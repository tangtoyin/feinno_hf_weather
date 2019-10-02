package com.ucss.elementary.tnwn.model.tnwn;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2019-9-11.
 */

@Data
@ToString
public class PhoneRequest implements Serializable {

    private String phoneNum;
    private String platFormtype;


}
