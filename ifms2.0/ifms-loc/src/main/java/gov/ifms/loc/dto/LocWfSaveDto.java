package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class LocWfSaveDto.
 */
public class LocWfSaveDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The branch id. */
	private Long branchId;

	/** The menu id. */
	private Long menuId;

	/** The office id. */
	private Long officeId;

	/** The post id. */
	private Long postId;

	/** The pou id. */
	private Long pouId;

	/** The trn id. */
	private Long trnId;

	/** The user id. */
	private String userId;

	/** The wf role ids. */
	private List<Long> wfRoleIds;

	/**
	 * Gets the branch id.
	 *
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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
	 * Gets the pou id.
	 *
	 * @return the pouId
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the pouId to set
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the trn id.
	 *
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
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
	 * Gets the wf role ids.
	 *
	 * @return the wfRoleIds
	 */
	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the wfRoleIds to set
	 */
	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

}
