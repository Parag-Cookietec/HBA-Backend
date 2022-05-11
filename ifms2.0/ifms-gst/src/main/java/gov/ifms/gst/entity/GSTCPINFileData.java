package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_EOD_CPIN_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class GSTCPINFileData extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_CFD = "CPFD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EOD_CPIN_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "FILE_TYPE_CD")
	private char fileTypeCd;

	@Column(name = "PAYMENT_MODE_CD")
	private String paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private char isGstinTmpid;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_DT")
	private Date cpinDt;

	@Column(name = "CPIN_DT_TIME")
	private LocalDateTime cpinDtTime;

	@Column(name = "CPIN_NO")
	private long cpinNo;

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

	public GSTCPINFileData(long id) {
		super();
		this.id = id;
	}

	public GSTCPINFileData() {
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
