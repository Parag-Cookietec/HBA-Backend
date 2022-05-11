package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeEOLeaveView.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@NativeQueryResultEntity
public class PVUEmployeSuspensionView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trans no. */
	@NativeQueryResultColumn(index = 0)
	private String transNo;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private String empId;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	/** The employee class. */
	@NativeQueryResultColumn(index = 3)
	private String employeeClass;

	/** The designation. */
	@NativeQueryResultColumn(index = 4)
	private String designation;

	/** The office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The start date. */
	@NativeQueryResultColumn(index = 6)
	private String payCommission;

	/** The end date. */
	@NativeQueryResultColumn(index = 7)
	private Date startDate;

	/** The emp no. */
	@NativeQueryResultColumn(index = 8)
	private String empNo;

	/** The no of days. */
	@NativeQueryResultColumn(index = 9)
	private String reasonForSus;

	/** The no of days. */
	@NativeQueryResultColumn(index = 10)
	private long suspensionId;

	@NativeQueryResultColumn(index = 11)
	private String workflowStatus;

	@NativeQueryResultColumn(index = 12)
	private long isEditable;

	@NativeQueryResultColumn(index = 13)
	private long isSuspensionClose;

	@NativeQueryResultColumn(index = 14)
	private String updateDate;

	@NativeQueryResultColumn(index = 15)
	private String status;

	/**
	 * Gets the trans no.
	 *
	 * @return the trans no
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param transNo the new trans no
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
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
	 * Gets the employee class.
	 *
	 * @return the employee class
	 */
	public String getEmployeeClass() {
		return employeeClass;
	}

	/**
	 * Sets the employee class.
	 *
	 * @param employeeClass the new employee class
	 */
	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

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
	 * Gets the suspension id.
	 *
	 * @return the suspension id
	 */
	public long getSuspensionId() {
		return suspensionId;
	}

	/**
	 * Sets the suspension id.
	 *
	 * @param suspensionId the new suspension id
	 */
	public void setSuspensionId(long suspensionId) {
		this.suspensionId = suspensionId;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the pay commission
	 */
	public String getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the new pay commission
	 */
	public void setPayCommission(String payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * Gets the reason for sus.
	 *
	 * @return the reason for sus
	 */
	public String getReasonForSus() {
		return reasonForSus;
	}

	/**
	 * Sets the reason for sus.
	 *
	 * @param reasonForSus the new reason for sus
	 */
	public void setReasonForSus(String reasonForSus) {
		this.reasonForSus = reasonForSus;
	}

	public String getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public long getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(long isEditable) {
		this.isEditable = isEditable;
	}

	public long getIsSuspensionClose() {
		return isSuspensionClose;
	}

	public void setIsSuspensionClose(long isSuspensionClose) {
		this.isSuspensionClose = isSuspensionClose;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {	return status;	}

	public void setStatus(String status) {		this.status = status;	}
}

