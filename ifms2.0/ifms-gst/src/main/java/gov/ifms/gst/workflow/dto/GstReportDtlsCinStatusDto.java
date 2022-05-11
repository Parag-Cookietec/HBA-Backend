package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCinStatusDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCinStatusDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls cin status dto.
	 */
	public GstReportDtlsCinStatusDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String gstin;
	@NativeQueryResultColumn(index = 1)
	private String cpin;
	@NativeQueryResultColumn(index = 2)
	private Date cpinDateTime;
	@NativeQueryResultColumn(index = 3)
	private String cin;
	@NativeQueryResultColumn(index = 4)
	private Date reportingDateTime;
	@NativeQueryResultColumn(index = 5)
	private String bankCd;
	@NativeQueryResultColumn(index = 6)
	private String instrumentType;
	@NativeQueryResultColumn(index = 7)
	private Integer bankReferenceNumber;
	@NativeQueryResultColumn(index = 8)
	private String paymentModeCd;
	@NativeQueryResultColumn(index = 9)
	private Double sgstTax;
	@NativeQueryResultColumn(index = 10)
	private Double sgstInterest;
	@NativeQueryResultColumn(index = 11)
	private Double sgstFee;
	@NativeQueryResultColumn(index = 12)
	private Double sgstPenalty;
	@NativeQueryResultColumn(index = 13)
	private Double sgstOther;
	@NativeQueryResultColumn(index = 14)
	private Double sgstTotal;
	@NativeQueryResultColumn(index = 15)
	private String scrollNumber;
	@NativeQueryResultColumn(index = 16)
	private Date scrollDate;
	@NativeQueryResultColumn(index = 17)
	private Date creditDate;


	public GstReportDtlsCinStatusDto(final String gstin, final String cpin, final Date cpinDateTime, final String cin, final Date reportingDateTime,
			final String bankCd, final String instrumentType, final Integer bankReferenceNumber, final String paymentModeCd, final Double sgstTax,
			final Double sgstInterest, final Double sgstFee, final Double sgstPenalty, final Double sgstOther, final Double sgstTotal,
			final String scrollNumber, final Date scrollDate, final Date creditDate) {
		super();
		this.gstin = gstin;
		this.cpin = cpin;
		this.cpinDateTime = cpinDateTime;
		this.cin = cin;
		this.reportingDateTime = reportingDateTime;
		this.bankCd = bankCd;
		this.instrumentType = instrumentType;
		this.bankReferenceNumber = bankReferenceNumber;
		this.paymentModeCd = paymentModeCd;
		this.sgstTax = sgstTax;
		this.sgstInterest = sgstInterest;
		this.sgstFee = sgstFee;
		this.sgstPenalty = sgstPenalty;
		this.sgstOther = sgstOther;
		this.sgstTotal = sgstTotal;
		this.scrollNumber = scrollNumber;
		this.scrollDate = scrollDate;
		this.creditDate = creditDate;
	}


	public String getGstin() {
		return gstin;
	}


	public void setGstin(String gstin) {
		this.gstin = gstin;
	}


	public String getCpin() {
		return cpin;
	}


	public void setCpin(String cpin) {
		this.cpin = cpin;
	}


	public Date getCpinDateTime() {
		return cpinDateTime;
	}


	public void setCpinDateTime(Date cpinDateTime) {
		this.cpinDateTime = cpinDateTime;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Date getReportingDateTime() {
		return reportingDateTime;
	}


	public void setReportingDateTime(Date reportingDateTime) {
		this.reportingDateTime = reportingDateTime;
	}


	public String getBankCd() {
		return bankCd;
	}


	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}


	public String getInstrumentType() {
		return instrumentType;
	}


	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}


	public Integer getBankReferenceNumber() {
		return bankReferenceNumber;
	}


	public void setBankReferenceNumber(Integer bankReferenceNumber) {
		this.bankReferenceNumber = bankReferenceNumber;
	}


	public String getPaymentModeCd() {
		return paymentModeCd;
	}


	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
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


	public String getScrollNumber() {
		return scrollNumber;
	}


	public void setScrollNumber(String scrollNumber) {
		this.scrollNumber = scrollNumber;
	}


	public Date getScrollDate() {
		return scrollDate;
	}


	public void setScrollDate(Date scrollDate) {
		this.scrollDate = scrollDate;
	}


	public Date getCreditDate() {
		return creditDate;
	}


	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}
	
	
}
