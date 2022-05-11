package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BkTxCd {
	

	@JsonProperty("Prtry")
	private Prtry prtry = new Prtry();

	public Prtry getPrtry() {
		return prtry;
	}

	public void setPrtry(Prtry prtry) {
		this.prtry = prtry;
	}

}
