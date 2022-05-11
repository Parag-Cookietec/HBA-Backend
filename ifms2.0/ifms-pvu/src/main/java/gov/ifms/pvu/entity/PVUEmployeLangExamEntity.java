package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeLangExamEntity.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 *
 */
@Entity
@Table(name = "T_EMP_LANG_EXAM", schema = Constant.PVU_SCHEMA)
public class PVUEmployeLangExamEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp lang exam id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_LANG_EXM_ID")
	private long empLangExamId;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LANGUAGE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity langName;

	/** The relationship. */
	private String examBody;

	/** The exam type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EXAM_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity examType;

	/** The date of passing. */
	@Column(name = "DATE_PASS_EXAM")
	private Date dateOfPassing;

	/** The seat no. */
	@Column(name = "SEAT_NO")
	private String seatNo;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity examStatus;

	/** The remarks. */
	@Column(name = "REMARK")
	private String remarks;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;
	
	@Column(name = "CHANGE_TYPE")
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
	 * @return the examType
	 */
	public EDPLuLookUpInfoEntity getExamType() {
		return examType;
	}

	/**
	 * @param examType the examType to set
	 */
	public void setExamType(EDPLuLookUpInfoEntity examType) {
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
	 * Gets the lang name.
	 *
	 * @return the langName
	 */
	public EDPLuLookUpInfoEntity getLangName() {
		return langName;
	}

	/**
	 * Sets the lang name.
	 *
	 * @param langName the langName to set
	 */
	public void setLangName(EDPLuLookUpInfoEntity langName) {
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
	 * Gets the exam status.
	 *
	 * @return the examStatus
	 */
	public EDPLuLookUpInfoEntity getExamStatus() {
		return examStatus;
	}

	/**
	 * Sets the exam status.
	 *
	 * @param examStatus the examStatus to set
	 */
	public void setExamStatus(EDPLuLookUpInfoEntity examStatus) {
		this.examStatus = examStatus;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * PVUEmployeLangExamEntity Constructor.
	 */
	public PVUEmployeLangExamEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateOfPassing, empLangExamId, examBody, examStatus, examType, langName, pvuEmployeEntity,
				remarks, seatNo, statusId);
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
		if (!(obj instanceof PVUEmployeLangExamEntity)) {
			return false;
		}
		PVUEmployeLangExamEntity other = (PVUEmployeLangExamEntity) obj;
		return Objects.equals(dateOfPassing, other.dateOfPassing) && Objects.equals(empLangExamId, other.empLangExamId)
				&& Objects.equals(examBody, other.examBody) && Objects.equals(examStatus, other.examStatus)
				&& Objects.equals(examType, other.examType) && Objects.equals(langName, other.langName)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(seatNo, other.seatNo) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeLangExamEntity [empLangExamId=" + empLangExamId + ", langName=" + langName + ", examBody="
				+ examBody + ", examType=" + examType + ", dateOfPassing=" + dateOfPassing + ", seatNo=" + seatNo
				+ ", examStatus=" + examStatus + ", remarks=" + remarks + ", statusId=" + statusId
				+ ", pvuEmployeEntity=" + pvuEmployeEntity + "]";
	}

}
