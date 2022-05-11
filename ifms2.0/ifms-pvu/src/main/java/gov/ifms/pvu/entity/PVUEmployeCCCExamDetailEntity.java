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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeCCCExamDetailEntity.
 *
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 *
 */
@Entity
@Table(name = "T_EMP_CCC_EXM_DTL", schema = Constant.PVU_SCHEMA)
public class PVUEmployeCCCExamDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp CCC exam detail id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_CCC_EXM_DTL_ID")
	private long empCCCExamDetailId;

	/** The ccc exam name. */
	@OneToOne(optional = false)
	@JoinColumn(name = "EXAM_NAME", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity cccExamName;

	/** The exam body. */
	@OneToOne
	@JoinColumn(name = "EXAM_BODY", referencedColumnName = "COURSE_ID")
	private PVUMsCourseEntity examBody;

	/** The date of exam. */
	@Column(name = "DATE_EXAM")
	private Date dateOfExam;

	/** The date of passing. */
	@Column(name = "DATE_PASS_EXAM")
	private Date dateOfPassing;

	/** The relationship. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity examStatus;

	/** The certificate no. */
	@Column(name = "NOTIFY_CERT_NO")
	private String certificateNo;

	/** The remarks. */
	@Column(name = "REMARK")
	private String remarks;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The relationship. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;
	
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
	public PVUMsCourseEntity getExamBody() {
		return examBody;
	}

	/**
	 * Sets the exam body.
	 *
	 * @param examBody the examBody to set
	 */
	public void setExamBody(PVUMsCourseEntity examBody) {
		this.examBody = examBody;
	}

	/**
	 * Gets the date of exam.
	 *
	 * @return the dateOfExam
	 */
	public Date getDateOfExam() {
		return dateOfExam;
	}

	/**
	 * Sets the date of exam.
	 *
	 * @param dateOfExam the dateOfExam to set
	 */
	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
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
	 * Gets the pvu employe entity.
	 *
	 * @return pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Gets the certificate no.
	 *
	 * @return the certificateNo
	 */
	public String getCertificateNo() {
		return certificateNo;
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
	 * Gets the ccc exam name.
	 *
	 * @return the cccExamName
	 */
	public EDPLuLookUpInfoEntity getCccExamName() {
		return cccExamName;
	}

	/**
	 * Sets the ccc exam name.
	 *
	 * @param cccExamName the cccExamName to set
	 */
	public void setCccExamName(EDPLuLookUpInfoEntity cccExamName) {
		this.cccExamName = cccExamName;
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
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * PVUEmployeCCCExamDetailEntity Constructor.
	 */
	public PVUEmployeCCCExamDetailEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cccExamName, certificateNo, dateOfExam, dateOfPassing, empCCCExamDetailId, examBody,
				examStatus, pvuEmployeEntity, remarks, statusId);
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
		PVUEmployeCCCExamDetailEntity other = (PVUEmployeCCCExamDetailEntity) obj;
		return Objects.equals(cccExamName, other.cccExamName) && Objects.equals(certificateNo, other.certificateNo)
				&& Objects.equals(dateOfExam, other.dateOfExam) && Objects.equals(dateOfPassing, other.dateOfPassing)
				&& empCCCExamDetailId == other.empCCCExamDetailId && Objects.equals(examBody, other.examBody)
				&& Objects.equals(examStatus, other.examStatus)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeCCCExamDetailEntity [empCCCExamDetailId=" + empCCCExamDetailId + ", cccExamName="
				+ cccExamName + ", examBody=" + examBody + ", dateOfExam=" + dateOfExam + ", dateOfPassing="
				+ dateOfPassing + ", examStatus=" + examStatus + ", certificateNo=" + certificateNo + ", remarks="
				+ remarks + ", pvuEmployeEntity=" + pvuEmployeEntity + ", statusId=" + statusId + "]";
	}

}
