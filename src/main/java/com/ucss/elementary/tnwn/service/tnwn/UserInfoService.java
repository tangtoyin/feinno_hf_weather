package com.ucss.elementary.tnwn.service.tnwn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucss.elementary.tnwn.constant.tnwn.Cache;
import com.ucss.elementary.tnwn.mapper.tnwn.TBNumrangeMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TDUserMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TUserInfoTempMapper;
import com.ucss.elementary.tnwn.model.database.*;
import com.ucss.elementary.tnwn.model.tnwn.*;
import com.ucss.elementary.tnwn.util.EntityUtil;
import com.ucss.elementary.tnwn.util.HttpClientHelper;
import com.ucss.elementary.tnwn.util.TQ24SolarTerms;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019-9-5.
 */

@Service
public class UserInfoService {

    private static final Logger log= LoggerFactory.getLogger(UserInfoService.class);
    @Autowired
    private Environment env;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TDUserMapper tdUserMapper;

    @Autowired
    private TUserInfoTempMapper tUserInfoTempMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TBNumrangeMapper tbNumrangeMapper;

    @Autowired
    SegmentService segmentService;

    /**
     * 用户详情
     * @param
     * @return
     * @throws Exception
     */
    public SingleUserReInfo getUserInfoV1(String phonenumber, String platformcode,String OUTERIFCODE,String OUTERIFRESULT) throws Exception{
        {

            //TODO：先查询缓存，再查数据库
            final String key=String.format(env.getProperty("redis.user.info.key"),phonenumber);
            //sb02:user:info:key:%s
            SingleUserReInfo singleUserReInfo = null;
            if (stringRedisTemplate.hasKey(key)){
                //TODO：key存在于缓存
                String value=stringRedisTemplate.opsForValue().get(key);
                singleUserReInfo=objectMapper.readValue(value,SingleUserReInfo.class);

            }else{
                //TODO 先判断区域,不在白名单省份内的手机号码不请求接口
                boolean flat=segmentService.AreaFilterSearchSingle(phonenumber);

                log.info("是否白名单省内:"+flat);
                if(flat){
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("serviceNum", phonenumber);
                    resultMap.put("firstChannelId", env.getProperty("http.group.tnwn.firstchannelid"));
                    resultMap.put("secondChannelId", env.getProperty("http.group.tnwn.secondchannelid"));
                    resultMap.put("firstChannelName",  "杭州致健网络科技有限公司");
                    resultMap.put("secondChannelName", "杭州致健-英语趣配音");
                    resultMap.put("chlGlobalCode", env.getProperty("http.group.tnwn.chlglobalcode"));
                    String url="http://"+env.getProperty("http.group.tnwn.ip")+":"+env.getProperty("http.group.tnwn.port")+env.getProperty("http.group.tnwn.single.cai.url");
                    String json=HttpClientHelper.HttpPostWithJson(url,JSON.toJSONString(resultMap),"Basic "+env.getProperty("http.group.tnwn.auth"));
                    //System.out.println(json);
                    log.info(json);
                    singleUserReInfo = new JSONObject().parseObject(json, SingleUserReInfo.class);
                    singleUserReInfo.setOUTERIFCODE(singleUserReInfo.getResultCode());
                    singleUserReInfo.setOUTERIFRESULT(json);
                    singleUserReInfo.setURL(url+""+resultMap.toString());
                }

               if(singleUserReInfo==null||!singleUserReInfo.getResultCode().equals("000000")){
                    //TODO：如果数据库里没有查询到，直接查询号段表判断
                   TBNumrange tbNumrange=null;
                   //TODO 从内存里取号段
                   List<TBNumrange> numrangeList= Cache.hash_numranges.get(phonenumber.substring(0,5));
                   if(numrangeList!=null&&numrangeList.size()>0){
                       for(TBNumrange t:numrangeList){
                           Long beginno=Long.parseLong(t.getBeginno());
                           Long endno=Long.parseLong(t.getEndno());
                           Long nowno=Long.parseLong(phonenumber);
                           if(nowno>=beginno&&nowno<=endno){
                               tbNumrange=t;
                           }
                       }
                   }
                   if(tbNumrange!=null){
                       singleUserReInfo=new SingleUserReInfo();
                       singleUserReInfo.setSuccess("true");
                       singleUserReInfo.setResultCode("000000");
                       singleUserReInfo.setResultMessage("操作成功");
                       CarryAroundInfo carryAroundInfo=new CarryAroundInfo();
                       carryAroundInfo.setServiceNum(phonenumber);
                       carryAroundInfo.setPortInIdDesc(tbNumrange.getServicername());
                       carryAroundInfo.setNetId(tbNumrange.getServicer());
                       carryAroundInfo.setNetIdDesc(tbNumrange.getServicername());
                       singleUserReInfo.setCarryAroundInfo(carryAroundInfo);
                       log.info("号段表查询netid:"+carryAroundInfo.getNetId());
                   }
                }else {
                    if(singleUserReInfo.getResult()!=null){
                        CarryAroundInfo carryAroundInfo= new JSONObject().parseObject(singleUserReInfo.getResult(), CarryAroundInfo.class);
                        singleUserReInfo.setCarryAroundInfo(carryAroundInfo);
                        log.info("接口返回:netid"+carryAroundInfo.getNetId());
                    }
                }

                //TODO redis月底过期
                stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(singleUserReInfo), TQ24SolarTerms.getLastDayByMin(), TimeUnit.MINUTES);
            }
            log.info("...."+OUTERIFRESULT);
            //TODO：发送消息
            if(singleUserReInfo!=null){
               // rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                //UserRegisterMessage message=new UserRegisterMessage(user,url+params);
               // Message msg= MessageBuilder.withBody(objectMapper.writeValueAsBytes(user)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
               // rabbitTemplate.send(env.getProperty("rabbitmq.user.register.exchange.name"),env.getProperty("rabbitmq.user.register.routing.key.name"),msg);
            }
            return singleUserReInfo;
        }
    }

    /**
     * 用户详情
     * @param
     * @return
     * @throws Exception
     */
    public SingleUserReInfo getUserInfoV1Temp(String phonenumber, String platformcode,String code,String result) throws Exception{
        //TODO：先查询缓存，再查数据库
        final String key=String.format(env.getProperty("redis.user.info.key"),phonenumber);
        TUserInfoTemp user = null;
        SingleUserReInfo singleUserReInfo=null;
        if (stringRedisTemplate.hasKey(key)){
            //TODO：key存在于缓存
            String value=stringRedisTemplate.opsForValue().get(key);
            singleUserReInfo=objectMapper.readValue(value,SingleUserReInfo.class);
        }else{
            //TODO：key不存在于缓存->查数据库并存入缓存
            //Long expire= RandomUtils.nextLong(10,30);
            TUserInfoTempExample t=new TUserInfoTempExample();
            t.createCriteria().andServicenumEqualTo(phonenumber);
            List<TUserInfoTemp> list=tUserInfoTempMapper.selectByExample(t);
            if (list.size()>0){
                user=list.get(0);
                singleUserReInfo=new SingleUserReInfo();
                singleUserReInfo.setSuccess("true");
                singleUserReInfo.setResultCode("000000");
                singleUserReInfo.setResultMessage("操作成功");
               // CarryAroundInfo carryAroundInfo=new CarryAroundInfo();
               // BeanUtils.copyProperties(carryAroundInfo,user);
                CarryAroundInfo carryAroundInfo= EntityUtil.transCarryAround(user);
                singleUserReInfo.setCarryAroundInfo(carryAroundInfo);
                stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(singleUserReInfo),10, TimeUnit.MINUTES);
            }else{
                //TODO：如果数据库里没有查询到，直接查询号段表判断
                TBNumrangeExample example=new TBNumrangeExample();
               // example.createCriteria().andNumrangeEqualTo(phonenumber.substring(0,7));
                example.createCriteria().andBeginnoLessThanOrEqualTo(phonenumber).andEndnoGreaterThanOrEqualTo(phonenumber).andIsvalidEqualTo((short) 1);
                List<TBNumrange> tbNumranges=tbNumrangeMapper.selectByExample(example);
                if(tbNumranges.size()>0){
                    TBNumrange tbNumrange=tbNumranges.get(0);
                    singleUserReInfo=new SingleUserReInfo();
                    singleUserReInfo.setSuccess("true");
                    singleUserReInfo.setResultCode("000000");
                    singleUserReInfo.setResultMessage("操作成功");
                    CarryAroundInfo carryAroundInfo=new CarryAroundInfo();
                    carryAroundInfo.setServiceNum(phonenumber);
                    carryAroundInfo.setPortInIdDesc(tbNumrange.getServicername());
                    carryAroundInfo.setNetId(tbNumrange.getServicer());
                    carryAroundInfo.setNetIdDesc(tbNumrange.getServicername());
                    log.info(carryAroundInfo.getNetId()+"-->"+carryAroundInfo.getNetIdDesc());
                    singleUserReInfo.setCarryAroundInfo(carryAroundInfo);
                    stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(singleUserReInfo),10, TimeUnit.MINUTES);
                }
            }
        }

        code="123";
        result="456";
        singleUserReInfo.setOUTERIFCODE("12333");
        singleUserReInfo.setOUTERIFRESULT("2222");
        return singleUserReInfo;
    }



    /**
     * 用户详情--批量不考虑缓存，直接把所有号码送给接口
     * @param
     * @return
     * @throws Exception
     */
    public BatchUserReInfo getUserInfoV2(List<String> list_phone, String platformcode) throws Exception{
        Long start=System.currentTimeMillis();
        BatchUserReInfo batchUserReInfo=null;
        if(list_phone==null||list_phone.size()==0)return batchUserReInfo;
        Map<String, Object> resultMap = new HashMap<>();
        String [] array=new String[list_phone.size()];
        for(int i=0;i<list_phone.size();i++){
            array[i]=list_phone.get(i);
        }



        resultMap.put("serviceNumBatch", array);
        resultMap.put("firstChannelId", env.getProperty("http.group.tnwn.firstchannelid"));
        resultMap.put("secondChannelId", env.getProperty("http.group.tnwn.secondchannelid"));
        resultMap.put("firstChannelName",  "杭州致健网络科技有限公司");
        resultMap.put("secondChannelName", "杭州致健-英语趣配音");
        resultMap.put("chlGlobalCode", env.getProperty("http.group.tnwn.chlglobalcode"));
        String url="http://"+env.getProperty("http.group.tnwn.ip")+":"+env.getProperty("http.group.tnwn.port")+env.getProperty("http.group.tnwn.batch.cai.url");
        String json=HttpClientHelper.HttpPostWithJson(url,JSON.toJSONString(resultMap),"Basic "+env.getProperty("http.group.tnwn.auth"));
        batchUserReInfo = new JSONObject().parseObject(json, BatchUserReInfo.class);
        List<BatchCarryAroundInfo> list=batchUserReInfo.getBatchResult();
        if(list!=null&&list.size()>0){
            for(BatchCarryAroundInfo batchCarryAroundInfo:list){
                CarryAroundInfo carryAroundInfo = new JSONObject().parseObject(batchCarryAroundInfo.getResult(), CarryAroundInfo.class);
                batchCarryAroundInfo.setCarryAroundInfo(carryAroundInfo);
            }
        }

        //TODO 最后把从接口里未获取到携转信息的号码取出来重新赋值
        if(list!=null&&list.size()>0){
            for(BatchCarryAroundInfo batchCarryAroundInfo:list){
                if(!batchCarryAroundInfo.getResultCode().equals("000000")){
                    {
                        TBNumrange tbNumrange=null;
                        //TODO 从内存里取号段
                        String str=batchCarryAroundInfo.getCarryAroundInfo().getServiceNum();
                        List<TBNumrange> numrangeList= Cache.hash_numranges.get(str.substring(0,5));
                        if(numrangeList!=null&&numrangeList.size()>0){
                            for(TBNumrange t:numrangeList){
                                Long beginno=Long.parseLong(t.getBeginno());
                                Long endno=Long.parseLong(t.getEndno());
                                Long nowno=Long.parseLong(str);
                                if(nowno>=beginno&&nowno<=endno){
                                    tbNumrange=t;
                                }
                            }
                        }
                        if(tbNumrange!=null){
                            batchCarryAroundInfo.setSuccess("true");
                            batchCarryAroundInfo.setResultCode("000000");
                            batchCarryAroundInfo.setResultMessage("操作成功");
                            batchCarryAroundInfo.getCarryAroundInfo().setPortInIdDesc(tbNumrange.getServicername());
                            batchCarryAroundInfo.getCarryAroundInfo().setServiceNum(str);
                            batchCarryAroundInfo.getCarryAroundInfo().setNetId(tbNumrange.getServicer());
                            batchCarryAroundInfo.getCarryAroundInfo().setNetIdDesc(tbNumrange.getServicername());
                        }else{
                            batchCarryAroundInfo.setSuccess("false");
                            batchCarryAroundInfo.setResultCode("100001");
                            batchCarryAroundInfo.setResultMessage("查询失败");
                            batchCarryAroundInfo.getCarryAroundInfo().setServiceNum(str);
                        }
                    }
                }
            }
        }

        Long end=System.currentTimeMillis();
        long s=end-start;
        log.info("不使用缓存所用时间为:"+s+"ms");
        return batchUserReInfo;
    }


    /**
     * 用户详情--批量不考虑缓存，直接把所有号码送给接口
     * @param
     * @return
     * @throws Exception
     */
    public BatchUserReInfo getUserInfoV2Temp(List<String> list_phone, String platformcode) throws Exception{
        Long start=System.currentTimeMillis();

        //临时存储没有在接口里查询到信息的号码
        List<String> no_info_list=new ArrayList<String>();

        BatchUserReInfo batchUserReInfo=new BatchUserReInfo();
        if(list_phone==null||list_phone.size()==0)return batchUserReInfo;

        TUserInfoTempExample t=new TUserInfoTempExample();
        t.createCriteria().andServicenumIn(list_phone);
        List<TUserInfoTemp> list=tUserInfoTempMapper.selectByExample(t);


        //把接口里没有查询到的号码放在临时集合中
        for(String str:list_phone){
            boolean flat=false;
            for(TUserInfoTemp tUserInfoTemp:list){
                if(str.equals(tUserInfoTemp.getServicenum())){
                    flat=true;
                }
            }
            if(!flat)no_info_list.add(str);
        }



        batchUserReInfo.setBatchuccess("true");
        batchUserReInfo.setBatchResultMessage("操作成功");
        batchUserReInfo.setBatchResultCode("111111");
        batchUserReInfo.setBatchCount(list_phone.size()+"");
        List<BatchCarryAroundInfo> batchResult=new ArrayList<BatchCarryAroundInfo>();

        //TODO 添加从接口查询出来的list
        for(TUserInfoTemp tUserInfoTemp:list){
            BatchCarryAroundInfo bcai=new BatchCarryAroundInfo();
            CarryAroundInfo cai=new CarryAroundInfo();
            bcai.setSuccess("true");
            bcai.setResultCode("000000");
            bcai.setResultMessage("操作成功");
            CarryAroundInfo carryAroundInfo= EntityUtil.transCarryAround(tUserInfoTemp);
            bcai.setCarryAroundInfo(carryAroundInfo);
            batchResult.add(bcai);
        }
        //TODO 添加从数据库查询出来的list
        for(String str:no_info_list){
            TBNumrangeExample example=new TBNumrangeExample();
           // example.createCriteria().andNumrangeEqualTo(str.substring(0,7));
            example.createCriteria().andBeginnoLessThanOrEqualTo(str).andEndnoGreaterThanOrEqualTo(str).andIsvalidEqualTo((short) 1);
            List<TBNumrange> tbNumranges=tbNumrangeMapper.selectByExample(example);
            BatchCarryAroundInfo bcai=new BatchCarryAroundInfo();
            CarryAroundInfo cai=new CarryAroundInfo();
            if(tbNumranges.size()>0){
                TBNumrange tbNumrange=tbNumranges.get(0);
                bcai.setSuccess("true");
                bcai.setResultCode("000000");
                bcai.setResultMessage("操作成功");
                cai.setPortInIdDesc(tbNumrange.getServicername());
                cai.setServiceNum(str);
                bcai.setCarryAroundInfo(cai);
            }else{
                bcai.setSuccess("false");
                bcai.setResultCode("100001");
                bcai.setResultMessage("查询失败");
                cai.setServiceNum(str);
                bcai.setCarryAroundInfo(cai);
            }
            batchResult.add(bcai);
        }

        batchUserReInfo.setBatchResult(batchResult);
        Long end=System.currentTimeMillis();
        long s=end-start;
        log.info("批量查询时间:"+s+"ms");
        return batchUserReInfo;
    }

    /**
     * 用户详情--批量
     * @param
     * @return
     * @throws Exception
     */
    public List<TUserInfoTemp> getUserInfoV3(List<String> list_phone,String platformcode) throws Exception{
        List<TUserInfoTemp> list_user=new ArrayList<TUserInfoTemp>();
        for(String phonenumber:list_phone){
            //TODO：先查询缓存，再查数据库
            final String key=String.format(env.getProperty("redis.user.info.key"),phonenumber);
            //sb02:user:info:key:%s
            TUserInfoTemp user = null;
            if (stringRedisTemplate.hasKey(key)){
                //TODO：key存在于缓存
                String value=stringRedisTemplate.opsForValue().get(key);
                user=objectMapper.readValue(value,TUserInfoTemp.class);
            }else{
                //TODO：key不存在于缓存->查数据库并存入缓存
                TUserInfoTempExample t=new TUserInfoTempExample();
                t.createCriteria().andServicenumEqualTo(phonenumber);
                List<TUserInfoTemp> list=tUserInfoTempMapper.selectByExample(t);
                if (list.size()>0){
                    user=list.get(0);
                    stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(user),20, TimeUnit.MINUTES);
                }
            }
            if(user!=null)list_user.add(user);
        }
        return list_user;
    }

    /**
     * 用户轨迹详情查询
     * @param
     * @return
     * @throws Exception
     */
    public BatchTrajectoryInfo gettrajectory(String phonenumber, String platformcode) throws Exception{
        {
            //TODO：先查询缓存，再查数据库
            final String key=String.format(env.getProperty("redis.user.info.key"),phonenumber);
            //sb02:user:info:key:%s
            SingleUserReInfo singleUserReInfo = null;
            BatchTrajectoryInfo batchTrajectoryInfo=null;
                //TODO：key不存在于缓存->查数据库并存入缓存
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("serviceNum", phonenumber);
                resultMap.put("firstChannelId", env.getProperty("http.group.tnwn.firstchannelid"));
                resultMap.put("secondChannelId", env.getProperty("http.group.tnwn.secondchannelid"));
                resultMap.put("firstChannelName",  "杭州致健网络科技有限公司");
                resultMap.put("secondChannelName", "杭州致健-英语趣配音");
                resultMap.put("chlGlobalCode", env.getProperty("http.group.tnwn.chlglobalcode"));
                String url="http://"+env.getProperty("http.group.tnwn.ip")+":"+env.getProperty("http.group.tnwn.port")+env.getProperty("http.group.tnwn.trajectory.url");
                String json=HttpClientHelper.HttpPostWithJson(url,JSON.toJSONString(resultMap),"Basic "+env.getProperty("http.group.tnwn.auth"));
                System.out.println(json);
                batchTrajectoryInfo=new JSONObject().parseObject(json, BatchTrajectoryInfo.class);
                if(batchTrajectoryInfo!=null){
                    if(batchTrajectoryInfo.getResult()!=null){
                        TrajectoryInfo trajectoryInfo=new JSONObject().parseObject(batchTrajectoryInfo.getResult(), TrajectoryInfo.class);
                        batchTrajectoryInfo.setResult(null);
                        batchTrajectoryInfo.setTrajectoryInfo(trajectoryInfo);
                    }
                }

               /* singleUserReInfo = new JSONObject().parseObject(json, SingleUserReInfo.class);
                if (singleUserReInfo!=null){
                    if(singleUserReInfo.getResult()!=null){
                        CarryAroundInfo carryAroundInfo= new JSONObject().parseObject(singleUserReInfo.getResult(), CarryAroundInfo.class);
                        singleUserReInfo.setCarryAroundInfo(carryAroundInfo);
                    }
                    //TODO redis月底过期
                    stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(singleUserReInfo), TQ24SolarTerms.getLastDayByMin(), TimeUnit.MINUTES);
                }*/


            return batchTrajectoryInfo;
        }
    }

    /**
     * 日志记录相关
     * @param
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void  handleLog(PhoneEntity phone) throws Exception{
       // Message message=MessageBuilder.withBody(objectMapper.writeValueAsBytes(phone)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
       // rabbitTemplate.send(env.getProperty("rabbitmq.user.tnwn.exchange.name"),env.getProperty("rabbitmq.user.tnwn.routing.key.name"),message);
    }

    /**
     * 号码根据省市进行拦截
     * @param
     * @return
     * @throws Exception
     */
    public boolean interceptProvince(List<String> list_phone) throws Exception{
        boolean flat=true;



        return flat;
    }


}
