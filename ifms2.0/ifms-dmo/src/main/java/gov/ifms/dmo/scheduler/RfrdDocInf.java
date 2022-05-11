package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RfrdDocInf {
	
	@JsonProperty("RltdDt")
	private String rltdDt = "";

	public String getRltdDt() {
		return rltdDt;
	}

	public void setRltdDt(String rltdDt) {
		this.rltdDt = rltdDt;
	}

}
