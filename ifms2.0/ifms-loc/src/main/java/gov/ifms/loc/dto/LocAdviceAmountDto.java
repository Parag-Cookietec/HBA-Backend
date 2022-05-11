package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class LocAdviceAmountDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Amount.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long amount;

	/**
	 * The LC No.
	 */
	@NativeQueryResultColumn(index = 1)
	private String lcNumber;



	/**
	 * The Amount type.
	 */
	@NativeQueryResultColumn(index = 2)
	private String amountType;

	/**
	 * @return the lcNumber
	 */
	public String getLcNumber() {
		return lcNumber;
	}

	/**
	 * @param lcNumber the lcNumber to set
	 */
	public void setLcNumber(String lcNumber) {
		this.lcNumber = lcNumber;
	}

	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountType
	 */
	public String getAmountType() {
		return amountType;
	}

	/**
	 * @param amountType the amountType to set
	 */
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

}
