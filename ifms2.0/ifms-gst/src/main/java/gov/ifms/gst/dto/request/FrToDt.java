package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrToDt {
	
	
	@JsonProperty("FrDtTm")
	private String frDtTm  = "2019-12-17T00:00:01";
	
	@JsonProperty("ToDtTm")
	private String toDtTm  = "2019-12-17T00:12:10";

	public String getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(String frDtTm) {
		this.frDtTm = frDtTm;
	}

	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

}
