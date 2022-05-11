package gov.ifms.gst.accounting.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class EodDataCinFile {
	
	@JsonProperty("state_cd")
	private String stateCd = null;
	
	
	
	@JsonProperty("cin")
    private Cin cin = null;

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public Cin getCin() {
		return cin;
	}

	public void setCin(Cin cin) {
		this.cin = cin;
	}

}
