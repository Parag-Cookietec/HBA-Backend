package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppHdrTo {
	@JsonProperty("OrgId")
	private AppHdrToOrgId to = new AppHdrToOrgId();

	public AppHdrToOrgId getTo() {
		return to;
	}

	public void setTo(AppHdrToOrgId to) {
		this.to = to;
	}


}
