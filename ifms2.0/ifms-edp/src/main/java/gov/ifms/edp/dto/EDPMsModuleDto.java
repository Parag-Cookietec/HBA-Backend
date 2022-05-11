package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsModuleDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:17:15
 *
 */
public class EDPMsModuleDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The module ID. */
	private long moduleID;

	/** The module name. */
	private String moduleName;

	/** The module name guj. */
	private String moduleNameGuj;

	/** The module description. */
	private String moduleDescription;

	/** The module description guj. */
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(moduleDescription, moduleDescriptionGuj, moduleID, moduleName, moduleNameGuj);
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
		if (!(obj instanceof EDPMsModuleDto)) {
			return false;
		}
		EDPMsModuleDto other = (EDPMsModuleDto) obj;
		return Objects.equals(moduleDescription, other.moduleDescription)
				&& Objects.equals(moduleDescriptionGuj, other.moduleDescriptionGuj) && moduleID == other.moduleID
				&& Objects.equals(moduleName, other.moduleName) && Objects.equals(moduleNameGuj, other.moduleNameGuj);
	}
	
}
