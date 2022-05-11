package gov.ifms.doi.coinsurance.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import gov.ifms.doi.jpa.dto.BaseDto;
import gov.ifms.doi.workflow.dto.DoiCoinsPolicyHdrWfDTO;


/**
 * @author Rudra
 *
 */

public class DoiCoinsPolicyHdrDTO extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6484493246593575468L;

	private long coinsPolicyHdrId;

	private double basicSumInsrd;

	private String challanNo;

	private String insuredAddress;

	private String insuredCity;

	private long insuredDistrictId;

	private String insuredName;

	private long insuredPincode;

	private long insuredTalukaId;

	private long isFacTreaty;

	private long isRiReqd;

	private long leaderAddrId;

	private String leaderAddress;

	private String leaderEmail;

	private long leaderId;

	private String leaderName;

	private String leaderPhone;

	private String leaderPolicyNo;

	private double ourAgentCommiss;

	private double ourSharePc;

	private double ourSharePremium;

	private double ourShareSi;

	private Date policyEndDt;

	private Date policyIssDt;

	private Date policyIssueDt;

	private String policyNo;

	private Date policyStartDt;

	private long policyTypeId;

	private double premiumAmount;

	private Timestamp referenceDt;

	private String referenceNo;

	private String remarks;

	private String riskDetails;

	private long riskTypeId;

	private String terrorPool;

	private double totalSiAmt;
	
	private List<DoiCoinsPolicyHdrWfDTO> doiCoinsPolicyHdrWf;

	private List<DoiCoinsPolicyRiDTO> doiCoinsPolicyRi;

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
	 * @return the basicSumInsrd
	 */
	public double getBasicSumInsrd() {
		return basicSumInsrd;
	}

	/**
	 * @param basicSumInsrd the basicSumInsrd to set
	 */
	public void setBasicSumInsrd(double basicSumInsrd) {
		this.basicSumInsrd = basicSumInsrd;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
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
	 * @return the insuredCity
	 */
	public String getInsuredCity() {
		return insuredCity;
	}

	/**
	 * @param insuredCity the insuredCity to set
	 */
	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}

	/**
	 * @return the insuredDistrictId
	 */
	public long getInsuredDistrictId() {
		return insuredDistrictId;
	}

	/**
	 * @param insuredDistrictId the insuredDistrictId to set
	 */
	public void setInsuredDistrictId(long insuredDistrictId) {
		this.insuredDistrictId = insuredDistrictId;
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
	 * @return the insuredPincode
	 */
	public long getInsuredPincode() {
		return insuredPincode;
	}

	/**
	 * @param insuredPincode the insuredPincode to set
	 */
	public void setInsuredPincode(long insuredPincode) {
		this.insuredPincode = insuredPincode;
	}

	/**
	 * @return the insuredTalukaId
	 */
	public long getInsuredTalukaId() {
		return insuredTalukaId;
	}

	/**
	 * @param insuredTalukaId the insuredTalukaId to set
	 */
	public void setInsuredTalukaId(long insuredTalukaId) {
		this.insuredTalukaId = insuredTalukaId;
	}

	/**
	 * @return the isFacTreaty
	 */
	public long getIsFacTreaty() {
		return isFacTreaty;
	}

	/**
	 * @param isFacTreaty the isFacTreaty to set
	 */
	public void setIsFacTreaty(long isFacTreaty) {
		this.isFacTreaty = isFacTreaty;
	}

	/**
	 * @return the isRiReqd
	 */
	public long getIsRiReqd() {
		return isRiReqd;
	}

	/**
	 * @param isRiReqd the isRiReqd to set
	 */
	public void setIsRiReqd(long isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	/**
	 * @return the leaderAddrId
	 */
	public long getLeaderAddrId() {
		return leaderAddrId;
	}

	/**
	 * @param leaderAddrId the leaderAddrId to set
	 */
	public void setLeaderAddrId(long leaderAddrId) {
		this.leaderAddrId = leaderAddrId;
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
	 * @return the ourAgentCommiss
	 */
	public double getOurAgentCommiss() {
		return ourAgentCommiss;
	}

	/**
	 * @param ourAgentCommiss the ourAgentCommiss to set
	 */
	public void setOurAgentCommiss(double ourAgentCommiss) {
		this.ourAgentCommiss = ourAgentCommiss;
	}

	/**
	 * @return the ourSharePc
	 */
	public double getOurSharePc() {
		return ourSharePc;
	}

	/**
	 * @param ourSharePc the ourSharePc to set
	 */
	public void setOurSharePc(double ourSharePc) {
		this.ourSharePc = ourSharePc;
	}

	/**
	 * @return the ourSharePremium
	 */
	public double getOurSharePremium() {
		return ourSharePremium;
	}

	/**
	 * @param ourSharePremium the ourSharePremium to set
	 */
	public void setOurSharePremium(double ourSharePremium) {
		this.ourSharePremium = ourSharePremium;
	}

	/**
	 * @return the ourShareSi
	 */
	public double getOurShareSi() {
		return ourShareSi;
	}

	/**
	 * @param ourShareSi the ourShareSi to set
	 */
	public void setOurShareSi(double ourShareSi) {
		this.ourShareSi = ourShareSi;
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
	 * @return the policyIssDt
	 */
	public Date getPolicyIssDt() {
		return policyIssDt;
	}

	/**
	 * @param policyIssDt the policyIssDt to set
	 */
	public void setPolicyIssDt(Date policyIssDt) {
		this.policyIssDt = policyIssDt;
	}

	/**
	 * @return the policyIssueDt
	 */
	public Date getPolicyIssueDt() {
		return policyIssueDt;
	}

	/**
	 * @param policyIssueDt the policyIssueDt to set
	 */
	public void setPolicyIssueDt(Date policyIssueDt) {
		this.policyIssueDt = policyIssueDt;
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
	 * @return the riskDetails
	 */
	public String getRiskDetails() {
		return riskDetails;
	}

	/**
	 * @param riskDetails the riskDetails to set
	 */
	public void setRiskDetails(String riskDetails) {
		this.riskDetails = riskDetails;
	}

	/**
	 * @return the riskTypeId
	 */
	public long getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the terrorPool
	 */
	public String getTerrorPool() {
		return terrorPool;
	}

	/**
	 * @param terrorPool the terrorPool to set
	 */
	public void setTerrorPool(String terrorPool) {
		this.terrorPool = terrorPool;
	}

	/**
	 * @return the totalSiAmt
	 */
	public double getTotalSiAmt() {
		return totalSiAmt;
	}

	/**
	 * @param totalSiAmt the totalSiAmt to set
	 */
	public void setTotalSiAmt(double totalSiAmt) {
		this.totalSiAmt = totalSiAmt;
	}

	/**
	 * @return the doiCoinsPolicyHdrWf
	 */
	public List<DoiCoinsPolicyHdrWfDTO> getDoiCoinsPolicyHdrWf() {
		return doiCoinsPolicyHdrWf;
	}

	/**
	 * @param doiCoinsPolicyHdrWf the doiCoinsPolicyHdrWf to set
	 */
	public void setDoiCoinsPolicyHdrWf(List<DoiCoinsPolicyHdrWfDTO> doiCoinsPolicyHdrWf) {
		this.doiCoinsPolicyHdrWf = doiCoinsPolicyHdrWf;
	}

	/**
	 * @return the doiCoinsPolicyRi
	 */
	public List<DoiCoinsPolicyRiDTO> getDoiCoinsPolicyRi() {
		return doiCoinsPolicyRi;
	}

	/**
	 * @param doiCoinsPolicyRi the doiCoinsPolicyRi to set
	 */
	public void setDoiCoinsPolicyRi(List<DoiCoinsPolicyRiDTO> doiCoinsPolicyRi) {
		this.doiCoinsPolicyRi = doiCoinsPolicyRi;
	}

}