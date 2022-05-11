package gov.ifms.edp.dto;

import java.io.Serializable;

public class PostOfficeMenuDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long postOfficeUserId;
	private Long menuId;
	public Long getPostOfficeUserId() {
		return postOfficeUserId;
	}
	public void setPostOfficeUserId(Long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
