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
 * The Class EDPLkModuleOfficeEntity.
 */
@Entity
@Table(name = "LK_MOD_OFFICE_TYPE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkModuleOfficeEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk mod off id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_MOD_OFF_TYPE_ID")
	private Long lkModOffId;

	/** The module id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="MODULE_ID" ,nullable = false, referencedColumnName ="MODULE_ID" )
	private EDPMsModuleEntity moduleId;
	
	/** The office type id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="OFFICE_TYPE_ID" ,nullable = false, referencedColumnName ="LOOKUP_INFO_ID" )
	private EDPLuLookUpInfoEntity officeTypeId;
	
	/** The office category id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="OFFICE_CATEGORY_ID" ,nullable = false, referencedColumnName ="LOOKUP_INFO_ID" )
	private EDPLuLookUpInfoEntity officeCategoryId;

	/**
	 * Gets the lk mod off id.
	 *
	 * @return the lk mod off id
	 */
	public Long getLkModOffId() {
		return lkModOffId;
	}

	/**
	 * Sets the lk mod off id.
	 *
	 * @param lkModOffId the new lk mod off id
	 */
	public void setLkModOffId(Long lkModOffId) {
		this.lkModOffId = lkModOffId;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public EDPMsModuleEntity getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(EDPMsModuleEntity moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the office type id.
	 *
	 * @return the office type id
	 */
	public EDPLuLookUpInfoEntity getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * Sets the office type id.
	 *
	 * @param officeTypeId the new office type id
	 */
	public void setOfficeTypeId(EDPLuLookUpInfoEntity officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	/**
	 * Gets the office category id.
	 *
	 * @return the office category id
	 */
	public EDPLuLookUpInfoEntity getOfficeCategoryId() {
		return officeCategoryId;
	}

	/**
	 * Sets the office category id.
	 *
	 * @param officeCategoryId the new office category id
	 */
	public void setOfficeCategoryId(EDPLuLookUpInfoEntity officeCategoryId) {
		this.officeCategoryId = officeCategoryId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkModOffId, moduleId, officeCategoryId, officeTypeId);
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
		if (!(obj instanceof EDPLkModuleOfficeEntity)) {
			return false;
		}
		EDPLkModuleOfficeEntity other = (EDPLkModuleOfficeEntity) obj;
		return Objects.equals(lkModOffId, other.lkModOffId) && Objects.equals(moduleId, other.moduleId)
				&& Objects.equals(officeCategoryId, other.officeCategoryId) && Objects.equals(officeTypeId, other.officeTypeId);
	}

	
}
