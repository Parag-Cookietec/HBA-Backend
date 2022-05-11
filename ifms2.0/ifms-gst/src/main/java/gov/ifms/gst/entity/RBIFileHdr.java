package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_RBI_FILES_HDR", schema = GSTConstant.GST_SCHEMA)
public class RBIFileHdr extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TRN_SCREEN_LBAO = "LBAO";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_FILE_HDR_ID")
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

	@Column(name = "MSG_DEF_IDR")
	private String msgDefIdr;

	@Column(name = "BIZ_SVC_INFO")
	private String bizSvcInfo;

	@Column(name = "CREDIT_DTTM")
	private LocalDateTime creditDttm;

	@Column(name = "DOC_MSG_ID")
	private String docMsgId;

	@Column(name = "DOC_CRED_DTTM")
	private LocalDateTime docCredDttm;

	@Column(name = "NTFCTN_ID")
	private String ntfctnId;

	@Column(name = "NTFCTN_PGNO")
	private String ntfctnPgno;

	@Column(name = "LAST_PG_INDX")
	private String lastPgIndx;

	@Column(name = "NTFCTN_CRD_DTTM")
	private LocalDateTime ntfctnCrdDttm;

	@Column(name = "ACCT_OTHR_ID")
	private String acctOthrId;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "BATCH_TRANX_NUM")
	private int batchTranxNum;

	@Column(name = "TNXN_ENTRY_NO")
	private String tnxnEntryNo;

	@Column(name = "TOT_ENTRY_SUM")
	private Double totEntrySum;

	@Column(name = "ENTRY_REF_NUM")
	private String entryRefNum;

	@Column(name = "VALUE_DT")
	private Date valueDt;

	@Column(name = "ENTRY_REF_AMT")
	private Double entryRefAmt;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public RBIFileHdr(Long id) {
		super();
		this.id = id;
	}

	public RBIFileHdr() {
		super();
	}

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

	public String getMsgDefIdr() {
		return msgDefIdr;
	}

	public void setMsgDefIdr(String msgDefIdr) {
		this.msgDefIdr = msgDefIdr;
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

	public String getBizSvcInfo() {
		return bizSvcInfo;
	}

	public void setBizSvcInfo(String bizSvcInfo) {
		this.bizSvcInfo = bizSvcInfo;
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

	public String getLastPgIndx() {
		return lastPgIndx;
	}

	public void setLastPgIndx(String lastPgIndx) {
		this.lastPgIndx = lastPgIndx;
	}

	public LocalDateTime getNtfctnCrdDttm() {
		return ntfctnCrdDttm;
	}

	public void setNtfctnCrdDttm(LocalDateTime ntfctnCrdDttm) {
		this.ntfctnCrdDttm = ntfctnCrdDttm;
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

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
