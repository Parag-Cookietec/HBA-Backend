package gov.ifms.doi.coinsurance.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import gov.ifms.doi.jpa.dto.BaseDto;
import gov.ifms.doi.workflow.dto.DoiCoinsClaimHdrWfDTO;


/**
 * @author Rudra
 *
 */

public class DoiCoinsClaimHdrDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2176759189502396945L;

	private long coinsClaimId;

	private String acceptedPolDtls;

	private double challanAmt;

	private Date challanDt;

	private double claimAmount;

	private String claimDesc;

	private short claimFormPageNo;

	private String claimStatus;

	private long claimStatusId;

	private Date coinsClaimDt;

	private String coinsClaimNo;

	private long coinsPolicyHdrId;

	private String coinsPolicyNo;

	private Date damageDt;

	private String damageReason;

	private double dmamgeScalpAmt;

	private short doiRespPageNo;

	private double gifClaimAmt;

	private double gifClaimPerc;

	private double gifSharePerc;

	private double gifSurveyAmt;

	private double gifTotAmt;

	private String insuredAddress;

	private String insuredName;

	private double intimClaimAmt;

	private double intimClaimPerc;

	private double intimSurveyAmt;

	private double intimTotAmt;

	private Date intimationDt;

	private long intimationThruId;

	private long isClaimFormRecv;

	private long isClaimUnderInv;

	private long isDoiResponsible;

	private long isSurveyRepRecv;

	private long isTpClaimRecv;

	private String leaderAddress;

	private double leaderClaimAmt;

	private String leaderClaimId;

	private String leaderEmail;

	private long leaderId;

	private String leaderName;

	private double leaderPaidPerc;

	private String leaderPhone;

	private String leaderPolicyNo;

	private double leaderSurveyAmt;

	private double leaderTotAmt;

	private double netClaimAmt;

	private Date policyEndDt;

	private Date policyStartDt;

	private long policyTypeId;

	private Date premPaidChallanDt;

	private double premiumAmt;

	private double premiumShareAmt;

	private Date railReceiptDt;

	private String railReceiptNo;

	private double receivedAmt;

	private Timestamp referenceDt;

	private String referenceNo;

	private String remarks;

	private String riskLocation;

	private double sumInsuredAmt;

	private short surveyRepPageNo;

	private double totClaimAmt;

	private double totSurveyAmt;

	private List<DoiCoinsClaimHdrWfDTO> doiCoinsClaimHdrWf;

	private List<DoiCoinsClaimRiDtlDTO> doiCoinsClaimRiDtl;
	
	/**
	 * @return the coinsClaimId
	 */
	public long getCoinsClaimId() {
		return coinsClaimId;
	}

	/**
	 * @param coinsClaimId the coinsClaimId to set
	 */
	public void setCoinsClaimId(long coinsClaimId) {
		this.coinsClaimId = coinsClaimId;
	}

	/**
	 * @return the acceptedPolDtls
	 */
	public String getAcceptedPolDtls() {
		return acceptedPolDtls;
	}

	/**
	 * @param acceptedPolDtls the acceptedPolDtls to set
	 */
	public void setAcceptedPolDtls(String acceptedPolDtls) {
		this.acceptedPolDtls = acceptedPolDtls;
	}

	/**
	 * @return the challanAmt
	 */
	public double getChallanAmt() {
		return challanAmt;
	}

	/**
	 * @param challanAmt the challanAmt to set
	 */
	public void setChallanAmt(double challanAmt) {
		this.challanAmt = challanAmt;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
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
	 * @return the claimDesc
	 */
	public String getClaimDesc() {
		return claimDesc;
	}

	/**
	 * @param claimDesc the claimDesc to set
	 */
	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}

	/**
	 * @return the claimFormPageNo
	 */
	public short getClaimFormPageNo() {
		return claimFormPageNo;
	}

	/**
	 * @param claimFormPageNo the claimFormPageNo to set
	 */
	public void setClaimFormPageNo(short claimFormPageNo) {
		this.claimFormPageNo = claimFormPageNo;
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
	 * @return the coinsClaimDt
	 */
	public Date getCoinsClaimDt() {
		return coinsClaimDt;
	}

	/**
	 * @param coinsClaimDt the coinsClaimDt to set
	 */
	public void setCoinsClaimDt(Date coinsClaimDt) {
		this.coinsClaimDt = coinsClaimDt;
	}

	/**
	 * @return the coinsClaimNo
	 */
	public String getCoinsClaimNo() {
		return coinsClaimNo;
	}

	/**
	 * @param coinsClaimNo the coinsClaimNo to set
	 */
	public void setCoinsClaimNo(String coinsClaimNo) {
		this.coinsClaimNo = coinsClaimNo;
	}

	/**
	 * @return the coinsPolicyHdrId
	 */
	public long getCoinsPolicyHdrId() {
		return coinsPolicyHdrId;
	}

	/**
	 * @param coinsPolicyHdrId the coinsPolicyHdrId to set
	 */
	public void setCoinsPolicyHdrId(long coinsPolicyHdrId) {
		this.coinsPolicyHdrId = coinsPolicyHdrId;
	}

	/**
	 * @return the coinsPolicyNo
	 */
	public String getCoinsPolicyNo() {
		return coinsPolicyNo;
	}

	/**
	 * @param coinsPolicyNo the coinsPolicyNo to set
	 */
	public void setCoinsPolicyNo(String coinsPolicyNo) {
		this.coinsPolicyNo = coinsPolicyNo;
	}

	/**
	 * @return the damageDt
	 */
	public Date getDamageDt() {
		return damageDt;
	}

	/**
	 * @param damageDt the damageDt to set
	 */
	public void setDamageDt(Date damageDt) {
		this.damageDt = damageDt;
	}

	/**
	 * @return the damageReason
	 */
	public String getDamageReason() {
		return damageReason;
	}

	/**
	 * @param damageReason the damageReason to set
	 */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	/**
	 * @return the dmamgeScalpAmt
	 */
	public double getDmamgeScalpAmt() {
		return dmamgeScalpAmt;
	}

	/**
	 * @param dmamgeScalpAmt the dmamgeScalpAmt to set
	 */
	public void setDmamgeScalpAmt(double dmamgeScalpAmt) {
		this.dmamgeScalpAmt = dmamgeScalpAmt;
	}

	/**
	 * @return the doiRespPageNo
	 */
	public short getDoiRespPageNo() {
		return doiRespPageNo;
	}

	/**
	 * @param doiRespPageNo the doiRespPageNo to set
	 */
	public void setDoiRespPageNo(short doiRespPageNo) {
		this.doiRespPageNo = doiRespPageNo;
	}

	/**
	 * @return the gifClaimAmt
	 */
	public double getGifClaimAmt() {
		return gifClaimAmt;
	}

	/**
	 * @param gifClaimAmt the gifClaimAmt to set
	 */
	public void setGifClaimAmt(double gifClaimAmt) {
		this.gifClaimAmt = gifClaimAmt;
	}

	/**
	 * @return the gifClaimPerc
	 */
	public double getGifClaimPerc() {
		return gifClaimPerc;
	}

	/**
	 * @param gifClaimPerc the gifClaimPerc to set
	 */
	public void setGifClaimPerc(double gifClaimPerc) {
		this.gifClaimPerc = gifClaimPerc;
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
	 * @return the gifSurveyAmt
	 */
	public double getGifSurveyAmt() {
		return gifSurveyAmt;
	}

	/**
	 * @param gifSurveyAmt the gifSurveyAmt to set
	 */
	public void setGifSurveyAmt(double gifSurveyAmt) {
		this.gifSurveyAmt = gifSurveyAmt;
	}

	/**
	 * @return the gifTotAmt
	 */
	public double getGifTotAmt() {
		return gifTotAmt;
	}

	/**
	 * @param gifTotAmt the gifTotAmt to set
	 */
	public void setGifTotAmt(double gifTotAmt) {
		this.gifTotAmt = gifTotAmt;
	}

	/**
	 * @return the insuredAddress
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}

	/**
	 * @param insuredAddress the insuredAddress to set
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
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
	 * @return the intimClaimAmt
	 */
	public double getIntimClaimAmt() {
		return intimClaimAmt;
	}

	/**
	 * @param intimClaimAmt the intimClaimAmt to set
	 */
	public void setIntimClaimAmt(double intimClaimAmt) {
		this.intimClaimAmt = intimClaimAmt;
	}

	/**
	 * @return the intimClaimPerc
	 */
	public double getIntimClaimPerc() {
		return intimClaimPerc;
	}

	/**
	 * @param intimClaimPerc the intimClaimPerc to set
	 */
	public void setIntimClaimPerc(double intimClaimPerc) {
		this.intimClaimPerc = intimClaimPerc;
	}

	/**
	 * @return the intimSurveyAmt
	 */
	public double getIntimSurveyAmt() {
		return intimSurveyAmt;
	}

	/**
	 * @param intimSurveyAmt the intimSurveyAmt to set
	 */
	public void setIntimSurveyAmt(double intimSurveyAmt) {
		this.intimSurveyAmt = intimSurveyAmt;
	}

	/**
	 * @return the intimTotAmt
	 */
	public double getIntimTotAmt() {
		return intimTotAmt;
	}

	/**
	 * @param intimTotAmt the intimTotAmt to set
	 */
	public void setIntimTotAmt(double intimTotAmt) {
		this.intimTotAmt = intimTotAmt;
	}

	/**
	 * @return the intimationDt
	 */
	public Date getIntimationDt() {
		return intimationDt;
	}

	/**
	 * @param intimationDt the intimationDt to set
	 */
	public void setIntimationDt(Date intimationDt) {
		this.intimationDt = intimationDt;
	}

	/**
	 * @return the intimationThruId
	 */
	public long getIntimationThruId() {
		return intimationThruId;
	}

	/**
	 * @param intimationThruId the intimationThruId to set
	 */
	public void setIntimationThruId(long intimationThruId) {
		this.intimationThruId = intimationThruId;
	}

	/**
	 * @return the isClaimFormRecv
	 */
	public long getIsClaimFormRecv() {
		return isClaimFormRecv;
	}

	/**
	 * @param isClaimFormRecv the isClaimFormRecv to set
	 */
	public void setIsClaimFormRecv(long isClaimFormRecv) {
		this.isClaimFormRecv = isClaimFormRecv;
	}

	/**
	 * @return the isClaimUnderInv
	 */
	public long getIsClaimUnderInv() {
		return isClaimUnderInv;
	}

	/**
	 * @param isClaimUnderInv the isClaimUnderInv to set
	 */
	public void setIsClaimUnderInv(long isClaimUnderInv) {
		this.isClaimUnderInv = isClaimUnderInv;
	}

	/**
	 * @return the isDoiResponsible
	 */
	public long getIsDoiResponsible() {
		return isDoiResponsible;
	}

	/**
	 * @param isDoiResponsible the isDoiResponsible to set
	 */
	public void setIsDoiResponsible(long isDoiResponsible) {
		this.isDoiResponsible = isDoiResponsible;
	}

	/**
	 * @return the isSurveyRepRecv
	 */
	public long getIsSurveyRepRecv() {
		return isSurveyRepRecv;
	}

	/**
	 * @param isSurveyRepRecv the isSurveyRepRecv to set
	 */
	public void setIsSurveyRepRecv(long isSurveyRepRecv) {
		this.isSurveyRepRecv = isSurveyRepRecv;
	}

	/**
	 * @return the isTpClaimRecv
	 */
	public long getIsTpClaimRecv() {
		return isTpClaimRecv;
	}

	/**
	 * @param isTpClaimRecv the isTpClaimRecv to set
	 */
	public void setIsTpClaimRecv(long isTpClaimRecv) {
		this.isTpClaimRecv = isTpClaimRecv;
	}

	/**
	 * @return the leaderAddress
	 */
	public String getLeaderAddress() {
		return leaderAddress;
	}

	/**
	 * @param leaderAddress the leaderAddress to set
	 */
	public void setLeaderAddress(String leaderAddress) {
		this.leaderAddress = leaderAddress;
	}

	/**
	 * @return the leaderClaimAmt
	 */
	public double getLeaderClaimAmt() {
		return leaderClaimAmt;
	}

	/**
	 * @param leaderClaimAmt the leaderClaimAmt to set
	 */
	public void setLeaderClaimAmt(double leaderClaimAmt) {
		this.leaderClaimAmt = leaderClaimAmt;
	}

	/**
	 * @return the leaderClaimId
	 */
	public String getLeaderClaimId() {
		return leaderClaimId;
	}

	/**
	 * @param leaderClaimId the leaderClaimId to set
	 */
	public void setLeaderClaimId(String leaderClaimId) {
		this.leaderClaimId = leaderClaimId;
	}

	/**
	 * @return the leaderEmail
	 */
	public String getLeaderEmail() {
		return leaderEmail;
	}

	/**
	 * @param leaderEmail the leaderEmail to set
	 */
	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
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
	 * @return the leaderPaidPerc
	 */
	public double getLeaderPaidPerc() {
		return leaderPaidPerc;
	}

	/**
	 * @param leaderPaidPerc the leaderPaidPerc to set
	 */
	public void setLeaderPaidPerc(double leaderPaidPerc) {
		this.leaderPaidPerc = leaderPaidPerc;
	}

	/**
	 * @return the leaderPhone
	 */
	public String getLeaderPhone() {
		return leaderPhone;
	}

	/**
	 * @param leaderPhone the leaderPhone to set
	 */
	public void setLeaderPhone(String leaderPhone) {
		this.leaderPhone = leaderPhone;
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
	 * @return the leaderSurveyAmt
	 */
	public double getLeaderSurveyAmt() {
		return leaderSurveyAmt;
	}

	/**
	 * @param leaderSurveyAmt the leaderSurveyAmt to set
	 */
	public void setLeaderSurveyAmt(double leaderSurveyAmt) {
		this.leaderSurveyAmt = leaderSurveyAmt;
	}

	/**
	 * @return the leaderTotAmt
	 */
	public double getLeaderTotAmt() {
		return leaderTotAmt;
	}

	/**
	 * @param leaderTotAmt the leaderTotAmt to set
	 */
	public void setLeaderTotAmt(double leaderTotAmt) {
		this.leaderTotAmt = leaderTotAmt;
	}

	/**
	 * @return the netClaimAmt
	 */
	public double getNetClaimAmt() {
		return netClaimAmt;
	}

	/**
	 * @param netClaimAmt the netClaimAmt to set
	 */
	public void setNetClaimAmt(double netClaimAmt) {
		this.netClaimAmt = netClaimAmt;
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
	 * @return the policyTypeId
	 */
	public long getPolicyTypeId() {
		return policyTypeId;
	}

	/**
	 * @param policyTypeId the policyTypeId to set
	 */
	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	/**
	 * @return the premPaidChallanDt
	 */
	public Date getPremPaidChallanDt() {
		return premPaidChallanDt;
	}

	/**
	 * @param premPaidChallanDt the premPaidChallanDt to set
	 */
	public void setPremPaidChallanDt(Date premPaidChallanDt) {
		this.premPaidChallanDt = premPaidChallanDt;
	}

	/**
	 * @return the premiumAmt
	 */
	public double getPremiumAmt() {
		return premiumAmt;
	}

	/**
	 * @param premiumAmt the premiumAmt to set
	 */
	public void setPremiumAmt(double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	/**
	 * @return the premiumShareAmt
	 */
	public double getPremiumShareAmt() {
		return premiumShareAmt;
	}

	/**
	 * @param premiumShareAmt the premiumShareAmt to set
	 */
	public void setPremiumShareAmt(double premiumShareAmt) {
		this.premiumShareAmt = premiumShareAmt;
	}

	/**
	 * @return the railReceiptDt
	 */
	public Date getRailReceiptDt() {
		return railReceiptDt;
	}

	/**
	 * @param railReceiptDt the railReceiptDt to set
	 */
	public void setRailReceiptDt(Date railReceiptDt) {
		this.railReceiptDt = railReceiptDt;
	}

	/**
	 * @return the railReceiptNo
	 */
	public String getRailReceiptNo() {
		return railReceiptNo;
	}

	/**
	 * @param railReceiptNo the railReceiptNo to set
	 */
	public void setRailReceiptNo(String railReceiptNo) {
		this.railReceiptNo = railReceiptNo;
	}

	/**
	 * @return the receivedAmt
	 */
	public double getReceivedAmt() {
		return receivedAmt;
	}

	/**
	 * @param receivedAmt the receivedAmt to set
	 */
	public void setReceivedAmt(double receivedAmt) {
		this.receivedAmt = receivedAmt;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the riskLocation
	 */
	public String getRiskLocation() {
		return riskLocation;
	}

	/**
	 * @param riskLocation the riskLocation to set
	 */
	public void setRiskLocation(String riskLocation) {
		this.riskLocation = riskLocation;
	}

	/**
	 * @return the sumInsuredAmt
	 */
	public double getSumInsuredAmt() {
		return sumInsuredAmt;
	}

	/**
	 * @param sumInsuredAmt the sumInsuredAmt to set
	 */
	public void setSumInsuredAmt(double sumInsuredAmt) {
		this.sumInsuredAmt = sumInsuredAmt;
	}

	/**
	 * @return the surveyRepPageNo
	 */
	public short getSurveyRepPageNo() {
		return surveyRepPageNo;
	}

	/**
	 * @param surveyRepPageNo the surveyRepPageNo to set
	 */
	public void setSurveyRepPageNo(short surveyRepPageNo) {
		this.surveyRepPageNo = surveyRepPageNo;
	}

	/**
	 * @return the totClaimAmt
	 */
	public double getTotClaimAmt() {
		return totClaimAmt;
	}

	/**
	 * @param totClaimAmt the totClaimAmt to set
	 */
	public void setTotClaimAmt(double totClaimAmt) {
		this.totClaimAmt = totClaimAmt;
	}

	/**
	 * @return the totSurveyAmt
	 */
	public double getTotSurveyAmt() {
		return totSurveyAmt;
	}

	/**
	 * @param totSurveyAmt the totSurveyAmt to set
	 */
	public void setTotSurveyAmt(double totSurveyAmt) {
		this.totSurveyAmt = totSurveyAmt;
	}

	/**
	 * @return the doiCoinsClaimHdrWf
	 */
	public List<DoiCoinsClaimHdrWfDTO> getDoiCoinsClaimHdrWf() {
		return doiCoinsClaimHdrWf;
	}

	/**
	 * @param doiCoinsClaimHdrWf the doiCoinsClaimHdrWf to set
	 */
	public void setDoiCoinsClaimHdrWf(List<DoiCoinsClaimHdrWfDTO> doiCoinsClaimHdrWf) {
		this.doiCoinsClaimHdrWf = doiCoinsClaimHdrWf;
	}

	/**
	 * @return the doiCoinsClaimRiDtl
	 */
	public List<DoiCoinsClaimRiDtlDTO> getDoiCoinsClaimRiDtl() {
		return doiCoinsClaimRiDtl;
	}

	/**
	 * @param doiCoinsClaimRiDtl the doiCoinsClaimRiDtl to set
	 */
	public void setDoiCoinsClaimRiDtl(List<DoiCoinsClaimRiDtlDTO> doiCoinsClaimRiDtl) {
		this.doiCoinsClaimRiDtl = doiCoinsClaimRiDtl;
	}

}