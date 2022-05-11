package gov.ifms.common.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.validation.FieldError;

/**
 * The ErrorDetails class.
 */
@JsonIgnoreProperties(value = {"stackTrace", "message", "localizedMessage", "suppressed", "cause"}, ignoreUnknown = true)
public class ErrorDetails extends RuntimeException implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The List of Error field details.
	 */
	private List<FieldError> fieldErrors = new ArrayList<>();

	@JsonIgnore
	public ErrorDetails(List<FieldError> allErrors) {
		this.fieldErrors = allErrors;
	}

	@JsonIgnore
	public ErrorDetails() {

	}

	/**
	 * Add List of errors.
	 *
	 * @param object  the object
	 * @param field   the field
	 * @param message the message
	 */
	@JsonIgnore
	public void addFieldError(String object, String field, String message) {
		FieldError error = new FieldError(object, field, message);
		fieldErrors.add(error);
	}

	/**
	 * Gets the field errors.
	 *
	 * @return the list of errors
	 */

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	@JsonIgnore
	public static ErrorDetails create(List<FieldError> allErrors) {
		return new ErrorDetails(allErrors);
	}
}
