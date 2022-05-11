package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfActionDto
 */
public class WfActionDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private long currentWorkflowId;
	
	private long wfActionId;
	
	private String wfActionName;
	
	private Long assignedWfRoleId;
	
	private long currentWfRoleId;
	
	private int currentActionLevel;
	
	private int nextActionLevel;
	
	private String trnStatus;

	private String wfStatus;

	private String wfActionCode;

	private String wfRoleCode;

	public String getWfRoleCode() {
		return wfRoleCode;
	}

	public void setWfRoleCode(String wfRoleCode) {
		this.wfRoleCode = wfRoleCode;
	}

	public String getWfActionCode() {
		return wfActionCode;
	}

	public void setWfActionCode(String wfActionCode) {
		this.wfActionCode = wfActionCode;
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
	 * @return the wfActionName
	 */
	public String getWfActionName() {
		return wfActionName;
	}

	/**
	 * @param wfActionName the wfActionName to set
	 */
	public void setWfActionName(String wfActionName) {
		this.wfActionName = wfActionName;
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

	public long getCurrentWfRoleId() {
		return currentWfRoleId;
	}

	public void setCurrentWfRoleId(long currentWfRoleId) {
		this.currentWfRoleId = currentWfRoleId;
	}

		
	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
	
	/**
	 * @return the currentActionLevel
	 */
	public int getCurrentActionLevel() {
		return currentActionLevel;
	}

	/**
	 * @param currentActionLevel the currentActionLevel to set
	 */
	public void setCurrentActionLevel(int currentActionLevel) {
		this.currentActionLevel = currentActionLevel;
	}

	/**
	 * @return the nextActionLevel
	 */
	public int getNextActionLevel() {
		return nextActionLevel;
	}

	/**
	 * @param nextActionLevel the nextActionLevel to set
	 */
	public void setNextActionLevel(int nextActionLevel) {
		this.nextActionLevel = nextActionLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedWfRoleId, currentActionLevel, currentWfRoleId, currentWorkflowId, nextActionLevel,
				trnStatus, wfActionId, wfActionName, wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfActionDto)) {
			return false;
		}
		WfActionDto other = (WfActionDto) obj;
		return assignedWfRoleId == other.assignedWfRoleId && currentActionLevel == other.currentActionLevel
				&& currentWfRoleId == other.currentWfRoleId && currentWorkflowId == other.currentWorkflowId
				&& nextActionLevel == other.nextActionLevel && Objects.equals(trnStatus, other.trnStatus)
				&& wfActionId == other.wfActionId && Objects.equals(wfActionName, other.wfActionName)
				&& Objects.equals(wfStatus, other.wfStatus);
	}

	@Override
	public String toString() {
		return String.format(
				"WfActionDto [currentWorkflowId=%s, wfActionId=%s, wfActionName=%s, assignedWfRoleId=%s, currentWfRoleId=%s, currentActionLevel=%s, nextActionLevel=%s, trnStatus=%s, wfStatus=%s]",
				currentWorkflowId, wfActionId, wfActionName, assignedWfRoleId, currentWfRoleId, currentActionLevel,
				nextActionLevel, trnStatus, wfStatus);
	}
}
