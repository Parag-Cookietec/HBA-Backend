package gov.ifms.gst.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

@Entity
@Table(name = "TPAO_RBI_FILES_TRANXN", schema = GSTConstant.GST_SCHEMA)
public class RBIFileTranxn extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "LBAO";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_FILE_TRANXN_ID")
	private long id;

	@Column(name = "RBI_FILE_HDR_ID")
	private long rbiFileHdrId;

	@Column(name = "ACT_SRC_REFRENCE")
	private String actSrcRefrence;

	@Column(name = "MESSAGE_ID")
	private String messageId;

	@Column(name = "INSTR_ID")
	private String instrId;

	@Column(name = "END_TO_END_ID")
	private String endToEndId;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "CLR_SYS_REF_NO")
	private String clrSysRefNo;

	@Column(name = "TRANSACTION_AMT")
	private Double transactionAmt;

	@Column(name = "MEMBER_ID")
	private String memberId;

	@Column(name = "TAX_ID")
	private String taxId;

	@Column(name = "ADMINSTRATIVE_ZONE")
	private String adminstrativeZone;

	@Column(name = "TOTAL_TRANS_AMT")
	private Double totalTransAmt;

	@Column(name = "ACCEPTANCE_DTTM")
	private LocalDateTime acceptanceDttm;

	@Column(name = "TRANSACTION_DTTM")
	private LocalDateTime transactionDttm;

	@Column(name = "ADDNL_TRN_INFO")
	private Double addnlTrnInfo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public RBIFileTranxn(Long id) {
		super();
		this.id = id;
	}

	public RBIFileTranxn() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiFileHdrId() {
		return rbiFileHdrId;
	}

	public void setRbiFileHdrId(long rbiFileHdrId) {
		this.rbiFileHdrId = rbiFileHdrId;
	}

	public String getActSrcRefrence() {
		return actSrcRefrence;
	}

	public void setActSrcRefrence(String actSrcRefrence) {
		this.actSrcRefrence = actSrcRefrence;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getEndToEndId() {
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getClrSysRefNo() {
		return clrSysRefNo;
	}

	public void setClrSysRefNo(String clrSysRefNo) {
		this.clrSysRefNo = clrSysRefNo;
	}

	public Double getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(Double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAdminstrativeZone() {
		return adminstrativeZone;
	}

	public void setAdminstrativeZone(String adminstrativeZone) {
		this.adminstrativeZone = adminstrativeZone;
	}

	public Double getTotalTransAmt() {
		return totalTransAmt;
	}

	public void setTotalTransAmt(Double totalTransAmt) {
		this.totalTransAmt = totalTransAmt;
	}

	public LocalDateTime getAcceptanceDttm() {
		return acceptanceDttm;
	}

	public void setAcceptanceDttm(LocalDateTime acceptanceDttm) {
		this.acceptanceDttm = acceptanceDttm;
	}

	public LocalDateTime getTransactionDttm() {
		return transactionDttm;
	}

	public void setTransactionDttm(LocalDateTime transactionDttm) {
		this.transactionDttm = transactionDttm;
	}

	public Double getAddnlTrnInfo() {
		return addnlTrnInfo;
	}

	public void setAddnlTrnInfo(Double addnlTrnInfo) {
		this.addnlTrnInfo = addnlTrnInfo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

}
