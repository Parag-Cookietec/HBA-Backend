package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ner {
	
	@JsonProperty("gstin")	
    private String gstin;
	
	@JsonProperty("cpin_dt")	
	private String cpinDt;
	
	@JsonProperty("cpin_tim")	
	private String cpinTim;
	
	@JsonProperty("cpin")	
    private String cpin ;
	
	@JsonProperty("blocked_by")	
	private String blockedBy;
	
	@JsonProperty("blocked_dt")	
	private String blockedBt;
	
	@JsonProperty("blocked_tim")	
	private String blockedTim;

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(String cpinDt) {
		this.cpinDt = cpinDt;
	}

	public String getCpinTim() {
		return cpinTim;
	}

	public void setCpinTim(String cpinTim) {
		this.cpinTim = cpinTim;
	}

	public String getCpin() {
		return cpin;
	}

	public void setCpin(String cpin) {
		this.cpin = cpin;
	}

	public String getBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(String blockedBy) {
		this.blockedBy = blockedBy;
	}

	public String getBlockedBt() {
		return blockedBt;
	}

	public void setBlockedBt(String blockedBt) {
		this.blockedBt = blockedBt;
	}

	public String getBlockedTim() {
		return blockedTim;
	}

	public void setBlockedTim(String blockedTim) {
		this.blockedTim = blockedTim;
	}




	

}
