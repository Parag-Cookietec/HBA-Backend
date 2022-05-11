package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class EdpUserRightsRequestDto.
 */
public class EdpUserRightsRequestDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk mod off type id. */
	private Long lkModOffTypeId;

	/** The sub module id. */
	private Long subModuleId;

	/** The att types. */
	private List<String> attTypes;

	/** The office id. */
	private Long officeId;

	/** The menu id. */
	private Long menuId;
	
	/** The wf role ids. */
	private String wfRoleIds;
	
	/** The perm id. */
	private Long permId;

	/** The module id. */
	private Long moduleId;

	/**
	 * Gets the lk mod off type id.
	 *
	 * @return the lk mod off type id
	 */
	public Long getLkModOffTypeId() {
		return lkModOffTypeId;
	}

	/**
	 * Sets the lk mod off type id.
	 *
	 * @param lkModOffTypeId the new lk mod off type id
	 */
	public void setLkModOffTypeId(Long lkModOffTypeId) {
		this.lkModOffTypeId = lkModOffTypeId;
	}

	/**
	 * Gets the sub module id.
	 *
	 * @return the sub module id
	 */
	public Long getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the new sub module id
	 */
	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Gets the att types.
	 *
	 * @return the att types
	 */
	public List<String> getAttTypes() {
		return attTypes;
	}

	/**
	 * Sets the att types.
	 *
	 * @param attTypes the new att types
	 */
	public void setAttTypes(List<String> attTypes) {
		this.attTypes = attTypes;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the wf role ids.
	 *
	 * @return the wf role ids
	 */
	public String getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the new wf role ids
	 */
	public void setWfRoleIds(String wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

	/**
	 * Gets the perm id.
	 *
	 * @return the perm id
	 */
	public Long getPermId() {
		return permId;
	}

	/**
	 * Sets the perm id.
	 *
	 * @param permId the new perm id
	 */
	public void setPermId(Long permId) {
		this.permId = permId;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
}
