package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUMsPayScaleEntity.
 */

@Entity
@Table(name = "MS_PAY_SCALE", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsPayScaleEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pay scale id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAY_SCALE_ID")
	private Long payScaleId;

	/** The scale value. */
	@Column(name = "SCALE_VAL")
	private String scaleValue;

	/** The pay commission. */
	@Column(name = "PAY_COMM")
	private int payCommission;

	/** The pay scale disp val. */
	@Column(name = "PAY_SCALE_DISP_VAL")
	private String payScaleDispVal;

	/** The pay scale disp val. */
	@Column(name = "ORDER_NO")
	private Integer orderNo;

	/**
	 * PVUMsPayScaleEntity Constructor.
	 */
	public PVUMsPayScaleEntity() {
		super();
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * PVUMsPayScaleEntity Constructor.
	 *
	 * @param payScaleId the pay scale id
	 */
	public PVUMsPayScaleEntity(Long payScaleId) {
		super();
		this.payScaleId = payScaleId;
	}

	/**
	 * Gets the pay scale id.
	 *
	 * @return the payScaleId
	 */
	public Long getPayScaleId() {
		return payScaleId;
	}

	/**
	 * Sets the pay scale id.
	 *
	 * @param payScaleId the payScaleId to set
	 */
	public void setPayScaleId(Long payScaleId) {
		this.payScaleId = payScaleId;
	}

	/**
	 * Gets the scale value.
	 *
	 * @return the scaleValue
	 */
	public String getScaleValue() {
		return scaleValue;
	}

	/**
	 * Sets the scale value.
	 *
	 * @param scaleValue the scaleValue to set
	 */
	public void setScaleValue(String scaleValue) {
		this.scaleValue = scaleValue;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the payCommission
	 */
	public int getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(int payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * Gets the pay scale disp val.
	 *
	 * @return the pay scale disp val
	 */
	public String getPayScaleDispVal() {
		return payScaleDispVal;
	}

	/**
	 * Sets the pay scale disp val.
	 *
	 * @param payScaleDispVal the new pay scale disp val
	 */
	public void setPayScaleDispVal(String payScaleDispVal) {
		this.payScaleDispVal = payScaleDispVal;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(payCommission, payScaleId, scaleValue);
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
		PVUMsPayScaleEntity other = (PVUMsPayScaleEntity) obj;
		return Objects.equals(payCommission, other.payCommission) && Objects.equals(payScaleId, other.payScaleId)
				&& Objects.equals(scaleValue, other.scaleValue);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayScaleEntity [payScaleId=" + payScaleId + ", scaleValue=" + scaleValue + ", payCommission="
				+ payCommission + "]";
	}

}
