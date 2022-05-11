package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsUserToken.
 */
@Entity
@Table(name = "MS_USER_TOKEN", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsUserToken  implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user token id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MS_USER_TOKEN_ID ")
	private Long userTokenId;

	/** The user id. */
	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity userId;

	/** The email id name guj. */
	@Column(name = "EMAIL_ID")
	private String emailId;

	/** The Phone No. */
	@Column(name = "PHONE_NO")
	private String phoneNo;

	/** The token number. */
	@Column(name = "TOKEN_NO")
	private String tokenNo;

	/** The validity period. */
	@Column(name = "VALIDITY_PERIOD")
	private Date validityPeriod;

	/** The is valid. */
	@Column(name = "IS_VALID")
	private int isValid;

	
	/** The created by. */
	@Column(name = "CREATED_BY", updatable = false)
	private long createdBy;

	/** The created date. */
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	/** The created by post. */
	@Column(name = "CREATED_BY_POST", updatable = false)
	private long createdByPost;

	/** The updated by post. */
	@Column(name = "UPDATED_BY_POST")
	private long updatedByPost;

	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;

	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private long updatedBy;

	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	
	
	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the created by post.
	 *
	 * @return the created by post
	 */
	public long getCreatedByPost() {
		return createdByPost;
	}

	/**
	 * Sets the created by post.
	 *
	 * @param createdByPost the new created by post
	 */
	public void setCreatedByPost(long createdByPost) {
		this.createdByPost = createdByPost;
	}

	/**
	 * Gets the updated by post.
	 *
	 * @return the updated by post
	 */
	public long getUpdatedByPost() {
		return updatedByPost;
	}

	/**
	 * Sets the updated by post.
	 *
	 * @param updatedByPost the new updated by post
	 */
	public void setUpdatedByPost(long updatedByPost) {
		this.updatedByPost = updatedByPost;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the active status
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the new active status
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy the new updated by
	 */
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * EDPMsUserToken Constructor.
	 */
	public EDPMsUserToken() {
		super();
	}


	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, createdBy, createdByPost, createdDate, emailId, isValid, phoneNo, tokenNo,
				updatedBy, updatedByPost, updatedDate, userId, userTokenId, validityPeriod);
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
		EDPMsUserToken other = (EDPMsUserToken) obj;
		return activeStatus == other.activeStatus && createdBy == other.createdBy
				&& createdByPost == other.createdByPost && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(emailId, other.emailId) && isValid == other.isValid
				&& Objects.equals(phoneNo, other.phoneNo) && Objects.equals(tokenNo, other.tokenNo)
				&& updatedBy == other.updatedBy && updatedByPost == other.updatedByPost
				&& Objects.equals(updatedDate, other.updatedDate) && Objects.equals(userId, other.userId)
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
	public EDPMsUserEntity getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(EDPMsUserEntity userId) {
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

}
