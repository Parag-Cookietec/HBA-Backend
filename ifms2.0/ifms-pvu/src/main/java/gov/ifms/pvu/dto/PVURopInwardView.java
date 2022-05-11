package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class PVURopInwardView.
 */
@NativeQueryResultEntity
public class PVURopInwardView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trans no. */
	@NativeQueryResultColumn(index = 0)
	private String transNo;

	/** The inward date. */
	@NativeQueryResultColumn(index = 1)
	private Date inwardDate;

	/** The inward number. */
	@NativeQueryResultColumn(index = 2)
	private String inwardNumber;

	/** The event name. */
	@NativeQueryResultColumn(index = 3)
	private String eventName;

	/** The employee no. */
	@NativeQueryResultColumn(index = 4)
	private String employeeNo;

	/** The employee name. */
	@NativeQueryResultColumn(index = 5)
	private String employeeName;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private String designation;

	/** The retirement date. */
	@NativeQueryResultColumn(index = 7)
	private Date retirementDate;

	/** The employee type. */
	@NativeQueryResultColumn(index = 8)
	private String employeeType;

	/** The office name. */
	@NativeQueryResultColumn(index = 9)
	private String officeName;

	/** The inward id. */
	@NativeQueryResultColumn(index = 10)
	private String ropEventId;

	/** The wf status. */
	@NativeQueryResultColumn(index = 11)
	private String status;

	/** The forwarded date. */
	@NativeQueryResultColumn(index = 12)
	private Date forwardedDate;

	/** The wf status. */
	@NativeQueryResultColumn(index = 13)
	private String wfStatus;

	@NativeQueryResultColumn(index = 14)
	private int inwardCount;

	/**
	 * @return
	 */
	public int getInwardCount() {
		return inwardCount;
	}

	/**
	 * @param inwardCount
	 */
	public void setInwardCount(int inwardCount) {
		this.inwardCount = inwardCount;
	}

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
	 * Gets the inward date.
	 *
	 * @return the inward date
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the new inward date
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the inward number.
	 *
	 * @return the inward number
	 */
	public String getInwardNumber() {
		return inwardNumber;
	}

	/**
	 * Sets the inward number.
	 *
	 * @param inwardNumber the new inward number
	 */
	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the new event name
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employee no
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the new employee no
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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
	 * Gets the retirement date.
	 *
	 * @return the retirement date
	 */
	public Date getRetirementDate() {
		return retirementDate;
	}

	/**
	 * Sets the retirement date.
	 *
	 * @param retirementDate the new retirement date
	 */
	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * Gets the employee type.
	 *
	 * @return the employee type
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * Sets the employee type.
	 *
	 * @param employeeType the new employee type
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
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
	 * Gets the rop event id.
	 *
	 * @return the rop event id
	 */
	public String getRopEventId() {
		return ropEventId;
	}

	/**
	 * Sets the rop event id.
	 *
	 * @param ropEventId the new rop event id
	 */
	public void setRopEventId(String ropEventId) {
		this.ropEventId = ropEventId;
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
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the forwarded date.
	 *
	 * @return the forwarded date
	 */
	public Date getForwardedDate() {
		return forwardedDate;
	}

	/**
	 * Sets the forwarded date.
	 *
	 * @param forwardedDate the new forwarded date
	 */
	public void setForwardedDate(Date forwardedDate) {
		this.forwardedDate = forwardedDate;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
}
