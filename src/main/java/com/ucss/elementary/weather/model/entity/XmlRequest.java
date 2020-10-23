package com.ucss.elementary.weather.model.entity;

/**
 * Created by Administrator on 2019/10/28.
 */
public class XmlRequest {
    private String code;
    private String sid;
    private String sourceCode;
    private Long timestamp;
    private String sessionId;
    private String sender;
    private String smsContent;
    private String receiverList;
    private String productCode;
    private String pseudoFlag;

    public XmlRequest(){};

    public XmlRequest(String code, String sid, String sourceCode, Long timestamp, String sessionId, String sender, String smsContent, String receiverList, String productCode, String pseudoFlag) {
        this.code = code;
        this.sid = sid;
        this.sourceCode = sourceCode;
        this.timestamp = timestamp;
        this.sessionId = sessionId;
        this.sender = sender;
        this.smsContent = smsContent;
        this.receiverList = receiverList;
        this.productCode = productCode;
        this.pseudoFlag = pseudoFlag;
    }

    public String getPseudoFlag() {
        return pseudoFlag;
    }

    public void setPseudoFlag(String pseudoFlag) {
        this.pseudoFlag = pseudoFlag;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(String receiverList) {
        this.receiverList = receiverList;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

