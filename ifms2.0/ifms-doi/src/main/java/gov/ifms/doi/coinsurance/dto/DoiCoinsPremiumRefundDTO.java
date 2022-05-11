package gov.ifms.doi.coinsurance.dto;

import java.sql.Timestamp;
import java.util.Date;

import gov.ifms.doi.jpa.dto.BaseDto;


/**
 * @author Rudra
 *
 */

public class DoiCoinsPremiumRefundDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -215016577304650452L;

	private long coinsPremRefundId;

	private String insuredName;

	private long leaderId;

	private String leaderName;

	private String leaderPolicyNo;

	private long majorheadId;

	private long minorheadId;

	private Date policyEndDt;

	private Date policyStartDt;

	private double premiumAmount;

	private Timestamp referenceDt;

	private String referenceNo;

	private double refundAmount;

	private String refundAmountWords;

	private String refundReason;

	private long submajorheadId;

	/**
	 * @return the coinsPremRefundId
	 */
	public long getCoinsPremRefundId() {
		return coinsPremRefundId;
	}

	/**
	 * @param coinsPremRefundId the coinsPremRefundId to set
	 */
	public void setCoinsPremRefundId(long coinsPremRefundId) {
		this.coinsPremRefundId = coinsPremRefundId;
	}

	/**
	 * @return the insuredName
	 */
	public String getInsuredName() {
		return insuredName;
	}

	/**
	 * @param insuredName the insuredName to set
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/**
	 * @return the leaderId
	 */
	public long getLeaderId() {
		return leaderId;
	}

	/**
	 * @param leaderId the leaderId to set
	 */
	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}

	/**
	 * @return the leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @param leaderName the leaderName to set
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * @return the leaderPolicyNo
	 */
	public String getLeaderPolicyNo() {
		return leaderPolicyNo;
	}

	/**
	 * @param leaderPolicyNo the leaderPolicyNo to set
	 */
	public void setLeaderPolicyNo(String leaderPolicyNo) {
		this.leaderPolicyNo = leaderPolicyNo;
	}

	/**
	 * @return the majorheadId
	 */
	public long getMajorheadId() {
		return majorheadId;
	}

	/**
	 * @param majorheadId the majorheadId to set
	 */
	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	/**
	 * @return the minorheadId
	 */
	public long getMinorheadId() {
		return minorheadId;
	}

	/**
	 * @param minorheadId the minorheadId to set
	 */
	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * @return the policyEndDt
	 */
	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	/**
	 * @param policyEndDt the policyEndDt to set
	 */
	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	/**
	 * @return the policyStartDt
	 */
	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	/**
	 * @param policyStartDt the policyStartDt to set
	 */
	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	/**
	 * @return the premiumAmount
	 */
	public double getPremiumAmount() {
		return premiumAmount;
	}

	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	/**
	 * @return the referenceDt
	 */
	public Timestamp getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Timestamp referenceDt) {
		this.referenceDt = referenceDt;
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
	 * @return the refundAmount
	 */
	public double getRefundAmount() {
		return refundAmount;
	}

	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	/**
	 * @return the refundAmountWords
	 */
	public String getRefundAmountWords() {
		return refundAmountWords;
	}

	/**
	 * @param refundAmountWords the refundAmountWords to set
	 */
	public void setRefundAmountWords(String refundAmountWords) {
		this.refundAmountWords = refundAmountWords;
	}

	/**
	 * @return the refundReason
	 */
	public String getRefundReason() {
		return refundReason;
	}

	/**
	 * @param refundReason the refundReason to set
	 */
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	/**
	 * @return the submajorheadId
	 */
	public long getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * @param submajorheadId the submajorheadId to set
	 */
	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

}