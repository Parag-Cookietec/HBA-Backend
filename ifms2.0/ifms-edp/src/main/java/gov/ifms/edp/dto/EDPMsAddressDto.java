package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class EDPMsAddressDto.
 * 
 * @version 1.0
 * @created 2019/08/29 18:45:37
 *
 */
public class EDPMsAddressDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The address id. */
	private long addressId;

	/** The address description. */
	private String addressDescription;

	/** The address description guj. */
	private String addressDescriptionGuj;

	/** The location id. */
	private int locationId;

	/** The parent address id. */
	private long parentAddressId;

	/**
	 * Gets the address id.
	 *
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * Sets the address id.
	 *
	 * @param addressId the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * Gets the address description.
	 *
	 * @return the addressDescription
	 */
	public String getAddressDescription() {
		return addressDescription;
	}

	/**
	 * Sets the address description.
	 *
	 * @param addressDescription the addressDescription to set
	 */
	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	/**
	 * Gets the address description guj.
	 *
	 * @return the addressDescriptionGuj
	 */
	public String getAddressDescriptionGuj() {
		return addressDescriptionGuj;
	}

	/**
	 * Sets the address description guj.
	 *
	 * @param addressDescriptionGuj the addressDescriptionGuj to set
	 */
	public void setAddressDescriptionGuj(String addressDescriptionGuj) {
		this.addressDescriptionGuj = addressDescriptionGuj;
	}

	/**
	 * Gets the location id.
	 *
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}

	/**
	 * Sets the location id.
	 *
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets the parent address id.
	 *
	 * @return the parentAddressId
	 */
	public long getParentAddressId() {
		return parentAddressId;
	}

	/**
	 * Sets the parent address id.
	 *
	 * @param parentAddressId the parentAddressId to set
	 */
	public void setParentAddressId(long parentAddressId) {
		this.parentAddressId = parentAddressId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(addressDescription, addressDescriptionGuj, addressId, locationId, parentAddressId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsAddressDto)) {
			return false;
		}
		EDPMsAddressDto other = (EDPMsAddressDto) obj;
		return Objects.equals(addressDescription, other.addressDescription)
				&& Objects.equals(addressDescriptionGuj, other.addressDescriptionGuj) && addressId == other.addressId
				&& locationId == other.locationId && parentAddressId == other.parentAddressId;
	}

}
