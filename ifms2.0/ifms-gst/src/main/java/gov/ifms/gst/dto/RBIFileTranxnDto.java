package gov.ifms.gst.dto;

import java.time.LocalDateTime;

public class RBIFileTranxnDto {

	private long id;
	private Long rbiFileHdrId;
	private String actSrcRefrence;
	private String messageId;
	private String instrId;
	private String endToEndId;
	private String transactionId;
	private String clrSysRefNo;
	private Double transactionAmt;
	private String memberId;
	private String taxId;
	private String adminstrativeZone;
	private Double totalTransAmt;
	private LocalDateTime acceptanceDttm;
	private LocalDateTime transactionDttm;
	private Double addnlTrnInfo;
	private String referenceNo;
	private LocalDateTime referenceDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getRbiFileHdrId() {
		return rbiFileHdrId;
	}

	public void setRbiFileHdrId(Long rbiFileHdrId) {
		this.rbiFileHdrId = rbiFileHdrId;
	}

	public String getActSrcRefrence() {
		return actSrcRefrence;
	}

	public void setActSrcRefrence(String actSrcRefrence) {
		this.actSrcRefrence = actSrcRefrence;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public LocalDateTime getAcceptanceDttm() {
		return acceptanceDttm;
	}

	public void setAcceptanceDttm(LocalDateTime acceptanceDttm) {
		this.acceptanceDttm = acceptanceDttm;
	}

	public LocalDateTime getTransactionDttm() {
		return transactionDttm;
	}

	public void setTransactionDttm(LocalDateTime transactionDttm) {
		this.transactionDttm = transactionDttm;
	}

	public Double getAddnlTrnInfo() {
		return addnlTrnInfo;
	}

	public void setAddnlTrnInfo(Double addnlTrnInfo) {
		this.addnlTrnInfo = addnlTrnInfo;
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
