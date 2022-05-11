package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RBIMoeReslvdCaseDto {

	private long id;
	private long rbiMoeResId;
	private String resolvedCaseId;
	private String confStsId;
	private String rejcdModId;
	private String stmtInstrId;
	private String stmtEndtoendId;
	private Double stmtTotTaxAmt;
	private String corrctnInstrId;
	private String corrctnEndtoendId;
	private Double corrctnTotTaxAmt;
	private String reslIntbkSttlmAmt;
	private Date reslIntbkSttlmDt;
	private String reslAddnlInfo;
	private String referenceNo;
	private LocalDateTime referenceDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiMoeResId() {
		return rbiMoeResId;
	}

	public void setRbiMoeResId(long rbiMoeResId) {
		this.rbiMoeResId = rbiMoeResId;
	}

	public String getResolvedCaseId() {
		return resolvedCaseId;
	}

	public void setResolvedCaseId(String resolvedCaseId) {
		this.resolvedCaseId = resolvedCaseId;
	}

	public String getConfStsId() {
		return confStsId;
	}

	public void setConfStsId(String confStsId) {
		this.confStsId = confStsId;
	}

	public String getRejcdModId() {
		return rejcdModId;
	}

	public void setRejcdModId(String rejcdModId) {
		this.rejcdModId = rejcdModId;
	}

	public String getStmtInstrId() {
		return stmtInstrId;
	}

	public void setStmtInstrId(String stmtInstrId) {
		this.stmtInstrId = stmtInstrId;
	}

	public String getStmtEndtoendId() {
		return stmtEndtoendId;
	}

	public void setStmtEndtoendId(String stmtEndtoendId) {
		this.stmtEndtoendId = stmtEndtoendId;
	}

	public Double getStmtTotTaxAmt() {
		return stmtTotTaxAmt;
	}

	public void setStmtTotTaxAmt(Double stmtTotTaxAmt) {
		this.stmtTotTaxAmt = stmtTotTaxAmt;
	}

	public String getCorrctnInstrId() {
		return corrctnInstrId;
	}

	public void setCorrctnInstrId(String corrctnInstrId) {
		this.corrctnInstrId = corrctnInstrId;
	}

	public String getCorrctnEndtoendId() {
		return corrctnEndtoendId;
	}

	public void setCorrctnEndtoendId(String corrctnEndtoendId) {
		this.corrctnEndtoendId = corrctnEndtoendId;
	}

	public Double getCorrctnTotTaxAmt() {
		return corrctnTotTaxAmt;
	}

	public void setCorrctnTotTaxAmt(Double corrctnTotTaxAmt) {
		this.corrctnTotTaxAmt = corrctnTotTaxAmt;
	}

	public String getReslIntbkSttlmAmt() {
		return reslIntbkSttlmAmt;
	}

	public void setReslIntbkSttlmAmt(String reslIntbkSttlmAmt) {
		this.reslIntbkSttlmAmt = reslIntbkSttlmAmt;
	}

	public Date getReslIntbkSttlmDt() {
		return reslIntbkSttlmDt;
	}

	public void setReslIntbkSttlmDt(Date reslIntbkSttlmDt) {
		this.reslIntbkSttlmDt = reslIntbkSttlmDt;
	}

	public String getReslAddnlInfo() {
		return reslAddnlInfo;
	}

	public void setReslAddnlInfo(String reslAddnlInfo) {
		this.reslAddnlInfo = reslAddnlInfo;
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
