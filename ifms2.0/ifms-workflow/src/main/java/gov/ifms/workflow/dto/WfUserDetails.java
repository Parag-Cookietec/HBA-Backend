package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class WfUserDetails implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long wfRoleId;

    private transient Object userId;

    private Long postId;

    private Long pouId;

    private Long officeId;

    private Long branchId;
    
    private Long groupId;

    private Integer level;

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the userId
	 */
	public Object getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Object userId) {
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
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfUserDetails that = (WfUserDetails) o;
		return Objects.equals(wfRoleId, that.wfRoleId) &&
				Objects.equals(userId, that.userId) &&
				Objects.equals(postId, that.postId) &&
				Objects.equals(pouId, that.pouId) &&
				Objects.equals(officeId, that.officeId) &&
				Objects.equals(branchId, that.branchId) &&
				Objects.equals(groupId, that.groupId) &&
				Objects.equals(level, that.level);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wfRoleId, userId, postId, pouId, officeId, branchId, groupId, level);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfUserDetails.class.getSimpleName() + "[", "]")
				.add("wfRoleId=" + wfRoleId)
				.add("userId=" + userId)
				.add("postId=" + postId)
				.add("pouId=" + pouId)
				.add("officeId=" + officeId)
				.add("branchId=" + branchId)
				.add("groupId=" + groupId)
				.add("level=" + level)
				.toString();
	}
}
