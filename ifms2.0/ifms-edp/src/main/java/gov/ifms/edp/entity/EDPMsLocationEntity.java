package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
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
 * The Class EDPMsLocationEntity.
 */
@Entity
@Table(name = "MS_LOCATION", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsLocationEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The location id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private long locationId;

	/** The location name. */
	@Column(name = "LOCATION_NAME")
	private String locationName;

	/** The location name guj. */
	@Column(name = "LOCATION_NAME_GUJ")
	private String locationNameGuj;

	/** The location description. */
	@Column(name = "LOCATION_DESCRIPTION")
	private String locationDescription;

	/** The location description guj. */
	@Column(name = "LOCATION_DESCRIPTION_GUJ")
	private String locationDescriptionGuj;

	/** The location type id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity locationTypeId;

	/** The parent location type id. */
	@Column(name = "PARENT_LOCATION_ID")
	private Long parentLocationTypeId;

	/** The is corporation allowed. */
	@Column(name = "IS_CORPORATION_ALLOWED")
	private long isCorporationAllowed;
	
	/** The location code name. */
	@Column(name = "LOCATION_CODE_NAME")
	private String locationCodeName;
	
	/** The location code. */
	@Column(name = "LOCATION_CODE")
	private String locationCode;

	/**
	 * Gets the checks if is corporation allowed.
	 *
	 * @return the isCorporationAllowed
	 */
	public long getIsCorporationAllowed() {
		return isCorporationAllowed;
	}

	/**
	 * Sets the checks if is corporation allowed.
	 *
	 * @param isCorporationAllowed the isCorporationAllowed to set
	 */
	public void setIsCorporationAllowed(long isCorporationAllowed) {
		this.isCorporationAllowed = isCorporationAllowed;
	}

	/**
	 * Gets the location id.
	 *
	 * @return the locationId
	 */
	public long getLocationId() {
		return locationId;
	}

	/**
	 * Sets the location id.
	 *
	 * @param locationId the locationId to set
	 */
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets the location name.
	 *
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the location name.
	 *
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * Gets the location name guj.
	 *
	 * @return the locationNameGuj
	 */
	public String getLocationNameGuj() {
		return locationNameGuj;
	}

	/**
	 * Sets the location name guj.
	 *
	 * @param locationNameGuj the locationNameGuj to set
	 */
	public void setLocationNameGuj(String locationNameGuj) {
		this.locationNameGuj = locationNameGuj;
	}

	/**
	 * Gets the location description.
	 *
	 * @return the locationDescription
	 */
	public String getLocationDescription() {
		return locationDescription;
	}

	/**
	 * Sets the location description.
	 *
	 * @param locationDescription the locationDescription to set
	 */
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	/**
	 * Gets the location description guj.
	 *
	 * @return the locationDescriptionGuj
	 */
	public String getLocationDescriptionGuj() {
		return locationDescriptionGuj;
	}

	/**
	 * Sets the location description guj.
	 *
	 * @param locationDescriptionGuj the locationDescriptionGuj to set
	 */
	public void setLocationDescriptionGuj(String locationDescriptionGuj) {
		this.locationDescriptionGuj = locationDescriptionGuj;
	}

	/**
	 * Gets the location type id.
	 *
	 * @return the locationTypeId
	 */
	public EDPLuLookUpInfoEntity getLocationTypeId() {
		return locationTypeId;
	}

	/**
	 * Sets the location type id.
	 *
	 * @param locationTypeId the locationTypeId to set
	 */
	public void setLocationTypeId(EDPLuLookUpInfoEntity locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	/**
	 * Gets the parent location type id.
	 *
	 * @return the parentLocationTypeId
	 */
	public Long getParentLocationTypeId() {
		return parentLocationTypeId;
	}

	/**
	 * Sets the parent location type id.
	 *
	 * @param parentLocationTypeId the parentLocationTypeId to set
	 */
	public void setParentLocationTypeId(Long parentLocationTypeId) {
		this.parentLocationTypeId = parentLocationTypeId;
	}

	/**
	 * Instantiates a new EDP ms location entity.
	 */
	public EDPMsLocationEntity() {
		super();
	}

	/**
	 * Gets the location code name.
	 *
	 * @return the locationCodeName
	 */
	public String getLocationCodeName() {
		return locationCodeName;
	}

	/**
	 * Sets the location code name.
	 *
	 * @param locationCodeName the locationCodeName to set
	 */
	public void setLocationCodeName(String locationCodeName) {
		this.locationCodeName = locationCodeName;
	}

	
	
	
	/**
	 * Gets the location code.
	 *
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * Sets the location code.
	 *
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Instantiates a new EDP ms location entity.
	 *
	 * @param locationId the location id
	 */
	public EDPMsLocationEntity(long locationId) {
		super();
		this.locationId = locationId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isCorporationAllowed, locationDescription, locationDescriptionGuj, locationId, locationName,
				locationNameGuj, locationTypeId, parentLocationTypeId,locationCode);
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
		if (!(obj instanceof EDPMsLocationEntity)) {
			return false;
		}
		EDPMsLocationEntity other = (EDPMsLocationEntity) obj;
		return isCorporationAllowed == other.isCorporationAllowed
				&& Objects.equals(locationDescription, other.locationDescription)
				&& Objects.equals(locationDescriptionGuj, other.locationDescriptionGuj)
				&& locationId == other.locationId && Objects.equals(locationName, other.locationName)
				&& Objects.equals(locationNameGuj, other.locationNameGuj)
				&& Objects.equals(locationTypeId, other.locationTypeId)
				&& Objects.equals(locationCode, other.locationCode)
				&& Objects.equals(parentLocationTypeId,other.parentLocationTypeId);
	}
}
