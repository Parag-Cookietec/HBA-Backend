package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsDistrictDto.
 */
public class EDPMsDistrictDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The district id. */
	private Long districtId;

	/** The district name. */
	private String districtName;

	/** The district name guj. */
	private String districtNameGuj;

	/** The district description. */
	private String districtDescription;

	/** The district description guj. */
	private String districtDescriptionGuj;

	/** The district code. */
	private String districtCode;

	/** The district code guj. */
	private String districtCodeGuj;

	/** The district code name. */
	private String districtCodeName;

	/** The state id. */
	private Integer stateId;

	/**
	 * EDPDistrictNameDto Constructor.
	 */
	public EDPMsDistrictDto() {
		super();
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
		if (!(obj instanceof EDPMsDistrictDto)) {
			return false;
		}

		EDPMsDistrictDto other = (EDPMsDistrictDto) obj;

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
	public Integer getStateId() {
		return stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}
