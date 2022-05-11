package gov.ifms.doi.db.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POLICY_LIST database table.
 * 
 */

public class TdoiDbPolicyListDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbPolicyLstId;

	private long dbProposalId;

	private long districtId;

	private String insuredName;

	private String policyCreateBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyCreateDt;

	private String policyCreateMnth;

	private long policyCreateMnthId;

	private int policyCreateYr;

	private long policyCreateYrId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyEndDt;

	private String policyModifyBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyModifyDt;

	private String policyNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyRenewDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyStartDt;

	private String policyStatus;

	private long policyTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long riskTypeId;

	private long talukaId;

	public TdoiDbPolicyListDTO() {
	}

	public long getDbPolicyLstId() {
		return this.dbPolicyLstId;
	}

	public void setDbPolicyLstId(long dbPolicyLstId) {
		this.dbPolicyLstId = dbPolicyLstId;
	}

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getPolicyCreateBy() {
		return this.policyCreateBy;
	}

	public void setPolicyCreateBy(String policyCreateBy) {
		this.policyCreateBy = policyCreateBy;
	}

	public Date getPolicyCreateDt() {
		return this.policyCreateDt;
	}

	public void setPolicyCreateDt(Date policyCreateDt) {
		this.policyCreateDt = policyCreateDt;
	}

	public String getPolicyCreateMnth() {
		return this.policyCreateMnth;
	}

	public void setPolicyCreateMnth(String policyCreateMnth) {
		this.policyCreateMnth = policyCreateMnth;
	}

	public long getPolicyCreateMnthId() {
		return this.policyCreateMnthId;
	}

	public void setPolicyCreateMnthId(long policyCreateMnthId) {
		this.policyCreateMnthId = policyCreateMnthId;
	}

	public int getPolicyCreateYr() {
		return this.policyCreateYr;
	}

	public void setPolicyCreateYr(int policyCreateYr) {
		this.policyCreateYr = policyCreateYr;
	}

	public long getPolicyCreateYrId() {
		return this.policyCreateYrId;
	}

	public void setPolicyCreateYrId(long policyCreateYrId) {
		this.policyCreateYrId = policyCreateYrId;
	}

	public Date getPolicyEndDt() {
		return this.policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyModifyBy() {
		return this.policyModifyBy;
	}

	public void setPolicyModifyBy(String policyModifyBy) {
		this.policyModifyBy = policyModifyBy;
	}

	public Date getPolicyModifyDt() {
		return this.policyModifyDt;
	}

	public void setPolicyModifyDt(Date policyModifyDt) {
		this.policyModifyDt = policyModifyDt;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getPolicyRenewDt() {
		return this.policyRenewDt;
	}

	public void setPolicyRenewDt(Date policyRenewDt) {
		this.policyRenewDt = policyRenewDt;
	}

	public Date getPolicyStartDt() {
		return this.policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public String getPolicyStatus() {
		return this.policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public long getRiskTypeId() {
		return this.riskTypeId;
	}

	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

}
