package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUSteppingUpInwardView.
 */
@NativeQueryResultEntity
public class PVUSteppingUpOfficeSearchView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The transaction no. */
	@NativeQueryResultColumn(index = 0)
	private String transNo;

	/** The employee id. */
	@NativeQueryResultColumn(index = 1)
	private Long employeeId;

	/** The employeeName. */
	@NativeQueryResultColumn(index = 2)
	private String employeeName;

	/** The designation */
	@NativeQueryResultColumn(index = 3)
	private String designationName;

	/** The employee class. */
	@NativeQueryResultColumn(index = 4)
	private String employeeClass;

	/** The office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The status. */
	@NativeQueryResultColumn(index = 6)
	private String status;

	/** The employee no. */
	@NativeQueryResultColumn(index = 7)
	private String employeeNumber;

	/** The record count. */
	@NativeQueryResultColumn(index = 8)
	private int recordCount;

	/** The eventId */
	@NativeQueryResultColumn(index = 9)
	private Long eventId;

	/** The created Date. */
	@NativeQueryResultColumn(index = 10)
	private Date createdDate;

	/** The isEditable . */
	@NativeQueryResultColumn(index = 11)
	private Integer isEditable;

	/** The eventName */
	@NativeQueryResultColumn(index = 12)
	private String eventName;

	/** The employee type. */
	@NativeQueryResultColumn(index = 13)
	private String empType;

	/** The wf status. */
	@NativeQueryResultColumn(index = 14)
	private String wfStatus;

	/** The deleteFlag */
	@NativeQueryResultColumn(index = 15)
	private Integer deleteFlag;

	/** The printFlag */
	@NativeQueryResultColumn(index = 16)
	private Integer printFlag;

	/** The authDate */
	@NativeQueryResultColumn(index = 17)
	private int authDate;

	/** The apprDate */
	@NativeQueryResultColumn(index = 18)
	private int apprDate;

	/** The inward created date. */
	@NativeQueryResultColumn(index = 19)
	private Date forwardDate;

	/** The inward number. */
	@NativeQueryResultColumn(index = 20)
	private String inwardNo;

	/** The inward date. */
	@NativeQueryResultColumn(index = 21)
	private Date inwardDate;

	/** The inward count. */
	@NativeQueryResultColumn(index = 22)
	private Integer inwardCount;

	@NativeQueryResultColumn(index = 23)
	private LocalDateTime refDate;

	private String eventCode = PvuConstant.EVENT_CODE_STEPPIN_UP;

	public Integer getInwardCount() {
		return inwardCount;
	}

	public void setInwardCount(Integer inwardCount) {
		this.inwardCount = inwardCount;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getEmployeeClass() {
		return employeeClass;
	}

	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
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

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Integer isEditable) {
		this.isEditable = isEditable;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}

	public int getAuthDate() {
		return authDate;
	}

	public void setAuthDate(int authDate) {
		this.authDate = authDate;
	}

	public int getApprDate() {
		return apprDate;
	}

	public void setApprDate(int apprDate) {
		this.apprDate = apprDate;
	}

	public Date getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(Date forwardDate) {
		this.forwardDate = forwardDate;
	}

	public String getInwardNo() {
		return inwardNo;
	}

	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @return the refDate
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apprDate, authDate, createdDate, deleteFlag, designationName, empType, employeeClass,
				employeeId, employeeName, employeeNumber, eventCode, eventId, eventName, forwardDate, inwardCount,
				inwardDate, inwardNo, isEditable, officeName, printFlag, recordCount, refDate, status, transNo,
				wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUSteppingUpOfficeSearchView)) {
			return false;
		}
		PVUSteppingUpOfficeSearchView other = (PVUSteppingUpOfficeSearchView) obj;
		return apprDate == other.apprDate && authDate == other.authDate
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(deleteFlag, other.deleteFlag)
				&& Objects.equals(designationName, other.designationName) && Objects.equals(empType, other.empType)
				&& Objects.equals(employeeClass, other.employeeClass) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeNumber, other.employeeNumber) && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(forwardDate, other.forwardDate) && Objects.equals(inwardCount, other.inwardCount)
				&& Objects.equals(inwardDate, other.inwardDate) && Objects.equals(inwardNo, other.inwardNo)
				&& Objects.equals(isEditable, other.isEditable) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(printFlag, other.printFlag) && recordCount == other.recordCount
				&& Objects.equals(refDate, other.refDate) && Objects.equals(status, other.status)
				&& Objects.equals(transNo, other.transNo) && Objects.equals(wfStatus, other.wfStatus);
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

}
