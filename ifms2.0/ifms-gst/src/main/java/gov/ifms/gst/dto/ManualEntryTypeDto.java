package gov.ifms.gst.dto;

import java.io.Serializable;

public class ManualEntryTypeDto implements Serializable{
	
	private Long id;
	
	private String typeName;
	
	public ManualEntryTypeDto(Long id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

}
