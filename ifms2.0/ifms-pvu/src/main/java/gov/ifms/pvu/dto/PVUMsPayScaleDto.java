package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUMsPayScaleDto.
 */
public class PVUMsPayScaleDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The pay scale id.
	 */
	private Long payScaleId;

	/**
	 * The scale value.
	 */
	private String scaleValue;

	/**
	 * The pay commission.
	 */
	private int payCommission;

	/** The pay scale disp val. */
	private String payScaleDispVal;

	private Integer orderNo;

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * PVUMsPayScaleDto Constructor.
	 */
	public PVUMsPayScaleDto() {
		super();
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
		return Objects.hash(payCommission, payScaleDispVal, payScaleId, scaleValue);
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
		PVUMsPayScaleDto other = (PVUMsPayScaleDto) obj;
		return payCommission == other.payCommission && Objects.equals(payScaleDispVal, other.payScaleDispVal)
				&& Objects.equals(payScaleId, other.payScaleId) && Objects.equals(scaleValue, other.scaleValue);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayScaleDto [payScaleId=" + payScaleId + ", scaleValue=" + scaleValue + ", payCommission="
				+ payCommission + ", payScaleDispVal=" + payScaleDispVal + "]";
	}

}
