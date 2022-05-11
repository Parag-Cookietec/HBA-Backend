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
 * The Class EDPUserMenuRolePrmEntity.
 * 
 * @version 1.0
 * @created 2019/12/30 11:47:19
 *
 */
@Entity
@Table(name = "TRN_USR_MNU_ROLE_PRM", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPUserMenuRolePrmEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user role prm id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_USR_ROLE_PRM_ID")
	private Long userRolePrmId;
	
	/** The user menu id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_USER_MENU_ID", referencedColumnName = "LK_USER_MENU_ID")
	private EDPLkUserMenuEntity userMenuId;
	
	/** The role prm id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROLE_PRM_ID", referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity rolePrmId;

	/**
	 * EDPUserMenuRolePrmDto Constructor.
	 */
	public EDPUserMenuRolePrmEntity() {
		super();
	}


	/**
	 * Gets the user role prm id.
	 *
	 * @return the user role prm id
	 */
	public Long getUserRolePrmId() {
		return userRolePrmId;
	}


	/**
	 * Sets the user role prm id.
	 *
	 * @param userRolePrmId the new user role prm id
	 */
	public void setUserRolePrmId(Long userRolePrmId) {
		this.userRolePrmId = userRolePrmId;
	}

	/**
	 * Gets the user menu id.
	 *
	 * @return the user menu id
	 */
	public EDPLkUserMenuEntity getUserMenuId() {
		return userMenuId;
	}


	/**
	 * Sets the user menu id.
	 *
	 * @param userMenuId the new user menu id
	 */
	public void setUserMenuId(EDPLkUserMenuEntity userMenuId) {
		this.userMenuId = userMenuId;
	}


	/**
	 * Gets the role prm id.
	 *
	 * @return the role prm id
	 */
	public EDPMsRolePermissionsEntity getRolePrmId() {
		return rolePrmId;
	}


	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the new role prm id
	 */
	public void setRolePrmId(EDPMsRolePermissionsEntity rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(rolePrmId, userMenuId, userRolePrmId);
	}


	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPUserMenuRolePrmEntity other = (EDPUserMenuRolePrmEntity) obj;
		return  Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(userMenuId, other.userMenuId)
				&& Objects.equals(userRolePrmId, other.userRolePrmId);
	}

}
