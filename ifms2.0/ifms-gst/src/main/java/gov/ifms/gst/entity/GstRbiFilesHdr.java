package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TPAO_RBI_FILES_HDR", schema = GSTConstant.GST_SCHEMA)
public class GstRbiFilesHdr extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="RBI_FILE_HDR_ID")
	private Long id;

	@Column(name ="FILE_NAME")
	private String fileName;

	@Column(name ="FILE_TYPE_CD")
	private String fileTypeCd;

	@Column(name ="FILE_TYPE")
	private String fileType;

	@Column(name ="FILE_RECV_DT")
	private Date fileRecvDt;

	@Column(name ="FILE_PROCESS_DT")
	private Date fileProcessDt;

	@Column(name ="FROM_MEMB_ID")
	private String fromMembId;

	@Column(name ="TO_ORGANZATION_ID")
	private String toOrganizationId;

	@Column(name ="TO_OTHR_ORGNZTN_ID")
	private String toOthrOrgnztnId;

	@Column(name ="BIZ_MSG_IDR")
	private String bizMsgIdr;

	@Column(name ="MSG_DEF_IDR")
	private String msgDefIdr;

	@Column(name ="BIZ_SVC_INFO")
	private String bizSvcInfo;

	@Column(name ="CREDIT_DTTM")
	private String creditDttm;

	@Column(name ="DOC_MSG_ID")
	private String docMsgId;

	@Column(name ="DOC_CRED_DTTM")
	private String docCredDttm;

	@Column(name ="NTFCTN_ID")
	private String ntfctn_id;

	@Column(name ="NTFCTN_PGNO")
	private String ntfctnPgno;

	@Column(name ="LAST_PG_INDX")
	private String lastPgIndx;

	@Column(name ="NTFCTN_CRD_DTTM")
	private String ntfctnCrdDttm;

	@Column(name ="ACCT_OTHR_ID")
	private String acctOthrId;

	@Column(name ="TNXN_ENTRY_NO")
	private String tnxnEntryNo;

	@Column(name ="TOT_ENTRY_SUM")
	private String totEntrySum;

	@Column(name ="ENTRY_REF_NUM")
	private String entryRefNum;

	@Column(name ="ENTRY_REF_AMT")
	private String entryRefAmt;

	@Column(name ="VALUE_DT")
	private String valueDt;

	@Column(name ="BATCH_TRANX_NUM")
	private String batchTranxNum;

	@Column(name ="REFERENCE_NO")
	private String referenceNo;

	@Column(name ="REFERENCE_DT")
	private String referenceDt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RBI_FILE_HDR_ID")
	public List<GstRbiFilesTranxn> rbiFileTranxns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getFileRecvDt() {
		return fileRecvDt;
	}

	public void setFileRecvDt(Date fileRecvDt) {
		this.fileRecvDt = fileRecvDt;
	}

	public Date getFileProcessDt() {
		return fileProcessDt;
	}

	public void setFileProcessDt(Date fileProcessDt) {
		this.fileProcessDt = fileProcessDt;
	}

	public String getFromMembId() {
		return fromMembId;
	}

	public void setFromMembId(String fromMembId) {
		this.fromMembId = fromMembId;
	}

	public String getToOrganizationId() {
		return toOrganizationId;
	}

	public void setToOrganizationId(String toOrganizationId) {
		this.toOrganizationId = toOrganizationId;
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

	public String getMsgDefIdr() {
		return msgDefIdr;
	}

	public void setMsgDefIdr(String msgDefIdr) {
		this.msgDefIdr = msgDefIdr;
	}

	public String getBizSvcInfo() {
		return bizSvcInfo;
	}

	public void setBizSvcInfo(String bizSvcInfo) {
		this.bizSvcInfo = bizSvcInfo;
	}

	public String getCreditDttm() {
		return creditDttm;
	}

	public void setCreditDttm(String creditDttm) {
		this.creditDttm = creditDttm;
	}

	public String getDocMsgId() {
		return docMsgId;
	}

	public void setDocMsgId(String docMsgId) {
		this.docMsgId = docMsgId;
	}

	public String getDocCredDttm() {
		return docCredDttm;
	}

	public void setDocCredDttm(String docCredDttm) {
		this.docCredDttm = docCredDttm;
	}

	public String getNtfctn_id() {
		return ntfctn_id;
	}

	public void setNtfctn_id(String ntfctn_id) {
		this.ntfctn_id = ntfctn_id;
	}

	public String getNtfctnPgno() {
		return ntfctnPgno;
	}

	public void setNtfctnPgno(String ntfctnPgno) {
		this.ntfctnPgno = ntfctnPgno;
	}

	public String getLastPgIndx() {
		return lastPgIndx;
	}

	public void setLastPgIndx(String lastPgIndx) {
		this.lastPgIndx = lastPgIndx;
	}

	public String getNtfctnCrdDttm() {
		return ntfctnCrdDttm;
	}

	public void setNtfctnCrdDttm(String ntfctnCrdDttm) {
		this.ntfctnCrdDttm = ntfctnCrdDttm;
	}

	public String getAcctOthrId() {
		return acctOthrId;
	}

	public void setAcctOthrId(String acctOthrId) {
		this.acctOthrId = acctOthrId;
	}

	public String getTnxnEntryNo() {
		return tnxnEntryNo;
	}

	public void setTnxnEntryNo(String tnxnEntryNo) {
		this.tnxnEntryNo = tnxnEntryNo;
	}

	public String getTotEntrySum() {
		return totEntrySum;
	}

	public void setTotEntrySum(String totEntrySum) {
		this.totEntrySum = totEntrySum;
	}

	public String getEntryRefNum() {
		return entryRefNum;
	}

	public void setEntryRefNum(String entryRefNum) {
		this.entryRefNum = entryRefNum;
	}

	public String getEntryRefAmt() {
		return entryRefAmt;
	}

	public void setEntryRefAmt(String entryRefAmt) {
		this.entryRefAmt = entryRefAmt;
	}

	public String getValueDt() {
		return valueDt;
	}

	public void setValueDt(String valueDt) {
		this.valueDt = valueDt;
	}

	public String getBatchTranxNum() {
		return batchTranxNum;
	}

	public void setBatchTranxNum(String batchTranxNum) {
		this.batchTranxNum = batchTranxNum;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(String referenceDt) {
		this.referenceDt = referenceDt;
	}

	public List<GstRbiFilesTranxn> getRbiFileTranxns() {
		return rbiFileTranxns;
	}

	public void setRbiFileTranxns(List<GstRbiFilesTranxn> rbiFileTranxns) {
		this.rbiFileTranxns = rbiFileTranxns;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GstRbiFilesHdr that = (GstRbiFilesHdr) o;
		return Objects.equals(id, that.id) && Objects.equals(fileName, that.fileName) && Objects.equals(fileTypeCd, that.fileTypeCd) && Objects.equals(fileType, that.fileType) && Objects.equals(fileRecvDt, that.fileRecvDt) && Objects.equals(fileProcessDt, that.fileProcessDt) && Objects.equals(fromMembId, that.fromMembId) && Objects.equals(toOrganizationId, that.toOrganizationId) && Objects.equals(toOthrOrgnztnId, that.toOthrOrgnztnId) && Objects.equals(bizMsgIdr, that.bizMsgIdr) && Objects.equals(msgDefIdr, that.msgDefIdr) && Objects.equals(bizSvcInfo, that.bizSvcInfo) && Objects.equals(creditDttm, that.creditDttm) && Objects.equals(docMsgId, that.docMsgId) && Objects.equals(docCredDttm, that.docCredDttm) && Objects.equals(ntfctn_id, that.ntfctn_id) && Objects.equals(ntfctnPgno, that.ntfctnPgno) && Objects.equals(lastPgIndx, that.lastPgIndx) && Objects.equals(ntfctnCrdDttm, that.ntfctnCrdDttm) && Objects.equals(acctOthrId, that.acctOthrId) && Objects.equals(tnxnEntryNo, that.tnxnEntryNo) && Objects.equals(totEntrySum, that.totEntrySum) && Objects.equals(entryRefNum, that.entryRefNum) && Objects.equals(entryRefAmt, that.entryRefAmt) && Objects.equals(valueDt, that.valueDt) && Objects.equals(batchTranxNum, that.batchTranxNum) && Objects.equals(referenceNo, that.referenceNo) && Objects.equals(referenceDt, that.referenceDt) && Objects.equals(rbiFileTranxns, that.rbiFileTranxns);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fileName, fileTypeCd, fileType, fileRecvDt, fileProcessDt, fromMembId, toOrganizationId, toOthrOrgnztnId, bizMsgIdr, msgDefIdr, bizSvcInfo, creditDttm, docMsgId, docCredDttm, ntfctn_id, ntfctnPgno, lastPgIndx, ntfctnCrdDttm, acctOthrId, tnxnEntryNo, totEntrySum, entryRefNum, entryRefAmt, valueDt, batchTranxNum, referenceNo, referenceDt, rbiFileTranxns);
	}
}