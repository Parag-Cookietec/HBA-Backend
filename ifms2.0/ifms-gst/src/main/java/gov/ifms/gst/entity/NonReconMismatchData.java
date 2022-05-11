package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_NONRECON_MISMATCH_DATA", schema = GSTConstant.GST_SCHEMA)
public class NonReconMismatchData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_NMD = "NMD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NONRECON_MISMATCH_ID")
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

	@Column(name = "RBI_CIN_NO")
	private String rbiCinNo;

	@Column(name = "RBI_PAYMENT_DT")
	private Date rbiPaymentDt;

	@Column(name = "RBI_PAYMENT_DT_TIME")
	private Date rbiPaymentDtTime;

	@Column(name = "RBI_BANK_REF_NUM")
	private long rbiBankRefNum;

	@Column(name = "RBI_PAYMENT_MODE")
	private String rbiPaymentMode;

	@Column(name = "RBI_E_SCROLL_NUM")
	private long rbiEScrollNum;

	@Column(name = "GST_CIN_NO")
	private String gstCinNo;

	@Column(name = "GST_PAYMENT_DT")
	private Date gstPaymentDt;

	@Column(name = "GST_PAYMENT_DT_TIME")
	private Date gstPaymentDtTime;

	@Column(name = "GST_BANK_REF_NUM")
	private long gstBankRefNum;

	@Column(name = "GST_PAYMENT_MODE")
	private String gstPaymentMode;

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

	public String getRbiCinNo() {
		return rbiCinNo;
	}

	public void setRbiCinNo(String rbiCinNo) {
		this.rbiCinNo = rbiCinNo;
	}

	public Date getRbiPaymentDt() {
		return rbiPaymentDt;
	}

	public void setRbiPaymentDt(Date rbiPaymentDt) {
		this.rbiPaymentDt = rbiPaymentDt;
	}

	public Date getRbiPaymentDtTime() {
		return rbiPaymentDtTime;
	}

	public void setRbiPaymentDtTime(Date rbiPaymentDtTime) {
		this.rbiPaymentDtTime = rbiPaymentDtTime;
	}

	public long getRbiBankRefNum() {
		return rbiBankRefNum;
	}

	public void setRbiBankRefNum(long rbiBankRefNum) {
		this.rbiBankRefNum = rbiBankRefNum;
	}

	public String getRbiPaymentMode() {
		return rbiPaymentMode;
	}

	public void setRbiPaymentMode(String rbiPaymentMode) {
		this.rbiPaymentMode = rbiPaymentMode;
	}

	public long getRbiEScrollNum() {
		return rbiEScrollNum;
	}

	public void setRbiEScrollNum(long rbiEScrollNum) {
		this.rbiEScrollNum = rbiEScrollNum;
	}

	public String getGstCinNo() {
		return gstCinNo;
	}

	public void setGstCinNo(String gstCinNo) {
		this.gstCinNo = gstCinNo;
	}

	public Date getGstPaymentDt() {
		return gstPaymentDt;
	}

	public void setGstPaymentDt(Date gstPaymentDt) {
		this.gstPaymentDt = gstPaymentDt;
	}

	public Date getGstPaymentDtTime() {
		return gstPaymentDtTime;
	}

	public void setGstPaymentDtTime(Date gstPaymentDtTime) {
		this.gstPaymentDtTime = gstPaymentDtTime;
	}

	public long getGstBankRefNum() {
		return gstBankRefNum;
	}

	public void setGstBankRefNum(long gstBankRefNum) {
		this.gstBankRefNum = gstBankRefNum;
	}

	public String getGstPaymentMode() {
		return gstPaymentMode;
	}

	public void setGstPaymentMode(String gstPaymentMode) {
		this.gstPaymentMode = gstPaymentMode;
	}

	public static String getTrnScreenNmd() {
		return TRN_SCREEN_NMD;
	}

	public NonReconMismatchData(Long id) {
		super();
		this.id = id;
	}

	public NonReconMismatchData() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
