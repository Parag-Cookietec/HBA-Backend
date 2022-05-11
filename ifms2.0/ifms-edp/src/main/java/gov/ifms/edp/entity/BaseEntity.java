package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class BaseEntity.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

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
	 * Before create.
	 */
	@PrePersist
	private void beforeCreate() {
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		this.activeStatus = 1;
		this.createdDate = new Date();
		this.updatedDate = new Date();
		this.createdBy = OAuthUtility.getCurrentUserUserId();
		this.updatedBy = OAuthUtility.getCurrentUserUserId();
		this.createdByPost = dDPMsPostDto.getPostId();
		this.updatedByPost = OAuthUtility.getCurrentUserLkPOUId();

	}

	/**
	 * On update.
	 */
	@PreUpdate
	private void onUpdate() {
		try {
			this.updatedDate = new Date();
			this.updatedBy = OAuthUtility.getCurrentUserUserId();
			this.updatedByPost = OAuthUtility.getCurrentUserLkPOUId();
		} catch (Exception e) {
			this.updatedDate = new Date();
			this.updatedBy = 0l;
			this.updatedByPost = 0l;
		}

	}

	/**
	 * Instantiates a new base entity.
	 */
	public BaseEntity() {
		super();
	}
}
