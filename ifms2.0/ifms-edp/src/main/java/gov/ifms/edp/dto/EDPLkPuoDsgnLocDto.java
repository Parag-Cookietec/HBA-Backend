package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPuoDsgnLocDto.
 * 
 * @version 1.0
 * @created 2019/12/11 16:14:51
 *
 */
public class EDPLkPuoDsgnLocDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk po off dsgn loc id. */
	private Long lkPoOffDsgnLocId;

	/** The post user office id. */
	private Long postUserOfficeId;

	/** The financial year id. */
	private Long financialYearId;

	/** The designation id. */
	private Long designationId;

	/** The country id. */
	private Long countryId;

	/** The state id. */
	private Long stateId;

	/** The district id. */
	private Long districtId;

	/** The taluka id. */
	private Long talukaId;

	/** The village id. */
	private Long villageId;

	/**
	 * Gets the lk po off dsgn loc id.
	 *
	 * @return the lkPoOffDsgnLocId
	 */
	public Long getLkPoOffDsgnLocId() {
		return lkPoOffDsgnLocId;
	}

	/**
	 * Sets the lk po off dsgn loc id.
	 *
	 * @param lkPoOffDsgnLocId the lkPoOffDsgnLocId to set
	 */
	public void setLkPoOffDsgnLocId(Long lkPoOffDsgnLocId) {
		this.lkPoOffDsgnLocId = lkPoOffDsgnLocId;
	}

	/**
	 * Gets the post user office id.
	 *
	 * @return the postUserOfficeId
	 */
	public Long getPostUserOfficeId() {
		return postUserOfficeId;
	}

	/**
	 * Sets the post user office id.
	 *
	 * @param postUserOfficeId the postUserOfficeId to set
	 */
	public void setPostUserOfficeId(Long postUserOfficeId) {
		this.postUserOfficeId = postUserOfficeId;
	}

	/**
	 * Gets the financial year id.
	 *
	 * @return the financialYearId
	 */
	public Long getFinancialYearId() {
		return financialYearId;
	}

	/**
	 * Sets the financial year id.
	 *
	 * @param financialYearId the financialYearId to set
	 */
	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
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
	 * Gets the district id.
	 *
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
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * Gets the village id.
	 *
	 * @return the villageId
	 */
	public Long getVillageId() {
		return villageId;
	}

	/**
	 * Sets the village id.
	 *
	 * @param villageId the villageId to set
	 */
	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(countryId, designationId, districtId, financialYearId, lkPoOffDsgnLocId, postUserOfficeId,
				stateId, talukaId, villageId);
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
		if (!(obj instanceof EDPLkPuoDsgnLocDto)) {
			return false;
		}
		EDPLkPuoDsgnLocDto other = (EDPLkPuoDsgnLocDto) obj;
		return Objects.equals(countryId, other.countryId) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(districtId, other.districtId)
				&& Objects.equals(financialYearId, other.financialYearId)
				&& Objects.equals(lkPoOffDsgnLocId, other.lkPoOffDsgnLocId)
				&& Objects.equals(postUserOfficeId, other.postUserOfficeId) && Objects.equals(stateId, other.stateId)
				&& Objects.equals(talukaId, other.talukaId) && Objects.equals(villageId, other.villageId);
	}

}
