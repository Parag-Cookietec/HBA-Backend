package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CdOrPrtry {
	
	@JsonProperty("Cd")
	private String cd  = "CLBD";

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

}
