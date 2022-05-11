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
 * The Class EDPMsModuleEntity.
 */
@Entity
@Table(name = "MS_MODULE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsModuleEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The module ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULE_ID ")
	private long moduleID;

	/** The module name. */
	@Column(name = "MODULE_NAME")
	private String moduleName;

	/** The module name guj. */
	@Column(name = "MODULE_NAME_GUJ")
	private String moduleNameGuj;

	/** The module description. */
	@Column(name = "MODULE_DESC")
	private String moduleDescription;

	/** The module description guj. */
	@Column(name = "MODULE_DESC_GUJ")
	private String moduleDescriptionGuj;

	/**
	 * Gets the module ID.
	 *
	 * @return the moduleID
	 */
	public long getModuleID() {
		return moduleID;
	}

	/**
	 * Sets the module ID.
	 *
	 * @param moduleID the moduleID to set
	 */
	public void setModuleID(long moduleID) {
		this.moduleID = moduleID;
	}

	/**
	 * Gets the module name.
	 *
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * Sets the module name.
	 *
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * Gets the module name guj.
	 *
	 * @return the moduleNameGuj
	 */
	public String getModuleNameGuj() {
		return moduleNameGuj;
	}

	/**
	 * Sets the module name guj.
	 *
	 * @param moduleNameGuj the moduleNameGuj to set
	 */
	public void setModuleNameGuj(String moduleNameGuj) {
		this.moduleNameGuj = moduleNameGuj;
	}

	/**
	 * Gets the module description.
	 *
	 * @return the moduleDescription
	 */
	public String getModuleDescription() {
		return moduleDescription;
	}

	/**
	 * Sets the module description.
	 *
	 * @param moduleDescription the moduleDescription to set
	 */
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	/**
	 * Gets the module description guj.
	 *
	 * @return the moduleDescriptionGuj
	 */
	public String getModuleDescriptionGuj() {
		return moduleDescriptionGuj;
	}

	/**
	 * Sets the module description guj.
	 *
	 * @param moduleDescriptionGuj the moduleDescriptionGuj to set
	 */
	public void setModuleDescriptionGuj(String moduleDescriptionGuj) {
		this.moduleDescriptionGuj = moduleDescriptionGuj;
	}

	/**
	 * Instantiates a new EDP ms module entity.
	 */
	public EDPMsModuleEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms module entity.
	 *
	 * @param moduleID the module ID
	 */
	public EDPMsModuleEntity(long moduleID) {
		super();
		this.moduleID = moduleID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(moduleDescription, moduleDescriptionGuj, moduleID, moduleName, moduleNameGuj);
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
		if (!(obj instanceof EDPMsModuleEntity)) {
			return false;
		}
		EDPMsModuleEntity other = (EDPMsModuleEntity) obj;
		return Objects.equals(moduleDescription, other.moduleDescription)
				&& Objects.equals(moduleDescriptionGuj, other.moduleDescriptionGuj) && moduleID == other.moduleID
				&& Objects.equals(moduleName, other.moduleName) && Objects.equals(moduleNameGuj, other.moduleNameGuj);
	}

}
