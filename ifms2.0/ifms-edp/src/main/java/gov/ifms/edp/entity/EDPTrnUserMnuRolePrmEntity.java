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
 * The Class EDPTrnUserMnuRolePrmEntity.
 * 
 * @version 1.0
 * @created 2019/12/24 15:41:02
 *
 */
@Entity
@Table(name = "TRN_USR_MNU_ROLE_PRM", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPTrnUserMnuRolePrmEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn usr role prm id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_USR_ROLE_PRM_ID")
	private Long trnUsrRolePrmId;

	/** The lk user menu id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_USER_MENU_ID", nullable = false, referencedColumnName = "LK_USER_MENU_ID")
	private EDPLkUserMenuEntity lkUserMenuId;

	/** The role prm id. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmId;

	
	/**
	 * EDPTrnUserMnuRolePrmDto Constructor.
	 */
	public EDPTrnUserMnuRolePrmEntity() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the trn usr role prm id
	 */

	/**
	 * @return the trnUsrRolePrmId
	 */
	public Long getTrnUsrRolePrmId() {
		return trnUsrRolePrmId;
	}

	/**
	 * Sets the trn usr role prm id.
	 *
	 * @param trnUsrRolePrmId the trnUsrRolePrmId to set
	 */
	public void setTrnUsrRolePrmId(Long trnUsrRolePrmId) {
		this.trnUsrRolePrmId = trnUsrRolePrmId;
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
	 * Gets the role prm id.
	 *
	 * @return the rolePrmId
	 */
	public Long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(Long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkUserMenuId, rolePrmId, trnUsrRolePrmId);
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
		if (!(obj instanceof EDPTrnUserMnuRolePrmEntity)) {
			return false;
		}
		EDPTrnUserMnuRolePrmEntity other = (EDPTrnUserMnuRolePrmEntity) obj;
		return Objects.equals(lkUserMenuId, other.lkUserMenuId) && Objects.equals(rolePrmId, other.rolePrmId)
				&& Objects.equals(trnUsrRolePrmId, other.trnUsrRolePrmId);
	}
	
}
