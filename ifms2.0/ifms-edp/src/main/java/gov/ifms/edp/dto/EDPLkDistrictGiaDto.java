package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkDistrictGiaDto.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 *
 */
public class EDPLkDistrictGiaDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long lkDistrictGiaId;

	private Long districtId;

	private Long isJilla;

	private Long isTaluka;

	private Long isGram;

	private Long isCorporation;

	private Long isMunicipality;

	private Long isNotifiedArea;

	/**
	 * EDPLkDistrictGiaDto Constructor
	 */
	public EDPLkDistrictGiaDto() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkDistrictGiaId, districtId, isJilla, isTaluka, isGram, isCorporation, isMunicipality,
				isNotifiedArea);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPLkDistrictGiaDto)) {
			return false;
		}

		EDPLkDistrictGiaDto other = (EDPLkDistrictGiaDto) obj;

		return Objects.equals(lkDistrictGiaId, other.lkDistrictGiaId) && Objects.equals(districtId, other.districtId)
				&& Objects.equals(isJilla, other.isJilla) && Objects.equals(isTaluka, other.isTaluka)
				&& Objects.equals(isGram, other.isGram) && Objects.equals(isCorporation, other.isCorporation)
				&& Objects.equals(isMunicipality, other.isMunicipality)
				&& Objects.equals(isNotifiedArea, other.isNotifiedArea);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "EDPLkDistrictGiaDto [lkDistrictGiaId = " + lkDistrictGiaId + ",districtId = " + districtId
				+ ",isJilla = " + isJilla + ",isTaluka = " + isTaluka + ",isGram = " + isGram + ",isCorporation = "
				+ isCorporation + ",isMunicipality = " + isMunicipality + ",isNotifiedArea = " + isNotifiedArea + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the lkDistrictGiaId
	 */
	public Long getLkDistrictGiaId() {
		return lkDistrictGiaId;
	}

	/**
	 * @param lkDistrictGiaId the lkDistrictGiaId to set
	 */
	public void setLkDistrictGiaId(Long lkDistrictGiaId) {
		this.lkDistrictGiaId = lkDistrictGiaId;
	}

	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the isJilla
	 */
	public Long getIsJilla() {
		return isJilla;
	}

	/**
	 * @param isJilla the isJilla to set
	 */
	public void setIsJilla(Long isJilla) {
		this.isJilla = isJilla;
	}

	/**
	 * @return the isTaluka
	 */
	public Long getIsTaluka() {
		return isTaluka;
	}

	/**
	 * @param isTaluka the isTaluka to set
	 */
	public void setIsTaluka(Long isTaluka) {
		this.isTaluka = isTaluka;
	}

	/**
	 * @return the isGram
	 */
	public Long getIsGram() {
		return isGram;
	}

	/**
	 * @param isGram the isGram to set
	 */
	public void setIsGram(Long isGram) {
		this.isGram = isGram;
	}

	/**
	 * @return the isCorporation
	 */
	public Long getIsCorporation() {
		return isCorporation;
	}

	/**
	 * @param isCorporation the isCorporation to set
	 */
	public void setIsCorporation(Long isCorporation) {
		this.isCorporation = isCorporation;
	}

	/**
	 * @return the isMunicipality
	 */
	public Long getIsMunicipality() {
		return isMunicipality;
	}

	/**
	 * @param isMunicipality the isMunicipality to set
	 */
	public void setIsMunicipality(Long isMunicipality) {
		this.isMunicipality = isMunicipality;
	}

	/**
	 * @return the isNotifiedArea
	 */
	public Long getIsNotifiedArea() {
		return isNotifiedArea;
	}

	/**
	 * @param isNotifiedArea the isNotifiedArea to set
	 */
	public void setIsNotifiedArea(Long isNotifiedArea) {
		this.isNotifiedArea = isNotifiedArea;
	}

}
