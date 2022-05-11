package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeLangExamDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 *
 */
public class PVUEmployeLangExamDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp lang exam id. */
	private long empLangExamId;

	/** The lang name. */
	private long langName;
	private String langIdName;

	/** The exam body. */
	private String examBody;

	/** The exam type. */
	private long examType;
	private String examTypeName;

	/** The date of passing. */
	private Date dateOfPassing;

	/** The seat no. */
	@NotBlank
	private String seatNo;

	/** The exam status. */
	private long examStatus;
	private String examStatusName;

	/** The remarks. */
	private String remarks;

	/** The emp id. */
	@NotBlank
	private long empId;

	/** The status id. */
	private long statusId;

	/**
	 * getter setter.
	 *
	 * @return the emp lang exam id
	 */

	/**
	 * @return the empLangExamId
	 */
	public long getEmpLangExamId() {
		return empLangExamId;
	}

	/**
	 * Sets the emp lang exam id.
	 *
	 * @param empLangExamId the empLangExamId to set
	 */
	public void setEmpLangExamId(long empLangExamId) {
		this.empLangExamId = empLangExamId;
	}

	/**
	 * Gets the lang name.
	 *
	 * @return the langName
	 */
	public long getLangName() {
		return langName;
	}

	/**
	 * Sets the lang name.
	 *
	 * @param langName the langName to set
	 */
	public void setLangName(long langName) {
		this.langName = langName;
	}

	/**
	 * Gets the exam body.
	 *
	 * @return the examBody
	 */
	public String getExamBody() {
		return examBody;
	}

	/**
	 * Sets the exam body.
	 *
	 * @param examBody the examBody to set
	 */
	public void setExamBody(String examBody) {
		this.examBody = examBody;
	}

	/**
	 * Gets the exam type.
	 *
	 * @return the examType
	 */
	public long getExamType() {
		return examType;
	}

	/**
	 * Sets the exam type.
	 *
	 * @param examType the examType to set
	 */
	public void setExamType(long examType) {
		this.examType = examType;
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
	 * Gets the seat no.
	 *
	 * @return the seatNo
	 */
	public String getSeatNo() {
		return seatNo;
	}

	/**
	 * Sets the seat no.
	 *
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
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
	 * @return the langIdName
	 */
	public String getLangIdName() {
		return langIdName;
	}

	/**
	 * @param langIdName the langIdName to set
	 */
	public void setLangIdName(String langIdName) {
		this.langIdName = langIdName;
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
	 * @return the examTypeName
	 */
	public String getExamTypeName() {
		return examTypeName;
	}

	/**
	 * @param examTypeName the examTypeName to set
	 */
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	/**
	 * PVUEmployeLangExamDto Constructor.
	 */
	public PVUEmployeLangExamDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateOfPassing, empId, empLangExamId, examBody, examStatus, examType, langName, remarks,
				seatNo, statusId);
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
		if (!(obj instanceof PVUEmployeLangExamDto)) {
			return false;
		}
		PVUEmployeLangExamDto other = (PVUEmployeLangExamDto) obj;
		return Objects.equals(dateOfPassing, other.dateOfPassing) && empId == other.empId
				&& Objects.equals(empLangExamId, other.empLangExamId) && Objects.equals(examBody, other.examBody)
				&& Objects.equals(examStatus, other.examStatus) && Objects.equals(examType, other.examType)
				&& Objects.equals(langName, other.langName) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(seatNo, other.seatNo) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeLangExamDto [empLangExamId=" + empLangExamId + ", langName=" + langName + ", examBody="
				+ examBody + ", examType=" + examType + ", dateOfPassing=" + dateOfPassing + ", seatNo=" + seatNo
				+ ", examStatus=" + examStatus + ", remarks=" + remarks + ", empId=" + empId + ", statusId=" + statusId
				+ "]";
	}

}