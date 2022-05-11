package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUEmployeFivePayDetailDto.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 *
 */
public class PVUEmployeFivePayDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fifth pay id. */
	private long fifthPayId;

	/** The pay scale. */
	private long payScale;
	private String payScaleName;

	/** The basic pay. */
	private long basicPay;

	/** The effective date. */
	private Date effectiveDate;

	/** The emp id. */
	private long empId;

	/** The emp id. */
	private long statusId;

	/** The date of next increment. */
	private Date dateOfNextIncrement;

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

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
	 * PVUEmployeFivePayDetailEntityDto Constructor.
	 */
	public PVUEmployeFivePayDetailDto() {
		super();
	}

	/**
	 * Gets the fifth pay id.
	 *
	 * @return the fifthPayId
	 */
	public long getFifthPayId() {
		return fifthPayId;
	}

	/**
	 * Sets the fifth pay id.
	 *
	 * @param fifthPayId the fifthPayId to set
	 */
	public void setFifthPayId(long fifthPayId) {
		this.fifthPayId = fifthPayId;
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
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(long basicPay) {
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
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
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
		return Objects.hash(basicPay, dateOfNextIncrement, effectiveDate, empId, fifthPayId, payScale, statusId);
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
		PVUEmployeFivePayDetailDto other = (PVUEmployeFivePayDetailDto) obj;
		return basicPay == other.basicPay && Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(effectiveDate, other.effectiveDate) && empId == other.empId
				&& fifthPayId == other.fifthPayId && payScale == other.payScale && statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFivePayDetailDto [fifthPayId=" + fifthPayId + ", payScale=" + payScale + ", basicPay="
				+ basicPay + ", effectiveDate=" + effectiveDate + ", empId=" + empId + ", statusId=" + statusId
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + "]";
	}

}
