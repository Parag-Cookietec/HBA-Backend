package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * The Class EDPMsStateDto.
 *
 * @version v 1.0
 * @created 2019/12/10 18:14:49
 */
public class EDPMsStateDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state id. */
	@NotNull
	private long stateId;

	/** The state name. */
	private String stateName;

	/** The state name guj. */
	private String stateNameGuj;

	/** The state description. */
	private String stateDescription;
	
	/** The state description guj. */
	private String stateDescriptionGuj;

	/** The state code. */
	private String stateCode;

	/** The state code guj. */
	private String stateCodeGuj;

	/** The state code name. */
	private String stateCodeName;

	/** The country id. */
	private Long countryId;


	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(stateId, stateId, stateName, stateNameGuj, stateDescription, stateCode, stateCodeGuj,
				stateCodeName);
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
		if (!(obj instanceof EDPMsStateDto)) {
			return false;
		}

		EDPMsStateDto other = (EDPMsStateDto) obj;

		return stateId == other.stateId && Objects.equals(stateName, other.stateName)
				&& Objects.equals(stateNameGuj, other.stateNameGuj)
				&& Objects.equals(stateDescription, other.stateDescription)
				&& Objects.equals(stateCode, other.stateCode) && Objects.equals(stateCodeGuj, other.stateCodeGuj)
				&& Objects.equals(stateCodeName, other.stateCodeName) ;
	}

	/**
	 * Gets the state id.
	 *
	 * @return the stateId
	 */
	public long getStateId() {
		return stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId the stateId to set
	 */
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Sets the state name.
	 *
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Gets the state name guj.
	 *
	 * @return the stateNameGuj
	 */
	public String getStateNameGuj() {
		return stateNameGuj;
	}

	/**
	 * Sets the state name guj.
	 *
	 * @param stateNameGuj the stateNameGuj to set
	 */
	public void setStateNameGuj(String stateNameGuj) {
		this.stateNameGuj = stateNameGuj;
	}

	/**
	 * Gets the state description.
	 *
	 * @return the stateDescription
	 */
	public String getStateDescription() {
		return stateDescription;
	}

	/**
	 * Sets the state description.
	 *
	 * @param stateDescription the stateDescription to set
	 */
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	/**
	 * Gets the state code.
	 *
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Sets the state code.
	 *
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Gets the state code guj.
	 *
	 * @return the stateCodeGuj
	 */
	public String getStateCodeGuj() {
		return stateCodeGuj;
	}

	/**
	 * Sets the state code guj.
	 *
	 * @param stateCodeGuj the stateCodeGuj to set
	 */
	public void setStateCodeGuj(String stateCodeGuj) {
		this.stateCodeGuj = stateCodeGuj;
	}

	/**
	 * Gets the state code name.
	 *
	 * @return the stateCodeName
	 */
	public String getStateCodeName() {
		return stateCodeName;
	}

	/**
	 * Sets the state code name.
	 *
	 * @param stateCodeName the stateCodeName to set
	 */
	public void setStateCodeName(String stateCodeName) {
		this.stateCodeName = stateCodeName;
	}
	
	/**
	 * Gets the state description guj.
	 *
	 * @return the stateDescriptionGuj
	 */
	public String getStateDescriptionGuj() {
		return stateDescriptionGuj;
	}

	/**
	 * Sets the state description guj.
	 *
	 * @param stateDescriptionGuj the stateDescriptionGuj to set
	 */
	public void setStateDescriptionGuj(String stateDescriptionGuj) {
		this.stateDescriptionGuj = stateDescriptionGuj;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

}
