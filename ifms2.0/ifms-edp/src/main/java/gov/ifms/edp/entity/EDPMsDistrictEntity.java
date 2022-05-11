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
 * The Class EDPMsDistrictEntity.
 */
@Entity
@Table(name = "MS_DISTRICT",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsDistrictEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The district id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRICT_ID ")
	private Long districtId;

	/** The district name. */
	@Column(name = "DISTRICT_NAME")
	private String districtName;

	/** The district name guj. */
	@Column(name = "DISTRICT_NAME_GUJ")
	private String districtNameGuj;

	/** The district description. */
	@Column(name = "DISTRICT_DESC")
	private String districtDescription;

	/** The district description guj. */
	@Column(name = "DISTRICT_DESC_GUJ")
	private String districtDescriptionGuj;

	/** The district code. */
	@Column(name = "DISTRICT_CODE")
	private String districtCode;

	/** The district code guj. */
	@Column(name = "DISTRICT_CODE_GUJ")
	private String districtCodeGuj;

	/** The district code name. */
	@Column(name = "DISTRICT_CODE_NAME")
	private String districtCodeName;

	/** The state id. */
	@Column(name = "STATE_ID")
	private Long stateId;
	
	/** The std code. */
	@Column(name = "STD_CODE")
	private String stdCode;

	/**
	 * EDPDistrictNameDto Constructor.
	 */
	public EDPMsDistrictEntity() {
		super();
	}
	
	/**
	 * Instantiates a new EDP ms district entity.
	 *
	 * @param districtId the district id
	 */
	public EDPMsDistrictEntity(long districtId) {
		super();
		this.districtId = districtId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(districtId, districtName, districtNameGuj, districtDescription, districtDescriptionGuj,
				districtCode, districtCodeGuj, districtCodeName, stateId);
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
		if (!(obj instanceof EDPMsDistrictEntity)) {
			return false;
		}

		EDPMsDistrictEntity other = (EDPMsDistrictEntity) obj;

		return Objects.equals(districtId, other.districtId) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(districtNameGuj, other.districtNameGuj)
				&& Objects.equals(districtDescription, other.districtDescription)
				&& Objects.equals(districtDescriptionGuj, other.districtDescriptionGuj)
				&& Objects.equals(districtCode, other.districtCode)
				&& Objects.equals(districtCodeGuj, other.districtCodeGuj)
				&& Objects.equals(districtCodeName, other.districtCodeName) && Objects.equals(stateId, other.stateId);
	}

	/**
	 * getter setter.
	 *
	 * @return the district id
	 */

	/**
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

	/**
	 * Gets the district name.
	 *
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the district name guj.
	 *
	 * @return the districtNameGuj
	 */
	public String getDistrictNameGuj() {
		return districtNameGuj;
	}

	/**
	 * Sets the district name guj.
	 *
	 * @param districtNameGuj the districtNameGuj to set
	 */
	public void setDistrictNameGuj(String districtNameGuj) {
		this.districtNameGuj = districtNameGuj;
	}

	/**
	 * Gets the district description.
	 *
	 * @return the districtDescription
	 */
	public String getDistrictDescription() {
		return districtDescription;
	}

	/**
	 * Sets the district description.
	 *
	 * @param districtDescription the districtDescription to set
	 */
	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}

	/**
	 * Gets the district description guj.
	 *
	 * @return the districtDescriptionGuj
	 */
	public String getDistrictDescriptionGuj() {
		return districtDescriptionGuj;
	}

	/**
	 * Sets the district description guj.
	 *
	 * @param districtDescriptionGuj the districtDescriptionGuj to set
	 */
	public void setDistrictDescriptionGuj(String districtDescriptionGuj) {
		this.districtDescriptionGuj = districtDescriptionGuj;
	}

	/**
	 * Gets the district code.
	 *
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * Sets the district code.
	 *
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * Gets the district code guj.
	 *
	 * @return the districtCodeGuj
	 */
	public String getDistrictCodeGuj() {
		return districtCodeGuj;
	}

	/**
	 * Sets the district code guj.
	 *
	 * @param districtCodeGuj the districtCodeGuj to set
	 */
	public void setDistrictCodeGuj(String districtCodeGuj) {
		this.districtCodeGuj = districtCodeGuj;
	}

	/**
	 * Gets the district code name.
	 *
	 * @return the districtCodeName
	 */
	public String getDistrictCodeName() {
		return districtCodeName;
	}

	/**
	 * Sets the district code name.
	 *
	 * @param districtCodeName the districtCodeName to set
	 */
	public void setDistrictCodeName(String districtCodeName) {
		this.districtCodeName = districtCodeName;
	}

	/**
	 * Gets the state id.
	 *
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
	 * Gets the std code.
	 *
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * Sets the std code.
	 *
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

}
