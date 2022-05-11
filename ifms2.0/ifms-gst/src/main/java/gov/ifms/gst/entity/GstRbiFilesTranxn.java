package gov.ifms.gst.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TPAO_RBI_FILES_TRANXN", schema = GSTConstant.GST_SCHEMA)
public class GstRbiFilesTranxn extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_FILE_TRANXN_ID")
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RBI_FILE_HDR_ID", referencedColumnName = "RBI_FILE_HDR_ID")
	private GstRbiFilesHdr rbiFileHdr;

	@Column(name = "MESSAGE_ID")
	private String messageId;

	@Column(name = "ACT_SRC_REFRENCE")
	private String actSrcReference;

	@Column(name = "INSTR_ID")
	private String instrId;

	@Column(name = "END_TO_END_ID")
	private String endToEndId;

	@Column(name = "TRANSACTION_ID")
	private String tranactionId;

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
	private Date acceptanceDttm;

	@Column(name = "TRANSACTION_DTTM")
	private Date transactionDttm;

	@Column(name = "ADDNL_TRN_INFO")
	private String addnlTrnInfo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@OneToOne(fetch = FetchType.EAGER ,mappedBy = "rbiFileTranxn")
	public GstSaDaChallanMapping gstSaDaChallanMapping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GstRbiFilesHdr getRbiFileHdr() {
		return rbiFileHdr;
	}

	public void setRbiFileHdr(GstRbiFilesHdr rbiFileHdr) {
		this.rbiFileHdr = rbiFileHdr;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getActSrcReference() {
		return actSrcReference;
	}

	public void setActSrcReference(String actSrcReference) {
		this.actSrcReference = actSrcReference;
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

	public String getTranactionId() {
		return tranactionId;
	}

	public void setTranactionId(String tranactionId) {
		this.tranactionId = tranactionId;
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

	public Date getAcceptanceDttm() {
		return acceptanceDttm;
	}

	public void setAcceptanceDttm(Date acceptanceDttm) {
		this.acceptanceDttm = acceptanceDttm;
	}

	public Date getTransactionDttm() {
		return transactionDttm;
	}

	public void setTransactionDttm(Date transactionDttm) {
		this.transactionDttm = transactionDttm;
	}

	public String getAddnlTrnInfo() {
		return addnlTrnInfo;
	}

	public void setAddnlTrnInfo(String addnlTrnInfo) {
		this.addnlTrnInfo = addnlTrnInfo;
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

	public GstSaDaChallanMapping getGstSaDaChallanMapping() {
		return gstSaDaChallanMapping;
	}

	public void setGstSaDaChallanMapping(GstSaDaChallanMapping gstSaDaChallanMapping) {
		this.gstSaDaChallanMapping = gstSaDaChallanMapping;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GstRbiFilesTranxn that = (GstRbiFilesTranxn) o;
		return Objects.equals(id, that.id) && Objects.equals(rbiFileHdr, that.rbiFileHdr) && Objects.equals(messageId, that.messageId) && Objects.equals(actSrcReference, that.actSrcReference) && Objects.equals(instrId, that.instrId) && Objects.equals(endToEndId, that.endToEndId) && Objects.equals(tranactionId, that.tranactionId) && Objects.equals(clrSysRefNo, that.clrSysRefNo) && Objects.equals(transactionAmt, that.transactionAmt) && Objects.equals(memberId, that.memberId) && Objects.equals(taxId, that.taxId) && Objects.equals(adminstrativeZone, that.adminstrativeZone) && Objects.equals(totalTransAmt, that.totalTransAmt) && Objects.equals(acceptanceDttm, that.acceptanceDttm) && Objects.equals(transactionDttm, that.transactionDttm) && Objects.equals(addnlTrnInfo, that.addnlTrnInfo) && Objects.equals(referenceNo, that.referenceNo) && Objects.equals(referenceDt, that.referenceDt) && Objects.equals(gstSaDaChallanMapping, that.gstSaDaChallanMapping);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rbiFileHdr, messageId, actSrcReference, instrId, endToEndId, tranactionId, clrSysRefNo, transactionAmt, memberId, taxId, adminstrativeZone, totalTransAmt, acceptanceDttm, transactionDttm, addnlTrnInfo, referenceNo, referenceDt, gstSaDaChallanMapping);
	}
}