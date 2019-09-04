package com.ucss.elementary.tnwn.model.database;

import com.ucss.elementary.tnwn.constant.IsNeeded;
import com.ucss.elementary.tnwn.util.StringHelper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TDUser implements Serializable {
    private Long id;
    @IsNeeded
    private String phonebind;
    @IsNeeded
    private String emailbind;
    @IsNeeded
    private String password;

    private String nickname;
    @IsNeeded
    private String regioncode;
    @IsNeeded
    private String headimage;
    @IsNeeded
    private Short gender;
    @IsNeeded
    private Short usertype;

    private Short isvalid;

    private Date createtime;

    private Date updatetime;

    private Long auditadminId;

    private Short auditstatus;

    private Date audittime;

    private String auditreason;

    private Short loginerrorcount;

    private Date lastloginerrortime;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    List<SysRole> roleList;
    public Short getLoginerrorcount() {
        return loginerrorcount;
    }

    public void setLoginerrorcount(Short loginerrorcount) {
        this.loginerrorcount = loginerrorcount;
    }

    public Date getLastloginerrortime() {
        return lastloginerrortime;
    }

    public void setLastloginerrortime(Date lastloginerrortime) {
        this.lastloginerrortime = lastloginerrortime;
    }


    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    private String loginname;

    private String virtualphone;

    public String getVirtualphone() {
        return virtualphone;
    }

    public void setVirtualphone(String virtualphone) {
        this.virtualphone = virtualphone;
    }

    public String getJurisdictRegionCode() {
        return jurisdictRegionCode;
    }

    public void setJurisdictRegionCode(String jurisdictRegionCode) {
        this.jurisdictRegionCode = jurisdictRegionCode;
    }

    private String jurisdictRegionCode;

    private static final long serialVersionUID = 1L;

    private Short regisource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhonebind() {
        return phonebind;
    }

    public void setPhonebind(String phonebind) {
        if(!StringHelper.isTrimEmpty(phonebind)) {
            this.phonebind = phonebind.trim();
        }
    }

    public String getEmailbind() {
        return emailbind;
    }

    public void setEmailbind(String emailbind) {
        this.emailbind = emailbind == null ? null : emailbind.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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

    public Short getRegisource() {
        return regisource;
    }

    public void setRegisource(Short regisource) {
        this.regisource = regisource;
    }

    @Override
    public String toString() {
        return "TDUser{" +
                "id=" + id +
                ", phonebind='" + phonebind + '\'' +
                ", emailbind='" + emailbind + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", regioncode='" + regioncode + '\'' +
                ", headimage='" + headimage + '\'' +
                ", gender=" + gender +
                ", usertype=" + usertype +
                ", isvalid=" + isvalid +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", auditadminId=" + auditadminId +
                ", auditstatus=" + auditstatus +
                ", audittime=" + audittime +
                ", auditreason='" + auditreason + '\'' +
                ", virtualphone='" + virtualphone + '\'' +
                ", jurisdictRegionCode='" + jurisdictRegionCode + '\'' +
                ", regisource=" + regisource +
                '}';
    }
}