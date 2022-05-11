package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balhdr {

	@JsonProperty("Tp")
	private TpHdr tp = new TpHdr();
	
	public TpHdr getTp() {
		return tp;
	}

	public void setTp(TpHdr tp) {
		this.tp = tp;
	}

}
