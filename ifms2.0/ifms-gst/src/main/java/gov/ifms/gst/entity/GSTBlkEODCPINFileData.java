package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TPAO_BLK_EODCPIN_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class GSTBlkEODCPINFileData extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_BMS = "GBLEF";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLK_EOD_CIN_FILE_ID")
	private Long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private Long fileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "FILE_TYPE_CD")
	private char fileTypeCd;

	@Column(name = "PAYMENT_MODE_CD")
	private char paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private char IsGstinTmpid;

	@Column(name = "GSTN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_DT")
	private LocalDate cpinDt;

	@Column(name = "CPIN_DT_TIME")
	private LocalDate cpinDtTime;

	@Column(name = "CPIN_NO")
	private Long cpinNo;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "BLOCKED_BY")
	private String blockedBy;

	@Column(name = "BLOCKED_DT")
	private LocalDate blockedDt;

	@Column(name = "BLOCKED_DT_TIME")
	private LocalDate blockedDtTime;
	
	public GSTBlkEODCPINFileData(Long id) {
		super();
		this.id = id;
	}

	public GSTBlkEODCPINFileData() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFileHdrId() {
		return fileHdrId;
	}

	public void setFileHdrId(Long fileHdrId) {
		this.fileHdrId = fileHdrId;
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

	public char getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(char paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public char getIsGstinTmpid() {
		return IsGstinTmpid;
	}

	public void setIsGstinTmpid(char isGstinTmpid) {
		IsGstinTmpid = isGstinTmpid;
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

	public Long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(Long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public String getBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(String blockedBy) {
		this.blockedBy = blockedBy;
	}

	public LocalDate getBlockedDt() {
		return blockedDt;
	}

	public void setBlockedDt(LocalDate blockedDt) {
		this.blockedDt = blockedDt;
	}

	public LocalDate getBlockedDtTime() {
		return blockedDtTime;
	}

	public void setBlockedDtTime(LocalDate blockedDtTime) {
		this.blockedDtTime = blockedDtTime;
	}

	public static String getTrnScreenBms() {
		return TRN_SCREEN_BMS;
	}

}
