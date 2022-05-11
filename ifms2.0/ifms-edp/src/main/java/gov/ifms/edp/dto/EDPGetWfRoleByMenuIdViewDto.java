package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsGivenRemovalDto.
 */
@NativeQueryResultEntity
public class EDPGetWfRoleByMenuIdViewDto {

	/** The lkMenuWfRoleId id. */
	@NativeQueryResultColumn(index = 0)
	private String lkMenuWfRoleId;
	
	/** The menuId . */
	@NativeQueryResultColumn(index = 1)
	private String menuId;
	
	/** The wfRoleId . */
	@NativeQueryResultColumn(index = 2)
	private String wfRoleId;
	
	/** The wfName. */
	@NativeQueryResultColumn(index = 3)
	private String wfName;

	public String getLkMenuWfRoleId() {
		return lkMenuWfRoleId;
	}

	public void setLkMenuWfRoleId(String lkMenuWfRoleId) {
		this.lkMenuWfRoleId = lkMenuWfRoleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(String wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public String getWfName() {
		return wfName;
	}

	public void setWfName(String wfName) {
		this.wfName = wfName;
	}
	
	
	
}
