package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tp {
	
	@JsonProperty("CdOrPrtry")
	private CdOrPrtry cdOrPrtry = new CdOrPrtry();

	public CdOrPrtry getCdOrPrtry() {
		return cdOrPrtry;
	}

	public void setCdOrPrtry(CdOrPrtry cdOrPrtry) {
		this.cdOrPrtry = cdOrPrtry;
	}

}
