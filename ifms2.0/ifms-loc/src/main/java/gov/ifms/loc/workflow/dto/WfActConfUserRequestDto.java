package gov.ifms.loc.workflow.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfRequestDto
 */
public class WfActConfUserRequestDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@NotNull
	private String userId;

	/** The post id. */
	@NotNull
	private Long postId;

	/** The office id. */
	@NotNull
	private Long officeId;
	
	/** The pou id. */
	@NotNull
	private Long pouId;
	
	/** The trn id. */
	@NotNull
	private Long trnId;
	
	/** The menu id. */
	@NotNull
	private Long menuId;
	
	/** The wf action config id. */
	@NotNull
	private Long wfActionConfigId;
			
	/** The branch id. */
	private Long branchId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the pouId
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * @param pouId the pouId to set
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the wfActionConfigId
	 */
	public Long getWfActionConfigId() {
		return wfActionConfigId;
	}

	/**
	 * @param wfActionConfigId the wfActionConfigId to set
	 */
	public void setWfActionConfigId(Long wfActionConfigId) {
		this.wfActionConfigId = wfActionConfigId;
	}

	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, menuId, officeId, postId, pouId, trnId, userId, wfActionConfigId);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfActConfUserRequestDto)) {
			return false;
		}
		WfActConfUserRequestDto other = (WfActConfUserRequestDto) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(postId, other.postId)
				&& Objects.equals(pouId, other.pouId) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(userId, other.userId) && Objects.equals(wfActionConfigId, other.wfActionConfigId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"WfActConfUserRequestDto [userId=%s, postId=%s, officeId=%s, pouId=%s, trnId=%s, menuId=%s, wfActionConfigId=%s, branchId=%s]",
				userId, postId, officeId, pouId, trnId, menuId, wfActionConfigId, branchId);
	}
	
}
