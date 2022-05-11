package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValDt {
	
	@JsonProperty("Dt")
	private String Dt  = "2019-12-17";

	public String getDt() {
		return Dt;
	}

	public void setDt(String dt) {
		Dt = dt;
	}

}
