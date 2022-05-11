package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.Date;

public class EODCINFileDataDto implements Serializable {
	public static final String TRN_SCREEN_CFD = "CFD";

	private long id;
	private long paoFileHdrId;
	private short stateCd;
	private String fileTypeCd;
	private String paymentModeCd;
	private String isGstinTmpid;
	private String gstinTmpidNo;
	private Date cpinDt;
	private Date cpinDtTime;
	private long cpinNo;
	private String cinNo;
	private Date paymentDt;
	private Date paymentDtTime;
	private long bankRefNum;
	private String utrNo;
	private String instrumentType;
	private long instrumentNum;
	private String instrumentMicrCd;
	private String brIfscCd;
	private String brLocation;
	private String brName;
	private Date paymentAckDt;
	private Date paymentAckDtTime;
	private long ackNum;
	private String Status;
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
	private Date reportingDt;
	private Double totalSgstTax = 0.00;
	private Double totalSgstIntr= 0.00;
	private Double totalSgstFee= 0.00;
	private Double totalSgstPenalty= 0.00;
	private Double totalSgstOth= 0.00;

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

	public Date getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(Date cpinDt) {
		this.cpinDt = cpinDt;
	}

	public Date getCpinDtTime() {
		return cpinDtTime;
	}

	public void setCpinDtTime(Date cpinDtTime) {
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

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Date getPaymentDtTime() {
		return paymentDtTime;
	}

	public void setPaymentDtTime(Date paymentDtTime) {
		this.paymentDtTime = paymentDtTime;
	}

	public long getBankRefNum() {
		return bankRefNum;
	}

	public void setBankRefNum(long bankRefNum) {
		this.bankRefNum = bankRefNum;
	}

	public String getUtrNo() {
		return utrNo;
	}

	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
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

	public Date getPaymentAckDt() {
		return paymentAckDt;
	}

	public void setPaymentAckDt(Date paymentAckDt) {
		this.paymentAckDt = paymentAckDt;
	}

	public Date getPaymentAckDtTime() {
		return paymentAckDtTime;
	}

	public void setPaymentAckDtTime(Date paymentAckDtTime) {
		this.paymentAckDtTime = paymentAckDtTime;
	}

	public long getAckNum() {
		return ackNum;
	}

	public void setAckNum(long ackNum) {
		this.ackNum = ackNum;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	public Date getReportingDt() {
		return reportingDt;
	}

	public void setReportingDt(Date reportingDt) {
		this.reportingDt = reportingDt;
	}

	public static String getTrnScreenCfd() {
		return TRN_SCREEN_CFD;
	}

	public Double getTotalSgstTax() {
		return totalSgstTax;
	}

	public void setTotalSgstTax(Double totalSgstTax) {
		this.totalSgstTax = totalSgstTax;
	}

	public Double getTotalSgstIntr() {
		return totalSgstIntr;
	}

	public void setTotalSgstIntr(Double totalSgstIntr) {
		this.totalSgstIntr = totalSgstIntr;
	}

	public Double getTotalSgstFee() {
		return totalSgstFee;
	}

	public void setTotalSgstFee(Double totalSgstFee) {
		this.totalSgstFee = totalSgstFee;
	}

	public Double getTotalSgstPenalty() {
		return totalSgstPenalty;
	}

	public void setTotalSgstPenalty(Double totalSgstPenalty) {
		this.totalSgstPenalty = totalSgstPenalty;
	}

	public Double getTotalSgstOth() {
		return totalSgstOth;
	}

	public void setTotalSgstOth(Double totalSgstOth) {
		this.totalSgstOth = totalSgstOth;
	}

}
