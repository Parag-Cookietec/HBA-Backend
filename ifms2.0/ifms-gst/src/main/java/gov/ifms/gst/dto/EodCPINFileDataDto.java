package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class EodCPINFileDataDto implements Serializable{
	public static final String TRN_SCREEN_CFD = "CPFD";
	
	private long id;
	private long paoFileHdrId;
	private short stateCd;
	private char fileTypeCd;
	private String paymentModeCd;
	private char isGstinTmpid;
	private String gstinTmpidNo;
	private LocalDate cpinDt;
	private LocalDate cpinDtTime;
	private long cpinNo;
	private String bankCd;
	private Double cgstTax;
	private Double cgstIntr;
	private Double cgstFee;
	private Double cgstPenalty;
	private Double cgstOth;
	private Double cgstTotal;
	private Double igstTax;
	private Double igstIntr;
	private Double igstFee;
	private Double igstPenalty;
	private Double igstOth;
	private Double igstTotal;
	private Double sgstTax;
	private Double sgstIntr;
	private Double sgstFee;
	private Double sgstPenalty;
	private Double sgstOth;
	private Double sgstTotal;
	private Double cessTax;
	private Double cessIntr;
	private Double cessFee;
	private Double cessPenalty;
	private Double cessOth;
	private Double cessTotal;
	private Double totalAmt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPaoFileHdrId() {
		return paoFileHdrId;
	}

	public void setPaoFileHdrId(long paoFileHdrId) {
		this.paoFileHdrId = paoFileHdrId;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public char getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(char fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
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

	public LocalDate getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(LocalDate cpinDt) {
		this.cpinDt = cpinDt;
	}

	public LocalDate getCpinDtTime() {
		return cpinDtTime;
	}

	public void setCpinDtTime(LocalDate cpinDtTime) {
		this.cpinDtTime = cpinDtTime;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public String getBankCd() {
		return bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public Double getCgstTax() {
		return cgstTax;
	}

	public void setCgstTax(Double cgstTax) {
		this.cgstTax = cgstTax;
	}

	public Double getCgstIntr() {
		return cgstIntr;
	}

	public void setCgstIntr(Double cgstIntr) {
		this.cgstIntr = cgstIntr;
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

	public Double getCgstOth() {
		return cgstOth;
	}

	public void setCgstOth(Double cgstOth) {
		this.cgstOth = cgstOth;
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

	public Double getIgstIntr() {
		return igstIntr;
	}

	public void setIgstIntr(Double igstIntr) {
		this.igstIntr = igstIntr;
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

	public Double getIgstOth() {
		return igstOth;
	}

	public void setIgstOth(Double igstOth) {
		this.igstOth = igstOth;
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

	public Double getSgstPenalty() {
		return sgstPenalty;
	}

	public void setSgstPenalty(Double sgstPenalty) {
		this.sgstPenalty = sgstPenalty;
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

	public Double getCessTax() {
		return cessTax;
	}

	public void setCessTax(Double cessTax) {
		this.cessTax = cessTax;
	}

	public Double getCessIntr() {
		return cessIntr;
	}

	public void setCessIntr(Double cessIntr) {
		this.cessIntr = cessIntr;
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

	public Double getCessOth() {
		return cessOth;
	}

	public void setCessOth(Double cessOth) {
		this.cessOth = cessOth;
	}

	public Double getCessTotal() {
		return cessTotal;
	}

	public void setCessTotal(Double cessTotal) {
		this.cessTotal = cessTotal;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public static String getTrnScreenCfd() {
		return TRN_SCREEN_CFD;
	}
}
