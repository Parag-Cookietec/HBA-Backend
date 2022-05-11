package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class To {

	@JsonProperty("OrgId")
	private OrgId orgId = new OrgId();

	public OrgId getOrgId() {
		return orgId;
	}

	public void setOrgId(OrgId orgId) {
		this.orgId = orgId;
	}
	
}
