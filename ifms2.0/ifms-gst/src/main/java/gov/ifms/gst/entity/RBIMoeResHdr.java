package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_RBI_MOE_RES_HDR", schema = GSTConstant.GST_SCHEMA)
public class RBIMoeResHdr extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RMRH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_MOE_RES_ID")
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
	private LocalDateTime creditDttm;

	@Column(name = "DOC_ASSGNMT_ID")
	private String docAssgnmtId;

	@Column(name = "DOC_ASSGNR_OTHR_ID")
	private String docAssgnrOthrId;

	@Column(name = "DOC_ASSGNE_OTHR_ID")
	private String docAssgneOthrId;

	@Column(name = "DOC_CRED_DTTM")
	private LocalDateTime docCredDttm;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	public RBIMoeResHdr(Long id) {
		super();
		this.id = id;
	}

	public RBIMoeResHdr() {
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

	public static String getTrnScreenLbao() {
		return TRN_SCREEN_LBAO;
	}

}
