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
 * The Class EDPLkPostOfficeDesignationLocationEntity.
 * 
 * @version 1.0
 * @created 2019/08/31 14:12:31
 *
 */
@Entity
@Table(name = "LK_POST_OFFICE_DESIGNATION_LOCATION", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPostOfficeDesignationLocationEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post office designation location id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_OFFICE_DESIGNATION_LOCATION_ID")
	private long postOfficeDesignationLocationId;

	/** The post id. */
	@Column(name = "POST_ID")
	private long postId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The location id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
	private EDPMsLocationEntity locationId;
	
	/**
	 * Gets the post office designation location id.
	 *
	 * @return the postOfficeDesignationLocationId
	 */
	public long getPostOfficeDesignationLocationId() {
		return postOfficeDesignationLocationId;
	}

	/**
	 * Sets the post office designation location id.
	 *
	 * @param postOfficeDesignationLocationId the postOfficeDesignationLocationId to
	 *                                        set
	 */
	public void setPostOfficeDesignationLocationId(long postOfficeDesignationLocationId) {
		this.postOfficeDesignationLocationId = postOfficeDesignationLocationId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the location id.
	 *
	 * @return the locationId
	 */
	public EDPMsLocationEntity getLocationId() {
		return locationId;
	}

	/**
	 * Sets the location id.
	 *
	 * @param locationId the locationId to set
	 */
	public void setLocationId(EDPMsLocationEntity locationId) {
		this.locationId = locationId;
	}

	/**
	 * Instantiates a new EDP lk post office designation location entity.
	 */
	public EDPLkPostOfficeDesignationLocationEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designationId, locationId, officeId, postId, postOfficeDesignationLocationId);
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
		if (!(obj instanceof EDPLkPostOfficeDesignationLocationEntity)) {
			return false;
		}
		EDPLkPostOfficeDesignationLocationEntity other = (EDPLkPostOfficeDesignationLocationEntity) obj;
		return Objects.equals(designationId, other.designationId) && Objects.equals(locationId, other.locationId)
				&& Objects.equals(officeId, other.officeId) && postId == other.postId
				&& postOfficeDesignationLocationId == other.postOfficeDesignationLocationId;
	}

}
