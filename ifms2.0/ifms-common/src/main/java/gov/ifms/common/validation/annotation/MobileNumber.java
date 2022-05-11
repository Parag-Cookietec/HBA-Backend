package gov.ifms.common.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import gov.ifms.common.validation.MobileNumberValidator;

@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumber {

	String message() default "Mobile Number is not valid";

	boolean nullable() default false;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
