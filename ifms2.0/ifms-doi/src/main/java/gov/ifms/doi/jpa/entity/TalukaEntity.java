package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "MS_TALUKA", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class TalukaEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TALUKA_ID", updatable = false)
	private Long talukaId;

	@Column(name = "TALUKA_NAME")
	private String talukaName;

	@Column(name = "TALUKA_NAME_GUJ")
	private String talukaNameGuj;

	@Column(name = "TALUKA_DESC")
	private String talukaDesc;

	@Column(name = "TALUKA_DESC_GUJ")
	private String talukaDescGuj;

	@Column(name = "TALUKA_CODE")
	private String talukaCode;

	@Column(name = "TALUKA_CODE_GUJ")
	private String talukaCodeGuj;

	@Column(name = "TALUKA_CODE_NAME")
	private String talukaCodeName;

	@Column(name = "DISTRICT_ID")
	private Long districtId;

	@Column(name = "STD_CODE")
	private String stdCode;

	@Column(name = "DISTRICT_CODE")
	private String districtCode;

	/*
	 * @OneToMany(fetch = FetchType.EAGER, mappedBy = "talukaId", cascade =
	 * CascadeType.ALL) private List<VillageEntity> village;
	 */

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
	public String getTalukaDesc() {
		return talukaDesc;
	}

	/**
	 * @param talukaDesc the talukaDesc to set
	 */
	public void setTalukaDesc(String talukaDesc) {
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
	public String getTalukaCodeName() {
		return talukaCodeName;
	}

	/**
	 * @param talukaCodeName the talukaCodeName to set
	 */
	public void setTalukaCodeName(String talukaCodeName) {
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
	/*
	 * public List<VillageEntity> getVillage() { return village; }
	 * 
	 *//**
		 * @param village the village to set
		 *//*
			 * public void setVillage(List<VillageEntity> village) { this.village = village;
			 * }
			 */

}
