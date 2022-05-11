package gov.ifms.common.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import gov.ifms.common.util.Constant;
import gov.ifms.common.util.MessageUtil;
import gov.ifms.common.validation.annotation.StringMultiWord;

/**
 * The Class StringMultiWordValidator. This velidator will check each word
 * should separated with single space and must be in camel case
 */
public class StringMultiWordValidator implements ConstraintValidator<StringMultiWord, String> {

	/** The isnullable. */
	private boolean isnullable;

	private String message;

	/**
	 * Checks if is valid.
	 *
	 * @param emailid the emailid
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(name))
			return isnullable;
		return isMultiSpaceAndCamelCase(name);
	}

	private boolean isMultiSpaceAndCamelCase(String name) {
		Pattern camelPattern = Pattern.compile(Constant.Regex.VALIDATE_CAMELCASE);
		String[] nameArray = name.split(Constant.SINGLE_SPACE);
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].isEmpty()) {
				setMessage(MessageUtil.getMsg("ERROR.EDP.SINGLESPACE"));
				return false;
			} else if (!camelPattern.matcher(nameArray[i]).matches()) {
				setMessage(MessageUtil.getMsg("ERROR.EDP.NAMEWITCAMELCASE"));
				return false;
			}

		}
		return true;
	}

	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	@Override
	public void initialize(StringMultiWord constraintAnnotation) {
		this.isnullable = constraintAnnotation.nullable();
	}

	/**
	 * @return the isnullable
	 */
	public boolean isIsnullable() {
		return isnullable;
	}

	/**
	 * @param isnullable the isnullable to set
	 */
	public void setIsnullable(boolean isnullable) {
		this.isnullable = isnullable;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
