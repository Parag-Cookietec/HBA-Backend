package gov.ifms.common.base;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Constraint(validatedBy = DateRangeValidator.class)
@Documented
public @interface ValidateDateRange {

    String message() default "{end} should be later than {start}";

    String start();

    String end();

    Class[] groups() default {};

    Class[] payload() default {};
}
