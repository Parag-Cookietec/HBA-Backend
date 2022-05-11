package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUMISCaseInqReportsVIew implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long totalRowCount;
	@NativeQueryResultColumn(index = 1)
	private Long caseId;
	@NativeQueryResultColumn(index = 2)
	private String inwardNumber;
	@NativeQueryResultColumn(index = 3)
	private Date inwardDate;
	@NativeQueryResultColumn(index = 4)
	private Long employeeNo;
	@NativeQueryResultColumn(index = 5)
	private String employeeName;
	@NativeQueryResultColumn(index = 6)
	private Date retirementDate;
	@NativeQueryResultColumn(index = 7)
	private Date deathDate;
	@NativeQueryResultColumn(index = 8)
	private String officeName;
	@NativeQueryResultColumn(index = 9)
	private String officeAddress;
	@NativeQueryResultColumn(index = 10)
	private String departmentName;
	@NativeQueryResultColumn(index = 11)
	private String endorsement;
	@NativeQueryResultColumn(index = 12)
	private String status;
	@NativeQueryResultColumn(index = 13)
	private String lyingWith;
	@NativeQueryResultColumn(index = 14)
	private Date outwardDate;
	@NativeQueryResultColumn(index = 15)
	private String outwardBy;
	@NativeQueryResultColumn(index = 16)
	private String outwardNumber;
	@NativeQueryResultColumn(index = 17)
	private String postConsignmentNo;
	@NativeQueryResultColumn(index = 18)
	private Date authDate;
	@NativeQueryResultColumn(index = 19)
	private Date returnDate;
	@NativeQueryResultColumn(index = 20)
	private Long eventType;
	@NativeQueryResultColumn(index = 21)
	private Date wfCreatedDate;
	@NativeQueryResultColumn(index = 22)
	private Long pvuEventId;
	@NativeQueryResultColumn(index = 23)
	private String createdDate;
	@NativeQueryResultColumn(index = 24)
	private String eventName;

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public String getInwardNumber() {
		return inwardNumber;
	}

	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLyingWith() {
		return lyingWith;
	}

	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	public Date getOutwardDate() {
		return outwardDate;
	}

	public void setOutwardDate(Date outwardDate) {
		this.outwardDate = outwardDate;
	}

	public String getOutwardBy() {
		return outwardBy;
	}

	public void setOutwardBy(String outwardBy) {
		this.outwardBy = outwardBy;
	}

	public String getOutwardNumber() {
		return outwardNumber;
	}

	public void setOutwardNumber(String outwardNumber) {
		this.outwardNumber = outwardNumber;
	}

	public String getPostConsignmentNo() {
		return postConsignmentNo;
	}

	public void setPostConsignmentNo(String postConsignmentNo) {
		this.postConsignmentNo = postConsignmentNo;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Long getEventType() {
		return eventType;
	}

	public void setEventType(Long eventType) {
		this.eventType = eventType;
	}

	public Date getWfCreatedDate() {
		return wfCreatedDate;
	}

	public void setWfCreatedDate(Date wfCreatedDate) {
		this.wfCreatedDate = wfCreatedDate;
	}

	public Long getPvuEventId() {
		return pvuEventId;
	}

	public void setPvuEventId(Long pvuEventId) {
		this.pvuEventId = pvuEventId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(Long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
