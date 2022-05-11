package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPEmployeePostView.
 */
public class EDPEmployeePostView  implements Serializable{

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post office user id. */
	private Long postOfficeUserId;

	/** The display name. */
	private String displayName;


	/**
	 * Gets the post office user id.
	 *
	 * @return the post office user id
	 */
	public Long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the new post office user id
	 */
	public void setPostOfficeUserId(Long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postOfficeUserId, displayName);
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
		EDPEmployeePostView other = (EDPEmployeePostView) obj;
		return  Objects.equals(displayName, other.displayName) && Objects.equals(postOfficeUserId, other.postOfficeUserId) ;
	}
	
}
