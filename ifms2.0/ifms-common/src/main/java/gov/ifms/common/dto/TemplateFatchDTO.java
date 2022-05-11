package gov.ifms.common.dto;

import javax.validation.constraints.NotNull;

public class TemplateFatchDTO {
	
	@NotNull
	private Long menuId;
	
	@NotNull
	private String eventCategory;
	
	@NotNull
	private String eventName;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
