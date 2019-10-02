package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;
import java.math.BigDecimal;

public class TBLongareacodePla implements Serializable {
    private BigDecimal id;

    private String platformcode;

    private String areacode;

    private String platformareacode;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPlatformcode() {
        return platformcode;
    }

    public void setPlatformcode(String platformcode) {
        this.platformcode = platformcode == null ? null : platformcode.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getPlatformareacode() {
        return platformareacode;
    }

    public void setPlatformareacode(String platformareacode) {
        this.platformareacode = platformareacode == null ? null : platformareacode.trim();
    }
}