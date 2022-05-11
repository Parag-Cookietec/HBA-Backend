package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClrSysMmbId {
	
	@JsonProperty("MmbId")
	private String mmbId = "RBI";

	public String getMmbId() {
		return mmbId;
	}

	public void setMmbId(String mmbId) {
		this.mmbId = mmbId;
	}

}
