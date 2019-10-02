package com.ucss.elementary.tnwn.model.tnwn;

import java.util.List;

/**
 * Created by Administrator on 2019-9-26.
 */
public class TrajectoryInfo {
    private String serviceNum;
    private String count;
    private List<CarryAroundInfo> trackRecord;

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public List<CarryAroundInfo> getTrackRecord() {
        return trackRecord;
    }

    public void setTrackRecord(List<CarryAroundInfo> trackRecord) {
        this.trackRecord = trackRecord;
    }
}
