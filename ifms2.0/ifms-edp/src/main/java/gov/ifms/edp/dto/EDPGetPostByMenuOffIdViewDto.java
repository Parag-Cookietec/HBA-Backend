package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsGivenRemovalDto.
 */
@NativeQueryResultEntity
public class EDPGetPostByMenuOffIdViewDto {
	
	/** The employee number. */
	@NativeQueryResultColumn(index = 0)
	private String employeeNumber;
	
	/** The employee name. */
	@NativeQueryResultColumn(index = 1)
	private String employeeName;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 2)
	private String postName;
	
	/** The post type. */
	@NativeQueryResultColumn(index = 3)
	private String postType;
	
	/** The permission id. */
	@NativeQueryResultColumn(index = 4)
	private String rolePermId;
	
	/** The permission name. */
	@NativeQueryResultColumn(index = 5)
	private String rolePermName;
	
	/** The status id. */
	@NativeQueryResultColumn(index = 6)
	private String wfRoleIds;

	/** The wf role names. */
	@NativeQueryResultColumn(index = 7)
	private String wfRoleNames;

	/** The menu name. */
	@NativeQueryResultColumn(index = 7)
	private String menuName;

	/**
	 * Gets the employee number.
	 *
	 * @return the employee number
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * Sets the employee number.
	 *
	 * @param employeeNumber the new employee number
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the new employee name
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the post name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the new post name
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the post type.
	 *
	 * @return the post type
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * Sets the post type.
	 *
	 * @param postType the new post type
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * Gets the role perm id.
	 *
	 * @return the role perm id
	 */
	public String getRolePermId() {
		return rolePermId;
	}

	/**
	 * Sets the role perm id.
	 *
	 * @param rolePermId the new role perm id
	 */
	public void setRolePermId(String rolePermId) {
		this.rolePermId = rolePermId;
	}

	/**
	 * Gets the role perm name.
	 *
	 * @return the role perm name
	 */
	public String getRolePermName() {
		return rolePermName;
	}

	/**
	 * Sets the role perm name.
	 *
	 * @param rolePermName the new role perm name
	 */
	public void setRolePermName(String rolePermName) {
		this.rolePermName = rolePermName;
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
	 * Gets the wf role names.
	 *
	 * @return the wf role names
	 */
	public String getWfRoleNames() {
		return wfRoleNames;
	}

	/**
	 * Sets the wf role names.
	 *
	 * @param wfRoleNames the new wf role names
	 */
	public void setWfRoleNames(String wfRoleNames) {
		this.wfRoleNames = wfRoleNames;
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
		
}
