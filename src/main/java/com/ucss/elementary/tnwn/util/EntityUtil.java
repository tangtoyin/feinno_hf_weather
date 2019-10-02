package com.ucss.elementary.tnwn.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ucss.elementary.tnwn.constant.tnwn.Status;
import com.ucss.elementary.tnwn.model.database.TUserInfoTemp;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.TnwnBaseResponse;
import com.ucss.elementary.tnwn.model.response.TnwnsBaseResponse;
import com.ucss.elementary.tnwn.model.tnwn.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019-9-6.
 */
public class EntityUtil
{
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static UserTnwnInfo TransUserInfo(CarryAroundInfo tUserInfoTemp){
        UserTnwnInfo userTnwnInfo=null;
        try{
            String ob = JSONObject.toJSONString(tUserInfoTemp);
            userTnwnInfo=(UserTnwnInfo)JSONObject.parseObject(ob, UserTnwnInfo.class);
            userTnwnInfo.setPhonenum(tUserInfoTemp.getServiceNum());
            userTnwnInfo.setLastoperators(tUserInfoTemp.getPortOutIdDesc());
            userTnwnInfo.setLastoperatorscode(tUserInfoTemp.getPortOutId());
            userTnwnInfo.setOperators(tUserInfoTemp.getPortInIdDesc());

            String mobile_type="01";
            if(tUserInfoTemp.getPortInIdDesc().indexOf("移动")>-1){
                mobile_type="01";
            }else if(tUserInfoTemp.getPortInIdDesc().indexOf("联")>-1){
                mobile_type="02";
            }else if(tUserInfoTemp.getPortInIdDesc().indexOf("电信")>-1){
                mobile_type="03";
            }
            userTnwnInfo.setOperatorscode(mobile_type);
            userTnwnInfo.setIschinammobile(tUserInfoTemp.getPortInIdDesc().indexOf("移动")>-1?"1":"0");
            userTnwnInfo.setRegioncode(tUserInfoTemp.getRegion());
            userTnwnInfo.setProvincecode(tUserInfoTemp.getProvince());

        }catch (Exception e){
            e.printStackTrace();
        }

        return userTnwnInfo;
    }

    public static UserTnwnInfo TransUserInfo(TUserInfoTemp tUserInfoTemp){
        UserTnwnInfo userTnwnInfo=null;
        try{
            String ob = JSONObject.toJSONString(tUserInfoTemp);
            userTnwnInfo=(UserTnwnInfo)JSONObject.parseObject(ob, UserTnwnInfo.class);
            userTnwnInfo.setPhonenum(tUserInfoTemp.getServicenum());
            userTnwnInfo.setLastoperators(tUserInfoTemp.getPortoutiddesc());
            userTnwnInfo.setLastoperatorscode(tUserInfoTemp.getPortoutid());
            userTnwnInfo.setOperators(tUserInfoTemp.getPortiniddesc());
           // userTnwnInfo.setOperatorscode(tUserInfoTemp.getPortinid());

            String mobile_type="01";
            if(tUserInfoTemp.getPortiniddesc().indexOf("移动")>-1){
                mobile_type="01";
            }else if(tUserInfoTemp.getPortiniddesc().indexOf("联")>-1){
                mobile_type="02";
            }else if(tUserInfoTemp.getPortiniddesc().indexOf("电信")>-1){
                mobile_type="03";
            }
            userTnwnInfo.setOperatorscode(mobile_type);
            userTnwnInfo.setIschinammobile(tUserInfoTemp.getPortiniddesc().indexOf("移动")>-1?"1":"0");
            userTnwnInfo.setRegioncode(tUserInfoTemp.getRegion());
            userTnwnInfo.setProvincecode(tUserInfoTemp.getProvince());

        }catch (Exception e){
            e.printStackTrace();
        }

        return userTnwnInfo;
    }


    public static List<UserTnwnInfo> TransUserInfos(List<TUserInfoTemp> list_tUserInfoTemp){

        List<UserTnwnInfo> list=new ArrayList<>();
        for(TUserInfoTemp tUserInfoTemp:list_tUserInfoTemp){

            String ob = JSONObject.toJSONString(tUserInfoTemp);
            UserTnwnInfo userTnwnInfo=(UserTnwnInfo)JSONObject.parseObject(ob, UserTnwnInfo.class);
            userTnwnInfo.setPhonenum(tUserInfoTemp.getServicenum());
            userTnwnInfo.setLastoperators(tUserInfoTemp.getPortoutiddesc());
            userTnwnInfo.setLastoperatorscode(tUserInfoTemp.getPortoutid());
            userTnwnInfo.setOperators(tUserInfoTemp.getPortiniddesc());
            //userTnwnInfo.setOperatorscode(tUserInfoTemp.getPortinid());

            String mobile_type="01";
            if(tUserInfoTemp.getPortiniddesc().indexOf("移动")>-1){
                mobile_type="01";
            }else if(tUserInfoTemp.getPortiniddesc().indexOf("联")>-1){
                mobile_type="02";
            }else if(tUserInfoTemp.getPortiniddesc().indexOf("电信")>-1){
                mobile_type="03";
            }
            userTnwnInfo.setOperatorscode(mobile_type);

            userTnwnInfo.setIschinammobile(tUserInfoTemp.getPortiniddesc().indexOf("移动")>-1?"1":"0");
            userTnwnInfo.setRegioncode(tUserInfoTemp.getRegion());
            userTnwnInfo.setProvincecode(tUserInfoTemp.getProvince());
            list.add(userTnwnInfo);
        }
        return list;
    }

   /* public static List<UserTnwnInfo> TransBatchUserInfos(BatchUserReInfo batchUserReInfo){
        List<UserTnwnInfo> list=new ArrayList<>();
        List<BatchCarryAroundInfo> l=batchUserReInfo.getBatchResult();
        for(BatchCarryAroundInfo batchCarryAroundInfo:l){
            CarryAroundInfo cai=batchCarryAroundInfo.getCarryAroundInfo();
            String ob = JSONObject.toJSONString(cai);
            UserTnwnInfo userTnwnInfo=(UserTnwnInfo)JSONObject.parseObject(ob, UserTnwnInfo.class);

            if(batchCarryAroundInfo.getResultCode().equals("000000")){
                userTnwnInfo.setPhonenum(cai.getServiceNum());
                userTnwnInfo.setLastoperators(cai.getPortOutIdDesc());
                userTnwnInfo.setLastoperatorscode(cai.getPortOutId());
                userTnwnInfo.setOperators(cai.getPortInIdDesc());
                userTnwnInfo.setOperatorscode(cai.getPortInId());
                userTnwnInfo.setIschinammobile(cai.getPortInIdDesc().indexOf("移动")>-1?"是":"否");
                userTnwnInfo.setRegioncode(cai.getRegion());
                userTnwnInfo.setProvincecode(cai.getProvince());
            }

            list.add(userTnwnInfo);
        }
        return list;
    }*/

    public static List<UserTnwnInfoRes> TransBatchUserInfos(BatchUserReInfo batchUserReInfo){
        List<UserTnwnInfoRes> list=new ArrayList<UserTnwnInfoRes>();
        List<BatchCarryAroundInfo> l=batchUserReInfo.getBatchResult();
        for(BatchCarryAroundInfo batchCarryAroundInfo:l){
            UserTnwnInfoRes res=new UserTnwnInfoRes();
            res.setResultcode(batchCarryAroundInfo.getResultCode());
            CarryAroundInfo cai=batchCarryAroundInfo.getCarryAroundInfo();
            String ob = JSONObject.toJSONString(cai);
            UserTnwnInfo re=(UserTnwnInfo)JSONObject.parseObject(ob, UserTnwnInfo.class);
            if(batchCarryAroundInfo.getResultCode().equals("000000")){
                re.setPhonenum(cai.getServiceNum());
                re.setLastoperators(cai.getPortOutIdDesc());
                re.setLastoperatorscode(cai.getPortOutId());
                re.setOperators(cai.getPortInIdDesc());
              //  re.setOperatorscode(cai.getPortInId());
                String mobile_type="01";
                if(cai.getPortInIdDesc().indexOf("移动")>-1){
                    mobile_type="01";
                }else if(cai.getPortInIdDesc().indexOf("联")>-1){
                    mobile_type="02";
                }else if(cai.getPortInIdDesc().indexOf("电信")>-1){
                    mobile_type="03";
                }
                re.setOperatorscode(mobile_type);
                re.setIschinammobile(cai.getPortInIdDesc().indexOf("移动")>-1?"1":"0");
                re.setRegioncode(cai.getRegion());
                re.setProvincecode(cai.getProvince());
            }
           // res.setUserTnwnInfo(userTnwnInfo);
            res.setResult(re);
            list.add(res);
        }
        return list;
    }



    /**
     * 查询符合的手机号码
     * @param str
     */
    public static List checkCellphone(String str){
        List<String> list=new ArrayList<String>();
        // 将给定的正则表达式编译到模式中
        Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([0-3]|[5-9]))|(19([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
       // Pattern pattern = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}$");
        //String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
        // 创建匹配给定输入与此模式的匹配器。
        Matcher matcher = pattern.matcher(str);
        //查找字符串中是否有符合的子字符串
        while(matcher.find()){
            //查找到符合的即输出
            list.add(matcher.group());
        }

        return list;
    }


    public static void main(String args[]){
        String str="[\"17338320004\",\"13429852099\",\"13233494455\"],";
        List l=checkCellphone(str);
        System.out.println(l.size());



        //String str="{\"serviceNum\": \"13429852098\",\"firstChannelId\": \"251\",\"secondChannelId\": \"104\",\"firstChannelName\": \"杭州致健网络科技有限公司\",\"secondChannelName\": \"杭州致健-英语趣配音\",\"chlGlobalCode\": \"2871515051200300020\"}";

    }


    /**
     * 根据url返回不同的错误类型
     * @return
     */
    public static Object doChange(String url,String code,String message){
        Object o=null;
        if(url.equals("/tnwn/UserInfo/detail")){
            o=new TnwnBaseResponse(code,null);
        }else if(url.equals("/tnwn/UserInfo/details")){
            o=new TnwnBaseResponse(code,null);
        }else if(url.equals("/tnwn/segmentArea/detail")){
            o=new NumberArea(code,null,null,null);
        }else{
            o=new BaseResponse(code,message);
        }
        return o;
    }

    public static CarryAroundInfo transCarryAround(TUserInfoTemp tUserInfoTemp){
        CarryAroundInfo carryAroundInfo=new CarryAroundInfo();
        carryAroundInfo.setServiceNum(tUserInfoTemp.getServicenum());
        carryAroundInfo.setState(tUserInfoTemp.getState());
        carryAroundInfo.setStateDesc(tUserInfoTemp.getStatedesc());
        carryAroundInfo.setNetId(tUserInfoTemp.getNetid());
        carryAroundInfo.setNetIdDesc(tUserInfoTemp.getNetiddesc());
        carryAroundInfo.setPortInId(tUserInfoTemp.getPortinid());
        carryAroundInfo.setPortInIdDesc(tUserInfoTemp.getPortiniddesc());
        carryAroundInfo.setPortOutId(tUserInfoTemp.getPortoutid());
        carryAroundInfo.setPortOutIdDesc(tUserInfoTemp.getPortoutiddesc());
        carryAroundInfo.setHomeNet(tUserInfoTemp.getHomenet());
        carryAroundInfo.setHomeNetDesc(tUserInfoTemp.getHomenetdesc());
        carryAroundInfo.setActiveTime(tUserInfoTemp.getActivetime());
        carryAroundInfo.setInactiveTime(null);
        carryAroundInfo.setServiceType(tUserInfoTemp.getServicetype());
        carryAroundInfo.setServiceTypeDesc(tUserInfoTemp.getServicetypedesc());
        carryAroundInfo.setRegion(tUserInfoTemp.getRegion());
        carryAroundInfo.setRegionName(tUserInfoTemp.getRegionname());
        carryAroundInfo.setProvince(tUserInfoTemp.getProvince());
        carryAroundInfo.setProvinceName(tUserInfoTemp.getProvincename());
       /* private String serviceNum;
        private String state;
        private String stateDesc;
        private String netId;
        private String netIdDesc;
        private String portInId;
        private String portInIdDesc;
        private String portOutId;
        private String portOutIdDesc;
        private String homeNet;
        private String homeNetDesc;
        private String activeTime;
        private String inactiveTime;
        private String serviceType;
        private String serviceTypeDesc;
        private String region;
        private String regionName;
        private String province;
        private String provinceName;*/

        return carryAroundInfo;
    }


}