package gov.ifms.gst.dto;

import java.time.LocalDateTime;

public class RBIMOEConfCaseAcknwlgeDto {

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
	private String caseId;
	private String notfAssgnmtId;
	private LocalDateTime notfCredDttm;
	private String assgnmtId;
	private String caseJustfctn;
	private String referenceNo;
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
