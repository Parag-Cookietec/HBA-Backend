package gov.ifms.gst.dto;

import java.io.Serializable;

public class HeadDto implements Serializable{
	
	private Long id;
	
	private String name;

	private String code;

	private String codeName;

	private String description;

	public HeadDto() {
	}

	public HeadDto(Long id, String code) {
		this.id = id;
		this.code = code;
	}

	public HeadDto(Long id, String name, String code, String codeName, String description) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.codeName = codeName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
