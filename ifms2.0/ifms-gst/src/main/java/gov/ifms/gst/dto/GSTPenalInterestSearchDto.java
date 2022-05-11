package gov.ifms.gst.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class GSTPenalInterestSearchDto   implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getModeOfReceiptId() {
		return modeOfReceiptId;
	}

	public void setModeOfReceiptId(Long modeOfReceiptId) {
		this.modeOfReceiptId = modeOfReceiptId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The Bank Id. */
	@NotNull
	private Long bankId;

	/** From date*/
	@NotNull
	private Date fromDate;

	/** To date*/
	@NotNull
	private Date toDate;

	/** Mode of receipt*/
	@NotNull
	private Long modeOfReceiptId;

	
}
