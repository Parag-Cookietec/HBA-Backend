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
 * The Class EDPMsAddressEntity.
 */
@Entity
@Table(name = "MS_ADDRESS", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsAddressEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The address id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private long addressId;

	/** The address description. */
	@Column(name = "ADDRESS_DESCRIPTION")
	private String addressDescription;

	/** The address description guj. */
	@Column(name = "ADDRESS_DESCRIPTION_GUJ")
	private String addressDescriptionGuj;

	/** The location entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_ID")
	private EDPMsLocationEntity locationEntity;

	/** The parent address id. */
	@Column(name = "PARENT_ADDRESS_ID")
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
	 * Gets the location entity.
	 *
	 * @return the locationEntity
	 */
	public EDPMsLocationEntity getLocationEntity() {
		return locationEntity;
	}

	/**
	 * Sets the location entity.
	 *
	 * @param locationEntity the locationEntity to set
	 */
	public void setLocationEntity(EDPMsLocationEntity locationEntity) {
		this.locationEntity = locationEntity;
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
		return Objects.hash(addressDescription, addressDescriptionGuj, addressId, locationEntity, parentAddressId);
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
		if (!(obj instanceof EDPMsAddressEntity)) {
			return false;
		}
		EDPMsAddressEntity other = (EDPMsAddressEntity) obj;
		return Objects.equals(addressDescription, other.addressDescription)
				&& Objects.equals(addressDescriptionGuj, other.addressDescriptionGuj) && addressId == other.addressId
				&& Objects.equals(locationEntity, other.locationEntity) && parentAddressId == other.parentAddressId;
	}

}
