package gov.ifms.common.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import gov.ifms.common.validation.PinCodeValidator;

@Documented
@Constraint(validatedBy = PinCodeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PinCode {

	String message() default "Pin Code is not valid";

	boolean nullable() default false;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
