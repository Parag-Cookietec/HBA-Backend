package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {

	@JsonProperty("Othr")
	private Othr othr = new Othr();

	public Othr getOthr() {
		return othr;
	}

	public void setOthr(Othr othr) {
		this.othr = othr;
	}
	
	
}
