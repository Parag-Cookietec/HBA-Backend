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
 * The Class EDPMsCountryEntity.
 */
@Entity
@Table(name = "MS_COUNTRY",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsCountryEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The country id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID")
	private Long countryId;

	/** The country name. */
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	/** The country name guj. */
	@Column(name = "COUNTRY_NAME_GUJ")
	private String countryNameGuj;

	/** The country description. */
	@Column(name = "COUNTRY_DESCRIPTION")
	private String countryDescription;

	/** The country description guj. */
	@Column(name = "COUNTRY_DESCRIPTION_GUJ")
	private String countryDescriptionGuj;

	/** The country code. */
	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	/** The country code guj. */
	@Column(name = "COUNTRY_CODE_GUJ")
	private String countryCodeGuj;

	/** The country code name. */
	@Column(name = "COUNTRY_CODE_NAME")
	private String countryCodeName;

	/**
	 * EDPMsCountryEntityDto Constructor.
	 */
	public EDPMsCountryEntity() {
		super();
	}
	
	/**
	 * Instantiates a new EDP ms country entity.
	 *
	 * @param countryId the country id
	 */
	public EDPMsCountryEntity(Long countryId) {
		super();
		this.countryId = countryId;
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
		if (!(obj instanceof EDPMsCountryEntity)) {
			return false;
		}

		EDPMsCountryEntity other = (EDPMsCountryEntity) obj;

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
