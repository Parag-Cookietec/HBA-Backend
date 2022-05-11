package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TpHdr {
	
	@JsonProperty("Cd")
	private String cd = "CLAV";

	@JsonProperty("Amt")
	private String amount;
	
	@JsonProperty("CdtDbtInd")
	private String cdtDbtInd = "CRDT1";

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdtDbtInd() {
		return cdtDbtInd;
	}

	public void setCdtDbtInd(String cdtDbtInd) {
		this.cdtDbtInd = cdtDbtInd;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
