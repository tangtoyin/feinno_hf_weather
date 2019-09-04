package com.ucss.elementary.tnwn.controller.base;

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

}
