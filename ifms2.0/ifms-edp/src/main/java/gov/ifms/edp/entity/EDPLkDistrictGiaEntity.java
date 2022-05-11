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
 * The Class EDPLkDistrictGiaEntity.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 *
 */
@Entity
@Table(name = "LK_DISTRICT_GIA", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkDistrictGiaEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk district gia id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_DISTRICT_GIA_ID")
	private Long lkDistrictGiaId;

	/** The district id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	/** The is jilla. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_JILLA", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isJilla;

	/** The is taluka. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_TALUKA", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isTaluka;

	/** The is gram. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_GRAM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isGram;

	/** The is corporation. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_CORPORATION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isCorporation;

	/** The is municipality. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_MUNICIPALITY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isMunicipality;

	/** The is notified area. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_NOTIFIED_AREA", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isNotifiedArea;

	/**
	 * EDPLkDistrictGiaEntity Constructor.
	 */
	public EDPLkDistrictGiaEntity() {
		super();
	}

	/**
	 * Gets the lk district gia id.
	 *
	 * @return the lk district gia id
	 */
	public Long getLkDistrictGiaId() {
		return lkDistrictGiaId;
	}

	/**
	 * Sets the lk district gia id.
	 *
	 * @param lkDistrictGiaId the new lk district gia id
	 */
	public void setLkDistrictGiaId(Long lkDistrictGiaId) {
		this.lkDistrictGiaId = lkDistrictGiaId;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public EDPMsDistrictEntity getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(EDPMsDistrictEntity districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the checks if is jilla.
	 *
	 * @return the checks if is jilla
	 */
	public EDPLuLookUpInfoEntity getIsJilla() {
		return isJilla;
	}

	/**
	 * Sets the checks if is jilla.
	 *
	 * @param isJilla the new checks if is jilla
	 */
	public void setIsJilla(EDPLuLookUpInfoEntity isJilla) {
		this.isJilla = isJilla;
	}

	/**
	 * Gets the checks if is taluka.
	 *
	 * @return the checks if is taluka
	 */
	public EDPLuLookUpInfoEntity getIsTaluka() {
		return isTaluka;
	}

	/**
	 * Sets the checks if is taluka.
	 *
	 * @param isTaluka the new checks if is taluka
	 */
	public void setIsTaluka(EDPLuLookUpInfoEntity isTaluka) {
		this.isTaluka = isTaluka;
	}

	/**
	 * Gets the checks if is gram.
	 *
	 * @return the checks if is gram
	 */
	public EDPLuLookUpInfoEntity getIsGram() {
		return isGram;
	}

	/**
	 * Sets the checks if is gram.
	 *
	 * @param isGram the new checks if is gram
	 */
	public void setIsGram(EDPLuLookUpInfoEntity isGram) {
		this.isGram = isGram;
	}

	/**
	 * Gets the checks if is corporation.
	 *
	 * @return the checks if is corporation
	 */
	public EDPLuLookUpInfoEntity getIsCorporation() {
		return isCorporation;
	}

	/**
	 * Sets the checks if is corporation.
	 *
	 * @param isCorporation the new checks if is corporation
	 */
	public void setIsCorporation(EDPLuLookUpInfoEntity isCorporation) {
		this.isCorporation = isCorporation;
	}

	/**
	 * Gets the checks if is municipality.
	 *
	 * @return the checks if is municipality
	 */
	public EDPLuLookUpInfoEntity getIsMunicipality() {
		return isMunicipality;
	}

	/**
	 * Sets the checks if is municipality.
	 *
	 * @param isMunicipality the new checks if is municipality
	 */
	public void setIsMunicipality(EDPLuLookUpInfoEntity isMunicipality) {
		this.isMunicipality = isMunicipality;
	}

	/**
	 * Gets the checks if is notified area.
	 *
	 * @return the checks if is notified area
	 */
	public EDPLuLookUpInfoEntity getIsNotifiedArea() {
		return isNotifiedArea;
	}

	/**
	 * Sets the checks if is notified area.
	 *
	 * @param isNotifiedArea the new checks if is notified area
	 */
	public void setIsNotifiedArea(EDPLuLookUpInfoEntity isNotifiedArea) {
		this.isNotifiedArea = isNotifiedArea;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(districtId, isCorporation, isGram, isJilla, isMunicipality, isNotifiedArea, isTaluka,
				lkDistrictGiaId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPLkDistrictGiaEntity other = (EDPLkDistrictGiaEntity) obj;
		return Objects.equals(districtId, other.districtId) && Objects.equals(isCorporation, other.isCorporation)
				&& Objects.equals(isGram, other.isGram) && Objects.equals(isJilla, other.isJilla)
				&& Objects.equals(isMunicipality, other.isMunicipality)
				&& Objects.equals(isNotifiedArea, other.isNotifiedArea) && Objects.equals(isTaluka, other.isTaluka)
				&& Objects.equals(lkDistrictGiaId, other.lkDistrictGiaId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPLkDistrictGiaEntity [lkDistrictGiaId=" + lkDistrictGiaId + ", districtId=" + districtId
				+ ", isJilla=" + isJilla + ", isTaluka=" + isTaluka + ", isGram=" + isGram + ", isCorporation="
				+ isCorporation + ", isMunicipality=" + isMunicipality + ", isNotifiedArea=" + isNotifiedArea + "]";
	}

}
