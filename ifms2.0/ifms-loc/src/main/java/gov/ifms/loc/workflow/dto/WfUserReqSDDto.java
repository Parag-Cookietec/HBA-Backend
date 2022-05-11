package gov.ifms.loc.workflow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class WfUserDto
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WfUserReqSDDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The trn id. */
	private long trnId;

	/** The menu id. */
	private long menuId;

	/** The user id. */
	private transient Object userId;

	/** The post id. */
	private long postId;

	/** The pou id. */
	private long pouId;

	/** The office id. */
	private long officeId;
		
	/** The branch id. */
	private Long branchId;
	
	/** The wf role ids. */
	private List<Long> wfRoleIds;

	/**
	 * @return the trnId
	 */
	public long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * @return the pouId
	 */
	public long getPouId() {
		return pouId;
	}

	/**
	 * @param pouId the pouId to set
	 */
	public void setPouId(long pouId) {
		this.pouId = pouId;
	}

	/**
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
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

	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfUserReqSDDto that = (WfUserReqSDDto) o;
		return trnId == that.trnId &&
				menuId == that.menuId &&
				postId == that.postId &&
				pouId == that.pouId &&
				officeId == that.officeId &&
				Objects.equals(userId, that.userId) &&
				Objects.equals(branchId, that.branchId) &&
				Objects.equals(wfRoleIds, that.wfRoleIds);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(trnId, menuId, userId, postId, pouId, officeId, branchId, wfRoleIds);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", WfUserReqSDDto.class.getSimpleName() + "[", "]")
				.add("trnId=" + trnId)
				.add("menuId=" + menuId)
				.add("userId=" + userId)
				.add("postId=" + postId)
				.add("pouId=" + pouId)
				.add("officeId=" + officeId)
				.add("branchId=" + branchId)
				.add("wfRoleIds=" + wfRoleIds)
				.toString();
	}
}
