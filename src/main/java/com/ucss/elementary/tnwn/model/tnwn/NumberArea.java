package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;

/**
 * Created by Administrator on 2019-9-6.
 */
public class NumberArea implements Serializable {
    private  String resultcode;
    private  String region;
    private  String regioncode;
    private  String longareacode;

    public NumberArea(){};

    public NumberArea(String resultcode){
        this.resultcode=resultcode;
    };



    public NumberArea(String resultcode,String region,String regioncode,String longareacode){
        this.resultcode=resultcode;
        this.region=region;
        this.regioncode=regioncode;
        this.longareacode=longareacode;
    }


    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getLongareacode() {
        return longareacode;
    }

    public void setLongareacode(String longareacode) {
        this.longareacode = longareacode;
    }
}
