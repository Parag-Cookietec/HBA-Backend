package gov.ifms.common.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;

/**
 * The GlobalExceptionHandler class.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	Logger loger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Resource not found exception.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		loger.error(ex.getMessage());
		return new ResponseEntity<>(new ApiResponse(ErrorResponse.REFERENCE_NOT_EXISTS.getCode(),
				ErrorResponse.REFERENCE_NOT_EXISTS.getMessage(), null), HttpStatus.OK);
	}

	/**
	 * Custom Error Exception handling
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@Trace
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiResponse> customException(CustomException ex, WebRequest request) {
		loger.error(ex.getMessage(),ex);
		return new ResponseEntity<>(new ApiResponse(ex.getErrorCode(), ex.getErrorMsg(), null), HttpStatus.OK);
	}

	/**
	 * Globle excpetion handler.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@Trace
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> globleExcpetionHandler(Exception ex, WebRequest request) {
		loger.error(ex.getMessage(),ex);
		return new ResponseEntity<>(new ApiResponse(ErrorResponse.UNKNOWN_ERROR_OCCURED.getCode(),
				ErrorResponse.UNKNOWN_ERROR_OCCURED.getMessage(), null), HttpStatus.OK);
	}

	/**
	 * Handle method argument not valid.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		loger.error(ex.getMessage());
		return new ResponseEntity<>(
				new ApiResponse(ErrorResponse.VALIDATIONS_FAILED.getCode(),
						ErrorResponse.VALIDATIONS_FAILED.getMessage(), processFieldErrors(fieldErrors)),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Process field errors.
	 *
	 * @param fieldErrors the field errors
	 * @return the error details
	 */
	private ErrorDetails processFieldErrors(List<FieldError> fieldErrors) {
		ErrorDetails error = new ErrorDetails();
		for (FieldError fieldError : fieldErrors) {
			error.addFieldError(fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getObjectName());
		}
		return error;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		if (ex.getCause() instanceof ConstraintViolationException) {
			return ResponseUtil.getResponse(HttpStatus.CONFLICT, ErrorResponse.REFERENCE_NOT_EXISTS.getMessage(),
					ex.getMessage());
		}
		loger.error(ex.getMessage(),ex);
		return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				ErrorResponse.UNKNOWN_ERROR_OCCURED.getMessage(), ex);
	}

	/**
	 * Handle HttpMediaTypeNotSupportedException. This one triggers when JSON is
	 * invalid as well.
	 *
	 * @param ex      HttpMediaTypeNotSupportedException
	 * @param headers HttpHeaders
	 * @param status  HttpStatus
	 * @param request WebRequest
	 * @return the ApiError object
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(ErrorResponse.UNSUPPORTED_MEDIA_TYPE.getMessage());
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
		if (loger.isDebugEnabled()) {
			loger.error(builder.toString());
		}
		return buildResponseEntity(HttpStatus.BAD_REQUEST, ErrorResponse.UNSUPPORTED_MEDIA_TYPE);
	}

	private ResponseEntity<Object> buildResponseEntity(final HttpStatus statusCode, final ErrorResponse errorEnum) {
		final ApiResponse apiResponse = new ApiResponse(errorEnum.getCode(), errorEnum.getMessage(), null);
		return new ResponseEntity<>(apiResponse, statusCode);
	}

	/**
	 * Handle http message not writable.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loger.error(ex.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, ErrorResponse.JSON_RESPONSE_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loger.error(ex.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, ErrorResponse.JSON_PARSING_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> constraintViolationExcpetionHandler(ConstraintViolationException ex,
			WebRequest request) {

		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		Set<String> errorMsgs = new HashSet<>();
		for (ConstraintViolation<?> violation : violations) {
			errorMsgs.add(violation.getMessage());
		}
		return new ResponseEntity<>(
				new ApiResponse(ErrorResponse.VALIDATIONS_FAILED.getCode(), String.join(", ", errorMsgs), null),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Custom Error Exception handling
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ErrorDetails.class)
	public ResponseEntity<ApiResponse> create(ErrorDetails ex, WebRequest request) {
		loger.error(ex.getMessage());
		StringBuilder builder = new StringBuilder().append(ex.getFieldErrors().get(0).getField()).append(" ")
				.append(ex.getFieldErrors().get(0).getDefaultMessage());

		return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), builder.toString(), ex.getFieldErrors()), HttpStatus.OK);
	}
}
