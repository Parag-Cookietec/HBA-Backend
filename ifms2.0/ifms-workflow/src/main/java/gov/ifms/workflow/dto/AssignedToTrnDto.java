package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class AssignedToTrnDto.
 */
@NativeQueryResultEntity
public class AssignedToTrnDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private long assignToWfRoleId;

	@NativeQueryResultColumn(index = 1)
	private int assignToActionLevel;
	
	@NativeQueryResultColumn(index = 2)
	private long wfId;
	
	@NativeQueryResultColumn(index = 3)
	private long assignToOfficeId;

	@NativeQueryResultColumn(index = 4)
	private long assignToBranchId;

	@NativeQueryResultColumn(index = 5)
	private long assignToGroupId;

	@NativeQueryResultColumn(index = 6)
	private long assignToPouId;

	public long getAssignToBranchId() {
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

	public long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	public void setAssignToOfficeId(long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	public long getAssignToGroupId() {
		return assignToGroupId;
	}

	public void setAssignToGroupId(long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	public long getAssignToPouId() {
		return assignToPouId;
	}

	public void setAssignToPouId(long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel) {
		super();
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
	}

	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel, long assignToBranchId) {
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
		this.assignToBranchId = assignToBranchId;
	}

	public AssignedToTrnDto(long assignToWfRoleId, int assignToActionLevel, long assignToBranchId, long assignToPouId) {
		this.assignToWfRoleId = assignToWfRoleId;
		this.assignToActionLevel = assignToActionLevel;
		this.assignToBranchId = assignToBranchId;
		this.assignToPouId = assignToPouId;
	}

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
