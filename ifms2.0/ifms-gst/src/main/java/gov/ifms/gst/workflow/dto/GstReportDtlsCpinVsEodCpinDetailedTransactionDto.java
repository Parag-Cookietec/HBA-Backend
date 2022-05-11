package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCpinVsEodCpinDetailedTransactionDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCpinVsEodCpinDetailedTransactionDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public GstReportDtlsCpinVsEodCpinDetailedTransactionDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String gstin;
	@NativeQueryResultColumn(index = 1)
	private Long transactionId;
	@NativeQueryResultColumn(index = 2)
	private String cpin;
	@NativeQueryResultColumn(index = 3)
	private String cin;
	@NativeQueryResultColumn(index = 4)
	private Date paymentDate;
	@NativeQueryResultColumn(index = 5)
	private String bankReferenceNumber;
	@NativeQueryResultColumn(index = 6)
	private String paymentMode;
	@NativeQueryResultColumn(index = 7)
	private Double sgstAmount;

	public GstReportDtlsCpinVsEodCpinDetailedTransactionDto(String gstin, Long transactionId, String cpin, String cin,
			Date paymentDate, String bankReferenceNumber, String paymentMode, Double sgstAmount) {
		super();
		this.gstin = gstin;
		this.transactionId = transactionId;
		this.cpin = cpin;
		this.cin = cin;
		this.paymentDate = paymentDate;
		this.bankReferenceNumber = bankReferenceNumber;
		this.paymentMode = paymentMode;
		this.sgstAmount = sgstAmount;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getCpin() {
		return cpin;
	}

	public void setCpin(String cpin) {
		this.cpin = cpin;
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

	public String getBankReferenceNumber() {
		return bankReferenceNumber;
	}

	public void setBankReferenceNumber(String bankReferenceNumber) {
		this.bankReferenceNumber = bankReferenceNumber;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(Double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}


}
