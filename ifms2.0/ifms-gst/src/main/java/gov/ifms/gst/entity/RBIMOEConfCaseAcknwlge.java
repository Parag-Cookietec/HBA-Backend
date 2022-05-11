package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TPAO_RBI_MOE_CONF_CASE_ACKNWLGE", schema = GSTConstant.GST_SCHEMA)
public class RBIMOEConfCaseAcknwlge extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RMCCA";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOE_CONF_ACKN_ID")
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

	@Column(name = "CASE_ID")
	private String caseId;

	@Column(name = "NOTF_ASSGNMT_ID")
	private String notfAssgnmtId;

	@Column(name = "NOTF_CRED_DTTM")
	private LocalDateTime notfCredDttm;

	@Column(name = "ASSGNMT_ID")
	private String assgnmtId;

	@Column(name = "CASE_JUSTFCTN")
	private String caseJustfctn;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public RBIMOEConfCaseAcknwlge(Long id) {
		super();
		this.id = id;
	}

	public RBIMOEConfCaseAcknwlge() {
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

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getNotfAssgnmtId() {
		return notfAssgnmtId;
	}

	public void setNotfAssgnmtId(String notfAssgnmtId) {
		this.notfAssgnmtId = notfAssgnmtId;
	}

	public LocalDateTime getNotfCredDttm() {
		return notfCredDttm;
	}

	public void setNotfCredDttm(LocalDateTime notfCredDttm) {
		this.notfCredDttm = notfCredDttm;
	}

	public String getAssgnmtId() {
		return assgnmtId;
	}

	public void setAssgnmtId(String assgnmtId) {
		this.assgnmtId = assgnmtId;
	}

	public String getCaseJustfctn() {
		return caseJustfctn;
	}

	public void setCaseJustfctn(String caseJustfctn) {
		this.caseJustfctn = caseJustfctn;
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
