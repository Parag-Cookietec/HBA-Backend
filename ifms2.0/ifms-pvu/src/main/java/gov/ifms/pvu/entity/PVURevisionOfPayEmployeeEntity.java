package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class PVURevisionOfPayEntity.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
@Entity
@Table(name = "T_PVU_RP_EMP", schema = Constant.PVU_SCHEMA)
public class PVURevisionOfPayEmployeeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RP_EMP_ID")
	private long id;

	/**
	 * The suspension.
	 */
	@ManyToOne
	@JoinColumn(name = "T_PVU_RP_EVNT_ID", nullable = false, referencedColumnName = "T_PVU_RP_EVNT_ID")
	private PVURevisionOfPayEntity revisionOfPay;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The employee. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity employee;

	/**
	 * The pay level.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity revPayLevel;

	/**
	 * The cell id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity revCell;

	/**
	 * The pay band.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity revPayBand;

	/**
	 * The pay band value.
	 */
	@Column(name = "R_PAY_BAND_VALUE")
	private long revPayBandValue;

	/**
	 * The grade pay.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity revGradePay;

	/** The rev basic pay. */
	@Column(name = "R_BASIC_PAY")
	private long revBasicPay;

	/** The reason for exclude. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REASON_FOR_EXCLUDE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reasonForExclude;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The benefit eff date. */
	@Column(name = "BEN_EFF_DATE")
	private LocalDate benefitEffDate;

	/** The next incr date. */
	@Column(name = "NEXT_INCR_DATE")
	private LocalDate nextIncrDate;

	/**
	 * The status id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The is eligible. */
	@Column(name = "IS_ELIGIBLE")
	private boolean isEligible;

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
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the revision of pay.
	 *
	 * @return the revision of pay
	 */
	public PVURevisionOfPayEntity getRevisionOfPay() {
		return revisionOfPay;
	}

	/**
	 * Sets the revision of pay.
	 *
	 * @param revisionOfPay the new revision of pay
	 */
	public void setRevisionOfPay(PVURevisionOfPayEntity revisionOfPay) {
		this.revisionOfPay = revisionOfPay;
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
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public PVUEmployeEntity getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(PVUEmployeEntity employee) {
		this.employee = employee;
	}

	/**
	 * Gets the rev pay level.
	 *
	 * @return the rev pay level
	 */
	public PVUMsPayLevelEntity getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * Sets the rev pay level.
	 *
	 * @param revPayLevel the new rev pay level
	 */
	public void setRevPayLevel(PVUMsPayLevelEntity revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * Gets the rev cell.
	 *
	 * @return the rev cell
	 */
	public PVUMsPayCellEntity getRevCell() {
		return revCell;
	}

	/**
	 * Sets the rev cell.
	 *
	 * @param revCell the new rev cell
	 */
	public void setRevCell(PVUMsPayCellEntity revCell) {
		this.revCell = revCell;
	}

	/**
	 * Gets the rev pay band.
	 *
	 * @return the rev pay band
	 */
	public PVUMsPayBandEntity getRevPayBand() {
		return revPayBand;
	}

	/**
	 * Sets the rev pay band.
	 *
	 * @param revPayBand the new rev pay band
	 */
	public void setRevPayBand(PVUMsPayBandEntity revPayBand) {
		this.revPayBand = revPayBand;
	}

	/**
	 * Gets the rev pay band value.
	 *
	 * @return the rev pay band value
	 */
	public long getRevPayBandValue() {
		return revPayBandValue;
	}

	/**
	 * Sets the rev pay band value.
	 *
	 * @param revPayBandValue the new rev pay band value
	 */
	public void setRevPayBandValue(long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	/**
	 * Gets the rev grade pay.
	 *
	 * @return the rev grade pay
	 */
	public PVUMsGradePayEntity getRevGradePay() {
		return revGradePay;
	}

	/**
	 * Sets the rev grade pay.
	 *
	 * @param revGradePay the new rev grade pay
	 */
	public void setRevGradePay(PVUMsGradePayEntity revGradePay) {
		this.revGradePay = revGradePay;
	}

	/**
	 * Gets the rev basic pay.
	 *
	 * @return the rev basic pay
	 */
	public long getRevBasicPay() {
		return revBasicPay;
	}

	/**
	 * Sets the rev basic pay.
	 *
	 * @param revBasicPay the new rev basic pay
	 */
	public void setRevBasicPay(long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	/**
	 * Gets the reason for exclude.
	 *
	 * @return the reason for exclude
	 */
	public EDPLuLookUpInfoEntity getReasonForExclude() {
		return reasonForExclude;
	}

	/**
	 * Sets the reason for exclude.
	 *
	 * @param reasonForExclude the new reason for exclude
	 */
	public void setReasonForExclude(EDPLuLookUpInfoEntity reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
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
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the benefit eff date.
	 *
	 * @return the benefit eff date
	 */
	public LocalDate getBenefitEffDate() {
		return benefitEffDate;
	}

	/**
	 * Sets the benefit eff date.
	 *
	 * @param benefitEffDate the new benefit eff date
	 */
	public void setBenefitEffDate(LocalDate benefitEffDate) {
		this.benefitEffDate = benefitEffDate;
	}

	/**
	 * Gets the next incr date.
	 *
	 * @return the next incr date
	 */
	public LocalDate getNextIncrDate() {
		return nextIncrDate;
	}

	/**
	 * Sets the next incr date.
	 *
	 * @param nextIncrDate the new next incr date
	 */
	public void setNextIncrDate(LocalDate nextIncrDate) {
		this.nextIncrDate = nextIncrDate;
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
	 * @param status the new status
	 */
	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	/**
	 * Checks if is eligible.
	 *
	 * @return true, if is eligible
	 */
	public boolean isEligible() {
		return isEligible;
	}

	/**
	 * Sets the eligible.
	 *
	 * @param eligible the new eligible
	 */
	public void setEligible(boolean eligible) {
		isEligible = eligible;
	}
}
