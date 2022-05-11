package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class EDPMsUserTokenDto.
 * 
 * @version 1.0
 * @created 2019/12/26 12:02:01
 *
 */
public class EDPMsUserTokenDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user token id. */
	private Long userTokenId;

	/** The token hash. */
	private String tokenHash;

	/** The user id. */
	private Long userId;

	/** The email id. */
	private String emailId;

	/** The phone no. */
	private String phoneNo;

	/** The token no. */
	private String tokenNo;

	/** The validity period. */
	private Date validityPeriod;

	/** The is valid. */
	private int isValid;

	/**
	 * EDPMsUserToken Constructor.
	 */
	public EDPMsUserTokenDto() {
		super();
	}

	

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(emailId, isValid, phoneNo, tokenHash, tokenNo, userId, userTokenId, validityPeriod);
	}



	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPMsUserTokenDto other = (EDPMsUserTokenDto) obj;
		return Objects.equals(emailId, other.emailId) && isValid == other.isValid
				&& Objects.equals(phoneNo, other.phoneNo) && Objects.equals(tokenHash, other.tokenHash)
				&& Objects.equals(tokenNo, other.tokenNo) && Objects.equals(userId, other.userId)
				&& Objects.equals(userTokenId, other.userTokenId)
				&& Objects.equals(validityPeriod, other.validityPeriod);
	}



	/**
	 * Gets the user token id.
	 *
	 * @return the user token id
	 */
	public Long getUserTokenId() {
		return userTokenId;
	}

	/**
	 * Sets the user token id.
	 *
	 * @param userTokenId the new user token id
	 */
	public void setUserTokenId(Long userTokenId) {
		this.userTokenId = userTokenId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the phone no.
	 *
	 * @return the phone no
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone no.
	 *
	 * @param phoneNo the new phone no
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the token no.
	 *
	 * @return the token no
	 */
	public String getTokenNo() {
		return tokenNo;
	}

	/**
	 * Sets the token no.
	 *
	 * @param tokenNo the new token no
	 */
	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * Gets the validity period.
	 *
	 * @return the validity period
	 */
	public Date getValidityPeriod() {
		return validityPeriod;
	}

	/**
	 * Sets the validity period.
	 *
	 * @param validityPeriod the new validity period
	 */
	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	/**
	 * Gets the checks if is valid.
	 *
	 * @return the checks if is valid
	 */
	public int getIsValid() {
		return isValid;
	}

	/**
	 * Sets the checks if is valid.
	 *
	 * @param isValid the new checks if is valid
	 */
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	/**
	 * Gets the token hash.
	 *
	 * @return the token hash
	 */
	public String getTokenHash() {
		return tokenHash;
	}

	/**
	 * Sets the token hash.
	 *
	 * @param tokenHash the new token hash
	 */
	public void setTokenHash(String tokenHash) {
		this.tokenHash = tokenHash;
	}

}
