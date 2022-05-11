package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;

/**
 * The Class PVUEmploye6PayDetailEntity.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 *
 */
@Entity
@Table(name = "T_EMP_6PAY", schema = Constant.PVU_SCHEMA)
public class PVUEmployeSixPayDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sixpay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_6PAY_ID")
	private Long sixpayId;

	/** The emp designation as on. */
	@OneToOne(optional = false)
	@JoinColumn(name = "DSGN_112006", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity empDesignationAsOn;

	/** The emp other designation. */
	@Column(name = "IF_OTHER_DSGN")
	private String empOtherDesignation;

	/** The pre revised pay scale. */
	@OneToOne(optional = false)
	@JoinColumn(name = "P_RVSD_PAYSCL_112006", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity preRevisedPayScale;

	/** The pre revised basic pay. */
	@Column(name = "P_RVSD_PAY_112006")
	private Long preRevisedBasicPay;

	/** The revised pay band. */
	@OneToOne(optional = false)
	@JoinColumn(name = "RSVD_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity revisedPayBand;

	/** The grade pay. */
	@ManyToOne(optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The date of pre revised next increment. */
	@Column(name = "DATE_NXT_INCR_PRS")
	private Date dateOfPreRevisedNextIncrement;

	/** The npa amount. */
	@OneToOne(optional = false)
	@JoinColumn(name = "NPA_IF_APP", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity npaAmount;

	/** The status id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The date of option. */
	@Column(name = "OPTION_DATE")
	private Date dateOfOption;

	/** The date of stagnational. */
	@Column(name = "STAG_DATE")
	private Date dateOfStagnational;

	/** The increment amount. */
	@Column(name = "INCR_AMT")
	private Double incrementAmount;

	/** The pvu employe entity. */
	@OneToOne(optional = false)
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The pay band value. */
	@Column(name = "P_BAND_VAL_6_PAYC")
	private long payBandValue;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The date of next increment. */
	@Column(name = "DATE_NEXT_INCR")
	private Date dateOfNextIncrement;
	
	/**
	 * Gets the eff date.
	 *
	 * @return the eff date
	 */
	public Date getEffDate() {
		return effDate;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the new eff date
	 */
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	/** The eff date. */
	@Column(name = "EFF_DATE")
	private Date effDate;

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
	 * Gets the pvu employe entity.
	 *
	 * @return the pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the pvuEmployeEntity to set
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

    /**
	 * Gets the sixpay id.
	 *
	 * @return the sixpayId
	 */
	public Long getSixpayId() {
		return sixpayId;
	}

    /**
	 * Sets the sixpay id.
	 *
	 * @param sixpayId the sixpayId to set
	 */
	public void setSixpayId(Long sixpayId) {
		this.sixpayId = sixpayId;
	}

	/**
	 * Gets the emp other designation.
	 *
	 * @return the empOtherDesignation
	 */
	public String getEmpOtherDesignation() {
		return empOtherDesignation;
	}

	/**
	 * Sets the emp other designation.
	 *
	 * @param empOtherDesignation the empOtherDesignation to set
	 */
	public void setEmpOtherDesignation(String empOtherDesignation) {
		this.empOtherDesignation = empOtherDesignation;
	}

	/**
	 * Gets the emp designation as on.
	 *
	 * @return the empDesignationAsOn
	 */
	public EDPMsDesignationEntity getEmpDesignationAsOn() {
		return empDesignationAsOn;
	}

	/**
	 * Sets the emp designation as on.
	 *
	 * @param empDesignationAsOn the empDesignationAsOn to set
	 */
	public void setEmpDesignationAsOn(EDPMsDesignationEntity empDesignationAsOn) {
		this.empDesignationAsOn = empDesignationAsOn;
	}

	/**
	 * Gets the pre revised pay scale.
	 *
	 * @return the preRevisedPayScale
	 */
	public PVUMsPayScaleEntity getPreRevisedPayScale() {
		return preRevisedPayScale;
	}

	/**
	 * Sets the pre revised pay scale.
	 *
	 * @param preRevisedPayScale the preRevisedPayScale to set
	 */
	public void setPreRevisedPayScale(PVUMsPayScaleEntity preRevisedPayScale) {
		this.preRevisedPayScale = preRevisedPayScale;
	}

	/**
	 * Gets the pre revised basic pay.
	 *
	 * @return the preRevisedBasicPay
	 */
	public Long getPreRevisedBasicPay() {
		return preRevisedBasicPay;
	}

	/**
	 * Sets the pre revised basic pay.
	 *
	 * @param preRevisedBasicPay the preRevisedBasicPay to set
	 */
	public void setPreRevisedBasicPay(Long preRevisedBasicPay) {
		this.preRevisedBasicPay = preRevisedBasicPay;
	}

	/**
	 * Gets the revised pay band.
	 *
	 * @return the revisedPayBand
	 */
	public PVUMsPayBandEntity getRevisedPayBand() {
		return revisedPayBand;
	}

	/**
	 * Sets the revised pay band.
	 *
	 * @param revisedPayBand the revisedPayBand to set
	 */
	public void setRevisedPayBand(PVUMsPayBandEntity revisedPayBand) {
		this.revisedPayBand = revisedPayBand;
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
	 * Sets the npa amount.
	 *
	 * @param npaAmount the npaAmount to set
	 */
	public void setNpaAmount(EDPLuLookUpInfoEntity npaAmount) {
		this.npaAmount = npaAmount;
	}

	/**
	 * Gets the date of pre revised next increment.
	 *
	 * @return the dateOfPreRevisedNextIncrement
	 */
	public Date getDateOfPreRevisedNextIncrement() {
		return dateOfPreRevisedNextIncrement;
	}

	/**
	 * Sets the date of pre revised next increment.
	 *
	 * @param dateOfPreRevisedNextIncrement the dateOfPreRevisedNextIncrement to set
	 */
	public void setDateOfPreRevisedNextIncrement(Date dateOfPreRevisedNextIncrement) {
		this.dateOfPreRevisedNextIncrement = dateOfPreRevisedNextIncrement;
	}

	/**
	 * Gets the npa amount.
	 *
	 * @return the npaAmount
	 */
	public EDPLuLookUpInfoEntity getNpaAmount() {
		return npaAmount;
	}

	/**
	 * Gets the date of option.
	 *
	 * @return the dateOfOption
	 */
	public Date getDateOfOption() {
		return dateOfOption;
	}

	/**
	 * Sets the date of option.
	 *
	 * @param dateOfOption the dateOfOption to set
	 */
	public void setDateOfOption(Date dateOfOption) {
		this.dateOfOption = dateOfOption;
	}

	/**
	 * Gets the date of stagnational.
	 *
	 * @return the dateOfStagnational
	 */
	public Date getDateOfStagnational() {
		return dateOfStagnational;
	}

	/**
	 * Sets the date of stagnational.
	 *
	 * @param dateOfStagnational the dateOfStagnational to set
	 */
	public void setDateOfStagnational(Date dateOfStagnational) {
		this.dateOfStagnational = dateOfStagnational;
	}

	/**
	 * Gets the increment amount.
	 *
	 * @return the incrementAmount
	 */
	public Double getIncrementAmount() {
		return incrementAmount;
	}

	/**
	 * Sets the increment amount.
	 *
	 * @param incrementAmount the incrementAmount to set
	 */
	public void setIncrementAmount(Double incrementAmount) {
		this.incrementAmount = incrementAmount;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, dateOfNextIncrement, dateOfOption, dateOfPreRevisedNextIncrement,
				dateOfStagnational, effDate, empDesignationAsOn, empOtherDesignation, gradePay, incrementAmount,
				npaAmount, payBandValue, preRevisedBasicPay, preRevisedPayScale, pvuEmployeEntity, revisedPayBand,
				sixpayId, statusId);
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
		PVUEmployeSixPayDetailEntity other = (PVUEmployeSixPayDetailEntity) obj;
		return basicPay == other.basicPay && Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(dateOfOption, other.dateOfOption)
				&& Objects.equals(dateOfPreRevisedNextIncrement, other.dateOfPreRevisedNextIncrement)
				&& Objects.equals(dateOfStagnational, other.dateOfStagnational)
				&& Objects.equals(effDate, other.effDate)
				&& Objects.equals(empDesignationAsOn, other.empDesignationAsOn)
				&& Objects.equals(empOtherDesignation, other.empOtherDesignation)
				&& Objects.equals(gradePay, other.gradePay) && Objects.equals(incrementAmount, other.incrementAmount)
				&& Objects.equals(npaAmount, other.npaAmount) && payBandValue == other.payBandValue
				&& Objects.equals(preRevisedBasicPay, other.preRevisedBasicPay)
				&& Objects.equals(preRevisedPayScale, other.preRevisedPayScale)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity)
				&& Objects.equals(revisedPayBand, other.revisedPayBand) && Objects.equals(sixpayId, other.sixpayId)
				&& Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeSixPayDetailEntity [sixpayId=" + sixpayId + ", empDesignationAsOn=" + empDesignationAsOn
				+ ", empOtherDesignation=" + empOtherDesignation + ", preRevisedPayScale=" + preRevisedPayScale
				+ ", preRevisedBasicPay=" + preRevisedBasicPay + ", revisedPayBand=" + revisedPayBand + ", gradePay="
				+ gradePay + ", dateOfPreRevisedNextIncrement=" + dateOfPreRevisedNextIncrement + ", npaAmount="
				+ npaAmount + ", statusId=" + statusId + ", dateOfOption=" + dateOfOption + ", dateOfStagnational="
				+ dateOfStagnational + ", incrementAmount=" + incrementAmount + ", pvuEmployeEntity=" + pvuEmployeEntity
				+ ", payBandValue=" + payBandValue + ", basicPay=" + basicPay + ", dateOfNextIncrement="
				+ dateOfNextIncrement + ", effDate=" + effDate + "]";
	}

}
