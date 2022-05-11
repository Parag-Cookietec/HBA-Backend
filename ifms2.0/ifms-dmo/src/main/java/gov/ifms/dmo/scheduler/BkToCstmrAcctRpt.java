package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BkToCstmrAcctRpt {
	
	@JsonProperty("GrpHdr")
	private GrpHdr grpHdr = new GrpHdr();
	
	@JsonProperty("Rpt")
	private Rpt rpt = new Rpt();
	
	public GrpHdr getGrpHdr() {
		return grpHdr;
	}

	public void setGrpHdr(GrpHdr grpHdr) {
		this.grpHdr = grpHdr;
	}

	public Rpt getRpt() {
		return rpt;
	}

	public void setRpt(Rpt rpt) {
		this.rpt = rpt;
	}

}
