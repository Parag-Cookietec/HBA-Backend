package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dt {
	
	@JsonProperty("DtTm")
	private String DtTm  = "2019-12-17T00:12:10";

	public String getDtTm() {
		return DtTm;
	}

	public void setDtTm(String dtTm) {
		this.DtTm = dtTm;
	}

}
