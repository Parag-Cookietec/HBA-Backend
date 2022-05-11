package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPLkPuoRoleGrpsEntity.
 * 
 * @version 1.0
 * @created 2019/11/15 18:58:15
 *
 */
@Entity
@Table(name = "LK_PUO_MENU_ROLES", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPuoMenuRolesEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo menu roles id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_PUO_MENU_ROLES_ID")
	private Long lkPuoMenuRolesId;

	/** The post user office id. */
	@Column(name = "POST_USER_OFFICE_ID")
	private Long postUserOfficeId;

	/** The menu ID. */
	@Column(name = "MENU_ID")
	private Long menuID;

	/** The role prm id. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmId;

	/**
	 * Instantiates a new EDP lk puo menu roles entity.
	 */
	public EDPLkPuoMenuRolesEntity() {
		super();
	}

	/**
	 * Gets the lk puo menu roles id.
	 *
	 * @return the lkPuoMenuRolesId
	 */
	public Long getLkPuoMenuRolesId() {
		return lkPuoMenuRolesId;
	}

	/**
	 * Sets the lk puo menu roles id.
	 *
	 * @param lkPuoMenuRolesId the lkPuoMenuRolesId to set
	 */
	public void setLkPuoMenuRolesId(Long lkPuoMenuRolesId) {
		this.lkPuoMenuRolesId = lkPuoMenuRolesId;
	}

	/**
	 * Gets the post user office id.
	 *
	 * @return the postUserOfficeId
	 */
	public Long getPostUserOfficeId() {
		return postUserOfficeId;
	}

	/**
	 * Sets the post user office id.
	 *
	 * @param postUserOfficeId the postUserOfficeId to set
	 */
	public void setPostUserOfficeId(Long postUserOfficeId) {
		this.postUserOfficeId = postUserOfficeId;
	}

	/**
	 * Gets the menu ID.
	 *
	 * @return the menuID
	 */
	public Long getMenuID() {
		return menuID;
	}

	/**
	 * Sets the menu ID.
	 *
	 * @param menuID the menuID to set
	 */
	public void setMenuID(Long menuID) {
		this.menuID = menuID;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkPuoMenuRolesId, menuID, postUserOfficeId, rolePrmId);
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
		if (!(obj instanceof EDPLkPuoMenuRolesEntity)) {
			return false;
		}
		EDPLkPuoMenuRolesEntity other = (EDPLkPuoMenuRolesEntity) obj;
		return Objects.equals(lkPuoMenuRolesId, other.lkPuoMenuRolesId) && Objects.equals(menuID, other.menuID)
				&& Objects.equals(postUserOfficeId, other.postUserOfficeId)
				&& Objects.equals(rolePrmId, other.rolePrmId);
	}

}
