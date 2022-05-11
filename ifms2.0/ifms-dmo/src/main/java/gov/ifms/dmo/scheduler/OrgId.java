package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrgId {

	@JsonProperty("Othr")
	private Othr othr = new Othr();
	
	public Othr getOthr() {
		return othr;
	}

	public void setOthr(Othr othr) {
		this.othr = othr;
	}
	
	
}

