package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeSixPayDetailDto.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 *
 */
public class PVUEmployeSixPayDetailDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The sixpay id. */
	private Long sixpayId;

	/** The emp designation as on. */
	private Long empDesignationAsOn;
	private String empDesignationAsOnName;

	/** The emp other designation. */
	private String empOtherDesignation;

	/** The pre revised pay scale. */
	private Long preRevisedPayScale;
	private String preRevisedPayScaleName;

	/** The pre revised basic pay. */
	private Long preRevisedBasicPay;

	/** The revised pay band. */
	private Long revisedPayBand;
	private String revisedPayBandName;

	/** The grade pay. */
	private Long gradePay;
	private String gradePayName;

	/** The grade pay. */
	private Long statusId;

	/** The date of pre revised next increment. */
	private Date dateOfPreRevisedNextIncrement;

	/** The npa amount. */
	private Long npaAmount;
	private String npaAmountName;

	/** The date of option. */
	private Date dateOfOption;

	/** The date of stagnational. */
	private Date dateOfStagnational;

	/** The increment amount. */
	private Double incrementAmount;

	/** The emp id. */
	private Long empId;

	/** The pay band value. */
	private Long payBandValue;

	/** The date of next increment. */
	private Date dateOfNextIncrement;

	/** The basic pay. */
	private Long basicPay;

	/** The eff date. */
	private Date effDate;

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

	/**
	 * Gets the basic pay.
	 *
	 * @return the basic pay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the new basic pay
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Instantiates a new PVU employe six pay detail dto.
	 */
	public PVUEmployeSixPayDetailDto() {
		super();
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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
	 * Gets the emp designation as on.
	 *
	 * @return the empDesignationAsOn
	 */
	public Long getEmpDesignationAsOn() {
		return empDesignationAsOn;
	}

	/**
	 * Sets the emp designation as on.
	 *
	 * @param empDesignationAsOn the empDesignationAsOn to set
	 */
	public void setEmpDesignationAsOn(Long empDesignationAsOn) {
		this.empDesignationAsOn = empDesignationAsOn;
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
	 * Gets the pre revised pay scale.
	 *
	 * @return the preRevisedPayScale
	 */
	public Long getPreRevisedPayScale() {
		return preRevisedPayScale;
	}

	/**
	 * Sets the pre revised pay scale.
	 *
	 * @param preRevisedPayScale the preRevisedPayScale to set
	 */
	public void setPreRevisedPayScale(Long preRevisedPayScale) {
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
	public Long getRevisedPayBand() {
		return revisedPayBand;
	}

	/**
	 * Sets the revised pay band.
	 *
	 * @param revisedPayBand the revisedPayBand to set
	 */
	public void setRevisedPayBand(Long revisedPayBand) {
		this.revisedPayBand = revisedPayBand;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the gradePay
	 */
	public Long getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(Long gradePay) {
		this.gradePay = gradePay;
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
	public Long getNpaAmount() {
		return npaAmount;
	}

	/**
	 * Sets the npa amount.
	 *
	 * @param npaAmount the npaAmount to set
	 */
	public void setNpaAmount(Long npaAmount) {
		this.npaAmount = npaAmount;
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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
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
	 * @return the empDesignationAsOnName
	 */
	public String getEmpDesignationAsOnName() {
		return empDesignationAsOnName;
	}

	/**
	 * @param empDesignationAsOnName the empDesignationAsOnName to set
	 */
	public void setEmpDesignationAsOnName(String empDesignationAsOnName) {
		this.empDesignationAsOnName = empDesignationAsOnName;
	}

	/**
	 * @return the preRevisedPayScaleName
	 */
	public String getPreRevisedPayScaleName() {
		return preRevisedPayScaleName;
	}

	/**
	 * @param preRevisedPayScaleName the preRevisedPayScaleName to set
	 */
	public void setPreRevisedPayScaleName(String preRevisedPayScaleName) {
		this.preRevisedPayScaleName = preRevisedPayScaleName;
	}

	/**
	 * @return the revisedPayBandName
	 */
	public String getRevisedPayBandName() {
		return revisedPayBandName;
	}

	/**
	 * @param revisedPayBandName the revisedPayBandName to set
	 */
	public void setRevisedPayBandName(String revisedPayBandName) {
		this.revisedPayBandName = revisedPayBandName;
	}

	/**
	 * @return the gradePayName
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * @param gradePayName the gradePayName to set
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * @return the npaAmountName
	 */
	public String getNpaAmountName() {
		return npaAmountName;
	}

	/**
	 * @param npaAmountName the npaAmountName to set
	 */
	public void setNpaAmountName(String npaAmountName) {
		this.npaAmountName = npaAmountName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(basicPay, dateOfNextIncrement, dateOfOption,
				dateOfPreRevisedNextIncrement, dateOfStagnational, effDate, empDesignationAsOn, empDesignationAsOnName,
				empId, empOtherDesignation, gradePay, gradePayName, incrementAmount, npaAmount, npaAmountName,
				payBandValue, preRevisedBasicPay, preRevisedPayScale, preRevisedPayScaleName, revisedPayBand,
				revisedPayBandName, sixpayId, statusId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUEmployeSixPayDetailDto)) {
			return false;
		}
		PVUEmployeSixPayDetailDto other = (PVUEmployeSixPayDetailDto) obj;
		return Objects.equals(basicPay, other.basicPay)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(dateOfOption, other.dateOfOption)
				&& Objects.equals(dateOfPreRevisedNextIncrement, other.dateOfPreRevisedNextIncrement)
				&& Objects.equals(dateOfStagnational, other.dateOfStagnational)
				&& Objects.equals(effDate, other.effDate)
				&& Objects.equals(empDesignationAsOn, other.empDesignationAsOn)
				&& Objects.equals(empDesignationAsOnName, other.empDesignationAsOnName)
				&& Objects.equals(empId, other.empId) && Objects.equals(empOtherDesignation, other.empOtherDesignation)
				&& Objects.equals(gradePay, other.gradePay) && Objects.equals(gradePayName, other.gradePayName)
				&& Objects.equals(incrementAmount, other.incrementAmount) && Objects.equals(npaAmount, other.npaAmount)
				&& Objects.equals(npaAmountName, other.npaAmountName)
				&& Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(preRevisedBasicPay, other.preRevisedBasicPay)
				&& Objects.equals(preRevisedPayScale, other.preRevisedPayScale)
				&& Objects.equals(preRevisedPayScaleName, other.preRevisedPayScaleName)
				&& Objects.equals(revisedPayBand, other.revisedPayBand)
				&& Objects.equals(revisedPayBandName, other.revisedPayBandName)
				&& Objects.equals(sixpayId, other.sixpayId) && Objects.equals(statusId, other.statusId);
	}

	@Override
	public String toString() {
		return "PVUEmployeSixPayDetailDto [sixpayId=" + sixpayId + ", empDesignationAsOn=" + empDesignationAsOn
				+ ", empDesignationAsOnName=" + empDesignationAsOnName + ", empOtherDesignation=" + empOtherDesignation
				+ ", preRevisedPayScale=" + preRevisedPayScale + ", preRevisedPayScaleName=" + preRevisedPayScaleName
				+ ", preRevisedBasicPay=" + preRevisedBasicPay + ", revisedPayBand=" + revisedPayBand
				+ ", revisedPayBandName=" + revisedPayBandName + ", gradePay=" + gradePay + ", gradePayName="
				+ gradePayName + ", statusId=" + statusId + ", dateOfPreRevisedNextIncrement="
				+ dateOfPreRevisedNextIncrement + ", npaAmount=" + npaAmount + ", npaAmountName=" + npaAmountName
				+ ", dateOfOption=" + dateOfOption + ", dateOfStagnational=" + dateOfStagnational + ", incrementAmount="
				+ incrementAmount + ", empId=" + empId + ", payBandValue=" + payBandValue + ", dateOfNextIncrement="
				+ dateOfNextIncrement + ", basicPay=" + basicPay + ", effDate=" + effDate + "]";
	}

}