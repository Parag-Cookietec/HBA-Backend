package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CinNer {
	
	@JsonProperty("gstin")
	private String gstin;
	
	@JsonProperty("cpin_dt")
	private String cpinDt;
	
	@JsonProperty("cpin_tim")
	private String cpinTim;
	
	@JsonProperty("cpin")
	private long cpin;
	
	@JsonProperty("cin")
	private String cin;
	
	@JsonProperty("payment_dt")
	private String paymentDt;
	
	@JsonProperty("payment_tim")
	private String paymentTim;
	
	@JsonProperty("bank_ref_num")
	private String bankRefNum;
	
	@JsonProperty("utr_num")
	private String utrNum;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("bank_cd")
	private String bankCd;
	
	@JsonProperty("cgst_tax")
	private String cgstTax;
	
	@JsonProperty("cgst_intr")
	private String cgstIntr;
	
	@JsonProperty("cgst_fee")
	private String cgstFee;
	
	@JsonProperty("cgst_pnlty")
	private String cgstPnlty;
	
	@JsonProperty("cgst_oth")
	private String cgstOth;
	
	@JsonProperty("cgst_total")
	private String cgstTotal;
	
	@JsonProperty("igst_tax")
	private String igstTax;
	
	@JsonProperty("igst_intr")
	private String igstIntr;
	
	@JsonProperty("igst_fee")
	private String igstFee;
	
	@JsonProperty("igst_pnlty")
	private String igstPnlty;
	
	@JsonProperty("igst_oth")
	private String igstOth;
	
	@JsonProperty("igst_total")
	private String igstTotal;
	
	@JsonProperty("sgst_tax")
	private String sgstTax;
	
	@JsonProperty("sgst_intr")
	private String sgstIntr;
	
	@JsonProperty("sgst_fee")
	private String sgstFee;
	
	@JsonProperty("sgst_pnlty")
	private String sgstPnlty;
	
	@JsonProperty("sgst_oth")
	private String sgstOth;
	
	@JsonProperty("sgst_total")
	private String sgstTotal;
	
	@JsonProperty("cess_tax")
	private String cessTax;
	
	@JsonProperty("cess_intr")
	private String cessIntr;
	
	@JsonProperty("cess_fee")
	private String cessFee;
	
	@JsonProperty("cess_pnlty")
	private String cessPnlty;
	
	@JsonProperty("cess_oth")
	private String cessOth;
	
	@JsonProperty("cess_total")
	private String cessTotal;
	
	@JsonProperty("total_amt")
	private String totalAmt;
	
	@JsonProperty("reporting_dt")
	private String reportingDt;
	
	@JsonProperty("reporting_tim")
	private String reportingTim;
	
	@JsonProperty("tmpid")
	private String tmpid;

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(String cpinDt) {
		this.cpinDt = cpinDt;
	}

	public String getCpinTim() {
		return cpinTim;
	}

	public void setCpinTim(String cpinTim) {
		this.cpinTim = cpinTim;
	}

	public long getCpin() {
		return cpin;
	}

	public void setCpin(long cpin) {
		this.cpin = cpin;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(String paymentDt) {
		this.paymentDt = paymentDt;
	}

	public String getPaymentTim() {
		return paymentTim;
	}

	public void setPaymentTim(String paymentTim) {
		this.paymentTim = paymentTim;
	}

	public String getBankRefNum() {
		return bankRefNum;
	}

	public void setBankRefNum(String bankRefNum) {
		this.bankRefNum = bankRefNum;
	}

	public String getUtrNum() {
		return utrNum;
	}

	public void setUtrNum(String utrNum) {
		this.utrNum = utrNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankCd() {
		return bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public String getCgstTax() {
		return cgstTax;
	}

	public void setCgstTax(String cgstTax) {
		this.cgstTax = cgstTax;
	}

	public String getCgstIntr() {
		return cgstIntr;
	}

	public void setCgstIntr(String cgstIntr) {
		this.cgstIntr = cgstIntr;
	}

	public String getCgstFee() {
		return cgstFee;
	}

	public void setCgstFee(String cgstFee) {
		this.cgstFee = cgstFee;
	}

	public String getCgstPnlty() {
		return cgstPnlty;
	}

	public void setCgstPnlty(String cgstPnlty) {
		this.cgstPnlty = cgstPnlty;
	}

	public String getCgstOth() {
		return cgstOth;
	}

	public void setCgstOth(String cgstOth) {
		this.cgstOth = cgstOth;
	}

	public String getCgstTotal() {
		return cgstTotal;
	}

	public void setCgstTotal(String cgstTotal) {
		this.cgstTotal = cgstTotal;
	}

	public String getIgstTax() {
		return igstTax;
	}

	public void setIgstTax(String igstTax) {
		this.igstTax = igstTax;
	}

	public String getIgstIntr() {
		return igstIntr;
	}

	public void setIgstIntr(String igstIntr) {
		this.igstIntr = igstIntr;
	}

	public String getIgstFee() {
		return igstFee;
	}

	public void setIgstFee(String igstFee) {
		this.igstFee = igstFee;
	}

	public String getIgstPnlty() {
		return igstPnlty;
	}

	public void setIgstPnlty(String igstPnlty) {
		this.igstPnlty = igstPnlty;
	}

	public String getIgstOth() {
		return igstOth;
	}

	public void setIgstOth(String igstOth) {
		this.igstOth = igstOth;
	}

	public String getIgstTotal() {
		return igstTotal;
	}

	public void setIgstTotal(String igstTotal) {
		this.igstTotal = igstTotal;
	}

	public String getSgstTax() {
		return sgstTax;
	}

	public void setSgstTax(String sgstTax) {
		this.sgstTax = sgstTax;
	}

	public String getSgstIntr() {
		return sgstIntr;
	}

	public void setSgstIntr(String sgstIntr) {
		this.sgstIntr = sgstIntr;
	}

	public String getSgstFee() {
		return sgstFee;
	}

	public void setSgstFee(String sgstFee) {
		this.sgstFee = sgstFee;
	}

	public String getSgstPnlty() {
		return sgstPnlty;
	}

	public void setSgstPnlty(String sgstPnlty) {
		this.sgstPnlty = sgstPnlty;
	}

	public String getSgstOth() {
		return sgstOth;
	}

	public void setSgstOth(String sgstOth) {
		this.sgstOth = sgstOth;
	}

	public String getSgstTotal() {
		return sgstTotal;
	}

	public void setSgstTotal(String sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	public String getCessTax() {
		return cessTax;
	}

	public void setCessTax(String cessTax) {
		this.cessTax = cessTax;
	}

	public String getCessIntr() {
		return cessIntr;
	}

	public void setCessIntr(String cessIntr) {
		this.cessIntr = cessIntr;
	}

	public String getCessFee() {
		return cessFee;
	}

	public void setCessFee(String cessFee) {
		this.cessFee = cessFee;
	}

	public String getCessPnlty() {
		return cessPnlty;
	}

	public void setCessPnlty(String cessPnlty) {
		this.cessPnlty = cessPnlty;
	}

	public String getCessOth() {
		return cessOth;
	}

	public void setCessOth(String cessOth) {
		this.cessOth = cessOth;
	}

	public String getCessTotal() {
		return cessTotal;
	}

	public void setCessTotal(String cessTotal) {
		this.cessTotal = cessTotal;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getReportingDt() {
		return reportingDt;
	}

	public void setReportingDt(String reportingDt) {
		this.reportingDt = reportingDt;
	}

	public String getReportingTim() {
		return reportingTim;
	}

	public void setReportingTim(String reportingTim) {
		this.reportingTim = reportingTim;
	}

	public String getTmpid() {
		return tmpid;
	}

	public void setTmpid(String tmpid) {
		this.tmpid = tmpid;
	}
	
	

}
