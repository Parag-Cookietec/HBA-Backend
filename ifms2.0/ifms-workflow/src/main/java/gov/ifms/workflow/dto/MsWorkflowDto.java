package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class MsWorkflowDto.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
public class MsWorkflowDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private long workflowId;

	private String workflowName;

	private long officeTypeId;

	private long wfRoleId;

	private long wfActionId;

	private String trnStatus;

	private long nextWfRoleId;
	
	private long menuId;

	private long wfLevelId;
	
	private long wfEndpointId;
	
	private long isExcpReq;
	
	private Long wfInitWfRoleId;
	
	private String wfStatus;

	public MsWorkflowDto() {
		super();
	}

	public MsWorkflowDto(long createdBy, Date createdDate, long createdByPost, long updatedByPost, int activeStatus,
			long updatedBy, Date updatedDate) {
		super(createdBy, createdDate, createdByPost, updatedByPost, activeStatus, updatedBy, updatedDate);
	}

	/**
	 * @return the workflowId
	 */
	public long getWorkflowId() {
		return workflowId;
	}

	/**
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	/**
	 * @return the workflowName
	 */
	public String getWorkflowName() {
		return workflowName;
	}

	/**
	 * @param workflowName the workflowName to set
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	/**
	 * @return the officeTypeId
	 */
	public long getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * @param officeTypeId the officeTypeId to set
	 */
	public void setOfficeTypeId(long officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	/**
	 * @return the wfRoleId
	 */
	public long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
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
	 * @return the nextWfRoleId
	 */
	public long getNextWfRoleId() {
		return nextWfRoleId;
	}

	/**
	 * @param nextWfRoleId the nextWfRoleId to set
	 */
	public void setNextWfRoleId(long nextWfRoleId) {
		this.nextWfRoleId = nextWfRoleId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the wfLevelId
	 */
	public long getWfLevelId() {
		return wfLevelId;
	}

	/**
	 * @param wfLevelId the wfLevelId to set
	 */
	public void setWfLevelId(long wfLevelId) {
		this.wfLevelId = wfLevelId;
	}

	/**
	 * @return the wfEndpointId
	 */
	public long getWfEndpointId() {
		return wfEndpointId;
	}

	/**
	 * @param wfEndpointId the wfEndpointId to set
	 */
	public void setWfEndpointId(long wfEndpointId) {
		this.wfEndpointId = wfEndpointId;
	}

	/**
	 * @return the isExcpReq
	 */
	public long getIsExcpReq() {
		return isExcpReq;
	}

	/**
	 * @param isExcpReq the isExcpReq to set
	 */
	public void setIsExcpReq(long isExcpReq) {
		this.isExcpReq = isExcpReq;
	}
	
	/**
	 * @return the wfInitWfRoleId
	 */
	public Long getWfInitWfRoleId() {
		return wfInitWfRoleId;
	}

	/**
	 * @param wfInitWfRoleId the wfInitWfRoleId to set
	 */
	public void setWfInitWfRoleId(Long wfInitWfRoleId) {
		this.wfInitWfRoleId = wfInitWfRoleId;
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

	@Override
	public int hashCode() {
		return Objects.hash(isExcpReq, menuId, nextWfRoleId, officeTypeId, trnStatus, wfActionId, wfEndpointId,
				wfInitWfRoleId, wfLevelId, wfRoleId, wfStatus, workflowId, workflowName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MsWorkflowDto)) {
			return false;
		}
		MsWorkflowDto other = (MsWorkflowDto) obj;
		return isExcpReq == other.isExcpReq && menuId == other.menuId && nextWfRoleId == other.nextWfRoleId
				&& officeTypeId == other.officeTypeId && Objects.equals(trnStatus, other.trnStatus)
				&& wfActionId == other.wfActionId && wfEndpointId == other.wfEndpointId
				&& Objects.equals(wfInitWfRoleId, other.wfInitWfRoleId) && wfLevelId == other.wfLevelId
				&& wfRoleId == other.wfRoleId && Objects.equals(wfStatus, other.wfStatus)
				&& workflowId == other.workflowId && Objects.equals(workflowName, other.workflowName);
	}

	@Override
	public String toString() {
		return String.format(
				"MsWorkflowDto [workflowId=%s, workflowName=%s, officeTypeId=%s, wfRoleId=%s, wfActionId=%s, trnStatus=%s, nextWfRoleId=%s, menuId=%s, wfLevelId=%s, wfEndpointId=%s, isExcpReq=%s, wfInitWfRoleId=%s, wfStatus=%s]",
				workflowId, workflowName, officeTypeId, wfRoleId, wfActionId, trnStatus, nextWfRoleId, menuId,
				wfLevelId, wfEndpointId, isExcpReq, wfInitWfRoleId, wfStatus);
	}

}
