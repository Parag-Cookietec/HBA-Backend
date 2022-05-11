package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsSubModuleDto.
 */
public class EDPMsSubModuleDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub module id. */
	private long subModuleId;

	/** The sub module name. */
	private String subModuleName;

	/** The sub module name guj. */
	private String subModuleNameGuj;

	/** The sub module desc. */
	private String subModuleDesc;

	/** The sub moduile desc guj. */
	private String subModuileDescGuj;

	/**
	 * Gets the sub module id.
	 *
	 * @return the subModuleId
	 */
	public long getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the subModuleId to set
	 */
	public void setSubModuleId(long subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Gets the sub module name.
	 *
	 * @return the subModuleName
	 */
	public String getSubModuleName() {
		return subModuleName;
	}

	/**
	 * Sets the sub module name.
	 *
	 * @param subModuleName the subModuleName to set
	 */
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	/**
	 * Gets the sub module name guj.
	 *
	 * @return the subModuleNameGuj
	 */
	public String getSubModuleNameGuj() {
		return subModuleNameGuj;
	}

	/**
	 * Sets the sub module name guj.
	 *
	 * @param subModuleNameGuj the subModuleNameGuj to set
	 */
	public void setSubModuleNameGuj(String subModuleNameGuj) {
		this.subModuleNameGuj = subModuleNameGuj;
	}

	/**
	 * Gets the sub module desc.
	 *
	 * @return the subModuleDesc
	 */
	public String getSubModuleDesc() {
		return subModuleDesc;
	}

	/**
	 * Sets the sub module desc.
	 *
	 * @param subModuleDesc the subModuleDesc to set
	 */
	public void setSubModuleDesc(String subModuleDesc) {
		this.subModuleDesc = subModuleDesc;
	}

	/**
	 * Gets the sub moduile desc guj.
	 *
	 * @return the subModuileDescGuj
	 */
	public String getSubModuileDescGuj() {
		return subModuileDescGuj;
	}

	/**
	 * Sets the sub moduile desc guj.
	 *
	 * @param subModuileDescGuj the subModuileDescGuj to set
	 */
	public void setSubModuileDescGuj(String subModuileDescGuj) {
		this.subModuileDescGuj = subModuileDescGuj;
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
		return Objects.hash(subModuileDescGuj, subModuleDesc, subModuleId, subModuleName, subModuleNameGuj);
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
		EDPMsSubModuleDto other = (EDPMsSubModuleDto) obj;
		return Objects.equals(subModuileDescGuj, other.subModuileDescGuj)
				&& Objects.equals(subModuleDesc, other.subModuleDesc) && subModuleId == other.subModuleId
				&& Objects.equals(subModuleName, other.subModuleName)
				&& Objects.equals(subModuleNameGuj, other.subModuleNameGuj);
	}

}
