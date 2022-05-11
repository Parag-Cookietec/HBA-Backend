package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentEntity;

import javax.persistence.*;
import javax.transaction.Transactional;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class PVUEmployeReversionEventEntity.
 */
@Transactional
@Entity
@Table(name = "T_PVU_RV_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeReversionEntity extends PVUCurrentEntity implements Serializable  {


	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rev event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RV_EVNT_ID")
	private long id;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The trans num. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The event order num. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The emp class. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_CLASS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empClass;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The pay scale. */
	@Column(name = "PAY_SCALE")
	private long payScale;

	/** The pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;

	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The effective date. */
	@Column(name = "EFF_DATE")
	private LocalDate effectiveDate;

	/** The date next incr. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;
	
	 /**
     * The departmentCategoryId.
     */
    @Column(name = "DEPT_CAT_ID")
    private Long departmentCategoryId;

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * Gets the pay comm.
	 *
	 * @return the payComm
	 */
	public EDPLuLookUpInfoEntity getPayComm() {
		return payComm;
	}

	/**
	 * Sets the pay comm.
	 *
	 * @param payComm the payComm to set
	 */
	public void setPayComm(EDPLuLookUpInfoEntity payComm) {
		this.payComm = payComm;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the event order date.
	 *
	 * @return the eventOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order date.
	 *
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event effective date.
	 *
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event effective date.
	 *
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the empClass
	 */
	public EDPLuLookUpInfoEntity getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(EDPLuLookUpInfoEntity empClass) {
		this.empClass = empClass;
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

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevel
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the gradePay
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
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
	 * @return the departmentCategoryId
	 */
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * @param departmentCategoryId the departmentCategoryId to set
	 */
	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}
	

	public PVUEmployeReversionEntity() {

	}

	/**
	 * Instantiates a new PVU employe reversion entity.
	 *
	 * @param id the id
	 */
	public PVUEmployeReversionEntity(long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "PVUEmployeReversionEntity [id=" + id + ", statusId=" + statusId + ", trnNo=" + trnNo + ", officeId="
				+ officeId + ", payComm=" + payComm + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate="
				+ eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate + ", empClass=" + empClass
				+ ", designationId=" + designationId + ", payScale=" + payScale + ", payLevel=" + payLevel + ", cellId="
				+ cellId + ", payBand=" + payBand + ", payBandValue=" + payBandValue + ", gradePay=" + gradePay
				+ ", basicPay=" + basicPay + ", effectiveDate=" + effectiveDate + ", dateOfNextIncrement="
				+ dateOfNextIncrement + ", remarks=" + remarks + ", refDate=" + refDate + ", departmentCategoryId="
				+ departmentCategoryId + ", getRefDate()=" + getRefDate() + ", getId()=" + getId() + ", getStatusId()="
				+ getStatusId() + ", getTrnNo()=" + getTrnNo() + ", getOfficeId()=" + getOfficeId() + ", getPayComm()="
				+ getPayComm() + ", getEventOrderNo()=" + getEventOrderNo() + ", getEventOrderDate()="
				+ getEventOrderDate() + ", getEventEffectiveDate()=" + getEventEffectiveDate() + ", getEmpClass()="
				+ getEmpClass() + ", getDesignationId()=" + getDesignationId() + ", getPayScale()=" + getPayScale()
				+ ", getPayLevel()=" + getPayLevel() + ", getCellId()=" + getCellId() + ", getPayBand()=" + getPayBand()
				+ ", getPayBandValue()=" + getPayBandValue() + ", getGradePay()=" + getGradePay() + ", getBasicPay()="
				+ getBasicPay() + ", getEffectiveDate()=" + getEffectiveDate() + ", getDateOfNextIncrement()="
				+ getDateOfNextIncrement() + ", getRemarks()=" + getRemarks() + ", getDepartmentCategoryId()="
				+ getDepartmentCategoryId() + ", getEmployee()=" + getEmployee() + ", getcDateOfJoining()="
				+ getcDateOfJoining() + ", getcOfficeId()=" + getcOfficeId() + ", getCurrentDetailsEventId()="
				+ getCurrentDetailsEventId() + ", getcPayLevel()=" + getcPayLevel() + ", getcCell()=" + getcCell()
				+ ", getcPayBand()=" + getcPayBand() + ", getcGradePay()=" + getcGradePay() + ", getcPayBandValue()="
				+ getcPayBandValue() + ", getcPayScale()=" + getcPayScale() + ", getcDesignation()=" + getcDesignation()
				+ ", getcDateOfRetirement()=" + getcDateOfRetirement() + ", getcClass()=" + getcClass()
				+ ", getcBasicPay()=" + getcBasicPay() + ", getcDateOfNextIncrement()=" + getcDateOfNextIncrement()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getCreatedByPost()=" + getCreatedByPost() + ", getUpdatedByPost()=" + getUpdatedByPost()
				+ ", getActiveStatus()=" + getActiveStatus() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getUpdatedDate()=" + getUpdatedDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, dateOfNextIncrement, departmentCategoryId, designationId, effectiveDate,
				empClass, eventEffectiveDate, eventOrderDate, eventOrderNo, gradePay, id, officeId, payBand,
				payBandValue, payComm, payLevel, payScale, refDate, remarks, statusId, trnNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeReversionEntity)) {
			return false;
		}
		PVUEmployeReversionEntity other = (PVUEmployeReversionEntity) obj;
		return basicPay == other.basicPay && Objects.equals(cellId, other.cellId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(departmentCategoryId, other.departmentCategoryId)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(empClass, other.empClass)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && Objects.equals(gradePay, other.gradePay)
				&& id == other.id && Objects.equals(officeId, other.officeId) && Objects.equals(payBand, other.payBand)
				&& payBandValue == other.payBandValue && Objects.equals(payComm, other.payComm)
				&& Objects.equals(payLevel, other.payLevel) && payScale == other.payScale
				&& Objects.equals(refDate, other.refDate) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnNo, other.trnNo);
	}
	
	
	
	

}