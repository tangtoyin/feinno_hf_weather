package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;

/**
 * Created by Administrator on 2019-9-6.
 */
public class SegmentArea implements Serializable {

    public SegmentArea(){};

    public SegmentArea(String success,String region,String regioncode,String longareacode){
        this.success=success;
        this.region=region;
        this.regioncode=regioncode;
        this.longareacode=longareacode;
    }

    private  String success;
    private  String region;
    private  String regioncode;
    private  String longareacode;


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
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
