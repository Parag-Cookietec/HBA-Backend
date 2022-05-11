package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Acct {

	@JsonProperty("Id")
	private Id id = new Id();

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	
}
