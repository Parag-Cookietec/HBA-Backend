package gov.ifms.edp.oauth.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.dto.OAuthMsUserEndpointsDTO;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class OAuthUtility.
 */
@Service
public class OAuthUtility {

	/** The static default token services. */
	private static DefaultTokenServices staticDefaultTokenServices;

	/** The static consumer token services. */
	private static ConsumerTokenServices staticConsumerTokenServices;

	/** The static encrypt decrypt utill. */
	private static EncryptDecryptUtil staticEncryptDecryptUtill;

	/** The auth flag. */
	private static boolean authFlag;

	/** The auth flag 1. */
	@Value("${spring.oauth.enabled}")
	private boolean authFlag1;

	/** The default token services. */
	@Autowired
	private DefaultTokenServices defaultTokenServices;

	/** The consumer token services. */
	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	/** The encrypt decrypt utill. */
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtill;

	/**
	 * Inits the.
	 */
	@PostConstruct
	public synchronized void init() {
		staticDefaultTokenServices = defaultTokenServices;
		staticConsumerTokenServices = consumerTokenServices;

		staticEncryptDecryptUtill = encryptDecryptUtill;
		authFlag = authFlag1;
	}

	/**
	 * Gets the current user user id.
	 *
	 * @return the current user user id
	 */
	public static long getCurrentUserUserId() {
		if (!authFlag) {
			return 1l;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> additionalInfo = staticDefaultTokenServices
				.getAccessToken((OAuth2Authentication) authentication).getAdditionalInformation();
		return Long.parseLong(staticEncryptDecryptUtill.decrypt(additionalInfo.get(OAuthConstant.USER_ID).toString()));
	}

	/**
	 * Checks if is user logout.
	 *
	 * @return true, if is user logout
	 */
	public static boolean isUserLogout() {
		boolean isLogout = false;
		OAuth2AccessToken accessToken = getCurrentUserOAuthToken();
		isLogout = staticConsumerTokenServices.revokeToken(accessToken.getValue());

		SecurityContextHolder.clearContext();
		return isLogout;
	}

	/**
	 * Gets the current user O auth token.
	 *
	 * @return the current user O auth token
	 */
	public static OAuth2AccessToken getCurrentUserOAuthToken() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return staticDefaultTokenServices.getAccessToken((OAuth2Authentication) authentication);
	}

	/**
	 * Gets the current user post oauth T oken.
	 *
	 * @return the current user post oauth T oken
	 */
	@SuppressWarnings("unchecked")
	public static List<EDPMsPostDto> getCurrentUserPostOauthTOken() {
		OAuth2AccessToken accessToken = getCurrentUserOAuthToken();
		return (List<EDPMsPostDto>) accessToken.getAdditionalInformation().get(OAuthConstant.POST);
	}

	/**
	 * Gets the current user primary post oauth token.
	 *
	 * @return the current user primary post oauth token
	 */
	public static EDPMsPostDto getCurrentUserPrimaryPostOauthToken() {
		if (!authFlag) {
			EDPMsPostDto eDPMsPostDto = new EDPMsPostDto();
			eDPMsPostDto.setPostId(1l);
			return eDPMsPostDto;
		}
		OAuth2AccessToken accessToken = getCurrentUserOAuthToken();
		@SuppressWarnings("unchecked")
		List<EDPMsPostDto> edpMsPostDTOList = (List<EDPMsPostDto>) accessToken.getAdditionalInformation()
				.get(OAuthConstant.POST);
		Optional<EDPMsPostDto> primaryPost = edpMsPostDTOList.stream().filter(EDPMsPostDto::isPrimaryPost).findFirst();
		return primaryPost.isPresent() ? primaryPost.get() : new EDPMsPostDto();
	}

	/**
	 * Gets the current user designation oauth token.
	 *
	 * @return the current user designation oauth token
	 */
	public static EDPMsDesignationDto getCurrentUserDesignationOauthToken() {
		if (!authFlag) {
			EDPMsDesignationDto edpMsDesignationDto = new EDPMsDesignationDto();
			edpMsDesignationDto.setDesignationId(1l);
			return edpMsDesignationDto;
		}
		EDPMsPostDto primaryPost = getCurrentUserLoginPostFromOauthToken();
		return primaryPost.getOauthTokenPostDTO().getEdpMsDesignationDto();
	}

	/**
	 * Gets the current user office oauth token.
	 *
	 * @return the current user office oauth token
	 */
	public static EDPMsOfficeDto getCurrentUserOfficeOauthToken() {
		if (!authFlag) {
			EDPMsOfficeDto edpMsOfficeDto = new EDPMsOfficeDto();
			edpMsOfficeDto.setOfficeId(Long.valueOf(1l));
			return edpMsOfficeDto;
		}
		EDPMsPostDto primaryPost = getCurrentUserLoginPostFromOauthToken();
		return primaryPost.getOauthTokenPostDTO().getEdpMsOfficeDto();
	}
	
	/**
	 * Gets the current user endpoints oauth token.
	 *
	 * @return the current user endpoints oauth token
	 */
	public static List<OAuthMsUserEndpointsDTO> getCurrentUserEndpointsOauthToken()
	{
		if (!authFlag) {
			return Collections.emptyList();
		}
		OAuth2AccessToken accessToken = getCurrentUserOAuthToken();
		@SuppressWarnings("unchecked")
		List<EDPMsPostDto> allPost = (List<EDPMsPostDto>)accessToken.getAdditionalInformation().get(OAuthConstant.POST);
		Optional<OAuthTokenPostDTO> oauthTokenPostDTO = allPost.stream().filter(EDPMsPostDto::isLoginPost).map(EDPMsPostDto::getOauthTokenPostDTO).findAny();
		if(oauthTokenPostDTO.isPresent())
		{
			List<EDPMsMenuDto> allMenu = oauthTokenPostDTO.get().getEdpMsMenuDtoList();
			List<List<OAuthMsUserEndpointsDTO>> allEndpoint =  allMenu.stream().filter(entity-> null != entity.getOauthMsUserEndpointsDTOList())
					.map(EDPMsMenuDto::getOauthMsUserEndpointsDTOList).collect(Collectors.toList());
			return allEndpoint.stream().flatMap(List::stream).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
	
	/**
	 * Gets the current user user name.
	 *
	 * @return the current user user name
	 */
	public static String getCurrentUserUserName() {
		if (!authFlag) {
			return StringUtils.EMPTY;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> additionalInfo = staticDefaultTokenServices
				.getAccessToken((OAuth2Authentication) authentication).getAdditionalInformation();
		return additionalInfo.get(OAuthConstant.USERNAME).toString();
	}
	
	
	
	/**
	 * Gets the current user user name.
	 *
	 * @return the current user user name
	 */
	public static String getCurrentUserCode() {
		if (!authFlag) {
			return EDPConstant.LONG_DEFALUT_VALUE;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> additionalInfo = staticDefaultTokenServices
				.getAccessToken((OAuth2Authentication) authentication).getAdditionalInformation();
		return additionalInfo.get(OAuthConstant.USER_CODE).toString();
	}
	
	/**
	 * Gets the current user login post from oauth token.
	 *
	 * @return the current user login post from oauth token
	 */
	public static EDPMsPostDto getCurrentUserLoginPostFromOauthToken() {
		if (!authFlag) {
			EDPMsPostDto eDPMsPostDto = new EDPMsPostDto();
			eDPMsPostDto.setPostId(1l);
			eDPMsPostDto.setLkPoOffUserId(1l);
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeId(1L);
			OAuthTokenPostDTO tokenDto = new OAuthTokenPostDTO();
			tokenDto.setEdpMsOfficeDto(officeDto);
			eDPMsPostDto.setOauthTokenPostDTO(tokenDto);
			return eDPMsPostDto;
		}
		OAuth2AccessToken accessToken = getCurrentUserOAuthToken();
		@SuppressWarnings("unchecked")
		List<EDPMsPostDto> edpMsPostDTOList = (List<EDPMsPostDto>) accessToken.getAdditionalInformation().get(OAuthConstant.POST);
		Optional<EDPMsPostDto> primaryPost = edpMsPostDTOList.stream().filter(EDPMsPostDto::isLoginPost).findFirst();
		return primaryPost.isPresent() ? primaryPost.get() : new EDPMsPostDto();
	}
	
	/**
	 * Gets the current user lk POU id.
	 *
	 * @return the current user lk POU id
	 */
	public static Long getCurrentUserLkPOUId() {
		EDPMsPostDto loginPost = getCurrentUserLoginPostFromOauthToken();
		return loginPost!=null?loginPost.getLkPoOffUserId():0l;
	}
	
	/**
	 * Checks if is current user is DAT.
	 *
	 * @return the boolean
	 */
	public static boolean isCurrentUserIsDAT() {
       EDPMsOfficeDto office = getCurrentUserOfficeOauthToken();
       return null != office && !StringUtils.isEmpty(office.getOfficeDivision()) && office.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE)
    		  ?Boolean.TRUE :Boolean.FALSE;
	}
	
	/**
	 * Gets the menu from login user by menu id.
	 *
	 * @param menuId the menu id
	 * @return the menu from login user by menu id
	 */
	public static EDPMsMenuDto getMenuFromLoginUserByMenuId(Long menuId) {
		EDPMsMenuDto menuDto = null;
		EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
		List<EDPMsMenuDto> menuDtoList = logginPost.getOauthTokenPostDTO().getEdpMsMenuDtoList();
		for(EDPMsMenuDto module : menuDtoList) {
			if(module.getMenuId() == menuId)
				return module;
			for(EDPMsMenuDto subModule : module.getMenuDtos()) {
				if(subModule.getMenuId() == menuId)
					return subModule;
			    List<EDPMsMenuDto> menu = subModule.getMenuDtos();
			    Optional<EDPMsMenuDto> optionalMenuDto = menu.stream().filter(menuD -> menuD.getMenuId() == menuId).findFirst();
			    if(optionalMenuDto.isPresent()) 
			    	return optionalMenuDto.get();	
		    }
		}
		return menuDto;
	}
	
	/**
	 * Gets the wf role using menu id.
	 *
	 * @param menuId the menu id
	 * @return the wf role using menu id
	 */
	public static Set<Long> getWfRoleUsingMenuId(Long menuId){
		EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
		List<EDPMsMenuDto> menuDtoList = logginPost.getOauthTokenPostDTO().getEdpMsMenuDtoList();
		for(EDPMsMenuDto module : menuDtoList) {
			for(EDPMsMenuDto subModule : module.getMenuDtos()) {
			    List<EDPMsMenuDto> menu = subModule.getMenuDtos();
			    Optional<EDPMsMenuDto> optionalMenuDto = menu.stream().filter(menuD -> menuD.getMenuId() == menuId).findFirst();
			    if(optionalMenuDto.isPresent()) 
			    	return getWfRoleFromList(optionalMenuDto.get().getWfRoleId());	
		    }
		}
		return Collections.emptySet();
	}
	
	/**
	 * Gets the wf role from list.
	 *
	 * @param wfIdList the wf id list
	 * @return the wf role from list
	 */
	private static Set<Long> getWfRoleFromList(Set<ClueDto> wfIdList){
		Set<Long> wfRole = new HashSet<>();
		if(!CollectionUtils.isEmpty(wfIdList)) {
			for(ClueDto object : wfIdList) {
				for(Long role : object.getWfRoleIds()) {
					wfRole.add(role);
				}
			}
		}
		return wfRole;
	}
	
	/**
	 * Gets the current user office from token.
	 *
	 * @return the current user office from token
	 */
	public static EDPMsOfficeDto getCurrentUserOfficeFromToken() {
		EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
		return logginPost.getOauthTokenPostDTO().getEdpMsOfficeDto();
	}
	
	/**
	 * Gets the current user office id from token.
	 *
	 * @return the current user office id from token
	 */
	public static Long getCurrentUserOfficeIdFromToken() {
		try {
			EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
			return logginPost.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId();
		} catch (Exception e) {
			return 0l;
		}
	}
	
	/**
	 * Gets the wf role using menu id.
	 *
	 * @param menuId the menu id
	 * @return the wf role using menu id
	 */
	public static Set<Long> getWfRoleOfMenuWithLinkMenuUsingMenuId(Long menuId){
		EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
		List<EDPMsMenuDto> menuDtoList = logginPost.getOauthTokenPostDTO().getEdpMsMenuDtoList();
		for(EDPMsMenuDto module : menuDtoList) {
			for(EDPMsMenuDto subModule : module.getMenuDtos()) {
			    List<EDPMsMenuDto> menu = subModule.getMenuDtos();
			    Optional<EDPMsMenuDto> optionalMenuDto = menu.stream().filter(menuD -> menuD.getMenuId() == menuId).findFirst();
			    if(optionalMenuDto.isPresent()) {			    	
			    	Set<Long> wfRole = getWfRoleFromList(optionalMenuDto.get().getWfRoleId());
			    	wfRole.addAll(getWfRoleFromList(optionalMenuDto.get().getLinkMenuWfRoleId()));
			    	return wfRole;
			    }
		    }
		}
		return Collections.emptySet();
	}
	
	/** The oauth map. */
	private static Map<String, Object> oauthMap = new LinkedHashMap<>();

	/**
	 * Gets the oauth map.
	 *
	 * @return the oauth map
	 */
	public static Map<String, Object> getOauthMap() {
		return oauthMap;
	}
	
	static {
		oauthMap.put("", OAuthUtility.getCurrentUserUserId());
	}

	public static Set<ClueDto> getWfRoleCodeOfMenuWithLinkMenuUsingMenuId(Long menuId){
		EDPMsPostDto logginPost = getCurrentUserLoginPostFromOauthToken();
		List<EDPMsMenuDto> menuDtoList = logginPost.getOauthTokenPostDTO().getEdpMsMenuDtoList();
		for(EDPMsMenuDto module : menuDtoList) {
			for(EDPMsMenuDto subModule : module.getMenuDtos()) {
				List<EDPMsMenuDto> menu = subModule.getMenuDtos();
				Optional<EDPMsMenuDto> optionalMenuDto = menu.stream().filter(menuD -> menuD.getMenuId() == menuId).findFirst();
				if(optionalMenuDto.isPresent()) {
					Set<ClueDto> wfRoleClueDto = optionalMenuDto.get().getWfRoleId();
					wfRoleClueDto.addAll(optionalMenuDto.get().getLinkMenuWfRoleId());
					return wfRoleClueDto;
				}
			}
		}
		return Collections.emptySet();
	}

	private static Set<String> getWfRoleCodeFromList(Set<ClueDto> wfIdList){
		Set<String> wfRole = new HashSet<>();
		if(!CollectionUtils.isEmpty(wfIdList)) {
			for(ClueDto object : wfIdList) {
				for(String roleCode : object.getWfRoleCode()) {
					wfRole.add(roleCode);
				}
			}
		}
		return wfRole;
	}
}
