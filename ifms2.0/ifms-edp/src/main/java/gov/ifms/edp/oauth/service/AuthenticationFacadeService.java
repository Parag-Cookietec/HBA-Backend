package gov.ifms.edp.oauth.service;

import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * The Interface AuthenticationFacadeService.
 */
public interface AuthenticationFacadeService {

	/**
	 * Gets the authentication.
	 *
	 * @return the authentication
	 */
	Authentication getAuthentication();

	/**
	 * This method generate httpheader with cookies for maintaining a session as OAuth client. This is required to call API with rest template.
	 * It will manage session for backend call and secure application by OAuth authentication. It will fetch httpheader detail without httprequest.
	 *
	 * @return
	 */
	HttpHeaders getHeaderDetails();

	/**
	 * This method generate httpheader with cookies for maintaining a session as OAuth client. This is required to call API with rest template.
	 * It will manage session for backend call and secure application by OAuth authentication.
	 *
	 * @param request
	 * @return HttpHeader object for new call to http urls
	 */
	HttpHeaders getHeaderDetails(HttpServletRequest request);
}
