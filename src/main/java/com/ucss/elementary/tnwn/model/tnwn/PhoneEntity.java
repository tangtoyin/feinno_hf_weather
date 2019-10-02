package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;

/**
 * Created by Administrator on 2019-9-11.
 */

public class PhoneEntity  implements Serializable {

    private String phoneNum;
    private String platFormtype;

    public PhoneEntity(){};


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPlatFormtype() {
        return platFormtype;
    }

    public void setPlatFormtype(String platFormtype) {
        this.platFormtype = platFormtype;
    }
}
