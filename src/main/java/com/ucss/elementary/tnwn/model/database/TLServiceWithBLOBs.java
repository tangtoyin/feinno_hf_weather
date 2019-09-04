package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;

public class TLServiceWithBLOBs extends TLService implements Serializable {
    private String request;

    private String response;

    private static final long serialVersionUID = 1L;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }
}