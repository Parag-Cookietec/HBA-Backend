package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeCCCExamDetailDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 *
 */
public class PVUEmployeCCCExamDetailEditableDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp CCC exam detail id. */
	private long empCCCExamDetailId;

	/** The ccc exam name. */
	private long cccExamName;
	private String cccExamIdName;

	/** The exam body. */
	private long examBody;
	private String examBodyName;

	/** The date of exam. */
	private String dateOfExam;

	/** The date of passing. */
	private String dateOfPassing;

	/** The exam status. */
	private long examStatus;
	private String examStatusName;

	/** The certificate no. */
	private String certificateNo;

	/** The remarks. */
	private String remarks;

	/** The emp id. */
	private long empId;

	private long statusId;
	
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
	 * @return the emp CCC exam detail id
	 */

	/**
	 * @return the empCCCExamDetailId
	 */
	public long getEmpCCCExamDetailId() {
		return empCCCExamDetailId;
	}

	/**
	 * Sets the emp CCC exam detail id.
	 *
	 * @param empCCCExamDetailId the empCCCExamDetailId to set
	 */
	public void setEmpCCCExamDetailId(long empCCCExamDetailId) {
		this.empCCCExamDetailId = empCCCExamDetailId;
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
	 * @return the dateOfExam
	 */
	public String getDateOfExam() {
		return dateOfExam;
	}

	/**
	 * @param dateOfExam the dateOfExam to set
	 */
	public void setDateOfExam(String dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	/**
	 * @return the dateOfPassing
	 */
	public String getDateOfPassing() {
		return dateOfPassing;
	}

	/**
	 * @param dateOfPassing the dateOfPassing to set
	 */
	public void setDateOfPassing(String dateOfPassing) {
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
	 * Gets the ccc exam name.
	 *
	 * @return the cccExamName
	 */
	public long getCccExamName() {
		return cccExamName;
	}

	/**
	 * Sets the ccc exam name.
	 *
	 * @param cccExamName the cccExamName to set
	 */
	public void setCccExamName(long cccExamName) {
		this.cccExamName = cccExamName;
	}

	/**
	 * Gets the certificate no.
	 *
	 * @return the certificateNo
	 */
	public String getCertificateNo() {
		return certificateNo;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Sets the certificate no.
	 *
	 * @param certificateNo the certificateNo to set
	 */
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	/**
	 * @return the cccExamIdName
	 */
	public String getCccExamIdName() {
		return cccExamIdName;
	}

	/**
	 * @param cccExamIdName the cccExamIdName to set
	 */
	public void setCccExamIdName(String cccExamIdName) {
		this.cccExamIdName = cccExamIdName;
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
	 * PVUEmployeCCCExamDetailDto Constructor.
	 */
	public PVUEmployeCCCExamDetailEditableDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cccExamName, certificateNo, dateOfExam, dateOfPassing, empCCCExamDetailId, empId, examBody,
				examStatus, remarks);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeCCCExamDetailEditableDto)) {
			return false;
		}
		PVUEmployeCCCExamDetailEditableDto other = (PVUEmployeCCCExamDetailEditableDto) obj;
		return Objects.equals(cccExamName, other.cccExamName) && Objects.equals(certificateNo, other.certificateNo)
				&& Objects.equals(dateOfExam, other.dateOfExam) && Objects.equals(dateOfPassing, other.dateOfPassing)
				&& Objects.equals(empCCCExamDetailId, other.empCCCExamDetailId) && empId == other.empId
				&& Objects.equals(examBody, other.examBody) && Objects.equals(examStatus, other.examStatus)
				&& Objects.equals(remarks, other.remarks);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeCCCExamDetailDto [empCCCExamDetailId=" + empCCCExamDetailId + ", cccExamName=" + cccExamName
				+ ", examBody=" + examBody + ", dateOfExam=" + dateOfExam + ", dateOfPassing=" + dateOfPassing
				+ ", examStatus=" + examStatus + ", certificateNo=" + certificateNo + ", remarks=" + remarks
				+ ", empId=" + empId + "]";
	}

}
