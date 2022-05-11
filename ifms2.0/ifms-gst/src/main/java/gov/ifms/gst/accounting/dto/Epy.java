package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Epy {
	
	
	@JsonProperty("gstin")	
	   private String gstin = null;
	
	@JsonProperty("cpin_dt")
	   private String cpinDt = null;
	
	@JsonProperty("cpin_tim")
	   private String cpinTim = null;
	
	@JsonProperty("cpin")
	   private String cpin = null;
	
	@JsonProperty("blocked_by")
	   private String blockedBy = null;
	
	@JsonProperty("blocked_dt")
	   private String blockeBt = null;
	
	@JsonProperty("blocked_tim")
	   private String blockedTim = null;

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

	public String getBlockeBt() {
		return blockeBt;
	}

	public void setBlockeBt(String blockeBt) {
		this.blockeBt = blockeBt;
	}

	public String getBlockedTim() {
		return blockedTim;
	}

	public void setBlockedTim(String blockedTim) {
		this.blockedTim = blockedTim;
	}



}
