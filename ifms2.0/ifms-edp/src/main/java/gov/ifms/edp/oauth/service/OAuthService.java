package gov.ifms.edp.oauth.service;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import gov.ifms.edp.dto.EDPMsForgotPassCaptchaDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPMsForgotPassCaptchaEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserToken;
import gov.ifms.edp.oauth.entity.EdpMsUserLockEntity;
import gov.ifms.edp.oauth.entity.OAuth2AccessTokenDto;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.EDPChangePass;
import gov.ifms.edp.dto.EDPMsUserTokenDto;

/**
 * The Interface OAuthService.
 */
public interface OAuthService extends UserDetailsService {

	/**
	 * Create OAuth Token.
	 *
	 * @param principal  the principal
	 * @param parameters the parameters
	 * @return the user authorization
	 * @throws CustomException
	 * @throws UnsupportedEncodingException
	 */
	OAuth2AccessTokenDto getUserAuthorization(Principal principal, Map<String, String> parameters) throws CustomException, UnsupportedEncodingException;

	/**
	 * Refesh TOken.
	 *
	 * @param refeshToken the refesh token
	 * @return the new token from old refesh token
	 * @throws CustomException
	 */
	OAuth2AccessToken getNewTokenFromOldRefeshToken(String refeshToken) throws CustomException;

	/**
	 * Get OAuth User.
	 *
	 * @return the o auth user info
	 */
	Map<String, Object> getOAuthUserInfo();

	/**
	 * Logout User.
	 *
	 * @return true, if successful
	 */
	boolean logoutUser();

	/**
	 * Gets the oauth token for post change.
	 *
	 * @param postId the post id
	 * @return the oauth token for post change
	 * @throws CustomException
	 */
	OAuth2AccessToken getOauthTokenForPostChange(long postId) throws CustomException;

	/**
	 * Change password.
	 *
	 * @param changePassword the change password
	 * @return true, if successful
	 */
	boolean changePassword(EDPChangePass changePassword);

	/**
	 * Checks if is password already used.
	 *
	 * @param newPasswordCheck the new password check
	 * @param userId the user id
	 * @return true, if is password already used
	 */
	boolean isPasswordAlreadyUsed(String newPasswordCheck ,long userId);

	/**
	 * Send otp to user.
	 *
	 * @param userCode the user code
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	Map<String, String> sendOtpToUser(String userCode) throws CustomException;

	/**
	 * Verify pass token.
	 *
	 * @param edpMsUserTokenDto the edp ms user token dto
	 * @return the boolean
	 */
	Boolean verifyPassToken(EDPMsUserTokenDto edpMsUserTokenDto);

	/**
	 * Change new password.
	 *
	 * @param changePassword the change password
	 * @param userId the user id
	 * @return true, if successful
	 * @throws CustomException
	 */
	boolean changeNewPassword(EDPChangePass changePassword,Long userId) throws CustomException;

	/**
	 * Encode password.
	 *
	 * @param pwd the pwd
	 * @return the string
	 */
	public String encodePassword(String pwd);

	/**
	 * Check current user password.
	 *
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	boolean checkCurrentUserPassword(String userPassword);

	IdNameDto getOnlyIdAndName(Long userId);

	/**
	 * @param userId
	 * @return
	 */
	Optional<EDPMsUserToken> isValidOTPForUserId(Long userId);

	void resetIsValid(EDPMsUserToken userToken);

	EDPMsForgotPassCaptchaDto generateCaptcha() throws CustomException;

	Optional<EDPMsForgotPassCaptchaEntity> validateCaptcha(long captchaId,String captcha);

	void deleteCaptchaById(long captchaId);
	
	void resetLockCountAndFlag(EDPMsUserEntity edpMsUser);

	EdpMsUserLockEntity getMsUserLockEntity(long userId);

}
