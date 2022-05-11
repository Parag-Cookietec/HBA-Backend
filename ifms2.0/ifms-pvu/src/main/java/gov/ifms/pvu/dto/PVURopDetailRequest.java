package gov.ifms.pvu.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import gov.ifms.common.base.DTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.common.util.Utils;

/**
 * The Class PVURopDetailRequest.
 */
public class PVURopDetailRequest extends DTO {

	/** The rop type. */
	private Long ropType;

	/** The emp no. */
	private Long empNo;

	/** The pay scale. */
	private Long payScale;

	/** The pay band. */
	private Long payBand;

	/** The pay band value. */
	private Long payBandValue;

	/** The grade pay. */
	private Long gradePay;

	/** The basic pay. */
	private Long basicPay;

	/** The next increment date. */
	private String nextIncrementDate;

	/** The effective date. */
	private String effectiveDate;

	/** The pay commission. */
	private Long payCommission;

	private String validateString;
	/**
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public Long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public Long getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(Long payBand) {
		this.payBand = payBand;
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
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the nextIncrementDate
	 */
	public String getNextIncrementDate() {
		return nextIncrementDate;
	}

	/**
	 * @param nextIncrementDate the nextIncrementDate to set
	 */
	public void setNextIncrementDate(String nextIncrementDate) {
		this.nextIncrementDate = nextIncrementDate;
	}

	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the payCommission
	 */
	public Long getPayCommission() {
		return payCommission;
	}

	/**
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(Long payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * @return the validateString
	 */
	public String getValidateString() {
		return validateString;
	}

	/**
	 * @param validateString the validateString to set
	 */
	public void setValidateString(String validateString) {
		this.validateString = validateString;
	}

	@Override
	public void validateAll() {
		List<FieldError> errors = null;
		if (URLConstant.URL_ROP_EMPLOYEE_DETAIL.equalsIgnoreCase(this.validateString)) {
			errors = this.businessValidate();
		} else if (URLConstant.URL_ROP_VALID.equalsIgnoreCase(this.validateString)) {
			errors = this.businessValidateRopValid();
		} else {
			errors = new ArrayList<>();
		}

		if (errors.isEmpty())
			return;
		ValidationUtil.throwErrors(errors);
	}
/**
 * 
 */
	@Override
	public List<FieldError> businessValidate() {
		List<FieldError> errors = new ArrayList<>();
		FieldError error = null;

		if (Utils.isEmpty(this.getEffectiveDate())) {
			error =  getFieldErrorInstance("Effective Date");
			errors.add(error);
		}

		if (Utils.isEmpty(this.getRopType())) {
			error =  getFieldErrorInstance("Rop Type");			
			errors.add(error);
		}

		if (Utils.isEmpty(this.getEmpNo())) {
			error =  getFieldErrorInstance("Employee No");			
			errors.add(error);
		}

		return errors;
	}

	private FieldError getFieldErrorInstance(final String filedName) {

		return new FieldError("PVURopDetailRequest",filedName, "can't be empty");
	}
/**
 * 
 * @return
 */
	public List<FieldError> businessValidateRopValid() {
		return businessValidate();
	}
}
