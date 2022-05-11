package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPostUserOfficeDto.
 * 
 * @version 1.0
 * @created 2019/09/11 16:43:32
 *
 */
public class EDPLkPostUserOfficeDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user id. */
	private Long postUserId;

	/** The post id. */
	private Long postId;

	/** The user id. */
	private Long userId;

	/** The office id. */
	private Long officeId;

	/** The is primary post. */
	private boolean isPrimaryPost;

	/**
	 * Gets the post user id.
	 *
	 * @return the postUserId
	 */
	public Long getPostUserId() {
		return postUserId;
	}

	/**
	 * Sets the post user id.
	 *
	 * @param postUserId the postUserId to set
	 */
	public void setPostUserId(Long postUserId) {
		this.postUserId = postUserId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Checks if is primary post.
	 *
	 * @return true, if is primary post
	 */
	public boolean isPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the primary post.
	 *
	 * @param isPrimaryPost the new primary post
	 */
	public void setPrimaryPost(boolean isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(officeId, postId, postUserId, userId, isPrimaryPost);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPLkPostUserOfficeDto)) {
			return false;
		}
		EDPLkPostUserOfficeDto other = (EDPLkPostUserOfficeDto) obj;
		return Objects.equals(officeId, other.officeId) && Objects.equals(postId, other.postId)
				&& Objects.equals(postUserId, other.postUserId) && Objects.equals(userId, other.userId)
				&& Objects.equals(isPrimaryPost, other.isPrimaryPost);
	}

}
