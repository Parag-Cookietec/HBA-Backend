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

/**
 * The Class PVUEmploye7PayDetailEntity.
 *
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 *
 */
@Entity
@Table(name = "T_EMP_7PAY", schema = Constant.PVU_SCHEMA)
public class PVUEmployeSevenPayDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sevenpay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_7PAY_ID")
	private long sevenPayId;

	/** The pay level. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private Long basicPay;

	/** The date of benefit effective. */
	@Column(name = "BENEFIT_EFF_DATE")
	private Date dateOfBenefitEffective;

	/** The date of next increment. */
	@Column(name = "DATE_NXT_INCR")
	private Date dateOfNextIncrement;

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
	 * PVUEmploye7PayDetailEntity Constructor.
	 */
	public PVUEmployeSevenPayDetailEntity() {
		super();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeSevenPayDetailEntity [sevenpayId=" + sevenPayId + ", payLevel=" + payLevel + ", cellId="
				+ cellId + ", basicPay=" + basicPay + ", dateOfBenefitEffective=" + dateOfBenefitEffective
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", pvuEmployeEntity=" + pvuEmployeEntity + "]";
	}

	/**
	 * getter setter.
	 *
	 * @return the int
	 */

	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, dateOfBenefitEffective, dateOfNextIncrement, payLevel, pvuEmployeEntity,
				sevenPayId);
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
		PVUEmployeSevenPayDetailEntity other = (PVUEmployeSevenPayDetailEntity) obj;
		return Objects.equals(basicPay, other.basicPay) && Objects.equals(cellId, other.cellId)
				&& Objects.equals(dateOfBenefitEffective, other.dateOfBenefitEffective)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(payLevel, other.payLevel) && Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity)
				&& Objects.equals(sevenPayId, other.sevenPayId);
	}

	/**
	 * Gets the sevenpay id.
	 *
	 * @return the sevenpayId
	 */
	public long getSevenPayId() {
		return sevenPayId;
	}

	/**
	 * Sets the sevenpay id.
	 *
	 * @param sevenpayId the sevenpayId to set
	 */
	public void setSevenPayId(long sevenpayId) {
		this.sevenPayId = sevenpayId;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevel
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the date of benefit effective.
	 *
	 * @return the dateOfBenefitEffective
	 */
	public Date getDateOfBenefitEffective() {
		return dateOfBenefitEffective;
	}

	/**
	 * Sets the date of benefit effective.
	 *
	 * @param dateOfBenefitEffective the dateOfBenefitEffective to set
	 */
	public void setDateOfBenefitEffective(Date dateOfBenefitEffective) {
		this.dateOfBenefitEffective = dateOfBenefitEffective;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

}
