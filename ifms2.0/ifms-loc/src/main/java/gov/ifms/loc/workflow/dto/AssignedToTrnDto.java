package gov.ifms.loc.workflow.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class AssignedToTrnDto.
 */
@NativeQueryResultEntity
public class AssignedToTrnDto implements Serializable{

	private static final long serialVersionUID = 1L;

	/** The assign to wf role id. */
	@NativeQueryResultColumn(index = 0)
	private long assignToWfRoleId;

	/** The assign to action level. */
	@NativeQueryResultColumn(index = 1)
	private int assignToActionLevel;
	
	/** The wf id. */
	@NativeQueryResultColumn(index = 2)
	private long wfId;
	
	/** The assign to office id. */
	@NativeQueryResultColumn(index = 3)
	private long assignToOfficeId;

	/** The assign to branch id. */
	@NativeQueryResultColumn(index = 4)
	private Long assignToBranchId;

	/** The assign to group id. */
	@NativeQueryResultColumn(index = 5)
	private long assignToGroupId;

	/** The assign to pou id. */
	@NativeQueryResultColumn(index = 6)
	private long assignToPouId;

	public Long getAssignToBranchId() {
		return assignToBranchId;
	}

	public void setAssignToBranchId(long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	/**
	 * @return the assignToWfRoleId
	 */
	public long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * @return the assignToActionLevel
	 */
	public int getAssignToActionLevel() {
		return assignToActionLevel;
	}

	/**
	 * @param assignToActionLevel the assignToActionLevel to set
	 */
	public void setAssignToActionLevel(int assignToActionLevel) {
		this.assignToActionLevel = assignToActionLevel;
	}

	/**
	 * Gets the assign to office id.
	 *
	 * @return the assign to office id
	 */
	public long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * Sets the assign to office id.
	 *
	 * @param assignToOfficeId the new assign to office id
	 */
	public void setAssignToOfficeId(long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	/**
	 * Gets the assign to group id.
	 *
	 * @return the assign to group id
	 */
	public long getAssignToGroupId() {
		return assignToGroupId;
	}

	/**
	 * Sets the assign to group id.
	 *
	 * @param assignToGroupId the new assign to group id
	 */
	public void setAssignToGroupId(long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	/**
	 * Gets the assign to pou id.
	 *
	 * @return the assign to pou id
	 */
	public long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * Sets the assign to pou id.
	 *
	 * @param assignToPouId the new assign to pou id
	 */
	public void setAssignToPouId(long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * Instantiates a new assigned to trn dto.
	 *
	 * @param assignToWfRoleId the assign to wf role id
	 * @param assignToActionLevel the assign to action level
	 */
	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel) {
		super();
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
	}

	/**
	 * Instantiates a new assigned to trn dto.
	 *
	 * @param assignToWfRoleId the assign to wf role id
	 * @param assignToActionLevel the assign to action level
	 * @param assignToBranchId the assign to branch id
	 */
	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel, long assignToBranchId) {
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
		this.assignToBranchId = assignToBranchId;
	}

	/**
	 * Instantiates a new assigned to trn dto.
	 *
	 * @param assignToWfRoleId the assign to wf role id
	 * @param assignToActionLevel the assign to action level
	 * @param assignToBranchId the assign to branch id
	 * @param assignToPouId the assign to pou id
	 */
	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel, long assignToBranchId, long assignToPouId) {
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
		this.assignToBranchId = assignToBranchId;
		this.assignToPouId = assignToPouId;
	}

	/**
	 * Instantiates a new assigned to trn dto.
	 */
	public AssignedToTrnDto() {
		super();
	}

	/**
	 * @return the wfId
	 */
	public long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(long wfId) {
		this.wfId = wfId;
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
		AssignedToTrnDto that = (AssignedToTrnDto) o;
		return assignToWfRoleId == that.assignToWfRoleId &&
				assignToActionLevel == that.assignToActionLevel &&
				wfId == that.wfId &&
				assignToOfficeId == that.assignToOfficeId &&
				assignToBranchId == that.assignToBranchId &&
				assignToGroupId == that.assignToGroupId &&
				assignToPouId == that.assignToPouId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(assignToWfRoleId, assignToActionLevel, wfId, assignToOfficeId, assignToBranchId, assignToGroupId, assignToPouId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", AssignedToTrnDto.class.getSimpleName() + "[", "]")
				.add("assignToWfRoleId=" + assignToWfRoleId)
				.add("assignToActionLevel=" + assignToActionLevel)
				.add("wfId=" + wfId)
				.add("assignToOfficeId=" + assignToOfficeId)
				.add("assignToBranchId=" + assignToBranchId)
				.add("assignToGroupId=" + assignToGroupId)
				.add("assignToPouId=" + assignToPouId)
				.toString();
	}
}
