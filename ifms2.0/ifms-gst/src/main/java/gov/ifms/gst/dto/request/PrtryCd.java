package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrtryCd extends Acct {
	
	@JsonProperty("Cd")
	private String Cd  = "TRF";

	public String getCd() {
		return Cd;
	}

	public void setCd(String cd) {
		Cd = cd;
	}

}
