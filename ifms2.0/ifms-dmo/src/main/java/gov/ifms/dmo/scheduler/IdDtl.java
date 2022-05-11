package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdDtl {

	@JsonProperty("OrgId")
	private OrgId othrId = new OrgId();

	public OrgId getOthrId() {
		return othrId;
	}

	public void setOthrId(OrgId othrId) {
		this.othrId = othrId;
	}

}
