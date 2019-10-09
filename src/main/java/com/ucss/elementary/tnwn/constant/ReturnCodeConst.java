package com.ucss.elementary.tnwn.constant;

public final class ReturnCodeConst {

    private ReturnCodeConst() {
    }
    //成功
    public static final String SUCCESS = "0";
    //错误
    public static final String ERROR = "500";
    //为空判断
    public static final String EMPTY = "300";
    //未登录
    public static final String NO_LOGIN = "110";
    //用户被封禁
    public static final String USER_BAN="104";
    //有敏感词
    public static final String SENSETIVE_CODE = "200";
    //敏感词提示语
    public static final String SENSETIVE_MSG = "提交的信息含有敏感词词汇，请重试";
    //登录信息有误
    public static final String LOGIN_ERROR="501";

    
}
