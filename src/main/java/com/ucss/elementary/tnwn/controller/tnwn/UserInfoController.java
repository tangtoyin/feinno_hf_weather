package com.ucss.elementary.tnwn.controller.tnwn;

/**
 * Created by Administrator on 2019-9-5.
 */


import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.tnwn.constant.tnwn.Status;
import com.ucss.elementary.tnwn.model.database.TUserInfoTemp;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.TnwnBaseResponse;
import com.ucss.elementary.tnwn.model.response.TnwnsBaseResponse;
import com.ucss.elementary.tnwn.model.tnwn.*;
import com.ucss.elementary.tnwn.service.tnwn.LogService;
import com.ucss.elementary.tnwn.service.tnwn.SegmentService;
import com.ucss.elementary.tnwn.service.tnwn.UserInfoService;
import com.ucss.elementary.tnwn.util.EntityUtil;
import com.ucss.elementary.tnwn.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author Smile
 */
@RestController
@RequestMapping("/tnwn/UserInfo")
@Api(description = "协号转网信息查询")

public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SegmentService segmentService;

    @Autowired
    LogService logService;

    @Autowired
    private Environment env;
    /**
     * 获取用户携网转号详情单一查询
     *
     * @return
     */

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    TnwnBaseResponse getUserInfoV1(@RequestParam(value = "PARAM") String param, HttpServletRequest req, HttpServletResponse res) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        TnwnBaseResponse response = new TnwnBaseResponse();
        // TODO 存放外部编码，返回
        SingleUserReInfo singleUserReInfo=null;
        Exception ex=null;
        String OUTERIFCODE="";
        String OUTERIFRESULT="";
        String phonenumber = jsonObject.get("phonenum").toString();
        String platformcode = jsonObject.get("platformcode").toString();
        try {
            long start=System.currentTimeMillis();
            singleUserReInfo=userInfoService.getUserInfoV1(phonenumber, platformcode,OUTERIFCODE,OUTERIFRESULT);
            long end=System.currentTimeMillis();
            logger.info("接口总共所需时间:"+(end-start));
            if (singleUserReInfo == null) {
                response.setResultcode(Status.noUserInfo);
                response.setResult(null);
            } else {
                if(singleUserReInfo.getCarryAroundInfo()!=null){
                    UserTnwnInfo userTnwnInfo=EntityUtil.TransUserInfo(singleUserReInfo.getCarryAroundInfo());
                    userTnwnInfo=segmentService.AreaDetailSearchV1(userTnwnInfo,platformcode);
                    response.setResult(userTnwnInfo);
                }else{
                    response.setResult(null);
                }
                response.setResultcode(singleUserReInfo.getResultCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            ex=e;
            response = new TnwnBaseResponse(Status.error,null);
            logger.info("获取用户携转信息异常",e);
        }finally {
            try {
                logger.info("OUTERIFCODE1:"+singleUserReInfo.getOUTERIFCODE());
                logger.info("OUTERIFRESULT1:"+singleUserReInfo.getOUTERIFRESULT());
                logService.insertLog(req, phonenumber, platformcode, response, ex , singleUserReInfo.getOUTERIFCODE(),singleUserReInfo.getOUTERIFRESULT(),singleUserReInfo.getURL(),"单号码携转信息查询");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }


    /**
     * 获取用户携网转号详情批量查询
     *
     * @return
     */
    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    TnwnsBaseResponse getUserInfoV2(@RequestParam(value = "PARAM") String param) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        String phonenumber = jsonObject.get("phonenumbatch").toString();
        String platformcode = jsonObject.get("platformcode").toString();
        List<String> list = EntityUtil.checkCellphone(phonenumber);
        TnwnsBaseResponse response = new TnwnsBaseResponse();
        try {
            BatchUserReInfo batchUserReInfo=userInfoService.getUserInfoV2(list, platformcode);
            if (batchUserReInfo==null) {
                response.setBatchresultcode(Status.noUserInfo);
                response.setBatchresult(null);
                response.setBatchcount("0");
            } else {
                if(batchUserReInfo.getBatchResult()==null||batchUserReInfo.getBatchResult().size()==0){
                    response.setBatchresult(null);
                    response.setBatchcount("0");
                }else{
                    List<UserTnwnInfoRes> ll=EntityUtil.TransBatchUserInfos(batchUserReInfo);
                    ll=segmentService.AreaDetailSearchV1(ll,platformcode);
                    response.setBatchresult(ll);
                    response.setBatchcount(batchUserReInfo.getBatchResult().size()+"");
                }
                response.setBatchresultcode(batchUserReInfo.getBatchResultCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new TnwnsBaseResponse( Status.error,null);
            logger.info("批量获取用户携转信息异常",e);
        }
        return response;

    }

    /**
     * 获取用户轨迹信息查询
     *
     * @return
     */

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/trajectory", method = RequestMethod.POST)
    BatchTrajectoryInfo gettrajectory(@RequestParam(value = "PARAM") String param) {
        System.out.println("param:" + param);
        JSONObject jsonObject = JSONObject.parseObject(param);
       // TnwnBaseResponse response = new TnwnBaseResponse();
        BatchTrajectoryInfo batchTrajectoryInfo=null;
        try {
            String phonenumber = jsonObject.get("phonenum").toString();
            String platformcode = jsonObject.get("platformcode").toString();
            TUserInfoTemp tUserInfoTemp=null;
            //  TUserInfoTemp tUserInfoTemp = userInfoService.getUserInfoV1(phonenumber, platformcode);
             batchTrajectoryInfo= userInfoService.gettrajectory(phonenumber, platformcode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取用户携转信息异常",e);
        }
        return batchTrajectoryInfo;
    }


    /**
     * 测试
     *
     * @return
     */

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    TnwnsBaseResponse getUserInfoV3(@RequestBody @Validated PhoneRequest phoneRequest, BindingResult bindingResult) {
        try {
            PhoneEntity phone = new PhoneEntity();
            BeanUtils.copyProperties(phoneRequest, phone);
            System.out.println(phone.getPhoneNum());
            System.out.println(phone.getPlatFormtype());
            userInfoService.handleLog(phone);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}