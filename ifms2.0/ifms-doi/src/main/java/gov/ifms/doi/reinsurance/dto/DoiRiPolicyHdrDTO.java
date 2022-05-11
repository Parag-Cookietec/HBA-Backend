package gov.ifms.doi.reinsurance.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @author Rudra
 *
 */

public class DoiRiPolicyHdrDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4194174345977884789L;

	private long riPolicyHdrId;

	private double agencyCommissPc;

	private double commissionAmt;

	private long departmentId;

	private String departmentName;

	private Date insurEndDt;
	
	private Date insurStartDt;

	private String insuredAddress;

	private String insuredName;

	private String policyNo;

	private long policyTypeId;

	private double premiumAmount;

	private Timestamp referenceDt;

	private String referenceNo;

	private String riskLocation;

	private long riskLocationId;

	private double sumInsuredAmt;
	
	private List<DoiRiPolicyDtlDTO> doiRiPolicyDtl;
	
	private List<DoiRiClaimHdrDTO> doiRiClaimHdr;

	/**
	 * @return the riPolicyHdrId
	 */
	public long getRiPolicyHdrId() {
		return riPolicyHdrId;
	}

	/**
	 * @param riPolicyHdrId the riPolicyHdrId to set
	 */
	public void setRiPolicyHdrId(long riPolicyHdrId) {
		this.riPolicyHdrId = riPolicyHdrId;
	}

	/**
	 * @return the agencyCommissPc
	 */
	public double getAgencyCommissPc() {
		return agencyCommissPc;
	}

	/**
	 * @param agencyCommissPc the agencyCommissPc to set
	 */
	public void setAgencyCommissPc(double agencyCommissPc) {
		this.agencyCommissPc = agencyCommissPc;
	}

	/**
	 * @return the commissionAmt
	 */
	public double getCommissionAmt() {
		return commissionAmt;
	}

	/**
	 * @param commissionAmt the commissionAmt to set
	 */
	public void setCommissionAmt(double commissionAmt) {
		this.commissionAmt = commissionAmt;
	}

	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the insurEndDt
	 */
	public Date getInsurEndDt() {
		return insurEndDt;
	}

	/**
	 * @param insurEndDt the insurEndDt to set
	 */
	public void setInsurEndDt(Date insurEndDt) {
		this.insurEndDt = insurEndDt;
	}

	/**
	 * @return the insurStartDt
	 */
	public Date getInsurStartDt() {
		return insurStartDt;
	}

	/**
	 * @param insurStartDt the insurStartDt to set
	 */
	public void setInsurStartDt(Date insurStartDt) {
		this.insurStartDt = insurStartDt;
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
	 * @return the riskLocationId
	 */
	public long getRiskLocationId() {
		return riskLocationId;
	}

	/**
	 * @param riskLocationId the riskLocationId to set
	 */
	public void setRiskLocationId(long riskLocationId) {
		this.riskLocationId = riskLocationId;
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
	 * @return the doiRiPolicyDtl
	 */
	public List<DoiRiPolicyDtlDTO> getDoiRiPolicyDtl() {
		return doiRiPolicyDtl;
	}

	/**
	 * @param doiRiPolicyDtl the doiRiPolicyDtl to set
	 */
	public void setDoiRiPolicyDtl(List<DoiRiPolicyDtlDTO> doiRiPolicyDtl) {
		this.doiRiPolicyDtl = doiRiPolicyDtl;
	}

	/**
	 * @return the doiRiClaimHdr
	 */
	public List<DoiRiClaimHdrDTO> getDoiRiClaimHdr() {
		return doiRiClaimHdr;
	}

	/**
	 * @param doiRiClaimHdr the doiRiClaimHdr to set
	 */
	public void setDoiRiClaimHdr(List<DoiRiClaimHdrDTO> doiRiClaimHdr) {
		this.doiRiClaimHdr = doiRiClaimHdr;
	}

}