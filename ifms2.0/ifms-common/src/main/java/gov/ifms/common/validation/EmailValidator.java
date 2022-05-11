package gov.ifms.common.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.validation.annotation.EmailId;

/**
 * The Class EmailValidator.
 */
public class EmailValidator implements ConstraintValidator<EmailId, String> {

	/** The email regex. */
	private String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";

	/** The isnullable. */
	private boolean isnullable;

	/**
	 * Checks if is valid.
	 *
	 * @param emailid the emailid
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String emailid, ConstraintValidatorContext context) {
		Pattern pat = Pattern.compile(emailRegex);
		if (StringUtils.isEmpty(emailid))
			return isnullable;
		return pat.matcher(emailid).matches();
	}

	
	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(EmailId constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}

}
