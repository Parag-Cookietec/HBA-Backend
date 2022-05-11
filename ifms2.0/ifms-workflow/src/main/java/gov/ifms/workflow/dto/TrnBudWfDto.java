package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class TrnBudWfDto.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
public class TrnBudWfDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private long trnBudWfId;

	private long trnBudSceHeaderId;

	private long currentWorkflowId;

	private Long assignedWfRoleId;

	private long wfActionId;

	private long assignedUserId;

	private String remarks;

	private String tranStatus;
	
	private long assignedPostId;
	
	private long officeId;
	
	private long assignedByPostId;
	
	private long assignedByUserId;
	
	private long assignedByOfficeId;

	public TrnBudWfDto() {
		super();
	}

	/**
	 * @return the trnBudWfId
	 */
	public long getTrnBudWfId() {
		return trnBudWfId;
	}

	/**
	 * @param trnBudWfId the trnBudWfId to set
	 */
	public void setTrnBudWfId(long trnBudWfId) {
		this.trnBudWfId = trnBudWfId;
	}

	/**
	 * @return the trnBudSceHeaderId
	 */
	public long getTrnBudSceHeaderId() {
		return trnBudSceHeaderId;
	}

	/**
	 * @param trnBudSceHeaderId the trnBudSceHeaderId to set
	 */
	public void setTrnBudSceHeaderId(long trnBudSceHeaderId) {
		this.trnBudSceHeaderId = trnBudSceHeaderId;
	}

	/**
	 * @return the currentWorkflowId
	 */
	public long getCurrentWorkflowId() {
		return currentWorkflowId;
	}

	/**
	 * @param currentWorkflowId the currentWorkflowId to set
	 */
	public void setCurrentWorkflowId(long currentWorkflowId) {
		this.currentWorkflowId = currentWorkflowId;
	}

	/**
	 * @return the assignedWfRoleId
	 */
	public Long getAssignedWfRoleId() {
		return assignedWfRoleId;
	}

	/**
	 * @param assignedWfRoleId the assignedWfRoleId to set
	 */
	public void setAssignedWfRoleId(Long assignedWfRoleId) {
		this.assignedWfRoleId = assignedWfRoleId;
	}

	/**
	 * @return the wfActionId
	 */
	public long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the assignedUserId
	 */
	public long getAssignedUserId() {
		return assignedUserId;
	}

	/**
	 * @param assignedUserId the assignedUserId to set
	 */
	public void setAssignedUserId(long assignedUserId) {
		this.assignedUserId = assignedUserId;
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
	 * @return the tranStatus
	 */
	public String getTranStatus() {
		return tranStatus;
	}

	/**
	 * @param tranStatus the tranStatus to set
	 */
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	

	/**
	 * @return the assignedPostId
	 */
	public long getAssignedPostId() {
		return assignedPostId;
	}

	/**
	 * @param assignedPostId the assignedPostId to set
	 */
	public void setAssignedPostId(long assignedPostId) {
		this.assignedPostId = assignedPostId;
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
	 * @return the assignedByPostId
	 */
	public long getAssignedByPostId() {
		return assignedByPostId;
	}

	/**
	 * @param assignedByPostId the assignedByPostId to set
	 */
	public void setAssignedByPostId(long assignedByPostId) {
		this.assignedByPostId = assignedByPostId;
	}

	/**
	 * @return the assignedByUserId
	 */
	public long getAssignedByUserId() {
		return assignedByUserId;
	}

	/**
	 * @param assignedByUserId the assignedByUserId to set
	 */
	public void setAssignedByUserId(long assignedByUserId) {
		this.assignedByUserId = assignedByUserId;
	}

	/**
	 * @return the assignedByOfficeId
	 */
	public long getAssignedByOfficeId() {
		return assignedByOfficeId;
	}

	/**
	 * @param assignedByOfficeId the assignedByOfficeId to set
	 */
	public void setAssignedByOfficeId(long assignedByOfficeId) {
		this.assignedByOfficeId = assignedByOfficeId;
	}

	public TrnBudWfDto(long createdBy, Date createdDate, long createdByPost, long updatedByPost, int activeStatus,
			long updatedBy, Date updatedDate) {
		super(createdBy, createdDate, createdByPost, updatedByPost, activeStatus, updatedBy, updatedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedByOfficeId, assignedByPostId, assignedByUserId, assignedPostId, assignedUserId,
				assignedWfRoleId, currentWorkflowId, officeId, remarks, tranStatus, trnBudSceHeaderId, trnBudWfId,
				wfActionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TrnBudWfDto)) {
			return false;
		}
		TrnBudWfDto other = (TrnBudWfDto) obj;
		return assignedByOfficeId == other.assignedByOfficeId && assignedByPostId == other.assignedByPostId
				&& assignedByUserId == other.assignedByUserId && assignedPostId == other.assignedPostId
				&& assignedUserId == other.assignedUserId && Objects.equals(assignedWfRoleId, other.assignedWfRoleId)
				&& currentWorkflowId == other.currentWorkflowId && officeId == other.officeId
				&& Objects.equals(remarks, other.remarks) && Objects.equals(tranStatus, other.tranStatus)
				&& trnBudSceHeaderId == other.trnBudSceHeaderId && trnBudWfId == other.trnBudWfId
				&& wfActionId == other.wfActionId;
	}

	@Override
	public String toString() {
		return String.format(
				"TrnBudWfDto [trnBudWfId=%s, trnBudSceHeaderId=%s, currentWorkflowId=%s, assignedWfRoleId=%s, wfActionId=%s, assignedUserId=%s, remarks=%s, tranStatus=%s, assignedPostId=%s, officeId=%s, assignedByPostId=%s, assignedByUserId=%s, assignedByOfficeId=%s]",
				trnBudWfId, trnBudSceHeaderId, currentWorkflowId, assignedWfRoleId, wfActionId, assignedUserId, remarks,
				tranStatus, assignedPostId, officeId, assignedByPostId, assignedByUserId, assignedByOfficeId);
	}
	
}
