package com.ucss.elementary.tnwn.model.tnwn;

import java.util.List;

/**
 * Created by Administrator on 2019-9-26.
 */
public class BatchTrajectoryInfo {
    private String success;
    private String resultCode;
    private String resultMessage;
    private String result;
    private TrajectoryInfo trajectoryInfo;


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

    public TrajectoryInfo getTrajectoryInfo() {
        return trajectoryInfo;
    }

    public void setTrajectoryInfo(TrajectoryInfo trajectoryInfo) {
        this.trajectoryInfo = trajectoryInfo;
    }
}
