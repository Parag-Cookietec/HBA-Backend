package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeFourthPayDetailDto.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 *
 */
public class PVUEmployeFourthPayDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fourth pay id. */
	private long fourthPayId;

	/** The pay scale. */
	private long payScale;
	private String payScaleName;

	/** The basic pay. */
	private double basicPay;

	/** The effective date. */
	private Date effectiveDate;

	/** The status id. */
	private long statusId;

	/** The emp id. */
	private long empId;

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * PVUEmployeFourthPayDetailEntityDto Constructor.
	 */
	public PVUEmployeFourthPayDetailDto() {
		super();
	}

	/**
	 * Gets the fourth pay id.
	 *
	 * @return the fourthPayId
	 */
	public long getFourthPayId() {
		return fourthPayId;
	}

	/**
	 * Sets the fourth pay id.
	 *
	 * @param fourthPayId the fourthPayId to set
	 */
	public void setFourthPayId(long fourthPayId) {
		this.fourthPayId = fourthPayId;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public double getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the payScaleName
	 */
	public String getPayScaleName() {
		return payScaleName;
	}

	/**
	 * @param payScaleName the payScaleName to set
	 */
	public void setPayScaleName(String payScaleName) {
		this.payScaleName = payScaleName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, effectiveDate, empId, fourthPayId, payScale, statusId);
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
		PVUEmployeFourthPayDetailDto other = (PVUEmployeFourthPayDetailDto) obj;
		return Double.doubleToLongBits(basicPay) == Double.doubleToLongBits(other.basicPay)
				&& Objects.equals(effectiveDate, other.effectiveDate) && empId == other.empId
				&& fourthPayId == other.fourthPayId && payScale == other.payScale && statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFourthPayDetailDto [fourthPayId=" + fourthPayId + ", payScale=" + payScale + ", basicPay="
				+ basicPay + ", effectiveDate=" + effectiveDate + ", statusId=" + statusId + ", empId=" + empId + "]";
	}

}
