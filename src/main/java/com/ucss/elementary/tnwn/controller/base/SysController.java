package com.ucss.elementary.tnwn.controller.base;

import com.ucss.elementary.tnwn.model.database.SysDict;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.SysService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Smile
 */
@RestController
@RequestMapping("/sys")
public class SysController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysService sysService;

    //region 通用字典表
    @ApiOperation("根据typecode获取列表")
    @PostMapping("optionbytypecode")
    BaseResponse optionByTypecode(@RequestParam("typecode") String typecode) {
        return new BaseResponse(sysService.getOptionsByTypecode(typecode));
    }

    @ApiOperation("根据typecode和code获取值")
    @PostMapping("option")
    BaseResponse optionByTypecodeAndCode(@RequestParam("typecode") String typecode
            , @RequestParam("code") String code) {
        SysDict dict = sysService.getOptionByTypecodeAndCode(typecode, code);
        if (dict == null) {
            return new BaseResponse("");
        }
        else {
            return new BaseResponse(dict.getLabel());
        }
    }
    //endregion

    //region  缓存
    @ApiOperation("清楚缓存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "key",value = "加*即为清除所有，否则一一对应",dataType = "String", paramType = "query", required = true),
    })
    @PostMapping("refreshredis")
    BaseResponse refreshRedisDataWithPrefix(@RequestParam("key") String key) {
        sysService.refreshRedisDataWithPrefix(key);
        return new BaseResponse("成功");
    }
    //endregion

}
