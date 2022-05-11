package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import gov.ifms.edp.entity.*;

/**
 * The Class PVUIncrementEventEntity.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */
@Entity
@Table(name = "T_PVU_IN_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUIncrementEventEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_EVNT_ID")
	private long inEventId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The post id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POST_ID", nullable = false, referencedColumnName = "POST_ID")
	private EDPMsPostEntity postId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "FINANCIAL_YEAR", nullable = false, referencedColumnName = "FINANCIAL_YEAR_ID")
	private EDPMsFinancialYearEntity financialYear;

	/** The trn no. */
	@Column(name = "INCREMENT_ORDER_NO")
	private long eventOrderNo;

	/** The increment for. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "INCREMENT_FOR", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity incrementFor;

	/** The increment type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "INCREMENT_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity incrementType;

	/** The increment type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_PAY_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empPayType;

	/** The emp type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empType;

	/** The class id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CLASS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity classId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The increment eff date. */
	@Column(name = "INCREMENT_EFF_DATE")
	private Date incrementEffDate;

	/** The date next inc. */
	@Column(name = "DATE_NEXT_INC")
	private Date dateNextInc;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The date next inc. */
	@Column(name = "EMP_NO")
	private String empNo;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The gpf no. */
	@Column(name = "GPF")
	private String gpf;

	@Column(name = "DDO_NO")
	private String ddoNo;

	@Column(name = "CARDEX_NO")
	private long cardexNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CGP_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity cgpTypeId;

	@Column(name = "REF_DATE")
	private Date refDate;

	/** The gpf no. */
//	@Column(name = "USER_REMARKS")
//	private String userRemarks;


	/**
	 * PVUIncrementEventEntity Constructor.
	 */
	public PVUIncrementEventEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU increment event entity.
	 *
	 * @param inEventId the in event id
	 */
	public PVUIncrementEventEntity(long inEventId) {
		this.inEventId = inEventId;
	}

	/**
	 * Gets the in event id.
	 *
	 * @return the inEventId
	 */
	public long getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(long inEventId) {
		this.inEventId = inEventId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the financial year.
	 *
	 * @return the financialYear
	 */
	public EDPMsFinancialYearEntity getFinancialYear() {
		return financialYear;
	}

	/**
	 * Sets the financial year.
	 *
	 * @param financialYear the financialYear to set
	 */
	public void setFinancialYear(EDPMsFinancialYearEntity financialYear) {
		this.financialYear = financialYear;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the eventOrderNo
	 */
	public long getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(long eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the increment for.
	 *
	 * @return the incrementFor
	 */
	public EDPLuLookUpInfoEntity getIncrementFor() {
		return incrementFor;
	}

	/**
	 * Sets the increment for.
	 *
	 * @param incrementFor the incrementFor to set
	 */
	public void setIncrementFor(EDPLuLookUpInfoEntity incrementFor) {
		this.incrementFor = incrementFor;
	}

	/**
	 * Gets the increment type.
	 *
	 * @return the incrementType
	 */
	public EDPLuLookUpInfoEntity getIncrementType() {
		return incrementType;
	}

	/**
	 * Sets the increment type.
	 *
	 * @param incrementType the incrementType to set
	 */
	public void setIncrementType(EDPLuLookUpInfoEntity incrementType) {
		this.incrementType = incrementType;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public EDPLuLookUpInfoEntity getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(EDPLuLookUpInfoEntity classId) {
		this.classId = classId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	public Date getIncrementEffDate() {
		return incrementEffDate;
	}

	public void setIncrementEffDate(Date incrementEffDate) {
		this.incrementEffDate = incrementEffDate;
	}

	public Date getDateNextInc() {
		return dateNextInc;
	}

	public void setDateNextInc(Date dateNextInc) {
		this.dateNextInc = dateNextInc;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
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
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public EDPLuLookUpInfoEntity getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(EDPLuLookUpInfoEntity empType) {
		this.empType = empType;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public EDPMsPostEntity getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(EDPMsPostEntity postId) {
		this.postId = postId;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the employee pay type.
	 *
	 * @return the employeePayType
	 */
	public EDPLuLookUpInfoEntity getEmpPayType() {
		return empPayType;
	}

	/**
	 * Sets the employee pay type.
	 *
	 * @param empPayType the new emp pay type
	 */
	public void setEmpPayType(EDPLuLookUpInfoEntity empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * Gets the gpf.
	 *
	 * @return the gpf
	 */
	public String getGpf() {
		return gpf;
	}

	/**
	 * Sets the gpf.
	 *
	 * @param gpf the gpf to set
	 */
	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	public String getDdoNo() {
		return ddoNo;
	}

	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	public long getCardexNo() {
		return cardexNo;
	}

	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	public EDPMsDistrictEntity getDistrictId() {
		return districtId;
	}

	public void setDistrictId(EDPMsDistrictEntity districtId) {
		this.districtId = districtId;
	}

	public EDPLuLookUpInfoEntity getCgpTypeId() {
		return cgpTypeId;
	}

	public void setCgpTypeId(EDPLuLookUpInfoEntity cgpTypeId) {
		this.cgpTypeId = cgpTypeId;
	}

	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

//	public String getUserRemarks() {
//		return userRemarks;
//	}
//
//	public void setUserRemarks(String userRemarks) {
//		this.userRemarks = userRemarks;
//	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUIncrementEventEntity)) return false;
		PVUIncrementEventEntity that = (PVUIncrementEventEntity) o;
		return getInEventId() == that.getInEventId() &&
				getEventOrderNo() == that.getEventOrderNo() &&
				getCardexNo() == that.getCardexNo() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getOfficeId(), that.getOfficeId()) &&
				Objects.equals(getPostId(), that.getPostId()) &&
				Objects.equals(getFinancialYear(), that.getFinancialYear()) &&
				Objects.equals(getIncrementFor(), that.getIncrementFor()) &&
				Objects.equals(getIncrementType(), that.getIncrementType()) &&
				Objects.equals(getEmpPayType(), that.getEmpPayType()) &&
				Objects.equals(getEmpType(), that.getEmpType()) &&
				Objects.equals(getClassId(), that.getClassId()) &&
				Objects.equals(getDesignationId(), that.getDesignationId()) &&
				Objects.equals(getIncrementEffDate(), that.getIncrementEffDate()) &&
				Objects.equals(getDateNextInc(), that.getDateNextInc()) &&
				Objects.equals(getEmpId(), that.getEmpId()) &&
				Objects.equals(getEmpNo(), that.getEmpNo()) &&
				Objects.equals(getStatusId(), that.getStatusId()) &&
				Objects.equals(getGpf(), that.getGpf()) &&
				Objects.equals(getDdoNo(), that.getDdoNo()) &&
				Objects.equals(getDistrictId(), that.getDistrictId()) &&
				Objects.equals(getCgpTypeId(), that.getCgpTypeId()) &&
				Objects.equals(getRefDate(), that.getRefDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInEventId(), getTrnNo(), getOfficeId(), getPostId(), getFinancialYear(), getEventOrderNo(), getIncrementFor(), getIncrementType(), getEmpPayType(), getEmpType(), getClassId(), getDesignationId(), getIncrementEffDate(), getDateNextInc(), getEmpId(), getEmpNo(), getStatusId(), getGpf(), getDdoNo(), getCardexNo(), getDistrictId(), getCgpTypeId(), getRefDate());
	}

	@Override
	public String toString() {
		return "PVUIncrementEventEntity{" +
				"inEventId=" + inEventId +
				", trnNo='" + trnNo + '\'' +
				", officeId=" + officeId +
				", postId=" + postId +
				", financialYear=" + financialYear +
				", eventOrderNo=" + eventOrderNo +
				", incrementFor=" + incrementFor +
				", incrementType=" + incrementType +
				", empPayType=" + empPayType +
				", empType=" + empType +
				", classId=" + classId +
				", designationId=" + designationId +
				", incrementEffDate=" + incrementEffDate +
				", dateNextInc=" + dateNextInc +
				", empId=" + empId +
				", empNo='" + empNo + '\'' +
				", statusId=" + statusId +
				", gpf='" + gpf + '\'' +
				", ddoNo='" + ddoNo + '\'' +
				", cardexNo=" + cardexNo +
				", districtId=" + districtId +
				", cgpTypeId=" + cgpTypeId +
				", refDate=" + refDate +
				'}';
	}
}
