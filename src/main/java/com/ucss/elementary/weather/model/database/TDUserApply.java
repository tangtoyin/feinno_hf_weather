package com.ucss.elementary.weather.model.database;

import java.io.Serializable;
import java.util.Date;

public class TDUserApply implements Serializable {
    private Long id;

    private Long userId;

    private String nickname;

    private String regioncode;

    private String headimage;

    private Short gender;

    private Short usertype;

    private Short isvalid;

    private Date createtime;

    private Long auditadminId;

    private Short auditstatus;

    private Date audittime;

    private String auditreason;

    private String usertypeText;

    private String phongbind;

    public String getPhongbind() {
        return phongbind;
    }

    public void setPhongbind(String phongbind) {
        this.phongbind = phongbind;
    }

    public String getUsertypeText() {
        return usertypeText;
    }

    public void setUsertypeText(String usertypeText) {
        this.usertypeText = usertypeText;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode == null ? null : regioncode.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public Short getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Short isvalid) {
        this.isvalid = isvalid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getAuditadminId() {
        return auditadminId;
    }

    public void setAuditadminId(Long auditadminId) {
        this.auditadminId = auditadminId;
    }

    public Short getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Short auditstatus) {
        this.auditstatus = auditstatus;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getAuditreason() {
        return auditreason;
    }

    public void setAuditreason(String auditreason) {
        this.auditreason = auditreason == null ? null : auditreason.trim();
    }
}