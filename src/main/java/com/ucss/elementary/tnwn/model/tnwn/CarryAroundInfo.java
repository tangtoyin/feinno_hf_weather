package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/9/20.
 */
public class CarryAroundInfo implements Serializable {
    private String serviceNum;
    private String state;
    private String stateDesc;
    private String netId;
    private String netIdDesc;
    private String portInId;
    private String portInIdDesc;
    private String portOutId;
    private String portOutIdDesc;
    private String homeNet;
    private String homeNetDesc;
    private String activeTime;
    private String inactiveTime;
    private String serviceType;
    private String serviceTypeDesc;
    private String region;
    private String regionName;
    private String province;
    private String provinceName;


    public String getServiceNum() {
        return serviceNum;
    }
    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getStateDesc() {
        return stateDesc;
    }
    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
    public String getNetId() {
        return netId;
    }
    public void setNetId(String netId) {
        this.netId = netId;
    }
    public String getNetIdDesc() {
        return netIdDesc;
    }
    public void setNetIdDesc(String netIdDesc) {
        this.netIdDesc = netIdDesc;
    }
    public String getPortInId() {
        return portInId;
    }
    public void setPortInId(String portInId) {
        this.portInId = portInId;
    }
    public String getPortInIdDesc() {
        return portInIdDesc;
    }
    public void setPortInIdDesc(String portInIdDesc) {
        this.portInIdDesc = portInIdDesc;
    }
    public String getPortOutId() {
        return portOutId;
    }
    public void setPortOutId(String portOutId) {
        this.portOutId = portOutId;
    }
    public String getPortOutIdDesc() {
        return portOutIdDesc;
    }
    public void setPortOutIdDesc(String portOutIdDesc) {
        this.portOutIdDesc = portOutIdDesc;
    }
    public String getHomeNet() {
        return homeNet;
    }
    public void setHomeNet(String homeNet) {
        this.homeNet = homeNet;
    }
    public String getHomeNetDesc() {
        return homeNetDesc;
    }
    public void setHomeNetDesc(String homeNetDesc) {
        this.homeNetDesc = homeNetDesc;
    }
    public String getActiveTime() {
        return activeTime;
    }
    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }
    public String getInactiveTime() {
        return inactiveTime;
    }
    public void setInactiveTime(String inactiveTime) {
        this.inactiveTime = inactiveTime;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getServiceTypeDesc() {
        return serviceTypeDesc;
    }
    public void setServiceTypeDesc(String serviceTypeDesc) {
        this.serviceTypeDesc = serviceTypeDesc;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegionName() {
        return regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvinceName() {
        return provinceName;
    }
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
