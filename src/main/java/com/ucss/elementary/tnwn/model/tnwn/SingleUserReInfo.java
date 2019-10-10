package com.ucss.elementary.tnwn.model.tnwn;

import java.io.Serializable;


public class SingleUserReInfo implements Serializable  {
	private String success;
	private String resultCode;
	private String resultMessage;
	private String result;
	private CarryAroundInfo carryAroundInfo;

	private String OUTERIFCODE;
	private String OUTERIFRESULT;
	private String URL;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public CarryAroundInfo getCarryAroundInfo() {
		return carryAroundInfo;
	}

	public void setCarryAroundInfo(CarryAroundInfo carryAroundInfo) {
		this.carryAroundInfo = carryAroundInfo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getOUTERIFCODE() {
		return OUTERIFCODE;
	}

	public void setOUTERIFCODE(String OUTERIFCODE) {
		this.OUTERIFCODE = OUTERIFCODE;
	}

	public String getOUTERIFRESULT() {
		return OUTERIFRESULT;
	}

	public void setOUTERIFRESULT(String OUTERIFRESULT) {
		this.OUTERIFRESULT = OUTERIFRESULT;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}
}




