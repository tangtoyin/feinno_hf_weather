package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TBNumrange implements Serializable {
    private BigDecimal id;

    private String procid;

    private String opertype;

    private String citycode;

    private String cityname;

    private String numrange;

    private String imsi;

    private String validdate;

    private String expiprdate;

    private String timestamp;

    private String type;

    private String classify;

    private String servicer;

    private Date createtime;

    private Date updatetime;

    private String servicername;

    private Short isvalid;

    private String locationcode;

    private String beginno;

    private String endno;

    public TBLongareacode getTbLongareacode() {
        return tbLongareacode;
    }

    public void setTbLongareacode(TBLongareacode tbLongareacode) {
        this.tbLongareacode = tbLongareacode;
    }

    private TBLongareacode tbLongareacode;
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

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getNumrange() {
        return numrange;
    }

    public void setNumrange(String numrange) {
        this.numrange = numrange == null ? null : numrange.trim();
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getValiddate() {
        return validdate;
    }

    public void setValiddate(String validdate) {
        this.validdate = validdate == null ? null : validdate.trim();
    }

    public String getExpiprdate() {
        return expiprdate;
    }

    public void setExpiprdate(String expiprdate) {
        this.expiprdate = expiprdate == null ? null : expiprdate.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getServicer() {
        return servicer;
    }

    public void setServicer(String servicer) {
        this.servicer = servicer == null ? null : servicer.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getServicername() {
        return servicername;
    }

    public void setServicername(String servicername) {
        this.servicername = servicername == null ? null : servicername.trim();
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

    public String getBeginno() {
        return beginno;
    }

    public void setBeginno(String beginno) {
        this.beginno = beginno == null ? null : beginno.trim();
    }

    public String getEndno() {
        return endno;
    }

    public void setEndno(String endno) {
        this.endno = endno == null ? null : endno.trim();
    }
}