package gov.ifms.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.AlphaNumericWithSpecialCharacter;

/**
 * The Class AlphaNumericWithSpecialCharacterValidator.
 */
public class AlphaNumericWithSpecialCharacterValidator
		implements ConstraintValidator<AlphaNumericWithSpecialCharacter, String> {

	/** The Constant ALPHANUMERICWITHSPECIALCHARACTER_REGEX. */
	private static final String ALPHANUMERICWITHSPECIALCHARACTER_REGEX = "^[ A-Za-z0-9_@./#&+-]*$";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param alphaNumericWithSpecialCharacter the alpha numeric with special character
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String alphaNumericWithSpecialCharacter, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(alphaNumericWithSpecialCharacter)) {
			return isnullable;
		}
		return alphaNumericWithSpecialCharacter.matches(ALPHANUMERICWITHSPECIALCHARACTER_REGEX);
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(AlphaNumericWithSpecialCharacter constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}
}
