package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;
import java.util.Date;

public class TLTnwninterlog implements Serializable {
    private Long id;

    private String ifcode;

    private String ifname;

    private String requester;

    private String phone;

    private String ip;

    private String ifurl;

    private String ifresultcode;

    private String ifresult;

    private String outerifcode;

    private String outerifname;

    private String outerifurl;

    private String outerifresult;

    private Date createtime;

    private String ifexception;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIfcode() {
        return ifcode;
    }

    public void setIfcode(String ifcode) {
        this.ifcode = ifcode == null ? null : ifcode.trim();
    }

    public String getIfname() {
        return ifname;
    }

    public void setIfname(String ifname) {
        this.ifname = ifname == null ? null : ifname.trim();
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester == null ? null : requester.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIfurl() {
        return ifurl;
    }

    public void setIfurl(String ifurl) {
        this.ifurl = ifurl == null ? null : ifurl.trim();
    }

    public String getIfresultcode() {
        return ifresultcode;
    }

    public void setIfresultcode(String ifresultcode) {
        this.ifresultcode = ifresultcode == null ? null : ifresultcode.trim();
    }

    public String getIfresult() {
        return ifresult;
    }

    public void setIfresult(String ifresult) {
        this.ifresult = ifresult == null ? null : ifresult.trim();
    }

    public String getOuterifcode() {
        return outerifcode;
    }

    public void setOuterifcode(String outerifcode) {
        this.outerifcode = outerifcode == null ? null : outerifcode.trim();
    }

    public String getOuterifname() {
        return outerifname;
    }

    public void setOuterifname(String outerifname) {
        this.outerifname = outerifname == null ? null : outerifname.trim();
    }

    public String getOuterifurl() {
        return outerifurl;
    }

    public void setOuterifurl(String outerifurl) {
        this.outerifurl = outerifurl == null ? null : outerifurl.trim();
    }

    public String getOuterifresult() {
        return outerifresult;
    }

    public void setOuterifresult(String outerifresult) {
        this.outerifresult = outerifresult == null ? null : outerifresult.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIfexception() {
        return ifexception;
    }

    public void setIfexception(String ifexception) {
        this.ifexception = ifexception == null ? null : ifexception.trim();
    }
}