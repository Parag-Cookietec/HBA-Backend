package gov.ifms.edp.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsGivenRemovalDto.
 */
@NativeQueryResultEntity
public class EDPUserRightsGivenRemovalDto {

	/** The employee id. */
	@NativeQueryResultColumn(index = 0)
	private String employeeId;
	
	/** The employee name. */
	@NativeQueryResultColumn(index = 1)
	private String employeeName;
	
	/** The employee number. */
	@NativeQueryResultColumn(index = 2)
	private String employeeNumber;
	
	/** The is rights removed. */
	@NativeQueryResultColumn(index = 3)
	private String isRightsRemoved;
	
	/** The post id. */
	@NativeQueryResultColumn(index = 4)
	private String postId;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 5)
	private String postName;
	
	/** The primary post. */
	@NativeQueryResultColumn(index = 6)
	private String primaryPost;
	
	/** The menu id. */
	@NativeQueryResultColumn(index = 7)
	private String menuId;
	
	/** The menu name. */
	@NativeQueryResultColumn(index = 8)
	private String menuName;
	
	/** The module id. */
	@NativeQueryResultColumn(index = 9)
	private long moduleId;
	
	/** The module name. */
	@NativeQueryResultColumn(index = 10)
	private String moduleName;
	
	/** The sub module id. */
	@NativeQueryResultColumn(index = 11)
	private String subModuleId;
	
	/** The sub module name. */
	@NativeQueryResultColumn(index = 12)
	private String subModuleName;
	
	/** The role prm id. */
	@NativeQueryResultColumn(index = 13)
	private String rolePrmId;
	
	/** The role prm name. */
	@NativeQueryResultColumn(index = 14)
	private String rolePrmName;
	
	/** The branch id. */
	@NativeQueryResultColumn(index = 15)
	private String branchId;
	
	/** The branch name. */
	@NativeQueryResultColumn(index = 16)
	private String branchName;
	
	/** The trn usr role prm id. */
	@NativeQueryResultColumn(index = 17)
	private String trnUsrRolePrmId;


	/** The post office user id. */
	@NativeQueryResultColumn(index = 18)
	private String postOfficeUserId;
	
	/** The transaction number. */
	@NativeQueryResultColumn(index = 19)
	private String transactionNumber;

	/** The created date. */
	@NativeQueryResultColumn(index = 20)
	private Date createdDate;
	
	/** The submmission status id. */
	@NativeQueryResultColumn(index = 21)
	private String submmissionStatusId;
	
	/** The submmission status name. */
	@NativeQueryResultColumn(index = 22)
	private String submmissionStatusName;
	
	@NativeQueryResultColumn(index = 23)
	private String lkUsrMenuId;
	
	@NativeQueryResultColumn(index = 24)
	private String workFlowId;
	
	@NativeQueryResultColumn(index = 25)
	private String workFlowName;
	
	@NativeQueryResultColumn(index = 26)
	private String trnUsrWfRoleId;
	
	private String isRightsRemovedWf;
	
	
	public String getIsRightsRemovedWf() {
		return isRightsRemovedWf;
	}

	public void setIsRightsRemovedWf(String isRightsRemovedWf) {
		this.isRightsRemovedWf = isRightsRemovedWf;
	}

	private long userRoleMappingId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getIsRightsRemoved() {
		return isRightsRemoved;
	}

	public void setIsRightsRemoved(String isRightsRemoved) {
		this.isRightsRemoved = isRightsRemoved;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPrimaryPost() {
		return primaryPost;
	}

	public void setPrimaryPost(String primaryPost) {
		this.primaryPost = primaryPost;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public String getRolePrmId() {
		return rolePrmId;
	}

	public void setRolePrmId(String rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	public String getRolePrmName() {
		return rolePrmName;
	}

	public void setRolePrmName(String rolePrmName) {
		this.rolePrmName = rolePrmName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getTrnUsrRolePrmId() {
		return trnUsrRolePrmId;
	}

	public void setTrnUsrRolePrmId(String trnUsrRolePrmId) {
		this.trnUsrRolePrmId = trnUsrRolePrmId;
	}

	public String getPostOfficeUserId() {
		return postOfficeUserId;
	}

	public void setPostOfficeUserId(String postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getSubmmissionStatusId() {
		return submmissionStatusId;
	}

	public void setSubmmissionStatusId(String submmissionStatusId) {
		this.submmissionStatusId = submmissionStatusId;
	}

	public String getSubmmissionStatusName() {
		return submmissionStatusName;
	}

	public void setSubmmissionStatusName(String submmissionStatusName) {
		this.submmissionStatusName = submmissionStatusName;
	}

	public String getLkUsrMenuId() {
		return lkUsrMenuId;
	}

	public void setLkUsrMenuId(String lkUsrMenuId) {
		this.lkUsrMenuId = lkUsrMenuId;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getTrnUsrWfRoleId() {
		return trnUsrWfRoleId;
	}

	public void setTrnUsrWfRoleId(String trnUsrWfRoleId) {
		this.trnUsrWfRoleId = trnUsrWfRoleId;
	}

	public long getUserRoleMappingId() {
		return userRoleMappingId;
	}

	public void setUserRoleMappingId(long userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	@Override
	public String toString() {
		return "EDPUserRightsGivenRemovalDto [employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeeNumber=" + employeeNumber + ", isRightsRemoved=" + isRightsRemoved + ", postId=" + postId
				+ ", postName=" + postName + ", primaryPost=" + primaryPost + ", menuId=" + menuId + ", menuName="
				+ menuName + ", moduleId=" + moduleId + ", moduleName=" + moduleName + ", subModuleId=" + subModuleId
				+ ", subModuleName=" + subModuleName + ", rolePrmId=" + rolePrmId + ", rolePrmName=" + rolePrmName
				+ ", branchId=" + branchId + ", branchName=" + branchName + ", trnUsrRolePrmId=" + trnUsrRolePrmId
				+ ", postOfficeUserId=" + postOfficeUserId + ", transactionNumber=" + transactionNumber
				+ ", createdDate=" + createdDate + ", submmissionStatusId=" + submmissionStatusId
				+ ", submmissionStatusName=" + submmissionStatusName + ", lkUsrMenuId=" + lkUsrMenuId + ", workFlowId="
				+ workFlowId + ", workFlowName=" + workFlowName + ", trnUsrWfRoleId=" + trnUsrWfRoleId
				+ ", userRoleMappingId=" + userRoleMappingId + "]";
	}
	
}
