package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsUserPasswordResetDisplayDto.
 */
public class EDPMsUserPasswordResetDisplayDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user code. */
	private Long userCode;
	
	/** The user name. */
	private String userName;
	
	/** The office name. */
	private String officeName;
	
	/** The post name. */
	private String postName;
	
	/** The post type. */
	private String postType;
	
	/** The user id. */
	private String userId;

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the post name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the new post name
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	

	/**
	 * Gets the post type.
	 *
	 * @return the postType
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * Sets the post type.
	 *
	 * @param postType the postType to set
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	/**
	 * Gets the user code.
	 *
	 * @return the userCode
	 */
	public Long getUserCode() {
		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the userCode to set
	 */
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(officeName, postName, postType, userCode, userId, userName);
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
		EDPMsUserPasswordResetDisplayDto other = (EDPMsUserPasswordResetDisplayDto) obj;
		return Objects.equals(officeName, other.officeName) && Objects.equals(postName, other.postName)
				&& Objects.equals(postType, other.postType) && Objects.equals(userCode, other.userCode)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName);
	}
	
}
