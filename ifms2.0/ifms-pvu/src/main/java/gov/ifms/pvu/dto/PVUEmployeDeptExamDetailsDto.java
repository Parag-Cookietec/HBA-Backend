package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeDeptExamDetailsDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 *
 */
public class PVUEmployeDeptExamDetailsDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp dept exam detail id. */
	private long empDeptExamDetailId;

	/** The dept exam name. */
	private String deptExamName;

	/** The exam body. */
	private long examBody;
	private String examBodyName;

	/** The dept hod name. */
	private Long deptHodName;

	/** The date of passing. */
	private Date dateOfPassing;

	/** The exam status. */
	private long examStatus;
	private String examStatusName;

	/** The exam attempts. */
	private int examAttempts;

	/** The remarks. */
	private String remarks;

	/** The emp id. */
	private long empId;

	/** The status id. */
	private long statusId;

	/** The other dept hod name. */
	private String otherDeptHodName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	private long changeType;

	/**
	 * @return the changeType
	 */
	public long getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(long changeType) {
		this.changeType = changeType;
	}
	/**
	 * getter setter.
	 *
	 * @return the emp dept exam detail id
	 */

	/**
	 * @return the empDeptExamDetailId
	 */
	public long getEmpDeptExamDetailId() {
		return empDeptExamDetailId;
	}

	/**
	 * Sets the emp dept exam detail id.
	 *
	 * @param empDeptExamDetailId the empDeptExamDetailId to set
	 */
	public void setEmpDeptExamDetailId(long empDeptExamDetailId) {
		this.empDeptExamDetailId = empDeptExamDetailId;
	}

	/**
	 * Gets the dept exam name.
	 *
	 * @return the deptExamName
	 */
	public String getDeptExamName() {
		return deptExamName;
	}

	/**
	 * Sets the dept exam name.
	 *
	 * @param deptExamName the deptExamName to set
	 */
	public void setDeptExamName(String deptExamName) {
		this.deptExamName = deptExamName;
	}

	/**
	 * Gets the exam body.
	 *
	 * @return the examBody
	 */
	public long getExamBody() {
		return examBody;
	}

	/**
	 * Sets the exam body.
	 *
	 * @param examBody the examBody to set
	 */
	public void setExamBody(long examBody) {
		this.examBody = examBody;
	}

	/**
	 * Gets the date of passing.
	 *
	 * @return the dateOfPassing
	 */
	public Date getDateOfPassing() {
		return dateOfPassing;
	}

	/**
	 * Sets the date of passing.
	 *
	 * @param dateOfPassing the dateOfPassing to set
	 */
	public void setDateOfPassing(Date dateOfPassing) {
		this.dateOfPassing = dateOfPassing;
	}

	/**
	 * Gets the exam status.
	 *
	 * @return the examStatus
	 */
	public long getExamStatus() {
		return examStatus;
	}

	/**
	 * Sets the exam status.
	 *
	 * @param examStatus the examStatus to set
	 */
	public void setExamStatus(long examStatus) {
		this.examStatus = examStatus;
	}

	/**
	 * Gets the exam attempts.
	 *
	 * @return the examAttempts
	 */
	public int getExamAttempts() {
		return examAttempts;
	}

	/**
	 * Sets the exam attempts.
	 *
	 * @param examAttempts the examAttempts to set
	 */
	public void setExamAttempts(int examAttempts) {
		this.examAttempts = examAttempts;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return empId
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
	 * Gets the dept hod name.
	 *
	 * @return the dept hod name
	 */
	public Long getDeptHodName() {
		return deptHodName;
	}

	/**
	 * Sets the dept hod name.
	 *
	 * @param deptHodName the new dept hod name
	 */
	public void setDeptHodName(Long deptHodName) {
		this.deptHodName = deptHodName;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the other dept hod name.
	 *
	 * @return the other dept hod name
	 */
	public String getOtherDeptHodName() {
		return otherDeptHodName;
	}

	/**
	 * Sets the other dept hod name.
	 *
	 * @param otherDeptHodName the new other dept hod name
	 */
	public void setOtherDeptHodName(String otherDeptHodName) {
		this.otherDeptHodName = otherDeptHodName;
	}

	/**
	 * @return the examBodyName
	 */
	public String getExamBodyName() {
		return examBodyName;
	}

	/**
	 * @param examBodyName the examBodyName to set
	 */
	public void setExamBodyName(String examBodyName) {
		this.examBodyName = examBodyName;
	}

	/**
	 * @return the examStatusName
	 */
	public String getExamStatusName() {
		return examStatusName;
	}

	/**
	 * @param examStatusName the examStatusName to set
	 */
	public void setExamStatusName(String examStatusName) {
		this.examStatusName = examStatusName;
	}

	/**
	 * PVUEmployeDeptExamDetailsDto Constructor.
	 */
	public PVUEmployeDeptExamDetailsDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateOfPassing, deptExamName, deptHodName, empDeptExamDetailId, empId, examAttempts,
				examBody, examStatus, otherDeptHodName, remarks, statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeDeptExamDetailsDto other = (PVUEmployeDeptExamDetailsDto) obj;
		return Objects.equals(dateOfPassing, other.dateOfPassing) && Objects.equals(deptExamName, other.deptExamName)
				&& deptHodName == other.deptHodName && empDeptExamDetailId == other.empDeptExamDetailId
				&& empId == other.empId && examAttempts == other.examAttempts && examBody == other.examBody
				&& examStatus == other.examStatus && Objects.equals(otherDeptHodName, other.otherDeptHodName)
				&& Objects.equals(remarks, other.remarks) && statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeDeptExamDetailsDto [empDeptExamDetailId=" + empDeptExamDetailId + ", deptExamName="
				+ deptExamName + ", examBody=" + examBody + ", deptHodName=" + deptHodName + ", dateOfPassing="
				+ dateOfPassing + ", examStatus=" + examStatus + ", examAttempts=" + examAttempts + ", remarks="
				+ remarks + ", empId=" + empId + ", statusId=" + statusId + ", otherDeptHodName=" + otherDeptHodName
				+ "]";
	}
}
