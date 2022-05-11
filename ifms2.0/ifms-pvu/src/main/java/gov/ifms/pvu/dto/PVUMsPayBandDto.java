package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUMsPayBandDto.
 *
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 */
public class PVUMsPayBandDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The starting value. */
	private long startingValue;

	/** The ending value. */
	private long endingValue;

	/** The order. */
	private int order;

	/** The pay band disp val. */
	private String payBandDispVal;

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * PVUMsPayBandDto Constructor.
	 */
	public PVUMsPayBandDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the id
	 */

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the starting value.
	 *
	 * @return the startingValue
	 */
	public long getStartingValue() {
		return startingValue;
	}

	/**
	 * Sets the starting value.
	 *
	 * @param startingValue the startingValue to set
	 */
	public void setStartingValue(long startingValue) {
		this.startingValue = startingValue;
	}

	/**
	 * Gets the ending value.
	 *
	 * @return the endingValue
	 */
	public long getEndingValue() {
		return endingValue;
	}

	/**
	 * Sets the ending value.
	 *
	 * @param endingValue the endingValue to set
	 */
	public void setEndingValue(long endingValue) {
		this.endingValue = endingValue;
	}

	/**
	 * Gets the pay band disp val.
	 *
	 * @return the pay band disp val
	 */
	public String getPayBandDispVal() {
		return payBandDispVal;
	}

	/**
	 * Sets the pay band disp val.
	 *
	 * @param payBandDispVal the new pay band disp val
	 */
	public void setPayBandDispVal(String payBandDispVal) {
		this.payBandDispVal = payBandDispVal;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(endingValue, id, order, payBandDispVal, startingValue);
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
		PVUMsPayBandDto other = (PVUMsPayBandDto) obj;
		return endingValue == other.endingValue && id == other.id && order == other.order
				&& Objects.equals(payBandDispVal, other.payBandDispVal) && startingValue == other.startingValue;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayBandDto [id=" + id + ", startingValue=" + startingValue + ", endingValue=" + endingValue
				+ ", order=" + order + ", payBandDispVal=" + payBandDispVal + "]";
	}

}
