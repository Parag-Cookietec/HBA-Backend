package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PvuTrnEmpCrWfDto.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
public class PvuTrnEmpCrWfDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long pvuTrnEmpCrWfId;
	
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
	
	@NotNull
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
	 * @return the pvuTrnEmpCrWfId
	 */
	public Long getPvuTrnEmpCrWfId() {
		return pvuTrnEmpCrWfId;
	}

	/**
	 * @param pvuTrnEmpCrWfId the pvuTrnEmpCrWfId to set
	 */
	public void setPvuTrnEmpCrWfId(Long pvuTrnEmpCrWfId) {
		this.pvuTrnEmpCrWfId = pvuTrnEmpCrWfId;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PvuTrnEmpCrWfDto that = (PvuTrnEmpCrWfDto) o;
		return assignToActionLevel == that.assignToActionLevel &&
				assignByActionLevel == that.assignByActionLevel &&
				Objects.equals(pvuTrnEmpCrWfId, that.pvuTrnEmpCrWfId) &&
				Objects.equals(trnId, that.trnId) &&
				Objects.equals(currentWorkflowId, that.currentWorkflowId) &&
				Objects.equals(wfActionId, that.wfActionId) &&
				Objects.equals(assignToWfRoleId, that.assignToWfRoleId) &&
				Objects.equals(assignToUserId, that.assignToUserId) &&
				Objects.equals(assignToPostId, that.assignToPostId) &&
				Objects.equals(assignToOfficeId, that.assignToOfficeId) &&
				Objects.equals(trnStatus, that.trnStatus) &&
				Objects.equals(wfStatus, that.wfStatus) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(assignByWfRoleId, that.assignByWfRoleId) &&
				Objects.equals(assignByPostId, that.assignByPostId) &&
				Objects.equals(assignByUserId, that.assignByUserId) &&
				Objects.equals(assignByOfficeId, that.assignByOfficeId) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(wfAttachmentIds, that.wfAttachmentIds) &&
				Objects.equals(eventId, that.eventId) &&
				Objects.equals(assignByPOUId, that.assignByPOUId) &&
				Objects.equals(assignToPOUId, that.assignToPOUId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pvuTrnEmpCrWfId, trnId, currentWorkflowId, wfActionId, assignToActionLevel, assignToWfRoleId, assignToUserId, assignToPostId, assignToOfficeId, trnStatus, wfStatus, remarks, assignByActionLevel, assignByWfRoleId, assignByPostId, assignByUserId, assignByOfficeId, menuId, wfAttachmentIds, eventId, assignByPOUId, assignToPOUId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PvuTrnEmpCrWfDto.class.getSimpleName() + "[", "]")
				.add("pvuTrnEmpCrWfId=" + pvuTrnEmpCrWfId)
				.add("trnId=" + trnId)
				.add("currentWorkflowId=" + currentWorkflowId)
				.add("wfActionId=" + wfActionId)
				.add("assignToActionLevel=" + assignToActionLevel)
				.add("assignToWfRoleId=" + assignToWfRoleId)
				.add("assignToUserId=" + assignToUserId)
				.add("assignToPostId=" + assignToPostId)
				.add("assignToOfficeId=" + assignToOfficeId)
				.add("trnStatus='" + trnStatus + "'")
				.add("wfStatus='" + wfStatus + "'")
				.add("remarks='" + remarks + "'")
				.add("assignByActionLevel=" + assignByActionLevel)
				.add("assignByWfRoleId=" + assignByWfRoleId)
				.add("assignByPostId=" + assignByPostId)
				.add("assignByUserId='" + assignByUserId + "'")
				.add("assignByOfficeId=" + assignByOfficeId)
				.add("menuId=" + menuId)
				.add("wfAttachmentIds=" + wfAttachmentIds)
				.add("eventId=" + eventId)
				.add("assignByPOUId=" + assignByPOUId)
				.add("assignToPOUId=" + assignToPOUId)
				.toString();
	}
}
