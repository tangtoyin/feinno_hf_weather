package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;

/**
 * Created by Administrator on 2019-9-6.
 */
public class result implements Serializable {

    private String phonenum;

    private String lastoperators;

    private String lastoperatorscode;

    private String operators;

    private String operatorscode;

    private String ischinammobile;

    private String regionname;

    private String regioncode;

    private String provincecode;

    private String provincename;


    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getLastoperators() {
        return lastoperators;
    }

    public void setLastoperators(String lastoperators) {
        this.lastoperators = lastoperators;
    }

    public String getLastoperatorscode() {
        return lastoperatorscode;
    }

    public void setLastoperatorscode(String lastoperatorscode) {
        this.lastoperatorscode = lastoperatorscode;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getOperatorscode() {
        return operatorscode;
    }

    public void setOperatorscode(String operatorscode) {
        this.operatorscode = operatorscode;
    }

    public String getIschinammobile() {
        return ischinammobile;
    }

    public void setIschinammobile(String ischinammobile) {
        this.ischinammobile = ischinammobile;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}
