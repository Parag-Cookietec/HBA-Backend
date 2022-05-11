package gov.ifms.edp.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUserRightsGivenRemovalDto.
 */
@NativeQueryResultEntity
public class EDPWfRolesDto {

	@NativeQueryResultColumn(index = 0)
	private String lkUsrMenuId;

	@NativeQueryResultColumn(index = 1)
	private String workFlowId;

	@NativeQueryResultColumn(index = 2)
	private String workFlowName;
	
	@NativeQueryResultColumn(index = 3)
	private String trnUsrWfRoleId;
	
	/** The employee id. */
	@NativeQueryResultColumn(index = 4)
	private String employeeId;
	
	/** The employee name. */
	@NativeQueryResultColumn(index = 5)
	private String employeeName;
	
	/** The employee number. */
	@NativeQueryResultColumn(index = 6)
	private String employeeNumber;
	
	/** The is rights removed. */
	@NativeQueryResultColumn(index = 7)
	private String isRightsRemoved;
	
	/** The post id. */
	@NativeQueryResultColumn(index = 8)
	private String postId;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 9)
	private String postName;
	
	/** The primary post. */
	@NativeQueryResultColumn(index = 10)
	private String primaryPost;
	
	/** The menu id. */
	@NativeQueryResultColumn(index = 11)
	private String menuId;
	
	/** The menu name. */
	@NativeQueryResultColumn(index = 12)
	private String menuName;
	
	/** The module id. */
	@NativeQueryResultColumn(index = 13)
	private long moduleId;
	
	/** The module name. */
	@NativeQueryResultColumn(index = 14)
	private String moduleName;
	
	/** The sub module id. */
	@NativeQueryResultColumn(index = 15)
	private String subModuleId;
	
	/** The sub module name. */
	@NativeQueryResultColumn(index = 16)
	private String subModuleName;
	
	

	/** The post office user id. */
	@NativeQueryResultColumn(index = 17)
	private String postOfficeUserId;
	
	/** The transaction number. */
	@NativeQueryResultColumn(index = 18)
	private String transactionNumber;

	/** The created date. */
	@NativeQueryResultColumn(index = 19)
	private Date createdDate;
	
	/** The submmission status id. */
	@NativeQueryResultColumn(index = 20)
	private String submmissionStatusId;
	
	/** The submmission status name. */
	@NativeQueryResultColumn(index = 21)
	private String submmissionStatusName;

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

	@Override
	public String toString() {
		return "EDPWfRolesDto [lkUsrMenuId=" + lkUsrMenuId + ", workFlowId=" + workFlowId + ", workFlowName="
				+ workFlowName + ", trnUsrWfRoleId=" + trnUsrWfRoleId + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeNumber=" + employeeNumber + ", isRightsRemoved=" + isRightsRemoved
				+ ", postId=" + postId + ", postName=" + postName + ", primaryPost=" + primaryPost + ", menuId="
				+ menuId + ", menuName=" + menuName + ", moduleId=" + moduleId + ", moduleName=" + moduleName
				+ ", subModuleId=" + subModuleId + ", subModuleName=" + subModuleName + ", postOfficeUserId="
				+ postOfficeUserId + ", transactionNumber=" + transactionNumber + ", createdDate=" + createdDate
				+ ", submmissionStatusId=" + submmissionStatusId + ", submmissionStatusName=" + submmissionStatusName
				+ "]";
	}

	
	

}
