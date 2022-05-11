package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EdpWorkflowRequestDto.
 */
public class EdpWorkflowRequestDto extends BaseDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The trn id. */
	private Long trnId;

	/** The user id. */
	private Object userId;

	/** The post id. */
	private Long postId;

	/** The pou id. */
	private Long pouId;

	/** The office id. */
	private Long officeId;
		
	/** The branch id. */
	private Long branchId;
	
	/** The wf role ids. */
	private List<Long> wfRoleIds;

	/**
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Object getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Object userId) {
		this.userId = userId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

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

	/**
	 * Gets the wf role ids.
	 *
	 * @return the wf role ids
	 */
	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the new wf role ids
	 */
	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
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
		result = prime * result + Objects.hash(branchId, officeId, postId, pouId, trnId, userId, wfRoleIds);
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
		if (!(obj instanceof EdpWorkflowRequestDto)) {
			return false;
		}
		EdpWorkflowRequestDto other = (EdpWorkflowRequestDto) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postId, other.postId) && Objects.equals(pouId, other.pouId)
				&& Objects.equals(trnId, other.trnId) && Objects.equals(userId, other.userId)
				&& Objects.equals(wfRoleIds, other.wfRoleIds);
	}
	
}
