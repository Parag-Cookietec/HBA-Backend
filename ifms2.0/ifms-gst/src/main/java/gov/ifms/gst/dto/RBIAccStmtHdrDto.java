package gov.ifms.gst.dto;

import java.time.LocalDateTime;

public class RBIAccStmtHdrDto {

	private long id;
	private String fileName;
	private long fileTypeCd;
	private String fileType;
	private LocalDateTime fileRecvDt;
	private LocalDateTime fileProcessDt;
	private String fromMembId;
	private String toOrganzationId;
	private String toOthrOrgnztnId;
	private String bizMsgIdr;
	private String bizSvcInfo;
	private LocalDateTime creditDttm;
	private String docMsgId;
	private LocalDateTime docCredDttm;
	private String statementId;
	private String statementPgno;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private String lastPgIndx;
	private LocalDateTime stmtCrdDttm;
	private LocalDateTime stmtFromDttm;
	private LocalDateTime stmtToDttm;
	private String acctOthrId;
	private int totCdtEntryNo;
	private Double totCdtEntrySum;
	private int totDbtEntryNo;
	private Double totDbtEntrySum;

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

	public LocalDateTime getCreditDttm() {
		return creditDttm;
	}

	public void setCreditDttm(LocalDateTime creditDttm) {
		this.creditDttm = creditDttm;
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

}
