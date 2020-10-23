package com.ucss.elementary.weather.model.database;

import java.io.Serializable;

public class TDIpBlacklist implements Serializable {
    private Long id;

    private String ipsegment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpsegment() {
        return ipsegment;
    }

    public void setIpsegment(String ipsegment) {
        this.ipsegment = ipsegment == null ? null : ipsegment.trim();
    }
}