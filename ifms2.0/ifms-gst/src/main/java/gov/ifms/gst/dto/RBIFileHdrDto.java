package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RBIFileHdrDto {

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
	private String msgDefIdr;
	private String bizSvcInfo;
	private LocalDateTime creditDttm;
	private String docMsgId;
	private LocalDateTime docCredDttm;
	private String ntfctnId;
	private String ntfctnPgno;
	private String lastPgIndx;
	private LocalDateTime ntfctnCrdDttm;
	private String acctOthrId;
	private String referenceNo;
	private int batchTranxNum;
	private String tnxnEntryNo;
	private Double totEntrySum;
	private String entryRefNum;
	private Date valueDt;
	private Double entryRefAmt;
	private LocalDateTime referenceDt;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
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

	

	public String getLastPgIndx() {
		return lastPgIndx;
	}

	public void setLastPgIndx(String lastPgIndx) {
		this.lastPgIndx = lastPgIndx;
	}

	

	public String getAcctOthrId() {
		return acctOthrId;
	}

	public void setAcctOthrId(String acctOthrId) {
		this.acctOthrId = acctOthrId;
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

	public String getMsgDefIdr() {
		return msgDefIdr;
	}

	public void setMsgDefIdr(String msgDefIdr) {
		this.msgDefIdr = msgDefIdr;
	}

	public String getNtfctnId() {
		return ntfctnId;
	}

	public void setNtfctnId(String ntfctnId) {
		this.ntfctnId = ntfctnId;
	}

	public String getNtfctnPgno() {
		return ntfctnPgno;
	}

	public void setNtfctnPgno(String ntfctnPgno) {
		this.ntfctnPgno = ntfctnPgno;
	}

	public LocalDateTime getNtfctnCrdDttm() {
		return ntfctnCrdDttm;
	}

	public void setNtfctnCrdDttm(LocalDateTime ntfctnCrdDttm) {
		this.ntfctnCrdDttm = ntfctnCrdDttm;
	}

	public int getBatchTranxNum() {
		return batchTranxNum;
	}

	public void setBatchTranxNum(int batchTranxNum) {
		this.batchTranxNum = batchTranxNum;
	}

	public String getTnxnEntryNo() {
		return tnxnEntryNo;
	}

	public void setTnxnEntryNo(String tnxnEntryNo) {
		this.tnxnEntryNo = tnxnEntryNo;
	}

	public Double getTotEntrySum() {
		return totEntrySum;
	}

	public void setTotEntrySum(Double totEntrySum) {
		this.totEntrySum = totEntrySum;
	}

	public String getEntryRefNum() {
		return entryRefNum;
	}

	public void setEntryRefNum(String entryRefNum) {
		this.entryRefNum = entryRefNum;
	}

	public Date getValueDt() {
		return valueDt;
	}

	public void setValueDt(Date valueDt) {
		this.valueDt = valueDt;
	}

	public Double getEntryRefAmt() {
		return entryRefAmt;
	}

	public void setEntryRefAmt(Double entryRefAmt) {
		this.entryRefAmt = entryRefAmt;
	}

}
