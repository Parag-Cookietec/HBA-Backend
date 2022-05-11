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
 * The Class EDPMsUserPassHistEntity.
 */
@Entity
@Table(name = "MS_USER_PASS_HIST", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsUserPassHistEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_PASS_HIST_ID")
	private long userItrId;

	/** The user id. */
	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity userId;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/** The browser. */
	@Column(name = "BROWSER")
	private String browser;

	/** The ip address. */
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	
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
	 * Gets the browser.
	 *
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

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
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public EDPMsUserEntity getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(EDPMsUserEntity userId) {
		this.userId = userId;
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
		if (!(obj instanceof EDPMsUserPassHistEntity)) {
			return false;
		}
		EDPMsUserPassHistEntity other = (EDPMsUserPassHistEntity) obj;
		return browser == other.browser && Objects.equals(password, other.password) && Objects.equals(userId, other.userId)
				&& userItrId == other.userItrId;
	}


}
