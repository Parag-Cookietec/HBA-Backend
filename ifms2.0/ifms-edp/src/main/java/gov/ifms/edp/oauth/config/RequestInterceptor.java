package gov.ifms.edp.oauth.config;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.oauth.dto.OAuthMsUserEndpointsDTO;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * RequestInterceptor For ROle Base Access
 * 
 * @author db2admin
 *
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	
	@Value("${spring.requestinterceptor.enabled}")
	private boolean requestInterceptorFlag;
	/**
	 * PreHandle For Check User Hase access of that URL Or Not.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param handler  the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (requestInterceptorFlag && handler instanceof HandlerMethod) {
			String authHeaderVal = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (authHeaderVal != null && authHeaderVal.startsWith(OAuthConstant.SECURE_REQUEST_TOKEN_HEADER)) {
				HandlerMethod hm = (HandlerMethod) handler;
				Method method = hm.getMethod();

				/** Check For RestController */
				if (method.getDeclaringClass().isAnnotationPresent(RestController.class)) {
					List<OAuthMsUserEndpointsDTO> userEndpoints = OAuthUtility.getCurrentUserEndpointsOauthToken();
					String requestEnpoint = request.getRequestURI();
					String userName = OAuthUtility.getCurrentUserUserName();
					boolean isUrlPresent = checkIsUrlAccess(userEndpoints, requestEnpoint);
					logger.info(OAuthConstant.LOG_MSG_USERNAME_REQUESTEDURL_HAVERIGHTS, userName, requestEnpoint,
							isUrlPresent);
					if (isUrlPresent) {
						return true;
					} else {
						/** If Endpoint is not linked then stop process and return responce as false */
						getUnauthorizedResponse(response);
						return false;
					}

				}
			}
		}
		return super.preHandle(request, response, handler);
	}


	/**
	 * Check is url access.
	 *
	 * @param userEndpoints the user endpoints
	 * @param requestEnpoint the request enpoint
	 * @return true, if successful
	 */
	private boolean checkIsUrlAccess(List<OAuthMsUserEndpointsDTO> userEndpoints, String requestEnpoint) {
		boolean isUrlPresent = userEndpoints.stream()
				.anyMatch(endpoint -> requestEnpoint.contains(endpoint.getUrlEndPoint()));
		if (requestEnpoint.contains(URLConstant.URL_EDP_OAUTH))
			isUrlPresent = true;
		return isUrlPresent;
	}

	
	/**
	 * Gets the unauthorized response.
	 *
	 * @param response the response
	 * @return the unauthorized response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void getUnauthorizedResponse(HttpServletResponse response) throws IOException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(OAuthConstant.CONTENTTYPE_VALUE);
		JSONObject jsonObject = new JSONObject(ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED,
				OAuthConstant.UNAUTHORISED_ACCESS, OAuthConstant.NO_RIGHTS_FOR_ACCESS_DATA));
		if (jsonObject.getJSONObject(OAuthConstant.BODY) != null) {
			response.getWriter().write(jsonObject.getJSONObject(OAuthConstant.BODY).toString());
		}
	}

}



