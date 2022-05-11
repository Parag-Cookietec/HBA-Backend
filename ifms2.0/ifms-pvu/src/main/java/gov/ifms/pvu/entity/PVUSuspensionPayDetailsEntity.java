/*
 * 
 */
package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;


/**
 * The Class PVUSuspensionPayDetailsEntity.
 * 
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 *
 */
@Entity
@Table(name = "T_PVU_SUS_PAY_DTL", schema = Constant.PVU_SCHEMA)
public class PVUSuspensionPayDetailsEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SUS_PAY_DTL_ID")
	private long id;

	/** The suspension. */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "T_PVU_SUS_CRT_ID", nullable = false, referencedColumnName = "T_PVU_SUS_CRT_ID")
	private PVUEmployeSuspensionEntity suspension;

	/** The payble grade pay perc. */
	@Column(name = "PYBLE_GP_PERC")
	private double payableGradePayPerc;

	/** The payble grade pay amt. */
	@Column(name = "PYBLE_GP_AMT")
	private long payableGradePayAmt;

	/** The payble pay band perc. */
	@Column(name = "PYBLE_PB_PERC")
	private double payablePayBandPerc;

	/** The payble pay band amt. */
	@Column(name = "PYBLE_PB_AMT")
	private long payablePayBandAmt;

	/** The payble basic pay perc. */
	@Column(name = "PYBLE_BP_PERC")
	private double payableBasicPayPerc;

	/** The payble basic pay amt. */
	@Column(name = "PYBLE_BP_AMT")
	private long payableBasicPayAmt;

	/** The payble from date. */
	@Column(name = "PYBLE_FROM_DATE")
	private LocalDate payableFromDate;

    @Column(name = "PYBLE_TO_DATE")
    private LocalDate payableToDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The pay scale. */
	@ManyToOne
	@JoinColumn(name = "SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;

	/** The grade pay. */
	@ManyToOne
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePayId;

	/** The cur pay band. */
	@ManyToOne
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBandId;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	/** The pay level. */
	@ManyToOne
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevelId;

	/** The cell id. */
	@ManyToOne
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private Long basicPay;


	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
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
	 * Gets the suspension.
	 *
	 * @return the suspension
	 */
	public PVUEmployeSuspensionEntity getSuspension() {
		return suspension;
	}

	/**
	 * Sets the suspension.
	 *
	 * @param suspension the suspension to set
	 */
	public void setSuspension(PVUEmployeSuspensionEntity suspension) {
		this.suspension = suspension;
	}

	/**
	 * Gets the payable grade pay perc.
	 *
	 * @return the payable grade pay perc
	 */
	public double getPayableGradePayPerc() {
		return payableGradePayPerc;
	}

	/**
	 * Sets the payable grade pay perc.
	 *
	 * @param payableGradePayPerc the new payable grade pay perc
	 */
	public void setPayableGradePayPerc(double payableGradePayPerc) {
		this.payableGradePayPerc = payableGradePayPerc;
	}

	/**
	 * Gets the payable grade pay amt.
	 *
	 * @return the payable grade pay amt
	 */
	public long getPayableGradePayAmt() {
		return payableGradePayAmt;
	}

	/**
	 * Sets the payable grade pay amt.
	 *
	 * @param payableGradePayAmt the new payable grade pay amt
	 */
	public void setPayableGradePayAmt(long payableGradePayAmt) {
		this.payableGradePayAmt = payableGradePayAmt;
	}

	/**
	 * Gets the payable pay band perc.
	 *
	 * @return the payable pay band perc
	 */
	public double getPayablePayBandPerc() {
		return payablePayBandPerc;
	}

	/**
	 * Sets the payable pay band perc.
	 *
	 * @param payablePayBandPerc the new payable pay band perc
	 */
	public void setPayablePayBandPerc(double payablePayBandPerc) {
		this.payablePayBandPerc = payablePayBandPerc;
	}

	/**
	 * Gets the payable pay band amt.
	 *
	 * @return the payable pay band amt
	 */
	public long getPayablePayBandAmt() {
		return payablePayBandAmt;
	}

	/**
	 * Sets the payable pay band amt.
	 *
	 * @param payablePayBandAmt the new payable pay band amt
	 */
	public void setPayablePayBandAmt(long payablePayBandAmt) {
		this.payablePayBandAmt = payablePayBandAmt;
	}

	/**
	 * Gets the payable basic pay perc.
	 *
	 * @return the payable basic pay perc
	 */
	public double getPayableBasicPayPerc() {
		return payableBasicPayPerc;
	}

	/**
	 * Sets the payable basic pay perc.
	 *
	 * @param payableBasicPayPerc the new payable basic pay perc
	 */
	public void setPayableBasicPayPerc(double payableBasicPayPerc) {
		this.payableBasicPayPerc = payableBasicPayPerc;
	}

	/**
	 * Gets the payable basic pay amt.
	 *
	 * @return the payable basic pay amt
	 */
	public long getPayableBasicPayAmt() {
		return payableBasicPayAmt;
	}

	/**
	 * Sets the payable basic pay amt.
	 *
	 * @param payableBasicPayAmt the new payable basic pay amt
	 */
	public void setPayableBasicPayAmt(long payableBasicPayAmt) {
		this.payableBasicPayAmt = payableBasicPayAmt;
	}

	/**
	 * Gets the payable from date.
	 *
	 * @return the payable from date
	 */
	public LocalDate getPayableFromDate() {
		return payableFromDate;
	}

	/**
	 * Sets the payable from date.
	 *
	 * @param payableFromDate the new payable from date
	 */
	public void setPayableFromDate(LocalDate payableFromDate) {
		this.payableFromDate = payableFromDate;
	}

    public LocalDate getPayableToDate() {
        return payableToDate;
    }

    public void setPayableToDate(LocalDate payableToDate) {
        this.payableToDate = payableToDate;
    }

	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	public void setPayScale(PVUMsPayScaleEntity payScale) {
		this.payScale = payScale;
	}

	public PVUMsGradePayEntity getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(PVUMsGradePayEntity gradePayId) {
		this.gradePayId = gradePayId;
	}

	public PVUMsPayBandEntity getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(PVUMsPayBandEntity payBandId) {
		this.payBandId = payBandId;
	}


	public PVUMsPayLevelEntity getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(PVUMsPayLevelEntity payLevelId) {
		this.payLevelId = payLevelId;
	}

	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	public Long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUSuspensionPayDetailsEntity)) return false;
		PVUSuspensionPayDetailsEntity that = (PVUSuspensionPayDetailsEntity) o;
		return getId() == that.getId() &&
				Double.compare(that.getPayableGradePayPerc(), getPayableGradePayPerc()) == 0 &&
				getPayableGradePayAmt() == that.getPayableGradePayAmt() &&
				Double.compare(that.getPayablePayBandPerc(), getPayablePayBandPerc()) == 0 &&
				getPayablePayBandAmt() == that.getPayablePayBandAmt() &&
				Double.compare(that.getPayableBasicPayPerc(), getPayableBasicPayPerc()) == 0 &&
				getPayableBasicPayAmt() == that.getPayableBasicPayAmt() &&
				Objects.equals(getSuspension(), that.getSuspension()) &&
				Objects.equals(getPayableFromDate(), that.getPayableFromDate()) &&
				Objects.equals(getPayableToDate(), that.getPayableToDate()) &&
				Objects.equals(getStatus(), that.getStatus()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getGradePayId(), that.getGradePayId()) &&
				Objects.equals(getPayBandId(), that.getPayBandId()) &&
				Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
				Objects.equals(getPayLevelId(), that.getPayLevelId()) &&
				Objects.equals(getCellId(), that.getCellId()) &&
				Objects.equals(getBasicPay(), that.getBasicPay());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getSuspension(), getPayableGradePayPerc(), getPayableGradePayAmt(), getPayablePayBandPerc(), getPayablePayBandAmt(), getPayableBasicPayPerc(), getPayableBasicPayAmt(), getPayableFromDate(), getPayableToDate(), getStatus(), getPayScale(), getGradePayId(), getPayBandId(), getPayBandValue(), getPayLevelId(), getCellId(), getBasicPay());
	}
}
