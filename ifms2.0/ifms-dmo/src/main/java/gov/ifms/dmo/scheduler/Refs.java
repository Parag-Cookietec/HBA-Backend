package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Refs {

	@JsonProperty("MndtId")
	private String mndtId = "";

	public String getMndtId() {
		return mndtId;
	}

	public void setMndtId(String mndtId) {
		this.mndtId = mndtId;
	}
	
}
