/**
 * 
 */
package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocOpeningBalanceDto.
 *
 * @author swath
 */
public class LocOpeningBalanceDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Double newBalanceAmount;

	/** The Name. */
	@NativeQueryResultColumn(index = 1)
	private Double openingBalanceAmount;

	/**
	 * Gets the new balance amount.
	 *
	 * @return the new balance amount
	 */
	public Double getNewBalanceAmount() {
		return newBalanceAmount;
	}

	/**
	 * Sets the new balance amount.
	 *
	 * @param newBalanceAmount the new new balance amount
	 */
	public void setNewBalanceAmount(Double newBalanceAmount) {
		this.newBalanceAmount = newBalanceAmount;
	}

	/**
	 * Gets the opening balance amount.
	 *
	 * @return the opening balance amount
	 */
	public Double getOpeningBalanceAmount() {
		return openingBalanceAmount;
	}

	/**
	 * Sets the opening balance amount.
	 *
	 * @param openingBalanceAmount the new opening balance amount
	 */
	public void setOpeningBalanceAmount(Double openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
	}

}
