package gov.ifms.edp.oauth.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsUserEntity.
 */
@Entity
@Table(name = "MS_USER_LOCK", schema = Constant.EDP_MASTER_SCHEMA)
public class EdpMsUserLockEntity implements Serializable{
	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user lock id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_LOCK_ID")
	private Long userLockId;
	
	/** The user id. */
	@Column(name = "USER_ID")
	private long userId;

	/** The lock count. */
	@Column(name = "LOCK_COUNT")
	private Integer lockCount;
	
	/** The is Lock FLag. */
	@Column(name = "IS_LOCK")
	private Integer isLock;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private long createdBy;

	/** The created date. */
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	/** The created by post. */
	@Column(name = "CREATED_BY_POST")
	private long createdByPost;

	/** The updated by post. */
	@Column(name = "UPDATED_BY_POST")
	private long updatedByPost;

	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus ;

	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private long updatedBy;

	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	/**
	 * @return the userLockId
	 */
	public Long getUserLockId() {
		return userLockId;
	}

	/**
	 * @param userLockId the userLockId to set
	 */
	public void setUserLockId(Long userLockId) {
		this.userLockId = userLockId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the lockCount
	 */
	public Integer getLockCount() {
		return lockCount;
	}

	/**
	 * @param lockCount the lockCount to set
	 */
	public void setLockCount(Integer lockCount) {
		this.lockCount = lockCount;
	}

	/**
	 * @return the isLock
	 */
	public Integer getIsLock() {
		return isLock;
	}

	/**
	 * @param isLock the isLock to set
	 */
	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	/**
	 * @return the createdBy
	 */
	public long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdByPost
	 */
	public long getCreatedByPost() {
		return createdByPost;
	}

	/**
	 * @param createdByPost the createdByPost to set
	 */
	public void setCreatedByPost(long createdByPost) {
		this.createdByPost = createdByPost;
	}

	/**
	 * @return the updatedByPost
	 */
	public long getUpdatedByPost() {
		return updatedByPost;
	}

	/**
	 * @param updatedByPost the updatedByPost to set
	 */
	public void setUpdatedByPost(long updatedByPost) {
		this.updatedByPost = updatedByPost;
	}

	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the updatedBy
	 */
	public long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activeStatus;
		result = prime * result + (int) (createdBy ^ (createdBy >>> 32));
		result = prime * result + (int) (createdByPost ^ (createdByPost >>> 32));
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((isLock == null) ? 0 : isLock.hashCode());
		result = prime * result + ((lockCount == null) ? 0 : lockCount.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + (int) (updatedByPost ^ (updatedByPost >>> 32));
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userLockId == null) ? 0 : userLockId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EdpMsUserLockEntity other = (EdpMsUserLockEntity) obj;
		if (activeStatus != other.activeStatus) {
			return false;
		}
		if (createdBy != other.createdBy) {
			return false;
		}
		if (createdByPost != other.createdByPost) {
			return false;
		}
		if (createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!createdDate.equals(other.createdDate)) {
			return false;
		}
		if (isLock == null) {
			if (other.isLock != null) {
				return false;
			}
		} else if (!isLock.equals(other.isLock)) {
			return false;
		}
		if (lockCount == null) {
			if (other.lockCount != null) {
				return false;
			}
		} else if (!lockCount.equals(other.lockCount)) {
			return false;
		}
		if (updatedBy != other.updatedBy) {
			return false;
		}
		if (updatedByPost != other.updatedByPost) {
			return false;
		}
		if (updatedDate == null) {
			if (other.updatedDate != null) {
				return false;
			}
		} else if (!updatedDate.equals(other.updatedDate)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		if (userLockId == null) {
			if (other.userLockId != null) {
				return false;
			}
		} else if (!userLockId.equals(other.userLockId)) {
			return false;
		}
		return true;
	}



	
	
	


}
