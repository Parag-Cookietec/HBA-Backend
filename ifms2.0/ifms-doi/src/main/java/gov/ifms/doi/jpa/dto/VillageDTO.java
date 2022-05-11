package gov.ifms.doi.jpa.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VillageDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("value")
	private Long villageId;

	@JsonProperty("viewValue")
	private String villageName;

	private Long villageGuj;

	private String villageDesc;

	private String villageDescGuj;

	private String villageCode;

	private Date villageCodeGuj;

	private String villageCodeName;

	private Long talukaId;

	private String villageDescription;

	private String villageDescriptionGuj;

	/**
	 * @return the villageId
	 */
	public Long getVillageId() {
		return villageId;
	}

	/**
	 * @param villageId the villageId to set
	 */
	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	/**
	 * @return the villageName
	 */
	public String getVillageName() {
		return villageName;
	}

	/**
	 * @param villageName the villageName to set
	 */
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	/**
	 * @return the villageGuj
	 */
	public Long getVillageGuj() {
		return villageGuj;
	}

	/**
	 * @param villageGuj the villageGuj to set
	 */
	public void setVillageGuj(Long villageGuj) {
		this.villageGuj = villageGuj;
	}

	/**
	 * @return the villageDesc
	 */
	public String getVillageDesc() {
		return villageDesc;
	}

	/**
	 * @param villageDesc the villageDesc to set
	 */
	public void setVillageDesc(String villageDesc) {
		this.villageDesc = villageDesc;
	}

	/**
	 * @return the villageDescGuj
	 */
	public String getVillageDescGuj() {
		return villageDescGuj;
	}

	/**
	 * @param villageDescGuj the villageDescGuj to set
	 */
	public void setVillageDescGuj(String villageDescGuj) {
		this.villageDescGuj = villageDescGuj;
	}

	/**
	 * @return the villageCode
	 */
	public String getVillageCode() {
		return villageCode;
	}

	/**
	 * @param villageCode the villageCode to set
	 */
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	/**
	 * @return the villageCodeGuj
	 */
	public Date getVillageCodeGuj() {
		return villageCodeGuj;
	}

	/**
	 * @param villageCodeGuj the villageCodeGuj to set
	 */
	public void setVillageCodeGuj(Date villageCodeGuj) {
		this.villageCodeGuj = villageCodeGuj;
	}

	/**
	 * @return the villageCodeName
	 */
	public String getVillageCodeName() {
		return villageCodeName;
	}

	/**
	 * @param villageCodeName the villageCodeName to set
	 */
	public void setVillageCodeName(String villageCodeName) {
		this.villageCodeName = villageCodeName;
	}

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
	 * @return the villageDescription
	 */
	public String getVillageDescription() {
		return villageDescription;
	}

	/**
	 * @param villageDescription the villageDescription to set
	 */
	public void setVillageDescription(String villageDescription) {
		this.villageDescription = villageDescription;
	}

	/**
	 * @return the villageDescriptionGuj
	 */
	public String getVillageDescriptionGuj() {
		return villageDescriptionGuj;
	}

	/**
	 * @param villageDescriptionGuj the villageDescriptionGuj to set
	 */
	public void setVillageDescriptionGuj(String villageDescriptionGuj) {
		this.villageDescriptionGuj = villageDescriptionGuj;
	}

}