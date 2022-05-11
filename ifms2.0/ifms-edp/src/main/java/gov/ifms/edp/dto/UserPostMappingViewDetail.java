package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class UserPostMappingViewDetail.
 */
public class UserPostMappingViewDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post id. */
	private Long postId;

	/** The office id. */
	private Long officeId;

	/** The post name. */
	private String postName;

	/** The office name. */
	private String officeName;

	/** The lkpost office id. */
	private Long lkpostOfficeId;

	/** The lk post ofc user id. */
	private Long lkPostOfcUserId;

	/** The user ID. */
	private Long userID;

	/** The user name. */
	private String userName;

	/** The set post type id. */
	private Long setPostTypeId;

	/** The user from or to. */
	private String userFromOrTo;

	/** The is transferd. */
	private Long isTransferd;

	/** The trn no. */
	private String trnNo;

	/** The trn date. */
	private Date trnDate;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edpUsrPoTrnsId
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the edpUsrPoTrnsId to set
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Gets the checks if is transferd.
	 *
	 * @return the isTransferd
	 */
	public Long getIsTransferd() {
		return isTransferd;
	}

	/**
	 * Sets the checks if is transferd.
	 *
	 * @param isTransferd the isTransferd to set
	 */
	public void setIsTransferd(Long isTransferd) {
		this.isTransferd = isTransferd;
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
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the lkpost office id.
	 *
	 * @return the lkpostOfficeId
	 */
	public Long getLkpostOfficeId() {
		return lkpostOfficeId;
	}

	/**
	 * Sets the lkpost office id.
	 *
	 * @param lkpostOfficeId the lkpostOfficeId to set
	 */
	public void setLkpostOfficeId(Long lkpostOfficeId) {
		this.lkpostOfficeId = lkpostOfficeId;
	}

	/**
	 * Gets the lk post ofc user id.
	 *
	 * @return the lkPostOfcUserId
	 */
	public Long getLkPostOfcUserId() {
		return lkPostOfcUserId;
	}

	/**
	 * Sets the lk post ofc user id.
	 *
	 * @param lkPostOfcUserId the lkPostOfcUserId to set
	 */
	public void setLkPostOfcUserId(Long lkPostOfcUserId) {
		this.lkPostOfcUserId = lkPostOfcUserId;
	}

	/**
	 * Gets the user ID.
	 *
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
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
	 * Sets the sets the post type id.
	 *
	 * @param setPostTypeId the setPostTypeId to set
	 */
	public void setSetPostTypeId(Long setPostTypeId) {
		this.setPostTypeId = setPostTypeId;
	}

	/**
	 * Gets the user from or to.
	 *
	 * @return the userFromOrTo
	 */
	public String getUserFromOrTo() {
		return userFromOrTo;
	}

	/**
	 * Sets the user from or to.
	 *
	 * @param userFromOrTo the userFromOrTo to set
	 */
	public void setUserFromOrTo(String userFromOrTo) {
		this.userFromOrTo = userFromOrTo;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsId, isTransferd, lkPostOfcUserId, lkpostOfficeId, officeId, officeName, postId,
				postName, setPostTypeId, trnDate, trnNo, userFromOrTo, userID, userName);
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
		if (!(obj instanceof UserPostMappingViewDetail)) {
			return false;
		}
		UserPostMappingViewDetail other = (UserPostMappingViewDetail) obj;
		return Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId) && Objects.equals(isTransferd, other.isTransferd)
				&& Objects.equals(lkPostOfcUserId, other.lkPostOfcUserId)
				&& Objects.equals(lkpostOfficeId, other.lkpostOfficeId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(postId, other.postId)
				&& Objects.equals(postName, other.postName) && Objects.equals(setPostTypeId, other.setPostTypeId)
				&& Objects.equals(trnDate, other.trnDate) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(userFromOrTo, other.userFromOrTo) && Objects.equals(userID, other.userID)
				&& Objects.equals(userName, other.userName);
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the sets the post type id.
	 *
	 * @return the setPostTypeId
	 */
	public Long getSetPostTypeId() {
		return setPostTypeId;
	}

	/**
	 * Gets the trn date.
	 *
	 * @return the trnDate
	 */
	public Date getTrnDate() {
		return trnDate;
	}

	/**
	 * Sets the trn date.
	 *
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

}
