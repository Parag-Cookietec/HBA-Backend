package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUMsPayLevelEntity.
 *
 * @version v 1.0
 * @created 2019/12/23 17:19:51
 */
@Entity
@Table(name = "MS_PAY_LEVEL", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsPayLevelEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAY_LEVEL_ID")
	private long id;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND_ID", nullable = false, referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The pay level value. */
	@Column(name = "PAY_LEVEL_VALUE")
	private String payLevelValue;

	/** The order. */
	@Column(name = "ORDER_NO")
	private int order;

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
	 * PVUMsPayLevelEntity Constructor.
	 */
	public PVUMsPayLevelEntity() {
		super();
	}

	/**
	 * PVUMsPayLevelEntity Constructor.
	 *
	 * @param id the id
	 */
	public PVUMsPayLevelEntity(long id) {
		this();
		this.id = id;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, payBand, payLevelValue);
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
		if (!(obj instanceof PVUMsPayLevelEntity)) {
			return false;
		}

		PVUMsPayLevelEntity other = (PVUMsPayLevelEntity) obj;

		return id == other.id && Objects.equals(payBand, other.payBand) && payLevelValue == other.payLevelValue;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayLevelEntity [id = " + id + ",payBand = " + payBand + ",payLevelValue = " + payLevelValue + ",]";
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
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
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
