package gov.ifms.doi.jpa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public class DoiJpaMasterPolicyDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long policyId;
	private Long policyTypeId;
	private String policyNum;
	private Long schemeId;
	private String schemeName;
	private short endorsementSrNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date policyStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date policyEndDate;
	private int beneficiaryNum;
	private Double premiumAmount;
	private Double deathClaimAmt;
	private Double disable50ClaimAmt;
	private Double disable100ClaimAmt;
	private Long policyStatusId;
	private Long policyStatus;
	private String endrRenewReason;
	private String referenceNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDate;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public Long getPolicyTypeId() {
		return policyTypeId;
	}

	public void setPolicyTypeId(Long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public String getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	public Long getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public short getEndorsementSrNo() {
		return endorsementSrNo;
	}

	public void setEndorsementSrNo(short endorsementSrNo) {
		this.endorsementSrNo = endorsementSrNo;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public int getBeneficiaryNum() {
		return beneficiaryNum;
	}

	public void setBeneficiaryNum(int beneficiaryNum) {
		this.beneficiaryNum = beneficiaryNum;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getDeathClaimAmt() {
		return deathClaimAmt;
	}

	public void setDeathClaimAmt(Double deathClaimAmt) {
		this.deathClaimAmt = deathClaimAmt;
	}

	public Double getDisable50ClaimAmt() {
		return disable50ClaimAmt;
	}

	public void setDisable50ClaimAmt(Double disable50ClaimAmt) {
		this.disable50ClaimAmt = disable50ClaimAmt;
	}

	public Double getDisable100ClaimAmt() {
		return disable100ClaimAmt;
	}

	public void setDisable100ClaimAmt(Double disable100ClaimAmt) {
		this.disable100ClaimAmt = disable100ClaimAmt;
	}

	public Long getPolicyStatusId() {
		return policyStatusId;
	}

	public void setPolicyStatusId(Long policyStatusId) {
		this.policyStatusId = policyStatusId;
	}

	public Long getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(Long policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getEndrRenewReason() {
		return endrRenewReason;
	}

	public void setEndrRenewReason(String endrRenewReason) {
		this.endrRenewReason = endrRenewReason;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

}
