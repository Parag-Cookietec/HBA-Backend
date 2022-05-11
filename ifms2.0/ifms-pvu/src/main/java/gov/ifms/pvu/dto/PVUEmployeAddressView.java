package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeAddressView.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@NativeQueryResultEntity
public class PVUEmployeAddressView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee id. */
	@NativeQueryResultColumn(index = 0)
	private String employeeId;

	/** The employee no. */
	@NativeQueryResultColumn(index = 1)
	private String employeeNo;

	/** The case no. */
	@NativeQueryResultColumn(index = 2)
	private String caseNo;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The class level. */
	@NativeQueryResultColumn(index = 4)
	private String classLevel;

	/** The dob. */
	@NativeQueryResultColumn(index = 5)
	private Date dob;

	/** The doj. */
	@NativeQueryResultColumn(index = 6)
	private Date doj;

	/** The pan. */
	@NativeQueryResultColumn(index = 7)
	private String pan;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;

	/** The emp name. */
	@NativeQueryResultColumn(index = 9)
	private String empName;

	/** The status. */
	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The status. */
	@NativeQueryResultColumn(index = 11)
	private String officeId;

	/** The total records. */
	@NativeQueryResultColumn(index = 12)
	private String wfTrnStatus;

	/** The is editable. */
	@NativeQueryResultColumn(index = 13)
	private String isEditable;
	
	/** The employee row count. */
	@NativeQueryResultColumn(index = 15)
	private String employeeRowCount;

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the case no.
	 *
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * Sets the case no.
	 *
	 * @param caseNo the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
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
	 * Gets the class level.
	 *
	 * @return the classLevel
	 */
	public String getClassLevel() {
		return classLevel;
	}

	/**
	 * Sets the class level.
	 *
	 * @param classLevel the classLevel to set
	 */
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the doj.
	 *
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}

	/**
	 * Sets the doj.
	 *
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	/**
	 * Gets the pan.
	 *
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * Sets the pan.
	 *
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the wf trn status.
	 *
	 * @return the wfTrnStatus
	 */
	public String getWfTrnStatus() {
		return wfTrnStatus;
	}

	/**
	 * Sets the wf trn status.
	 *
	 * @param wfTrnStatus the wfTrnStatus to set
	 */
	public void setWfTrnStatus(String wfTrnStatus) {
		this.wfTrnStatus = wfTrnStatus;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the isEditable
	 */
	public String getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}
	
	

	/**
	 * @return the employeeRowCount
	 */
	public String getEmployeeRowCount() {
		return employeeRowCount;
	}

	/**
	 * @param employeeRowCount the employeeRowCount to set
	 */
	public void setEmployeeRowCount(String employeeRowCount) {
		this.employeeRowCount = employeeRowCount;
	}

	
	/**
	 * returns int hashCode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(caseNo, classLevel, designation, dob, doj, empName, employeeId, employeeNo,
				employeeRowCount, isEditable, officeId, officeName, pan, status, wfTrnStatus);
	}

	/**
	 * returns true or false based on equals comparison
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PVUEmployeAddressView other = (PVUEmployeAddressView) obj;
		return Objects.equals(caseNo, other.caseNo) && Objects.equals(classLevel, other.classLevel)
				&& Objects.equals(designation, other.designation) && Objects.equals(dob, other.dob)
				&& Objects.equals(doj, other.doj) && Objects.equals(empName, other.empName)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(employeeRowCount, other.employeeRowCount)
				&& Objects.equals(isEditable, other.isEditable) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(pan, other.pan)
				&& Objects.equals(status, other.status) && Objects.equals(wfTrnStatus, other.wfTrnStatus);
	}

	
	/**
	 * To String
	 * return to String to display object attributes. 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PVUEmployeAddressView [employeeId=").append(employeeId).append(", employeeNo=")
				.append(employeeNo).append(", caseNo=").append(caseNo).append(", designation=").append(designation)
				.append(", classLevel=").append(classLevel).append(", dob=").append(dob).append(", doj=").append(doj)
				.append(", pan=").append(pan).append(", officeName=").append(officeName).append(", empName=")
				.append(empName).append(", status=").append(status).append(", officeId=").append(officeId)
				.append(", wfTrnStatus=").append(wfTrnStatus).append(", isEditable=").append(isEditable)
				.append(", employeeRowCount=").append(employeeRowCount).append("]");
		return builder.toString();
	}

}
