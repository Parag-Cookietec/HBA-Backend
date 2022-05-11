package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUSuspensionPayDetailsDto.
 *
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 *
 */
public class PVUSuspensionPayDetailsDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The payble grade pay perc. */
	@Min(value = 1)
	@Max(value = 99)
	private double payableGradePayPerc;

	/** The payble grade pay amt. */

	private long payableGradePayAmt;

	/** The payble pay band perc. */
	@Min(value = 1)
	@Max(value = 99)
	private double payablePayBandPerc;

	/** The payble pay band amt. */

	private long payablePayBandAmt;

	/** The payble basic pay perc. */
	@Min(value = 1)
	@Max(value = 99)
	private double payableBasicPayPerc;

	/** The payble basic pay amt. */

	private long payableBasicPayAmt;

	/** The payble from date. */
	@NotNull
	private LocalDate payableFromDate;

	private LocalDate payableToDate;

	/** The suspension id. */
	private long suspensionId;

	private long statusId;

	/** The pay scale. */
	private Long payScale;

	/** The grade pay id. */
	private Long gradePayId;

	/** The basic pay. */
	private Long basicPay;

	/** The pay band id. */
	private Long payBandId;

	/** The pay band value. */
	private Long payBandValue;

	/** The pay level id. */
	private Long payLevelId;

	/** The cell id. */
	private Long cellId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPayableGradePayPerc() {
		return payableGradePayPerc;
	}

	public void setPayableGradePayPerc(double payableGradePayPerc) {
		this.payableGradePayPerc = payableGradePayPerc;
	}

	public long getPayableGradePayAmt() {
		return payableGradePayAmt;
	}

	public void setPayableGradePayAmt(long payableGradePayAmt) {
		this.payableGradePayAmt = payableGradePayAmt;
	}

	public double getPayablePayBandPerc() {
		return payablePayBandPerc;
	}

	public void setPayablePayBandPerc(double payablePayBandPerc) {
		this.payablePayBandPerc = payablePayBandPerc;
	}

	public long getPayablePayBandAmt() {
		return payablePayBandAmt;
	}

	public void setPayablePayBandAmt(long payablePayBandAmt) {
		this.payablePayBandAmt = payablePayBandAmt;
	}

	public double getPayableBasicPayPerc() {
		return payableBasicPayPerc;
	}

	public void setPayableBasicPayPerc(double payableBasicPayPerc) {
		this.payableBasicPayPerc = payableBasicPayPerc;
	}

	public long getPayableBasicPayAmt() {
		return payableBasicPayAmt;
	}

	public void setPayableBasicPayAmt(long payableBasicPayAmt) {
		this.payableBasicPayAmt = payableBasicPayAmt;
	}

	public LocalDate getPayableFromDate() {
		return payableFromDate;
	}

	public void setPayableFromDate(LocalDate payableFromDate) {
		this.payableFromDate = payableFromDate;
	}

	public LocalDate getPayableToDate() {
		return payableToDate;
	}

	public void setPayableToDate(LocalDate payableToDate) {
		this.payableToDate = payableToDate;
	}

	public long getSuspensionId() {
		return suspensionId;
	}

	public void setSuspensionId(long suspensionId) {
		this.suspensionId = suspensionId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Long getPayScale() {
		return payScale;
	}

	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	public Long getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(Long gradePayId) {
		this.gradePayId = gradePayId;
	}

	public Long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	public Long getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public Long getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(Long payLevelId) {
		this.payLevelId = payLevelId;
	}

	public Long getCellId() {
		return cellId;
	}

	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUSuspensionPayDetailsDto)) return false;
		if (!super.equals(o)) return false;
		PVUSuspensionPayDetailsDto that = (PVUSuspensionPayDetailsDto) o;
		return getId() == that.getId() &&
				Double.compare(that.getPayableGradePayPerc(), getPayableGradePayPerc()) == 0 &&
				getPayableGradePayAmt() == that.getPayableGradePayAmt() &&
				Double.compare(that.getPayablePayBandPerc(), getPayablePayBandPerc()) == 0 &&
				getPayablePayBandAmt() == that.getPayablePayBandAmt() &&
				Double.compare(that.getPayableBasicPayPerc(), getPayableBasicPayPerc()) == 0 &&
				getPayableBasicPayAmt() == that.getPayableBasicPayAmt() &&
				getSuspensionId() == that.getSuspensionId() &&
				getStatusId() == that.getStatusId() &&
				Objects.equals(getPayableFromDate(), that.getPayableFromDate()) &&
				Objects.equals(getPayableToDate(), that.getPayableToDate()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getGradePayId(), that.getGradePayId()) &&
				Objects.equals(getBasicPay(), that.getBasicPay()) &&
				Objects.equals(getPayBandId(), that.getPayBandId()) &&
				Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
				Objects.equals(getPayLevelId(), that.getPayLevelId()) &&
				Objects.equals(getCellId(), that.getCellId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getPayableGradePayPerc(), getPayableGradePayAmt(), getPayablePayBandPerc(), getPayablePayBandAmt(), getPayableBasicPayPerc(), getPayableBasicPayAmt(), getPayableFromDate(), getPayableToDate(), getSuspensionId(), getStatusId(), getPayScale(), getGradePayId(), getBasicPay(), getPayBandId(), getPayBandValue(), getPayLevelId(), getCellId());
	}
}
