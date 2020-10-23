package com.ucss.elementary.weather.constant;

import com.ucss.elementary.weather.util.SystemConfigUtil;

public final class CacheKeyConst {

    //前缀名称
    static String redisPre = SystemConfigUtil.getProperty("spring.application.name");
    //前缀名称--可以清除缓存的
    static String redisOtherPre = SystemConfigUtil.getProperty("spring.application.name")+"tnwn.";

    private CacheKeyConst() {
    }

    //region 不可清除缓存
    //uat前缀
    public static final String UAT_PRE = redisPre + "uat.";
    //uat（用户id）前缀，保存为hash类型，目前有字段uat，后续可扩充类似imei之类字段
    public static final String UAT_USERID_PRE = redisPre + "uatu.";
    //图片验证码
    public static final String PIC_VERICODE_PRE = redisPre + ".pvc.";
    //重置密码token
    public static final String RESET_PASSWORD_PRE = redisPre + "rep.";

    //endregion

    //region uaf开头
    //地区缓存，hash类型，hash的key为regioncode，value为region对象
    public static final String REGION_CODE = redisOtherPre + "rg";
    //地区父级缓存，hash类型，hash的key为parentcode，value为region对象列表
    public static final String REGION_PARENT = redisOtherPre + "rgp";
    //字典表
    public static final String DICT = redisOtherPre + "dict";
    //取区县的区域:hash类型，hash的key为hieraechy，value为region对象列表
    public static final String REGION_CITY = redisOtherPre + "rg.city";
    //广告位
    public static final String AD = redisOtherPre + "ad.";
    //导航图标
    public static final String APPICON = redisOtherPre + "appicon.";
    //幻灯片
    public static final String BANNER = redisOtherPre + "banner.";
    //分享模板
    public static final String SHAREMANAGEMENT = redisOtherPre + "sharemanagement.";
    //秘钥
    public static final String API_KEY = redisOtherPre + "apikey.";
    //白名单
    public static final String IP_WHITELIST = redisOtherPre + "ip_whitelist.";
    //黑名单
    public static final String IP_BLACKLIST = redisOtherPre + "ip_blacklist.";
    //数据库数据类型
    public static final String DB_DATETYPE = redisOtherPre + "db_datetype.";
    //定时任务失败重传时间
    public static final String TIMERJOB_REEXECUTE_ID=redisOtherPre + "timerjob_reexecute_id.";
    //应用方
    public static final String PARTNERID = redisOtherPre + "partnerid.";
    //endregion
}
