package com.ucss.elementary.tnwn.controller.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.util.RandomValueUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * @author Smile
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${server.port}")
    String port;


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RandomValueUtil randomValueUtil;


    @ApiOperation("body测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("body")
    BaseResponse bodyTest(
            @RequestBody(required = false) JSONObject body,
            @RequestParam(value = "uat") String uat
    ) {
        JSON b = body;
        return new BaseResponse(body);
    }


    @ApiOperation("测试")
    @PostMapping("test")
    BaseResponse test1(
            @RequestParam(value = "param1") String param1,
            HttpServletResponse response
    ) {
        return new BaseResponse(param1);
    }

    @ApiOperation("redis-set")
    @PostMapping("redisset")
    BaseResponse redisSetValue(@RequestParam(value = "rediskey") String rediskey, @RequestParam(value = "value") String value) {
//        redisTemplate.opsForValue().set(rediskey, value);


        return new BaseResponse("set success!");
    }


    @ApiOperation("redis-get")
    @PostMapping("redisget")
    BaseResponse redisGetValue(@RequestParam(value = "rediskey") String rediskey) {
//        String abc = TConverter.toSafeString(redisTemplate.opsForValue().get(rediskey));
//        return new BaseResponse(abc);

        return new BaseResponse("");
    }


}
