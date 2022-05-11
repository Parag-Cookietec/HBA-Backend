package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsEodCpinDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsEodCpinDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls eod cpin dto.
	 */
	public GstReportDtlsEodCpinDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String gstIn;
	@NativeQueryResultColumn(index = 1)
	private String cin;
	@NativeQueryResultColumn(index = 2)
	private String bank;
	@NativeQueryResultColumn(index = 3)
	private Date cpinDate;
	@NativeQueryResultColumn(index = 4)
	private Double sgstTax;
	@NativeQueryResultColumn(index = 5)
	private Double sgstInterest;
	@NativeQueryResultColumn(index = 6)
	private Double sgstFee;
	@NativeQueryResultColumn(index = 7)
	private Double sgstPenalty;
	@NativeQueryResultColumn(index = 8)
	private Double sgstOther;
	@NativeQueryResultColumn(index = 9)
	private Double sgstTotal;
	@NativeQueryResultColumn(index = 10)
	private String paymentMode;


	public GstReportDtlsEodCpinDto(final String gstIn, final String cin, final String bank, final Date cpinDate, final Double sgstTax,
			final Double sgstInterest, final Double sgstFee, final Double sgstPenalty, final Double sgstOther, final Double sgstTotal,
			final String paymentMode) {
		super();
		this.gstIn = gstIn;
		this.cin = cin;
		this.bank = bank;
		this.cpinDate = cpinDate;
		this.sgstTax = sgstTax;
		this.sgstInterest = sgstInterest;
		this.sgstFee = sgstFee;
		this.sgstPenalty = sgstPenalty;
		this.sgstOther = sgstOther;
		this.sgstTotal = sgstTotal;
		this.paymentMode = paymentMode;
	}


	public String getGstIn() {
		return gstIn;
	}


	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public Date getCpinDate() {
		return cpinDate;
	}


	public void setCpinDate(Date cpinDate) {
		this.cpinDate = cpinDate;
	}


	public Double getSgstTax() {
		return sgstTax;
	}


	public void setSgstTax(Double sgstTax) {
		this.sgstTax = sgstTax;
	}


	public Double getSgstInterest() {
		return sgstInterest;
	}


	public void setSgstInterest(Double sgstInterest) {
		this.sgstInterest = sgstInterest;
	}


	public Double getSgstFee() {
		return sgstFee;
	}


	public void setSgstFee(Double sgstFee) {
		this.sgstFee = sgstFee;
	}


	public Double getSgstPenalty() {
		return sgstPenalty;
	}


	public void setSgstPenalty(Double sgstPenalty) {
		this.sgstPenalty = sgstPenalty;
	}


	public Double getSgstOther() {
		return sgstOther;
	}


	public void setSgstOther(Double sgstOther) {
		this.sgstOther = sgstOther;
	}


	public Double getSgstTotal() {
		return sgstTotal;
	}


	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


}
