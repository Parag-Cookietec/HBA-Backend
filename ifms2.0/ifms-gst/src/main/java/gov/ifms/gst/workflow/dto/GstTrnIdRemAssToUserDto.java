package gov.ifms.gst.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class GstTrnIdRemAssToUserDto.
 */
public class GstTrnIdRemAssToUserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5735832725261271754L;

	/** The trn id. */
	private long trnId;

	/** The pou id. */
	private Long pouId;

	/** The office id. */
	private Long officeId;

	/** The branch id. */
	private Long branchId;

	/** The remarks. */
	private String remarks;

	/** The postId. */
	private Long postId;

	/** The userId. */
	private String userId;

	/** The wfRoleId. */
	private Long wfRoleId;

	/** The level. */
	private Long level;

	/**
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(long trnId) {
		this.trnId = trnId;
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
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchId, level, officeId, postId, pouId, remarks, trnId, userId, wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GstTrnIdRemAssToUserDto other = (GstTrnIdRemAssToUserDto) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(level, other.level)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(postId, other.postId)
				&& Objects.equals(pouId, other.pouId) && Objects.equals(remarks, other.remarks) && trnId == other.trnId
				&& Objects.equals(userId, other.userId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	@Override
	public String toString() {
		return "GstTrnIdRemAssToUserDto [trnId=" + trnId + ", pouId=" + pouId + ", officeId=" + officeId + ", branchId="
				+ branchId + ", remarks=" + remarks + ", postId=" + postId + ", userId=" + userId + ", wfRoleId="
				+ wfRoleId + ", level=" + level + "]";
	}

}
