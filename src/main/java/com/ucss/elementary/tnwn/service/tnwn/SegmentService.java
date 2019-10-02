package com.ucss.elementary.tnwn.service.tnwn;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        //101	核心平台

        //102	ESB
        //106	和工作
        //107   务工易

        //103   百事易
        //104   农情气象
        //105   田原生活汇

        List<UserTnwnInfoRes> l_res=new ArrayList<>();
        for(UserTnwnInfoRes userTnwnInfoRes:userTnwnInfoResList){
            UserTnwnInfo userTnwnInfo=userTnwnInfoRes.getResult();
            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andNumrangeEqualTo(userTnwnInfo.getPhonenum().substring(0,7));
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
            TBNumrange tbNumrange=null;
            if(list.size()==1){
                tbNumrange=list.get(0);
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
            //101	核心平台

            //102	ESB
            //106	和工作
            //107   务工易

           //103   百事易
           //104   农情气象
           //105   田原生活汇

        TBNumrangeExample example=new TBNumrangeExample();
        example.createCriteria().andNumrangeEqualTo(userTnwnInfo.getPhonenum().substring(0,7));
        List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
        TBNumrange tbNumrange=null;
        if(list.size()==1){
            tbNumrange=list.get(0);
        }

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
        }


        return userTnwnInfo;
    }




    /**
     * 携网转号接口区域过滤
     * @param
     * @return
     * @throws Exception
     */
    public boolean AreaFilterSearch(List<String> phone_list) throws Exception{
        boolean flat=true;

        if(env.getProperty("http.group.tnwn.provincewhite").equals("*"))return flat;

        //天津、海南、江西、湖北、
        Hashtable hash=new Hashtable();
        String[] provinces=env.getProperty("http.group.tnwn.provincewhite").split(",");
        for(int i=0;i<provinces.length;i++){
            hash.put(provinces[i],provinces[i]);
        }

        for(String phone_number:phone_list){
            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andNumrangeEqualTo(phone_number.substring(0,7));
            List<TBNumrange> list = tbNumrangeMapper.selectByExample(example);
            if(list.size()>0){
                TBNumrange tbNumrange=list.get(0);
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

        }


        return flat;
    }

}
