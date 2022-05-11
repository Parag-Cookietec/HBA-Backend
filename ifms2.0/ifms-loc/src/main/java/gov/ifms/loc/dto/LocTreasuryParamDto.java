package gov.ifms.loc.dto;

import javax.validation.constraints.NotNull;

/**
 * The Class LocTreasuryParamDto.
 */
public class LocTreasuryParamDto {

	/** The district id. */
	@NotNull
	private Long districtId;

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

}
