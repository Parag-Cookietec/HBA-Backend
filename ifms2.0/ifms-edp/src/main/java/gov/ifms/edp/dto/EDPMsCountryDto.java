package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsCountryDto.
 */
public class EDPMsCountryDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The country id. */
	private Long countryId;

	/** The country name. */
	private String countryName;

	/** The country name guj. */
	private String countryNameGuj;

	/** The country description. */
	private String countryDescription;

	/** The country description guj. */
	private String countryDescriptionGuj;

	/** The country code. */
	private String countryCode;

	/** The country code guj. */
	private String countryCodeGuj;

	/** The country code name. */
	private String countryCodeName;

	/**
	 * EDPMsCountryEntityDto Constructor.
	 */
	public EDPMsCountryDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(countryId, countryName, countryNameGuj, countryDescription, countryDescriptionGuj,
				countryCode, countryCodeGuj, countryCodeName);
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
		if (!(obj instanceof EDPMsCountryDto)) {
			return false;
		}

		EDPMsCountryDto other = (EDPMsCountryDto) obj;

		return Objects.equals(countryId, other.countryId) && Objects.equals(countryName, other.countryName)
				&& Objects.equals(countryNameGuj, other.countryNameGuj)
				&& Objects.equals(countryDescription, other.countryDescription)
				&& Objects.equals(countryDescriptionGuj, other.countryDescriptionGuj)
				&& Objects.equals(countryCode, other.countryCode)
				&& Objects.equals(countryCodeGuj, other.countryCodeGuj)
				&& Objects.equals(countryCodeName, other.countryCodeName);
	}

	/**
	 * getter setter.
	 *
	 * @return the country id
	 */

	/**
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

	/**
	 * Gets the country name.
	 *
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Sets the country name.
	 *
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Gets the country name guj.
	 *
	 * @return the countryNameGuj
	 */
	public String getCountryNameGuj() {
		return countryNameGuj;
	}

	/**
	 * Sets the country name guj.
	 *
	 * @param countryNameGuj the countryNameGuj to set
	 */
	public void setCountryNameGuj(String countryNameGuj) {
		this.countryNameGuj = countryNameGuj;
	}

	/**
	 * Gets the country description.
	 *
	 * @return the countryDescription
	 */
	public String getCountryDescription() {
		return countryDescription;
	}

	/**
	 * Sets the country description.
	 *
	 * @param countryDescription the countryDescription to set
	 */
	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}

	/**
	 * Gets the country description guj.
	 *
	 * @return the countryDescriptionGuj
	 */
	public String getCountryDescriptionGuj() {
		return countryDescriptionGuj;
	}

	/**
	 * Sets the country description guj.
	 *
	 * @param countryDescriptionGuj the countryDescriptionGuj to set
	 */
	public void setCountryDescriptionGuj(String countryDescriptionGuj) {
		this.countryDescriptionGuj = countryDescriptionGuj;
	}

	/**
	 * Gets the country code.
	 *
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code.
	 *
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Gets the country code guj.
	 *
	 * @return the countryCodeGuj
	 */
	public String getCountryCodeGuj() {
		return countryCodeGuj;
	}

	/**
	 * Sets the country code guj.
	 *
	 * @param countryCodeGuj the countryCodeGuj to set
	 */
	public void setCountryCodeGuj(String countryCodeGuj) {
		this.countryCodeGuj = countryCodeGuj;
	}

	/**
	 * Gets the country code name.
	 *
	 * @return the countryCodeName
	 */
	public String getCountryCodeName() {
		return countryCodeName;
	}

	/**
	 * Sets the country code name.
	 *
	 * @param countryCodeName the countryCodeName to set
	 */
	public void setCountryCodeName(String countryCodeName) {
		this.countryCodeName = countryCodeName;
	}

}
