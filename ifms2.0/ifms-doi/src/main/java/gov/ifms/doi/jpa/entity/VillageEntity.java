package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "MS_VILLAGE", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class VillageEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VILLAGE_ID", updatable = false)
	private Long villageId;

	@Column(name = "VILLAGE_NAME")
	private String villageName;

	@Column(name = "VILLAGE_NAME_GUJ")
	private String villageGuj;

	@Column(name = "VILLAGE_DESC")
	private String villageDesc;

	@Column(name = "VILLAGE_DESC_GUJ")
	private String villageDescGuj;

	@Column(name = "VILLAGE_CODE")
	private String villageCode;

	@Column(name = "VILLAGE_CODE_GUJ")
	private String villageCodeGuj;

	@Column(name = "VILLAGE_CODE_NAME")
	private String villageCodeName;

	@Column(name = "TALUKA_ID")
	private Long talukaId;

	@Column(name = "VILLAGE_DESCRIPTION")
	private String villageDescription;

	@Column(name = "VILLAGE_DESCRIPTION_GUJ")
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
	public String getVillageGuj() {
		return villageGuj;
	}

	/**
	 * @param villageGuj the villageGuj to set
	 */
	public void setVillageGuj(String villageGuj) {
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
	public String getVillageCodeGuj() {
		return villageCodeGuj;
	}

	/**
	 * @param villageCodeGuj the villageCodeGuj to set
	 */
	public void setVillageCodeGuj(String villageCodeGuj) {
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