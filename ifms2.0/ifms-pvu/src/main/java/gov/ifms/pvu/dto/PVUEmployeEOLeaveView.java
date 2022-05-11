package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;


/**
 * The Class PVUEmployeEOLeaveView.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@NativeQueryResultEntity
public class PVUEmployeEOLeaveView implements Serializable {
	
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

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;
	
	/** The employee class. */
	@NativeQueryResultColumn(index = 4)
	private String employeeClass;

	/** The start date. */
	@NativeQueryResultColumn(index = 5)
	private String startDate;
	
	/** The end date. */
	@NativeQueryResultColumn(index = 6)
	private String endDate;
	
	/** The no of days. */
	@NativeQueryResultColumn(index = 7)
	private Integer noOfDays;
	

	
	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;
	

	@NativeQueryResultColumn(index = 9)
	private String status;
	
	/** The emp no. */
	@NativeQueryResultColumn(index = 10)
	private String empNo;
	
	/** The record count. */
	@NativeQueryResultColumn(index = 11)
	private String recordCount;
	
	/** The emp eol id. */
	@NativeQueryResultColumn(index = 12)
	private String empEolId;
	
	/** The emp eol id. */
	@NativeQueryResultColumn(index = 13)
	private String updatedDate;
	
	/** The isEditable. */
	@NativeQueryResultColumn(index = 14)
	private long isEditable;
	
	@NativeQueryResultColumn(index = 15)
	private String workflowStatus;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the transNo
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * @param transNo the transNo to set
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the employeeClass
	 */
	public String getEmployeeClass() {
		return employeeClass;
	}

	/**
	 * @param employeeClass the employeeClass to set
	 */
	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the noOfDays
	 */
	public Integer getNoOfDays() {
		return noOfDays;
	}

	/**
	 * @param noOfDays the noOfDays to set
	 */
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	
	/**
	 * @return the workflowStatus
	 */
	public String getWorkflowStatus() {
		return workflowStatus;
	}

	/**
	 * @param workflowStatus the workflowStatus to set
	 */
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the recordCount
	 */
	public String getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the empEolId
	 */
	public String getEmpEolId() {
		return empEolId;
	}

	/**
	 * @param empEolId the empEolId to set
	 */
	public void setEmpEolId(String empEolId) {
		this.empEolId = empEolId;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the isEditable
	 */
	public long getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(long isEditable) {
		this.isEditable = isEditable;
	}
	

}
