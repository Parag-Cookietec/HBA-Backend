package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsTreasuryDto.
 * 
 * @version 1.0
 * @created 2019/12/11 14:53:04
 *
 */
public class EDPMsTreasuryDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The treasury id. */
	private Long treasuryId;

	/** The treasury name. */
	private String treasuryName;

	/** The treasury name guj. */
	private String treasuryNameGuj;

	/** The treasury description. */
	private String treasuryDescription;

	/** The treasury description guj. */
	private String treasuryDescriptionGuj;

	/** The treasury code. */
	private String treasuryCode;

	/** The treasury code guj. */
	private String treasuryCodeGuj;

	/** The treasury code name. */
	private String treasuryCodeName;

	/** The district id. */
	private Long districtId;

	/**
	 * EDPMsTreasuryDto Constructor.
	 */
	public EDPMsTreasuryDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(treasuryId, treasuryName, treasuryNameGuj, treasuryDescription, treasuryDescriptionGuj,
				treasuryCode, treasuryCodeGuj, treasuryCodeName, districtId);
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
		if (!(obj instanceof EDPMsTreasuryDto)) {
			return false;
		}

		EDPMsTreasuryDto other = (EDPMsTreasuryDto) obj;

		return Objects.equals(treasuryId, other.treasuryId) && Objects.equals(treasuryName, other.treasuryName)
				&& Objects.equals(treasuryNameGuj, other.treasuryNameGuj)
				&& Objects.equals(treasuryDescription, other.treasuryDescription)
				&& Objects.equals(treasuryDescriptionGuj, other.treasuryDescriptionGuj)
				&& Objects.equals(treasuryCode, other.treasuryCode)
				&& Objects.equals(treasuryCodeGuj, other.treasuryCodeGuj)
				&& Objects.equals(treasuryCodeName, other.treasuryCodeName)
				&& Objects.equals(districtId, other.districtId);
	}

	/**
	 * getter setter.
	 *
	 * @return the treasury id
	 */

	/**
	 * @return the treasuryId
	 */
	public Long getTreasuryId() {
		return treasuryId;
	}

	/**
	 * Sets the treasury id.
	 *
	 * @param treasuryId the treasuryId to set
	 */
	public void setTreasuryId(Long treasuryId) {
		this.treasuryId = treasuryId;
	}

	/**
	 * Gets the treasury name.
	 *
	 * @return the treasuryName
	 */
	public String getTreasuryName() {
		return treasuryName;
	}

	/**
	 * Sets the treasury name.
	 *
	 * @param treasuryName the treasuryName to set
	 */
	public void setTreasuryName(String treasuryName) {
		this.treasuryName = treasuryName;
	}

	/**
	 * Gets the treasury name guj.
	 *
	 * @return the treasuryNameGuj
	 */
	public String getTreasuryNameGuj() {
		return treasuryNameGuj;
	}

	/**
	 * Sets the treasury name guj.
	 *
	 * @param treasuryNameGuj the treasuryNameGuj to set
	 */
	public void setTreasuryNameGuj(String treasuryNameGuj) {
		this.treasuryNameGuj = treasuryNameGuj;
	}

	/**
	 * Gets the treasury description.
	 *
	 * @return the treasuryDescription
	 */
	public String getTreasuryDescription() {
		return treasuryDescription;
	}

	/**
	 * Sets the treasury description.
	 *
	 * @param treasuryDescription the treasuryDescription to set
	 */
	public void setTreasuryDescription(String treasuryDescription) {
		this.treasuryDescription = treasuryDescription;
	}

	/**
	 * Gets the treasury description guj.
	 *
	 * @return the treasuryDescriptionGuj
	 */
	public String getTreasuryDescriptionGuj() {
		return treasuryDescriptionGuj;
	}

	/**
	 * Sets the treasury description guj.
	 *
	 * @param treasuryDescriptionGuj the treasuryDescriptionGuj to set
	 */
	public void setTreasuryDescriptionGuj(String treasuryDescriptionGuj) {
		this.treasuryDescriptionGuj = treasuryDescriptionGuj;
	}

	/**
	 * Gets the treasury code.
	 *
	 * @return the treasuryCode
	 */
	public String getTreasuryCode() {
		return treasuryCode;
	}

	/**
	 * Sets the treasury code.
	 *
	 * @param treasuryCode the treasuryCode to set
	 */
	public void setTreasuryCode(String treasuryCode) {
		this.treasuryCode = treasuryCode;
	}

	/**
	 * Gets the treasury code guj.
	 *
	 * @return the treasuryCodeGuj
	 */
	public String getTreasuryCodeGuj() {
		return treasuryCodeGuj;
	}

	/**
	 * Sets the treasury code guj.
	 *
	 * @param treasuryCodeGuj the treasuryCodeGuj to set
	 */
	public void setTreasuryCodeGuj(String treasuryCodeGuj) {
		this.treasuryCodeGuj = treasuryCodeGuj;
	}

	/**
	 * Gets the treasury code name.
	 *
	 * @return the treasuryCodeName
	 */
	public String getTreasuryCodeName() {
		return treasuryCodeName;
	}

	/**
	 * Sets the treasury code name.
	 *
	 * @param treasuryCodeName the treasuryCodeName to set
	 */
	public void setTreasuryCodeName(String treasuryCodeName) {
		this.treasuryCodeName = treasuryCodeName;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

}
