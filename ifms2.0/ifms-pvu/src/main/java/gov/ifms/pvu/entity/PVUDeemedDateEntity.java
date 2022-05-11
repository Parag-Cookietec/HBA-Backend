package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentEntity;

/**
 * The Class PVUDeemedDateEntity.
 */

@Entity
@Table(name = "T_PVU_DD_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUDeemedDateEntity extends PVUCurrentEntity implements Serializable {
	public PVUDeemedDateEntity(Long id) {
		this.id = id;
	}

	public PVUDeemedDateEntity() {

	}

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_DD_EVNT_ID")
	private Long id;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID")
	private EDPMsOfficeEntity office;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM")
	private EDPLuLookUpInfoEntity payComm;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The employee class. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity employeeClass;

	/** The designation. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESIGNATION_ID", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designation;

	/** The option available. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OPTION_AVAIL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity optionAvailable;

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

	/** The benefit effective date. */
	@Column(name = "BEN_EFF_DATE")
	private LocalDate benefitEffectiveDate;

	/** The deemed date. */
	@Column(name = "DEEM_DATE")
	private LocalDate deemedDate;

	/** The actual date promo. */
	@Column(name = "ACT_DATE_PRM")
	private LocalDate actualDatePromo;

	/** The duration. */
	@Column(name = "DURT")
	private int duration;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The status. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The pay scale. */
	@Column(name = "PAY_SCALE")
	private long payScale;

	/** The pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevelId;

	/** The cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The against employee. */
	@ManyToOne
	@JoinColumn(name = "AGAINST_EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity againstEmployee;

	/** The option available date. */
	@Column(name = "OPTION_AVAIL_DATE")
	private LocalDate optionAvailableDate;

	/** The date of next increment. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/**
	 * The departmentCategoryId.
	 */
	@Column(name = "DEPT_CAT_ID")
	private Long departmentCategoryId;

	/** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	@Column(name = "SR_SENIOR_NO")
	private Long srSeniorNo;

	@Column(name = "JR_SENIOR_NO")
	private Long jrSeniorNo;
	
	/** The date of last pf date. */
	@Column(name = "LAST_PF_DATE")
	private LocalDate lastPfDate;
	
	/** The oa basic pay value. */
	@Column(name = "OA_EMP_BASIC_PAY")
	private Long oaBasicPayValue;

	/** The oa pay scale id. */
	@Column(name = "OA_PAY_SCALE")
	private Long oaPayScaleId;

	/** The oa pay band id. */
	@Column(name = "OA_EMP_PAY_BAND")
	private Long oaPayBandId;

	/** The oa pay band value. */
	@Column(name = "OA_PAY_BAND_VALUE")
	private Long oaPayBandValue;

	/** The oa grade pay id. */
	@Column(name = "OA_EMP_GRD_PAY")
	private Long oaGradePayId;

	/** The oa pay level id. */
	@Column(name = "OA_EMP_PAY_LEVEL")
	private Long oaPayLevelId;

	/** The oa cell id value. */
	@Column(name = "OA_CELL_ID")
	private Long oaCellIdValue;

	/** The oa pay cell id. */
	@Column(name = "OA_PAY_CELL_ID")
	private Long oaPayCellId;
		
	public LocalDate getLastPfDate() {
		return lastPfDate;
	}

	public void setLastPfDate(LocalDate lastPfDate) {
		this.lastPfDate = lastPfDate;
	}

	public Long getSrSeniorNo() {
		return srSeniorNo;
	}

	public void setSrSeniorNo(Long srSeniorNo) {
		this.srSeniorNo = srSeniorNo;
	}

	public Long getJrSeniorNo() {
		return jrSeniorNo;
	}

	public void setJrSeniorNo(Long jrSeniorNo) {
		this.jrSeniorNo = jrSeniorNo;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/* Getter Setter */

	/**
	 * Gets the employee class.
	 *
	 * @return the employeeClass
	 */
	public EDPLuLookUpInfoEntity getEmployeeClass() {
		return employeeClass;
	}

	/**
	 * Set employeeClass.
	 *
	 * @param employeeClass employeeClass
	 */
	public void setEmployeeClass(EDPLuLookUpInfoEntity employeeClass) {
		this.employeeClass = employeeClass;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public EDPMsDesignationEntity getDesignation() {
		return designation;
	}

	/**
	 * Set designation.
	 *
	 * @param designation designation
	 */
	public void setDesignation(EDPMsDesignationEntity designation) {
		this.designation = designation;
	}

	/**
	 * Gets the option available.
	 *
	 * @return the optionAvailable
	 */
	public EDPLuLookUpInfoEntity getOptionAvailable() {
		return optionAvailable;
	}

	/**
	 * Set optionAvailable.
	 *
	 * @param optionAvailable optionAvailable
	 */
	public void setOptionAvailable(EDPLuLookUpInfoEntity optionAvailable) {
		this.optionAvailable = optionAvailable;
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
	 * Set payBand.
	 *
	 * @param payBand payBand
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
	 * Set payBandValue.
	 *
	 * @param payBandValue payBandValue
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
	 * Set gradePay.
	 *
	 * @param gradePay gradePay
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
	 * Set basicPay.
	 *
	 * @param basicPay basicPay
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the office.
	 *
	 * @return the office
	 */
	public EDPMsOfficeEntity getOffice() {
		return office;
	}

	/**
	 * Sets the office.
	 *
	 * @param office the office to set
	 */
	public void setOffice(EDPMsOfficeEntity office) {
		this.office = office;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	/**
	 * Sets the benefit effective date.
	 *
	 * @param benefitEffectiveDate the benefitEffectiveDate to set
	 */
	public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}

	/**
	 * Sets the deemed date.
	 *
	 * @param deemedDate the deemDate to set
	 */
	public void setDeemedDate(LocalDate deemedDate) {
		this.deemedDate = deemedDate;
	}

	/**
	 * Sets the actual date promo.
	 *
	 * @param actualDatePromo the actualPromotionDate to set
	 */
	public void setActualDatePromo(LocalDate actualDatePromo) {
		this.actualDatePromo = actualDatePromo;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the notionalDuration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
	 * Gets the benefit effective date.
	 *
	 * @return the benefitEffectiveDate
	 */
	public LocalDate getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	/**
	 * Gets the deemed date.
	 *
	 * @return the deemDate
	 */
	public LocalDate getDeemedDate() {
		return deemedDate;
	}

	/**
	 * Gets the actual date promo.
	 *
	 * @return the actualPromotionDate
	 */
	public LocalDate getActualDatePromo() {
		return actualDatePromo;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the notionalDuration
	 */
	public int getDuration() {
		return duration;
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
	 * Gets the against employee.
	 *
	 * @return the againstEmployee
	 */
	public PVUEmployeEntity getAgainstEmployee() {
		return againstEmployee;
	}

	/**
	 * Sets the against employee.
	 *
	 * @param againstEmployee the againstEmployee
	 */
	public void setAgainstEmployee(PVUEmployeEntity againstEmployee) {
		this.againstEmployee = againstEmployee;
	}

	/**
	 * toString method.
	 *
	 * @return the option available date
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Sets the option available date.
	 *
	 * @param optionAvailableDate the new option available date
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
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
	 * Gets the pay level.
	 *
	 * @return the pay level
	 */
	public PVUMsPayLevelEntity getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevelId the new pay level
	 */
	public void setPayLevelId(PVUMsPayLevelEntity payLevelId) {
		this.payLevelId = payLevelId;
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

	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}
	
	

	/**
	 * @return the oaBasicPayValue
	 */
	public Long getOaBasicPayValue() {
		return oaBasicPayValue;
	}

	/**
	 * @param oaBasicPayValue the oaBasicPayValue to set
	 */
	public void setOaBasicPayValue(Long oaBasicPayValue) {
		this.oaBasicPayValue = oaBasicPayValue;
	}

	/**
	 * @return the oaPayScaleId
	 */
	public Long getOaPayScaleId() {
		return oaPayScaleId;
	}

	/**
	 * @param oaPayScaleId the oaPayScaleId to set
	 */
	public void setOaPayScaleId(Long oaPayScaleId) {
		this.oaPayScaleId = oaPayScaleId;
	}

	/**
	 * @return the oaPayBandId
	 */
	public Long getOaPayBandId() {
		return oaPayBandId;
	}

	/**
	 * @param oaPayBandId the oaPayBandId to set
	 */
	public void setOaPayBandId(Long oaPayBandId) {
		this.oaPayBandId = oaPayBandId;
	}

	/**
	 * @return the oaPayBandValue
	 */
	public Long getOaPayBandValue() {
		return oaPayBandValue;
	}

	/**
	 * @param oaPayBandValue the oaPayBandValue to set
	 */
	public void setOaPayBandValue(Long oaPayBandValue) {
		this.oaPayBandValue = oaPayBandValue;
	}

	/**
	 * @return the oaGradePayId
	 */
	public Long getOaGradePayId() {
		return oaGradePayId;
	}

	/**
	 * @param oaGradePayId the oaGradePayId to set
	 */
	public void setOaGradePayId(Long oaGradePayId) {
		this.oaGradePayId = oaGradePayId;
	}

	/**
	 * @return the oaPayLevelId
	 */
	public Long getOaPayLevelId() {
		return oaPayLevelId;
	}

	/**
	 * @param oaPayLevelId the oaPayLevelId to set
	 */
	public void setOaPayLevelId(Long oaPayLevelId) {
		this.oaPayLevelId = oaPayLevelId;
	}

	/**
	 * @return the oaCellIdValue
	 */
	public Long getOaCellIdValue() {
		return oaCellIdValue;
	}

	/**
	 * @param oaCellIdValue the oaCellIdValue to set
	 */
	public void setOaCellIdValue(Long oaCellIdValue) {
		this.oaCellIdValue = oaCellIdValue;
	}

	/**
	 * @return the oaPayCellId
	 */
	public Long getOaPayCellId() {
		return oaPayCellId;
	}

	/**
	 * @param oaPayCellId the oaPayCellId to set
	 */
	public void setOaPayCellId(Long oaPayCellId) {
		this.oaPayCellId = oaPayCellId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(actualDatePromo, againstEmployee, basicPay, benefitEffectiveDate, cellId,
				dateOfNextIncrement, deemedDate, designation, duration, employeeClass, eventEffectiveDate,
				eventOrderDate, eventOrderNo, gradePay, id, office, optionAvailable, optionAvailableDate, payBand,
				payBandValue, payComm, payLevelId, payScale, remarks, status, trnNo, departmentCategoryId,
				oaCellIdValue, oaBasicPayValue, oaGradePayId, oaPayBandId, oaPayBandValue, oaPayCellId, oaPayScaleId, oaPayLevelId);
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
		PVUDeemedDateEntity other = (PVUDeemedDateEntity) obj;
		return Objects.equals(actualDatePromo, other.actualDatePromo)
				&& Objects.equals(againstEmployee, other.againstEmployee) && basicPay == other.basicPay
				&& Objects.equals(benefitEffectiveDate, other.benefitEffectiveDate)
				&& Objects.equals(cellId, other.cellId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(deemedDate, other.deemedDate) && Objects.equals(designation, other.designation)
				&& duration == other.duration
				&& Objects.equals(employeeClass, other.employeeClass)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && Objects.equals(gradePay, other.gradePay)
				&& Objects.equals(id, other.id) && Objects.equals(office, other.office)
				&& Objects.equals(optionAvailable, other.optionAvailable)
				&& Objects.equals(optionAvailableDate, other.optionAvailableDate)
				&& Objects.equals(payBand, other.payBand) && payBandValue == other.payBandValue
				&& Objects.equals(payComm, other.payComm) && Objects.equals(payLevelId, other.payLevelId)
				&& payScale == other.payScale && Objects.equals(remarks, other.remarks)
				&& Objects.equals(status, other.status) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(departmentCategoryId, other.departmentCategoryId)
				&& Objects.equals(oaBasicPayValue, other.oaBasicPayValue)
				&& Objects.equals(oaCellIdValue, other.oaCellIdValue)
				&& Objects.equals(oaGradePayId, other.oaGradePayId)
				&& Objects.equals(oaPayBandId, other.oaPayBandId)
				&& Objects.equals(oaPayBandValue, other.oaPayBandValue)
				&& Objects.equals(oaPayCellId, other.oaPayCellId)
				&& Objects.equals(oaPayLevelId, other.oaPayLevelId)
				&& Objects.equals(oaPayScaleId, other.oaPayScaleId);
	}

	@Override
	public String toString() {
		return "PVUDeemedDateEntity [id=" + id + ", trnNo=" + trnNo + ", office=" + office + ", payComm=" + payComm
				+ ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate="
				+ eventEffectiveDate + ", employeeClass=" + employeeClass + ", designation=" + designation
				+ ", optionAvailable=" + optionAvailable + ", payBand=" + payBand + ", payBandValue=" + payBandValue
				+ ", gradePay=" + gradePay + ", basicPay=" + basicPay + ", benefitEffectiveDate=" + benefitEffectiveDate
				+ ", deemedDate=" + deemedDate + ", actualDatePromo=" + actualDatePromo + ", duration=" + duration
				+ ", remarks=" + remarks + ", status=" + status + ", payScale=" + payScale + ", payLevelId="
				+ payLevelId + ", cellId=" + cellId + ", againstEmployee=" + againstEmployee + ", optionAvailableDate="
				+ optionAvailableDate + ", dateOfNextIncrement=" + dateOfNextIncrement + ", departmentCategoryId="
				+ departmentCategoryId + ", refDate=" + refDate + ", srSeniorNo=" + srSeniorNo + ", jrSeniorNo="
				+ jrSeniorNo + ", lastPfDate=" + lastPfDate + ", oaBasicPayValue=" + oaBasicPayValue + ", oaPayScaleId="
				+ oaPayScaleId + ", oaPayBandId=" + oaPayBandId + ", oaPayBandValue=" + oaPayBandValue
				+ ", oaGradePayId=" + oaGradePayId + ", oaPayLevelId=" + oaPayLevelId + ", oaCellIdValue="
				+ oaCellIdValue + ", oaPayCellId=" + oaPayCellId + "]";
	}


}
