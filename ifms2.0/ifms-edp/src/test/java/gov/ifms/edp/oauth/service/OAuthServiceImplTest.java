package gov.ifms.edp.oauth.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import gov.ifms.common.util.EncryptDecryptUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsMenuConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.converter.EDPMsRolePermissionsConverter;
import gov.ifms.edp.dto.EDPChangePass;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPMsUserTokenDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserPassHistEntity;
import gov.ifms.edp.entity.EDPMsUserToken;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.oauth.converter.OAuthMsUserEndpointsConverter;
import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserEndpointsRepository;
import gov.ifms.edp.oauth.repository.OAuthMsUserSessionsRepository;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostUserOfficeRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkUserMenuRepository;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;
import gov.ifms.edp.repository.EDPMsUserPassHistRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPMsUserTokenRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;

/**
 * The Class OAuthServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class OAuthServiceImplTest {

	/** The service. */
	@InjectMocks
	private OAuthServiceImpl service;

	/** The a. */
	@Mock
	private Authentication a;

	/** The access token. */
	@Mock
	private OAuth2AccessToken accessToken;

	/** The tokenserv. */
	@Mock
	private DefaultTokenServices tokenserv;

	/** The token store. */
	@Mock
	private TokenStore tokenStore;

	/** The o auth 2 authentication. */
	@Mock
	private OAuth2Authentication oAuth2Authentication;

	/** The oauthrequest. */
	@Mock
	private OAuth2Request oauthrequest;

	/** The mock security context. */
	@Mock
	private SecurityContext mockSecurityContext;

	/** The consumertoken. */
	@Mock
	private ConsumerTokenServices consumertoken;

	/** The authentication. */
	@Mock
	private Authentication authentication;

	/** The refresh. */
	@Mock
	private OAuth2RefreshToken refresh;

	/** The token service. */
	@Mock
	private DefaultTokenServices tokenService;

	/** The offrepo. */
	@Mock
	private EDPLkPostUserOfficeRepository offrepo;

	/** The edp ms user repository. */
	@Mock
	private EDPMsUserRepository edpMsUserRepository;

	/** The encrypt decrypt utill. */
	@Mock
	private EncryptDecryptUtil encryptDecryptUtill;

	/** The bcrypt password encoder. */
	@Mock
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	/** The edp ms user pass hist repository. */
	@Mock
	private EDPMsUserPassHistRepository edpMsUserPassHistRepository;

	/** The edp ms user pass hist entity. */
	@Mock
	private EDPMsUserPassHistEntity edpMsUserPassHistEntity;

	/** The change password. */
	@Mock
	private EDPChangePass changePassword;

	/** The user entity. */
	@Mock
	private EDPMsUserEntity userEntity;

	/** The default O auth 2 access token. */
	@Mock
	private DefaultOAuth2AccessToken defaultOAuth2AccessToken;

	/** The edp lk po off user repository. */
	@Mock
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The user. */
	@Mock
	private UserDetails user;

	/** The principal. */
	@Mock
	private Principal principal;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The oauth ms user sessions repository. */
	@Mock
	private OAuthMsUserSessionsRepository oauthMsUserSessionsRepository;

	/** The edp lk post office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The edp ms post entity. */
	@Mock
	private EDPMsPostEntity edpMsPostEntity;

	/** The edp ms post converter. */
	@Mock
	private EDPMsPostConverter edpMsPostConverter;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp ms post dto. */
	@Mock
	private EDPMsPostDto edpMsPostDto;

	/** The edp lk user menu repository. */
	@Mock
	private EDPLkUserMenuRepository edpLkUserMenuRepository;

	/** The edp lk user menu entity. */
	@Mock
	private EDPLkUserMenuEntity edpLkUserMenuEntity;

	/** The edp trn user mnu role prm entity. */
	@Mock
	private EDPTrnUserMnuRolePrmEntity edpTrnUserMnuRolePrmEntity;

	/** The edp trn user mnu role prm repository. */
	@Mock
	private EDPTrnUserMnuRolePrmRepository edpTrnUserMnuRolePrmRepository;

	/** The edp ms role permissions converter. */
	@Mock
	private EDPMsRolePermissionsConverter edpMsRolePermissionsConverter;

	/** The edp ms role permissions repository. */
	@Mock
	private EDPMsRolePermissionsRepository edpMsRolePermissionsRepository;

	/** The edp ms role permissions entity. */
	@Mock
	private EDPMsRolePermissionsEntity edpMsRolePermissionsEntity;

	/** The oauth ms user endpoints converter. */
	@Mock
	private OAuthMsUserEndpointsConverter oauthMsUserEndpointsConverter;

	/** The oauth ms user endpoints repository. */
	@Mock
	private OAuthMsUserEndpointsRepository oauthMsUserEndpointsRepository;

	/** The oauth ms user endpoints entity. */
	@Mock
	private OAuthMsUserEndpointsEntity oauthMsUserEndpointsEntity;

	/** The menu repository. */
	@Mock
	private EDPMsMenuRepository menuRepository;

	/** The edp ms menu entity. */
	@Mock
	private EDPMsMenuEntity edpMsMenuEntity;

	/** The edp ms menu converter. */
	@Mock
	private EDPMsMenuConverter edpMsMenuConverter;

	/** The edp ms menu dto. */
	@Mock
	private EDPMsMenuDto edpMsMenuDto;

	/** The edp lk puo menu RLWF repository. */
	@Mock
	private EDPLkPuoMenuRLWFRepository edpLkPuoMenuRLWFRepository;

	/** The edp trn usr mnu wf role. */
	@Mock
	private EDPTrnUsrMnuWfRole edpTrnUsrMnuWfRole;

	/** The edp ms office converter. */
	@Mock
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/** The edp ms office entity. */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** The edp ms office dto. */
	@Mock
	private EDPMsOfficeDto edpMsOfficeDto;

	/** The edp ms designation entity. */
	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	/** The edp ms designation converter. */
	@Mock
	private EDPMsDesignationConverter edpMsDesignationConverter;

	/** The authentication facade service. */
	@Mock
	private AuthenticationFacadeService authenticationFacadeService;

	/** The edp ms user token repository. */
	@Mock
	private EDPMsUserTokenRepository edpMsUserTokenRepository;

	/** The edp ms user token. */
	@Mock
	private EDPMsUserToken edpMsUserToken;

	/** The edp ms user token dto. */
	@Mock
	private EDPMsUserTokenDto edpMsUserTokenDto;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get new token from old refesh token.
	 * @throws CustomException 
	 */

//	@Test
	public void testGetNewTokenFromOldRefeshToken() throws CustomException {
		when(tokenStore.readRefreshToken(JunitConstants.STRING_TYPE)).thenReturn(refresh);
		when(tokenStore.readAuthenticationForRefreshToken(refresh)).thenReturn(oAuth2Authentication);
		when(tokenService.getAccessToken(oAuth2Authentication)).thenReturn(null);
		when(oAuth2Authentication.getOAuth2Request()).thenReturn(oauthrequest);
		Set<String> scope = new HashSet<>();
		scope.add(JunitConstants.STRING_TYPE);
		when(oauthrequest.getScope()).thenReturn(scope);
		when(oAuth2Authentication.getPrincipal()).thenReturn(user);
		when(user.getUsername()).thenReturn(JunitConstants.LONG_STRING);
		when(edpMsUserRepository.findByUserCodeAndActiveStatus(Long.valueOf(JunitConstants.LONG_STRING),
				OAuthConstant.ACTIVE_STATUS)).thenReturn(userEntity);
		when(tokenService.createAccessToken(Mockito.any(OAuth2Authentication.class))).thenReturn(accessToken);
		assertNotNull(service.getNewTokenFromOldRefeshToken(JunitConstants.STRING_TYPE));
	}

	/**
	 * Encode password.
	 */
	@Test
	public void encodePassword() {
		when(bcryptPasswordEncoder.encode(JunitConstants.PASSWORD)).thenReturn(JunitConstants.PASSWORD);
		assertNotNull(service.encodePassword(JunitConstants.PASSWORD));
	}

	/**
	 * Test get user authorization.
	 *
	 * @throws CustomException the custom exception
	 * @throws UnsupportedEncodingException 
	 */

	//@Test
	public void testGetUserAuthorization() throws CustomException, UnsupportedEncodingException {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(OAuthConstant.USERNAME, JunitConstants.LONG_STRING);
		parameters.put(OAuthConstant.SECRET, JunitConstants.STRING_TYPE);
		when(principal.getName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsUserRepository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, OAuthConstant.ACTIVE_STATUS))
				.thenReturn(userEntity);
		when(userEntity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList = new ArrayList<>();
		edpLkPoOffUserEntityList.add(edpLkPoOffUserEntity);
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getPostEntity()).thenReturn(edpMsPostEntity);
		when(edpMsPostEntity.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpLkPoOffUserEntity.getIsPrimaryPost()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(Constant.LOOKUP_YES);
		when(bcryptPasswordEncoder.matches(parameters.get(OAuthConstant.SECRET), userEntity.getPassword()))
				.thenReturn(true);
		when(userEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(edpLkPoOffUserEntityList);
		when(bcryptPasswordEncoder.encode(parameters.get(OAuthConstant.SECRET))).thenReturn(JunitConstants.STRING_TYPE);
		when(oauthMsUserSessionsRepository.countBySessionIdAndActiveStatus(JunitConstants.STRING_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(JunitConstants.INTEGER_TYPE_0);
		when(tokenService.createAccessToken(Mockito.any(OAuth2Authentication.class))).thenReturn(accessToken);
		when(accessToken.getValue()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsPostConverter.toDTO(edpMsPostEntity)).thenReturn(edpMsPostDto);
		when(edpLkPoOffUserEntity.getLkPoOffUserId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPLkUserMenuEntity> edpLkPuoMenuRolesEntity = new ArrayList<>();
		edpLkPuoMenuRolesEntity.add(edpLkUserMenuEntity);
		when(edpLkUserMenuRepository.findByPoOffUserIdLkPoOffUserIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(edpLkPuoMenuRolesEntity);
		when(edpLkUserMenuEntity.getLkUserMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkUserMenuEntity.getMenuID()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPTrnUserMnuRolePrmEntity> lstTrnUserMnuRolePrmEntity = new ArrayList<>();
		lstTrnUserMnuRolePrmEntity.add(edpTrnUserMnuRolePrmEntity);
		when(edpTrnUserMnuRolePrmRepository.findByLkUserMenuIdLkUserMenuIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lstTrnUserMnuRolePrmEntity);
		List<EDPMsRolePermissionsEntity> edpMsRolePermissionsEntityList = new ArrayList<>();
		edpMsRolePermissionsEntityList.add(edpMsRolePermissionsEntity);
		when(edpMsRolePermissionsRepository.findByRolePrmIdIn(Mockito.anySet()))
				.thenReturn(edpMsRolePermissionsEntityList);
		List<OAuthMsUserEndpointsEntity> oauthMsUserEndpointsEntityList = new ArrayList<>();
		oauthMsUserEndpointsEntityList.add(oauthMsUserEndpointsEntity);
		when(oauthMsUserEndpointsRepository.findByActiveStatusAndMenuId(OAuthConstant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(oauthMsUserEndpointsEntityList);
		when(menuRepository.findByActiveStatusAndMenuId(OAuthConstant.ACTIVE_STATUS, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpMsMenuEntity));
		when(edpMsMenuConverter.toDTO(edpMsMenuEntity)).thenReturn(edpMsMenuDto);
		List<EDPTrnUsrMnuWfRole> lstEdpTrnUsrMnuWfRoles = new ArrayList<>();
		lstEdpTrnUsrMnuWfRoles.add(edpTrnUsrMnuWfRole);
		when(edpLkPuoMenuRLWFRepository.findByLkUserMenuIdLkUserMenuIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lstEdpTrnUsrMnuWfRoles);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeConverter.toDTO(edpMsOfficeEntity)).thenReturn(edpMsOfficeDto);
		assertNotNull(service.getUserAuthorization(principal, parameters));
		when(oauthMsUserSessionsRepository.countBySessionIdAndActiveStatus(JunitConstants.STRING_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.getUserAuthorization(principal, parameters));
		when(tokenStore.getAccessToken(Mockito.any(OAuth2Authentication.class))).thenReturn(accessToken);
		assertNotNull(service.getUserAuthorization(principal, parameters));
	}

	/**
	 * Test load user by username.
	 */
	@Test
	public void testLoadUserByUsername() {
		when(edpMsUserRepository.findByUserCodeAndActiveStatus(Long.valueOf(JunitConstants.LONG_STRING),
				OAuthConstant.ACTIVE_STATUS)).thenReturn(userEntity);
		when(userEntity.getUserName()).thenReturn(JunitConstants.STRING_TYPE);
		when(userEntity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.loadUserByUsername(JunitConstants.LONG_STRING));
	}

	/**
	 * Test is password already used.
	 */
	@Test
	public void testIsPasswordAlreadyUsed() {
		List<EDPMsUserPassHistEntity> lstEdpMsUserPassHistEntities = new ArrayList<>();
		lstEdpMsUserPassHistEntities.add(edpMsUserPassHistEntity);
		when(edpMsUserPassHistRepository.findTop3ByUserIdUserIdOrderByCreatedDateDesc(JunitConstants.LONG_TYPE))
				.thenReturn(lstEdpMsUserPassHistEntities);
		when(edpMsUserPassHistEntity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(bcryptPasswordEncoder.matches(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE)).thenReturn(true);
		assertNotNull(service.isPasswordAlreadyUsed(JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE));
		when(bcryptPasswordEncoder.matches(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE)).thenReturn(false);
		assertNotNull(service.isPasswordAlreadyUsed(JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get O auth user info.
	 */
	@Test
	public void testGetOAuthUserInfo() {
		when(authenticationFacadeService.getAuthentication()).thenReturn(oAuth2Authentication);
		when(tokenService.getAccessToken(oAuth2Authentication)).thenReturn(accessToken);
		assertNotNull(service.getOAuthUserInfo());
	}

	/**
	 * Test send otp to user.
	 *
	 * @throws CustomException the custom exception
	 */
	// @Test
	public void testSendOtpToUser() throws CustomException {
		List<Object[]> emailAndMobile = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = JunitConstants.EMAIL;
		obj[1] = JunitConstants.STRING_TYPE;
		emailAndMobile.add(obj);
		when(edpMsUserRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(emailAndMobile);
// 		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put(EDPConstant.USER_CODE, JunitConstants.LONG_TYPE);
//		paramMap.put(EDPConstant.USER_EMAIL,JunitConstants.EMAIL);
		when(edpMsUserTokenRepository.save(Mockito.any(EDPMsUserToken.class))).thenReturn(edpMsUserToken);
		assertNotNull(service.sendOtpToUser(JunitConstants.LONG_STRING));
	}

	/**
	 * Test check current user password.
	 */
	@Test
	public void testCheckCurrentUserPassword() {
		when(edpMsUserRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(userEntity));
		when(userEntity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(bcryptPasswordEncoder.matches(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE)).thenReturn(true);
		assertNotNull(service.checkCurrentUserPassword(JunitConstants.STRING_TYPE));
		when(bcryptPasswordEncoder.matches(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE)).thenReturn(false);
		assertNotNull(service.checkCurrentUserPassword(JunitConstants.STRING_TYPE));
		when(edpMsUserRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNotNull(service.checkCurrentUserPassword(JunitConstants.STRING_TYPE));
	}

	/**
	 * Test verify pass token.
	 */
	@Test
	public void testVerifyPassToken() {
		when(edpMsUserTokenDto.getTokenHash()).thenReturn(JunitConstants.LONG_STRING);
		when(encryptDecryptUtill.decrypt(edpMsUserTokenDto.getTokenHash() + "")).thenReturn(JunitConstants.LONG_STRING);
		EDPMsUserToken token = new EDPMsUserToken();
		when(edpMsUserTokenRepository.isOtpValid(Mockito.anyLong(), Mockito.anyString(), Mockito.any(Date.class)))
				.thenReturn(Optional.of(token));
		assertNotNull(service.verifyPassToken(edpMsUserTokenDto));
	}
}
