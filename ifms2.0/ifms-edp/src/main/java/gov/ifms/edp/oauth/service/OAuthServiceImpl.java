package gov.ifms.edp.oauth.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.SecureRandom;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.email.dto.Email;
import gov.ifms.common.email.service.EmailService;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.service.SMSServices;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.converter.EDPMsBranchConverter;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsMenuConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.converter.EDPMsUserLockConverter;
import gov.ifms.edp.converter.EDPSignInMsgConverter;
import gov.ifms.edp.converter.EDPTrnUserItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPChangePass;
import gov.ifms.edp.dto.EDPMsBranchDto;
import gov.ifms.edp.dto.EDPMsForgotPassCaptchaDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPMsUserTokenDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPMsForgotPassCaptchaEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserPassHistEntity;
import gov.ifms.edp.entity.EDPMsUserToken;
import gov.ifms.edp.entity.EDPTrnPouBrMapEntity;
import gov.ifms.edp.entity.EDPTrnUserItrEntity;
import gov.ifms.edp.oauth.dto.EdpMsUserLockDto;
import gov.ifms.edp.oauth.dto.OAuthEmployeeInfoDTO;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.oauth.entity.EdpMsUserLockEntity;
import gov.ifms.edp.oauth.entity.OAuth2AccessTokenDto;
import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;
import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserEndpointsRepository;
import gov.ifms.edp.oauth.repository.OAuthMsUserSessionsRepository;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkUserMenuRepository;
import gov.ifms.edp.repository.EDPMsForgotPasswordCaptchaRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPMsUserLockRepository;
import gov.ifms.edp.repository.EDPMsUserPassHistRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPMsUserTokenRepository;
import gov.ifms.edp.repository.EDPSignInMsgRepository;
import gov.ifms.edp.repository.EDPTrnPouBrMapRepository;
import gov.ifms.edp.repository.EDPTrnUserItrRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class OAuthServiceImpl.
 */
@Service
public class OAuthServiceImpl implements OAuthService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/** The edp ms user repository. */
	@Autowired
	private EDPMsUserRepository edpMsUserRepository;

	/** The token service. */
	@Autowired
	private DefaultTokenServices tokenService;

	/** The authentication facade service. */
	@Autowired
	private AuthenticationFacadeService authenticationFacadeService;

	/** The token store. */
	@Autowired
	private TokenStore tokenStore;

	/** The encrypt decrypt utill. */
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtill;

	/** The oauth ms user endpoints repository. */
	@Autowired
	private OAuthMsUserEndpointsRepository oauthMsUserEndpointsRepository;

	/** The edp ms post converter. */
	@Autowired
	private EDPMsPostConverter edpMsPostConverter;

	/** The oauth ms user sessions repository. */
	@Autowired
	private OAuthMsUserSessionsRepository oauthMsUserSessionsRepository;

	/** The edp lk puo role grps repository. */
	@Autowired
	private EDPLkUserMenuRepository edpLkUserMenuRepository;

	/** The consumer token services. */
	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	/** The edp ms post repository. */
	@Autowired
	private EDPMsPostRepository edpMsPostRepository;

	/** The edp ms designation converter. */
	@Autowired
	private EDPMsDesignationConverter edpMsDesignationConverter;

	/** The bcrypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	/** The edp lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp ms office converter. */
	@Autowired
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/** The edp ms user pass hist repository. */
	@Autowired
	private EDPMsUserPassHistRepository edpMsUserPassHistRepository;

	/** The edp trn user itr converter. */
	@Autowired
	private EDPTrnUserItrConverter edpTrnUserItrConverter;

	/** The edp trn user itr repository. */
	@Autowired
	private EDPTrnUserItrRepository edpTrnUserItrRepository;

	/** The template engine. */
	@Autowired
	private SpringTemplateEngine templateEngine;

	/** The email service. */
	@Autowired
	private EmailService emailService;

	/** The edp ms user token repository. */
	@Autowired
	private EDPMsUserTokenRepository edpMsUserTokenRepository;

	/** The edp employe repository. */
	@Autowired
	private EDPEmployeRepository edpEmployeRepository;

	@Autowired
	private EDPSignInMsgRepository signInMsgRepository;

	/** The edp ms menu converter. */
	@Autowired
	private EDPMsMenuConverter edpMsMenuConverter;

	@Autowired
	private EDPTrnPouBrMapRepository pouBrMapEntity;

	@Autowired
	private EDPMsBranchConverter branchConverter;

	@Autowired
	private CustomeOAuthService customeOAuthService;

	@Autowired
	private EDPSignInMsgConverter signInMsgConverter;

	@Autowired
	private EDPMsForgotPasswordCaptchaRepository captchaRepository;

	@Autowired
	private SMSServices smsService;
	
	/** The edp ms user  lock repository. */
	@Autowired
	private EDPMsUserLockRepository edpMsUserLockRepository;
	
	/** The edp ms user  lock converter. */
	@Autowired
	private EDPMsUserLockConverter edpMsUserLockConverter;


	@Value("${lock.count}")
	private Integer isLockCount;
	
	/**
	 * Gets the user authorization.
	 *
	 * @param principal  the principal
	 * @param parameters the parameters
	 * @return the user authorization
	 * @throws CustomException
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public OAuth2AccessTokenDto getUserAuthorization(Principal principal, Map<String, String> parameters)
			throws CustomException, UnsupportedEncodingException {

		OAuth2AccessTokenDto oAuth2AccessTokenDto = new OAuth2AccessTokenDto();
		OAuth2AccessToken accessToken = null;

		Map<String, String> authorizationParameters = getAuthorizationParameters(principal.getName(),
				parameters.get(OAuthConstant.USERNAME));

		EDPMsUserEntity edpMsUser = edpMsUserRepository.findByUserCodeAndActiveStatus(
				Long.valueOf(parameters.get(OAuthConstant.USERNAME)), OAuthConstant.ACTIVE_STATUS);
		String decodedPwd = URLDecoder.decode(parameters.get(OAuthConstant.SECRET), "UTF-8");

		if (edpMsUser == null || !bcryptPasswordEncoder.matches(decodedPwd, edpMsUser.getPassword())) {
			EdpMsUserLockDto edpMsUserLockDto =  accountLock(edpMsUser);
			oAuth2AccessTokenDto.setLockCount(edpMsUserLockDto.getLockCount());
			return oAuth2AccessTokenDto;
		}

		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList = edpLkPoOffUserRepository
				.findByUserIdUserIdAndActiveStatus(edpMsUser.getUserId(), OAuthConstant.ACTIVE_STATUS);

		if (CollectionUtils.isEmpty(edpLkPoOffUserEntityList)) {
			logger.error(OAuthConstant.NO_POST_MAP_TO_THIS_USER);
			throw new CustomException(HttpStatus.UNAUTHORIZED, OAuthConstant.NO_POST_MAP_TO_THIS_USER);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		UserDetails userDetails = new User(String.valueOf(edpMsUser.getUserCode()), edpMsUser.getPassword(),
				grantedAuthorities);

		Set<String> responseType = new HashSet<>();
		responseType.add(OAuthConstant.SECRET);

		OAuth2Request authorizationRequest = new OAuth2Request(authorizationParameters, principal.getName(),
				userDetails.getAuthorities(), true, new HashSet<>(), null, OAuthConstant.EMPTY, responseType, null);
		User userPrincipal = new User(userDetails.getUsername(), OAuthConstant.EMPTY, true, true, true, true,
				userDetails.getAuthorities());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal,
				null, userDetails.getAuthorities());

		OAuth2Authentication authenticationRequest = new OAuth2Authentication(authorizationRequest,
				authenticationToken);
		authenticationRequest.setAuthenticated(true);
		accessToken = customeOAuthService.createAccessToken(authenticationRequest);
		try {
			final Map<String, Object> additionalInfo = getAdditionalInfo(edpMsUser, Optional.empty());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
			saveOauthUserSession(accessToken, edpMsUser);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			tokenStore.removeAccessToken(accessToken);
		}
		oAuth2AccessTokenDto.setToken(accessToken);
		return oAuth2AccessTokenDto;
	}

	/**
	 * Gets the additional info.
	 *
	 * @param edpMsUser the edp ms user
	 * @param postId    the post id
	 * @return the additional info
	 * @throws CustomException
	 */
	private Map<String, Object> getAdditionalInfo(EDPMsUserEntity edpMsUser, Optional<EDPMsPostEntity> postId) {

		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList = edpLkPoOffUserRepository
				.findByUserIdUserIdAndActiveStatus(edpMsUser.getUserId(), OAuthConstant.ACTIVE_STATUS);

		List<EDPMsPostDto> allMsPostDto = getMsPostDTOFromEdpLkPostUserOfficeEntityList(edpLkPoOffUserEntityList, postId);


		List<Object[]> employeeInfo  = edpEmployeRepository.getEmployeeInfoForLogin(edpMsUser.getUserCode());

		final Map<String, Object> additionalInfo = new HashMap<>();
		additionalInfo.put(OAuthConstant.USERID, (encryptDecryptUtill.encrypt(Long.toString(edpMsUser.getUserId()))));
		additionalInfo.put(OAuthConstant.USERNAME, EDPUtility.getEmployeeNameFromEmployeeInfo(employeeInfo));
		additionalInfo.put(OAuthConstant.USER_CODE, edpMsUser.getUserCode());
		/** Add Temporary HardCoded UserType In OAuth (In Feature It's Will Remove) **/
		additionalInfo.put(OAuthConstant.USER_TYPE, getUserTypeFromEDPMsUser(edpMsUser));
		/** ------------------------------------------------------------------------------**/
		additionalInfo.put(OAuthConstant.IS_ALREADY_LOGGING, false);
		additionalInfo.put(OAuthConstant.IS_FIRST_LOGIN, edpMsUser.getFirstLogin());
		additionalInfo.put(OAuthConstant.POST, allMsPostDto);
		additionalInfo.put(OAuthConstant.IS_RESET, edpMsUser.getIsPassReset());
		additionalInfo.put(OAuthConstant.EMPLOYEE_INFO, getEmployeeInfo(employeeInfo));
		additionalInfo.put(OAuthConstant.IDEAL_TIMEOUT,OAuthConstant.IDEAL_TIMOUT_MILLI_SECONDS);
		signInMsgRepository.findTop1ByEnableMsgDsplAndActiveStatusOrderBySignInMsgIdDesc(Constant.ACTIVE_STATUS,Constant.ACTIVE_STATUS).ifPresent(x -> {
			additionalInfo.put(OAuthConstant.SIGN_IN_MSG_INFO,signInMsgConverter.toDTO(x));
		});
		if (!CollectionUtils.isEmpty(edpLkPoOffUserEntityList)) {
			Optional<EDPMsPostDto> loginPost = allMsPostDto.stream().filter(EDPMsPostDto::isLoginPost).findFirst();
			if (loginPost.isPresent()) {
				List<EDPTrnPouBrMapEntity> pouBrEntities = pouBrMapEntity
						.findByEdpLkPoOffUserIdLkPoOffUserIdAndActiveStatus(loginPost.get().getLkPoOffUserId(), Constant.ACTIVE_STATUS);
				if (!CollectionUtils.isEmpty(pouBrEntities)) {
					List<EDPMsBranchDto> branches = new ArrayList<>();
					for (EDPTrnPouBrMapEntity pouBrEntity : pouBrEntities) {
						branches.add(branchConverter.toDTO(pouBrEntity.getEdpMsBranchEntity()));
					}
					additionalInfo.put(OAuthConstant.BRANCH_DETAILS, branches);
				}
			}
		}
		return additionalInfo;
	}

	/**
	 * Gets the employee info.
	 *
	 * @param employeeInfo the employee info
	 * @return the employee info
	 */
	private OAuthEmployeeInfoDTO getEmployeeInfo(List<Object[]> employeeInfo) {
		OAuthEmployeeInfoDTO dto = new OAuthEmployeeInfoDTO();
		if(!CollectionUtils.isEmpty(employeeInfo)) {
			dto.setEmailId(null != employeeInfo.get(0)[4]?EDPUtility.convertObjectToString(employeeInfo.get(0)[4]):EDPConstant.EMPTY_STRING);
			dto.setMobileNo(null != employeeInfo.get(0)[5]?EDPUtility.convertObjectToString(employeeInfo.get(0)[5]):EDPConstant.EMPTY_STRING);
			dto.setPanNo(null != employeeInfo.get(0)[6]?EDPUtility.convertObjectToString(employeeInfo.get(0)[6]):EDPConstant.EMPTY_STRING);
		}
		return dto;
	}

	/**
	 * Gets the ms office DTO from edp lk post user office entity list.
	 *
	 * @param edpLkPoOffUserEntityList the edp lk po off user entity list
	 * @param msPostDto                the ms post dto
	 * @return the ms office DTO from edp lk post user office entity list
	 */
	private Optional<EDPMsOfficeDto> getMsOfficeDTOFromEdpLkPostUserOfficeEntityList(
			List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList, EDPMsPostDto msPostDto) {

		return edpLkPoOffUserEntityList.stream()
				.filter(entity -> entity.getLkPostOfficeId().getPostEntity().getPostId().equals(msPostDto.getPostId()))
				.map(entity -> edpMsOfficeConverter.toDTO(entity.getLkPostOfficeId().getOfficeEntity())).findFirst();
	}

	/**
	 * Gets the ms post DTO from edp lk post user office entity list.
	 *
	 * @param edpLkPoOffUserEntityList the edp lk po off user entity list
	 * @param postId                   the post id
	 * @return the ms post DTO from edp lk post user office entity list
	 */
	private List<EDPMsPostDto> getMsPostDTOFromEdpLkPostUserOfficeEntityList(
			List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList, Optional<EDPMsPostEntity> postId) {

		if (!CollectionUtils.isEmpty(edpLkPoOffUserEntityList)) {

			List<EDPMsPostDto> edpMsPostDtoList = new ArrayList<>();

			edpLkPoOffUserEntityList.forEach(entity -> {

				EDPMsPostDto msPostDto = edpMsPostConverter.toDTO(entity.getLkPostOfficeId().getPostEntity());

				OAuthTokenPostDTO oauthTokenPostDTO = getOauthTokenPostDTO(edpLkPoOffUserEntityList, postId, entity,
						msPostDto);
				msPostDto.setOauthTokenPostDTO(oauthTokenPostDTO);
				msPostDto.setLkPoOffUserId(entity.getLkPoOffUserId());
				edpMsPostDtoList.add(msPostDto);
			});
			return edpMsPostDtoList;
		}
		return Collections.emptyList();
	}


	/**
	 * Gets the new token from old refesh token.
	 *
	 * @param refeshToken the refesh token
	 * @return the new token from old refesh token
	 * @throws CustomException
	 */
	@Override
	public OAuth2AccessToken getNewTokenFromOldRefeshToken(String refeshToken) throws CustomException {
		OAuth2AccessToken accessToken = null;
		OAuth2RefreshToken oauth2RefreshToken = tokenStore.readRefreshToken(refeshToken);
		if (oauth2RefreshToken != null) {
			OAuth2Authentication oAuth2Authentication = tokenStore
					.readAuthenticationForRefreshToken(oauth2RefreshToken);

			if (oAuth2Authentication != null) {
				accessToken = tokenService.getAccessToken(oAuth2Authentication);
				OAuth2Request oauth2Authentication = oAuth2Authentication.getOAuth2Request();
				Set<String> scope = oauth2Authentication.getScope();
				EDPMsUserEntity edpMsUser;
				if (accessToken != null) {
					int refeshTokenValidSecond = (accessToken.getExpiresIn()
							+ (OAuthConstant.REFRESH_TOKEN_VALIDITY_SECONDS
							- OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS));
					if (refeshTokenValidSecond < 0) {
						consumerTokenServices.revokeToken(accessToken.getValue());
						return null;
					} else {
						Map<String, Object> additionalInfdo = accessToken.getAdditionalInformation();
						String userCode = additionalInfdo.get(OAuthConstant.USER_CODE).toString();
						edpMsUser = edpMsUserRepository.findByUserCodeAndActiveStatus(Long.valueOf(userCode),
								OAuthConstant.ACTIVE_STATUS);
					}
				} else {
					String userCode = ((UserDetails) oAuth2Authentication.getPrincipal()).getUsername();
					edpMsUser = edpMsUserRepository.findByUserCodeAndActiveStatus(Long.valueOf(userCode),
							OAuthConstant.ACTIVE_STATUS);
					accessToken = tokenService.createAccessToken(oAuth2Authentication);
					saveOauthUserSession(accessToken, edpMsUser);
					tokenStore.removeRefreshToken(oauth2RefreshToken);
				}

				Optional<EDPMsPostEntity> postEntity = getLogginPostFromOAuthToken(accessToken);
				final Map<String, Object> additionalInfo = getAdditionalInfo(edpMsUser, postEntity);
				((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
				((DefaultOAuth2AccessToken) accessToken).setScope(scope);
				((DefaultOAuth2AccessToken) accessToken).setExpiration(getNewExpirationTimeForToken());
			}
		}
		return accessToken;
	}

	/**
	 * Save oauth user session.
	 *
	 * @param newAccessToken the new access token
	 * @param edpMsUser      the edp ms user
	 */
	private void saveOauthUserSession(OAuth2AccessToken newAccessToken, EDPMsUserEntity edpMsUser) {
		OAuthMsUserSessionsEntity newUserSession = getNewOAuthUserSession(newAccessToken.getValue(), edpMsUser);
		oauthMsUserSessionsRepository.save(newUserSession);
	}

	/**
	 * Deactive O auth user session.
	 *
	 * @param accessToken the access token
	 */
	private void deactiveOAuthUserSession(OAuth2AccessToken accessToken) {
		Optional<OAuthMsUserSessionsEntity> oldUserSession = oauthMsUserSessionsRepository
				.findBySessionId(accessToken.getValue());
		if (oldUserSession.isPresent()) {
			oldUserSession.get().setActiveStatus(OAuthConstant.DEACTIVE_STATUS);
			oauthMsUserSessionsRepository.save(oldUserSession.get());
		}
	}

	/**
	 * Gets the authorization parameters.
	 *
	 * @param clientId the client id
	 * @param userName the user name
	 * @return the authorization parameters
	 */
	private Map<String, String> getAuthorizationParameters(String clientId, String userName) {
		Map<String, String> authorizationParameters = new HashMap<>();
		authorizationParameters.put(OAuthConstant.SCOPE, OAuthConstant.SCOPE_READ);
		authorizationParameters.put(OAuthConstant.USERNAME, userName);
		authorizationParameters.put(OAuthConstant.CLIENT_ID, clientId);
		authorizationParameters.put(OAuthConstant.GRANT, OAuthConstant.SECRET);
		return authorizationParameters;
	}

	/**
	 * Load user by username.
	 *
	 * @param userName the user name
	 * @return the user details
	 */
	public UserDetails loadUserByUsername(String userName) {
		EDPMsUserEntity edpMstUser = edpMsUserRepository.findByUserCodeAndActiveStatus(Long.valueOf(userName),
				OAuthConstant.ACTIVE_STATUS);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		return new User(edpMstUser.getUserName(), edpMstUser.getPassword(), grantedAuthorities);
	}

	/**
	 * Gets the o auth user info.
	 *
	 * @return the o auth user info
	 */
	@Override
	public Map<String, Object> getOAuthUserInfo() {
		OAuth2Authentication authentication = (OAuth2Authentication) authenticationFacadeService.getAuthentication();
		OAuth2AccessToken token = tokenService.getAccessToken(authentication);
		return token.getAdditionalInformation();
	}

	/**
	 * Gets the new O auth user session.
	 *
	 * @param sessionValue the session value
	 * @param edpMsUser    the edp ms user
	 * @return the new O auth user session
	 */
	private OAuthMsUserSessionsEntity getNewOAuthUserSession(String sessionValue, EDPMsUserEntity edpMsUser) {
		Date sessionStartTime = new Date();
		Date sessionTimeOut = sessionStartTime;
		sessionTimeOut.setTime(sessionStartTime.getTime() + OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS);

		return new OAuthMsUserSessionsEntity(sessionValue, OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS,
				OAuthConstant.OAUTH_USER_MAX_SESSION, edpMsUser, sessionStartTime, sessionTimeOut,
				OAuthConstant.ACTIVE_STATUS);
	}

	/**
	 * Logout user.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean logoutUser() {

		OAuth2AccessToken accessToken = OAuthUtility.getCurrentUserOAuthToken();
		boolean isLogout = OAuthUtility.isUserLogout();
		if (isLogout) {
			deactiveOAuthUserSession(accessToken);
			return true;
		}
		return false;
	}

	/**
	 * Gets the new expiration time for token.
	 *
	 * @return the new expiration time for token
	 */
	private Date getNewExpirationTimeForToken() {
		return new Date(System.currentTimeMillis()
				+ (OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS * OAuthConstant.MILLI_TO_SECOND_DIFF));
	}

	/**
	 * Gets the oauth token for post change.
	 *
	 * @param postId the post id
	 * @return the oauth token for post change
	 * @throws CustomException
	 */
	@Override
	public OAuth2AccessToken getOauthTokenForPostChange(long postId) throws CustomException {
		OAuth2AccessToken accessToken = null;
		Optional<EDPMsPostEntity> loginPost = edpMsPostRepository.findById(postId);
		if (loginPost.isPresent()) {
			OAuth2AccessToken oldAccessToken = OAuthUtility.getCurrentUserOAuthToken();
			long userId = OAuthUtility.getCurrentUserUserId();
			Optional<EDPMsUserEntity> edpMsUserEntity = edpMsUserRepository.findById(userId);
			if (edpMsUserEntity.isPresent()) {
				Map<String, Object> additionalInfo = getAdditionalInfo(edpMsUserEntity.get(), loginPost);
				((DefaultOAuth2AccessToken) oldAccessToken).setAdditionalInformation(additionalInfo);
				((DefaultOAuth2AccessToken) oldAccessToken).setExpiration(getNewExpirationTimeForToken());
				return oldAccessToken;
			}
		}
		return accessToken;
	}

	/**
	 * Gets the menu dto list from post.
	 *
	 * @param entity the entity
	 * @return the menu dto list from post
	 */

	private List<EDPMsMenuDto> getMenuDtoListFromPost(EDPLkPoOffUserEntity entity) {
		List<OAuthMsUserEndpointsEntity> masterEndpointList = oauthMsUserEndpointsRepository.findByActiveStatus(OAuthConstant.ACTIVE_STATUS);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.IN_LK_POU_ID, entity.getLkPoOffUserId());
		List<Object[]> menuInfo = callSp(EDPConstant.SP_LOGIN_USER_MENU_ROLEPRM_WF,paramMap);
		Map<Long, Set<ClueDto>> menuWf = getMenuAndWorkFlow(menuInfo);
		List<Object[]> menuDataList = menuInfo.stream().filter(menuData-> null != menuData[2]).collect(Collectors.toList());
		return CollectionUtils.isEmpty(menuDataList)? new ArrayList<>()
				: edpMsMenuConverter.authTokenEntityToDtoList(menuDataList,masterEndpointList,menuWf);
	}

	/**
	 * Sets the menu office in oauth token post DTO.
	 *
	 * @param entity                        the entity
	 * @param msPostDto                     the ms post dto
	 * @param oauthTokenPostDTO             the oauth token post DTO
	 */
	private void setMenuInOauthTokenPostDTO(EDPLkPoOffUserEntity entity, EDPMsPostDto msPostDto,
			OAuthTokenPostDTO oauthTokenPostDTO) {
		if(oauthTokenPostDTO.isTransactionAllow()) {
			List<EDPMsMenuDto> menuDtoList = getMenuDtoListFromPost(entity);
			oauthTokenPostDTO.setEdpMsMenuDtoList(menuDtoList);
		}
		msPostDto.setLoginPost(true);
	}

	/**
	 * Sets the ms designation in Oauth token post DTO.
	 *
	 * @param entity            the entity
	 * @param oauthTokenPostDTO the oauth token post DTO
	 */
	private void setMsDesignationInOAuthTokenPostDTO(EDPLkPoOffUserEntity entity, OAuthTokenPostDTO oauthTokenPostDTO) {
		if (entity != null && entity.getLkPostOfficeId() != null && entity.getLkPostOfficeId().getPostEntity() != null
				&& entity.getLkPostOfficeId().getPostEntity().getDesignationId() != null) {
			oauthTokenPostDTO.setEdpMsDesignationDto(
					edpMsDesignationConverter.toDTO(entity.getLkPostOfficeId().getPostEntity().getDesignationId()));

		}
	}

	/**
	 * Gets the oauth token post DTO.
	 *
	 * @param edpLkPostUserOfficeEntityList the edp lk post user office entity list
	 * @param postId                        the post id
	 * @param entity                        the entity
	 * @param msPostDto                     the ms post dto
	 * @return the oauth token post DTO
	 */
	private OAuthTokenPostDTO getOauthTokenPostDTO(List<EDPLkPoOffUserEntity> edpLkPostUserOfficeEntityList,
			Optional<EDPMsPostEntity> postId, EDPLkPoOffUserEntity entity, EDPMsPostDto msPostDto) {
		OAuthTokenPostDTO oauthTokenPostDTO = new OAuthTokenPostDTO();
		Optional<EDPMsOfficeDto> officeDto = getMsOfficeDTOFromEdpLkPostUserOfficeEntityList(edpLkPostUserOfficeEntityList, msPostDto);
		if (officeDto.isPresent()) {
			oauthTokenPostDTO.setEdpMsOfficeDto(officeDto.get());
			setMsDesignationInOAuthTokenPostDTO(entity, oauthTokenPostDTO);
			setTransactionAllowForPost(oauthTokenPostDTO, officeDto.get(),msPostDto);
			if (!postId.isPresent() && entity.getIsPrimaryPost().getLookUpInfoName().equals(Constant.LOOKUP_YES)) {
				msPostDto.setPrimaryPost(true);
				setMenuInOauthTokenPostDTO(entity, msPostDto, oauthTokenPostDTO);
			}
			if (postId.isPresent()) {
				if (entity.getIsPrimaryPost().getLookUpInfoName().equals(Constant.LOOKUP_YES))
					msPostDto.setPrimaryPost(true);
				if (msPostDto.getPostId().equals(postId.get().getPostId()))
					setMenuInOauthTokenPostDTO(entity, msPostDto, oauthTokenPostDTO);
			}
		}
		return oauthTokenPostDTO;
	}

	/**
	 * Sets the transaction allow for post.
	 *
	 * @param oauthTokenPostDTO the oauth token post DTO
	 * @param edpMsOfficeDto the edp ms office dto
	 * @param msPostDto the ms post dto
	 */
	private void setTransactionAllowForPost(OAuthTokenPostDTO oauthTokenPostDTO, EDPMsOfficeDto edpMsOfficeDto, EDPMsPostDto msPostDto) {
		Long officeStatus = edpMsOfficeDto.getOfficeStatus();
		if(null != officeStatus) {
			if(!officeStatus.equals(EDPConstant.LOOKUP_INFO_CANCEL_ID)
					&& !officeStatus.equals(EDPConstant.LOOKUP_INFO_INACTIVE_ID)) {
				oauthTokenPostDTO.setTransactionAllow(Boolean.TRUE);
			} else {
				oauthTokenPostDTO.setTransactionAllow(Boolean.FALSE);
				String status = officeStatus.equals(EDPConstant.LOOKUP_INFO_CANCEL_ID)?EDPConstant.LOOKUP_INFO_CANCEL_VALUE:EDPConstant.LOOKUP_INFO_INACTIVE_VALUE;
				String displayMessage = MessageFormat.format(MsgConstant.OAUTH_LOGIN_FROM_INACTIVE_CANCLE_OFFICE,msPostDto.getPostName(),
						status,null != edpMsOfficeDto.getOfficeEndDate() ? new SimpleDateFormat(EDPConstant.DD_MM_YYYY).format(edpMsOfficeDto.getOfficeEndDate()):"-");
				oauthTokenPostDTO.setTransactionMessage(displayMessage);
			}
		} else {
			oauthTokenPostDTO.setTransactionAllow(Boolean.TRUE);
		}
	}

	/**
	 * Gets the loggin post from O auth token.
	 *
	 * @param accessToken the access token
	 * @return the loggin post from O auth token
	 */
	private Optional<EDPMsPostEntity> getLogginPostFromOAuthToken(OAuth2AccessToken accessToken) {
		Map<String, Object> additionalInfo = accessToken.getAdditionalInformation();
		if (additionalInfo != null) {
			@SuppressWarnings("unchecked")
			List<EDPMsPostDto> allMsPostDto = (List<EDPMsPostDto>) additionalInfo.get(OAuthConstant.POST);
			return allMsPostDto.stream().filter(EDPMsPostDto::isLoginPost)
					.map(entity -> edpMsPostConverter.toEntity(entity)).findAny();
		}
		return Optional.empty();
	}

	/**
	 * Change password.
	 *
	 * @param changePassword the change password
	 * @return true, if successful
	 */
	@Override
	public boolean changePassword(EDPChangePass changePassword) {
		Optional<EDPMsUserEntity> optionalEdpMsUserEntity = edpMsUserRepository
				.findById(OAuthUtility.getCurrentUserUserId());
		if (optionalEdpMsUserEntity.isPresent()) {
			String currentPassword = changePassword.getCurrentPassword();
			if (bcryptPasswordEncoder.matches(currentPassword, optionalEdpMsUserEntity.get().getPassword())) {
				String newPassword = bcryptPasswordEncoder.encode(changePassword.getNewPassword());
				insertPasswordHistory(newPassword, optionalEdpMsUserEntity.get().getUserId());
				insertItrUserTable();
				int count = edpMsUserRepository.updateUserPassword(newPassword, new Date(),
						OAuthUtility.getCurrentUserUserId(), new Date(),
						OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId(),
						OAuthUtility.getCurrentUserUserId());
				Email email = new Email();
				email.setSubject(OAuthConstant.PASS_CHANGE_SUCCESS);
				Context context = new Context();
				context.setVariable(EDPConstant.USER_CODE, optionalEdpMsUserEntity.get().getUserCode().toString());
				String content = templateEngine.process(EDPConstant.TEMPLATE, context);
				content = EDPUtility.html2text(content);
				email.setMessageText(content);
				Map<String, Object> map = getEmpEmailAndMobileByUserCode(optionalEdpMsUserEntity.get().getUserCode());
				if (null != map.get(EDPConstant.USER_EMAIL)) {
					String emailId = map.get(EDPConstant.USER_EMAIL).toString();
					email.setTo(new String[] { emailId });
					emailService.sendMail(email);
				}
				return count > 0;
			}
		}
		return Boolean.FALSE;

	}

	/**
	 * Insert itr user table.
	 */
	private void insertItrUserTable() {
		Optional<EDPMsUserEntity> edpMsUserEntity = edpMsUserRepository.findById(OAuthUtility.getCurrentUserUserId());
		if (edpMsUserEntity.isPresent()) {
			EDPTrnUserItrEntity edpTrnUserItrEntity = edpTrnUserItrConverter
					.edpMsUserTotrnUserItr(edpMsUserEntity.get());
			edpTrnUserItrEntity.setUserId(new EDPMsUserEntity(edpMsUserEntity.get().getUserId()));
			edpTrnUserItrRepository.save(edpTrnUserItrEntity);
		}
	}

	/**
	 * Insert password history.
	 *
	 * @param newPassword the new password
	 * @param userId      the user id
	 */
	public void insertPasswordHistory(String newPassword, long userId) {
		EDPMsUserPassHistEntity edpMsUserPassHistEntity = new EDPMsUserPassHistEntity();
		edpMsUserPassHistEntity.setBrowser(EDPUtility.getRequestBrowser());
		edpMsUserPassHistEntity.setIpAddress(EDPUtility.getRequestUserIPAddress());
		edpMsUserPassHistEntity.setUserId(new EDPMsUserEntity(userId));
		edpMsUserPassHistEntity.setPassword(newPassword);
		edpMsUserPassHistEntity.setCreatedBy(userId);
		edpMsUserPassHistEntity.setCreatedByPost(1);
		edpMsUserPassHistEntity.setCreatedDate(new Date());
		edpMsUserPassHistEntity.setUpdatedBy(userId);
		edpMsUserPassHistEntity.setUpdatedByPost(userId);
		edpMsUserPassHistEntity.setUpdatedDate(new Date());
		edpMsUserPassHistRepository.save(edpMsUserPassHistEntity);
	}

	/**
	 * Checks if is password already used.
	 *
	 * @param newPasswordCheck the new password check
	 * @param userId           the user id
	 * @return true, if is password already used
	 */
	@Override
	public boolean isPasswordAlreadyUsed(String newPasswordCheck, long userId) {
		boolean isPasswordUsed = false;
		List<EDPMsUserPassHistEntity> lstEdpMsUserPassHistEntities = edpMsUserPassHistRepository
				.findTop3ByUserIdUserIdOrderByCreatedDateDesc(userId);
		for (EDPMsUserPassHistEntity entity : lstEdpMsUserPassHistEntities) {

			isPasswordUsed = bcryptPasswordEncoder.matches(newPasswordCheck, entity.getPassword());
			if (isPasswordUsed) {
				return isPasswordUsed;
			}
		}
		return isPasswordUsed;
	}

	/**
	 * Gets the emp email and mobile by user code.
	 *
	 * @param userCode the user code
	 * @return the emp email and mobile by user code
	 */
	public final Map<String, Object> getEmpEmailAndMobileByUserCode(Long userCode) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.USER_CODE, userCode);
		List<Object[]> emailAndMobile = edpMsUserRepository
				.executeSQLQuery(EDPNativeSQLUtil.getEmpAndMobileByUserCode(), paramMap);
		paramMap.clear();
		if (!emailAndMobile.isEmpty()) {
			if (null != emailAndMobile.get(0)[0]) {
				paramMap.put(EDPConstant.USER_EMAIL, (String) emailAndMobile.get(0)[0]);
			}
			paramMap.put(EDPConstant.USER_MOBILE, (String) emailAndMobile.get(0)[1]);
			paramMap.put(EDPConstant.USER_ID, (BigInteger) emailAndMobile.get(0)[2]);
			paramMap.put(EDPConstant.EMP_NO, (BigInteger) emailAndMobile.get(0)[3]);
		}
		return paramMap;
	}

	/**
	 * Send otp to user.
	 *
	 * @param userCode the user code
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, String> sendOtpToUser(String userCode) throws CustomException {
		Map<String, Object> paramMap = getEmpEmailAndMobileByUserCode(Long.valueOf(userCode));
		if (!paramMap.isEmpty()) {
			BigInteger userId = (BigInteger) paramMap.get(EDPConstant.USER_ID);
			Map<String, String> map = new HashMap<>();
			if((null == paramMap.get(EDPConstant.USER_EMAIL) || paramMap.get(EDPConstant.USER_EMAIL).equals(""))
					&& (null == paramMap.get(EDPConstant.USER_MOBILE) || paramMap.get(EDPConstant.USER_MOBILE).equals(""))){
				throw new CustomException(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.NO_EMAIL_MAP_TO_THIS_USER);
			}else if(null != paramMap.get(EDPConstant.USER_EMAIL) &&
					(null == paramMap.get(EDPConstant.USER_MOBILE) || paramMap.get(EDPConstant.USER_MOBILE).equals(""))){
				String userEmail = paramMap.get(EDPConstant.USER_EMAIL).toString();
				EDPMsUserToken tokenEntity = saveToken(userEmail,userId,null);
				sendEmail(String.valueOf(paramMap.get(EDPConstant.EMP_NO)),userEmail,tokenEntity);
			map.put(EDPConstant.EMAIL_MASK, EDPUtility.getMaskEmail(userEmail));
				map.put(EDPConstant.TOKEN_HASH, encryptDecryptUtill.encrypt(userId + ""));
			}else if(( null == paramMap.get(EDPConstant.USER_EMAIL) || paramMap.get(EDPConstant.USER_EMAIL).equals(""))
					&& null != paramMap.get(EDPConstant.USER_MOBILE)){
				String userMobile = paramMap.get(EDPConstant.USER_MOBILE).toString();
				EDPMsUserToken tokenEntity = saveToken(null,userId,userMobile);
				sendSms(userMobile,tokenEntity,String.valueOf(paramMap.get(EDPConstant.EMP_NO)));
				map.put(EDPConstant.MOBILE_MASK, EDPUtility.getMaskMobileNo(userMobile));
				map.put(EDPConstant.TOKEN_HASH, encryptDecryptUtill.encrypt(userId + ""));
			}else{
				String userEmail = paramMap.get(EDPConstant.USER_EMAIL).toString();
				String userMobile = paramMap.get(EDPConstant.USER_MOBILE).toString();
				EDPMsUserToken tokenEntity = saveToken(userEmail,userId,userMobile);
				sendEmail(String.valueOf(paramMap.get(EDPConstant.EMP_NO)),userEmail,tokenEntity);
				sendSms(userMobile,tokenEntity,String.valueOf(paramMap.get(EDPConstant.EMP_NO)));
				map.put(EDPConstant.EMAIL_MASK, EDPUtility.getMaskEmail(userEmail));
				map.put(EDPConstant.MOBILE_MASK, EDPUtility.getMaskMobileNo(userMobile));
				map.put(EDPConstant.TOKEN_HASH, encryptDecryptUtill.encrypt(userId + ""));
			}
			return map;
		}
		return null;
	}

	private EDPMsUserToken saveToken(String userEmail,BigInteger userId,String userMobile){
		SecureRandom rand = new SecureRandom();
		int token = rand.nextInt(900000) + 100000;
		final String passwordRecoveryToken = encryptDecryptUtill.encrypt(String.valueOf(token));
		EDPMsUserToken edpMsUserToken = new EDPMsUserToken();
		edpMsUserToken.setTokenNo(passwordRecoveryToken);
		edpMsUserToken.setEmailId(userEmail);
		edpMsUserToken.setPhoneNo(userMobile);
		edpMsUserToken.setActiveStatus(1);
		edpMsUserToken.setIsValid(0);
		edpMsUserToken.setValidityPeriod(getOtpExpiredTime());
		edpMsUserToken.setUserId(new EDPMsUserEntity(userId.longValue()));
		edpMsUserToken.setActiveStatus(Constant.ACTIVE_STATUS);
		edpMsUserToken.setCreatedBy(userId.longValue());
		edpMsUserToken.setCreatedByPost(1L);
		edpMsUserToken.setUpdatedBy(userId.longValue());
		edpMsUserToken.setUpdatedByPost(1L);
		edpMsUserToken.setCreatedDate(new Date());
		edpMsUserToken.setUpdatedDate(new Date());
		edpMsUserTokenRepository.isOtpValidatedForUser(userId.longValue(),Constant.VALID_OTP_FOR_USER,Constant.ACTIVE_STATUS).ifPresent(x -> {
			x.setIsValid(0);
			edpMsUserTokenRepository.save(x);
		});
		edpMsUserTokenRepository.save(edpMsUserToken);
		return edpMsUserToken;
	}

	private void sendEmail(String empNo,String empEmail, EDPMsUserToken tokenEntity){
		try{
			Pattern emailIdRegex = Pattern.compile(Constant.Regex.GOG_EMAIL_ID_REGEX);
			if(!emailIdRegex.matcher(empEmail).matches()){
				logger.info(empEmail);
				logger.info(OAuthConstant.NOT_GOG_EMAIL_MAP_TO_THIS_USER);
			}
			String token = encryptDecryptUtill.decrypt(tokenEntity.getTokenNo());
			Email email = new Email();
			email.setSubject(OAuthConstant.OTP_SENT_SUCCESSFULLY);
			Context context = new Context();
			context.setVariable("opt", String.valueOf(token));
			context.setVariable(EDPConstant.EMP_NO, empNo);
			context.setVariable(EDPConstant.TRN_NO, tokenEntity.getUserTokenId());
			context.setVariable("exp", Integer.parseInt(OAuthConstant.OPT_VALIDITY) / 60);
			String content = templateEngine.process("mail/sendOtpEmail", context);
			content = EDPUtility.html2text(content);
			email.setMessageText(content);
			email.setTo(new String[] { empEmail });
			emailService.sendMail(email);
		}catch (Exception e){
			logger.error(empEmail);
			logger.error(OAuthConstant.EMAIL_ID_IS_NOT_VALID);
			e.printStackTrace();
		}
	}

	private void sendSms(String mobileNo, EDPMsUserToken tokenEntity,String empNo){
		try {
			String token = encryptDecryptUtill.decrypt(tokenEntity.getTokenNo());
			smsService.sendSingleSMS(mobileNo,MessageFormat.format(MsgConstant.SMS_OTP_TEMPLATE,empNo,token,Integer.parseInt(OAuthConstant.OPT_VALIDITY) / 60));
		} catch (UnsupportedEncodingException|NoSuchAlgorithmException e) {
			logger.error(mobileNo);
			logger.error(OAuthConstant.MOBILE_NO_IS_NOT_VALID);
			e.printStackTrace();
		}
	}

	/**
	 * Verify pass token.
	 *
	 * @param edpMsUserTokenDto the edp ms user token dto
	 * @return the boolean
	 */
	@Override
	public Boolean verifyPassToken(EDPMsUserTokenDto edpMsUserTokenDto) {
		final long userId = Long.parseLong(encryptDecryptUtill.decrypt(edpMsUserTokenDto.getTokenHash() + ""));
		String otp = encryptDecryptUtill.encrypt(edpMsUserTokenDto.getTokenNo());
		Optional<EDPMsUserToken> edpMsUserToken = edpMsUserTokenRepository.isOtpValid(userId, otp, new Date());
		if(edpMsUserToken.isPresent()){
			edpMsUserToken.get().setIsValid(Constant.VALID_OTP_FOR_USER);
			edpMsUserTokenRepository.save(edpMsUserToken.get());
			return Boolean.TRUE;
		}else{

			return Boolean.FALSE;
		}
	}

	/**
	 * Gets the otp expired time.
	 *
	 * @return the otp expired time
	 */
	private Date getOtpExpiredTime() {
		return new Date(System.currentTimeMillis()
				+ (Integer.parseInt(OAuthConstant.OPT_VALIDITY) * OAuthConstant.MILLI_TO_SECOND_DIFF));
	}

	/**
	 * Change new password.
	 *
	 * @param changePassword the change password
	 * @param userId         the user id
	 * @return true, if successful
	 * @throws CustomException
	 */
	@Override
	public boolean changeNewPassword(EDPChangePass changePassword, Long userId) throws CustomException {
		Optional<EDPMsUserEntity> optionalEdpMsUserEntity = edpMsUserRepository.findById(userId);
		if (optionalEdpMsUserEntity.isPresent()) {
			String newPassword = bcryptPasswordEncoder.encode(changePassword.getNewPassword());
			EDPMsUserEntity updateEntity = optionalEdpMsUserEntity.get();
			if (!bcryptPasswordEncoder.matches(changePassword.getNewPassword(), updateEntity.getPassword())) {
				insertPasswordHistory(newPassword, updateEntity.getUserId());
				updateEntity.setPassword(newPassword);
				updateEntity.setPwdChangedDate(new Date());
				updateEntity.setUpdatedDate(new Date());
				updateEntity.setIsPassReset(Constant.IN_ACTIVE_STATUS);
				updateEntity.setFirstLogin(Constant.IN_ACTIVE_STATUS);
				edpMsUserRepository.save(updateEntity);
				Email email = new Email();
				email.setSubject(OAuthConstant.PASS_CHANGE_SUCCESS);
				Context context = new Context();
				context.setVariable(EDPConstant.USER_CODE, updateEntity.getUserCode().toString());
				String content = templateEngine.process(EDPConstant.TEMPLATE, context);
				content = EDPUtility.html2text(content);
				email.setMessageText(content);
				String emailId = getEmpEmailAndMobileByUserCode(optionalEdpMsUserEntity.get().getUserCode())
						.get(EDPConstant.USER_EMAIL).toString();
				email.setTo(new String[] { emailId });
				emailService.sendMail(email);
				return Boolean.TRUE;
			} else {
				throw new CustomException(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.NEW_PASS_OLD_PASS_NOT_SAME);
			}
		}
		return false;

	}

	/**
	 * Encode password.
	 *
	 * @param pwd the pwd
	 * @return the string
	 */
	public String encodePassword(String pwd) {
		return bcryptPasswordEncoder.encode(pwd);
	}

	/**
	 * Check current user password.
	 *
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	public boolean checkCurrentUserPassword(String userPassword) {
		Optional<EDPMsUserEntity> optionalEdpMsUserEntity = edpMsUserRepository
				.findById(OAuthUtility.getCurrentUserUserId());
		return optionalEdpMsUserEntity.isPresent()
				&& bcryptPasswordEncoder.matches(userPassword, optionalEdpMsUserEntity.get().getPassword())
						? Boolean.TRUE
						: Boolean.FALSE;
	}

	/**
	 * Adds the is allready login in token.
	 *
	 * @param token the token
	 * @return the o auth 2 access token
	 */
	public OAuth2AccessToken addIsAllreadyLoginInToken(OAuth2AccessToken token) {
		if (token != null) {
			if (null != token.getAdditionalInformation()) {
				token.getAdditionalInformation().put(OAuthConstant.IS_ALREADY_LOGGING, true);
			} else {
				final Map<String, Object> additionalInfo = new HashMap<>();
				additionalInfo.put(OAuthConstant.IS_ALREADY_LOGGING, true);
				((DefaultOAuth2AccessToken) token).setAdditionalInformation(additionalInfo);
			}
		}
		return token;
	}

	public IdNameDto getOnlyIdAndName(Long userId) {
		return edpMsUserRepository.getOnlyIdAndName(userId);
	}

	/**
	 * Call sp for oauth.
	 *
	 * @param paramMap the param map
	 * @return the list
	 */
	public List<Object[]> callSp(String spName , Map<String, Object> paramMap){
		String procName = Constant.EDP_MASTER_SCHEMA.concat(Constant.DOT.concat(spName));
		return edpLkUserMenuRepository.callStoredProcedure(procName,paramMap);
	}


	/**
	 * Gets the menu and work flow.
	 *
	 * @param menuInfo the menu info
	 * @return the menu and work flow
	 */
	private Map<Long,Set<ClueDto>> getMenuAndWorkFlow(List<Object[]> menuInfo) {
		Map<Long,Set<ClueDto>> menuMap = new HashMap<>();
		menuInfo.forEach(obj -> {
			if(null != obj[4] && null != obj[5]) {
				Long menuId = EDPUtility.convertObjectToLong(obj[0]);
				if(obj != null && menuMap.containsKey(menuId)) {
					Set<ClueDto> wfRole = menuMap.get(menuId);
					ClueDto dto = new ClueDto();
					dto.setWfRoleIds(Arrays.asList(EDPUtility.convertObjectToLong(obj[4])));
					dto.setWfRoleCode(Arrays.asList(EDPUtility.convertObjectToString(obj[5])));
					wfRole.add(dto);
					menuMap.replace(menuId,wfRole);
				} else {
					Set<ClueDto> objList = new HashSet<>();
					ClueDto dto = new ClueDto();
					dto.setWfRoleIds(Arrays.asList(EDPUtility.convertObjectToLong(obj[4])));
					dto.setWfRoleCode(Arrays.asList(EDPUtility.convertObjectToString(obj[5])));
					objList.add(dto);
					menuMap.put(menuId, objList);
				}
		   }
		});
		return menuMap;
	}

	/**
	 * Gets the user type from EDP ms user.
	 *
	 * @param edpMsUser the edp ms user
	 * @return the user type from EDP ms user
	 */
	private ClueDto getUserTypeFromEDPMsUser(EDPMsUserEntity edpMsUser) {
		/**  Add Temporary HardCoded UserType In OAuth (In Feature It's Will Remove) 	 **/
		if (null != edpMsUser)
			return new ClueDto(1, "HOD");
		return null;
	}

	/**
	 * Verify pass token.
	 *
	 * @param userId the edp ms user token dto
	 * @return the boolean
	 */
	@Override
	public Optional<EDPMsUserToken> isValidOTPForUserId(Long userId) {
		return edpMsUserTokenRepository.isOtpValidatedForUser(userId, Constant.VALID_OTP_FOR_USER ,Constant.ACTIVE_STATUS);
	}

	@Override
	public void resetIsValid(EDPMsUserToken userToken) {
		userToken.setIsValid(Constant.INVALID_OTP_FOR_USER);
		edpMsUserTokenRepository.save(userToken);
	}

	@Override
	public EDPMsForgotPassCaptchaDto generateCaptcha() throws CustomException{
		int iTotalChars = 6;
		int iHeight = 40;
		int iWidth = 130;
		Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
		Random randChars = new Random();
		String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
		BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
		g2dImage.setColor(new Color(249, 249, 249));
		g2dImage.fillRect(0,0,iWidth,iHeight);
		int iCircle = 15;
		for (int i = 0; i < iCircle; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		}
		g2dImage.setFont(fntStyle1);
		for (int i = 0; i < iTotalChars; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
			if (i % 2 == 0) {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 21 * i, 24);
			} else {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 21 * i, 35);
			}
		}
		ByteArrayOutputStream osImage = new ByteArrayOutputStream();

		try {
			ImageIO.write(biImage, "jpeg", osImage);
			g2dImage.dispose();
			EDPMsForgotPassCaptchaEntity captchaEntity = new EDPMsForgotPassCaptchaEntity(sImageCode);
			captchaRepository.save(captchaEntity);
			return new EDPMsForgotPassCaptchaDto(captchaEntity.getCaptchaId(),osImage.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"Not able to generate captcha!");
		}
	}

	@Override
	public Optional<EDPMsForgotPassCaptchaEntity> validateCaptcha(long captchaId,String captcha) {
		return captchaRepository.findByCaptchaIdAndCaptcha(captchaId,captcha);
	}

	@Override
	public void deleteCaptchaById(long captchaId) {
		captchaRepository.delete(captchaRepository.getOne(captchaId));
	}
	
	private EdpMsUserLockDto accountLock(EDPMsUserEntity edpMsUser) {
		EdpMsUserLockEntity lockEntity = null;
		if (Objects.nonNull(edpMsUser)) {
			lockEntity = edpMsUserLockRepository.findByUserIdAndActiveStatus(edpMsUser.getUserId(),
					OAuthConstant.ACTIVE_STATUS);
			if (Objects.isNull(lockEntity)) {
				lockEntity = new EdpMsUserLockEntity();
				lockEntity.setUserId(edpMsUser.getUserId());
				lockEntity.setIsLock(OAuthConstant.DEACTIVE_STATUS);// Settign Lock COunt to 1
				lockEntity.setLockCount(OAuthConstant.ACTIVE_STATUS);// By default lock flag value is 1
				lockEntity.setActiveStatus(OAuthConstant.ACTIVE_STATUS);
				// Bydefault setting all the values to 1
				lockEntity.setCreatedBy(edpMsUser.getUserId());
				lockEntity.setCreatedByPost(OAuthConstant.ACTIVE_STATUS);
				lockEntity.setUpdatedBy(edpMsUser.getUserId());
				lockEntity.setUpdatedByPost(OAuthConstant.ACTIVE_STATUS);

				lockEntity.setCreatedDate(new Date());

			} else {
				lockEntity.setLockCount(lockEntity.getLockCount() + 1);
				if (lockEntity.getLockCount() == isLockCount) {
					lockEntity.setIsLock(OAuthConstant.ACTIVE_STATUS);
				}

			}
			lockEntity.setUpdatedDate(new Date());
			edpMsUserLockRepository.save(lockEntity);
		}
		return edpMsUserLockConverter.toDTO(lockEntity);
	}

	
	@Override
	public void resetLockCountAndFlag(EDPMsUserEntity edpMsUser) {
		EdpMsUserLockEntity edpMsUserLockEntity = getMsUserLockEntity(edpMsUser.getUserId());
		if (Objects.nonNull(edpMsUserLockEntity)) {
			edpMsUserLockEntity.setLockCount(OAuthConstant.DEACTIVE_STATUS);
			edpMsUserLockEntity.setIsLock(OAuthConstant.DEACTIVE_STATUS);
			edpMsUserLockRepository.save(edpMsUserLockEntity);
		}

	}

	@Override
	public EdpMsUserLockEntity getMsUserLockEntity(long userId) {
		return edpMsUserLockRepository.findByUserIdAndActiveStatus(userId,OAuthConstant.ACTIVE_STATUS);
	}
}
