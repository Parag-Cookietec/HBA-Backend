package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
 * The Class PVUPromotionEntity.
 */

@Entity
@Table(name = "T_PVU_PR_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUPromotionEntity extends PVUCurrentEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_PR_EVNT_ID")
	private Long id;

	/**
	 * The trn no.
	 */
	@Column(name = "TRN_NO")
	private String trnNo;

	/**
	 * The office id.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity office;

	/**
	 * The pay comm.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/**
	 * The event order no.
	 */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/**
	 * The event order date.
	 */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/**
	 * The event effective date.
	 */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/**
	 * The status.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/**
	 * The promotion type.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_PR_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity promotionType;

	/**
	 * The employee.
	 */
	@ManyToOne
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity employee;

	/**
	 * The employee class.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_CLASS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity employeeClass;

	/**
	 * The designation.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designation;

	/**
	 * The option available.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OPT_AVAIL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity optionAvailable;

	/**
	 * The option available date.
	 */
	@Column(name = "OPT_AVAIL_DATE")
	private LocalDate optionAvailableDate;

	/**
	 * The pay scale.
	 */
	@Column(name = "SCALE")
	private long payScale;

	/**
	 * The pay level.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/**
	 * The cell.
	 */
	@OneToOne
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cell;

	/**
	 * The pay band.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/**
	 * The pay band value.
	 */
	// Based on Band value will come
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;

	/**
	 * The grade pay.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/**
	 * The basic pay.
	 */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/**
	 * The date of joining.
	 */
	@Column(name = "DATE_OF_JOINING") // actual promotion post join date
	private LocalDate dateOfJoining;

	/**
	 * The noon type.
	 */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NOON_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity noonType;

	/**
	 * The date of next increment.
	 */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/**
	 * The remarks.
	 */
	@Column(name = "REMARKS")
	private String remarks;

	/**
	 * The departmentCategoryId.
	 */
	@Column(name = "DEPT_CAT_ID")
	private Long departmentCategoryId;

	/** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

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

	/**
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Instantiates a new PVU promotion entity.
	 *
	 * @param id the id
	 */
	public PVUPromotionEntity(Long id) {
		this.id = id;
	}

	/**
	 * Instantiates a new PVU promotion entity.
	 */
	public PVUPromotionEntity() {
	}

	/* Getter Setter */

	/**
	 * Gets the promotion type.
	 *
	 * @return the promotionType
	 */
	public EDPLuLookUpInfoEntity getPromotionType() {
		return promotionType;
	}

	/**
	 * Set promotionType.
	 *
	 * @param promotionType promotionType
	 */
	public void setPromotionType(EDPLuLookUpInfoEntity promotionType) {
		this.promotionType = promotionType;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public PVUEmployeEntity getEmployee() {
		return employee;
	}

	/**
	 * Set employee.
	 *
	 * @param employee employee
	 */
	public void setEmployee(PVUEmployeEntity employee) {
		this.employee = employee;
	}

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
	 * Gets the option available date.
	 *
	 * @return the optionAvailableDate
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Set optionAvailableDate.
	 *
	 * @param optionAvailableDate optionAvailableDate
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
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
	 * Set payScale.
	 *
	 * @param payScale payScale
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
	 * Set payLevel.
	 *
	 * @param payLevel payLevel
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell.
	 *
	 * @return the cell
	 */
	public PVUMsPayCellEntity getCell() {
		return cell;
	}

	/**
	 * Set cell.
	 *
	 * @param cell cell
	 */
	public void setCell(PVUMsPayCellEntity cell) {
		this.cell = cell;
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
	 * Gets the date of joining.
	 *
	 * @return the dateOfJoining
	 */
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Set dateOfJoining.
	 *
	 * @param dateOfJoining dateOfJoining
	 */
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the noon type.
	 *
	 * @return the noonType
	 */
	public EDPLuLookUpInfoEntity getNoonType() {
		return noonType;
	}

	/**
	 * Set noonType.
	 *
	 * @param noonType noonType
	 */
	public void setNoonType(EDPLuLookUpInfoEntity noonType) {
		this.noonType = noonType;
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
	 * Set dateOfNextIncrement.
	 *
	 * @param dateOfNextIncrement dateOfNextIncrement
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Set remarks.
	 *
	 * @param remarks remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * Getter for property 'departmentCategoryId'.
	 *
	 * @return Value for property 'departmentCategoryId'.
	 */
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * Setter for property 'departmentCategoryId'.
	 *
	 * @param departmentCategoryId Value to set for property 'departmentCategoryId'.
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (basicPay ^ (basicPay >>> 32));
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((dateOfNextIncrement == null) ? 0 : dateOfNextIncrement.hashCode());
		result = prime * result + ((departmentCategoryId == null) ? 0 : departmentCategoryId.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((employeeClass == null) ? 0 : employeeClass.hashCode());
		result = prime * result + ((eventEffectiveDate == null) ? 0 : eventEffectiveDate.hashCode());
		result = prime * result + ((eventOrderDate == null) ? 0 : eventOrderDate.hashCode());
		result = prime * result + ((eventOrderNo == null) ? 0 : eventOrderNo.hashCode());
		result = prime * result + ((gradePay == null) ? 0 : gradePay.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((noonType == null) ? 0 : noonType.hashCode());
		result = prime * result + ((oaBasicPayValue == null) ? 0 : oaBasicPayValue.hashCode());
		result = prime * result + ((oaCellIdValue == null) ? 0 : oaCellIdValue.hashCode());
		result = prime * result + ((oaGradePayId == null) ? 0 : oaGradePayId.hashCode());
		result = prime * result + ((oaPayBandId == null) ? 0 : oaPayBandId.hashCode());
		result = prime * result + ((oaPayBandValue == null) ? 0 : oaPayBandValue.hashCode());
		result = prime * result + ((oaPayCellId == null) ? 0 : oaPayCellId.hashCode());
		result = prime * result + ((oaPayLevelId == null) ? 0 : oaPayLevelId.hashCode());
		result = prime * result + ((oaPayScaleId == null) ? 0 : oaPayScaleId.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((optionAvailable == null) ? 0 : optionAvailable.hashCode());
		result = prime * result + ((optionAvailableDate == null) ? 0 : optionAvailableDate.hashCode());
		result = prime * result + ((payBand == null) ? 0 : payBand.hashCode());
		result = prime * result + (int) (payBandValue ^ (payBandValue >>> 32));
		result = prime * result + ((payComm == null) ? 0 : payComm.hashCode());
		result = prime * result + ((payLevel == null) ? 0 : payLevel.hashCode());
		result = prime * result + (int) (payScale ^ (payScale >>> 32));
		result = prime * result + ((promotionType == null) ? 0 : promotionType.hashCode());
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((trnNo == null) ? 0 : trnNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUPromotionEntity other = (PVUPromotionEntity) obj;
		if (basicPay != other.basicPay)
			return false;
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (dateOfNextIncrement == null) {
			if (other.dateOfNextIncrement != null)
				return false;
		} else if (!dateOfNextIncrement.equals(other.dateOfNextIncrement))
			return false;
		if (departmentCategoryId == null) {
			if (other.departmentCategoryId != null)
				return false;
		} else if (!departmentCategoryId.equals(other.departmentCategoryId))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (employeeClass == null) {
			if (other.employeeClass != null)
				return false;
		} else if (!employeeClass.equals(other.employeeClass))
			return false;
		if (eventEffectiveDate == null) {
			if (other.eventEffectiveDate != null)
				return false;
		} else if (!eventEffectiveDate.equals(other.eventEffectiveDate))
			return false;
		if (eventOrderDate == null) {
			if (other.eventOrderDate != null)
				return false;
		} else if (!eventOrderDate.equals(other.eventOrderDate))
			return false;
		if (eventOrderNo == null) {
			if (other.eventOrderNo != null)
				return false;
		} else if (!eventOrderNo.equals(other.eventOrderNo))
			return false;
		if (gradePay == null) {
			if (other.gradePay != null)
				return false;
		} else if (!gradePay.equals(other.gradePay))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (noonType == null) {
			if (other.noonType != null)
				return false;
		} else if (!noonType.equals(other.noonType))
			return false;
		if (oaBasicPayValue == null) {
			if (other.oaBasicPayValue != null)
				return false;
		} else if (!oaBasicPayValue.equals(other.oaBasicPayValue))
			return false;
		if (oaCellIdValue == null) {
			if (other.oaCellIdValue != null)
				return false;
		} else if (!oaCellIdValue.equals(other.oaCellIdValue))
			return false;
		if (oaGradePayId == null) {
			if (other.oaGradePayId != null)
				return false;
		} else if (!oaGradePayId.equals(other.oaGradePayId))
			return false;
		if (oaPayBandId == null) {
			if (other.oaPayBandId != null)
				return false;
		} else if (!oaPayBandId.equals(other.oaPayBandId))
			return false;
		if (oaPayBandValue == null) {
			if (other.oaPayBandValue != null)
				return false;
		} else if (!oaPayBandValue.equals(other.oaPayBandValue))
			return false;
		if (oaPayCellId == null) {
			if (other.oaPayCellId != null)
				return false;
		} else if (!oaPayCellId.equals(other.oaPayCellId))
			return false;
		if (oaPayLevelId == null) {
			if (other.oaPayLevelId != null)
				return false;
		} else if (!oaPayLevelId.equals(other.oaPayLevelId))
			return false;
		if (oaPayScaleId == null) {
			if (other.oaPayScaleId != null)
				return false;
		} else if (!oaPayScaleId.equals(other.oaPayScaleId))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (optionAvailable == null) {
			if (other.optionAvailable != null)
				return false;
		} else if (!optionAvailable.equals(other.optionAvailable))
			return false;
		if (optionAvailableDate == null) {
			if (other.optionAvailableDate != null)
				return false;
		} else if (!optionAvailableDate.equals(other.optionAvailableDate))
			return false;
		if (payBand == null) {
			if (other.payBand != null)
				return false;
		} else if (!payBand.equals(other.payBand))
			return false;
		if (payBandValue != other.payBandValue)
			return false;
		if (payComm == null) {
			if (other.payComm != null)
				return false;
		} else if (!payComm.equals(other.payComm))
			return false;
		if (payLevel == null) {
			if (other.payLevel != null)
				return false;
		} else if (!payLevel.equals(other.payLevel))
			return false;
		if (payScale != other.payScale)
			return false;
		if (promotionType == null) {
			if (other.promotionType != null)
				return false;
		} else if (!promotionType.equals(other.promotionType))
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (trnNo == null) {
			if (other.trnNo != null)
				return false;
		} else if (!trnNo.equals(other.trnNo))
			return false;
		return true;
	}

}
