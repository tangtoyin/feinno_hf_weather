package com.ucss.elementary.tnwn.model.response;

/**
 * Created by HL on 2018/1/21.
 */
public class ErrorResponse {

    public ErrorResponse() {

    }

    public ErrorResponse(String resultcode, Object result) {
        this.resultcode = resultcode;
        this.result = result;

    }
    private String resultcode;
    private Object result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
