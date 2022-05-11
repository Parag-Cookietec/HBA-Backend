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
 * The Class PVUEmployeDeptExamDetailsEntity.
 *
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 *
 */
@Entity
@Table(name = "T_EMP_DPT_EXM_DTL", schema = Constant.PVU_SCHEMA)
public class PVUEmployeDeptExamDetailsEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp dept exam detail id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_DPT_EXM_DTL_ID")
	private long empDeptExamDetailId;

	/** The dept exam name. */
	@Column(name = "DEPT_EXM_NAME")
	private String deptExamName;

	/** The exam body. */
	@OneToOne
	@JoinColumn(name = "EXAM_BODY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity examBody;

	/** The dept hod name. */
	@Column(name = "DEPT_HOD_NAME")
	private Long deptHodName;

	/** The date of passing. */
	@Column(name = "DATE_EXAM_PASS")
	private Date dateOfPassing;

	/** The relationship. */
	@OneToOne
	@JoinColumn(name = "STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity examStatus;

	/** The exam attempts. */
	@Column(name = "ATTEMPTS")
	private int examAttempts;

	/** The remarks. */
	@Column(name = "REMARK")
	private String remarks;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The other dept hod name. */
	@Column(name = "OTHER_DEPT_HOD_NAME")
	private String otherDeptHodName;
	
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
	 * Gets the exam body.
	 *
	 * @return the examBody
	 */
	public EDPLuLookUpInfoEntity getExamBody() {
		return examBody;
	}

	/**
	 * Sets the exam body.
	 *
	 * @param examBody the examBody to set
	 */
	public void setExamBody(EDPLuLookUpInfoEntity examBody) {
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
	 * Gets the other dept hod name.
	 *
	 * @return the otherDeptHodName
	 */
	public String getOtherDeptHodName() {
		return otherDeptHodName;
	}

	/**
	 * Sets the other dept hod name.
	 *
	 * @param otherDeptHodName the otherDeptHodName to set
	 */
	public void setOtherDeptHodName(String otherDeptHodName) {
		this.otherDeptHodName = otherDeptHodName;
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
	 * PVUEmployeDeptExamDetailsEntity Constructor.
	 */
	public PVUEmployeDeptExamDetailsEntity() {
		super();
	}

	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateOfPassing, deptExamName, deptHodName, empDeptExamDetailId, examAttempts, examBody,
				examStatus, otherDeptHodName, pvuEmployeEntity, remarks, statusId);
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
		PVUEmployeDeptExamDetailsEntity other = (PVUEmployeDeptExamDetailsEntity) obj;
		return Objects.equals(dateOfPassing, other.dateOfPassing) && Objects.equals(deptExamName, other.deptExamName)
				&& Objects.equals(deptHodName, other.deptHodName) && empDeptExamDetailId == other.empDeptExamDetailId
				&& examAttempts == other.examAttempts && Objects.equals(examBody, other.examBody)
				&& Objects.equals(examStatus, other.examStatus)
				&& Objects.equals(otherDeptHodName, other.otherDeptHodName)
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
		return "PVUEmployeDeptExamDetailsEntity [empDeptExamDetailId=" + empDeptExamDetailId + ", deptExamName="
				+ deptExamName + ", examBody=" + examBody + ", deptHodName=" + deptHodName + ", dateOfPassing="
				+ dateOfPassing + ", examStatus=" + examStatus + ", examAttempts=" + examAttempts + ", remarks="
				+ remarks + ", pvuEmployeEntity=" + pvuEmployeEntity + ", statusId=" + statusId + ", otherDeptHodName="
				+ otherDeptHodName + "]";
	}
}
