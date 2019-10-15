package com.ucss.elementary.tnwn.constant.tnwn;

/**
 * Created by Administrator on 2019-9-6.
 */
public class Status {

    public static final String success="000000";                     //查询成功且有数据
    public static final String noUserInfo="100001";                  //未查询到用户携转信息！
    public static final String CancellationUserInfo="100002";        //该用户是已注销的携转用户
    public static final String noNumrange="100003";                   //号段不存在
    public static final String error01="200001";                      //数据校验失败，用户手机号码不能为空
    public static final String error02="200002";                       //数据校验失败，用户手机号码不足11位
    public static final String error03="200003";                        //数据校验失败，IP地址不在白名单内
    public static final String error04="200004";                        //数据校验失败，错误的平台标识
    public static final String error05="200005";                         //数据校验失败，数据加密秘钥错误
    public static final String error06="200006";                         //数据校验失败，批量查询数量不能超过500
    public static final String error07="111111";                         //批量查询成功（注：此处的成功为系统未发生异常）
    public static final String error="999999";                           //系统异常
    public static final String error08="101";                            //数据校验失败，手机号码不能为空
    public static final String error09="102";                            //数据校验失败，手机号码格式错误
    public static final String error10="103";                            //数据校验失败，IP地址不在白名单内
    public static final String error11="104";                            //数据校验失败，错误的平台标识
    public static final String error12="105";                            //数据校验失败，数据加密验证错误
    public static final String error13="106";                            //数据校验失败，ts已失效
    public static final String error14="107";                            //数据校验失败，缺少入参
    public static final String error15="500";                            //服务器内部错误
    public static final String error16="406";                            //表示客户端错误，指服务器端无法提供与  Accept-Charset 以及 Accept-Language 消息头指定的值相匹配的响应
    public static final String error17="405";                            //方法不被允许
    public static final String error18="415";                            //服务器无法处理请求附带的媒体格式
    public static final String error19="404";                            //找不到 — 服务器找不到给定的资源
    public static final String error20="400";                            //错误请求 — 请求中有语法问题，或不能满足请求


    public static final String  platform_code_hxpt ="101";
    public static final String  platform_code_esb  ="102";
    public static final String  platform_code_bsy  ="103";
    public static final String  platform_code_nqqx ="104";
    public static final String  platform_code_tyshh="105";
    public static final String  platform_code_hgz  ="106";
    public static final String  platform_code_wgy  ="107";
    public static final String  platform_code_ex   ="108";
    public static final String  platform_code_rx   ="109";
    public static final String  platform_code_xxk  ="110";
    public static final String  platform_code_zwy  ="111";







}
