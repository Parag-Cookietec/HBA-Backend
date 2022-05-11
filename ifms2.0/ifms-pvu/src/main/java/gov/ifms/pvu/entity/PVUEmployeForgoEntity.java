package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUForgoEntity.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:00:23
 *
 */

@Entity
@Table(name = "T_PVU_PRFG_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeForgoEntity extends BaseEntity implements Serializable {

	/**
	 * Instantiates a new PVU employe forgo entity.
	 *
	 */

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_PRFG_EVNT_ID")
	private long id;

	/** The trans no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order LocalDate. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event eff LocalDate. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The emp event. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_PRFG_EMP_EVNT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empEvent;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The emp class. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_CLASS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empClass;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The promo LocalDate. */
	@Column(name = "PROMO_DATE")
	private LocalDate promoDate;

	/** The join promotion post. */
	@Column(name = "JN_PR_POST_SEL")
	private long joinPromotionPost;

	/** The join promotion LocalDate. */
	@Column(name = "JN_PR_DATE")
	private LocalDate joinPromotionDate;

	/** The promo forgo LocalDate. */
	@Column(name = "PR_FG_DATE")
	private LocalDate promoForgoDate;

	/** The nxt increment LocalDate. */
	@Column(name = "DATE_OF_NXT_INC")
	private LocalDate dateOfNextIncrement;

	/** The high grade sel. */
	@Column(name = "HIGH_GRAD_SEL")
	private long highGradeSel;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBandId;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;



	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePayId;

	/** The pay scale. */
	@Column(name = "PAY_SCALE")
	private long payScale;

	/** The LocalDate of high grade 1. */
	@Column(name = "DATE_HG_1")
	private LocalDate dateOfHighGrade1;

	/** The LocalDate of high grade 2. */
	@Column(name = "DATE_HG_2")
	private LocalDate dateOfHighGrade2;

	/** The LocalDate of high grade 3. */
	@Column(name = "DATE_HG_3")
	private LocalDate dateOfHighGrade3;
	
	
	@Column(name = "REMARKS")
	 private String remarks;



	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public long getEventId() {
		return id;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Sets the event id.
	 *
	 * @param id the new event id
	 */
	public void setEventId(long id) {
		this.id = id;
	}


	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the pay comm.
	 *
	 * @return the pay comm
	 */
	public EDPLuLookUpInfoEntity getPayComm() {
		return payComm;
	}

	/**
	 * Sets the pay comm.
	 *
	 * @param payComm the new pay comm
	 */
	public void setPayComm(EDPLuLookUpInfoEntity payComm) {
		this.payComm = payComm;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the event order no
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the new event order no
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the event order LocalDate.
	 *
	 * @return the event order LocalDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order LocalDate.
	 *
	 * @param eventOrderDate the new event order LocalDate
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event eff LocalDate.
	 *
	 * @return the event eff LocalDate
	 */
	public LocalDate getEventEffDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event eff LocalDate.
	 *
	 * @param eventEffectiveDate the new event eff LocalDate
	 */
	public void setEventEffDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the emp event.
	 *
	 * @return the emp event
	 */
	public EDPLuLookUpInfoEntity getEmpEvent() {
		return empEvent;
	}

	/**
	 * Sets the emp event.
	 *
	 * @param empEvent the new emp event
	 */
	public void setEmpEvent(EDPLuLookUpInfoEntity empEvent) {
		this.empEvent = empEvent;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the emp class
	 */
	public EDPLuLookUpInfoEntity getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the new emp class
	 */
	public void setEmpClass(EDPLuLookUpInfoEntity empClass) {
		this.empClass = empClass;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designation id
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the new designation id
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the pay level
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the new pay level
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cell id
	 */
	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the new cell id
	 */
	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basic pay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the new basic pay
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the promo LocalDate.
	 *
	 * @return the promo LocalDate
	 */
	public LocalDate getPromoDate() {
		return promoDate;
	}

	/**
	 * Sets the promo LocalDate.
	 *
	 * @param promoDate the new promo LocalDate
	 */
	public void setPromoDate(LocalDate promoDate) {
		this.promoDate = promoDate;
	}

	/**
	 * Gets the join promotion post.
	 *
	 * @return the join promotion post
	 */
	public long getJoinPromotionPost() {
		return joinPromotionPost;
	}

	/**
	 * Sets the join promotion post.
	 *
	 * @param joinPromotionPost the new join promotion post
	 */
	public void setJoinPromotionPost(long joinPromotionPost) {
		this.joinPromotionPost = joinPromotionPost;
	}

	/**
	 * Gets the join promotion LocalDate.
	 *
	 * @return the join promotion LocalDate
	 */
	public LocalDate getJoinPromotionDate() {
		return joinPromotionDate;
	}

	/**
	 * Sets the join promotion LocalDate.
	 *
	 * @param joinPromotionDate the new join promotion LocalDate
	 */
	public void setJoinPromotionDate(LocalDate joinPromotionDate) {
		this.joinPromotionDate = joinPromotionDate;
	}

	/**
	 * Gets the promo forgo LocalDate.
	 *
	 * @return the promo forgo LocalDate
	 */
	public LocalDate getPromoForgoDate() {
		return promoForgoDate;
	}

	/**
	 * Sets the promo forgo LocalDate.
	 *
	 * @param promoForgoDate the new promo forgo LocalDate
	 */
	public void setPromoForgoDate(LocalDate promoForgoDate) {
		this.promoForgoDate = promoForgoDate;
	}

	
	/**
	 * Gets the high grade sel.
	 *
	 * @return the high grade sel
	 */
	public long getHighGradeSel() {
		return highGradeSel;
	}

	/**
	 * Sets the high grade sel.
	 *
	 * @param highGradeSel the new high grade sel
	 */
	public void setHighGradeSel(long highGradeSel) {
		this.highGradeSel = highGradeSel;
	}

	/**
	 * Gets the pay band.
	 *
	 * @return the pay band
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBandId;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBandId the new pay band
	 */
	public void setPayBand(PVUMsPayBandEntity payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the pay band value
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the new pay band value
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the grade pay
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePayId the new grade pay
	 */
	public void setGradePay(PVUMsGradePayEntity gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the pay scale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the new pay scale
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the LocalDate of high grade 1.
	 *
	 * @return the LocalDate of high grade 1
	 */
	public LocalDate getDateOfHighGrade1() {
		return dateOfHighGrade1;
	}

	/**
	 * Sets the LocalDate of high grade 1.
	 *
	 * @param dateOfHighGrade1 the new LocalDate of high grade 1
	 */
	public void setDateOfHighGrade1(LocalDate dateOfHighGrade1) {
		this.dateOfHighGrade1 = dateOfHighGrade1;
	}

	/**
	 * Gets the LocalDate of high grade 2.
	 *
	 * @return the LocalDate of high grade 2
	 */
	public LocalDate getDateOfHighGrade2() {
		return dateOfHighGrade2;
	}

	/**
	 * Sets the LocalDate of high grade 2.
	 *
	 * @param dateOfHighGrade2 the new LocalDate of high grade 2
	 */
	public void setDateOfHighGrade2(LocalDate dateOfHighGrade2) {
		this.dateOfHighGrade2 = dateOfHighGrade2;
	}

	/**
	 * Gets the LocalDate of high grade 3.
	 *
	 * @return the LocalDate of high grade 3
	 */
	public LocalDate getDateOfHighGrade3() {
		return dateOfHighGrade3;
	}

	/**
	 * Sets the LocalDate of high grade 3.
	 *
	 * @param dateOfHighGrade3 the new LocalDate of high grade 3
	 */
	public void setDateOfHighGrade3(LocalDate dateOfHighGrade3) {
		this.dateOfHighGrade3 = dateOfHighGrade3;
	}

	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * @return the payBandId
	 */
	public PVUMsPayBandEntity getPayBandId() {
		return payBandId;
	}

	/**
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(PVUMsPayBandEntity payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * @return the gradePayId
	 */
	public PVUMsGradePayEntity getGradePayId() {
		return gradePayId;
	}

	/**
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(PVUMsGradePayEntity gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, dateOfHighGrade1, dateOfHighGrade2, dateOfHighGrade3, designationId,
				empClass, empEvent, empId, eventEffectiveDate, id, eventOrderDate, eventOrderNo, gradePayId,
				highGradeSel, joinPromotionDate, joinPromotionPost, dateOfNextIncrement, officeId, payBandId, payBandValue,
				payComm, payLevel, payScale, promoDate, promoForgoDate, statusId, trnNo);
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
		if (!(obj instanceof PVUEmployeForgoEntity)) {
			return false;
		}
		PVUEmployeForgoEntity other = (PVUEmployeForgoEntity) obj;
		return basicPay == other.basicPay && Objects.equals(cellId, other.cellId)
				&& Objects.equals(dateOfHighGrade1, other.dateOfHighGrade1)
				&& Objects.equals(dateOfHighGrade2, other.dateOfHighGrade2)
				&& Objects.equals(dateOfHighGrade3, other.dateOfHighGrade3)
				&& Objects.equals(designationId, other.designationId) && Objects.equals(empClass, other.empClass)
				&& Objects.equals(empEvent, other.empEvent) && Objects.equals(empId, other.empId)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate) && id == other.id
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo)
				&& Objects.equals(gradePayId, other.gradePayId) && highGradeSel == other.highGradeSel
				&& Objects.equals(joinPromotionDate, other.joinPromotionDate)
				&& joinPromotionPost == other.joinPromotionPost
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(payBandId, other.payBandId) && payBandValue == other.payBandValue
				&& Objects.equals(payComm, other.payComm) && Objects.equals(payLevel, other.payLevel)
				&& payScale == other.payScale && Objects.equals(promoDate, other.promoDate)
				&& Objects.equals(promoForgoDate, other.promoForgoDate) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeForgoEntity [id=" + id + ", trnNo=" + trnNo + ", officeId=" + officeId
				+ ", payComm=" + payComm + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate
				+ ", eventEffectiveDate=" + eventEffectiveDate + ", statusId=" + statusId + ", empEvent=" + empEvent + ", empId="
				+ empId + ", empClass=" + empClass + ", designationId=" + designationId + ", payLevel=" + payLevel
				+ ", cellId=" + cellId + ", basicPay=" + basicPay + ", promoDate=" + promoDate + ", joinPromotionPost="
				+ joinPromotionPost + ", joinPromotionDate=" + joinPromotionDate + ", promoForgoDate=" + promoForgoDate
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", highGradeSel=" + highGradeSel + ", payBandId=" + payBandId
				+ ", payBandValue=" + payBandValue + ", gradePayId=" + gradePayId + ", payScale="
				+ payScale + ", dateOfHighGrade1=" + dateOfHighGrade1 + ", dateOfHighGrade2=" + dateOfHighGrade2
				+ ", dateOfHighGrade3=" + dateOfHighGrade3 + "]";
	}

	public PVUEmployeForgoEntity(long id) {
		super();
		this.id = id;
	}

	public PVUEmployeForgoEntity() {
		super();
	}
	
	

}