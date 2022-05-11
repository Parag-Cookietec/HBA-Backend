package gov.ifms.edp.oauth.entity;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OAuth2AccessTokenDto {

	private OAuth2AccessToken token ;
	private int lockCount;//count
	/**
	 * @return the token
	 */
	public OAuth2AccessToken getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(OAuth2AccessToken token) {
		this.token = token;
	}
	/**
	 * @return the lockCount
	 */
	public int getLockCount() {
		return lockCount;
	}
	/**
	 * @param lockCount the lockCount to set
	 */
	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}
	
	
	
	
}
