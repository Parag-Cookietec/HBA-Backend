package gov.ifms.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.PinCode;

public class PinCodeValidator implements ConstraintValidator<PinCode, String> {

	private static final String PINCODE_REGEX = "\\d{6}";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param pincode the pan card
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String pincode, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(pincode)) {
			return isnullable;
		}
		return pincode.matches(PINCODE_REGEX);
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(PinCode constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}

}
