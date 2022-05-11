package gov.ifms.dmo.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class TxsSummry {
	
	@JsonProperty("Ntry")
	@JacksonXmlElementWrapper(useWrapping=false)
	private List<NtryHdr> ntryHdr  = new ArrayList<>();

	public List<NtryHdr> getNtryHdr() {
		return ntryHdr;
	}

	public void setNtryHdr(List<NtryHdr> ntryHdr) {
		this.ntryHdr = ntryHdr;
	}

}
