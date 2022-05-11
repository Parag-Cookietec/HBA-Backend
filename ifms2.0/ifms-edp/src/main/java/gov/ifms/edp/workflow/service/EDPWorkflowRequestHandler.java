package gov.ifms.edp.workflow.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * The Class EDPWorkflowRequestHandler.
 */
@Service
public class EDPWorkflowRequestHandler {

    /** The Constant WF_ROLE_IDS. */
    private static final String WF_ROLE_IDS = "wfRoleIds";

	/** The Constant USER_ID. */
	private static final String USER_ID = "userId";

	/** The Constant TRN_ID. */
	private static final String TRN_ID = "trnId";

	/** The Constant LK_POU_ID. */
	private static final String LK_POU_ID = "lkPOUId";

	/** The Constant POU_ID. */
	private static final String POU_ID = "pouId";

	/** The Constant POST_ID. */
	private static final String POST_ID = "postId";

	/** The Constant OFFICE_ID. */
	private static final String OFFICE_ID = "officeId";

	/** The Constant MENU_ID. */
	private static final String MENU_ID = "menuId";

	private String requestedUrl;

	@Autowired
	private HttpServletRequest request;

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
	 * Save as draft wf.
	 *
	 * @param menuId the menu id
	 * @param trnId the trn id
	 * @throws CustomException the custom exception
	 */
	public void saveAsDraftWf(Long menuId, Long trnId) throws CustomException {
		Map<String, Object> map = prepareArgumentForWF(menuId, trnId, Boolean.FALSE);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeaderDetails();
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
		String url = getRequestedUrl().concat(URLConstant.URL_ACTION_CONFIG_WORKFLOW.concat(URLConstant.URL_WF_TRN_SAVE));
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		map.clear();
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new CustomException(ErrorResponse.WF_FAILED);
		}
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
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
			}
		}
		headers.set("Cookie", sb.toString());
		return headers;
	}
	

	/**
	 * Wf direct submite api call.
	 *
	 * @param menuId the menu id
	 * @param trnId the trn id
	 * @throws CustomException the custom exception
	 */
	public void wfDirectSubmiteApiCall(Long menuId , Long trnId) throws CustomException {
		Map<String, Object> map = prepareArgumentForWF(menuId, trnId, Boolean.TRUE);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeaderDetails();
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
		String url = getRequestedUrl().concat(URLConstant.URL_ACTION_CONFIG_WORKFLOW.concat(URLConstant.URL_WF_DIRECT_SUBMIT));
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		map.clear();
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new CustomException(ErrorResponse.WF_FAILED);
		}
	}
	
	
	/**
	 * Prepare argument for direct submit.
	 *
	 * @param menuId the menu id
	 * @param trnId the trn id
	 * @param isSubmit the is submit
	 * @return the map
	 */
	public Map<String, Object> prepareArgumentForWF(Long menuId, Long trnId, Boolean isSubmit ) {
		Map<String, Object> map = new HashMap<>();
		map.put(MENU_ID, menuId);
		map.put(OFFICE_ID, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		map.put(POST_ID, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		if(isSubmit)
			map.put(LK_POU_ID, OAuthUtility.getCurrentUserLkPOUId());
		else
			map.put(POU_ID, OAuthUtility.getCurrentUserLkPOUId());
		map.put(TRN_ID, trnId);
		map.put(USER_ID, OAuthUtility.getCurrentUserUserId());
		map.put(WF_ROLE_IDS, OAuthUtility.getWfRoleUsingMenuId(menuId));
		return map;
	}

	public String getRequestedUrl() {
		String context=null;
		if(request.getServletContext()!=null){
			context = request.getServletContext().getContextPath();
			System.out.println("####Request.getServletContext().getContextPath()" + request.getServletContext());
		}else{
			context = request.getContextPath();
		}
		StringBuilder sb = new StringBuilder();
		if(context!=null){
			sb.append("http://localhost:").append(request.getLocalPort()).append("/").append(context);
		}else{
			sb.append("http://localhost:").append(request.getLocalPort());
		}
		System.out.println("####Request.getContextPath()" + request.getContextPath());
		System.out.println("####BUDGET FACADE URI = "+sb.toString());
		return sb.toString();
	}

	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}

}
