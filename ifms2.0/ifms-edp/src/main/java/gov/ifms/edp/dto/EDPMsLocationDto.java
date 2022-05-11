package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPMsLocationDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:49:36
 *
 */
public class EDPMsLocationDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The location id. */
	private long locationId;

	/** The location name. */
	private String locationName;

	/** The location name guj. */
	private String locationNameGuj;

	/** The location description. */
	private String locationDescription;

	/** The location description guj. */
	private String locationDescriptionGuj;

	/** The parent location type id. */
	private Long parentLocationTypeId;

	/** The location type id. */
	private int locationTypeId;

	/** The is corporation allowed. */
	private long isCorporationAllowed;

	/** The location code name. */
	private String locationCodeName;
	
	/** The talukas. */
	private List<EDPMsLocationDto> talukas;
	
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
	 * Gets the location type id.
	 *
	 * @return the locationTypeId
	 */
	public int getLocationTypeId() {
		return locationTypeId;
	}

	/**
	 * Sets the location type id.
	 *
	 * @param locationTypeId the locationTypeId to set
	 */
	public void setLocationTypeId(int locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	/**
	 * Gets the checks if is corporation allowed.
	 *
	 * @return the isCorporationArea
	 */
	public long getIsCorporationAllowed() {
		return isCorporationAllowed;
	}

	/**
	 * Sets the checks if is corporation allowed.
	 *
	 * @param isCorporationArea the isCorporationArea to set
	 */
	public void setIsCorporationAllowed(long isCorporationArea) {
		this.isCorporationAllowed = isCorporationArea;
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
	 * Gets the talukas.
	 *
	 * @return the talukas
	 */
	public List<EDPMsLocationDto> getTalukas() {
		return talukas;
	}

	/**
	 * Sets the talukas.
	 *
	 * @param talukas the talukas to set
	 */
	public void setTalukas(List<EDPMsLocationDto> talukas) {
		this.talukas = talukas;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isCorporationAllowed, locationDescription, locationDescriptionGuj, locationId, locationName,
				locationNameGuj, locationTypeId, parentLocationTypeId,talukas);
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
		if (!(obj instanceof EDPMsLocationDto)) {
			return false;
		}
		EDPMsLocationDto other = (EDPMsLocationDto) obj;
		return isCorporationAllowed == other.isCorporationAllowed
				&& Objects.equals(locationDescription, other.locationDescription)
				&& Objects.equals(locationDescriptionGuj, other.locationDescriptionGuj)
				&& locationId == other.locationId && Objects.equals(locationName, other.locationName)
				&& Objects.equals(locationNameGuj, other.locationNameGuj) && locationTypeId == other.locationTypeId
				&& Objects.equals(parentLocationTypeId,other.parentLocationTypeId)
				&& Objects.equals(talukas,other.talukas);
	}

}
