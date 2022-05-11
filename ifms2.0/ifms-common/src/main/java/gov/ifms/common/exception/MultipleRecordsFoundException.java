package gov.ifms.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The ResourceNotFoundException class.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class MultipleRecordsFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param message the message
	 */
	public MultipleRecordsFoundException(String message) {
		super(message);
	}

	public MultipleRecordsFoundException() {
	}
}
