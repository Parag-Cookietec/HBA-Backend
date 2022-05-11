package gov.ifms.common.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import gov.ifms.common.validation.NumericValidator;

@Documented
@Constraint(validatedBy = NumericValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {

	String message() default "Only Digits are allowed";

	boolean nullable() default false;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
