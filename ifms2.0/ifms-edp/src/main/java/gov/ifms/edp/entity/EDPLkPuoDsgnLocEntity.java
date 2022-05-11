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
 * The Class EDPLkPuoDsgnLocEntity.
 * 
 * @version 1.0
 * @created 2019/12/11 16:14:51
 *
 */
@Entity
@Table(name = "LK_PO_OFF_DSGN_LOC",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPuoDsgnLocEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_PO_OFF_DSGN_LOC_ID")
	private Long lkPoOffDsgnLocId;

	@Column(name = "POST_USER_OFFICE_ID")
	private Long postUserOfficeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FINANCIAL_YEAR_ID", referencedColumnName = "FINANCIAL_YEAR_ID")
	private EDPMsFinancialYearEntity financialYearId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
	private EDPMsCountryEntity countryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
	private EDPMsStateEntity stateId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUKA_ID", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity talukaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID", referencedColumnName = "VILLAGE_ID")
	private EDPMsVillageEntity villageId;

	/**
	 * EDPLkPuoDsgnLocDto Constructor
	 */
	public EDPLkPuoDsgnLocEntity() {
		super();
	}

	/**
	 * @return the lkPoOffDsgnLocId
	 */
	public Long getLkPoOffDsgnLocId() {
		return lkPoOffDsgnLocId;
	}

	/**
	 * @param lkPoOffDsgnLocId the lkPoOffDsgnLocId to set
	 */
	public void setLkPoOffDsgnLocId(Long lkPoOffDsgnLocId) {
		this.lkPoOffDsgnLocId = lkPoOffDsgnLocId;
	}

	/**
	 * @return the postUserOfficeId
	 */
	public Long getPostUserOfficeId() {
		return postUserOfficeId;
	}

	/**
	 * @param postUserOfficeId the postUserOfficeId to set
	 */
	public void setPostUserOfficeId(Long postUserOfficeId) {
		this.postUserOfficeId = postUserOfficeId;
	}

	/**
	 * @return the financialYearId
	 */
	public EDPMsFinancialYearEntity getFinancialYearId() {
		return financialYearId;
	}

	/**
	 * @param financialYearId the financialYearId to set
	 */
	public void setFinancialYearId(EDPMsFinancialYearEntity financialYearId) {
		this.financialYearId = financialYearId;
	}

	/**
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * @return the countryId
	 */
	public EDPMsCountryEntity getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(EDPMsCountryEntity countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the stateId
	 */
	public EDPMsStateEntity getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(EDPMsStateEntity stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the districtId
	 */
	public EDPMsDistrictEntity getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(EDPMsDistrictEntity districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the talukaId
	 */
	public EDPMsTalukaEntity getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(EDPMsTalukaEntity talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the villageId
	 */
	public EDPMsVillageEntity getVillageId() {
		return villageId;
	}

	/**
	 * @param villageId the villageId to set
	 */
	public void setVillageId(EDPMsVillageEntity villageId) {
		this.villageId = villageId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId, designationId, districtId, financialYearId, lkPoOffDsgnLocId, postUserOfficeId,
				stateId, talukaId, villageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPLkPuoDsgnLocEntity)) {
			return false;
		}
		EDPLkPuoDsgnLocEntity other = (EDPLkPuoDsgnLocEntity) obj;
		return Objects.equals(countryId, other.countryId) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(districtId, other.districtId)
				&& Objects.equals(financialYearId, other.financialYearId)
				&& Objects.equals(lkPoOffDsgnLocId, other.lkPoOffDsgnLocId)
				&& Objects.equals(postUserOfficeId, other.postUserOfficeId) && Objects.equals(stateId, other.stateId)
				&& Objects.equals(talukaId, other.talukaId) && Objects.equals(villageId, other.villageId);
	}

}
