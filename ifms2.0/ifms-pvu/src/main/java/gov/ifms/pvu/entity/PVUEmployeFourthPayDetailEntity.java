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
 * The Class PVUEmployeFourthPayDetailEntity.
 *
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 */
@Entity
@Table(name = "T_EMP_4PAY", schema = Constant.PVU_SCHEMA)
public class PVUEmployeFourthPayDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fourth pay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_4PAY_ID")
	private long fourthPayId;

	/** The pay scale. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private double basicPay;

	/** The effective date. */
	@Column(name = "EFF_DATE")
	private Date effectiveDate;

	/** The status id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The pvu employe entity. */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

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
	 * PVUEmployeFourthPayDetailEntity Constructor.
	 */
	public PVUEmployeFourthPayDetailEntity() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the int
	 */

	@Override
	public int hashCode() {
		return Objects.hash(basicPay, effectiveDate, fourthPayId, payScale, pvuEmployeEntity, statusId);
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
		PVUEmployeFourthPayDetailEntity other = (PVUEmployeFourthPayDetailEntity) obj;
		return Double.doubleToLongBits(basicPay) == Double.doubleToLongBits(other.basicPay)
				&& Objects.equals(effectiveDate, other.effectiveDate) && fourthPayId == other.fourthPayId
				&& payScale == other.payScale && Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity)
				&& statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFourthPayDetailEntity [fourthPayId=" + fourthPayId + ", payScale=" + payScale + ", basicPay="
				+ basicPay + ", effectiveDate=" + effectiveDate + ", statusId=" + statusId + ", pvuEmployeEntity="
				+ pvuEmployeEntity + "]";
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
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

}
