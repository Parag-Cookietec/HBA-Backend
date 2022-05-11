package gov.ifms.edp.entity;

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

/**
 * The Class EDPTrnUsrMnuWfRole.
 */
@Entity
@Table(name = "TRN_USR_MNU_WF_ROLE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPTrnUsrMnuWfRole extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn usr wf role id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_USR_WF_ROLE_ID")
	private Long trnUsrWfRoleId;

	/** The lk user menu id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_USER_MENU_ID", nullable = false, referencedColumnName = "LK_USER_MENU_ID")
	private EDPLkUserMenuEntity lkUserMenuId;

	/** The workflow role id. */
	@Column(name = "WF_ROLE_ID")
	private Long workflowRoleId;
	
	/** The is mapped frm linkd mnu. */
	@Column(name = "IS_MAPPED_FRM_LINKD_MNU")
	private Long isMappedFrmLinkdMnu;

	/**
	 * EDPLkPuoMenuRLWFDto Constructor.
	 */
	public EDPTrnUsrMnuWfRole() {
		super();
	}

	/**
	 * Gets the trn usr wf role id.
	 *
	 * @return the trnUsrWfRoleId
	 */
	public Long getTrnUsrWfRoleId() {
		return trnUsrWfRoleId;
	}

	/**
	 * Sets the trn usr wf role id.
	 *
	 * @param trnUsrWfRoleId the trnUsrWfRoleId to set
	 */
	public void setTrnUsrWfRoleId(Long trnUsrWfRoleId) {
		this.trnUsrWfRoleId = trnUsrWfRoleId;
	}

	/**
	 * Gets the lk user menu id.
	 *
	 * @return the lkUserMenuId
	 */
	public EDPLkUserMenuEntity getLkUserMenuId() {
		return lkUserMenuId;
	}

	/**
	 * Sets the lk user menu id.
	 *
	 * @param lkUserMenuId the lkUserMenuId to set
	 */
	public void setLkUserMenuId(EDPLkUserMenuEntity lkUserMenuId) {
		this.lkUserMenuId = lkUserMenuId;
	}

	/**
	 * Gets the workflow role id.
	 *
	 * @return the workflowRoleId
	 */
	public Long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * Sets the workflow role id.
	 *
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(Long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}

	/**
	 * @return the isMappedFrmLinkdMnu
	 */
	public Long getIsMappedFrmLinkdMnu() {
		return isMappedFrmLinkdMnu;
	}

	/**
	 * @param isMappedFrmLinkdMnu the isMappedFrmLinkdMnu to set
	 */
	public void setIsMappedFrmLinkdMnu(Long isMappedFrmLinkdMnu) {
		this.isMappedFrmLinkdMnu = isMappedFrmLinkdMnu;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isMappedFrmLinkdMnu, lkUserMenuId, trnUsrWfRoleId, workflowRoleId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPTrnUsrMnuWfRole)) {
			return false;
		}
		EDPTrnUsrMnuWfRole other = (EDPTrnUsrMnuWfRole) obj;
		return Objects.equals(isMappedFrmLinkdMnu, other.isMappedFrmLinkdMnu)
				&& Objects.equals(lkUserMenuId, other.lkUserMenuId)
				&& Objects.equals(trnUsrWfRoleId, other.trnUsrWfRoleId)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
	}


}
