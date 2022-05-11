package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUEmployeEOLeaveView.
 *
 * @version v 1.0
 * @created 2019 /11/22 03:23:32
 */
@NativeQueryResultEntity
public class PVUAssuredCareerProgSearchView implements Serializable {

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


	@NativeQueryResultColumn(index = 13)
	private String ropType;

	@NativeQueryResultColumn(index = 14)
	private String empType;

	@NativeQueryResultColumn(index = 12)
	private String trnStatus;

	@NativeQueryResultColumn(index = 15)
	private String wfStatus;

	@NativeQueryResultColumn(index = 16)
	private Integer deleteFlag;

	@NativeQueryResultColumn(index = 17)
	private Integer printFlag;

	@NativeQueryResultColumn(index = 18)
	private Date approveDate;

	@NativeQueryResultColumn(index = 19)
	private Date authorizeDate;

	@NativeQueryResultColumn(index = 20)
	private Date forwardDate;


	@NativeQueryResultColumn(index = 21)
	private String inwardNo;

	@NativeQueryResultColumn(index = 22)
	private Date inwardDate;

	@NativeQueryResultColumn(index = 23)
	private Date effectiveDate;

	/**
	 * Gets effective date.
	 *
	 * @return the effective date
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets effective date.
	 *
	 * @param effectiveDate the effective date
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets inward date.
	 *
	 * @return the inward date
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets inward date.
	 *
	 * @param inwardDate the inward date
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets forward date.
	 *
	 * @return the forward date
	 */
	public Date getForwardDate() {
		return forwardDate;
	}

	/**
	 * Sets forward date.
	 *
	 * @param forwardDate the forward date
	 */
	public void setForwardDate(Date forwardDate) {
		this.forwardDate = forwardDate;
	}

	/**
	 * Gets inward no.
	 *
	 * @return the inward no
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets inward no.
	 *
	 * @param inwardNo the inward no
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets print flag.
	 *
	 * @return the print flag
	 */
	public Integer getPrintFlag() {
		return printFlag;
	}

	/**
	 * Sets print flag.
	 *
	 * @param printFlag the print flag
	 */
	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}

	/**
	 * Gets delete flag.
	 *
	 * @return the delete flag
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * Sets delete flag.
	 *
	 * @param deleteFlag the delete flag
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * Gets trn status.
	 *
	 * @return the trn status
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets trn status.
	 *
	 * @param trnStatus the trn status
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * Gets emp type.
	 *
	 * @return the emp type
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * Sets emp type.
	 *
	 * @param empType the emp type
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * Gets rop type.
	 *
	 * @return the rop type
	 */
	public String getRopType() {
		return ropType;
	}

	/**
	 * Sets rop type.
	 *
	 * @param ropType the rop type
	 */
	public void setRopType(String ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets trans no.
	 *
	 * @return the transNo
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets trans no.
	 *
	 * @param transNo the transNo to set
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * Gets employee id.
	 *
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets employee name.
	 *
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets employee name.
	 *
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets class name.
	 *
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets class name.
	 *
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets employee number.
	 *
	 * @return the employeeNumber
	 */
	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * Sets employee number.
	 *
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * Gets record count.
	 *
	 * @return the recordCount
	 */
	public Integer getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Gets event id.
	 *
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Sets event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets created date.
	 *
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets created date.
	 *
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets is editable.
	 *
	 * @return the isEditable
	 */
	public Integer getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets is editable.
	 *
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(Integer isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets approve date.
	 *
	 * @return the approve date
	 */
	public Date getApproveDate() {
		return approveDate;
	}

	/**
	 * Sets approve date.
	 *
	 * @param approveDate the approve date
	 */
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * Gets authorize date.
	 *
	 * @return the authorize date
	 */
	public Date getAuthorizeDate() {
		return authorizeDate;
	}

	/**
	 * Sets authorize date.
	 *
	 * @param authorizeDate the authorize date
	 */
	public void setAuthorizeDate(Date authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	@Override
	public String toString() {
		return "PVURevisionOfPaySearchView{" +
				"transNo='" + transNo + '\'' +
				", employeeId=" + employeeId +
				", employeeName='" + employeeName + '\'' +
				", designationName='" + designationName + '\'' +
				", className='" + className + '\'' +
				", officeName='" + officeName + '\'' +
				", status='" + status + '\'' +
				", employeeNumber=" + employeeNumber +
				", recordCount=" + recordCount +
				", eventId=" + eventId +
				", createdDate=" + createdDate +
				", isEditable=" + isEditable +
				", ropType='" + ropType + '\'' +
				", empType='" + empType + '\'' +
				", trnStatus='" + trnStatus + '\'' +
				", wfStatus='" + wfStatus + '\'' +
				", deleteFlag=" + deleteFlag +
				", printFlag=" + printFlag +
				", approveDate=" + approveDate +
				", authorizeDate=" + authorizeDate +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUAssuredCareerProgSearchView that = (PVUAssuredCareerProgSearchView) o;
		return Objects.equals(transNo, that.transNo) &&
				Objects.equals(employeeId, that.employeeId) &&
				Objects.equals(employeeName, that.employeeName) &&
				Objects.equals(designationName, that.designationName) &&
				Objects.equals(className, that.className) &&
				Objects.equals(officeName, that.officeName) &&
				Objects.equals(status, that.status) &&
				Objects.equals(employeeNumber, that.employeeNumber) &&
				Objects.equals(recordCount, that.recordCount) &&
				Objects.equals(eventId, that.eventId) &&
				Objects.equals(createdDate, that.createdDate) &&
				Objects.equals(isEditable, that.isEditable) &&
				Objects.equals(ropType, that.ropType) &&
				Objects.equals(empType, that.empType) &&
				Objects.equals(trnStatus, that.trnStatus) &&
				Objects.equals(wfStatus, that.wfStatus) &&
				Objects.equals(deleteFlag, that.deleteFlag) &&
				Objects.equals(printFlag, that.printFlag) &&
				Objects.equals(approveDate, that.approveDate) &&
				Objects.equals(authorizeDate, that.authorizeDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transNo, employeeId, employeeName, designationName, className, officeName, status, employeeNumber, recordCount, eventId, createdDate, isEditable, ropType, empType, trnStatus, wfStatus, deleteFlag, printFlag, approveDate, authorizeDate);
	}
}
