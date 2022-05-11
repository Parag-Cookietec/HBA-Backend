package gov.ifms.common.base;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DateRangeValidator implements ConstraintValidator<ValidateDateRange, Object> {

    private String start;

    private String end;

    @Override
    public void initialize(ValidateDateRange validateDateRange) {
        start = validateDateRange.start();
        end = validateDateRange.end();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(value);
        LocalDate st = (LocalDate) wrapper.getPropertyValue(this.start);
        LocalDate en = (LocalDate) wrapper.getPropertyValue(this.end);


        if (Objects.equals(en, st)) {
            return true;
        }
        return Objects.requireNonNull(en).isAfter(Objects.requireNonNull(st));
    }
}
