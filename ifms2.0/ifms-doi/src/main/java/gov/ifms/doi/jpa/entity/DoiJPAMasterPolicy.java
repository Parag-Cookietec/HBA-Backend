package gov.ifms.doi.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Entity
@Table(name = "MDOI_JPA_POLICY_MST", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJPAMasterPolicy extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POLICY_ID", updatable = false)
	private Long policyId;
	@Column(name = "POLICY_TYPE_ID", updatable = false)
	private Long policyTypeId;
	@Column(name = "POLICY_NUM", updatable = false)
	private String policyNum;
	@Column(name = "SCHEME_ID")
	private Long schemeId;
	@Column(name = "SCHEME_NAME")
	private String schemeName;
	@Column(name = "ENDORSEMENT_SRNO")
	private short endorsementSrNo;
	@Column(name = "POLICY_START_DT")
	private Date policyStartDate;
	@Column(name = "POLICY_END_DT")
	private Date policyEndDate;
	@Column(name = "BENEFICIARY_NUM")
	private int beneficiaryNum;
	@Column(name = "PREMIUM_AMOUNT")
	private Double premiumAmount;
	@Column(name = "DEATH_CLAIM_AMT")
	private Double deathClaimAmt;
	@Column(name = "DISABLE_50_CLAIM_AMT")
	private Double disable50ClaimAmt;
	@Column(name = "DISABLE_100_CLAIM_AMT")
	private Double disable100ClaimAmt;
	@Column(name = "POLICY_STATUS_ID")
	private Long policyStatusId;
	@Column(name = "POLICY_STATUS")
	private Long policyStatus;
	@Column(name = "ENDR_RENEW_REASON")
	private String endrRenewReason;
	@Column(name = "REFERENCE_NO")
	private String referenceNo;
	@Column(name = "REFERENCE_DT")
	private Date referenceDate;

	/*
	 * //bi-directional many-to-one association to MdoiJpaPolicyMstWf
	 * 
	 * @OneToMany(mappedBy="doiJpaPolicyMst") private
	 * List<DoiJpaMasterPolicyWFEntity> mdoiJpaPolicyMstWfs;
	 */

	/**
	 * @return the policyId
	 */
	public Long getPolicyId() {
		return policyId;
	}

	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	/**
	 * @return the policyTypeId
	 */
	public Long getPolicyTypeId() {
		return policyTypeId;
	}

	/**
	 * @param policyTypeId the policyTypeId to set
	 */
	public void setPolicyTypeId(Long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	/**
	 * @return the policyNum
	 */
	public String getPolicyNum() {
		return policyNum;
	}

	/**
	 * @param policyNum the policyNum to set
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	/**
	 * @return the schemeId
	 */
	public Long getSchemeId() {
		return schemeId;
	}

	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the endorsementSrNo
	 */
	public short getEndorsementSrNo() {
		return endorsementSrNo;
	}

	/**
	 * @param endorsementSrNo the endorsementSrNo to set
	 */
	public void setEndorsementSrNo(short endorsementSrNo) {
		this.endorsementSrNo = endorsementSrNo;
	}

	/**
	 * @return the policyStartDate
	 */
	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	/**
	 * @param policyStartDate the policyStartDate to set
	 */
	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	/**
	 * @return the policyEndDate
	 */
	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	/**
	 * @param policyEndDate the policyEndDate to set
	 */
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	/**
	 * @return the beneficiaryNum
	 */
	public int getBeneficiaryNum() {
		return beneficiaryNum;
	}

	/**
	 * @param beneficiaryNum the beneficiaryNum to set
	 */
	public void setBeneficiaryNum(int beneficiaryNum) {
		this.beneficiaryNum = beneficiaryNum;
	}

	/**
	 * @return the premiumAmount
	 */
	public Double getPremiumAmount() {
		return premiumAmount;
	}

	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	/**
	 * @return the deathClaimAmt
	 */
	public Double getDeathClaimAmt() {
		return deathClaimAmt;
	}

	/**
	 * @param deathClaimAmt the deathClaimAmt to set
	 */
	public void setDeathClaimAmt(Double deathClaimAmt) {
		this.deathClaimAmt = deathClaimAmt;
	}

	/**
	 * @return the disable50ClaimAmt
	 */
	public Double getDisable50ClaimAmt() {
		return disable50ClaimAmt;
	}

	/**
	 * @param disable50ClaimAmt the disable50ClaimAmt to set
	 */
	public void setDisable50ClaimAmt(Double disable50ClaimAmt) {
		this.disable50ClaimAmt = disable50ClaimAmt;
	}

	/**
	 * @return the disable100ClaimAmt
	 */
	public Double getDisable100ClaimAmt() {
		return disable100ClaimAmt;
	}

	/**
	 * @param disable100ClaimAmt the disable100ClaimAmt to set
	 */
	public void setDisable100ClaimAmt(Double disable100ClaimAmt) {
		this.disable100ClaimAmt = disable100ClaimAmt;
	}

	/**
	 * @return the policyStatusId
	 */
	public Long getPolicyStatusId() {
		return policyStatusId;
	}

	/**
	 * @param policyStatusId the policyStatusId to set
	 */
	public void setPolicyStatusId(Long policyStatusId) {
		this.policyStatusId = policyStatusId;
	}

	/**
	 * @return the policyStatus
	 */
	public Long getPolicyStatus() {
		return policyStatus;
	}

	/**
	 * @param policyStatus the policyStatus to set
	 */
	public void setPolicyStatus(Long policyStatus) {
		this.policyStatus = policyStatus;
	}

	/**
	 * @return the endrRenewReason
	 */
	public String getEndrRenewReason() {
		return endrRenewReason;
	}

	/**
	 * @param endrRenewReason the endrRenewReason to set
	 */
	public void setEndrRenewReason(String endrRenewReason) {
		this.endrRenewReason = endrRenewReason;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the referenceDate
	 */
	public Date getReferenceDate() {
		return referenceDate;
	}

	/**
	 * @param referenceDate the referenceDate to set
	 */
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	/**
	 * @return the mdoiJpaPolicyMstWfs
	 */
	/*
	 * public List<DoiJpaMasterPolicyWFEntity> getMdoiJpaPolicyMstWfs() { return
	 * mdoiJpaPolicyMstWfs; }
	 * 
	 *//**
		 * @param mdoiJpaPolicyMstWfs the mdoiJpaPolicyMstWfs to set
		 *//*
			 * public void setMdoiJpaPolicyMstWfs(List<DoiJpaMasterPolicyWFEntity>
			 * mdoiJpaPolicyMstWfs) { this.mdoiJpaPolicyMstWfs = mdoiJpaPolicyMstWfs; }
			 */
}
