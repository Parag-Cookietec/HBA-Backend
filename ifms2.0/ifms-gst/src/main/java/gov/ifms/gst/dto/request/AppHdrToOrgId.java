package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppHdrToOrgId {

	@JsonProperty("Id")
	private ToOrgId id = new ToOrgId();

	public ToOrgId getId() {
		return id;
	}

	public void setId(ToOrgId id) {
		this.id = id;
	}
	
}
