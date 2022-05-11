package gov.ifms.loc.workflow.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;


/**
 * The Class LocWfRlBrTypeMenuAuthEntity.
 */
@Entity
@Table(name = "TLOC_WF_RL_BR_TYPE_MENU_AUTH", schema = LocConstant.LOC_SCHEMA)
public class LocWfRlBrTypeMenuAuthEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4479574467946816164L;

	/** The wf rl br type menu auth id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_RL_BR_TYPE_MENU_AUTH_ID")
	private long wfRlBrTypeMenuAuthId;

	/** The menu id. */
	@Column(name = "MENU_ID")
	private long menuId;

	/** The wf role id. */
	@Column(name = "WF_RL_ID")
	private long wfRoleId;

	/** The branch type id. */
	@Column(name = "BRANCH_TYPE_ID")
	private Long branchTypeId;
	
	/** The branch id. */
	@Column(name = "BRANCH_ID")
	private Long branchId;


	/**
	 * Gets the wf rl br type menu auth id.
	 *
	 * @return the wf rl br type menu auth id
	 */
	public long getWfRlBrTypeMenuAuthId() {
		return wfRlBrTypeMenuAuthId;
	}

	/**
	 * Sets the wf rl br type menu auth id.
	 *
	 * @param wfRlBrTypeMenuAuthId the new wf rl br type menu auth id
	 */
	public void setWfRlBrTypeMenuAuthId(long wfRlBrTypeMenuAuthId) {
		this.wfRlBrTypeMenuAuthId = wfRlBrTypeMenuAuthId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the branch type id.
	 *
	 * @return the branch type id
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the new branch type id
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	
	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LocWfRlBrTypeMenuAuthEntity that = (LocWfRlBrTypeMenuAuthEntity) o;
		return wfRlBrTypeMenuAuthId == that.wfRlBrTypeMenuAuthId && menuId == that.menuId && wfRoleId == that.wfRoleId && Objects.equals(branchTypeId, that.branchTypeId);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(wfRlBrTypeMenuAuthId, menuId, wfRoleId, branchTypeId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LocWfRlBrTypeMenuAuthEntity{");
		sb.append("wfRlBrTypeMenuAuthId=").append(wfRlBrTypeMenuAuthId);
		sb.append(", menuId=").append(menuId);
		sb.append(", wfRoleId=").append(wfRoleId);
		sb.append(", branchTypeId=").append(branchTypeId);
		sb.append('}');
		return sb.toString();
	}
}
