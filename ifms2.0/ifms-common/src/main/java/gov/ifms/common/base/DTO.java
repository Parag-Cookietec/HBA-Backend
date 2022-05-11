package gov.ifms.common.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.FieldError;

import gov.ifms.common.exception.ValidationUtil;

/**
 * The type Dto.
 */
public class DTO {

    private Status formAction;

    /**
     * Gets form action.
     *
     * @return the form action
     */
    public Status getFormAction() {
        return formAction;
    }

    /**
     * Sets form action.
     *
     * @param formAction the form action
     */
    public void setFormAction(Status formAction) {
        this.formAction = formAction;
    }

    /**
     * Instantiates a new Dto.
     */
    public DTO() {
        // default constructor
    }

    /**
     * Business validate list.
     *
     * @return the list
     */
    public List<FieldError> businessValidate() {
        return new ArrayList<>();
    }

    /**
     * Property based validation set.
     *
     * @return the set
     */
    public Set<String> propertyBasedValidation() {
        return new HashSet<>();
    }

    /**
     * Mandatory validation class [ ].
     *
     * @return the class [ ]
     */
    public Class[] mandatoryValidation() {
        return new Class[]{ValidateDateRange.class, Min.class, Digits.class, Max.class, Pattern.class, NotNull.class, NotBlank.class, PastOrPresent.class,NotEmpty.class, DecimalMin.class};
    }

    /**
     * Validate all.
     */
    public void validateAll() {
        List<FieldError> errors = new ArrayList<>();
        errors.addAll(ValidationUtil.validateProperty(this, propertyBasedValidation()));
        errors.addAll(ValidationUtil.validateValue(this.getClass(), fullPropertyValidation(), this));
        errors.addAll(this.businessValidate());
        ValidationUtil.validate(this, mandatoryValidation(), errors);
    }

    public List<String> fullPropertyValidation() {
        return new ArrayList<>();
    }


    /**
     * Draft field validate.
     */
    public void draftFieldValidate() {
        List<FieldError> fieldErrors = ValidationUtil.validateProperty(this, propertyBasedValidation());
        if (CollectionUtils.isNotEmpty(fieldErrors)) {
            ValidationUtil.throwErrors(fieldErrors);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(formAction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTO other = (DTO) obj;
		return formAction == other.formAction;
	}
    
    
}
