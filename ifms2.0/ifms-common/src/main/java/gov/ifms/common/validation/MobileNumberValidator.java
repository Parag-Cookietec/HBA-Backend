package gov.ifms.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.MobileNumber;

/**
 * The Class MobileNumberValidator.
 */
public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {

	/** The Constant MOBILENO_REGEX. */
	private static final String MOBILENO_REGEX = "\\d{10}";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param mobileNumber the mobile number
	 * @param context      the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(mobileNumber)) {
			return isnullable;
		}
		return mobileNumber.matches(MOBILENO_REGEX);
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(MobileNumber constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}
}
