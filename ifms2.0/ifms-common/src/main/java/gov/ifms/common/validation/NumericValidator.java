package gov.ifms.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.Numeric;

/**
 * The Class NumericValidator.
 */
public class NumericValidator implements ConstraintValidator<Numeric, String> {

	/** The Constant NUMERIC_REGEX. */
	private static final String NUMERIC_REGEX = "^[0-9]+$";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param panCard the pan card
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String panCard, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(panCard)) {
			return isnullable;
		}
		return panCard.matches(NUMERIC_REGEX);
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(Numeric constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}
}
