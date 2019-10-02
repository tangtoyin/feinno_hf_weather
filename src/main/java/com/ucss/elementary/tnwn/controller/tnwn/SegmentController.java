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
import com.ucss.elementary.tnwn.model.tnwn.NumberArea;
import com.ucss.elementary.tnwn.model.tnwn.SegmentArea;
import com.ucss.elementary.tnwn.service.tnwn.SegmentService;
import com.ucss.elementary.tnwn.service.tnwn.UserInfoService;
import com.ucss.elementary.tnwn.util.EntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author Smile
 */
@RestController
@RequestMapping("/tnwn/segmentArea")
@Api(description = "号段区域统一查询接口")

public class SegmentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SegmentService segmentService;

    /**
     * 获取用户携网转号详情单一查询
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
    NumberArea getSegmentArea(@RequestParam(value = "PARAM") String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        NumberArea na=null;
        try {
            String  phonenumber=jsonObject.get("phonenum").toString();
            String  platformcode=jsonObject.get("platformcode").toString();
            na=segmentService.NumberAreaDetail(phonenumber,platformcode);
        }catch (Exception e){
            e.printStackTrace();
            na=new NumberArea(Status.error,"","","");
        }
        return na;
    }


}
