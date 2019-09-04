package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.util.TConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class PicVericodeService {
    @Autowired
    RedisTemplate redisTemplate;

    //图片验证码有效期，单位秒
    private int validity = 5 * 60;

    //保存图片验证码
    public void savePicVericode(String token, String vericode) {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(vericode)) {
            return;
        }
        redisTemplate.opsForValue().set(CacheKeyConst.PIC_VERICODE_PRE + token, vericode, validity, TimeUnit.SECONDS);
    }

    //验证图形验证码
    public boolean verify(String token, String veriCode) {
        String savedVericode = TConverter.toSafeString(redisTemplate.opsForValue().get(CacheKeyConst.PIC_VERICODE_PRE + token));
        if (veriCode.equalsIgnoreCase(savedVericode)) {
            return true;
        } else {
            return false;
        }
    }

    //根据token获取图形验证码
    public String getVericode(String token) {
        return TConverter.toSafeString(redisTemplate.opsForValue().get(CacheKeyConst.PIC_VERICODE_PRE + token));
    }


}
