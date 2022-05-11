package gov.ifms.loc.workflow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class WfActionConfigSubmitTrnResDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class WfActionConfigSubmitTrnResDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The wf id. */
	@NativeQueryResultColumn(index = 0)
	private long wfId;

	/** The trn id. */
	@NativeQueryResultColumn(index = 1)
	private long trnId;

	/** The action config id. */
	@NativeQueryResultColumn(index = 2)
	private Long actionConfigId;

	/** The wf action id. */
	@NativeQueryResultColumn(index = 3)
	private Long wfActionId;

	/** The assign to wf role id. */
	@NativeQueryResultColumn(index = 4)
	private Long assignToWfRoleId;

	/** The assign to user id. */
	@NativeQueryResultColumn(index = 5)
	private Long assignToUserId;

	/** The assign to post id. */
	@NativeQueryResultColumn(index = 6)
	private Long assignToPostId;

	/** The assign to pou id. */
	@NativeQueryResultColumn(index = 7)
	private Long assignToPouId;

	/** The assign to office id. */
	@NativeQueryResultColumn(index = 8)
	private Long assignToOfficeId;

	/** The assign to branch id. */
	@NativeQueryResultColumn(index = 9)
	private Long assignToBranchId;

	/** The assign to group id. */
	@NativeQueryResultColumn(index = 10)
	private Long assignToGroupId;

	/** The wf status. */
	@NativeQueryResultColumn(index = 11)
	private String wfStatus;

	/** The trn status. */
	@NativeQueryResultColumn(index = 12)
	private String trnStatus;

	/** The assign by wf role id. */
	@NativeQueryResultColumn(index = 13)
	private Long assignByWfRoleId;

	/** The assign by user id. */
	@NativeQueryResultColumn(index = 14)
	private Long assignByUserId;

	/** The assign by post id. */
	@NativeQueryResultColumn(index = 15)
	private Long assignByPostId;

	/** The assign by pou id. */
	@NativeQueryResultColumn(index = 16)
	private Long assignByPouId;

	/** The assign by office id. */
	@NativeQueryResultColumn(index = 17)
	private Long assignByOfficeId;

	/** The assign by branch id. */
	@NativeQueryResultColumn(index = 18)
	private Long assignByBranchId;

	/** The assign by group id. */
	@NativeQueryResultColumn(index = 19)
	private Long assignByGroupId;

	/** The remarks. */
	@NativeQueryResultColumn(index = 20)
	private String remarks;

	/** The level. */
	@NativeQueryResultColumn(index = 21)
	private String level;

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(long wfId) {
		this.wfId = wfId;
	}

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
	 * Gets the action config id.
	 *
	 * @return the action config id
	 */
	public Long getActionConfigId() {
		return actionConfigId;
	}

	/**
	 * Sets the action config id.
	 *
	 * @param actionConfigId the new action config id
	 */
	public void setActionConfigId(Long actionConfigId) {
		this.actionConfigId = actionConfigId;
	}

	/**
	 * Gets the wf action id.
	 *
	 * @return the wf action id
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * Sets the wf action id.
	 *
	 * @param wfActionId the new wf action id
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * Gets the assign to wf role id.
	 *
	 * @return the assign to wf role id
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * Sets the assign to wf role id.
	 *
	 * @param assignToWfRoleId the new assign to wf role id
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * Gets the assign to user id.
	 *
	 * @return the assign to user id
	 */
	public Long getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * Sets the assign to user id.
	 *
	 * @param assignToUserId the new assign to user id
	 */
	public void setAssignToUserId(Long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * Gets the assign to post id.
	 *
	 * @return the assign to post id
	 */
	public Long getAssignToPostId() {
		return assignToPostId;
	}

	/**
	 * Sets the assign to post id.
	 *
	 * @param assignToPostId the new assign to post id
	 */
	public void setAssignToPostId(Long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	/**
	 * Gets the assign to pou id.
	 *
	 * @return the assign to pou id
	 */
	public Long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * Sets the assign to pou id.
	 *
	 * @param assignToPouId the new assign to pou id
	 */
	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * Gets the assign to office id.
	 *
	 * @return the assign to office id
	 */
	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * Sets the assign to office id.
	 *
	 * @param assignToOfficeId the new assign to office id
	 */
	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	/**
	 * Gets the assign to branch id.
	 *
	 * @return the assign to branch id
	 */
	public Long getAssignToBranchId() {
		return assignToBranchId;
	}

	/**
	 * Sets the assign to branch id.
	 *
	 * @param assignToBranchId the new assign to branch id
	 */
	public void setAssignToBranchId(Long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	/**
	 * Gets the assign to group id.
	 *
	 * @return the assign to group id
	 */
	public Long getAssignToGroupId() {
		return assignToGroupId;
	}

	/**
	 * Sets the assign to group id.
	 *
	 * @param assignToGroupId the new assign to group id
	 */
	public void setAssignToGroupId(Long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the trn status.
	 *
	 * @return the trn status
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets the trn status.
	 *
	 * @param trnStatus the new trn status
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * Gets the assign by wf role id.
	 *
	 * @return the assign by wf role id
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * Sets the assign by wf role id.
	 *
	 * @param assignByWfRoleId the new assign by wf role id
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * Gets the assign by user id.
	 *
	 * @return the assign by user id
	 */
	public Long getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * Sets the assign by user id.
	 *
	 * @param assignByUserId the new assign by user id
	 */
	public void setAssignByUserId(Long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * Gets the assign by post id.
	 *
	 * @return the assign by post id
	 */
	public Long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * Sets the assign by post id.
	 *
	 * @param assignByPostId the new assign by post id
	 */
	public void setAssignByPostId(Long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * Gets the assign by pou id.
	 *
	 * @return the assign by pou id
	 */
	public Long getAssignByPouId() {
		return assignByPouId;
	}

	/**
	 * Sets the assign by pou id.
	 *
	 * @param assignByPouId the new assign by pou id
	 */
	public void setAssignByPouId(Long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	/**
	 * Gets the assign by office id.
	 *
	 * @return the assign by office id
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * Sets the assign by office id.
	 *
	 * @param assignByOfficeId the new assign by office id
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * Gets the assign by branch id.
	 *
	 * @return the assign by branch id
	 */
	public Long getAssignByBranchId() {
		return assignByBranchId;
	}

	/**
	 * Sets the assign by branch id.
	 *
	 * @param assignByBranchId the new assign by branch id
	 */
	public void setAssignByBranchId(Long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	/**
	 * Gets the assign by group id.
	 *
	 * @return the assign by group id
	 */
	public Long getAssignByGroupId() {
		return assignByGroupId;
	}

	/**
	 * Sets the assign by group id.
	 *
	 * @param assignByGroupId the new assign by group id
	 */
	public void setAssignByGroupId(Long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
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

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Instantiates a new wf action config submit trn res dto.
	 *
	 * @param wfId the wf id
	 * @param trnId the trn id
	 * @param actionConfigId the action config id
	 */
	public WfActionConfigSubmitTrnResDto(Long wfId, Long trnId, Long actionConfigId) {
		super();
		this.wfId = wfId;
		this.trnId = trnId;
		this.actionConfigId = actionConfigId;
	}

	/**
	 * Instantiates a new wf action config submit trn res dto.
	 */
	public WfActionConfigSubmitTrnResDto() {
		super();
	}

	/**
	 * Instantiates a new wf action config submit trn res dto.
	 *
	 * @param wfId the wf id
	 * @param trnId the trn id
	 * @param actionconfigId the actionconfig id
	 * @param wfRoleId the wf role id
	 * @param officeId the office id
	 */
	public WfActionConfigSubmitTrnResDto(Long wfId, Long trnId, long actionconfigId, Long wfRoleId, Long officeId) {
		super();
		this.wfId = wfId;
		this.trnId = trnId;
		this.actionConfigId = actionconfigId;
		this.assignByWfRoleId = wfRoleId;
		this.assignToOfficeId = officeId;

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", WfActionConfigSubmitTrnResDto.class.getSimpleName() + "[", "]")
				.add("wfId=" + wfId).add("trnId=" + trnId).add("actionConfigId=" + actionConfigId)
				.add("wfActionId=" + wfActionId).add("assignToWfRoleId=" + assignToWfRoleId)
				.add("assignToUserId=" + assignToUserId).add("assignToPostId=" + assignToPostId)
				.add("assignToPouId=" + assignToPouId).add("assignToOfficeId=" + assignToOfficeId)
				.add("assignToBranchId=" + assignToBranchId).add("assignToGroupId=" + assignToGroupId)
				.add("wfStatus='" + wfStatus + "'").add("trnStatus='" + trnStatus + "'")
				.add("assignByWfRoleId=" + assignByWfRoleId).add("assignByUserId=" + assignByUserId)
				.add("assignByPostId=" + assignByPostId).add("assignByPouId=" + assignByPouId)
				.add("assignByOfficeId=" + assignByOfficeId).add("assignByBranchId=" + assignByBranchId)
				.add("assignByGroupId=" + assignByGroupId).add("remarks='" + remarks + "'").toString();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(actionConfigId, assignByBranchId, assignByGroupId, assignByOfficeId, assignByPostId,
				assignByPouId, assignByUserId, assignByWfRoleId, assignToBranchId, assignToGroupId, assignToOfficeId,
				assignToPostId, assignToPouId, assignToUserId, assignToWfRoleId, level, remarks, trnId, trnStatus,
				wfActionId, wfId, wfStatus);
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
		if (!(obj instanceof WfActionConfigSubmitTrnResDto)) {
			return false;
		}
		WfActionConfigSubmitTrnResDto other = (WfActionConfigSubmitTrnResDto) obj;
		return Objects.equals(actionConfigId, other.actionConfigId)
				&& Objects.equals(assignByBranchId, other.assignByBranchId)
				&& Objects.equals(assignByGroupId, other.assignByGroupId)
				&& Objects.equals(assignByOfficeId, other.assignByOfficeId)
				&& Objects.equals(assignByPostId, other.assignByPostId)
				&& Objects.equals(assignByPouId, other.assignByPouId)
				&& Objects.equals(assignByUserId, other.assignByUserId)
				&& Objects.equals(assignByWfRoleId, other.assignByWfRoleId)
				&& Objects.equals(assignToBranchId, other.assignToBranchId)
				&& Objects.equals(assignToGroupId, other.assignToGroupId)
				&& Objects.equals(assignToOfficeId, other.assignToOfficeId)
				&& Objects.equals(assignToPostId, other.assignToPostId)
				&& Objects.equals(assignToPouId, other.assignToPouId)
				&& Objects.equals(assignToUserId, other.assignToUserId)
				&& Objects.equals(assignToWfRoleId, other.assignToWfRoleId) && Objects.equals(level, other.level)
				&& Objects.equals(remarks, other.remarks) && trnId == other.trnId
				&& Objects.equals(trnStatus, other.trnStatus) && Objects.equals(wfActionId, other.wfActionId)
				&& wfId == other.wfId && Objects.equals(wfStatus, other.wfStatus);
	}
}
