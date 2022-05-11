package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapDtlDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:31:33
 *
 */
public class EDPtusrRgMapDtlDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

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
	 * EDPtusrRgMapDtlDto Constructor.
	 */
	public EDPtusrRgMapDtlDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tusrRgMapDtlId, tusrRgMapId, menuId, rolePrmId, oldRolePrmId, isRemoved);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof EDPtusrRgMapDtlDto)) {
			return false;
		}

		EDPtusrRgMapDtlDto other = (EDPtusrRgMapDtlDto) obj;

		return Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId) && Objects.equals(tusrRgMapId, other.tusrRgMapId)
				&& Objects.equals(menuId, other.menuId) && Objects.equals(rolePrmId, other.rolePrmId)
				&& Objects.equals(oldRolePrmId, other.oldRolePrmId) && Objects.equals(isRemoved, other.isRemoved);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPtusrRgMapDtlDto [tusrRgMapDtlId = " + tusrRgMapDtlId + ",tusrRgMapId = " + tusrRgMapId + ",menuId = "
				+ menuId + ",rolePrmId = " + rolePrmId + ",oldRolePrmId = " + oldRolePrmId + ",isRemoved = " + isRemoved
				+ ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the tusr rg map dtl id
	 */

	/**
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

}
