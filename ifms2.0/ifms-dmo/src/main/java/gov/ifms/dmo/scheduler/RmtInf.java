package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RmtInf {
	
	@JsonProperty("Strd")
	private Strd strd = new Strd();

	@JsonProperty("Ustrd")
	private String ustrd = "";

	public Strd getStrd() {
		return strd;
	}

	public void setStrd(Strd strd) {
		this.strd = strd;
	}

	public String getUstrd() {
		return ustrd;
	}

	public void setUstrd(String ustrd) {
		this.ustrd = ustrd;
	}

}
