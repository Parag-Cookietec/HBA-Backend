package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_RECON_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class ReconFileData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RMRH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECON_FILE_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "PAYMENT_MODE_CD")
	private char paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private char isGstinTmpid;

	@Column(name = "RECON_TYPE_CD")
	private char reconTypeCd;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_NO")
	private long cpinNo;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "E_SCROLL_NUM")
	private long eScrollNum;

	@Column(name = "NER_RECON_DT")
	private Date nerReconDt;

	@Column(name = "OTHR_MODE_RECON_DT")
	private Date othrModeReconDt;

	public ReconFileData(Long id) {
		super();
		this.id = id;
	}

	public ReconFileData() {
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

	public char getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(char paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public char getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(char isGstinTmpid) {
		this.isGstinTmpid = isGstinTmpid;
	}

	public char getReconTypeCd() {
		return reconTypeCd;
	}

	public void setReconTypeCd(char reconTypeCd) {
		this.reconTypeCd = reconTypeCd;
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

	public long geteScrollNum() {
		return eScrollNum;
	}

	public void seteScrollNum(long eScrollNum) {
		this.eScrollNum = eScrollNum;
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

	public static String getTrnScreenLbao() {
		return TRN_SCREEN_LBAO;
	}

}
