package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;


/**
 * The Class PVUForgoView.
 */
public class PVUForgoView implements Serializable{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@NativeQueryResultColumn(index = 0)
	private String eventId;

	/** The trans no. */
	@NativeQueryResultColumn(index = 1)
	private String transNo;

	/** The event name. */
	@NativeQueryResultColumn(index = 2)
	private String eventName;

	/** The emp no. */
	@NativeQueryResultColumn(index = 3)
	private String empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 4)
	private String empName;

	/** The designation. */
	@NativeQueryResultColumn(index = 5)
	private String designation;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private String empClass;

	/** The employee Type. */
	@NativeQueryResultColumn(index = 7)
	private String empType;

	/** The pan no. */
	@NativeQueryResultColumn(index = 8)
	private String panNo;

	/** The office name. */
	@NativeQueryResultColumn(index = 9)
	private String officeName;

	/** The status. */
	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The retirement date. */
	@NativeQueryResultColumn(index = 11)
	private String retirementDate;

	/** The record count. */
	@NativeQueryResultColumn(index = 12)
	private String recordCount;
	
	/** The updated date. */
	@NativeQueryResultColumn(index=13)
	private String updatedDate;
	
	/** The is editable. */
	@NativeQueryResultColumn(index=14)
	private String isEditable;
	
	/** The workflow status. */
	@NativeQueryResultColumn(index=15)
	private String workflowStatus;

	/**
	 * Gets the event id.
	 *
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the trans no.
	 *
	 * @return the transNo
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param transNo the transNo to set
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the empClass
	 */
	public String getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(String empClass) {
		this.empClass = empClass;
	}

	/**
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * Gets the pan no.
	 *
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * Sets the pan no.
	 *
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the retirement date.
	 *
	 * @return the retirementDate
	 */
	public String getRetirementDate() {
		return retirementDate;
	}

	/**
	 * Sets the retirement date.
	 *
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * Gets the record count.
	 *
	 * @return the recordCount
	 */
	public String getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public String getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the workflow status.
	 *
	 * @return the workflow status
	 */
	public String getWorkflowStatus() {
		return workflowStatus;
	}

	/**
	 * Sets the workflow status.
	 *
	 * @param workflowStatus the new workflow status
	 */
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	
	
}
