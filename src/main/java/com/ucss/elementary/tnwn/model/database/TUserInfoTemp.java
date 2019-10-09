package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;

public class TUserInfoTemp implements Serializable {
    private String servicenum;

    private String state;

    private String statedesc;

    private String netid;

    private String netiddesc;

    private String portinid;

    private String portiniddesc;

    private String portoutid;

    private String portoutiddesc;

    private String homenet;

    private String homenetdesc;

    private String activetime;

    private String servicetype;

    private String servicetypedesc;

    private String region;

    private String regionname;

    private String province;

    private String provincename;

    private static final long serialVersionUID = 1L;

    public String getServicenum() {
        return servicenum;
    }

    public void setServicenum(String servicenum) {
        this.servicenum = servicenum == null ? null : servicenum.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStatedesc() {
        return statedesc;
    }

    public void setStatedesc(String statedesc) {
        this.statedesc = statedesc == null ? null : statedesc.trim();
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String netid) {
        this.netid = netid == null ? null : netid.trim();
    }

    public String getNetiddesc() {
        return netiddesc;
    }

    public void setNetiddesc(String netiddesc) {
        this.netiddesc = netiddesc == null ? null : netiddesc.trim();
    }

    public String getPortinid() {
        return portinid;
    }

    public void setPortinid(String portinid) {
        this.portinid = portinid == null ? null : portinid.trim();
    }

    public String getPortiniddesc() {
        return portiniddesc;
    }

    public void setPortiniddesc(String portiniddesc) {
        this.portiniddesc = portiniddesc == null ? null : portiniddesc.trim();
    }

    public String getPortoutid() {
        return portoutid;
    }

    public void setPortoutid(String portoutid) {
        this.portoutid = portoutid == null ? null : portoutid.trim();
    }

    public String getPortoutiddesc() {
        return portoutiddesc;
    }

    public void setPortoutiddesc(String portoutiddesc) {
        this.portoutiddesc = portoutiddesc == null ? null : portoutiddesc.trim();
    }

    public String getHomenet() {
        return homenet;
    }

    public void setHomenet(String homenet) {
        this.homenet = homenet == null ? null : homenet.trim();
    }

    public String getHomenetdesc() {
        return homenetdesc;
    }

    public void setHomenetdesc(String homenetdesc) {
        this.homenetdesc = homenetdesc == null ? null : homenetdesc.trim();
    }

    public String getActivetime() {
        return activetime;
    }

    public void setActivetime(String activetime) {
        this.activetime = activetime == null ? null : activetime.trim();
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    public String getServicetypedesc() {
        return servicetypedesc;
    }

    public void setServicetypedesc(String servicetypedesc) {
        this.servicetypedesc = servicetypedesc == null ? null : servicetypedesc.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }
}