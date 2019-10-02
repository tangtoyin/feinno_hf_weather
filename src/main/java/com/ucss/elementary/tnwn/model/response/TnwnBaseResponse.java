package com.ucss.elementary.tnwn.model.response;

/**
 * Created by tangbo on 2019/9/6.
 */
public class TnwnBaseResponse {

    public TnwnBaseResponse() {
        this.result = "";
    }

    public TnwnBaseResponse(String resultcode) {
        this.resultcode = resultcode;
        this.result = "";
    }

    public TnwnBaseResponse( String resultcode, Object data) {

        this.resultcode = resultcode;
        this.result = data;
    }

    public TnwnBaseResponse(Object data) {
        this.resultcode = "";
        this.result = data;
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
