package gov.ifms.edp.oauth.exception;


import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;


/**
 * The Class CommonException.
 */
@Component
public class CommonException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Un authorized.
	 *
	 * @param response the response
	 * @param message the message
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void unAuthorized(HttpServletResponse response, String message) throws IOException {
		response.sendError(401, message);
	}

	/**
	 * Request blank.
	 *
	 * @param response the response
	 * @param message the message
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void requestBlank(HttpServletResponse response, String message) throws IOException {
		response.sendError(400, message);
	}
}
