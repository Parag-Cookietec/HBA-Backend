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
 * The Class EDPtusrRgMapDtlItrEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:32:46
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP_DTL_ITR", schema = Constant.EDP_SCHEMA)
public class EDPtusrRgMapDtlItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USRRG_MP_DTLITR_ID")
	private Long tusrRgMapDtlItrId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USR_RG_MAP_DTL_ID", referencedColumnName = "T_USR_RG_MAP_DTL_ID")
	private EDPtusrRgMapDtlEntity tusrRgMapDtlId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RG_MAP_ID", referencedColumnName = "T_USR_RG_MAP_ID")
	private EDPtusrRgMapEntity tusrRgMapId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
	private EDPMsMenuEntity menuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_PRM_ID", referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity rolePrmId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OLD_ROLE_PRM_ID", referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity oldRolePrmId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_REMOVED", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isRemoved;

	/**
	 * @return the tusrRgMapDtlItrId
	 */
	public Long getTusrRgMapDtlItrId() {
		return tusrRgMapDtlItrId;
	}

	/**
	 * @param tusrRgMapDtlItrId the tusrRgMapDtlItrId to set
	 */
	public void setTusrRgMapDtlItrId(Long tusrRgMapDtlItrId) {
		this.tusrRgMapDtlItrId = tusrRgMapDtlItrId;
	}

	/**
	 * @return the tusrRgMapDtlId
	 */
	public EDPtusrRgMapDtlEntity getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(EDPtusrRgMapDtlEntity tusrRgMapDtlId) {
		this.tusrRgMapDtlId = tusrRgMapDtlId;
	}

	/**
	 * @return the tusrRgMapId
	 */
	public EDPtusrRgMapEntity getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(EDPtusrRgMapEntity tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * @return the menuId
	 */
	public EDPMsMenuEntity getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(EDPMsMenuEntity menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the rolePrmId
	 */
	public EDPMsRolePermissionsEntity getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(EDPMsRolePermissionsEntity rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * @return the oldRolePrmId
	 */
	public EDPMsRolePermissionsEntity getOldRolePrmId() {
		return oldRolePrmId;
	}

	/**
	 * @param oldRolePrmId the oldRolePrmId to set
	 */
	public void setOldRolePrmId(EDPMsRolePermissionsEntity oldRolePrmId) {
		this.oldRolePrmId = oldRolePrmId;
	}

	/**
	 * @return the isRemoved
	 */
	public EDPLuLookUpInfoEntity getIsRemoved() {
		return isRemoved;
	}

	/**
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(EDPLuLookUpInfoEntity isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
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
		return Objects.hash(isRemoved, menuId, oldRolePrmId, rolePrmId, tusrRgMapDtlId, tusrRgMapDtlItrId, tusrRgMapId);
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
		if (!(obj instanceof EDPtusrRgMapDtlItrEntity)) {
			return false;
		}
		EDPtusrRgMapDtlItrEntity other = (EDPtusrRgMapDtlItrEntity) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(oldRolePrmId, other.oldRolePrmId) && Objects.equals(rolePrmId, other.rolePrmId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapDtlItrId, other.tusrRgMapDtlItrId)
				&& Objects.equals(tusrRgMapId, other.tusrRgMapId);
	}

}
