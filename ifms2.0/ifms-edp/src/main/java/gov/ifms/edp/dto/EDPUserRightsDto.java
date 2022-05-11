package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsDto.
 */
@NativeQueryResultEntity
public class EDPUserRightsDto {

	/** The role prm id. */
	@NativeQueryResultColumn(index = 0)
	private String rolePrmId;

	/** The district id. */
	@NativeQueryResultColumn(index = 1)
	private String rolePrmName;

	/** The menu id. */
	@NativeQueryResultColumn(index = 2)
	private String menuId;

	/** The menu name. */
	@NativeQueryResultColumn(index = 3)
	private String menuName;

	/** The sub module id. */
	@NativeQueryResultColumn(index = 4)
	private String subModuleId;

	/** The sub module name. */
	@NativeQueryResultColumn(index = 5)
	private String subModuleName;

	/** The module id. */
	@NativeQueryResultColumn(index = 6)
	private String moduleId;

	/** The module name. */
	@NativeQueryResultColumn(index = 7)
	private String moduleName;

	@NativeQueryResultColumn(index = 8)
	private String statusId;

	@NativeQueryResultColumn(index = 9)
	private String isRemoved;
	
	@NativeQueryResultColumn(index = 10)
	private String empName;
	
	@NativeQueryResultColumn(index = 11)
	private String empNo;
	
	@NativeQueryResultColumn(index = 12)
	private String postName;
	
	@NativeQueryResultColumn(index = 13)
	private String statusName;
	
	@NativeQueryResultColumn(index = 14)
	private String createdBy;
	
	@NativeQueryResultColumn(index = 15)
	private String createdByPostName;
	
	@NativeQueryResultColumn(index = 16)
	private String createdByPostId;
	
	@NativeQueryResultColumn(index = 17)
	private Long rgMapId;
	
	@NativeQueryResultColumn(index = 18)
	private String lkUsrMenuId;
	
	

	public String getCreatedBy() {
		return createdBy;
	}

	public Long getRgMapId() {
		return rgMapId;
	}

	public void setRgMapId(Long rgMapId) {
		this.rgMapId = rgMapId;
	}

	public String getLkUsrMenuId() {
		return lkUsrMenuId;
	}

	public void setLkUsrMenuId(String lkUsrMenuIds) {
		lkUsrMenuId = lkUsrMenuIds;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByPostName() {
		return createdByPostName;
	}

	public void setCreatedByPostName(String createdByPostName) {
		this.createdByPostName = createdByPostName;
	}

	public String getCreatedByPostId() {
		return createdByPostId;
	}

	public void setCreatedByPostId(String createdByPostId) {
		this.createdByPostId = createdByPostId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(String isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
	 * Gets the role prm id.
	 *
	 * @return the role prm id
	 */
	public String getRolePrmId() {
		return rolePrmId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the new role prm id
	 */
	public void setRolePrmId(String rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the role prm name.
	 *
	 * @return the role prm name
	 */
	public String getRolePrmName() {
		return rolePrmName;
	}

	/**
	 * Sets the role prm name.
	 *
	 * @param rolePrmName the new role prm name
	 */
	public void setRolePrmName(String rolePrmName) {
		this.rolePrmName = rolePrmName;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the menu name.
	 *
	 * @return the menu name
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * Sets the menu name.
	 *
	 * @param menuName the new menu name
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * Gets the sub module id.
	 *
	 * @return the sub module id
	 */
	public String getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the new sub module id
	 */
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Gets the sub module name.
	 *
	 * @return the sub module name
	 */
	public String getSubModuleName() {
		return subModuleName;
	}

	/**
	 * Sets the sub module name.
	 *
	 * @param subModuleName the new sub module name
	 */
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public String getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the module name.
	 *
	 * @return the module name
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * Sets the module name.
	 *
	 * @param moduleName the new module name
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Instantiates a new EDP user rights dto.
	 */
	public EDPUserRightsDto() {
		super();
	}

}
