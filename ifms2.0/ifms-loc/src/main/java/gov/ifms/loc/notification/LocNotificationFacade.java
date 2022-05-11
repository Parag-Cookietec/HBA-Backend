package gov.ifms.loc.notification;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LocNotificationFacade {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${workflow.url}")
	private String workflowApiUrl;

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
		if(Objects.nonNull(cookies)) {
		for (Cookie cookie : cookies) {
			sb.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
			headers.set("Cookie", sb.toString());
		}
		}
		return headers;
	}

	/**
	 * Gets the wf submit api.
	 *
	 * @param wfUrl the wf url
	 * @param urlPost the url post
	 * @return the wf submit api
	 */
	private String getWfSubmitApi(String wfUrl, String urlPost) {
		return new StringBuilder(workflowApiUrl).append(wfUrl).append(urlPost).toString();
	}

		/**
		 * Notification rest API.
		 *
		 * @param notificationDto the notification dto
		 * @return the boolean
		 */
		public Boolean notificationRestAPI(NotificationPostDTO notificationDto) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeaderDetails();
		HttpEntity<NotificationPostDTO> request = new HttpEntity<>(notificationDto, headers);
		logger.info(getWfSubmitApi(URLConstant.URL_NOTIFICATION, URLConstant.POST_NOTIFICATION_V2));
		ResponseEntity<String> response = restTemplate.postForEntity(
				(getWfSubmitApi(URLConstant.URL_NOTIFICATION, URLConstant.POST_NOTIFICATION_V2)), request, String.class);

		return response.getStatusCode() == HttpStatus.OK ? Boolean.TRUE : Boolean.FALSE;
	}

}
