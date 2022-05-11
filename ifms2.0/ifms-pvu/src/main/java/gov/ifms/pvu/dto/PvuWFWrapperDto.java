package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class LkScWfUserRoleOfficeDto.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
public class PvuWFWrapperDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu trn emp cr wf id. */
	private Long pvuTrnEmpCrWfId;

	/** The trn id. */
	@NotNull
	private Long trnId;

	/** The current workflow id. */
	@NotNull
	private Long currentWorkflowId;

	/** The wf action id. */
	@NotNull
	private Long wfActionId;

	/** The assign to wf role id. */
	private Long assignToWfRoleId;

	/** The assign to user id. */
	private Long assignToUserId;

	/** The assign to post id. */
	private Long assignToPostId;

	/** The assign to office id. */
	private Long assignToOfficeId;

	/** The trn status. */
	@NotNull
	private String trnStatus;

	/** The wf status. */
	@NotNull
	private String wfStatus;

	/** The remarks. */
	@NotNull
	private String remarks;

	/** The assign by wf role id. */
	@NotNull
	private Long assignByWfRoleId;

	/** The assign by post id. */
	@NotNull
	private Long assignByPostId;

	/** The assign by user id. */
	@NotNull
	private String assignByUserId;

	/** The assign by office id. */
	@NotNull
	private Long assignByOfficeId;

	/** The menu id. */
	@NotNull
	private Long menuId;

	/** The wf attachment ids. */
	@NotNull
	private List<Long> wfAttachmentIds;

	/** The assign by POU id. */
	private Long assignByPOUId;

	/** The assign to POU id. */
	private Long assignToPOUId;

	/** The event id. */
	private Long eventId;

	/** The assign by action level. */
	private int assignByActionLevel;

	/** The assign to action level. */
	private int assignToActionLevel;

	/**
	 * Gets the pvu trn emp cr wf id.
	 *
	 * @return the pvuTrnEmpCrWfId
	 */
	public Long getPvuTrnEmpCrWfId() {
		return pvuTrnEmpCrWfId;
	}

	/**
	 * Sets the pvu trn emp cr wf id.
	 *
	 * @param pvuTrnEmpCrWfId the pvuTrnEmpCrWfId to set
	 */
	public void setPvuTrnEmpCrWfId(Long pvuTrnEmpCrWfId) {
		this.pvuTrnEmpCrWfId = pvuTrnEmpCrWfId;
	}

	/**
	 * Gets the trn id.
	 *
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the current workflow id.
	 *
	 * @return the currentWorkflowId
	 */
	public Long getCurrentWorkflowId() {
		return currentWorkflowId;
	}

	/**
	 * Sets the current workflow id.
	 *
	 * @param currentWorkflowId the currentWorkflowId to set
	 */
	public void setCurrentWorkflowId(Long currentWorkflowId) {
		this.currentWorkflowId = currentWorkflowId;
	}

	/**
	 * Gets the wf action id.
	 *
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * Sets the wf action id.
	 *
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * Gets the assign to wf role id.
	 *
	 * @return the assignToWfRoleId
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * Sets the assign to wf role id.
	 *
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * Gets the assign to user id.
	 *
	 * @return the assignToUserId
	 */
	public Long getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * Sets the assign to user id.
	 *
	 * @param assignToUserId the assignToUserId to set
	 */
	public void setAssignToUserId(Long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * Gets the assign to post id.
	 *
	 * @return the assignToPostId
	 */
	public Long getAssignToPostId() {
		return assignToPostId;
	}

	/**
	 * Sets the assign to post id.
	 *
	 * @param assignToPostId the assignToPostId to set
	 */
	public void setAssignToPostId(Long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	/**
	 * Gets the assign to office id.
	 *
	 * @return the assignToOfficeId
	 */
	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * Sets the assign to office id.
	 *
	 * @param assignToOfficeId the assignToOfficeId to set
	 */
	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	/**
	 * Gets the trn status.
	 *
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets the trn status.
	 *
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
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
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the assign by wf role id.
	 *
	 * @return the assignByWfRoleId
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * Sets the assign by wf role id.
	 *
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * Gets the assign by post id.
	 *
	 * @return the assignByPostId
	 */
	public Long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * Sets the assign by post id.
	 *
	 * @param assignByPostId the assignByPostId to set
	 */
	public void setAssignByPostId(Long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * Gets the assign by user id.
	 *
	 * @return the assignByUserId
	 */
	public String getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * Sets the assign by user id.
	 *
	 * @param assignByUserId the assignByUserId to set
	 */
	public void setAssignByUserId(String assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * Gets the assign by office id.
	 *
	 * @return the assignByOfficeId
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * Sets the assign by office id.
	 *
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the wf attachment ids.
	 *
	 * @return the wfAttachmentIds
	 */
	public List<Long> getWfAttachmentIds() {
		return wfAttachmentIds;
	}

	/**
	 * Sets the wf attachment ids.
	 *
	 * @param wfAttachmentIds the wfAttachmentIds to set
	 */
	public void setWfAttachmentIds(List<Long> wfAttachmentIds) {
		this.wfAttachmentIds = wfAttachmentIds;
	}

	/**
	 * Gets the assign by POU id.
	 *
	 * @return the assign by POU id
	 */
	public Long getAssignByPOUId() {
		return assignByPOUId;
	}

	/**
	 * Sets the assign by POU id.
	 *
	 * @param assignByPOUId the new assign by POU id
	 */
	public void setAssignByPOUId(Long assignByPOUId) {
		this.assignByPOUId = assignByPOUId;
	}

	/**
	 * Gets the assign to POU id.
	 *
	 * @return the assign to POU id
	 */
	public Long getAssignToPOUId() {
		return assignToPOUId;
	}

	/**
	 * Sets the assign to POU id.
	 *
	 * @param assignToPOUId the new assign to POU id
	 */
	public void setAssignToPOUId(Long assignToPOUId) {
		this.assignToPOUId = assignToPOUId;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the assign by action level.
	 *
	 * @return the assign by action level
	 */
	public int getAssignByActionLevel() {
		return assignByActionLevel;
	}

	/**
	 * Sets the assign by action level.
	 *
	 * @param assignByActionLevel the new assign by action level
	 */
	public void setAssignByActionLevel(int assignByActionLevel) {
		this.assignByActionLevel = assignByActionLevel;
	}

	/**
	 * Gets the assign to action level.
	 *
	 * @return the assign to action level
	 */
	public int getAssignToActionLevel() {
		return assignToActionLevel;
	}

	/**
	 * Sets the assign to action level.
	 *
	 * @param assignToActionLevel the new assign to action level
	 */
	public void setAssignToActionLevel(int assignToActionLevel) {
		this.assignToActionLevel = assignToActionLevel;
	}

	/**
	 * @return the updatedDate
	 */
	@Override
	public Date getUpdatedDate() {
		if (Utils.isEmpty(super.getUpdatedDate())) {
			return new Date();
		}
		return super.getUpdatedDate();
	}
	
	@Override
	public long getUpdatedBy() {
		return OAuthUtility.getCurrentUserUserId();
	}

	@Override
	public long getUpdatedByPost() {
		return OAuthUtility.getCurrentUserLkPOUId();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(assignByActionLevel, assignByOfficeId, assignByPOUId, assignByPostId, assignByUserId,
				assignByWfRoleId, assignToActionLevel, assignToOfficeId, assignToPOUId, assignToPostId, assignToUserId,
				assignToWfRoleId, currentWorkflowId, eventId, menuId, pvuTrnEmpCrWfId, remarks, trnId, trnStatus,
				wfActionId, wfAttachmentIds, wfStatus);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PvuWFWrapperDto other = (PvuWFWrapperDto) obj;
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
				&& Objects.equals(currentWorkflowId, other.currentWorkflowId) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(menuId, other.menuId) && Objects.equals(pvuTrnEmpCrWfId, other.pvuTrnEmpCrWfId)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(trnStatus, other.trnStatus) && Objects.equals(wfActionId, other.wfActionId)
				&& Objects.equals(wfAttachmentIds, other.wfAttachmentIds) && Objects.equals(wfStatus, other.wfStatus);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PvuWFWrapperDto [pvuTrnEmpCrWfId=%s, trnId=%s, currentWorkflowId=%s, wfActionId=%s, assignToWfRoleId=%s, assignToUserId=%s, assignToPostId=%s, assignToOfficeId=%s, trnStatus=%s, wfStatus=%s, remarks=%s, assignByWfRoleId=%s, assignByPostId=%s, assignByUserId=%s, assignByOfficeId=%s, menuId=%s, wfAttachmentIds=%s, assignByPOUId=%s, assignToPOUId=%s, eventId=%s, assignByActionLevel=%s, assignToActionLevel=%s]",
				pvuTrnEmpCrWfId, trnId, currentWorkflowId, wfActionId, assignToWfRoleId, assignToUserId, assignToPostId,
				assignToOfficeId, trnStatus, wfStatus, remarks, assignByWfRoleId, assignByPostId, assignByUserId,
				assignByOfficeId, menuId, wfAttachmentIds, assignByPOUId, assignToPOUId, eventId, assignByActionLevel,
				assignToActionLevel);
	}

}
