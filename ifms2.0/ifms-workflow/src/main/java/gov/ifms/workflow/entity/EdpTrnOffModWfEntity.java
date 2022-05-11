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
 * The Class EdpTrnOffModWfEntity.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Entity
@Table(name = "T_EDPOFFMOD_WF", schema = Constant.EDP_SCHEMA)
public class EdpTrnOffModWfEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDPOFFMOD_WF_ID")
	private long edpTrnOffModWfId;

	@Column(name = "TRN_ID")
	private long edpTrnOffId;

	@Column(name = "CURRENT_WORKFLOW_ID")
	private long currentWorkflowId;

	@Column(name = "WF_ACTION_ID")
	private long wfActionId;

	@Column(name = "ASSIGN_TO_WF_ROLE_ID")
	private Long assignedToWfRoleId;

	@Column(name = "ASSIGN_TO_USER_ID")
	private Long assignedToUserId;

	@Column(name = "ASSIGN_TO_POST_ID")
	private Long assignedToPostId;

	@Column(name = "ASSIGN_TO_OFFICE_ID")
	private Long assignedToOfficeId;

	@Column(name = "TRN_STATUS")
	private String trnStatus;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "ASSIGN_BY_WF_ROLE_ID")
	private long assignedByWfRoleId;

	@Column(name = "ASSIGN_BY_POST_ID")
	private long assignedByPostId;

	@Column(name = "ASSIGN_BY_USER_ID")
	private long assignedByUserId;

	@Column(name = "ASSIGN_BY_OFFICE_ID")
	private long assignedByOfficeId;

	@Column(name = "MENU_ID")
	private long menuId;

	public EdpTrnOffModWfEntity() {
		super();
	}

	public long getEdpTrnOffModWfId() {
		return edpTrnOffModWfId;
	}

	public void setEdpTrnOffModWfId(long edpTrnOffModWfId) {
		this.edpTrnOffModWfId = edpTrnOffModWfId;
	}

	public long getEdpTrnOffId() {
		return edpTrnOffId;
	}

	public void setEdpTrnOffId(long edpTrnOffId) {
		this.edpTrnOffId = edpTrnOffId;
	}

	public long getCurrentWorkflowId() {
		return currentWorkflowId;
	}

	public void setCurrentWorkflowId(long currentWorkflowId) {
		this.currentWorkflowId = currentWorkflowId;
	}

	public long getWfActionId() {
		return wfActionId;
	}

	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	public Long getAssignedToWfRoleId() {
		return assignedToWfRoleId;
	}

	public void setAssignedToWfRoleId(Long assignedToWfRoleId) {
		this.assignedToWfRoleId = assignedToWfRoleId;
	}

	public Long getAssignedToUserId() {
		return assignedToUserId;
	}

	public void setAssignedToUserId(Long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}

	public Long getAssignedToPostId() {
		return assignedToPostId;
	}

	public void setAssignedToPostId(Long assignedToPostId) {
		this.assignedToPostId = assignedToPostId;
	}

	public Long getAssignedToOfficeId() {
		return assignedToOfficeId;
	}

	public void setAssignedToOfficeId(Long assignedToOfficeId) {
		this.assignedToOfficeId = assignedToOfficeId;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getAssignedByWfRoleId() {
		return assignedByWfRoleId;
	}

	public void setAssignedByWfRoleId(long assignedByWfRoleId) {
		this.assignedByWfRoleId = assignedByWfRoleId;
	}

	public long getAssignedByPostId() {
		return assignedByPostId;
	}

	public void setAssignedByPostId(long assignedByPostId) {
		this.assignedByPostId = assignedByPostId;
	}

	public long getAssignedByUserId() {
		return assignedByUserId;
	}

	public void setAssignedByUserId(long assignedByUserId) {
		this.assignedByUserId = assignedByUserId;
	}

	public long getAssignedByOfficeId() {
		return assignedByOfficeId;
	}

	public void setAssignedByOfficeId(long assignedByOfficeId) {
		this.assignedByOfficeId = assignedByOfficeId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedByOfficeId, assignedByPostId, assignedByUserId, assignedByWfRoleId,
				assignedToOfficeId, assignedToPostId, assignedToUserId, assignedToWfRoleId, currentWorkflowId,
				edpTrnOffId, edpTrnOffModWfId, menuId, remarks, trnStatus, wfActionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EdpTrnOffModWfEntity)) {
			return false;
		}
		EdpTrnOffModWfEntity other = (EdpTrnOffModWfEntity) obj;
		return assignedByOfficeId == other.assignedByOfficeId && assignedByPostId == other.assignedByPostId
				&& assignedByUserId == other.assignedByUserId && assignedByWfRoleId == other.assignedByWfRoleId
				&& Objects.equals(assignedToOfficeId, other.assignedToOfficeId)
				&& Objects.equals(assignedToPostId, other.assignedToPostId)
				&& Objects.equals(assignedToUserId, other.assignedToUserId)
				&& Objects.equals(assignedToWfRoleId, other.assignedToWfRoleId)
				&& currentWorkflowId == other.currentWorkflowId && edpTrnOffId == other.edpTrnOffId
				&& edpTrnOffModWfId == other.edpTrnOffModWfId && menuId == other.menuId
				&& Objects.equals(remarks, other.remarks) && Objects.equals(trnStatus, other.trnStatus)
				&& wfActionId == other.wfActionId;
	}

}
