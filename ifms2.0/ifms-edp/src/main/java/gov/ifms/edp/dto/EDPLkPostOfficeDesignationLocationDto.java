package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPostOfficeDesignationLocationDto.
 * 
 * @version 1.0
 * @created 2019/08/31 14:12:31
 *
 */
public class EDPLkPostOfficeDesignationLocationDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post office designation location id. */
	private long postOfficeDesignationLocationId;

	/** The post id. */
	private long postId;

	/** The office id. */
	private long officeId;

	/** The designation id. */
	private long designationId;

	/** The location id. */
	private long locationId;

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
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(designationId, locationId, officeId, postId, postOfficeDesignationLocationId);
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
		if (!(obj instanceof EDPLkPostOfficeDesignationLocationDto)) {
			return false;
		}
		EDPLkPostOfficeDesignationLocationDto other = (EDPLkPostOfficeDesignationLocationDto) obj;
		return designationId == other.designationId && locationId == other.locationId && officeId == other.officeId
				&& postId == other.postId && postOfficeDesignationLocationId == other.postOfficeDesignationLocationId;
	}
	
}
