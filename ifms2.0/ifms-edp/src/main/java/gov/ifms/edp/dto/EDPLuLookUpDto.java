package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLuLookUpDto.
 * 
 * @version 1.0
 * @created 2019/08/29 18:10:47
 *
 */
public class EDPLuLookUpDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The look up id. */
	private long lookUpId;

	/** The look up name. */
	private String lookUpName;

	/** The look up name guj. */
	private String lookUpNameGuj;

	/** The look up description. */
	private String lookUpDescription;

	/** The look up description guj. */
	private String lookUpDescriptionGuj;

	/** The order id. */
	private short orderId;

	/**
	 * Gets the look up id.
	 *
	 * @return the lookUpId
	 */
	public long getLookUpId() {
		return lookUpId;
	}

	/**
	 * Sets the look up id.
	 *
	 * @param lookUpId the lookUpId to set
	 */
	public void setLookUpId(long lookUpId) {
		this.lookUpId = lookUpId;
	}

	/**
	 * Gets the look up name.
	 *
	 * @return the lookUpName
	 */
	public String getLookUpName() {
		return lookUpName;
	}

	/**
	 * Sets the look up name.
	 *
	 * @param lookUpName the lookUpName to set
	 */
	public void setLookUpName(String lookUpName) {
		this.lookUpName = lookUpName;
	}

	/**
	 * Gets the look up name guj.
	 *
	 * @return the lookUpNameGuj
	 */
	public String getLookUpNameGuj() {
		return lookUpNameGuj;
	}

	/**
	 * Sets the look up name guj.
	 *
	 * @param lookUpNameGuj the lookUpNameGuj to set
	 */
	public void setLookUpNameGuj(String lookUpNameGuj) {
		this.lookUpNameGuj = lookUpNameGuj;
	}

	/**
	 * Gets the look up description.
	 *
	 * @return the lookUpDescription
	 */
	public String getLookUpDescription() {
		return lookUpDescription;
	}

	/**
	 * Sets the look up description.
	 *
	 * @param lookUpDescription the lookUpDescription to set
	 */
	public void setLookUpDescription(String lookUpDescription) {
		this.lookUpDescription = lookUpDescription;
	}

	/**
	 * Gets the look up description guj.
	 *
	 * @return the lookUpDescriptionGuj
	 */
	public String getLookUpDescriptionGuj() {
		return lookUpDescriptionGuj;
	}

	/**
	 * Sets the look up description guj.
	 *
	 * @param lookUpDescriptionGuj the lookUpDescriptionGuj to set
	 */
	public void setLookUpDescriptionGuj(String lookUpDescriptionGuj) {
		this.lookUpDescriptionGuj = lookUpDescriptionGuj;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the orderId
	 */
	public short getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(short orderId) {
		this.orderId = orderId;
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
				+ Objects.hash(lookUpDescription, lookUpDescriptionGuj, lookUpId, lookUpName, lookUpNameGuj, orderId);
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
		if (!(obj instanceof EDPLuLookUpDto)) {
			return false;
		}
		EDPLuLookUpDto other = (EDPLuLookUpDto) obj;
		return Objects.equals(lookUpDescription, other.lookUpDescription)
				&& Objects.equals(lookUpDescriptionGuj, other.lookUpDescriptionGuj) && lookUpId == other.lookUpId
				&& Objects.equals(lookUpName, other.lookUpName) && Objects.equals(lookUpNameGuj, other.lookUpNameGuj)
				&& orderId == other.orderId;
	}

}
