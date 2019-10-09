package com.ucss.elementary.tnwn.service.tnwn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucss.elementary.tnwn.constant.tnwn.Cache;
import com.ucss.elementary.tnwn.constant.tnwn.Status;
import com.ucss.elementary.tnwn.mapper.tnwn.*;
import com.ucss.elementary.tnwn.model.database.*;
import com.ucss.elementary.tnwn.model.tnwn.*;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019-9-5.
 */

@Service
public class SegmentService {

    private static final Logger log= LoggerFactory.getLogger(SegmentService.class);
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
    private TBLongareacodePlaMapper tbLongareacodePlaMapper;

    @Autowired
    private TBLongareacodeMapper tbLongareacodeMapper;

    @Autowired
    private TBLocationMapper tbLocationMapper;

    @Autowired
    private TBLocationPlaMapper tbLocationPlaMapper;

    /**
     * 号段区域统一查询接口
     * @param
     * @return
     * @throws Exception
     */
    public NumberArea NumberAreaDetail(String phonenumber, String platformcode) throws Exception{
        NumberArea numberArea=null;
        if((!platformcode.equals("103"))&&(!platformcode.equals("105"))&&(!platformcode.equals("106"))){
            platformcode="106";
        }
        final String key=String.format(env.getProperty("redis.segment.info.key"),phonenumber+"->"+platformcode);

        if (stringRedisTemplate.hasKey(key)){
            //TODO：key存在于缓存
            String value=stringRedisTemplate.opsForValue().get(key);
            numberArea=objectMapper.readValue(value,NumberArea.class);

        }else{
            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andNumrangeEqualTo(phonenumber.substring(0,7));
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
            TBNumrange tbNumrange=null;
            if(list.size()==1){
                tbNumrange=list.get(0);
                //TODO 根据平台名称查询区域编码
                TBLongareacodePlaExample tbLongareacodePlaExample=new TBLongareacodePlaExample();
                tbLongareacodePlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(tbNumrange.getCitycode());
                List<TBLongareacodePla> tbl_list = tbLongareacodePlaMapper.selectByExample(tbLongareacodePlaExample);
                numberArea=new NumberArea();
                if(tbl_list.size()==1){
                    numberArea.setResultcode(Status.success);
                    TBLongareacodePla tbLongareacodePla=tbl_list.get(0);
                    numberArea.setRegioncode(tbLongareacodePla.getPlatformareacode());
                    numberArea.setLongareacode(tbLongareacodePla.getAreacode());
                    TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                    tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbLongareacodePla.getAreacode());
                    List<TBLongareacode> tblc= tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                    if(tblc.size()==1){
                        TBLongareacode t=tblc.get(0);
                        numberArea.setRegion(t.getAreaname());
                    }
                    stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(numberArea),60*24, TimeUnit.MINUTES);

                }else{
                    numberArea.setResultcode(Status.noUserInfo);
                }

            }else{
                numberArea.setResultcode(Status.noUserInfo);
            }
        }
        return numberArea;
    }


    /**
     * 批量区域查询接口
     *
     */

    public List<UserTnwnInfoRes> AreaDetailSearch(List<UserTnwnInfoRes> userTnwnInfoResList, String platformcode) throws Exception{
        List<UserTnwnInfoRes> l=new ArrayList<>();

        if((!platformcode.equals("103"))&&(!platformcode.equals("105"))&&(!platformcode.equals("106"))){
            platformcode="106";
        }

        for(UserTnwnInfoRes userTnwnInfoRes:userTnwnInfoResList){
            UserTnwnInfo userTnwnInfo=userTnwnInfoRes.getResult();
            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andNumrangeEqualTo(userTnwnInfo.getPhonenum().substring(0,7));
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
            TBNumrange tbNumrange=null;
            if(list.size()==1){
                tbNumrange=list.get(0);
                //TODO 根据平台名称查询区域编码
                TBLongareacodePlaExample tbLongareacodePlaExample=new TBLongareacodePlaExample();
                tbLongareacodePlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(tbNumrange.getCitycode());
                List<TBLongareacodePla> tbl_list = tbLongareacodePlaMapper.selectByExample(tbLongareacodePlaExample);
                if(tbl_list.size()>=1){
                    TBLongareacodePla tbLongareacodePla=tbl_list.get(0);
                    userTnwnInfo.setRegioncode(tbLongareacodePla.getPlatformareacode());
                    TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                    tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbLongareacodePla.getAreacode());
                    List<TBLongareacode> tblc= tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                    if(tblc.size()==1){
                        TBLongareacode t=tblc.get(0);
                        userTnwnInfo.setRegionname(t.getAreaname());
                        String provcode=t.getProvcode();
                        userTnwnInfo.setProvincecode(provcode);
                        //TODO 根据省编码查省份

                        TBLocationExample tbLocationExample=new TBLocationExample();
                        tbLocationExample.createCriteria().andProvincecodeEqualTo(provcode).andParentidEqualTo(new BigDecimal(101));
                        List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                        if(ttt.size()==1){
                            TBLocation tbl=ttt.get(0);
                            userTnwnInfo.setProvincename(tbl.getLocationname());
                        }

                    }
                    // stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(numberArea),60*24, TimeUnit.MINUTES);

                }else{
                    // numberArea.setResultcode(Status.noUserInfo);
                }

            }else{
                // numberArea.setResultcode(Status.noUserInfo);
            }
            l.add(userTnwnInfoRes);
        }

        return l;

    }

    /**
     * 批量区域查询接口
     *
     */
    public List<UserTnwnInfoRes> AreaDetailSearchV1(List<UserTnwnInfoRes> userTnwnInfoResList, String platformcode) throws Exception{
        List<UserTnwnInfoRes> l_res=new ArrayList<>();
        for(UserTnwnInfoRes userTnwnInfoRes:userTnwnInfoResList){
            UserTnwnInfo userTnwnInfo=userTnwnInfoRes.getResult();
           /* TBNumrangeExample example=new TBNumrangeExample();
            System.out.println("userTnwnInfo.getPhonenum():"+userTnwnInfo.getPhonenum());
            example.createCriteria().andBeginnoLessThanOrEqualTo(userTnwnInfo.getPhonenum()).andEndnoGreaterThanOrEqualTo(userTnwnInfo.getPhonenum()).andIsvalidEqualTo((short) 1);
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);*/
            TBNumrange tb=null;
            TBNumrange tbNumrange=null;
            List<TBNumrange> numrangeList= Cache.hash_numranges.get(userTnwnInfo.getPhonenum().substring(0,5));
            if(numrangeList!=null&&numrangeList.size()>0){
                for(TBNumrange t:numrangeList){
                    Long beginno=Long.parseLong(t.getBeginno());
                    Long endno=Long.parseLong(t.getEndno());
                    Long nowno=Long.parseLong(userTnwnInfo.getPhonenum());
                    if(nowno>=beginno&&nowno<=endno){
                        tb=t;
                    }
                }
            }
            if(tb!=null){
                tbNumrange=tb;
                //TODO 根据平台名称查询区域编码
                //TODO 核心平台直接返回locationcode
                if(platformcode.equals("101")){
                   // String locationcode=tbNumrange.getLocationcode();
                    String locationcode=tbNumrange.getLocationcode()!=null?tbNumrange.getLocationcode():"0";
                    TBLocationExample tbLocationExample=new TBLocationExample();
                    tbLocationExample.createCriteria().andLocationcodeEqualTo(locationcode);
                    List<TBLocation> l=tbLocationMapper.selectByExample(tbLocationExample);
                    if(l.size()>0){
                        TBLocation tbLocation=l.get(0);
                        userTnwnInfo.setRegioncode(locationcode);
                        userTnwnInfo.setRegionname(tbLocation.getLocationname());
                        userTnwnInfo.setProvincecode(tbLocation.getProvincecode());
                        TBLocationExample tbe=new TBLocationExample();
                        tbe.createCriteria().andProvincecodeEqualTo(tbLocation.getProvincecode()).andParentidEqualTo(new BigDecimal(101));
                        List<TBLocation> ttt=tbLocationMapper.selectByExample(tbe);
                        if(ttt.size()>0){
                            TBLocation tbl=ttt.get(0);
                            userTnwnInfo.setProvincename(tbl.getLocationname());
                        }
                    }
                }else if(platformcode.equals("103")||platformcode.equals("104")||platformcode.equals("105")){
                    {
                       // String locationcode=tbNumrange.getLocationcode();
                        String locationcode=tbNumrange.getLocationcode()!=null?tbNumrange.getLocationcode():"0";
                        TBLocationExample tbLocationExample=new TBLocationExample();
                        tbLocationExample.createCriteria().andLocationcodeEqualTo(locationcode);
                        List<TBLocation> l=tbLocationMapper.selectByExample(tbLocationExample);
                        if(l.size()>0){
                            TBLocation tbLocation=l.get(0);
                            //userTnwnInfo.setRegioncode(locationcode);
                            userTnwnInfo.setRegionname(tbLocation.getLocationname());
                            userTnwnInfo.setProvincecode(tbLocation.getProvincecode());

                            TBLocationExample tbe=new TBLocationExample();
                            tbe.createCriteria().andProvincecodeEqualTo(tbLocation.getProvincecode()).andParentidEqualTo(new BigDecimal(101));
                            List<TBLocation> ttt=tbLocationMapper.selectByExample(tbe);
                            if(ttt.size()>0){
                                TBLocation tbl=ttt.get(0);
                                userTnwnInfo.setProvincename(tbl.getLocationname());
                            }

                            TBLocationPlaExample tbLocationPlaExample=new TBLocationPlaExample();
                            tbLocationPlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(locationcode);
                            List<TBLocationPla> tbLocationPlaList=tbLocationPlaMapper.selectByExample(tbLocationPlaExample);
                            if(tbLocationPlaList.size()>0){
                                TBLocationPla pla=tbLocationPlaList.get(0);
                                userTnwnInfo.setRegioncode(pla.getPlatformareacode());
                            }

                        }

                    }
                }else if(platformcode.equals("102")||platformcode.equals("106")||platformcode.equals("107")){ //TODO
                    String citycode=tbNumrange.getCitycode();
                    TBLongareacodePlaExample tbLongareacodePlaExample=new TBLongareacodePlaExample();
                    tbLongareacodePlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(citycode);
                    List<TBLongareacodePla> tbl_list = tbLongareacodePlaMapper.selectByExample(tbLongareacodePlaExample);
                    if(tbl_list.size()>0){
                        TBLongareacodePla tbLongareacodePla=tbl_list.get(0);
                        userTnwnInfo.setRegioncode(tbLongareacodePla.getPlatformareacode());
                        TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                        tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbLongareacodePla.getAreacode());
                        List<TBLongareacode> tblc= tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                        if(tblc.size()==1){
                            TBLongareacode t=tblc.get(0);
                            userTnwnInfo.setRegionname(t.getAreaname());
                            String provcode=t.getProvcode();
                            userTnwnInfo.setProvincecode(provcode);
                            //TODO 根据省编码查省份
                            TBLocationExample tbLocationExample=new TBLocationExample();
                            tbLocationExample.createCriteria().andProvincecodeEqualTo(provcode).andParentidEqualTo(new BigDecimal(101));
                            List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                            if(ttt.size()==1){
                                TBLocation tbl=ttt.get(0);
                                userTnwnInfo.setProvincename(tbl.getLocationname());
                            }

                        }

                    }
                }else if(platformcode.equals("108")||platformcode.equals("109")||platformcode.equals("110")||platformcode.equals("111")){
                            //TODO
                            String citycode=tbNumrange.getCitycode();
                            TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                            tbLongareacodeExample.createCriteria().andAreacodeEqualTo(citycode);
                            List<TBLongareacode> l=tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                            if(l.size()>0){
                                TBLongareacode tbLongareacode=l.get(0);
                                userTnwnInfo.setRegioncode(tbLongareacode.getAreacode());
                                userTnwnInfo.setRegionname(tbLongareacode.getAreaname());
                                userTnwnInfo.setProvincecode(tbLongareacode.getProvcode());

                                //TODO 根据省编码查省份
                                TBLocationExample tbLocationExample=new TBLocationExample();
                                tbLocationExample.createCriteria().andProvincecodeEqualTo(tbLongareacode.getProvcode()).andParentidEqualTo(new BigDecimal(101));
                                List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                                if(ttt.size()==1){
                                    TBLocation tbl=ttt.get(0);
                                    userTnwnInfo.setProvincename(tbl.getLocationname());
                                }
                        }
                }
               }
            l_res.add(userTnwnInfoRes);
        }

        return l_res;

    }


    /**
     * 区域查询接口
     * @param
     * @return
     * @throws Exception
     */
    public UserTnwnInfo AreaDetailSearch(UserTnwnInfo userTnwnInfo, String platformcode) throws Exception{

        if((!platformcode.equals("103"))&&(!platformcode.equals("105"))&&(!platformcode.equals("106"))){
            platformcode="106";
        }

            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andNumrangeEqualTo(userTnwnInfo.getPhonenum().substring(0,7));
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
            TBNumrange tbNumrange=null;
            if(list.size()==1){
                tbNumrange=list.get(0);
                //TODO 根据平台名称查询区域编码
                TBLongareacodePlaExample tbLongareacodePlaExample=new TBLongareacodePlaExample();
                tbLongareacodePlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(tbNumrange.getCitycode());
                List<TBLongareacodePla> tbl_list = tbLongareacodePlaMapper.selectByExample(tbLongareacodePlaExample);
                if(tbl_list.size()>=1){
                    TBLongareacodePla tbLongareacodePla=tbl_list.get(0);
                    userTnwnInfo.setRegioncode(tbLongareacodePla.getPlatformareacode());
                    TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                    tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbLongareacodePla.getAreacode());
                    List<TBLongareacode> tblc= tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                    if(tblc.size()==1){
                        TBLongareacode t=tblc.get(0);
                        userTnwnInfo.setRegionname(t.getAreaname());
                        String provcode=t.getProvcode();
                        userTnwnInfo.setProvincecode(provcode);
                        //TODO 根据省编码查省份

                        TBLocationExample tbLocationExample=new TBLocationExample();
                        tbLocationExample.createCriteria().andProvincecodeEqualTo(provcode).andParentidEqualTo(new BigDecimal(101));
                        List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                        if(ttt.size()==1){
                            TBLocation tbl=ttt.get(0);
                            userTnwnInfo.setProvincename(tbl.getLocationname());
                        }

                    }
                }else{
                }

            }else{
            }

        return userTnwnInfo;
    }

    /**
     * 区域查询接口
     * @param
     * @return
     * @throws Exception
     */
    public UserTnwnInfo AreaDetailSearchV1(UserTnwnInfo userTnwnInfo, String platformcode) throws Exception{
        TBNumrange tbNumrange=null;

        long start=System.currentTimeMillis();
       // TBNumrangeExample example=new TBNumrangeExample();
       // example.createCriteria().andNumrangeEqualTo(userTnwnInfo.getPhonenum().substring(0,7));
       // example.createCriteria().andBeginnoLessThanOrEqualTo(userTnwnInfo.getPhonenum()).andEndnoGreaterThanOrEqualTo(userTnwnInfo.getPhonenum()).andIsvalidEqualTo((short) 1);
       // List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);

        //TODO 从内存里取号段
        List<TBNumrange> numrangeList= Cache.hash_numranges.get(userTnwnInfo.getPhonenum().substring(0,5));
        if(numrangeList!=null&&numrangeList.size()>0){
            for(TBNumrange t:numrangeList){
                Long beginno=Long.parseLong(t.getBeginno());
                Long endno=Long.parseLong(t.getEndno());
                Long nowno=Long.parseLong(userTnwnInfo.getPhonenum());
                if(nowno>=beginno&&nowno<=endno){
                    tbNumrange=t;
                }
            }
       }
        long end=System.currentTimeMillis();
        log.info("查询号段表:"+(end-start)+"ms");



        if(tbNumrange==null)return userTnwnInfo;

        //TODO 核心平台直接返回locationcode
        if(platformcode.equals("101")){
           // String locationcode=tbNumrange.getLocationcode();
            String locationcode=tbNumrange.getLocationcode()!=null?tbNumrange.getLocationcode():"0";
            TBLocationExample tbLocationExample=new TBLocationExample();
            tbLocationExample.createCriteria().andLocationcodeEqualTo(locationcode);
            List<TBLocation> l=tbLocationMapper.selectByExample(tbLocationExample);
            if(l.size()>0){
                TBLocation tbLocation=l.get(0);
                //locationname
                userTnwnInfo.setRegioncode(locationcode);
                userTnwnInfo.setRegionname(tbLocation.getLocationname());
                userTnwnInfo.setProvincecode(tbLocation.getProvincecode());
                TBLocationExample tbe=new TBLocationExample();
                tbe.createCriteria().andProvincecodeEqualTo(tbLocation.getProvincecode()).andParentidEqualTo(new BigDecimal(101));
                List<TBLocation> ttt=tbLocationMapper.selectByExample(tbe);
                if(ttt.size()>0){
                    TBLocation tbl=ttt.get(0);
                    userTnwnInfo.setProvincename(tbl.getLocationname());
                }
            }

        }else if(platformcode.equals("103")||platformcode.equals("104")||platformcode.equals("105")){
                String locationcode=tbNumrange.getLocationcode()!=null?tbNumrange.getLocationcode():"0";
                TBLocationExample tbLocationExample=new TBLocationExample();
                tbLocationExample.createCriteria().andLocationcodeEqualTo(locationcode);
                List<TBLocation> l=tbLocationMapper.selectByExample(tbLocationExample);
                if(l.size()>0){
                    TBLocation tbLocation=l.get(0);
                   //userTnwnInfo.setRegioncode(locationcode);
                    userTnwnInfo.setRegionname(tbLocation.getLocationname());
                    userTnwnInfo.setProvincecode(tbLocation.getProvincecode());

                    TBLocationExample tbe=new TBLocationExample();
                    tbe.createCriteria().andProvincecodeEqualTo(tbLocation.getProvincecode()).andParentidEqualTo(new BigDecimal(101));
                    List<TBLocation> ttt=tbLocationMapper.selectByExample(tbe);
                    if(ttt.size()>0){
                        TBLocation tbl=ttt.get(0);
                        userTnwnInfo.setProvincename(tbl.getLocationname());
                    }

                    TBLocationPlaExample tbLocationPlaExample=new TBLocationPlaExample();
                    tbLocationPlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(locationcode);
                    List<TBLocationPla> tbLocationPlaList=tbLocationPlaMapper.selectByExample(tbLocationPlaExample);
                    if(tbLocationPlaList.size()>0){
                        TBLocationPla pla=tbLocationPlaList.get(0);
                        userTnwnInfo.setRegioncode(pla.getPlatformareacode());
                    }
                }
        }else if(platformcode.equals("102")||platformcode.equals("106")||platformcode.equals("107")){ //TODO
            String citycode=tbNumrange.getCitycode();
            TBLongareacodePlaExample tbLongareacodePlaExample=new TBLongareacodePlaExample();
            tbLongareacodePlaExample.createCriteria().andPlatformcodeEqualTo(platformcode).andAreacodeEqualTo(citycode);
            List<TBLongareacodePla> tbl_list = tbLongareacodePlaMapper.selectByExample(tbLongareacodePlaExample);
            if(tbl_list.size()>0){
                TBLongareacodePla tbLongareacodePla=tbl_list.get(0);
                userTnwnInfo.setRegioncode(tbLongareacodePla.getPlatformareacode());

                TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbLongareacodePla.getAreacode());
                List<TBLongareacode> tblc= tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                if(tblc.size()==1){
                    TBLongareacode t=tblc.get(0);
                    userTnwnInfo.setRegionname(t.getAreaname());
                    String provcode=t.getProvcode();
                    userTnwnInfo.setProvincecode(provcode);
                    //TODO 根据省编码查省份
                    TBLocationExample tbLocationExample=new TBLocationExample();
                    tbLocationExample.createCriteria().andProvincecodeEqualTo(provcode).andParentidEqualTo(new BigDecimal(101));
                    List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                    if(ttt.size()==1){
                        TBLocation tbl=ttt.get(0);
                        userTnwnInfo.setProvincename(tbl.getLocationname());
                    }

                }

            }
        }else if(platformcode.equals("108")||platformcode.equals("109")||platformcode.equals("110")||platformcode.equals("111")){
            //TODO
            String citycode=tbNumrange.getCitycode();
            TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
            tbLongareacodeExample.createCriteria().andAreacodeEqualTo(citycode);
            List<TBLongareacode> l=tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
            if(l.size()>0){
                TBLongareacode tbLongareacode=l.get(0);
                userTnwnInfo.setRegioncode(tbLongareacode.getAreacode());
                userTnwnInfo.setRegionname(tbLongareacode.getAreaname());
                userTnwnInfo.setProvincecode(tbLongareacode.getProvcode());

                //TODO 根据省编码查省份
                TBLocationExample tbLocationExample=new TBLocationExample();
                tbLocationExample.createCriteria().andProvincecodeEqualTo(tbLongareacode.getProvcode()).andParentidEqualTo(new BigDecimal(101));
                List<TBLocation> ttt=tbLocationMapper.selectByExample(tbLocationExample);
                if(ttt.size()==1){
                    TBLocation tbl=ttt.get(0);
                    userTnwnInfo.setProvincename(tbl.getLocationname());
                }
            }
        }

        long end_=System.currentTimeMillis();
        log.info("区域查询总共所需时间:"+(end_-end)+"ms");


        return userTnwnInfo;
    }




    /**
     * 携网转号接口区域返回区域内的手机号码
     * @param
     * @return
     * @throws Exception
     */
    public  List<String> AreaFilterSearch(List<String> phone_list) throws Exception{
        List<String> list=new ArrayList<String>();

        //15320189127
        boolean flat=true;
        if(env.getProperty("http.group.tnwn.provincewhite").equals("*"))return phone_list;

        //天津、海南、江西、湖北、
        Hashtable hash=new Hashtable();
        String[] provinces=env.getProperty("http.group.tnwn.provincewhite").split(",");
        for(int i=0;i<provinces.length;i++){
            hash.put(provinces[i],provinces[i]);
        }

        TBNumrange tbNumrange=null;
        for(String phone_number:phone_list){
            List<TBNumrange> numrangeList= Cache.hash_numranges.get(phone_number.substring(0,5));
            if(numrangeList!=null&&numrangeList.size()>0){
                for(TBNumrange t:numrangeList){
                    Long beginno=Long.parseLong(t.getBeginno());
                    Long endno=Long.parseLong(t.getEndno());
                    Long nowno=Long.parseLong(phone_number);
                    if(nowno>=beginno&&nowno<=endno){
                        tbNumrange=t;
                    }
                }
            }

            TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
            tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbNumrange.getCitycode());
            List<TBLongareacode> tbl_list = tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
            if(tbl_list.size()>=1){
                TBLongareacode tbLongareacode=tbl_list.get(0);
                String provcode=tbLongareacode.getProvcode();
                if(!hash.containsKey(provcode)){
                    flat=false;
                }
            }
        }

        return list;
    }

    /**
     * 携网转号接口区域过滤单条
     * @param
     * @return
     * @throws Exception
     */
    public boolean AreaFilterSearchSingle(String phone) throws Exception{
        boolean flat=true;

        if(env.getProperty("http.group.tnwn.provincewhite").equals("*"))return flat;

        //天津、海南、江西、湖北、
        Hashtable hash=new Hashtable();
        String[] provinces=env.getProperty("http.group.tnwn.provincewhite").split(",");
        for(int i=0;i<provinces.length;i++){
            hash.put(provinces[i],provinces[i]);
        }
            TBNumrange tbNumrange=null;
            List<TBNumrange> numrangeList= Cache.hash_numranges.get(phone.substring(0,5));
            if(numrangeList!=null&&numrangeList.size()>0){
                for(TBNumrange t:numrangeList){
                    Long beginno=Long.parseLong(t.getBeginno());
                    Long endno=Long.parseLong(t.getEndno());
                    Long nowno=Long.parseLong(phone);
                    if(nowno>=beginno&&nowno<=endno){
                        tbNumrange=t;
                    }
                }
            }

            if(tbNumrange!=null){
                TBLongareacodeExample tbLongareacodeExample=new TBLongareacodeExample();
                tbLongareacodeExample.createCriteria().andAreacodeEqualTo(tbNumrange.getCitycode());
                List<TBLongareacode> tbl_list = tbLongareacodeMapper.selectByExample(tbLongareacodeExample);
                if(tbl_list.size()>=1){
                    TBLongareacode tbLongareacode=tbl_list.get(0);
                    String provcode=tbLongareacode.getProvcode();
                    if(!hash.containsKey(provcode)){
                        flat=false;
                    }
                }
            }

        return flat;
    }

}
