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
 * The Class EDPtusrRgMapDtlEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:31:33
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP_DTL", schema = Constant.EDP_SCHEMA)
public class EDPtusrRgMapDtlEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map dtl id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RG_MAP_DTL_ID")
	private Long tusrRgMapDtlId;

	/** The tusr rg map id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USR_RG_MAP_ID", referencedColumnName = "T_USR_RG_MAP_ID")
	private EDPtusrRgMapEntity tusrRgMapId;

	/** The menu id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
	private EDPMsMenuEntity menuId;
	
	/** The role prm id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_PRM_ID", referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity rolePrmId;

	/** The old role prm id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OLD_ROLE_PRM_ID", referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity oldRolePrmId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_REMOVED", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isRemoved;

	/**
	 * Gets the tusr rg map dtl id.
	 *
	 * @return the tusrRgMapDtlId
	 */
	public Long getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * Sets the tusr rg map dtl id.
	 *
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(Long tusrRgMapDtlId) {
		this.tusrRgMapDtlId = tusrRgMapDtlId;
	}

	/**
	 * Gets the tusr rg map id.
	 *
	 * @return the tusrRgMapId
	 */
	public EDPtusrRgMapEntity getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(EDPtusrRgMapEntity tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public EDPMsMenuEntity getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(EDPMsMenuEntity menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the role prm id.
	 *
	 * @return the rolePrmId
	 */
	public EDPMsRolePermissionsEntity getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(EDPMsRolePermissionsEntity rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the old role prm id.
	 *
	 * @return the oldRolePrmId
	 */
	public EDPMsRolePermissionsEntity getOldRolePrmId() {
		return oldRolePrmId;
	}

	/**
	 * Sets the old role prm id.
	 *
	 * @param oldRolePrmId the oldRolePrmId to set
	 */
	public void setOldRolePrmId(EDPMsRolePermissionsEntity oldRolePrmId) {
		this.oldRolePrmId = oldRolePrmId;
	}

	/**
	 * Gets the checks if is removed.
	 *
	 * @return the isRemoved
	 */
	public EDPLuLookUpInfoEntity getIsRemoved() {
		return isRemoved;
	}

	/**
	 * Sets the checks if is removed.
	 *
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(EDPLuLookUpInfoEntity isRemoved) {
		this.isRemoved = isRemoved;
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
		return Objects.hash(isRemoved, menuId, oldRolePrmId, rolePrmId, tusrRgMapDtlId, tusrRgMapId);
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
		if (!(obj instanceof EDPtusrRgMapDtlEntity)) {
			return false;
		}
		EDPtusrRgMapDtlEntity other = (EDPtusrRgMapDtlEntity) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(oldRolePrmId, other.oldRolePrmId) && Objects.equals(rolePrmId, other.rolePrmId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapId, other.tusrRgMapId);
	}
	
}
