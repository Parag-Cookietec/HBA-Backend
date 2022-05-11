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
 * The Class EdpLkSubMenuOfficeType.
 */
@Entity
@Table(name = "LK_SUB_MNU_OFF_TYPE", schema = Constant.EDP_MASTER_SCHEMA)
public class EdpLkSubMenuOfficeTypeEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk menu off type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_MNU_OFF_TYPE_ID")
	private Long lkMenuOffTypeId;

	/** The mod off type id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="MOD_OFF_TYPE_ID" ,nullable = false, referencedColumnName ="LK_MOD_OFF_TYPE_ID" )
	private EDPLkModuleOfficeEntity modOffTypeId;

	/** The sub module id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="SUB_MODULE_ID" ,nullable = false, referencedColumnName ="SUB_MODULE_ID" )
	private EDPMsSubModuleEntity subModuleId;

	/** The menu id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="MENU_ID" ,nullable = false, referencedColumnName ="MENU_ID" )
	private EDPMsMenuEntity menuId;

	/**
	 * Gets the lk menu off type id.
	 *
	 * @return the lk menu off type id
	 */
	public Long getLkMenuOffTypeId() {
		return lkMenuOffTypeId;
	}

	/**
	 * Sets the lk menu off type id.
	 *
	 * @param lkMenuOffTypeId the new lk menu off type id
	 */
	public void setLkMenuOffTypeId(Long lkMenuOffTypeId) {
		this.lkMenuOffTypeId = lkMenuOffTypeId;
	}

	/**
	 * Gets the mod off type id.
	 *
	 * @return the mod off type id
	 */
	public EDPLkModuleOfficeEntity getModOffTypeId() {
		return modOffTypeId;
	}

	/**
	 * Sets the mod off type id.
	 *
	 * @param modOffTypeId the new mod off type id
	 */
	public void setModOffTypeId(EDPLkModuleOfficeEntity modOffTypeId) {
		this.modOffTypeId = modOffTypeId;
	}

	/**
	 * Gets the sub module id.
	 *
	 * @return the sub module id
	 */
	public EDPMsSubModuleEntity getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the new sub module id
	 */
	public void setSubModuleId(EDPMsSubModuleEntity subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public EDPMsMenuEntity getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(EDPMsMenuEntity menuId) {
		this.menuId = menuId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkMenuOffTypeId, menuId, modOffTypeId, subModuleId);
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
		if (!(obj instanceof EdpLkSubMenuOfficeTypeEntity)) {
			return false;
		}
		EdpLkSubMenuOfficeTypeEntity other = (EdpLkSubMenuOfficeTypeEntity) obj;
		return Objects.equals(lkMenuOffTypeId, other.lkMenuOffTypeId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(modOffTypeId, other.modOffTypeId) && Objects.equals(subModuleId, other.subModuleId);
	}
	
}
