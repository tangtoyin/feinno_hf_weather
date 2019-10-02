package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;
import java.math.BigDecimal;

public class TBLongareacode implements Serializable {
    private BigDecimal id;

    private String procid;

    private String opertype;

    private String areacode;

    private String provcode;

    private String areaname;

    private String validdate;

    private String expiredate;

    private String timestamp;

    private Short isvalid;

    private String locationcode;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProcid() {
        return procid;
    }

    public void setProcid(String procid) {
        this.procid = procid == null ? null : procid.trim();
    }

    public String getOpertype() {
        return opertype;
    }

    public void setOpertype(String opertype) {
        this.opertype = opertype == null ? null : opertype.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getProvcode() {
        return provcode;
    }

    public void setProvcode(String provcode) {
        this.provcode = provcode == null ? null : provcode.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getValiddate() {
        return validdate;
    }

    public void setValiddate(String validdate) {
        this.validdate = validdate == null ? null : validdate.trim();
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate == null ? null : expiredate.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    public Short getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Short isvalid) {
        this.isvalid = isvalid;
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode == null ? null : locationcode.trim();
    }
}