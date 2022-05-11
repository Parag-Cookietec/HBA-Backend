package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsGivenRemovalDto.
 */
@NativeQueryResultEntity
public class EDPWfRolesMenuDto {
	
	/** The menu id. */
	@NativeQueryResultColumn(index = 0)
	private String menuId;

	@NativeQueryResultColumn(index = 1)
	private String wfRoleId;
	
	@NativeQueryResultColumn(index = 2)
	private String workFlowName;
	
	@NativeQueryResultColumn(index = 3)
	private String statusId;

	@NativeQueryResultColumn(index = 4)
	private String statusName;
	
	@NativeQueryResultColumn(index = 5)
	private String isRemoved;
	
	/** The sub module id. */
	@NativeQueryResultColumn(index = 6)
	private String subModuleId;

	/** The sub module name. */
	@NativeQueryResultColumn(index = 7)
	private String subModuleName;
	
	/** The module id. */
	@NativeQueryResultColumn(index = 8)
	private String moduleId;

	/** The module name. */
	@NativeQueryResultColumn(index = 9)
	private String moduleName;
	
	@NativeQueryResultColumn(index = 10)
	private String empName;
	
	@NativeQueryResultColumn(index = 11)
	private String empNo;
	
	@NativeQueryResultColumn(index = 12)
	private String postName;
	
	@NativeQueryResultColumn(index = 13)
	private Long rgMapId;
	
	@NativeQueryResultColumn(index = 14)
	private String lkUsrMenuId;
	
	@NativeQueryResultColumn(index = 15)
	private String createdBy;
	
	@NativeQueryResultColumn(index = 16)
	private String createdByPostName;
	
	@NativeQueryResultColumn(index = 17)
	private String createdByPostId;
	
	

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

	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
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

	public String getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

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

	public String getCreatedBy() {
		return createdBy;
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

	public Long getRgMapId() {
		return rgMapId;
	}

	public void setRgMapId(Long rgMapId) {
		this.rgMapId = rgMapId;
	}

	public String getLkUsrMenuId() {
		return lkUsrMenuId;
	}

	public void setLkUsrMenuId(String lkUsrMenuId) {
		this.lkUsrMenuId = lkUsrMenuId;
	}
	
	

	
	
	
	
	
	
	

	
	

}
