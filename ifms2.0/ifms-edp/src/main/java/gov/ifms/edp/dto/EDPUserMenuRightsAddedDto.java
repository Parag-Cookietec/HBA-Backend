package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class EDPUserMenuRightsAddedDto.
 */
public class EDPUserMenuRightsAddedDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp no. */
	private String empNo;
	
	/** The emp name. */
	private String empName;
	
	/** The post name. */
	private String postName;
	
	/** The post type. */
	private String postType;
	
	/** The module. */
	private String module;

	/** The module id. */
	private Long moduleId;

	/** The sub module. */
	private String subModule;

	/** The sub module id. */
	private Long subModuleId;
	
	/** The menu. */
	private String menu;
	 
	/** The permission. */
	private String permission;
	
	/** The wf role. */
	private String wfRole;

	/** The is removed. */
	private Long isRemoved;
	
	/** The added or removed rights. */
	private List<String> addedOrRemovedRights;
	
	/** The menu id. */
	private Long menuId;	

	/** The prm id. */
	private Long prmId;	

	/** The old prm id. */
	private Long oldPrmId;	

	/** The wf role ids. */
	private List<Long> wfRoleIds;	

	/** The old wf role ids. */
	private List<Long> oldWfRoleIds;	

	/** The wf roles. */
	private List<ClueDto> wfRoleList;

	/** The tusr rg map dtl id. */
	private Long tusrRgMapDtlId;

	/** The office id. */
	private Long officeId;
	
	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
	 * Gets the module.
	 *
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module.
	 *
	 * @param module the new module
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Gets the sub module.
	 *
	 * @return the sub module
	 */
	public String getSubModule() {
		return subModule;
	}

	/**
	 * Sets the sub module.
	 *
	 * @param subModule the new sub module
	 */
	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * Sets the menu.
	 *
	 * @param menu the new menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * Gets the permission.
	 *
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * Sets the permission.
	 *
	 * @param permission the new permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * Gets the wf role.
	 *
	 * @return the wf role
	 */
	public String getWfRole() {
		return wfRole;
	}

	/**
	 * Sets the wf role.
	 *
	 * @param wfRole the new wf role
	 */
	public void setWfRole(String wfRole) {
		this.wfRole = wfRole;
	}

	/**
	 * Gets the checks if is removed.
	 *
	 * @return the checks if is removed
	 */
	public Long getIsRemoved() {
		return isRemoved;
	}

	/**
	 * Sets the checks if is removed.
	 *
	 * @param isRemoved the new checks if is removed
	 */
	public void setIsRemoved(Long isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
	 * Gets the added or removed rights.
	 *
	 * @return the added or removed rights
	 */
	public List<String> getAddedOrRemovedRights() {
		return addedOrRemovedRights;
	}

	/**
	 * Sets the added or removed rights.
	 *
	 * @param addedOrRemovedRights the new added or removed rights
	 */
	public void setAddedOrRemovedRights(List<String> addedOrRemovedRights) {
		this.addedOrRemovedRights = addedOrRemovedRights;
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
	 * Gets the prm id.
	 *
	 * @return the prm id
	 */
	public Long getPrmId() {
		return prmId;
	}

	/**
	 * Sets the prm id.
	 *
	 * @param prmId the new prm id
	 */
	public void setPrmId(Long prmId) {
		this.prmId = prmId;
	}

	/**
	 * Gets the old prm id.
	 *
	 * @return the old prm id
	 */
	public Long getOldPrmId() {
		return oldPrmId;
	}

	/**
	 * Sets the old prm id.
	 *
	 * @param oldPrmId the new old prm id
	 */
	public void setOldPrmId(Long oldPrmId) {
		this.oldPrmId = oldPrmId;
	}

	/**
	 * Gets the wf role ids.
	 *
	 * @return the wf role ids
	 */
	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the new wf role ids
	 */
	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

	/**
	 * Gets the old wf role ids.
	 *
	 * @return the old wf role ids
	 */
	public List<Long> getOldWfRoleIds() {
		return oldWfRoleIds;
	}

	/**
	 * Sets the old wf role ids.
	 *
	 * @param oldWfRoleIds the new old wf role ids
	 */
	public void setOldWfRoleIds(List<Long> oldWfRoleIds) {
		this.oldWfRoleIds = oldWfRoleIds;
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
	 * Gets the wf role list.
	 *
	 * @return the wf role list
	 */
	public List<ClueDto> getWfRoleList() {
		return wfRoleList;
	}

	/**
	 * Sets the wf role list.
	 *
	 * @param wfRoleList the new wf role list
	 */
	public void setWfRoleList(List<ClueDto> wfRoleList) {
		this.wfRoleList = wfRoleList;
	}

	/**
	 * Gets the tusr rg map dtl id.
	 *
	 * @return the tusr rg map dtl id
	 */
	public Long getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * Sets the tusr rg map dtl id.
	 *
	 * @param tusrRgMapDtlId the new tusr rg map dtl id
	 */
	public void setTusrRgMapDtlId(Long tusrRgMapDtlId) {
		this.tusrRgMapDtlId = tusrRgMapDtlId;
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
	
}
