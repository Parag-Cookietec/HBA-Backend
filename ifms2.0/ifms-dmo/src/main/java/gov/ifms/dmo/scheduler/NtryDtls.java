package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NtryDtls {

	@JsonProperty("TxDtls")
	private TxDtls txDtls  = new TxDtls();

	public TxDtls getTxDtls() {
		return txDtls;
	}

	public void setTxDtls(TxDtls txDtls) {
		this.txDtls = txDtls;
	}
	
}
