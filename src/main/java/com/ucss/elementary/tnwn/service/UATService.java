package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import com.ucss.elementary.tnwn.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class UATService {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CmsUserService cmsUserService;
    @Autowired
    SysService sysService;

    //生成uat并保存到redis
    public String generateUAT(long userID) {
        //暂时只以uat做key保存
        //根据生成规则生成uat，保存到redis，返回给客户端
        String uat = UUIDUtil.getUUID();
        //保存到redis： key为uat.随机值	value为userid
        redisTemplate.opsForValue().set(CacheKeyConst.UAT_PRE + uat, userID);
        return uat;
    }

    //根据uat获取userid
    public long getUserIDByUAT(String uat) {
        if (StringUtils.isEmpty(uat)) {
            return 0;
        }
        return TConverter.ObjectToLong(redisTemplate.opsForValue().get(CacheKeyConst.UAT_PRE + uat));
    }

    //根据uat获取用户
    public TDUser getUserByUAT(String uat) {
        if (StringUtils.isEmpty(uat)) {
            return null;
        }
        long userID = getUserIDByUAT(uat);
        if (userID == 0) {
            return null;
        }
        return userService.getByID(userID);
    }

    //根据uat删除缓存中记录
    public void deleteCacheByUAT(String uat) {
        if (StringUtils.isEmpty(uat)) {
            return;
        }
        int isopen=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.single_login","isopen"));//是否开启单一登录
        if(isopen!=1){
            redisTemplate.delete(CacheKeyConst.UAT_PRE + uat);
        }else {
            //根据uat获取到userid
            long userID = TConverter.ObjectToLong(redisTemplate.opsForValue().get(CacheKeyConst.UAT_PRE + uat));
            if (userID == 0) {
                return;
            }
            //删除uat
            redisTemplate.delete(CacheKeyConst.UAT_PRE + uat);
            //删除uatu
            String oldUat = TConverter.toSafeString(redisTemplate.opsForHash().get(CacheKeyConst.UAT_USERID_PRE + userID, "uat"));
            //若新旧uat相同，说明为正常退出，否则为轮询时强制退出
            if (uat.equals(oldUat)) {
                redisTemplate.delete(CacheKeyConst.UAT_USERID_PRE + userID);
            }
        }
    }

    //生成uat和rt并保存到redis和数据库
    public Object generateUATandRT(long userID, String appcode,String imei) {
        String uat = UUIDUtil.getUUID();
        //保存到redis： key为uat.随机值	value为userid
        redisTemplate.opsForValue().set(CacheKeyConst.UAT_PRE + uat, userID);

        //region  app
        if (!StringHelper.isEmpty(appcode) && !"web".equals(appcode.toLowerCase())) {
            int isopen=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.single_login","isopen"));//是否开启单一登录
            if(isopen==1) {
                String uatUserKey = CacheKeyConst.UAT_USERID_PRE + userID;
                //判断用户是否已有登录信息
                if (redisTemplate.hasKey(uatUserKey)){
                    //删除uatu.
                    redisTemplate.delete(uatUserKey);
                }
                //保存到redis hash： key为uatu.userid	value为hash，uat保存生成的uat，以后可扩充imei等字段
                redisTemplate.opsForHash().put(uatUserKey, "uat", uat);
                redisTemplate.opsForHash().put(uatUserKey, "imei", imei);
            }
            //暂时只以uat做key保存,rt保存到数据库
            String rt = UUIDUtil.getUUID();
            userService.insertUserRefresh(userID, rt);
            HashMap<String, Object> result = new HashMap<>();
            result.put("uat", uat);
            result.put("rt", rt);
            return result;
        }
        //endregion
        return uat;
    }

    //保存重置密码的token
    public void savaResetPasswordToken(String token,long  userid){
        if (StringUtils.isEmpty(token) || userid<=0) {
            return;
        }
        redisTemplate.opsForValue().set(CacheKeyConst.RESET_PASSWORD_PRE + token, userid, 5 * 60, TimeUnit.SECONDS);
    }
    //通过重置密码的token获取phone
    public Long getUseridByRPToken(String token) {
        Long userid= TConverter.ObjectToLong(redisTemplate.opsForValue().get(CacheKeyConst.RESET_PASSWORD_PRE + token));
        if(userid!=null&&userid>0){//设置过期
            redisTemplate.delete(CacheKeyConst.RESET_PASSWORD_PRE + token);
        }
        return userid;
    }

}
