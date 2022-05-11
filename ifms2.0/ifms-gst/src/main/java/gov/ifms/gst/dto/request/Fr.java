package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fr {
	
	@JsonProperty("FIId")
	private FIId fIId = new FIId();

	public FIId getfIId() {
		return fIId;
	}

	public void setfIId(FIId fIId) {
		this.fIId = fIId;
	}

}
