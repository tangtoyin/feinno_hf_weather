package com.ucss.elementary.tnwn.model.response;

/**
 * Created by tangbo on 2019/9/6.
 */
public class TnwnsBaseResponse {

    public TnwnsBaseResponse(){}

    public TnwnsBaseResponse(Object batchResult) {
        this.batchresultcode = "000000";
        this.batchresult = batchResult;
        this.batchcount="1";
    }
    public TnwnsBaseResponse(Object batchResult,int size) {
        this.batchresultcode = "000000";
        this.batchresult = batchResult;
        this.batchcount=size+"";
    }

    public TnwnsBaseResponse(String batchResultCode) {
        this.batchresultcode = batchResultCode;
        this.batchresult = null;
        this.batchcount="0";
    }

    public TnwnsBaseResponse(String batchResultCode,Object batchResult) {
        this.batchresultcode = batchResultCode;
        this.batchresult = batchResult;
        this.batchcount="0";
    }


    private String batchresultcode;
    private String batchcount;
    private Object batchresult;


    public String getBatchresultcode() {
        return batchresultcode;
    }

    public void setBatchresultcode(String batchresultcode) {
        this.batchresultcode = batchresultcode;
    }

    public String getBatchcount() {
        return batchcount;
    }

    public void setBatchcount(String batchcount) {
        this.batchcount = batchcount;
    }

    public Object getBatchresult() {
        return batchresult;
    }

    public void setBatchresult(Object batchresult) {
        this.batchresult = batchresult;
    }
}
