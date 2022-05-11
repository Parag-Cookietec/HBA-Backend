package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapDtlItrDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:32:46
 *
 */
public class EDPtusrRgMapDtlItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map dtl itr id. */
	private Long tusrRgMapDtlItrId;

	/** The tusr rg map dtl id. */
	private Long tusrRgMapDtlId;

	/** The tusr rg map id. */
	private Long tusrRgMapId;

	/** The menu id. */
	private Long menuId;

	/** The role prm id. */
	private Long rolePrmId;

	/** The old role prm id. */
	private Long oldRolePrmId;

	/** The is removed. */
	private Long isRemoved;

	/**
	 * Gets the tusr rg map dtl itr id.
	 *
	 * @return the tusrRgMapDtlItrId
	 */
	public Long getTusrRgMapDtlItrId() {
		return tusrRgMapDtlItrId;
	}

	/**
	 * Sets the tusr rg map dtl itr id.
	 *
	 * @param tusrRgMapDtlItrId the tusrRgMapDtlItrId to set
	 */
	public void setTusrRgMapDtlItrId(Long tusrRgMapDtlItrId) {
		this.tusrRgMapDtlItrId = tusrRgMapDtlItrId;
	}

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
	public Long getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(Long tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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
	 * Gets the old role prm id.
	 *
	 * @return the oldRolePrmId
	 */
	public Long getOldRolePrmId() {
		return oldRolePrmId;
	}

	/**
	 * Sets the old role prm id.
	 *
	 * @param oldRolePrmId the oldRolePrmId to set
	 */
	public void setOldRolePrmId(Long oldRolePrmId) {
		this.oldRolePrmId = oldRolePrmId;
	}

	/**
	 * Gets the checks if is removed.
	 *
	 * @return the isRemoved
	 */
	public Long getIsRemoved() {
		return isRemoved;
	}

	/**
	 * Sets the checks if is removed.
	 *
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(Long isRemoved) {
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(isRemoved, menuId, oldRolePrmId, rolePrmId, tusrRgMapDtlId,
				tusrRgMapDtlItrId, tusrRgMapId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapDtlItrDto)) {
			return false;
		}
		EDPtusrRgMapDtlItrDto other = (EDPtusrRgMapDtlItrDto) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(oldRolePrmId, other.oldRolePrmId) && Objects.equals(rolePrmId, other.rolePrmId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapDtlItrId, other.tusrRgMapDtlItrId)
				&& Objects.equals(tusrRgMapId, other.tusrRgMapId);
	}
	
}
