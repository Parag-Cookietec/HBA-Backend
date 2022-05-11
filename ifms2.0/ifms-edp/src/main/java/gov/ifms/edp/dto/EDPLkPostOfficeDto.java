package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPostOfficeDto.
 * 
 * @version 1.0
 * @created 2019/12/26 11:14:39
 *
 */
public class EDPLkPostOfficeDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk post office id. */
	private Long lkPostOfficeId;

	/** The post id. */
	private Long postId;

	/** The office id. */
	private Long officeId;

	/** The is vacant post. */
	private Long isVacantPost;

	/**
	 * EDPLkPostOfficeDto Constructor.
	 */
	public EDPLkPostOfficeDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkPostOfficeId, postId, officeId, isVacantPost);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPLkPostOfficeDto)) {
			return false;
		}

		EDPLkPostOfficeDto other = (EDPLkPostOfficeDto) obj;

		return Objects.equals(lkPostOfficeId, other.lkPostOfficeId) && Objects.equals(postId, other.postId)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(isVacantPost, other.isVacantPost);
	}

	/**
	 * getter setter.
	 *
	 * @return the lk post office id
	 */

	/**
	 * @return the lkPostOfficeId
	 */
	public Long getLkPostOfficeId() {
		return lkPostOfficeId;
	}

	/**
	 * Sets the lk post office id.
	 *
	 * @param lkPostOfficeId the lkPostOfficeId to set
	 */
	public void setLkPostOfficeId(Long lkPostOfficeId) {
		this.lkPostOfficeId = lkPostOfficeId;
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
	 * Gets the checks if is vacant post.
	 *
	 * @return the isVacantPost
	 */
	public Long getIsVacantPost() {
		return isVacantPost;
	}

	/**
	 * Sets the checks if is vacant post.
	 *
	 * @param isVacantPost the isVacantPost to set
	 */
	public void setIsVacantPost(Long isVacantPost) {
		this.isVacantPost = isVacantPost;
	}

}
