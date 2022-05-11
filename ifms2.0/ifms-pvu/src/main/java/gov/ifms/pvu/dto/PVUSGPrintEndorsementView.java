package gov.ifms.pvu.dto;

import static gov.ifms.pvu.util.PvuConstant.EVENT_CODE_SELECTION_GRAD;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

@NativeQueryResultEntity
public class PVUSGPrintEndorsementView implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String transNo;

	@NativeQueryResultColumn(index = 1)
	private Date inwardDate;

	@NativeQueryResultColumn(index = 2)
	private String inwardNumber;

	@NativeQueryResultColumn(index = 3)
	private String eventName;

	@NativeQueryResultColumn(index = 4)
	private String employeeNo;

	@NativeQueryResultColumn(index = 5)
	private String employeeName;

	@NativeQueryResultColumn(index = 6)
	private String designation;

	@NativeQueryResultColumn(index = 7)
	private Date retirementDate;

	@NativeQueryResultColumn(index = 8)
	private String officeName;

	@NativeQueryResultColumn(index = 9)
	private Long id; // trnId

	@NativeQueryResultColumn(index = 10)
	private String status;

	@NativeQueryResultColumn(index = 11)
	private Date authorizationDate;

	@NativeQueryResultColumn(index = 12)
	private String wfStatus;

	@NativeQueryResultColumn(index = 13)
	private Long printEndId;

	@NativeQueryResultColumn(index = 14)
	private Integer printCnt;

	@NativeQueryResultColumn(index = 15)
	private int isPrint;

	@NativeQueryResultColumn(index = 16)
	private long empId;

	@NativeQueryResultColumn(index = 17)
	private Date effectiveDate;

	@NativeQueryResultColumn(index = 18)
	private long eventId;
	
	private String eventCode = EVENT_CODE_SELECTION_GRAD;

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
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

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

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
	 * Gets the authorization date.
	 *
	 * @return the authorization date
	 */
	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	/**
	 * Sets the authorization date.
	 *
	 * @param authorizationDate the new authorization date
	 */
	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
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

	/**
	 * Gets the prints the end id.
	 *
	 * @return the prints the end id
	 */
	public Long getPrintEndId() {
		return printEndId;
	}

	/**
	 * Sets the prints the end id.
	 *
	 * @param printEndId the new prints the end id
	 */
	public void setPrintEndId(Long printEndId) {
		this.printEndId = printEndId;
	}

	/**
	 * Gets the prints the cnt.
	 *
	 * @return the prints the cnt
	 */
	public Integer getPrintCnt() {
		return printCnt;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Sets the prints the cnt.
	 *
	 * @param printCnt the new prints the cnt
	 */
	public void setPrintCnt(Integer printCnt) {
		this.printCnt = printCnt;
	}

	/**
	 * Gets the checks if is print.
	 *
	 * @return the checks if is print
	 */
	public int getIsPrint() {
		return isPrint;
	}

	/**
	 * Sets the checks if is print.
	 *
	 * @param isPrint the new checks if is print
	 */
	public void setIsPrint(int isPrint) {
		this.isPrint = isPrint;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
