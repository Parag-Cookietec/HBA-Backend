
package gov.ifms.edp.oauth.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.EDPChangePass;
import gov.ifms.edp.dto.EDPMsUserDto;
import gov.ifms.edp.dto.EDPMsUserTokenDto;
import gov.ifms.edp.entity.EDPMsForgotPassCaptchaEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserToken;
import gov.ifms.edp.oauth.converter.OAuthMsUserSessionsConverter;
import gov.ifms.edp.oauth.entity.EdpMsUserLockEntity;
import gov.ifms.edp.oauth.entity.OAuth2AccessTokenDto;
import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;
import gov.ifms.edp.oauth.service.OAuthMsUserSessionService;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsUserLockRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.service.EDPMsUserService;

/**
 * The Class OAuthController.
 *
 * @version 0.01
 * @description : OAuth2 token Request
 * @Date : 26 JUNE 2019
 */

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class OAuthController {

	/** The oauth service. */
	@Autowired
	private OAuthService oauthService;

	/** The oauth ms user session service. */
	@Autowired
	private OAuthMsUserSessionService oauthMsUserSessionService;

	/** The oauth ms user sessions converter. */
	@Autowired
	private OAuthMsUserSessionsConverter oauthMsUserSessionsConverter;


	/** The edp ms user service. */
	@Autowired
	private EDPMsUserService edpMsUserService;

	/** The encrypt decrypt util. */
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;
	

	/** The edp ms user  lock repository. */
	@Autowired
	private EDPMsUserLockRepository edpMsUserLockRepository;
	
	@Value("${lock.count}")
	private Integer isLockCount;
	
	/** The edp ms user repository. */
	@Autowired
	private EDPMsUserRepository edpMsUserRepository;

	/**
	 * to create new access token.
	 *
	 * @param principal  the principal
	 * @param parameters the parameters
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws UnsupportedEncodingException
	 */
	@PostMapping(value = URLConstant.OAUTH_CREATE_TOKEN)
	@Trace
	public ResponseEntity<ApiResponse> postAccessToken(Principal principal,
													   @RequestParam Map<String, String> parameters ,HttpServletRequest req) throws CustomException, UnsupportedEncodingException {
		EDPMsUserEntity edpMsUser = edpMsUserRepository.findByUserCodeAndActiveStatus(
				Long.valueOf(parameters.get(OAuthConstant.USERNAME)), OAuthConstant.ACTIVE_STATUS);
		EdpMsUserLockEntity edpMsUserLockEntity = oauthService.getMsUserLockEntity(edpMsUser.getUserId());
		
		if(Objects.nonNull(edpMsUserLockEntity) && Objects.nonNull(edpMsUserLockEntity.getIsLock()) && edpMsUserLockEntity.getIsLock() == OAuthConstant.ACTIVE_STATUS) {
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.ACCOUNT_LOCKED,null);
		}
		OAuth2AccessTokenDto oAuth2AccessToken = oauthService.getUserAuthorization(principal, parameters);
		OAuth2AccessToken token = oAuth2AccessToken.getToken();
		
		if (token == null && oAuth2AccessToken.getLockCount() == 0) {
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.USERNAME_OR_PASWD_INCORRECT, token);
		}else if ( token == null && oAuth2AccessToken.getLockCount() >0 && oAuth2AccessToken.getLockCount()< isLockCount) {
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.WRONG_PASSWORD1 + oAuth2AccessToken.getLockCount() + OAuthConstant.WRONG_PASSWORD2, token);
		}else if ( token == null && oAuth2AccessToken.getLockCount() >= isLockCount) {
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.ACCOUNT_LOCKED, token);
		}	else {
			Map<String, Object> map = token.getAdditionalInformation();
			if(null != map && null != map.get(OAuthConstant.IS_ALREADY_LOGGING) ) {
				boolean isLogging = (boolean) map.get(OAuthConstant.IS_ALREADY_LOGGING);
				if (isLogging) {
					return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.ALREADY_LOGGING, null);
				} else {
					HttpSession session = req.getSession();
					session.setAttribute("token", token);
					oauthService.resetLockCountAndFlag(edpMsUser);
					return ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.AUTHENTICATION_SUCCESS, token);
				}
			}
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.USERNAME_OR_PASWD_INCORRECT, token);
		}
	}

	/**
	 * TO get new token using refesh token.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException
	 */
	@PostMapping(value = URLConstant.OAUTH_REFESH_TOKEN)
	@Trace
	public ResponseEntity<ApiResponse> postRefreshToken(HttpServletRequest request) throws CustomException {
		if (request.getParameter(OAuthConstant.REFRESH_TOKEN) == null)
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.AUTHENTICATION_FAIL, null);
		else {
			OAuth2AccessToken token = oauthService
					.getNewTokenFromOldRefeshToken(request.getParameter(OAuthConstant.REFRESH_TOKEN));
			return token != null ? ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.AUTHENTICATION_SUCCESS, token)
					: ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.INVALID_REFESH_TOKEN, token);
		}
	}

	/**
	 * For Get User info Which Are present in Token.
	 *
	 * @return the response entity
	 */
	@PostMapping(value = URLConstant.OAUTH_USER_INFO)
	@Trace
	public ResponseEntity<ApiResponse> postOAuthUserInfo() {
		Map<String, Object> userInfo = oauthService.getOAuthUserInfo();
		return ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OAUTH_DATA_FETCH_SUCESS, userInfo);
	}

	/**
	 * For get user id of current user.
	 *
	 * @return the response entity
	 */
	@PostMapping(value = URLConstant.OAUTH_USER_ID)
	@Trace
	public ResponseEntity<ApiResponse> postOAuthUserId() {
		Long userId = OAuthUtility.getCurrentUserUserId();
		return userId != null ? ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OAUTH_DATA_FETCH_SUCESS, userId)
				: ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, OAuthConstant.AUTHENTICATION_FAIL, userId);
	}

	/**
	 * For Revoke User Token.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the response entity
	 */
	@PostMapping(value = URLConstant.OAUTH_REVOKE_TOKEN)
	@Trace
	public ResponseEntity<ApiResponse> logout(HttpServletRequest request, HttpServletResponse response) {
		return oauthService.logoutUser()
				? ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OAUTH_TOKEN_REVOKE, null)
				: ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, OAuthConstant.AUTHENTICATION_FAIL, null);
	}

	/**
	 * Gets the current user session.
	 *
	 * @return the current user session
	 */
	@PostMapping(value = URLConstant.OAUTH_CURRENT_USER_SESSION)
	@Trace
	public ResponseEntity<ApiResponse> getCurrentUserSession() {
		OAuthMsUserSessionsEntity userSession = oauthMsUserSessionService.getOAuthCurrentUserSession();
		return userSession != null
				? ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OAUTH_DATA_FETCH_SUCESS,
						oauthMsUserSessionsConverter.toDTO(userSession))
				: ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, OAuthConstant.AUTHENTICATION_FAIL, null);
	}
	/**
	 * Gets the o auth token for change post.
	 *
	 * @param dto the request
	 * @return the o auth token for change post
	 * @throws CustomException
	 * @throws NumberFormatException
	 */
	@PostMapping(value = URLConstant.OAUTH_CHANGE_USER_POST)
	@Trace
	public ResponseEntity<ApiResponse> getOAuthTokenForChangePost(@RequestBody IdDto dto) throws CustomException {
		if (dto.getId() == null)
			return ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.AUTHENTICATION_FAIL, null);
		else {
			OAuth2AccessToken token = oauthService.getOauthTokenForPostChange(dto.getId());
			return token != null ? ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.SWITCH_ROLE_SUCCESSFULLY, token)
					: ResponseUtil.getResponse(HttpStatus.UNAUTHORIZED, OAuthConstant.POST_INVALID, token);
		}
	}

	/**
	 * Gets the change pass.
	 *
	 * @param changePassword the change password
	 * @return the change pass
	 */
	@PostMapping(value = URLConstant.OAUTH_CHANGE_PASS)
	public ResponseEntity<ApiResponse> getChangePass(@Valid @RequestBody EDPChangePass changePassword) {
		if (oauthService.checkCurrentUserPassword(changePassword.getCurrentPassword())) {
			String newPasswordCheck = changePassword.getNewPassword();
			String confirmPassword = changePassword.getConfirmPassword();
			if (newPasswordCheck.equals(changePassword.getCurrentPassword())) {
				return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.NEW_PASS_OLD_PASS_NOT_SAME,
						Boolean.FALSE);
			}
			if (newPasswordCheck.equals(confirmPassword)) {
				boolean isAlreadyUsed = oauthService.isPasswordAlreadyUsed(newPasswordCheck,
						OAuthUtility.getCurrentUserUserId());
				if (isAlreadyUsed)
					return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.PASS_ALREADY_USED,
							Boolean.FALSE);
				boolean bvalue = oauthService.changePassword(changePassword);
				return bvalue?ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.PASS_CHANGE_SUCCESS, bvalue):
					ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.WRONG_OLD_PASS, bvalue);
			}
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.PASS_NOT_SAME, Boolean.FALSE);
		}
		return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.WRONG_OLD_PASS, null);
	}

	/**
	 * to create new access token.
	 *
	 * @param msUserDto the ms user dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@PostMapping(value = URLConstant.OAUTH_FORGOT_PASS)
	@Trace
	public ResponseEntity<ApiResponse> forgotPassword(@RequestBody EDPMsUserDto msUserDto) throws CustomException {
		EDPMsUserEntity userEntity = edpMsUserService.findByUserCode(Long.parseLong(msUserDto.getUserCode()));
		if (userEntity!=null) {
			Map<String, String> sendOtpToUser = null;
			if(userEntity.getFirstLogin()==1 || userEntity.getIsPassReset()==1){
				sendOtpToUser = oauthService.sendOtpToUser(msUserDto.getUserCode());
			}else{
				Optional<EDPMsForgotPassCaptchaEntity> opCaptcha = oauthService.validateCaptcha(msUserDto.getCaptchaId(),msUserDto.getCaptcha());
				if(opCaptcha.isPresent()){
					sendOtpToUser = oauthService.sendOtpToUser(msUserDto.getUserCode());
					oauthService.deleteCaptchaById(opCaptcha.get().getCaptchaId());
					oauthService.resetLockCountAndFlag(userEntity);
				}else{
					return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.INVALID_CAPTCHA);
				}
			}
			if (sendOtpToUser == null) {
				return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.INVALID_USER_CODE, null);
			} else {
				return ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OTP_SENT_SUCCESSFULLY, sendOtpToUser);
			}
		} else {
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.USER_CODE_NOT_FOUND, null);
		}
	}

	/**
	 * to create new access token.
	 *
	 * @param edpMsUserTokenDto the edp ms user token dto
	 * @return the response entity
	 */
	@PostMapping(value = URLConstant.OAUTH_VERIFY_PASS_TOKEN)
	@Trace
	public ResponseEntity<ApiResponse> verifyPassToken(@RequestBody final EDPMsUserTokenDto edpMsUserTokenDto) {
		boolean status = oauthService.verifyPassToken(edpMsUserTokenDto);
		if (status) {
			return ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.OTP_VALID, status);
		} else {
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.OTP_IN_VALID, status);
		}

	}

	/**
	 * Gets the new pass.
	 *
	 * @param changePassword the change password
	 * @return the new pass
	 * @throws CustomException the custom exception
	 */
	@PostMapping(value = URLConstant.OAUTH_NEW_PASS)
	public ResponseEntity<ApiResponse> getNewPass(@Valid @RequestBody EDPChangePass changePassword)
			throws CustomException {
		String newPasswordCheck = changePassword.getNewPassword();
		String confirmPassword = changePassword.getConfirmPassword();
		if (!newPasswordCheck.equals(confirmPassword)) {
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.PASS_NOT_SAME, Boolean.FALSE);
		}
		Long userId = Long.parseLong(encryptDecryptUtil.decrypt(changePassword.getUserId()));
		Optional<EDPMsUserToken> validOtpToken = oauthService.isValidOTPForUserId(userId);
		if(!validOtpToken.isPresent()){
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.OTP_IN_VALID, Boolean.FALSE);
		}
		boolean isAlreadyUsed = oauthService.isPasswordAlreadyUsed(newPasswordCheck, userId);
		if (isAlreadyUsed) {
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.PASS_ALREADY_USED, Boolean.FALSE);
		}
		boolean vBool = oauthService.changeNewPassword(changePassword, userId);
		if (vBool) {
			oauthService.resetIsValid(validOtpToken.get());
			return ResponseUtil.getResponse(HttpStatus.OK, OAuthConstant.PASS_CHANGE_SUCCESS, vBool);
		} else {
			return ResponseUtil.getResponse(HttpStatus.NOT_ACCEPTABLE, OAuthConstant.ERRORS, Boolean.FALSE);
		}
	}

    @GetMapping(value = URLConstant.OAUTH_CAPTCHA)
    public ResponseEntity<ApiResponse> getCaptcha(HttpServletRequest request) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.CREATED,"Captcha generated",oauthService.generateCaptcha());
    }

}
