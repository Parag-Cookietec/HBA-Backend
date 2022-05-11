package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class EdpTrnOffModWfDto.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
public class EdpTrnOffModWfDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	
	private Long edpTrnOffModWfId;
	
	@NotNull
	private Long edpTrnOffId;

	
	@NotNull
	private Long currentWorkflowId;

	
	@NotNull
	private Long wfActionId;

	
	private Long assignedToWfRoleId;

	private Long assignedToUserId;
	
	private Long assignedToPostId;
	
	private Long assignedToOfficeId;

	@NotNull
	private String trnStatus;

	@NotNull
	private String remarks;
	
	
	@NotNull
	private Long assignedByWfRoleId;
	
	
	@NotNull
	private Long assignedByPostId;
	
	
	@NotNull
	private Long assignedByUserId;
	
	
	@NotNull
	private Long assignedByOfficeId;
	
	
	@NotNull
	private Long menuId;
	
	
	@NotNull
	private List<Long> wfAttachmentIds;

	/**
	 * @return the edpTrnOffModWfId
	 */
	
	public Long getEdpTrnOffModWfId() {
		return edpTrnOffModWfId;
	}

	/**
	 * @param edpTrnOffModWfId the edpTrnOffModWfId to set
	 */
	
	public void setEdpTrnOffModWfId(Long edpTrnOffModWfId) {
		this.edpTrnOffModWfId = edpTrnOffModWfId;
	}

	/**
	 * @return the edpTrnOffId
	 */
	
	public Long getEdpTrnOffId() {
		return edpTrnOffId;
	}

	/**
	 * @param edpTrnOffId the edpTrnOffId to set
	 */
	
	public void setEdpTrnOffId(Long edpTrnOffId) {
		this.edpTrnOffId = edpTrnOffId;
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
	 * @return the assignedToWfRoleId
	 */
	public Long getAssignedToWfRoleId() {
		return assignedToWfRoleId;
	}

	/**
	 * @param assignedToWfRoleId the assignedToWfRoleId to set
	 */
	public void setAssignedToWfRoleId(Long assignedToWfRoleId) {
		this.assignedToWfRoleId = assignedToWfRoleId;
	}

	/**
	 * @return the assignedToUserId
	 */
	public Long getAssignedToUserId() {
		return assignedToUserId;
	}

	/**
	 * @param assignedToUserId the assignedToUserId to set
	 */
	public void setAssignedToUserId(Long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}

	/**
	 * @return the assignedToPostId
	 */
	public Long getAssignedToPostId() {
		return assignedToPostId;
	}

	/**
	 * @param assignedToPostId the assignedToPostId to set
	 */
	public void setAssignedToPostId(Long assignedToPostId) {
		this.assignedToPostId = assignedToPostId;
	}

	/**
	 * @return the assignedToOfficeId
	 */
	public Long getAssignedToOfficeId() {
		return assignedToOfficeId;
	}

	/**
	 * @param assignedToOfficeId the assignedToOfficeId to set
	 */
	public void setAssignedToOfficeId(Long assignedToOfficeId) {
		this.assignedToOfficeId = assignedToOfficeId;
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
	 * @return the assignedByWfRoleId
	 */
	
	public Long getAssignedByWfRoleId() {
		return assignedByWfRoleId;
	}

	/**
	 * @param assignedByWfRoleId the assignedByWfRoleId to set
	 */
	
	public void setAssignedByWfRoleId(Long assignedByWfRoleId) {
		this.assignedByWfRoleId = assignedByWfRoleId;
	}

	/**
	 * @return the assignedByPostId
	 */
	
	public Long getAssignedByPostId() {
		return assignedByPostId;
	}

	/**
	 * @param assignedByPostId the assignedByPostId to set
	 */
	
	public void setAssignedByPostId(Long assignedByPostId) {
		this.assignedByPostId = assignedByPostId;
	}

	/**
	 * @return the assignedByUserId
	 */
	
	public Long getAssignedByUserId() {
		return assignedByUserId;
	}

	/**
	 * @param assignedByUserId the assignedByUserId to set
	 */
	
	public void setAssignedByUserId(Long assignedByUserId) {
		this.assignedByUserId = assignedByUserId;
	}

	/**
	 * @return the assignedByOfficeId
	 */
	
	public Long getAssignedByOfficeId() {
		return assignedByOfficeId;
	}

	/**
	 * @param assignedByOfficeId the assignedByOfficeId to set
	 */
	
	public void setAssignedByOfficeId(Long assignedByOfficeId) {
		this.assignedByOfficeId = assignedByOfficeId;
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

	@Override
	public int hashCode() {
		return Objects.hash(assignedByOfficeId, assignedByPostId, assignedByUserId, assignedByWfRoleId,
				assignedToOfficeId, assignedToPostId, assignedToUserId, assignedToWfRoleId, currentWorkflowId,
	
				edpTrnOffId, edpTrnOffModWfId, menuId, remarks, trnStatus, wfActionId, wfAttachmentIds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EdpTrnOffModWfDto)) {
			return false;
		}
		EdpTrnOffModWfDto other = (EdpTrnOffModWfDto) obj;
		
		return Objects.equals(assignedByOfficeId, other.assignedByOfficeId)
				&& Objects.equals(assignedByPostId, other.assignedByPostId)
				&& Objects.equals(assignedByUserId, other.assignedByUserId)
				&& Objects.equals(assignedByWfRoleId, other.assignedByWfRoleId)
				&& Objects.equals(assignedToOfficeId, other.assignedToOfficeId)
				&& Objects.equals(assignedToPostId, other.assignedToPostId)
				&& Objects.equals(assignedToUserId, other.assignedToUserId)
				&& Objects.equals(assignedToWfRoleId, other.assignedToWfRoleId)
				&& Objects.equals(currentWorkflowId, other.currentWorkflowId)
				&& Objects.equals(edpTrnOffId, other.edpTrnOffId)
				&& Objects.equals(edpTrnOffModWfId, other.edpTrnOffModWfId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(trnStatus, other.trnStatus)
		
				&& Objects.equals(wfActionId, other.wfActionId)
				&& Objects.equals(wfAttachmentIds, other.wfAttachmentIds);
	}

	@Override
	public String toString() {
		
		return String.format(
				"EdpTrnOffModWfDto [edpTrnOffModWfId=%s, edpTrnOffId=%s, currentWorkflowId=%s, wfActionId=%s, assignedToWfRoleId=%s, assignedToUserId=%s, assignedToPostId=%s, assignedToOfficeId=%s, trnStatus=%s, remarks=%s, assignedByWfRoleId=%s, assignedByPostId=%s, assignedByUserId=%s, assignedByOfficeId=%s, menuId=%s, wfAttachmentIds=%s]",
				edpTrnOffModWfId, edpTrnOffId, currentWorkflowId, wfActionId, assignedToWfRoleId, assignedToUserId,
				assignedToPostId, assignedToOfficeId, trnStatus, remarks, assignedByWfRoleId, assignedByPostId,
				assignedByUserId, assignedByOfficeId, menuId, wfAttachmentIds);
	}
}
