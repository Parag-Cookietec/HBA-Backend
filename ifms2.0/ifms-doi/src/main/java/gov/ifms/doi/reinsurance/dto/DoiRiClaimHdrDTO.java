package gov.ifms.doi.reinsurance.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @author Rudra
 *
 */
public class DoiRiClaimHdrDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5781279363842071564L;

	private long riClaimId;

	private double claimAmount;

	private String claimId;

	private String claimStatus;

	private long claimStatusId;

	private double gifShareAmt;

	private double gifSharePerc;

	private String insuredName;

	private String leaderName;

	private String policyNo;

	private Timestamp referenceDt;

	private String referenceNo;

	private Date riClaimDt;

	private DoiRiPolicyHdrDTO doiRiPolicyHdr;
	
	private List<DoiRiClaimDtlDTO> doiRiClaimDtl;

	/**
	 * @return the riClaimId
	 */
	public long getRiClaimId() {
		return riClaimId;
	}

	/**
	 * @param riClaimId the riClaimId to set
	 */
	public void setRiClaimId(long riClaimId) {
		this.riClaimId = riClaimId;
	}

	/**
	 * @return the claimAmount
	 */
	public double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * @return the claimId
	 */
	public String getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return the claimStatus
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * @param claimStatus the claimStatus to set
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	/**
	 * @return the claimStatusId
	 */
	public long getClaimStatusId() {
		return claimStatusId;
	}

	/**
	 * @param claimStatusId the claimStatusId to set
	 */
	public void setClaimStatusId(long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	/**
	 * @return the gifShareAmt
	 */
	public double getGifShareAmt() {
		return gifShareAmt;
	}

	/**
	 * @param gifShareAmt the gifShareAmt to set
	 */
	public void setGifShareAmt(double gifShareAmt) {
		this.gifShareAmt = gifShareAmt;
	}

	/**
	 * @return the gifSharePerc
	 */
	public double getGifSharePerc() {
		return gifSharePerc;
	}

	/**
	 * @param gifSharePerc the gifSharePerc to set
	 */
	public void setGifSharePerc(double gifSharePerc) {
		this.gifSharePerc = gifSharePerc;
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
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	 * @return the riClaimDt
	 */
	public Date getRiClaimDt() {
		return riClaimDt;
	}

	/**
	 * @param riClaimDt the riClaimDt to set
	 */
	public void setRiClaimDt(Date riClaimDt) {
		this.riClaimDt = riClaimDt;
	}

	/**
	 * @return the doiRiPolicyHdr
	 */
	public DoiRiPolicyHdrDTO getDoiRiPolicyHdr() {
		return doiRiPolicyHdr;
	}

	/**
	 * @param doiRiPolicyHdr the doiRiPolicyHdr to set
	 */
	public void setDoiRiPolicyHdr(DoiRiPolicyHdrDTO doiRiPolicyHdr) {
		this.doiRiPolicyHdr = doiRiPolicyHdr;
	}

	/**
	 * @return the doiRiClaimDtl
	 */
	public List<DoiRiClaimDtlDTO> getDoiRiClaimDtl() {
		return doiRiClaimDtl;
	}

	/**
	 * @param doiRiClaimDtl the doiRiClaimDtl to set
	 */
	public void setDoiRiClaimDtl(List<DoiRiClaimDtlDTO> doiRiClaimDtl) {
		this.doiRiClaimDtl = doiRiClaimDtl;
	}

}