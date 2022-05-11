package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TxsSummry {
	
	@JsonProperty("TotCdtEntryNo")
	private TotCdtEntryNo totCdtEntryNo  = new TotCdtEntryNo();
	
	@JsonProperty("TtlDbtNtries")
	private TtlDbtNtries ttlDbtNtries = new TtlDbtNtries();

	
	public TtlDbtNtries getTtlDbtNtries() {
		return ttlDbtNtries;
	}

	public void setTtlDbtNtries(TtlDbtNtries ttlDbtNtries) {
		this.ttlDbtNtries = ttlDbtNtries;
	}

	public TotCdtEntryNo getTotCdtEntryNo() {
		return totCdtEntryNo;
	}

	public void setTotCdtEntryNo(TotCdtEntryNo totCdtEntryNo) {
		this.totCdtEntryNo = totCdtEntryNo;
	}

	
	
	
	
}
