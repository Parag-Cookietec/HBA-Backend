package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeeJoiningPayEntity.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 *
 */
@Entity
@Table(name = "T_EMP_JOIN_PAY_DTL", schema = Constant.PVU_SCHEMA)
public class PVUEmployeeJoiningPayEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The joining pay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_JOIN_PAY_DTL_ID")
	private Long joiningPayId;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The pay commission joining time. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "JOIN_PAY_COMM_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommissionJoiningTime;

	/** The pay scale. */
	@Column(name = "PAY_SCALE_ID")
	private String payScale;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private Long basicPay;

	/** The pay band. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND_ID", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY_ID", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	/** The pay level. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL_ID", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/**
	 * PVUEmployeeJoiningPayEntity Constructor.
	 */
	public PVUEmployeeJoiningPayEntity() {
		super();
	}

	/**
	 * Gets the joining pay id.
	 *
	 * @return the joining pay id
	 */
	public Long getJoiningPayId() {
		return joiningPayId;
	}

	/**
	 * Sets the joining pay id.
	 *
	 * @param joiningPayId the new joining pay id
	 */
	public void setJoiningPayId(Long joiningPayId) {
		this.joiningPayId = joiningPayId;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return the pvu employe entity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * Gets the pay commission joining time.
	 *
	 * @return the pay commission joining time
	 */
	public EDPLuLookUpInfoEntity getPayCommissionJoiningTime() {
		return payCommissionJoiningTime;
	}

	/**
	 * Sets the pay commission joining time.
	 *
	 * @param payCommissionJoiningTime the new pay commission joining time
	 */
	public void setPayCommissionJoiningTime(EDPLuLookUpInfoEntity payCommissionJoiningTime) {
		this.payCommissionJoiningTime = payCommissionJoiningTime;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the pay scale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the new pay scale
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basic pay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the new basic pay
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the pay band.
	 *
	 * @return the pay band
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the new pay band
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the grade pay
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the new grade pay
	 */
	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the pay band value
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the new pay band value
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the pay level
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the new pay level
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cell id
	 */
	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the new cell id
	 */
	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, gradePay, joiningPayId, payBand, payBandValue, payCommissionJoiningTime,
				payLevel, payScale, pvuEmployeEntity);
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
		PVUEmployeeJoiningPayEntity other = (PVUEmployeeJoiningPayEntity) obj;
		return Objects.equals(basicPay, other.basicPay) && Objects.equals(cellId, other.cellId)
				&& Objects.equals(gradePay, other.gradePay) && Objects.equals(joiningPayId, other.joiningPayId)
				&& Objects.equals(payBand, other.payBand) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCommissionJoiningTime, other.payCommissionJoiningTime)
				&& Objects.equals(payLevel, other.payLevel) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeeJoiningPayEntity [joiningPayId=" + joiningPayId + ", pvuEmployeEntity=" + pvuEmployeEntity
				+ ", payCommissionJoiningTime=" + payCommissionJoiningTime + ", payScale=" + payScale + ", basicPay="
				+ basicPay + ", payBand=" + payBand + ", gradePay=" + gradePay + ", payBandValue=" + payBandValue
				+ ", payLevel=" + payLevel + ", cellId=" + cellId + "]";
	}

}
