package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Othr {
	
	@JsonProperty("Id")
	private Long id = 0l;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

}
