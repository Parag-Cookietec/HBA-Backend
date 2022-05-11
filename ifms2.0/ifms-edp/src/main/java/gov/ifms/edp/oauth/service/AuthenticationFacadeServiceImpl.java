package gov.ifms.edp.oauth.service;

import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * The Class AuthenticationFacadeServiceImpl.
 */
@Service
public class AuthenticationFacadeServiceImpl implements AuthenticationFacadeService {

	/**
	 * Gets the authentication.
	 *
	 * @return the authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * This method generate httpheader with cookies for maintaining a session as OAuth client. This is required to call API with rest template.
	 * It will manage session for backend call and secure application by OAuth authentication. It will fetch httpheader detail without httprequest.
	 *
	 * @return
	 */
	public HttpHeaders getHeaderDetails() {
		HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return getHeaderDetails(httprequest);
	}

	/**
	 * This method generate httpheader with cookies for maintaining a session as OAuth client. This is required to call API with rest template.
	 * It will manage session for backend call and secure application by OAuth authentication.
	 *
	 * @param request
	 * @return HttpHeader object for new call to http urls
	 */
	public HttpHeaders getHeaderDetails(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(OAuthConstant.AUTHORIZATION,
				OAuthConstant.SECURE_REQUEST_TOKEN_HEADER.concat(OAuthUtility.getCurrentUserOAuthToken().getValue()));
		Cookie[] cookies = request.getCookies();
		StringBuilder sb = new StringBuilder();
		for (Cookie cookie : cookies) {
			sb.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
		}
		headers.set("Cookie", sb.toString());
		return headers;
	}
}
