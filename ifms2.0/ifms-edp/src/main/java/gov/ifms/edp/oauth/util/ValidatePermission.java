package gov.ifms.edp.oauth.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface ValidatePermission.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidatePermission {
	
	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value();
}
