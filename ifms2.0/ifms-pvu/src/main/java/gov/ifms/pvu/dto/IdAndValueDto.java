package gov.ifms.pvu.dto;

public class IdAndValueDto {
	
	Long id;
	
	String value;
	
	Long payCellId;
	

	public Long getPayCellId() {
		return payCellId;
	}

	public void setPayCellId(Long payCellId) {
		this.payCellId = payCellId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public IdAndValueDto(Long id, String value,Long payCellId) {
		this.id = id;
		this.value = value;
		this.payCellId=payCellId;
	}
	public IdAndValueDto(Long id, String value) {
		this.id = id;
		this.value = value;
	}
	public IdAndValueDto() {}
	

}
