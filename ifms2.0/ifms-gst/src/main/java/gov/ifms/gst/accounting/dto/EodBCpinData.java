package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EodBCpinData {

	@JsonProperty("state_cd")
	private String stateCd = null;
	
	@JsonProperty("cpin")
    private Cpin cpin;

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public Cpin getCpin() {
		return cpin;
	}

	public void setCpin(Cpin cpin) {
		this.cpin = cpin;
	}


	
	
	
}
