package gov.ifms.pvu.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUShettyPayListView {

	@NativeQueryResultColumn(index = 0)
	private Long id;

	@NativeQueryResultColumn(index = 1)
	private String trnNo;

	@NativeQueryResultColumn(index = 2)
	private String eventName;

	@NativeQueryResultColumn(index = 3)
	private Long employeeNo;

	@NativeQueryResultColumn(index = 4)
	private String employeeName;

	@NativeQueryResultColumn(index = 5)
	private String designationName;

	@NativeQueryResultColumn(index = 6)
	private String className;

	@NativeQueryResultColumn(index = 7)
	private String empType;

	@NativeQueryResultColumn(index = 8)
	private String panNo;

	@NativeQueryResultColumn(index = 9)
	private String officeName;

	@NativeQueryResultColumn(index = 10)
	private String statusName;

	@NativeQueryResultColumn(index = 11)
	private LocalDateTime retirementDate;

	@JsonIgnore
	@NativeQueryResultColumn(index = 12)
	private Long count;

	@NativeQueryResultColumn(index = 13)
	private String eventCode;

	@NativeQueryResultColumn(index = 14)
	private Long isEditable;

	@NativeQueryResultColumn(index = 15)
	private String wfStatus;

	@NativeQueryResultColumn(index = 16)
	private Integer deleteFlag;
	
	@NativeQueryResultColumn(index = 17)
    private String createrDate;

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public LocalDateTime getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(LocalDateTime retirementDate) {
		this.retirementDate = retirementDate;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public Long getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(className, count, deleteFlag, designationName, empType, employeeName, employeeNo, eventCode,
				eventName, id, isEditable, officeName, panNo, retirementDate, statusName, trnNo, wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUShettyPayListView)) {
			return false;
		}
		PVUShettyPayListView other = (PVUShettyPayListView) obj;
		return Objects.equals(className, other.className) && Objects.equals(count, other.count)
				&& Objects.equals(deleteFlag, other.deleteFlag)
				&& Objects.equals(designationName, other.designationName) && Objects.equals(empType, other.empType)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(eventCode, other.eventCode) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(id, other.id) && Objects.equals(isEditable, other.isEditable)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(panNo, other.panNo)
				&& Objects.equals(retirementDate, other.retirementDate) && Objects.equals(statusName, other.statusName)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(wfStatus, other.wfStatus);
	}

	/**
	 * @return the deleteFlag
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the createrDate
	 */
	public String getCreaterDate() {
		return createrDate;
	}

	/**
	 * @param createrDate the createrDate to set
	 */
	public void setCreaterDate(String createrDate) {
		this.createrDate = createrDate;
	}
	
	

}
