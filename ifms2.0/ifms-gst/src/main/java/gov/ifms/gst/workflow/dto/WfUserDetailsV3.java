package gov.ifms.gst.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfUserDetailsV3.
 */
public class WfUserDetailsV3 implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pou id. */
	private Long pouId;

	/** The office id. */
	private Long officeId;

	/** The branch id. */
	private Long branchId;

	/** The postId. */
	private Long postId;

	/** The userId. */
	private Long userId;

	/** The wfRoleId. */
	private Long wfRoleId;

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branch id
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the new branch id
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchId, officeId, postId, pouId, userId, wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WfUserDetailsV3 other = (WfUserDetailsV3) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postId, other.postId) && Objects.equals(pouId, other.pouId)
				&& Objects.equals(userId, other.userId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	@Override
	public String toString() {
		return "WfUserDetailsV3 [pouId=" + pouId + ", officeId=" + officeId + ", branchId=" + branchId + ", postId="
				+ postId + ", userId=" + userId + ", wfRoleId=" + wfRoleId + "]";
	}
}
