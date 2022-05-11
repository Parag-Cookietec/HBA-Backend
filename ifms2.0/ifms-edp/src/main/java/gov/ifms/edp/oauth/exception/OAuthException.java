package gov.ifms.edp.oauth.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class OAuthException.
 */
@JsonSerialize(using = OAuthExceptionSerializer.class)
public class OAuthException extends OAuth2Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new o auth exception.
	 *
	 * @param msg the msg
	 */
	public OAuthException(String msg) {
		super(msg);
	}
}