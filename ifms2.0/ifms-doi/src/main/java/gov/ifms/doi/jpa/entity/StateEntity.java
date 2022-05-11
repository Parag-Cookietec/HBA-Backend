package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "MS_STATE", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class StateEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID", updatable = false)
	private Long stateId;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "STATE_NAME_GUJ")
	private Long stateNameGuj;

	@Column(name = "STATE_DESCRIPTION")
	private String stateDescription;

	@Column(name = "STATE_DESCRIPTION_GUJ")
	private String stateDescriptionGuj;

	@Column(name = "STATE_CODE")
	private String stateCode;

	@Column(name = "STATE_CODE_GUJ")
	private String stateCodeGuj;

	@Column(name = "STATE_CODE_NAME")
	private String stateCodeName;

	@Column(name = "COUNTRY_ID")
	private Long countryId;
	
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;

	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the stateNameGuj
	 */
	public Long getStateNameGuj() {
		return stateNameGuj;
	}

	/**
	 * @param stateNameGuj the stateNameGuj to set
	 */
	public void setStateNameGuj(Long stateNameGuj) {
		this.stateNameGuj = stateNameGuj;
	}

	/**
	 * @return the stateDescription
	 */
	public String getStateDescription() {
		return stateDescription;
	}

	/**
	 * @param stateDescription the stateDescription to set
	 */
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	/**
	 * @return the stateDescriptionGuj
	 */
	public String getStateDescriptionGuj() {
		return stateDescriptionGuj;
	}

	/**
	 * @param stateDescriptionGuj the stateDescriptionGuj to set
	 */
	public void setStateDescriptionGuj(String stateDescriptionGuj) {
		this.stateDescriptionGuj = stateDescriptionGuj;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the stateCodeGuj
	 */
	public String getStateCodeGuj() {
		return stateCodeGuj;
	}

	/**
	 * @param stateCodeGuj the stateCodeGuj to set
	 */
	public void setStateCodeGuj(String stateCodeGuj) {
		this.stateCodeGuj = stateCodeGuj;
	}

	/**
	 * @return the stateCodeName
	 */
	public String getStateCodeName() {
		return stateCodeName;
	}

	/**
	 * @param stateCodeName the stateCodeName to set
	 */
	public void setStateCodeName(String stateCodeName) {
		this.stateCodeName = stateCodeName;
	}

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
