package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsStateEntity.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:14:49
 *
 */
@Entity
@Table(name = "MS_STATE",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsStateEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID")
	private Long stateId;

	/** The state name. */
	@Column(name = "STATE_NAME")
	private String stateName;

	/** The state name guj. */
	@Column(name = "STATE_NAME_GUJ")
	private String stateNameGuj;

	/** The state description. */
	@Column(name = "STATE_DESCRIPTION")
	private String stateDescription;
	
	/** The state description guj. */
	@Column(name = "STATE_DESCRIPTION_GUJ")
	private String stateDescriptionGuj;

	/** The state code. */
	@Column(name = "STATE_CODE")
	private String stateCode;

	/** The state code guj. */
	@Column(name = "STATE_CODE_GUJ")
	private String stateCodeGuj;

	/** The state code name. */
	@Column(name = "STATE_CODE_NAME")
	private String stateCodeName;

	/** The country id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "COUNTRY_ID",referencedColumnName = "COUNTRY_ID")
	private EDPMsCountryEntity countryId;

	/**
	 * EDPEDPMsStateEntity Constructor.
	 */
	public EDPMsStateEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms state entity.
	 *
	 * @param stateId the state id
	 */
	public EDPMsStateEntity(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * getter setter.
	 *
	 * @return the state id
	 */

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
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
	public EDPMsCountryEntity getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId the countryId to set
	 */
	public void setCountryId(EDPMsCountryEntity countryId) {
		this.countryId = countryId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(countryId, stateCode, stateCodeGuj, stateCodeName, stateDescription, stateDescriptionGuj,
				stateId, stateName, stateNameGuj);
	}

	/**
	 * Equals.
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
		if (!(obj instanceof EDPMsStateEntity)) {
			return false;
		}
		EDPMsStateEntity other = (EDPMsStateEntity) obj;
		return Objects.equals(countryId, other.countryId) && Objects.equals(stateCode, other.stateCode)
				&& Objects.equals(stateCodeGuj, other.stateCodeGuj)
				&& Objects.equals(stateCodeName, other.stateCodeName)
				&& Objects.equals(stateDescription, other.stateDescription)
				&& Objects.equals(stateDescriptionGuj, other.stateDescriptionGuj)
				&& Objects.equals(stateId, other.stateId) && Objects.equals(stateName, other.stateName)
				&& Objects.equals(stateNameGuj, other.stateNameGuj);
	}

	
}
