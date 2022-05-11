/*
 * 
 */
package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class BudgetNCItemView.
 */
@NativeQueryResultEntity
public class PvuExpEmpView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The empId */
	@NativeQueryResultColumn(index = 0)
	private long empId;

	/** The employeeNo */
	@NativeQueryResultColumn(index = 1)
	private String employeeNo;
	
	/** The budget head. */
	@NativeQueryResultColumn(index = 2)
	private String employeeName;
	
	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The empPayType. */
	@NativeQueryResultColumn(index = 4)
	private String empPayType;

	/** The app panNo. */
	@NativeQueryResultColumn(index = 5)
	private String panNo;

	/** The app office Name. */
	@NativeQueryResultColumn(index = 6)
	private String officeName;

	/** The pa status. */
	@NativeQueryResultColumn(index = 7)
	private String status;

	/** The pa officeId. */
	@NativeQueryResultColumn(index = 8)
	private Long officeId;

	/** The statusId. */
	@NativeQueryResultColumn(index = 9)
	private Long statusId ;

	/** The createdDate. */
	@NativeQueryResultColumn(index = 10)
	private String createdDate;
	
	/** The totalRecords. */
	@NativeQueryResultColumn(index = 11)
	private int totalRecords;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
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

	public String getEmpPayType() {
		return empPayType;
	}

	public void setEmpPayType(String empPayType) {
		this.empPayType = empPayType;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
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

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PvuExpEmpView that = (PvuExpEmpView) o;
		return empId == that.empId && totalRecords == that.totalRecords && Objects.equals(employeeNo, that.employeeNo) && Objects.equals(employeeName, that.employeeName) && Objects.equals(designation, that.designation) && Objects.equals(empPayType, that.empPayType) && Objects.equals(panNo, that.panNo) && Objects.equals(officeName, that.officeName) && Objects.equals(status, that.status) && Objects.equals(officeId, that.officeId) && Objects.equals(statusId, that.statusId) && Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, employeeNo, employeeName, designation, empPayType, panNo, officeName, status, officeId, statusId, createdDate, totalRecords);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PvuExpEmpView{");
		sb.append("empId=").append(empId);
		sb.append(", employeeNo='").append(employeeNo).append('\'');
		sb.append(", employeeName='").append(employeeName).append('\'');
		sb.append(", designation='").append(designation).append('\'');
		sb.append(", empPayType='").append(empPayType).append('\'');
		sb.append(", panNo='").append(panNo).append('\'');
		sb.append(", officeName='").append(officeName).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", officeId=").append(officeId);
		sb.append(", statusId=").append(statusId);
		sb.append(", createdDate='").append(createdDate).append('\'');
		sb.append(", totalRecords=").append(totalRecords);
		sb.append('}');
		return sb.toString();
	}
}