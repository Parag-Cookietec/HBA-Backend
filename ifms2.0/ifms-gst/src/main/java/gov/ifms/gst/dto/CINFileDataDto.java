package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CINFileDataDto implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private long id;

	/** The bankRate. */
	private long paoFileHdrId;

	/** The State code. */
	private short stateCd;

	/** The fileType. */
	private String fileTypeCd;

	/** The payment mode. */
	private String paymentModeCd;

	/** The IS GSTIN TMPID. */
	private String isGstinTmpid;

	/** The gstinTmpidNo. */
	private String gstinTmpidNo;

	/** The cpinDt. */
	private LocalDate cpinDt;

	/** The cpinDtTime. */
	private LocalDate cpinDtTime;

	/** The cpinNo. */
	private long cpinNo;

	/** The cinNo. */
	private String cinNo;

	/** The paymentDt. */
	private LocalDate paymentDt;

	/** The paymentDtTime. */
	private LocalDate paymentDtTime;

	/** The bankRefNum. */
	private long bankRefNum;

	/** The utrNum. */
	private String utrNum;

	/** The instrumentType. */
	private String instrumentType;

	/** The instrumentNum. */
	private long instrumentNum;

	/** The instrumentMicrCd. */
	private String instrumentMicrCd;

	/** The brIfscCd. */
	private String brIfscCd;

	/** The brLocation. */
	private String brLocation;

	/** The brName. */
	private String brName;

	/** The pymntAckDt. */
	private LocalDate pymntAckDt;

	/** The pymntAckDtTime. */
	private LocalDate pymntAckDtTime;

	/** The ackNum. */
	private long ackNum;

	/** The status. */
	private String status;

	/** The bankCd. */
	private String bankCd;

	/** The payment mode. */
	private Double cgstTax;

	/** The payment mode. */
	private Double cgstIntr;

	/** The payment mode. */
	private Double cgstFee;

	/** The payment mode. */
	private Double cgstPnlty;

	/** The payment mode. */
	private Double cgstOth;

	/** The payment mode. */
	private Double cgstTotal;

	/** The payment mode. */
	private Double igstTax;

	/** The payment mode. */
	private Double igstIntr;

	/** The payment mode. */
	private Double igstFee;

	/** The payment mode. */
	private Double igstPnlty;

	/** The payment mode. */
	private Double igstOth;

	/** The payment mode. */
	private Double igstTotal;

	/** The payment mode. */
	private Double sgstTax;

	/** The payment mode. */
	private Double sgstIntr;

	/** The payment mode. */
	private Double sgstFee;

	private Double sgstPnlty;

	private Double sgstOth;

	private Double sgstTotal;

	private Double cessTax;

	private Double cessIntr;

	private Double cessFee;

	private Double cessPnlty;

	private Double cessOth;

	private Double cessTotal;

	private Double totalAmt;

	private LocalDate reportingDt;

	private LocalDate reportingDtTime;

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

	public String getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public String getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(String isGstinTmpid) {
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

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public LocalDate getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(LocalDate paymentDt) {
		this.paymentDt = paymentDt;
	}

	public LocalDate getPaymentDtTime() {
		return paymentDtTime;
	}

	public void setPaymentDtTime(LocalDate paymentDtTime) {
		this.paymentDtTime = paymentDtTime;
	}

	public long getBankRefNum() {
		return bankRefNum;
	}

	public void setBankRefNum(long bankRefNum) {
		this.bankRefNum = bankRefNum;
	}

	public String getUtrNum() {
		return utrNum;
	}

	public void setUtrNum(String utrNum) {
		this.utrNum = utrNum;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public long getInstrumentNum() {
		return instrumentNum;
	}

	public void setInstrumentNum(long instrumentNum) {
		this.instrumentNum = instrumentNum;
	}

	public String getInstrumentMicrCd() {
		return instrumentMicrCd;
	}

	public void setInstrumentMicrCd(String instrumentMicrCd) {
		this.instrumentMicrCd = instrumentMicrCd;
	}

	public String getBrIfscCd() {
		return brIfscCd;
	}

	public void setBrIfscCd(String brIfscCd) {
		this.brIfscCd = brIfscCd;
	}

	public String getBrLocation() {
		return brLocation;
	}

	public void setBrLocation(String brLocation) {
		this.brLocation = brLocation;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public LocalDate getPymntAckDt() {
		return pymntAckDt;
	}

	public void setPymntAckDt(LocalDate pymntAckDt) {
		this.pymntAckDt = pymntAckDt;
	}

	public LocalDate getPymntAckDtTime() {
		return pymntAckDtTime;
	}

	public void setPymntAckDtTime(LocalDate pymntAckDtTime) {
		this.pymntAckDtTime = pymntAckDtTime;
	}

	public long getAckNum() {
		return ackNum;
	}

	public void setAckNum(long ackNum) {
		this.ackNum = ackNum;
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

	public Double getCgstPnlty() {
		return cgstPnlty;
	}

	public void setCgstPnlty(Double cgstPnlty) {
		this.cgstPnlty = cgstPnlty;
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

	public Double getIgstPnlty() {
		return igstPnlty;
	}

	public void setIgstPnlty(Double igstPnlty) {
		this.igstPnlty = igstPnlty;
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

	public Double getCessPnlty() {
		return cessPnlty;
	}

	public void setCessPnlty(Double cessPnlty) {
		this.cessPnlty = cessPnlty;
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

	public LocalDate getReportingDt() {
		return reportingDt;
	}

	public void setReportingDt(LocalDate reportingDt) {
		this.reportingDt = reportingDt;
	}

	public LocalDate getReportingDtTime() {
		return reportingDtTime;
	}

	public void setReportingDtTime(LocalDate reportingDtTime) {
		this.reportingDtTime = reportingDtTime;
	}

}
