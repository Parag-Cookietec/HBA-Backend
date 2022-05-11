package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TPAO_RBI_ACC_STMT_HDR", schema = GSTConstant.GST_SCHEMA)
public class RBIAccStmtHdr extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_RASH = "RASH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_ACC_STMT_ID")
	private long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_TYPE_CD")
	private long fileTypeCd;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Column(name = "FILE_RECV_DT")
	private LocalDateTime fileRecvDt;

	@Column(name = "FILE_PROCESS_DT")
	private LocalDateTime fileProcessDt;

	@Column(name = "FROM_MEMB_ID")
	private String fromMembId;

	@Column(name = "TO_ORGANZATION_ID")
	private String toOrganzationId;

	@Column(name = "TO_OTHR_ORGNZTN_ID")
	private String toOthrOrgnztnId;

	@Column(name = "BIZ_MSG_IDR")
	private String bizMsgIdr;

	@Column(name = "BIZ_SVC_INFO")
	private String bizSvcInfo;

	@Column(name = "CREDIT_DTTM")
	private LocalDateTime creDtTm;

	@Column(name = "DOC_MSG_ID")
	private String docMsgId;

	@Column(name = "DOC_CRED_DTTM")
	private LocalDateTime docCredDttm;

	@Column(name = "STATEMENT_ID")
	private String statementId;

	@Column(name = "STATEMENT_PGNO")
	private String statementPgno;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "LAST_PG_INDX")
	private String lastPgIndx;

	@Column(name = "STMT_CRD_DTTM")
	private LocalDateTime stmtCrdDttm;

	@Column(name = "STMT_FROM_DTTM")
	private LocalDateTime stmtFromDttm;

	@Column(name = "STMT_TO_DTTM")
	private LocalDateTime stmtToDttm;

	@Column(name = "ACCT_OTHR_ID")
	private String acctOthrId;

	@Column(name = "TOT_CDT_ENTRY_NO")
	private int totCdtEntryNo;

	@Column(name = "TOT_CDT_ENTRY_SUM")
	private Double totCdtEntrySum;

	@Column(name = "TOT_DBT_ENTRY_NO")
	private int totDbtEntryNo;

	@Column(name = "TOT_DBT_ENTRY_SUM")
	private Double totDbtEntrySum;

	public RBIAccStmtHdr(Long id) {
		super();
		this.id = id;
	}

	public RBIAccStmtHdr() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileNumber() {
		return fileName;
	}

	public void setFileNumber(String fileName) {
		this.fileName = fileName;
	}

	public long getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(long fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public LocalDateTime getFileRecvDt() {
		return fileRecvDt;
	}

	public void setFileRecvDt(LocalDateTime fileRecvDt) {
		this.fileRecvDt = fileRecvDt;
	}

	public LocalDateTime getFileProcessDt() {
		return fileProcessDt;
	}

	public void setFileProcessDt(LocalDateTime fileProcessDt) {
		this.fileProcessDt = fileProcessDt;
	}

	public String getFromMembId() {
		return fromMembId;
	}

	public void setFromMembId(String fromMembId) {
		this.fromMembId = fromMembId;
	}

	public String getToOrganzationId() {
		return toOrganzationId;
	}

	public void setToOrganzationId(String toOrganzationId) {
		this.toOrganzationId = toOrganzationId;
	}

	public String getToOthrOrgnztnId() {
		return toOthrOrgnztnId;
	}

	public void setToOthrOrgnztnId(String toOthrOrgnztnId) {
		this.toOthrOrgnztnId = toOthrOrgnztnId;
	}

	public String getBizMsgIdr() {
		return bizMsgIdr;
	}

	public void setBizMsgIdr(String bizMsgIdr) {
		this.bizMsgIdr = bizMsgIdr;
	}

	public String getBizSvcInfo() {
		return bizSvcInfo;
	}

	public void setBizSvcInfo(String bizSvcInfo) {
		this.bizSvcInfo = bizSvcInfo;
	}

	
	public String getDocMsgId() {
		return docMsgId;
	}

	public void setDocMsgId(String docMsgId) {
		this.docMsgId = docMsgId;
	}

	public LocalDateTime getDocCredDttm() {
		return docCredDttm;
	}

	public void setDocCredDttm(LocalDateTime docCredDttm) {
		this.docCredDttm = docCredDttm;
	}

	public String getStatementId() {
		return statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	public String getStatementPgno() {
		return statementPgno;
	}

	public void setStatementPgno(String statementPgno) {
		this.statementPgno = statementPgno;
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

	public String getLastPgIndx() {
		return lastPgIndx;
	}

	public void setLastPgIndx(String lastPgIndx) {
		this.lastPgIndx = lastPgIndx;
	}

	public LocalDateTime getStmtCrdDttm() {
		return stmtCrdDttm;
	}

	public void setStmtCrdDttm(LocalDateTime stmtCrdDttm) {
		this.stmtCrdDttm = stmtCrdDttm;
	}

	public LocalDateTime getStmtFromDttm() {
		return stmtFromDttm;
	}

	public void setStmtFromDttm(LocalDateTime stmtFromDttm) {
		this.stmtFromDttm = stmtFromDttm;
	}

	public LocalDateTime getStmtToDttm() {
		return stmtToDttm;
	}

	public void setStmtToDttm(LocalDateTime stmtToDttm) {
		this.stmtToDttm = stmtToDttm;
	}

	public String getAcctOthrId() {
		return acctOthrId;
	}

	public void setAcctOthrId(String acctOthrId) {
		this.acctOthrId = acctOthrId;
	}

	public int getTotCdtEntryNo() {
		return totCdtEntryNo;
	}

	public void setTotCdtEntryNo(int totCdtEntryNo) {
		this.totCdtEntryNo = totCdtEntryNo;
	}

	public Double getTotCdtEntrySum() {
		return totCdtEntrySum;
	}

	public void setTotCdtEntrySum(Double totCdtEntrySum) {
		this.totCdtEntrySum = totCdtEntrySum;
	}

	public int getTotDbtEntryNo() {
		return totDbtEntryNo;
	}

	public void setTotDbtEntryNo(int totDbtEntryNo) {
		this.totDbtEntryNo = totDbtEntryNo;
	}

	public Double getTotDbtEntrySum() {
		return totDbtEntrySum;
	}

	public void setTotDbtEntrySum(Double totDbtEntrySum) {
		this.totDbtEntrySum = totDbtEntrySum;
	}

	public static String getTrnScreenRash() {
		return TRN_SCREEN_RASH;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDateTime getCreDtTm() {
		return creDtTm;
	}

	public void setCreDtTm(LocalDateTime creDtTm) {
		this.creDtTm = creDtTm;
	}





}
