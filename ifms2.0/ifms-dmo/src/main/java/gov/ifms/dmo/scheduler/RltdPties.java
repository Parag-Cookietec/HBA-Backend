package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RltdPties {

	@JsonProperty("InitgPty")
	private InitgPty initgPty = new InitgPty();

	public InitgPty getInitgPty() {
		return initgPty;
	}

	public void setInitgPty(InitgPty initgPty) {
		this.initgPty = initgPty;
	}

}
