package gov.ifms.gst.dto;

import java.time.LocalDateTime;

public class RBIAccStmtBalDto {

	private long id;
	private long rbiAccStmtId;
	private String balCdType;
	private Double ccyInrAmt;
	private String crtDbtType;
	private LocalDateTime cdtDbtDttm;
	private String referenceNo;
	private LocalDateTime referenceDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiAccStmtId() {
		return rbiAccStmtId;
	}

	public void setRbiAccStmtId(long rbiAccStmtId) {
		this.rbiAccStmtId = rbiAccStmtId;
	}

	public String getBalCdType() {
		return balCdType;
	}

	public void setBalCdType(String balCdType) {
		this.balCdType = balCdType;
	}

	public Double getCcyInrAmt() {
		return ccyInrAmt;
	}

	public void setCcyInrAmt(Double ccyInrAmt) {
		this.ccyInrAmt = ccyInrAmt;
	}

	public String getCrtDbtType() {
		return crtDbtType;
	}

	public void setCrtDbtType(String crtDbtType) {
		this.crtDbtType = crtDbtType;
	}

	public LocalDateTime getCdtDbtDttm() {
		return cdtDbtDttm;
	}

	public void setCdtDbtDttm(LocalDateTime cdtDbtDttm) {
		this.cdtDbtDttm = cdtDbtDttm;
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
