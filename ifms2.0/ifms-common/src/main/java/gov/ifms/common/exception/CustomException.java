package gov.ifms.common.exception;

import org.springframework.http.HttpStatus;

import gov.ifms.common.util.ErrorResponse;

/**
 * The Class CustomException.
 */
public class CustomException extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The error msg. */
	private final String errorMsg;

	/** The error code. */
	private final int errorCode;

	/**
	 * Instantiates a new custom exception.
	 *
	 * @param errorResponse the error response
	 */
	public CustomException(ErrorResponse errorResponse) {
		super(errorResponse.getMessage());
		this.errorMsg = errorResponse.getMessage();
		this.errorCode = errorResponse.getCode();
	}

	/**
	 * Instantiates a new custom exception.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public CustomException(int code, String message) {
		super(message);
		this.errorCode = code;
		this.errorMsg = message;

	}

	/**
	 * Instantiates a new custom exception.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public CustomException(HttpStatus status, String message) {
		super(message);
		this.errorCode = status.value();
		this.errorMsg = message;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("CustomException [errorMsg=%s, errorCode=%s]", errorMsg, errorCode);
	}

}
