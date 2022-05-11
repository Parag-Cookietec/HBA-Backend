package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PvuTrnEmpCrWfEntity.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Entity
@Table(name = "T_PVU_EMPCR_WF", schema = Constant.PVU_SCHEMA)
public class PvuTrnEmpCrWfEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_EMPCR_WF_ID")
	private long pvuTrnEmpCrWfId;

	@Column(name = "TRN_ID")
	private long trnId;

	@Column(name = "CURRENT_WORKFLOW_ID")
	private long currentWorkflowId;

	@Column(name = "WF_ACTION_ID")
	private long wfActionId;

	@Column(name = "ASSIGN_TO_ACTION_LEVEL")
	private int assignToActionLevel;
	
	@Column(name = "ASSIGN_TO_WF_ROLE_ID")
	private Long assignToWfRoleId;

	@Column(name = "ASSIGN_TO_USER_ID")
	private Long assignToUserId;

	@Column(name = "ASSIGN_TO_POST_ID")
	private Long assignToPostId;

	@Column(name = "ASSIGN_TO_OFFICE_ID")
	private Long assignToOfficeId;

	@Column(name = "TRN_STATUS")
	private String trnStatus;
	
	@Column(name = "WF_STATUS")
	private String wfStatus;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "ASSIGN_BY_ACTION_LEVEL")
	private int assignByActionLevel;
	
	@Column(name = "ASSIGN_BY_WF_ROLE_ID")
	private long assignByWfRoleId;

	@Column(name = "ASSIGN_BY_POST_ID")
	private long assignByPostId;

	@Column(name = "ASSIGN_BY_USER_ID")
	private long assignByUserId;

	@Column(name = "ASSIGN_BY_OFFICE_ID")
	private long assignByOfficeId;

	@Column(name = "MENU_ID")
	private long menuId;

	public PvuTrnEmpCrWfEntity() {
		super();
	}
	
	/**
	 * @return the pvuTrnEmpCrWfId
	 */
	public long getPvuTrnEmpCrWfId() {
		return pvuTrnEmpCrWfId;
	}

	/**
	 * @param pvuTrnEmpCrWfId the pvuTrnEmpCrWfId to set
	 */
	public void setPvuTrnEmpCrWfId(long pvuTrnEmpCrWfId) {
		this.pvuTrnEmpCrWfId = pvuTrnEmpCrWfId;
	}

	/**
	 * @return the trnId
	 */
	public long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(long trnId) {
		this.trnId = trnId;
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
	public long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * @return the assignByPostId
	 */
	public long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * @param assignByPostId the assignByPostId to set
	 */
	public void setAssignByPostId(long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * @return the assignByUserId
	 */
	public long getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * @param assignByUserId the assignByUserId to set
	 */
	public void setAssignByUserId(long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * @return the assignByOfficeId
	 */
	public long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
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

	@Override
	public int hashCode() {
		return Objects.hash(assignByActionLevel, assignByOfficeId, assignByPostId, assignByUserId, assignByWfRoleId,
				assignToActionLevel, assignToOfficeId, assignToPostId, assignToUserId, assignToWfRoleId,
				currentWorkflowId, menuId, pvuTrnEmpCrWfId, remarks, trnId, trnStatus, wfActionId, wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PvuTrnEmpCrWfEntity)) {
			return false;
		}
		PvuTrnEmpCrWfEntity other = (PvuTrnEmpCrWfEntity) obj;
		return assignByActionLevel == other.assignByActionLevel && assignByOfficeId == other.assignByOfficeId
				&& assignByPostId == other.assignByPostId && assignByUserId == other.assignByUserId
				&& assignByWfRoleId == other.assignByWfRoleId && assignToActionLevel == other.assignToActionLevel
				&& Objects.equals(assignToOfficeId, other.assignToOfficeId)
				&& Objects.equals(assignToPostId, other.assignToPostId)
				&& Objects.equals(assignToUserId, other.assignToUserId)
				&& Objects.equals(assignToWfRoleId, other.assignToWfRoleId)
				&& currentWorkflowId == other.currentWorkflowId && menuId == other.menuId
				&& pvuTrnEmpCrWfId == other.pvuTrnEmpCrWfId && Objects.equals(remarks, other.remarks)
				&& trnId == other.trnId && Objects.equals(trnStatus, other.trnStatus) && wfActionId == other.wfActionId
				&& Objects.equals(wfStatus, other.wfStatus);
	}
}
