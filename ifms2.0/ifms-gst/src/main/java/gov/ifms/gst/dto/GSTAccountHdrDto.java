package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GSTAccountHdrDto implements Serializable {
	public static final String TRN_SCREEN_AH = "AH";

	private long id;
	private String referenceNo;
	private String gstin;
	private LocalDate referenceDt;
	private char isGstinTmpid;
	private String gstinTmpidNo;
	private String partyName;
	private LocalDate paymentDt;
	private Double sgstTax;
	private Double sgstIntr;
	private Double sgstFee;
	private Double sgstPnlty;
	private Double sgstOth;
	private Double sgstTotal;
	private char isEntryMatched;
	private String cinNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public LocalDate getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDate referenceDt) {
		this.referenceDt = referenceDt;
	}

	public char getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(char isGstinTmpid) {
		this.isGstinTmpid = isGstinTmpid;
	}

	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}

	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public LocalDate getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(LocalDate paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Double getSgstTax() {
		return sgstTax;
	}

	public void setSgstTax(Double sgstTax) {
		this.sgstTax = sgstTax;
	}

	public Double getSgstIntr() {
		return sgstIntr;
	}

	public void setSgstIntr(Double sgstIntr) {
		this.sgstIntr = sgstIntr;
	}

	public Double getSgstFee() {
		return sgstFee;
	}

	public void setSgstFee(Double sgstFee) {
		this.sgstFee = sgstFee;
	}

	public Double getSgstPnlty() {
		return sgstPnlty;
	}

	public void setSgstPnlty(Double sgstPnlty) {
		this.sgstPnlty = sgstPnlty;
	}

	public Double getSgstOth() {
		return sgstOth;
	}

	public void setSgstOth(Double sgstOth) {
		this.sgstOth = sgstOth;
	}

	public Double getSgstTotal() {
		return sgstTotal;
	}

	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	public char getIsEntryMatched() {
		return isEntryMatched;
	}

	public void setIsEntryMatched(char isEntryMatched) {
		this.isEntryMatched = isEntryMatched;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public static String getTrnScreenAh() {
		return TRN_SCREEN_AH;
	}
}
