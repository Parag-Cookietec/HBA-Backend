package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InitgPty {

	@JsonProperty("Id")
	private IdDtl id = new IdDtl();

	public IdDtl getId() {
		return id;
	}

	public void setId(IdDtl id) {
		this.id = id;
	}

}
