package gov.ifms.common.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.PasswordId;

/**
 * The Class EmailValidator.
 */
public class PasswordValidator implements ConstraintValidator<PasswordId, String> {

	/** The email regex. */
	private String passRegx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*{}\'\"()_+]).{8,16})";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param passRegx the passRegx
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		Pattern pat = Pattern.compile(passRegx);
		if (StringUtils.isEmpty(password))
			return isnullable;
		return pat.matcher(password).matches();
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(PasswordId constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}

}
