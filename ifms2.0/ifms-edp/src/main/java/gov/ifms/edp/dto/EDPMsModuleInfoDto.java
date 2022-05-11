package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsModuleInfoDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:19:17
 *
 */
public class EDPMsModuleInfoDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The module info id. */
	private long moduleInfoId;

	/** The module info name. */
	private String moduleInfoName;

	/** The module info name guj. */
	private String moduleInfoNameGuj;

	/** The module info D escription. */
	private String moduleInfoDEscription;

	/** The module info desciption guj. */
	private String moduleInfoDesciptionGuj;

	/** The parent module id. */
	private int parentModuleId;

	/**
	 * Gets the module info id.
	 *
	 * @return the moduleInfoId
	 */
	public long getModuleInfoId() {
		return moduleInfoId;
	}

	/**
	 * Sets the module info id.
	 *
	 * @param moduleInfoId the moduleInfoId to set
	 */
	public void setModuleInfoId(long moduleInfoId) {
		this.moduleInfoId = moduleInfoId;
	}

	/**
	 * Gets the module info name.
	 *
	 * @return the moduleInfoName
	 */
	public String getModuleInfoName() {
		return moduleInfoName;
	}

	/**
	 * Sets the module info name.
	 *
	 * @param moduleInfoName the moduleInfoName to set
	 */
	public void setModuleInfoName(String moduleInfoName) {
		this.moduleInfoName = moduleInfoName;
	}

	/**
	 * Gets the module info name guj.
	 *
	 * @return the moduleInfoNameGuj
	 */
	public String getModuleInfoNameGuj() {
		return moduleInfoNameGuj;
	}

	/**
	 * Sets the module info name guj.
	 *
	 * @param moduleInfoNameGuj the moduleInfoNameGuj to set
	 */
	public void setModuleInfoNameGuj(String moduleInfoNameGuj) {
		this.moduleInfoNameGuj = moduleInfoNameGuj;
	}

	/**
	 * Gets the module info D escription.
	 *
	 * @return the moduleInfoDEscription
	 */
	public String getModuleInfoDEscription() {
		return moduleInfoDEscription;
	}

	/**
	 * Sets the module info D escription.
	 *
	 * @param moduleInfoDEscription the moduleInfoDEscription to set
	 */
	public void setModuleInfoDEscription(String moduleInfoDEscription) {
		this.moduleInfoDEscription = moduleInfoDEscription;
	}

	/**
	 * Gets the module info desciption guj.
	 *
	 * @return the moduleInfoDesciptionGuj
	 */
	public String getModuleInfoDesciptionGuj() {
		return moduleInfoDesciptionGuj;
	}

	/**
	 * Sets the module info desciption guj.
	 *
	 * @param moduleInfoDesciptionGuj the moduleInfoDesciptionGuj to set
	 */
	public void setModuleInfoDesciptionGuj(String moduleInfoDesciptionGuj) {
		this.moduleInfoDesciptionGuj = moduleInfoDesciptionGuj;
	}

	/**
	 * Gets the parent module id.
	 *
	 * @return the parentModuleId
	 */
	public int getParentModuleId() {
		return parentModuleId;
	}

	/**
	 * Sets the parent module id.
	 *
	 * @param parentModuleId the parentModuleId to set
	 */
	public void setParentModuleId(int parentModuleId) {
		this.parentModuleId = parentModuleId;
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
		result = prime * result + Objects.hash(moduleInfoDEscription, moduleInfoDesciptionGuj, moduleInfoId,
				moduleInfoName, moduleInfoNameGuj, parentModuleId);
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
		if (!(obj instanceof EDPMsModuleInfoDto)) {
			return false;
		}
		EDPMsModuleInfoDto other = (EDPMsModuleInfoDto) obj;
		return Objects.equals(moduleInfoDEscription, other.moduleInfoDEscription)
				&& Objects.equals(moduleInfoDesciptionGuj, other.moduleInfoDesciptionGuj)
				&& moduleInfoId == other.moduleInfoId && Objects.equals(moduleInfoName, other.moduleInfoName)
				&& Objects.equals(moduleInfoNameGuj, other.moduleInfoNameGuj) && parentModuleId == other.parentModuleId;
	}

}
