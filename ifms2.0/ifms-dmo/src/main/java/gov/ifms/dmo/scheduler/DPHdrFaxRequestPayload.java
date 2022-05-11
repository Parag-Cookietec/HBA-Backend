package gov.ifms.dmo.scheduler;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "RequestPayload")
public class DPHdrFaxRequestPayload {
	
	@JsonProperty("AppHdr")
	@XmlElement
	private AppHdr appHdr = new AppHdr();

	@JsonProperty("BkToCstmrAcctRpt")
	private BkToCstmrAcctRpt bkToCstmrAcctRpt = new BkToCstmrAcctRpt();

	public AppHdr getAppHdr() {
		return appHdr;
	}

	public void setAppHdr(AppHdr appHdr) {
		this.appHdr = appHdr;
	}

	public BkToCstmrAcctRpt getBkToCstmrAcctRpt() {
		return bkToCstmrAcctRpt;
	}

	public void setBkToCstmrAcctRpt(BkToCstmrAcctRpt bkToCstmrAcctRpt) {
		this.bkToCstmrAcctRpt = bkToCstmrAcctRpt;
	}

}
