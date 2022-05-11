package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_NONRECON_GST_DATA", schema = GSTConstant.GST_SCHEMA)
public class NonReconGstData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_NGD = "NGD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NONRECON_GST_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "NER_RECON_DT")
	private Date nerReconDt;

	@Column(name = "OTHR_MODE_RECON_DT")
	private Date othrModeReconDt;

	@Column(name = "RECON_TYPE_CD")
	private String reconTypeCd;

	@Column(name = "PAYMENT_MODE_CD")
	private String paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private String isGstinTmpid;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_NO")
	private long cpinNo;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "BANK_REF_NUM")
	private long bankRefNum;

	@Column(name = "UTR_NUM")
	private String utrNo;

	@Column(name = "CGST_TOTAL")
	private Double cgstTotal;

	@Column(name = "IGST_TOTAL")
	private Double igstTotal;

	@Column(name = "SGST_TOTAL")
	private Double sgstTotal;

	@Column(name = "CESS_TOTAL")
	private Double cessTotal;

	public NonReconGstData(Long id) {
		super();
		this.id = id;
	}

	public NonReconGstData() {
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

	public Date getNerReconDt() {
		return nerReconDt;
	}

	public void setNerReconDt(Date nerReconDt) {
		this.nerReconDt = nerReconDt;
	}

	public Date getOthrModeReconDt() {
		return othrModeReconDt;
	}

	public void setOthrModeReconDt(Date othrModeReconDt) {
		this.othrModeReconDt = othrModeReconDt;
	}

	public String getReconTypeCd() {
		return reconTypeCd;
	}

	public void setReconTypeCd(String reconTypeCd) {
		this.reconTypeCd = reconTypeCd;
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

	public Double getCgstTotal() {
		return cgstTotal;
	}

	public void setCgstTotal(Double cgstTotal) {
		this.cgstTotal = cgstTotal;
	}

	public Double getIgstTotal() {
		return igstTotal;
	}

	public void setIgstTotal(Double igstTotal) {
		this.igstTotal = igstTotal;
	}

	public Double getSgstTotal() {
		return sgstTotal;
	}

	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	public Double getCessTotal() {
		return cessTotal;
	}

	public void setCessTotal(Double cessTotal) {
		this.cessTotal = cessTotal;
	}

	public static String getTrnScreenNgd() {
		return TRN_SCREEN_NGD;
	}

}
