package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsEodcinDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsEodcinDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls eodcin dto.
	 */
	public GstReportDtlsEodcinDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String gstin;
	@NativeQueryResultColumn(index = 1)
	private String cin;
	@NativeQueryResultColumn(index = 2)
	private Date paymentDate;
	@NativeQueryResultColumn(index = 3)
	private String bankCd;
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
	private Date fileDate;


	public GstReportDtlsEodcinDto(final String gstin, final String cin, final Date paymentDate, final String bankCd, final Double sgstTax,
			final Double sgstInterest, final Double sgstFee, final Double sgstPenalty, final Double sgstOther, final Double sgstTotal,
			final Date fileDate) {
		this.gstin = gstin;
		this.cin = cin;
		this.paymentDate = paymentDate;
		this.bankCd = bankCd;
		this.sgstTax = sgstTax;
		this.sgstInterest = sgstInterest;
		this.sgstFee = sgstFee;
		this.sgstPenalty = sgstPenalty;
		this.sgstOther = sgstOther;
		this.sgstTotal = sgstTotal;
		this.fileDate = fileDate;
	}


	public String getGstin() {
		return gstin;
	}


	public void setGstin(String gstin) {
		this.gstin = gstin;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getBankCd() {
		return bankCd;
	}


	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
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


	public Date getFileDate() {
		return fileDate;
	}


	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
}
