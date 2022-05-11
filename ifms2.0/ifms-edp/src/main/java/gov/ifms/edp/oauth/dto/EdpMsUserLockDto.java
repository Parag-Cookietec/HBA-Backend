package gov.ifms.edp.oauth.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class EDPMsUserLockDto.
 */

public class EdpMsUserLockDto extends BaseEntity implements Serializable {
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user lock id. */

	private Long userLockId;

	private long userId;

	private Integer lockCount;

	private Integer isLock;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isLock == null) ? 0 : isLock.hashCode());
		result = prime * result + ((lockCount == null) ? 0 : lockCount.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userLockId == null) ? 0 : userLockId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdpMsUserLockDto other = (EdpMsUserLockDto) obj;
		if (isLock == null) {
			if (other.isLock != null)
				return false;
		} else if (!isLock.equals(other.isLock))
			return false;
		if (lockCount == null) {
			if (other.lockCount != null)
				return false;
		} else if (!lockCount.equals(other.lockCount))
			return false;
		if (userId != other.userId)
			return false;
		if (userLockId == null) {
			if (other.userLockId != null)
				return false;
		} else if (!userLockId.equals(other.userLockId))
			return false;
		return true;
	}

}
