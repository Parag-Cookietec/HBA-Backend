package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsUserPassHistDto.
 */
public class EDPMsUserPassHistDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user itr id. */
	private long userItrId;

	/** The user id. */
	private long userId;

	/** The password. */
	private String password;

	/** The browser. */
	private String browser;
	
	/** The ip address. */
	private String ipAddress;
	

	/**
	 * Gets the ip address.
	 *
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Sets the browser.
	 *
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * Gets the user itr id.
	 *
	 * @return the userItrId
	 */
	public long getUserItrId() {
		return userItrId;
	}

	/**
	 * Sets the user itr id.
	 *
	 * @param userItrId the userItrId to set
	 */
	public void setUserItrId(long userItrId) {
		this.userItrId = userItrId;
	}

	

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(browser, password, userId, userItrId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPMsUserPassHistDto)) {
			return false;
		}
		EDPMsUserPassHistDto other = (EDPMsUserPassHistDto) obj;
		return browser == other.browser && Objects.equals(password, other.password) && Objects.equals(userId, other.userId)
				&& userItrId == other.userItrId;
	}

}
