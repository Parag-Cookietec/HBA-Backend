package gov.ifms.gst.dto;

import javax.validation.constraints.NotNull;

/**
 * The Class GSTPenalGetClaimAmountParams.
 * 
 * @version v 1.0
 * @created 2021/10/02 14:58:33
 *
 */

public class GSTPenalGetClaimAmountParams {

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	/** The Bank Id. */
	@NotNull
	private Long bankId;

	/** Month */
	@NotNull
	private Long month;

	/** Year */
	@NotNull
	private Long year;


}
