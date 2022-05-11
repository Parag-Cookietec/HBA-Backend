package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeFivePayDetailEntity.
 *
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 *
 */
@Entity
@Table(name = "T_EMP_5PAY", schema = Constant.PVU_SCHEMA)
public class PVUEmployeFivePayDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fifth pay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_5PAY_ID")
	private long fifthPayId;

	/** The pay scale. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;

	/** The pay scale. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The effective date. */
	@Column(name = "EFF_DATE")
	private Date effectiveDate;

	/** The pvu employe entity. */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;
	
	/** The date of next increment. */
	@Column(name = "DATE_NEXT_INCR")
	private Date dateOfNextIncrement;

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return the pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the pvuEmployeEntity to set
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * PVUEmployeFivePayDetailEntity Constructor.
	 */
	public PVUEmployeFivePayDetailEntity() {
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
	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(PVUMsPayScaleEntity payScale) {
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFivePayDetailEntity [fifthPayId=" + fifthPayId + ", payScale=" + payScale + ", statusId="
				+ statusId + ", basicPay=" + basicPay + ", effectiveDate=" + effectiveDate + ", pvuEmployeEntity="
				+ pvuEmployeEntity + ", dateOfNextIncrement=" + dateOfNextIncrement + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, dateOfNextIncrement, effectiveDate, fifthPayId, payScale, pvuEmployeEntity,
				statusId);
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
		PVUEmployeFivePayDetailEntity other = (PVUEmployeFivePayDetailEntity) obj;
		return basicPay == other.basicPay && Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(effectiveDate, other.effectiveDate) && fifthPayId == other.fifthPayId
				&& Objects.equals(payScale, other.payScale) && Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity)
				&& Objects.equals(statusId, other.statusId);
	}

}
