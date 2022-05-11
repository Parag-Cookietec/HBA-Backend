package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PvuTrnEmpCrWfDto.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WfConfigTrnDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long entityPrimaryKeyId;
	
	@NotNull
	private Long trnId;

	@NotNull
	private Long currentWorkflowId;

	@NotNull
	private Long wfActionId;

	private int assignToActionLevel;
	
	private Long assignToWfRoleId;

	private Long assignToUserId;

	private Long assignToPostId;

	private Long assignToOfficeId;

	@NotNull
	private String trnStatus;
	
	private String wfStatus;

	@NotNull
	private String remarks;

	private int assignByActionLevel;
	
	@NotNull
	private Long assignByWfRoleId;

	@NotNull
	private Long assignByPostId;

	@NotNull
	private String assignByUserId;

	@NotNull
	private Long assignByOfficeId;

	@NotNull
	private Long menuId;

	private List<Long> wfAttachmentIds;
	
	private Long eventId;


	private Long assignByPOUId;

	private Long assignToPOUId;
	
	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}


	/**
	 * @return the entityPrimaryKeyId
	 */
	public Long getEntityPrimaryKeyId() {
		return entityPrimaryKeyId;
	}

	/**
	 * @param entityPrimaryKeyId the entityPrimaryKeyId to set
	 */
	public void setEntityPrimaryKeyId(Long entityPrimaryKeyId) {
		this.entityPrimaryKeyId = entityPrimaryKeyId;
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
	 * @return the currentWorkflowId
	 */
	public Long getCurrentWorkflowId() {
		return currentWorkflowId;
	}

	/**
	 * @param currentWorkflowId the currentWorkflowId to set
	 */
	public void setCurrentWorkflowId(Long currentWorkflowId) {
		this.currentWorkflowId = currentWorkflowId;
	}

	/**
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the assignToWfRoleId
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * @return the assignToUserId
	 */
	public Long getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * @param assignToUserId the assignToUserId to set
	 */
	public void setAssignToUserId(Long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * @return the assignToPostId
	 */
	public Long getAssignToPostId() {
		return assignToPostId;
	}

	/**
	 * @param assignToPostId the assignToPostId to set
	 */
	public void setAssignToPostId(Long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	/**
	 * @return the assignToOfficeId
	 */
	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * @param assignToOfficeId the assignToOfficeId to set
	 */
	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the assignByWfRoleId
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * @return the assignByPostId
	 */
	public Long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * @param assignByPostId the assignByPostId to set
	 */
	public void setAssignByPostId(Long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * @return the assignByUserId
	 */
	public String getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * @param assignByUserId the assignByUserId to set
	 */
	public void setAssignByUserId(String assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * @return the assignByOfficeId
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
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
	 * @return the wfAttachmentIds
	 */
	public List<Long> getWfAttachmentIds() {
		return wfAttachmentIds;
	}

	/**
	 * @param wfAttachmentIds the wfAttachmentIds to set
	 */
	public void setWfAttachmentIds(List<Long> wfAttachmentIds) {
		this.wfAttachmentIds = wfAttachmentIds;
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
	 * @return the assignByActionLevel
	 */
	public int getAssignByActionLevel() {
		return assignByActionLevel;
	}

	/**
	 * @param assignByActionLevel the assignByActionLevel to set
	 */
	public void setAssignByActionLevel(int assignByActionLevel) {
		this.assignByActionLevel = assignByActionLevel;
	}

	public Long getAssignByPOUId() {
		return assignByPOUId;
	}

	public void setAssignByPOUId(Long assignByPOUId) {
		this.assignByPOUId = assignByPOUId;
	}

	public Long getAssignToPOUId() {
		return assignToPOUId;
	}

	public void setAssignToPOUId(Long assignToPOUId) {
		this.assignToPOUId = assignToPOUId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignByActionLevel, assignByOfficeId, assignByPOUId, assignByPostId, assignByUserId,
				assignByWfRoleId, assignToActionLevel, assignToOfficeId, assignToPOUId, assignToPostId, assignToUserId,
				assignToWfRoleId, currentWorkflowId, entityPrimaryKeyId, eventId, menuId, remarks, trnId, trnStatus,
				wfActionId, wfAttachmentIds, wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfConfigTrnDto)) {
			return false;
		}
		WfConfigTrnDto other = (WfConfigTrnDto) obj;
		return assignByActionLevel == other.assignByActionLevel
				&& Objects.equals(assignByOfficeId, other.assignByOfficeId)
				&& Objects.equals(assignByPOUId, other.assignByPOUId)
				&& Objects.equals(assignByPostId, other.assignByPostId)
				&& Objects.equals(assignByUserId, other.assignByUserId)
				&& Objects.equals(assignByWfRoleId, other.assignByWfRoleId)
				&& assignToActionLevel == other.assignToActionLevel
				&& Objects.equals(assignToOfficeId, other.assignToOfficeId)
				&& Objects.equals(assignToPOUId, other.assignToPOUId)
				&& Objects.equals(assignToPostId, other.assignToPostId)
				&& Objects.equals(assignToUserId, other.assignToUserId)
				&& Objects.equals(assignToWfRoleId, other.assignToWfRoleId)
				&& Objects.equals(currentWorkflowId, other.currentWorkflowId)
				&& Objects.equals(entityPrimaryKeyId, other.entityPrimaryKeyId)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(trnStatus, other.trnStatus) && Objects.equals(wfActionId, other.wfActionId)
				&& Objects.equals(wfAttachmentIds, other.wfAttachmentIds) && Objects.equals(wfStatus, other.wfStatus);
	}

	@Override
	public String toString() {
		return String.format(
				"WfConfigTrnDto [entityPrimaryKeyId=%s, trnId=%s, currentWorkflowId=%s, wfActionId=%s, assignToActionLevel=%s, assignToWfRoleId=%s, assignToUserId=%s, assignToPostId=%s, assignToOfficeId=%s, trnStatus=%s, wfStatus=%s, remarks=%s, assignByActionLevel=%s, assignByWfRoleId=%s, assignByPostId=%s, assignByUserId=%s, assignByOfficeId=%s, menuId=%s, wfAttachmentIds=%s, eventId=%s, assignByPOUId=%s, assignToPOUId=%s]",
				entityPrimaryKeyId, trnId, currentWorkflowId, wfActionId, assignToActionLevel, assignToWfRoleId,
				assignToUserId, assignToPostId, assignToOfficeId, trnStatus, wfStatus, remarks, assignByActionLevel,
				assignByWfRoleId, assignByPostId, assignByUserId, assignByOfficeId, menuId, wfAttachmentIds, eventId,
				assignByPOUId, assignToPOUId);
	}

}
