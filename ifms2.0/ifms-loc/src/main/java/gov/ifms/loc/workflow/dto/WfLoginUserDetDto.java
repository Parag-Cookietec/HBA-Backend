package gov.ifms.loc.workflow.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import gov.ifms.edp.dto.EDPMsBranchDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;

/**
 * The Class WfRequestDto
 */
public class WfLoginUserDetDto{

	/** The user id. */
	private long userId;

	/** The post id. */
	private long postId;

	/** The pou id. */
	private long pouId;

	/** The office dto. */
	private EDPMsOfficeDto officeDto;

	/** The branches. */
	private List<EDPMsBranchDto> branches;

	/** The wf role ids. */
	private Set<Long> wfRoleIds;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the office dto.
	 *
	 * @return the office dto
	 */
	public EDPMsOfficeDto getOfficeDto() {
		return officeDto;
	}

	/**
	 * Sets the office dto.
	 *
	 * @param officeDto the new office dto
	 */
	public void setOfficeDto(EDPMsOfficeDto officeDto) {
		this.officeDto = officeDto;
	}

	/**
	 * Gets the branches.
	 *
	 * @return the branches
	 */
	public List<EDPMsBranchDto> getBranches() {
		return branches;
	}

	/**
	 * Sets the branches.
	 *
	 * @param branches the new branches
	 */
	public void setBranches(List<EDPMsBranchDto> branches) {
		this.branches = branches;
	}

	/**
	 * Gets the wf role ids.
	 *
	 * @return the wf role ids
	 */
	public Set<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the new wf role ids
	 */
	public void setWfRoleIds(Set<Long> wfRoleIds) {
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
		WfLoginUserDetDto that = (WfLoginUserDetDto) o;
		return userId == that.userId && postId == that.postId && pouId == that.pouId && Objects.equals(officeDto, that.officeDto) && Objects.equals(branches, that.branches) && Objects.equals(wfRoleIds, that.wfRoleIds);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(userId, postId, pouId, officeDto, branches, wfRoleIds);
	}
}
