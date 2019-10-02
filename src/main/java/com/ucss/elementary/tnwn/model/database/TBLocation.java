package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;
import java.math.BigDecimal;

public class TBLocation implements Serializable {
    private BigDecimal gid;

    private String locationname;

    private String locationcode;

    private String lastlevelcode;

    private BigDecimal parentid;

    private BigDecimal locationlevel;

    private String locationdesc;

    private String transcode;

    private BigDecimal locationorder;

    private BigDecimal locationtype;

    private String locationsimplecode;

    private String telecode;

    private String description;

    private String provincecode;

    private static final long serialVersionUID = 1L;

    public BigDecimal getGid() {
        return gid;
    }

    public void setGid(BigDecimal gid) {
        this.gid = gid;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname == null ? null : locationname.trim();
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode == null ? null : locationcode.trim();
    }

    public String getLastlevelcode() {
        return lastlevelcode;
    }

    public void setLastlevelcode(String lastlevelcode) {
        this.lastlevelcode = lastlevelcode == null ? null : lastlevelcode.trim();
    }

    public BigDecimal getParentid() {
        return parentid;
    }

    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public BigDecimal getLocationlevel() {
        return locationlevel;
    }

    public void setLocationlevel(BigDecimal locationlevel) {
        this.locationlevel = locationlevel;
    }

    public String getLocationdesc() {
        return locationdesc;
    }

    public void setLocationdesc(String locationdesc) {
        this.locationdesc = locationdesc == null ? null : locationdesc.trim();
    }

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode == null ? null : transcode.trim();
    }

    public BigDecimal getLocationorder() {
        return locationorder;
    }

    public void setLocationorder(BigDecimal locationorder) {
        this.locationorder = locationorder;
    }

    public BigDecimal getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(BigDecimal locationtype) {
        this.locationtype = locationtype;
    }

    public String getLocationsimplecode() {
        return locationsimplecode;
    }

    public void setLocationsimplecode(String locationsimplecode) {
        this.locationsimplecode = locationsimplecode == null ? null : locationsimplecode.trim();
    }

    public String getTelecode() {
        return telecode;
    }

    public void setTelecode(String telecode) {
        this.telecode = telecode == null ? null : telecode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }
}