package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUMsPayBandEntity.
 *
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 */
@Entity
@Table(name = "MS_PAY_BAND", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsPayBandEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAY_BAND_ID")
	private long id;

	/** The starting value. */
	@Column(name = "STARTING_VALUE")
	private long startingValue;

	/** The ending value. */
	@Column(name = "ENDING_VALUE")
	private long endingValue;

	/** The order. */
	@Column(name = "ORDER_NO")
	private int order;

	/** The pay band disp val. */
	@Column(name = "PAY_BAND_DISP_VAL")
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
	 * PVUMS_PAY_BANDEntity Constructor.
	 */
	public PVUMsPayBandEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU ms pay band entity.
	 *
	 * @param id Constructor for set id
	 */
	public PVUMsPayBandEntity(long id) {
		this.id = id;
	}

	/**
	 * hasCode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, startingValue, endingValue);
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
		if (!(obj instanceof PVUMsPayBandEntity)) {
			return false;
		}

		PVUMsPayBandEntity other = (PVUMsPayBandEntity) obj;

		return id == other.id && startingValue == other.startingValue && endingValue == other.endingValue;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayBandEntity [id = " + id + ",starttingValue = " + startingValue + ",endingValue = " + endingValue
				+ ",]";
	}

	/**
	 * Gets the id.
	 *
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

}
