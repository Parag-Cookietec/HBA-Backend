package gov.ifms.pvu.wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.PvuWFWrapperDto;

/**
 * The Class PVYFacade.
 */
@Service
public class PVYFacade {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private String requestedUrl;

	@Autowired
	private HttpServletRequest request;

	/**
	 * Call work flow apis.
	 *
	 * @param pvuWfWrapperDto the pvu wf wrapper dto
	 * @return true, if successful
	 */
	public boolean callWorkFlowApis(PvuWFWrapperDto pvuWfWrapperDto) {
		HttpServletRequest requestHost = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		try {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = getHeaderDetails(requestHost);
				Map<String,Object> map = new HashMap<>();
				map.put("assignByOfficeId",pvuWfWrapperDto.getAssignByOfficeId());
				map.put("assignByPostId",pvuWfWrapperDto.getAssignByPostId());
				map.put("assignByUserId",pvuWfWrapperDto.getAssignByUserId());
				map.put("assignByWfRoleId",pvuWfWrapperDto.getAssignByWfRoleId());
				map.put("assignToOfficeId",pvuWfWrapperDto.getAssignToOfficeId());
				map.put("assignToPostId",pvuWfWrapperDto.getAssignToPostId());
				map.put("assignToUserId",pvuWfWrapperDto.getAssignToUserId());
				map.put("assignToWfRoleId",pvuWfWrapperDto.getAssignToWfRoleId());
				map.put("currentWorkflowId",pvuWfWrapperDto.getCurrentWorkflowId());
				map.put("menuId",pvuWfWrapperDto.getMenuId());
				map.put("remarks",pvuWfWrapperDto.getRemarks());
				map.put("trnId",pvuWfWrapperDto.getTrnId());
				map.put("trnStatus"	,pvuWfWrapperDto.getTrnStatus());
				map.put("wfActionId",pvuWfWrapperDto.getWfActionId());
				map.put("wfAttachmentIds",pvuWfWrapperDto.getWfAttachmentIds());
				map.put("wfStatus", pvuWfWrapperDto.getWfStatus());
				map.put("assignToActionLevel", pvuWfWrapperDto.getAssignToActionLevel());
				map.put("assignByActionLevel", pvuWfWrapperDto.getAssignByActionLevel());
				map.put("assignToPOUId", pvuWfWrapperDto.getAssignToPOUId());
				map.put("assignByPOUId", pvuWfWrapperDto.getAssignByPOUId());
				map.put("eventId", pvuWfWrapperDto.getEventId());
				HttpEntity<Map<String,Object>> request = new HttpEntity<>(map, headers);
				logger.info(getWfSubmitApi(URLConstant.URL_WORKFLOW_TRN_PVU_WF,URLConstant.URL_POST));
				ResponseEntity<String> response = restTemplate.postForEntity((getWfSubmitApi(URLConstant.URL_WORKFLOW_TRN_PVU_WF,URLConstant.URL_POST)), request, String.class);
				return response.getStatusCode() == HttpStatus.OK ? Boolean.TRUE : Boolean.FALSE;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return false;
	}

	/**
	 * This method generate httpheader with cookies for maintaining a session as OAuth client. This is required to call API with rest template.
	 * It will manage session for backend call and secure application by OAuth authentication. It will fetch httpheader detail without httprequest.
	 *
	 * @return
	 */
	private HttpHeaders getHeaderDetails() {
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
	private HttpHeaders getHeaderDetails(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(OAuthConstant.AUTHORIZATION,
				OAuthConstant.SECURE_REQUEST_TOKEN_HEADER.concat(OAuthUtility.getCurrentUserOAuthToken().getValue()));
		Cookie[] cookies = request.getCookies();
		StringBuilder sb = new StringBuilder();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
			}
		}
		headers.set("Cookie", sb.toString());
		return headers;
	}
	
	
	/**
	 * Gets the wf submit api.
	 *
	 * @param urlPost
	 * @param wfUrl 
	 * @return the wf submit api
	 */
	private String getWfSubmitApi(String wfUrl, String urlPost) {
				return new StringBuilder(getRequestedUrl()).append(wfUrl).append(urlPost).toString();
	}

	/**
	 * Call work flow apis.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 */
	public Boolean callWorkFlowApis(List<PvuWFWrapperDto> wrapperDto) {
		HttpServletRequest requestHost = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = getHeaderDetails(requestHost);
			HttpEntity<List<PvuWFWrapperDto>> request = new HttpEntity<>(wrapperDto, headers);
			logger.info(getWfSubmitApi(URLConstant.URL_WORKFLOW_TRN_PVU_WF,URLConstant.URL_POST));
			ResponseEntity<String> response = restTemplate.postForEntity((getWfSubmitApi(URLConstant.URL_WORKFLOW_TRN_PVU_WF,URLConstant.URL_POST_LIST)), request,String.class);
			return response.getStatusCode() == HttpStatus.OK ? Boolean.TRUE : Boolean.FALSE;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return false;
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
		System.out.println("####PVU FACADE URI = "+sb.toString());
		return sb.toString();
	}

	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}

}
