package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/9/22.
 */
public class BatchUserReInfo implements Serializable {
    private String batchuccess;
    private String batchResultCode;
    private String batchResultMessage;
    private String batchCount;
    private List<BatchCarryAroundInfo> batchResult;

    public String getBatchuccess() {
        return batchuccess;
    }

    public void setBatchuccess(String batchuccess) {
        this.batchuccess = batchuccess;
    }

    public String getBatchResultCode() {
        return batchResultCode;
    }

    public void setBatchResultCode(String batchResultCode) {
        this.batchResultCode = batchResultCode;
    }

    public String getBatchResultMessage() {
        return batchResultMessage;
    }

    public void setBatchResultMessage(String batchResultMessage) {
        this.batchResultMessage = batchResultMessage;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        this.batchCount = batchCount;
    }


    public List<BatchCarryAroundInfo> getBatchResult() {
        return batchResult;
    }

    public void setBatchResult(List<BatchCarryAroundInfo> batchResult) {
        this.batchResult = batchResult;
    }
}
