package gov.ifms.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.AlphaNumeric;

/**
 * The Class AlphaNumericValidator.
 */
public class AlphaNumericValidator implements ConstraintValidator<AlphaNumeric, String> {

	/** The Constant ALPHANUMERIC_REGEX. */
	private static final String ALPHANUMERIC_REGEX = "^[A-Za-z0-9]+$";

	/** The isnullable. */
	private boolean isnullable;

	
	/**
	 * Checks if is valid.
	 *
	 * @param alphaNumeric the alpha numeric
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String alphaNumeric, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(alphaNumeric)) {
			return isnullable;
		}
		return alphaNumeric.matches(ALPHANUMERIC_REGEX);
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(AlphaNumeric constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}

}
