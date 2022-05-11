package gov.ifms.common.exception;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
import java.util.stream.Collectors;

public class ValidationUtil {

    private ValidationUtil() {
    }

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static void throwErrors(List<FieldError> errors) {
        if (!CollectionUtils.isEmpty(errors)) {
            throw ErrorDetails.create(errors.stream().distinct().collect(Collectors.toList()));
        }
    }

    public static <T> void validate(T t, Class[] classes, List<FieldError> errors) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(t);
        if (!violationSet.isEmpty()) {
            violationSet.forEach(err -> Arrays.stream(classes).filter(classz -> err.getConstraintDescriptor().getAnnotation().annotationType() == classz).findFirst()
                    .ifPresent(pre -> errors.add(buildError(err))));
        }

        if (errors.isEmpty()) {
            return;
        }
        throwErrors(errors);
    }

    public static <T> List<FieldError> validateFor(T t, Class[] classes) {
        List<FieldError> errors = new ArrayList<>();
        Arrays.stream(classes).forEach(classz -> errors.addAll(ValidationUtil.validateFor(t, classz)));
        if (errors.isEmpty()) {
            return new ArrayList<>();
        }
        return errors;
    }

    private static <T> List<FieldError> validateFor(T t, Class classz) {
        List<FieldError> errors = new ArrayList<>();
        validator.validate(t).forEach(err -> {
            if (err.getConstraintDescriptor().getAnnotation().annotationType() == classz) {
                errors.add(buildError(err));
            }
        });
        return !errors.isEmpty() ? errors : new ArrayList<>();
    }

    private static <T> List<FieldError> getResponseErrors(Class classz, Set<ConstraintViolation<T>> violations) {
        List<FieldError> errors = new ArrayList<>();
        violations.forEach(err -> {
            if (err.getConstraintDescriptor().getAnnotation().annotationType() == classz) {
                errors.add(buildError(err));
            }
        });
        return errors;
    }

    private static <T> FieldError buildError(ConstraintViolation<T> err) {
/*
        return createSimple(
                err.getRootBeanClass().getSimpleName(), // objectName
                ((PathImpl) err.getPropertyPath()).getLeafNode().asString(), // field
                err.getMessage(), // defaultMessage
                null, // invalidValue
                err.getMessage() // message
        );
*/
        return createSimple(
                err.getRootBeanClass().getSimpleName(), // objectName
                ((PathImpl) err.getPropertyPath()).getLeafNode().asString(), // field
                err.getMessage()
        );
    }

    private static FieldError create(String objectName, String field, String defaultMessage, Object invalidValue, String message) {
        return new FieldError(objectName, field, defaultMessage, true, null, null, message);
    }

    private static FieldError createSimple(String objectName, String field, String defaultMessage) {
        return new FieldError(objectName, field, defaultMessage);
    }

    public static <T> List<FieldError> validateProperty(T obj, Set<String> properties) {
        List<FieldError> errors = new ArrayList<>();
        properties.forEach(property -> errors.addAll(validatePropertyFor(obj, property)));
        if (errors.isEmpty()) {
            return new ArrayList<>();
        }
        return errors;
    }

    private static <T> List<FieldError> validatePropertyFor(T obj, String property) {
        Set<ConstraintViolation<T>> violations = validator.validateProperty(obj, property);
        return violations.stream().map(ValidationUtil::buildError).collect(Collectors.toList());
    }

    public static <T> List<FieldError> validateValue(Class<T> beanType, List<String> properties, Object value) {
        List<FieldError> errors = new ArrayList<>();
        properties.forEach(e -> validator.validateValue(beanType, e, value).forEach(err -> errors.add(buildError(err))));
        return errors;
    }

    public static <T> List<FieldError> validateGroup(T obj, Class[] groups) {
        List<FieldError> errors = new ArrayList<>();
        validator.validate(obj, groups).forEach(err -> errors.add(buildError(err)));
        return errors;
    }


}
