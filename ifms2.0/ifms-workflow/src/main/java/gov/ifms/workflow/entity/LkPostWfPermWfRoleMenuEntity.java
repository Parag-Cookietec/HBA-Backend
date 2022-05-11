package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;

/**
 * The Class EDPLkPostWfPermWfRoleMenuEntity.
 * 
 * @version 1.0
 * @created 2019/08/31 14:08:39
 *
 */
@Entity
@Table(name = "LK_POST_WF_PERM_WF_ROLE_MENU", schema = Constant.BUDGET_SCHEMA)
public class LkPostWfPermWfRoleMenuEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_WF_PERM_WF_ROLE_MENU_ID")
	private long postWfPermWfRoleMenuId;

	@Column(name = "POST_ID")
	private long postId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_PERM_ID", referencedColumnName = "WF_PERM_ID")
	private MsWorkflowPermissionsEntity wfPermId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_ROLE_ID", referencedColumnName = "WF_ROLE_ID")
	private MsWorkflowRoleEntity wfRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
	private EDPMsMenuEntity menuEntity;

	/**
	 * @return the postWfPermWfRoleMenuId
	 */
	public long getPostWfPermWfRoleMenuId() {
		return postWfPermWfRoleMenuId;
	}

	/**
	 * @param postWfPermWfRoleMenuId the postWfPermWfRoleMenuId to set
	 */
	public void setPostWfPermWfRoleMenuId(long postWfPermWfRoleMenuId) {
		this.postWfPermWfRoleMenuId = postWfPermWfRoleMenuId;
	}

	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * @return the wfPermId
	 */
	public MsWorkflowPermissionsEntity getWfPermId() {
		return wfPermId;
	}

	/**
	 * @param wfPermId the wfPermId to set
	 */
	public void setWfPermId(MsWorkflowPermissionsEntity wfPermId) {
		this.wfPermId = wfPermId;
	}

	/**
	 * @return the wfRoleId
	 */
	public MsWorkflowRoleEntity getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(MsWorkflowRoleEntity wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public EDPMsMenuEntity getMenuEntity() {
		return menuEntity;
	}

	public void setMenuEntity(EDPMsMenuEntity menuEntity) {
		this.menuEntity = menuEntity;
	}

	@Override
	public String toString() {
		return "EDPLkPostWfPermWfRoleMenuEntity []";
	}

	public LkPostWfPermWfRoleMenuEntity() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(menuEntity, postId, postWfPermWfRoleMenuId, wfPermId, wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LkPostWfPermWfRoleMenuEntity)) {
			return false;
		}
		LkPostWfPermWfRoleMenuEntity other = (LkPostWfPermWfRoleMenuEntity) obj;
		return Objects.equals(menuEntity, other.menuEntity) && postId == other.postId
				&& postWfPermWfRoleMenuId == other.postWfPermWfRoleMenuId && Objects.equals(wfPermId, other.wfPermId)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}
}
