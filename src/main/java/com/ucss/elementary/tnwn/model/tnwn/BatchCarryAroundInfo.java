package com.ucss.elementary.tnwn.model.tnwn;

/**
 * Created by Administrator on 2019/9/20.
 */
public class BatchCarryAroundInfo {
    private String success;
    private String resultCode;
    private String resultMessage;
    private String result;
    private CarryAroundInfo carryAroundInfo;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public CarryAroundInfo getCarryAroundInfo() {
        return carryAroundInfo;
    }

    public void setCarryAroundInfo(CarryAroundInfo carryAroundInfo) {
        this.carryAroundInfo = carryAroundInfo;
    }
}
