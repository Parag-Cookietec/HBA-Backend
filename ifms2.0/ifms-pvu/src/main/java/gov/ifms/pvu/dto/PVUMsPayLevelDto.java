package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUMsPayLevelDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:19:51
 */
public class PVUMsPayLevelDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The pay band id. */
	private long payBandId;

	/** The pay level value. */
	private String payLevelValue;

	/** The order. */
	private int order;

	/**
	 * PVUMsPayLevelDto Constructor.
	 */
	public PVUMsPayLevelDto() {
		super();
	}

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
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, payBandId, payLevelValue);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof PVUMsPayLevelDto)) {
			return false;
		}

		PVUMsPayLevelDto other = (PVUMsPayLevelDto) obj;

		return id == other.id && Objects.equals(payBandId, other.payBandId) && payLevelValue == other.payLevelValue;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayLevelDto [id = " + id + ",payBand = " + payBandId + ",payLevelValue = " + payLevelValue + ",]";
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
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the pay level value.
	 *
	 * @return the payLevelValue
	 */
	public String getPayLevelValue() {
		return payLevelValue;
	}

	/**
	 * Sets the pay level value.
	 *
	 * @param payLevelValue the payLevelValue to set
	 */
	public void setPayLevelValue(String payLevelValue) {
		this.payLevelValue = payLevelValue;
	}

}
