package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TPAO_CIN_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class CINfileData extends BaseEntity implements Serializable {
	
	public static final String TRN_SCREEN_BMS = "FA";

	/** The designation id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIN_FILE_ID")
	private long id;

	/** The bankRate. */
	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	/** The State code. */
	@Column(name = "STATE_CD")
	private short stateCd;

	/** The fileType. */
	@Column(name = "FILE_TYPE_CD")
	private String fileTypeCd;

	/** The payment mode. */
	@Column(name = "PAYMENT_MODE_CD")
	private String paymentModeCd;
	
	/** The IS GSTIN TMPID. */
	@Column(name = "IS_GSTIN_TMPID")
    private String isGstinTmpid;
	
	/** The gstinTmpidNo. */
	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	/** The cpinDtTime. */
	@Column(name = "CPIN_DT_TIME")
	private LocalDate cpinDtTime;

	/** The cpinNo. */
	@Column(name = "CPIN_NO")
	private long cpinNo;

	/** The cinNo. */
	@Column(name = "CIN_NO")
	private String cinNo;

	/** The paymentDt. */
    @Column(name = "PAYMENT_DT")
    private LocalDate paymentDt;
    
    /** The paymentDtTime. */
    @Column(name = "PAYMENT_DT_TIME")
    private LocalDate paymentDtTime;
    
    /** The bankRefNum. */
	@Column(name = "BANK_REF_NUM")
	private long bankRefNum;
	
	/** The utrNum. */
	@Column(name = "UTR_NUM")
	private String utrNum;
	
	/** The instrumentType. */
	@Column(name = "CPIN_DT")
	private String instrumentType;

	/** The instrumentNum. */
	@Column(name = "INSTRUMENT_NUM")
	private long instrumentNum;

	/** The instrumentMicrCd. */
	@Column(name = "INSTRUMENT_MICR_CD")
	private String instrumentMicrCd;

	/** The brIfscCd. */
	@Column(name = "BR_IFSC_CD")
	private String brIfscCd;

	/** The brLocation. */
	@Column(name = "BR_LOCATION")
	private String brLocation;

	/** The brName. */
	@Column(name = "BR_NAME")
	private String brName;

	/** The pymntAckDt. */
	@Column(name = "PYMNT_ACK_DT")
	private LocalDate pymntAckDt;

	/** The pymntAckDtTime. */
	@Column(name = "PYMNT_ACK_DT_TIME")
	private LocalDate pymntAckDtTime;

	/** The ackNum. */
	@Column(name = "ACK_NUM")
	private long ackNum;

	/** The status. */
	@Column(name = "STATUS")
	private String status;

	/** The bankCd. */
	@Column(name = "BANK_CD")
	private String bankCd;
	
	/** The payment mode. */
	@Column(name = "CGST_TAX")
	private Double cgstTax;

	/** The payment mode. */
	@Column(name = "CGST_INTR")
	private Double cgstIntr;

	/** The payment mode. */
	@Column(name = "CGST_FEE")
	private Double cgstFee;

	/** The payment mode. */
	@Column(name = "CGST_PNLTY")
	private Double cgstPnlty;

	/** The payment mode. */
	@Column(name = "CGST_OTH")
	private Double cgstOth;

	/** The payment mode. */
	@Column(name = "CGST_TOTAL")
	private Double cgstTotal;

	/** The payment mode. */
	@Column(name = "IGST_TAX")
	private Double igstTax;

	/** The payment mode. */
	@Column(name = "IGST_INTR")
	private Double igstIntr;

	/** The payment mode. */
	@Column(name = "IGST_FEE")
	private Double igstFee;

	/** The payment mode. */
	@Column(name = "IGST_PNLTY")
	private Double igstPnlty;

	/** The payment mode. */
	@Column(name = "IGST_OTH")
	private Double igstOth;

	/** The payment mode. */
	@Column(name = "IGST_TOTAL")
	private Double igstTotal;

	/** The payment mode. */
	@Column(name = "SGST_TAX")
	private Double sgstTax;

	/** The payment mode. */
	@Column(name = "SGST_INTR")
	private Double sgstIntr;

	/** The payment mode. */
	@Column(name = "SGST_FEE")
	private Double sgstFee;

	@Column(name = "SGST_PNLTY")
	private Double sgstPnlty;

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
	private Double cessPnlty;

	@Column(name = "CESS_OTH")
	private Double cessOth;

	@Column(name = "CESS_TOTAL")
	private Double cessTotal;

	@Column(name = "TOTAL_AMT")
	private Double totalAmt;

	@Column(name = "REPORTING_DT")
	private LocalDate reportingDt;

	@Column(name = "REPORTING_DT_TIME")
	private LocalDate reportingDtTime;
	
	public CINfileData(long id) {
		super();
		this.id = id;
	}

	public CINfileData() {
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

	/**public LocalDate getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(LocalDate cpinDt) {
		this.cpinDt = cpinDt;
	}*/

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

	public static String getTrnScreenBms() {
		return TRN_SCREEN_BMS;
	}

}
