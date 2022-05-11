package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NtryHdr {

	@JsonProperty("Amt")
	private String amount;
	
	@JsonProperty("CdtDbtInd")
	private String cdtDbtInd ;
	
	@JsonProperty("BkTxCd")
	private BkTxCd bkTxCd = new BkTxCd();

	public String getCdtDbtInd() {
		return cdtDbtInd;
	}

	public void setCdtDbtInd(String cdtDbtInd) {
		this.cdtDbtInd = cdtDbtInd;
	}

	public BkTxCd getBkTxCd() {
		return bkTxCd;
	}

	public void setBkTxCd(BkTxCd bkTxCd) {
		this.bkTxCd = bkTxCd;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
