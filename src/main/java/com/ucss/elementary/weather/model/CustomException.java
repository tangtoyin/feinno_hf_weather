package com.ucss.elementary.weather.model;

import com.ucss.elementary.weather.constant.ReturnCodeConst;

/**
 * @author Smile
 * @date 2018/12/28 16:30
 */
public class CustomException extends Exception{
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String code;
    String msg;
    public CustomException(){}

    public CustomException(String msg){
        this.code= ReturnCodeConst.ERROR;
        this.msg=msg;
    }
    public CustomException(String code,String msg){
        this.code= code;
        this.msg=msg;
    }
}
