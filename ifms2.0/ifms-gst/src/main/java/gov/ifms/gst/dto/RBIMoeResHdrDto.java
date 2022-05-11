package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RBIMoeResHdrDto {

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
	private String docAssgnmtId;
	private String docAssgnrOthrId;
	private String docAssgneOthrId;
	private LocalDateTime docCredDttm;
	private String referenceNo;
	private Date referenceDt;

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

	public String getDocAssgnmtId() {
		return docAssgnmtId;
	}

	public void setDocAssgnmtId(String docAssgnmtId) {
		this.docAssgnmtId = docAssgnmtId;
	}

	public String getDocAssgnrOthrId() {
		return docAssgnrOthrId;
	}

	public void setDocAssgnrOthrId(String docAssgnrOthrId) {
		this.docAssgnrOthrId = docAssgnrOthrId;
	}

	public String getDocAssgneOthrId() {
		return docAssgneOthrId;
	}

	public void setDocAssgneOthrId(String docAssgneOthrId) {
		this.docAssgneOthrId = docAssgneOthrId;
	}

	public LocalDateTime getDocCredDttm() {
		return docCredDttm;
	}

	public void setDocCredDttm(LocalDateTime docCredDttm) {
		this.docCredDttm = docCredDttm;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

}
