package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_EOD_CIN_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class EODCINFileData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_GFAC = "GFAC";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EOD_CIN_FILE_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "FILE_TYPE_CD")
	private String fileTypeCd;

	@Column(name = "PAYMENT_MODE_CD")
	private String paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private String isGstinTmpid;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_DT")
	private Date cpinDt;

	@Column(name = "CPIN_DT_TIME")
	private LocalDateTime cpinDtTime;

	@Column(name = "CPIN_NO")
	private long cpinNo;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "PAYMENT_DT")
	private Date paymentDt;

	@Column(name = "PAYMENT_DT_TIME")
	private Date paymentDtTime;

	@Column(name = "BANK_REF_NUM")
	private long bankRefNum;

	@Column(name = "UTR_NUM")
	private String utrNo;

	@Column(name = "INSTRUMENT_TYPE")
	private String instrumentType;

	@Column(name = "INSTRUMENT_NUM")
	private long instrumentNum;

	@Column(name = "INSTRUMENT_MICR_CD")
	private String instrumentMicrCd;

	@Column(name = "BR_IFSC_CD")
	private String brIfscCd;

	@Column(name = "BR_LOCATION")
	private String brLocation;

	@Column(name = "BR_NAME")
	private String brName;

	@Column(name = "PYMNT_ACK_DT")
	private Date paymentAckDt;

	@Column(name = "PYMNT_ACK_DT_TIME")
	private Date paymentAckDtTime;

	@Column(name = "ACK_NUM")
	private long ackNum;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "BANK_CD")
	private String bankCd;

	@Column(name = "CGST_TAX")
	private Double cgstTax;

	@Column(name = "CGST_INTR")
	private Double cgstIntr;

	@Column(name = "CGST_FEE")
	private Double cgstFee;

	@Column(name = "CGST_PNLTY")
	private Double cgstPenalty;

	@Column(name = "CGST_OTH")
	private Double cgstOth;

	@Column(name = "CGST_TOTAL")
	private Double cgstTotal;

	@Column(name = "IGST_TAX")
	private Double igstTax;

	@Column(name = "IGST_INTR")
	private Double igstIntr;

	@Column(name = "IGST_FEE")
	private Double igstFee;

	@Column(name = "IGST_PNLTY")
	private Double igstPenalty;

	@Column(name = "IGST_OTH")
	private Double igstOth;

	@Column(name = "IGST_TOTAL")
	private Double igstTotal;

	@Column(name = "SGST_TAX")
	private Double sgstTax;

	@Column(name = "SGST_INTR")
	private Double sgstIntr;

	@Column(name = "SGST_FEE")
	private Double sgstFee;

	@Column(name = "SGST_PNLTY")
	private Double sgstPenalty;

	@Column(name = "SGST_OTH")
	private Double sgstOth;

	@Column(name = "SGST_TOTAL")
	private Double sgstTotal;

	@Column(name = "CESS_TAX")
	private Double cessTax;

	@Column(name = "CESS_INTR")
	private Double cessIntr;

	@Column(name = "CESS_FEE")
	private Double cessFee;

	@Column(name = "CESS_PNLTY")
	private Double cessPenalty;

	@Column(name = "CESS_OTH")
	private Double cessOth;

	@Column(name = "CESS_TOTAL")
	private Double cessTotal;

	@Column(name = "TOTAL_AMT")
	private Double totalAmt;

	@Column(name = "REPORTING_DT")
	private Date reportingDt;

	public EODCINFileData(long id) {
		super();
		this.id = id;
	}

	public EODCINFileData() {
		super();
	}

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

	public LocalDateTime getCpinDtTime() {
		return cpinDtTime;
	}

	public void setCpinDtTime(LocalDateTime cpinDtTime) {
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

	public void setInstrumentNumber(long instrumentNum) {
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

	public Date getReportingDtTime() {
		return reportingDtTime;
	}

	public void setReportingDtTime(Date reportingDtTime) {
		this.reportingDtTime = reportingDtTime;
	}

	public static String getTrnScreenCfd() {
		return TRN_SCREEN_GFAC;
	}

	@Column(name = "REPORTING_DT_TIME")
	private Date reportingDtTime;

}
