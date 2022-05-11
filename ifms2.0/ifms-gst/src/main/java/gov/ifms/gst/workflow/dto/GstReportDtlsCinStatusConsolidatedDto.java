package gov.ifms.gst.workflow.dto;

import java.sql.Date;
import java.sql.Timestamp;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCinStatusConsolidatedDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCinStatusConsolidatedDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls cin status dto.
	 */
	public GstReportDtlsCinStatusConsolidatedDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String gstin;
	@NativeQueryResultColumn(index = 1)
	private String cpin;
	@NativeQueryResultColumn(index = 2)
	private Timestamp cpinDateTime;
	@NativeQueryResultColumn(index = 3)
	private String cin;
	@NativeQueryResultColumn(index = 4)
	private Timestamp reportingDateTime;
	@NativeQueryResultColumn(index = 5)
	private String bankCd;
	@NativeQueryResultColumn(index = 6)
	private String instrumentType;
	@NativeQueryResultColumn(index = 7)
	private Integer bankReferenceNumber;
	@NativeQueryResultColumn(index = 8)
	private String paymentModeCd;
	@NativeQueryResultColumn(index = 9)
	private Double cgstTax;
	@NativeQueryResultColumn(index = 10)
	private Double cgstInterest;
	@NativeQueryResultColumn(index = 11)
	private Double cgstFee;
	@NativeQueryResultColumn(index = 12)
	private Double cgstPenalty;
	@NativeQueryResultColumn(index = 13)
	private Double cgstOther;
	@NativeQueryResultColumn(index = 14)
	private Double cgstTotal;
	@NativeQueryResultColumn(index = 15)
	private Double igstTax;
	@NativeQueryResultColumn(index = 16)
	private Double igstInterest;
	@NativeQueryResultColumn(index = 17)
	private Double igstFee;
	@NativeQueryResultColumn(index = 18)
	private Double igstPenalty;
	@NativeQueryResultColumn(index = 19)
	private Double igstOther;
	@NativeQueryResultColumn(index = 20)
	private Double igstTotal;	
	@NativeQueryResultColumn(index = 21)
	private Double sgstTax;
	@NativeQueryResultColumn(index = 22)
	private Double sgstInterest;
	@NativeQueryResultColumn(index = 23)
	private Double sgstFee;
	@NativeQueryResultColumn(index = 24)
	private Double sgstPenalty;
	@NativeQueryResultColumn(index = 25)
	private Double sgstOther;
	@NativeQueryResultColumn(index = 26)
	private Double sgstTotal;	
	@NativeQueryResultColumn(index = 27)
	private Double cessTax;
	@NativeQueryResultColumn(index = 28)
	private Double cessInterest;
	@NativeQueryResultColumn(index = 29)
	private Double cessFee;
	@NativeQueryResultColumn(index = 30)
	private Double cessPenalty;
	@NativeQueryResultColumn(index = 31)
	private Double cessOther;
	@NativeQueryResultColumn(index = 32)
	private Double cessTotal;
	@NativeQueryResultColumn(index = 33)
	private String scrollNumber;
	@NativeQueryResultColumn(index = 34)
	private Timestamp scrollDate;
	@NativeQueryResultColumn(index = 35)
	private Date creditDate;


	public GstReportDtlsCinStatusConsolidatedDto(String gstin, String cpin, Timestamp cpinDateTime, String cin,
			Timestamp reportingDateTime, String bankCd, String instrumentType, Integer bankReferenceNumber,
			String paymentModeCd, Double cgstTax, Double cgstInterest, Double cgstFee, Double cgstPenalty,
			Double cgstOther, Double cgstTotal, Double igstTax, Double igstInterest, Double igstFee, Double igstPenalty,
			Double igstOther, Double igstTotal, Double sgstTax, Double sgstInterest, Double sgstFee, Double sgstPenalty,
			Double sgstOther, Double sgstTotal, Double cessTax, Double cessInterest, Double cessFee, Double cessPenalty,
			Double cessOther, Double cessTotal, String scrollNumber, Timestamp scrollDate, Date creditDate) {
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
		this.cgstTax = cgstTax;
		this.cgstInterest = cgstInterest;
		this.cgstFee = cgstFee;
		this.cgstPenalty = cgstPenalty;
		this.cgstOther = cgstOther;
		this.cgstTotal = cgstTotal;
		this.igstTax = igstTax;
		this.igstInterest = igstInterest;
		this.igstFee = igstFee;
		this.igstPenalty = igstPenalty;
		this.igstOther = igstOther;
		this.igstTotal = igstTotal;
		this.sgstTax = sgstTax;
		this.sgstInterest = sgstInterest;
		this.sgstFee = sgstFee;
		this.sgstPenalty = sgstPenalty;
		this.sgstOther = sgstOther;
		this.sgstTotal = sgstTotal;
		this.cessTax = cessTax;
		this.cessInterest = cessInterest;
		this.cessFee = cessFee;
		this.cessPenalty = cessPenalty;
		this.cessOther = cessOther;
		this.cessTotal = cessTotal;
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


	public Timestamp getCpinDateTime() {
		return cpinDateTime;
	}


	public void setCpinDateTime(Timestamp cpinDateTime) {
		this.cpinDateTime = cpinDateTime;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Timestamp getReportingDateTime() {
		return reportingDateTime;
	}


	public void setReportingDateTime(Timestamp reportingDateTime) {
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


	public Double getCgstTax() {
		return cgstTax;
	}


	public void setCgstTax(Double cgstTax) {
		this.cgstTax = cgstTax;
	}


	public Double getCgstInterest() {
		return cgstInterest;
	}


	public void setCgstInterest(Double cgstInterest) {
		this.cgstInterest = cgstInterest;
	}


	public Double getCgstFee() {
		return cgstFee;
	}


	public void setCgstFee(Double cgstFee) {
		this.cgstFee = cgstFee;
	}


	public Double getCgstPenalty() {
		return cgstPenalty;
	}


	public void setCgstPenalty(Double cgstPenalty) {
		this.cgstPenalty = cgstPenalty;
	}


	public Double getCgstOther() {
		return cgstOther;
	}


	public void setCgstOther(Double cgstOther) {
		this.cgstOther = cgstOther;
	}


	public Double getCgstTotal() {
		return cgstTotal;
	}


	public void setCgstTotal(Double cgstTotal) {
		this.cgstTotal = cgstTotal;
	}


	public Double getIgstTax() {
		return igstTax;
	}


	public void setIgstTax(Double igstTax) {
		this.igstTax = igstTax;
	}


	public Double getIgstInterest() {
		return igstInterest;
	}


	public void setIgstInterest(Double igstInterest) {
		this.igstInterest = igstInterest;
	}


	public Double getIgstFee() {
		return igstFee;
	}


	public void setIgstFee(Double igstFee) {
		this.igstFee = igstFee;
	}


	public Double getIgstPenalty() {
		return igstPenalty;
	}


	public void setIgstPenalty(Double igstPenalty) {
		this.igstPenalty = igstPenalty;
	}


	public Double getIgstOther() {
		return igstOther;
	}


	public void setIgstOther(Double igstOther) {
		this.igstOther = igstOther;
	}


	public Double getIgstTotal() {
		return igstTotal;
	}


	public void setIgstTotal(Double igstTotal) {
		this.igstTotal = igstTotal;
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


	public Double getCessTax() {
		return cessTax;
	}


	public void setCessTax(Double cessTax) {
		this.cessTax = cessTax;
	}


	public Double getCessInterest() {
		return cessInterest;
	}


	public void setCessInterest(Double cessInterest) {
		this.cessInterest = cessInterest;
	}


	public Double getCessFee() {
		return cessFee;
	}


	public void setCessFee(Double cessFee) {
		this.cessFee = cessFee;
	}


	public Double getCessPenalty() {
		return cessPenalty;
	}


	public void setCessPenalty(Double cessPenalty) {
		this.cessPenalty = cessPenalty;
	}


	public Double getCessOther() {
		return cessOther;
	}


	public void setCessOther(Double cessOther) {
		this.cessOther = cessOther;
	}


	public Double getCessTotal() {
		return cessTotal;
	}


	public void setCessTotal(Double cessTotal) {
		this.cessTotal = cessTotal;
	}


	public String getScrollNumber() {
		return scrollNumber;
	}


	public void setScrollNumber(String scrollNumber) {
		this.scrollNumber = scrollNumber;
	}


	public Timestamp getScrollDate() {
		return scrollDate;
	}


	public void setScrollDate(Timestamp scrollDate) {
		this.scrollDate = scrollDate;
	}


	public Date getCreditDate() {
		return creditDate;
	}


	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}

	
}
