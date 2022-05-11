package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUSelectionGradeOfficeSearchView implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String transNo;

	@NativeQueryResultColumn(index = 1)
	private Long employeeId;

	@NativeQueryResultColumn(index = 2)
	private String employeeName;

	@NativeQueryResultColumn(index = 3)
	private String designationName;

	@NativeQueryResultColumn(index = 4)
	private String className;

	@NativeQueryResultColumn(index = 5)
	private String officeName;

	@NativeQueryResultColumn(index = 6)
	private String status;

	@NativeQueryResultColumn(index = 7)
	private Long employeeNumber;

	@NativeQueryResultColumn(index = 8)
	private Integer recordCount;

	@NativeQueryResultColumn(index = 9)
	private Long eventId;

	@NativeQueryResultColumn(index = 10)
	private Date createdDate;

	@NativeQueryResultColumn(index = 11)
	private Integer isEditable;

	@NativeQueryResultColumn(index = 12)
	private String eventName;

	@NativeQueryResultColumn(index = 13)
	private String empType;

	@NativeQueryResultColumn(index = 14)
	private String wfStatus;

	@NativeQueryResultColumn(index = 15)
	private Integer deleteFlag;

	@NativeQueryResultColumn(index = 16)
	private Integer printFlag;

	@NativeQueryResultColumn(index = 17)
	private Date approveDate;

	@NativeQueryResultColumn(index = 18)
	private Date authorizeDate;

	@NativeQueryResultColumn(index = 19)
	private Date forwardDate;

	@NativeQueryResultColumn(index = 20)
	private String inwardNo;

	@NativeQueryResultColumn(index = 21)
	private Date inwardDate;

	@NativeQueryResultColumn(index = 22)
	private Integer inwardCount;

	@NativeQueryResultColumn(index = 23)
	private LocalDateTime refDate;
	private String eventCode;

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
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

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Date getAuthorizeDate() {
		return authorizeDate;
	}

	public void setAuthorizeDate(Date authorizeDate) {
		this.authorizeDate = authorizeDate;
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

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the inwardCount
	 */
	public Integer getInwardCount() {
		return inwardCount;
	}

	/**
	 * @param inwardCount the inwardCount to set
	 */
	public void setInwardCount(Integer inwardCount) {
		this.inwardCount = inwardCount;
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
		return Objects.hash(approveDate, authorizeDate, className, createdDate, deleteFlag, designationName, empType,
				employeeId, employeeName, employeeNumber, eventCode, eventId, eventName, forwardDate, inwardCount,
				inwardDate, inwardNo, isEditable, officeName, printFlag, recordCount, refDate, status, transNo,
				wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUSelectionGradeOfficeSearchView)) {
			return false;
		}
		PVUSelectionGradeOfficeSearchView other = (PVUSelectionGradeOfficeSearchView) obj;
		return Objects.equals(approveDate, other.approveDate) && Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(className, other.className) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(deleteFlag, other.deleteFlag)
				&& Objects.equals(designationName, other.designationName) && Objects.equals(empType, other.empType)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeNumber, other.employeeNumber) && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(forwardDate, other.forwardDate) && Objects.equals(inwardCount, other.inwardCount)
				&& Objects.equals(inwardDate, other.inwardDate) && Objects.equals(inwardNo, other.inwardNo)
				&& Objects.equals(isEditable, other.isEditable) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(printFlag, other.printFlag) && Objects.equals(recordCount, other.recordCount)
				&& Objects.equals(refDate, other.refDate) && Objects.equals(status, other.status)
				&& Objects.equals(transNo, other.transNo) && Objects.equals(wfStatus, other.wfStatus);
	}

}
