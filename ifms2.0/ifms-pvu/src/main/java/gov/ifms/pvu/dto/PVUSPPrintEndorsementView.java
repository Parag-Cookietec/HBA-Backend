package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUSPPrintEndorsementView implements Serializable {
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

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;

	/** The rop event id. */
	@NativeQueryResultColumn(index = 9)
	private String id;

	/** The status. */
	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The authorization date. */
	@NativeQueryResultColumn(index = 11)
	private Date authorizationDate;

	/** The wf status. */
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;

	/** The print end id. */
	@NativeQueryResultColumn(index = 13)
	private Long printEndId;

	/** The print cnt. */
	@NativeQueryResultColumn(index = 14)
	private Integer printCnt;

	/** The is print. */
	@NativeQueryResultColumn(index = 15)
	private int isPrint;

	/** The emp id. */
	@NativeQueryResultColumn(index = 16)
	private long empId;

	@NativeQueryResultColumn(index = 17)
	private Date effectiveDate;

	@NativeQueryResultColumn(index = 18)
	private long eventId;

	private String eventCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getInwardNumber() {
		return inwardNumber;
	}

	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Long getPrintEndId() {
		return printEndId;
	}

	public void setPrintEndId(Long printEndId) {
		this.printEndId = printEndId;
	}

	public Integer getPrintCnt() {
		return printCnt;
	}

	public void setPrintCnt(Integer printCnt) {
		this.printCnt = printCnt;
	}

	public int getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(int isPrint) {
		this.isPrint = isPrint;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

}
