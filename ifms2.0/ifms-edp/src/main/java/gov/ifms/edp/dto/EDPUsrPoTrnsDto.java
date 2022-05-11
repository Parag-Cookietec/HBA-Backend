package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPUserPoTrnsDto.
 * 
 * @version 1.0
 * @created 2020/01/02 14:26:15
 *
 */
public class EDPUsrPoTrnsDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post office id. */
	private Long postOfficeId;

	/** The trn no. */
	private String trnNo;

	/** The from pou id. */
	private Long fromUserId;

	/** The to pou id. */
	private Long toUserId;

	/** The will be primary. */
	private Long willBePrimary;

	/** The wf role id. */
	private Long wfRoleId;

	/** The menu code. */
	private String menuCode;

	/** The edp user post dto. */
	private EDPUserPostDto edpUserPostDto;

	/** The is primary post. */
	private Long isPrimaryPost;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/** The edp usr po trns header id. */
	private Long edpUsrPoTrnsHeaderId;

	/**
	 * Gets the post office id.
	 *
	 * @return the postOfficeId
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the postOfficeId to set
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
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
	 * Gets the from user id.
	 *
	 * @return the fromUserId
	 */
	public Long getFromUserId() {
		return fromUserId;
	}

	/**
	 * Sets the from user id.
	 *
	 * @param fromUserId the fromUserId to set
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 * Gets the to user id.
	 *
	 * @return the toUserId
	 */
	public Long getToUserId() {
		return toUserId;
	}

	/**
	 * Sets the to user id.
	 *
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * Gets the will be primary.
	 *
	 * @return the willBePrimary
	 */
	public Long getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * Sets the will be primary.
	 *
	 * @param willBePrimary the willBePrimary to set
	 */
	public void setWillBePrimary(Long willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the menu code.
	 *
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * Sets the menu code.
	 *
	 * @param menuCode the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * Gets the edp user post dto.
	 *
	 * @return the edpUserPostDto
	 */
	public EDPUserPostDto getEdpUserPostDto() {
		return edpUserPostDto;
	}

	/**
	 * Sets the edp user post dto.
	 *
	 * @param edpUserPostDto the edpUserPostDto to set
	 */
	public void setEdpUserPostDto(EDPUserPostDto edpUserPostDto) {
		this.edpUserPostDto = edpUserPostDto;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUserPostDto, edpUsrPoTrnsHeaderId, edpUsrPoTrnsId, fromUserId, isPrimaryPost, menuCode,
				postOfficeId, toUserId, trnNo, wfRoleId, willBePrimary);
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
		if (!(obj instanceof EDPUsrPoTrnsDto)) {
			return false;
		}
		EDPUsrPoTrnsDto other = (EDPUsrPoTrnsDto) obj;
		return Objects.equals(edpUserPostDto, other.edpUserPostDto)
				&& Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId) && Objects.equals(fromUserId, other.fromUserId)
				&& Objects.equals(isPrimaryPost, other.isPrimaryPost) && Objects.equals(menuCode, other.menuCode)
				&& Objects.equals(postOfficeId, other.postOfficeId) && Objects.equals(toUserId, other.toUserId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(wfRoleId, other.wfRoleId)
				&& Objects.equals(willBePrimary, other.willBePrimary);
	}

	/**
	 * Gets the checks if is primary post.
	 *
	 * @return the isPrimaryPost
	 */
	public Long getIsPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the checks if is primary post.
	 *
	 * @param isPrimaryPost the isPrimaryPost to set
	 */
	public void setIsPrimaryPost(Long isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

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
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edpUsrPoTrnsHeaderId
	 */
	public Long getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edpUsrPoTrnsHeaderId to set
	 */
	public void setEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
	}

}
