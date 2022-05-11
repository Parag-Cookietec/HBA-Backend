package gov.ifms.dmo.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import gov.ifms.common.base.DTO;

/**
 * The Class BaseDto.
 */
public class BaseDto extends DTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/** The created by. */
	private long createdBy;

	/** The created date. */
	private Date createdDate;

	/** The created by post. */
	private long createdByPost;

	/** The updated by post. */
	private long updatedByPost;

	/** The active status. */
	private int activeStatus = 1;

	/** The updated by. */
	private long updatedBy;

	/** The updated date. */
	private Date updatedDate;
	
	/** The current clicked Menu. */
	private Long curMenuId;
	

	

	public Long getCurMenuId() {
		return curMenuId;
	}

	public void setCurMenuId(Long curMenuId) {
		this.curMenuId = curMenuId;
	}

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
	 * Instantiates a new base dto.
	 */
	public BaseDto() {
		super();
	}
	
	/**
	 * Instantiates a new base dto.
	 *
	 * @param createdBy the created by
	 * @param createdDate the created date
	 * @param createdByPost the created by post
	 * @param updatedByPost the updated by post
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 */
	public BaseDto(long createdBy, Date createdDate, long createdByPost,
			long updatedByPost, int activeStatus, long updatedBy, Date updatedDate) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.createdByPost = createdByPost;
		this.updatedByPost = updatedByPost;
		this.activeStatus = activeStatus;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, createdBy, createdByPost, createdDate, updatedBy, updatedByPost, updatedDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDto other = (BaseDto) obj;
		return activeStatus == other.activeStatus && createdBy == other.createdBy
				&& createdByPost == other.createdByPost && Objects.equals(createdDate, other.createdDate)
				&& updatedBy == other.updatedBy && updatedByPost == other.updatedByPost
				&& Objects.equals(updatedDate, other.updatedDate);
	}

}
