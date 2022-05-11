package gov.ifms.common.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import gov.ifms.common.validation.StringMultiWordValidator;

@Documented
@Constraint(validatedBy = StringMultiWordValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringMultiWord {

	String message() default "Given name is not valid: 1) It should be in camel case. 2) Each word should be single space separated. 3) Special characters not allowed.";

	boolean nullable() default false;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
