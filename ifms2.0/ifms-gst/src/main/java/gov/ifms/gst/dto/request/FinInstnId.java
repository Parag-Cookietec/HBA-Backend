package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinInstnId {
	
	@JsonProperty("ClrSysMmbId")
	private ClrSysMmbId clrSysMmbId = new ClrSysMmbId();

	public ClrSysMmbId getClrSysMmbId() {
		return clrSysMmbId;
	}

	public void setClrSysMmbId(ClrSysMmbId clrSysMmbId) {
		this.clrSysMmbId = clrSysMmbId;
	}

}
