package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVURopPostDetailView.
 */
@NativeQueryResultEntity
public class PVURopPostDetailView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pay band. */
	// 5th Pay Commission
	@NativeQueryResultColumn(index = 0)
	private String payBand;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 1)
	private Long payBandId;

	/** The pay band value. */
	@NativeQueryResultColumn(index = 10)
	private Long payBandValue;

	/** The grade pay. */
	// 6th Pay Commission
	@NativeQueryResultColumn(index = 2)
	private String gradePay;

	/** The grade pay id. */
	@NativeQueryResultColumn(index = 3)
	private Long gradePayId;

	/** The pay level. */
	@NativeQueryResultColumn(index = 4)
	private String payLevel;

	/** The pay level id. */
	@NativeQueryResultColumn(index = 5)
	private Long payLevelId;

	/** The pay cell id. */
	@NativeQueryResultColumn(index = 6)
	private Long payCellId;

	/** The pay cell value. */
	@NativeQueryResultColumn(index = 7)
	private Long payCellValue;

	/** The basic pay. */
	@NativeQueryResultColumn(index = 8)
	private Long basicPay;

	/** The next increment date. */
	@NativeQueryResultColumn(index = 9)
	private String nextIncrementDate;

	/** The auto six valid flag. */
	@NativeQueryResultColumn(index = 11)
	private Long autoSixValidFlag;
	
	/** The auto six valid basic. */
	@NativeQueryResultColumn(index = 12)
	private Long autoSixValidBasic;

	/** The auto six valid pay value. */
	@NativeQueryResultColumn(index = 13)
	private Long autoSixValidPayValue;

	/**
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public String getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public Long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the gradePay
	 */
	public String getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the gradePayId
	 */
	public Long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(Long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevel
	 */
	public String getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public Long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(Long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the pay cell id.
	 *
	 * @return the payCellId
	 */
	public Long getPayCellId() {
		return payCellId;
	}

	/**
	 * Sets the pay cell id.
	 *
	 * @param payCellId the payCellId to set
	 */
	public void setPayCellId(Long payCellId) {
		this.payCellId = payCellId;
	}

	/**
	 * Gets the pay cell value.
	 *
	 * @return the payCellValue
	 */
	public Long getPayCellValue() {
		return payCellValue;
	}

	/**
	 * Sets the pay cell value.
	 *
	 * @param payCellValue the payCellValue to set
	 */
	public void setPayCellValue(Long payCellValue) {
		this.payCellValue = payCellValue;
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
	 * Gets the next increment date.
	 *
	 * @return the nextIncrementDate
	 */
	public String getNextIncrementDate() {
		return nextIncrementDate;
	}

	/**
	 * Sets the next increment date.
	 *
	 * @param nextIncrementDate the nextIncrementDate to set
	 */
	public void setNextIncrementDate(String nextIncrementDate) {
		this.nextIncrementDate = nextIncrementDate;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the auto six valid basic.
	 *
	 * @return the autoSixValidBasic
	 */
	public Long getAutoSixValidBasic() {
		return autoSixValidBasic;
	}

	/**
	 * Sets the auto six valid basic.
	 *
	 * @param autoSixValidBasic the autoSixValidBasic to set
	 */
	public void setAutoSixValidBasic(Long autoSixValidBasic) {
		this.autoSixValidBasic = autoSixValidBasic;
	}

	/**
	 * Gets the auto six valid pay value.
	 *
	 * @return the autoSixValidPayValue
	 */
	public Long getAutoSixValidPayValue() {
		return autoSixValidPayValue;
	}

	/**
	 * Sets the auto six valid pay value.
	 *
	 * @param autoSixValidPayValue the autoSixValidPayValue to set
	 */
	public void setAutoSixValidPayValue(Long autoSixValidPayValue) {
		this.autoSixValidPayValue = autoSixValidPayValue;
	}

	/**
	 * Gets the auto six valid flag.
	 *
	 * @return the autoSixValidFlag
	 */
	public Long getAutoSixValidFlag() {
		return autoSixValidFlag;
	}

	/**
	 * Sets the auto six valid flag.
	 *
	 * @param autoSixValidFlag the autoSixValidFlag to set
	 */
	public void setAutoSixValidFlag(Long autoSixValidFlag) {
		this.autoSixValidFlag = autoSixValidFlag;
	}

}
