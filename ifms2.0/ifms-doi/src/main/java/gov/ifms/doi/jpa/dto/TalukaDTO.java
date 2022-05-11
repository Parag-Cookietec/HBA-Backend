package gov.ifms.doi.jpa.dto;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TalukaDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("value")
	private Long talukaId;

	@JsonProperty("viewValue")
	private String talukaName;

	private String talukaNameGuj;

	private Long talukaDesc;

	private String talukaDescGuj;

	private String talukaCode;

	private String talukaCodeGuj;

	private Date talukaCodeName;

	private Long districtId;

	private String stdCode;

	private String districtCode;

	private Set<VillageDTO> village;

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * @return the talukaNameGuj
	 */
	public String getTalukaNameGuj() {
		return talukaNameGuj;
	}

	/**
	 * @param talukaNameGuj the talukaNameGuj to set
	 */
	public void setTalukaNameGuj(String talukaNameGuj) {
		this.talukaNameGuj = talukaNameGuj;
	}

	/**
	 * @return the talukaDesc
	 */
	public Long getTalukaDesc() {
		return talukaDesc;
	}

	/**
	 * @param talukaDesc the talukaDesc to set
	 */
	public void setTalukaDesc(Long talukaDesc) {
		this.talukaDesc = talukaDesc;
	}

	/**
	 * @return the talukaDescGuj
	 */
	public String getTalukaDescGuj() {
		return talukaDescGuj;
	}

	/**
	 * @param talukaDescGuj the talukaDescGuj to set
	 */
	public void setTalukaDescGuj(String talukaDescGuj) {
		this.talukaDescGuj = talukaDescGuj;
	}

	/**
	 * @return the talukaCode
	 */
	public String getTalukaCode() {
		return talukaCode;
	}

	/**
	 * @param talukaCode the talukaCode to set
	 */
	public void setTalukaCode(String talukaCode) {
		this.talukaCode = talukaCode;
	}

	/**
	 * @return the talukaCodeGuj
	 */
	public String getTalukaCodeGuj() {
		return talukaCodeGuj;
	}

	/**
	 * @param talukaCodeGuj the talukaCodeGuj to set
	 */
	public void setTalukaCodeGuj(String talukaCodeGuj) {
		this.talukaCodeGuj = talukaCodeGuj;
	}

	/**
	 * @return the talukaCodeName
	 */
	public Date getTalukaCodeName() {
		return talukaCodeName;
	}

	/**
	 * @param talukaCodeName the talukaCodeName to set
	 */
	public void setTalukaCodeName(Date talukaCodeName) {
		this.talukaCodeName = talukaCodeName;
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
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * @return the village
	 */
	public Set<VillageDTO> getVillage() {
		return village;
	}

	/**
	 * @param village the village to set
	 */
	public void setVillage(Set<VillageDTO> village) {
		this.village = village;
	}

}
