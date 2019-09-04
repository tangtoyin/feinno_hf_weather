package com.ucss.elementary.tnwn.model.response;

/**
 * Created by HL on 2018/1/21.
 */
public class BaseResponse {

    public BaseResponse() {
        this.data = "";
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = "";
    }

    public BaseResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Object data) {
        this.code = "0";
        this.message = "成功";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String code;
    private String message;
    private Object data;
}
