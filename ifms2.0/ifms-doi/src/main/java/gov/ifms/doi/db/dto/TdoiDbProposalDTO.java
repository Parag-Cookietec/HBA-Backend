package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPOSAL database table.
 * 
 */

public class TdoiDbProposalDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbProposalId;

	private long aadharNum;

	private long bankId;

	private String bankName;

	private long branchId;

	private String branchName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date btr5ReceiptDt;

	private String btr5ReceiptNo;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private String contactNum;

	private double discountAmount;

	private long districtId;

	private String emailAddress;

	private String endorsementNo;

	private double grandTotalAmt;

	private String instituteName;

	private String instituteType;

	private double insurPremium;

	private String insuredName;

	private long paymentModeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyEndDt;

	private String policyGenrBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyGenrDt;

	private String policyNo;

	private String policyRefrenceNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyRenewDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyStartDt;

	private String policyStatus;

	private long policyTypeId;

	private double premiumAmount;

	private String propertyLocation;

	private String proposalGenrBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date proposalGenrDt;

	private String proposalNo;

	private String proposalStatus;

	private long proposalStatusId;

	private String proposerAddress;

	private String proposerName;

	private long proposerTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long riskTypeId;

	private double sumInsured;

	private long talukaId;

	private double taxAmount;

	private double totalPremiumAmt;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	private List<TdoiDbClaimEntryDTO> tdoiDbClaimEntries;

	// bi-directional many-to-one association to TdoiDbFireBuildingVal
	private List<TdoiDbFireBuildingValDTO> tdoiDbFireBuildingVals;

	// bi-directional many-to-one association to TdoiDbFirePastPolicy
	private List<TdoiDbFirePastPolicyDTO> tdoiDbFirePastPolicies;

	// bi-directional many-to-one association to TdoiDbFireRiskLoc
	private List<TdoiDbFireRiskLocDTO> tdoiDbFireRiskLocs;

	// bi-directional many-to-one association to TdoiDbFireSumInsured
	private List<TdoiDbFireSumInsuredDTO> tdoiDbFireSumInsureds;

	// bi-directional many-to-one association to TdoiDbPolAviation
	private List<TdoiDbPolAviationDTO> tdoiDbPolAviations;

	// bi-directional many-to-one association to TdoiDbPolBurglary
	private List<TdoiDbPolBurglaryDTO> tdoiDbPolBurglaries;

	// bi-directional many-to-one association to TdoiDbPolElecEquip
	private List<TdoiDbPolElecEquipDTO> tdoiDbPolElecEquips;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	private List<TdoiDbPolFirePerilDTO> tdoiDbPolFirePerils;

	// bi-directional many-to-one association to TdoiDbPolMoneyIntransit
	private List<TdoiDbPolMoneyIntransitDTO> tdoiDbPolMoneyIntransits;

	// bi-directional many-to-one association to TdoiDbProposlWf
	private List<TdoiDbProposlWfDTO> tdoiDbProposlWfs;

	// bi-directional many-to-one association to TdoiDbPropslAviation
	private List<TdoiDbPropslAviationDTO> tdoiDbPropslAviations;

	// bi-directional many-to-one association to TdoiDbPropslBurglary
	private List<TdoiDbPropslBurglaryDTO> tdoiDbPropslBurglaries;

	// bi-directional many-to-one association to TdoiDbPropslElecEquip
	private List<TdoiDbPropslElecEquipDTO> tdoiDbPropslElecEquips;

	// bi-directional many-to-one association to TdoiDbPropslFirePeril
	private List<TdoiDbPropslFirePerilDTO> tdoiDbPropslFirePerils;

	// bi-directional many-to-one association to TdoiDbPropslPolicy
	private List<TdoiDbPropslPolicyDTO> tdoiDbPropslPolicies;

	// bi-directional many-to-one association to TdoiDbPropslPolAddon
	private List<TdoiDbPropslPolAddonDTO> tdoiDbPropslPolAddons;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit
	private List<TdoiDbPropMoneyIntransitDTO> tdoiDbPropMoneyIntransits;

	public TdoiDbProposalDTO() {
	}

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
	}

	public long getAadharNum() {
		return this.aadharNum;
	}

	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	public long getBankId() {
		return this.bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getBtr5ReceiptDt() {
		return this.btr5ReceiptDt;
	}

	public void setBtr5ReceiptDt(Date btr5ReceiptDt) {
		this.btr5ReceiptDt = btr5ReceiptDt;
	}

	public String getBtr5ReceiptNo() {
		return this.btr5ReceiptNo;
	}

	public void setBtr5ReceiptNo(String btr5ReceiptNo) {
		this.btr5ReceiptNo = btr5ReceiptNo;
	}

	public double getChallanAmount() {
		return this.challanAmount;
	}

	public void setChallanAmount(double challanAmount) {
		this.challanAmount = challanAmount;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChequeDdDt() {
		return this.chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public String getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(String chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEndorsementNo() {
		return this.endorsementNo;
	}

	public void setEndorsementNo(String endorsementNo) {
		this.endorsementNo = endorsementNo;
	}

	public double getGrandTotalAmt() {
		return this.grandTotalAmt;
	}

	public void setGrandTotalAmt(double grandTotalAmt) {
		this.grandTotalAmt = grandTotalAmt;
	}

	public String getInstituteName() {
		return this.instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteType() {
		return this.instituteType;
	}

	public void setInstituteType(String instituteType) {
		this.instituteType = instituteType;
	}

	public double getInsurPremium() {
		return this.insurPremium;
	}

	public void setInsurPremium(double insurPremium) {
		this.insurPremium = insurPremium;
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public long getPaymentModeId() {
		return this.paymentModeId;
	}

	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public Date getPolicyEndDt() {
		return this.policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyGenrBy() {
		return this.policyGenrBy;
	}

	public void setPolicyGenrBy(String policyGenrBy) {
		this.policyGenrBy = policyGenrBy;
	}

	public Date getPolicyGenrDt() {
		return this.policyGenrDt;
	}

	public void setPolicyGenrDt(Date policyGenrDt) {
		this.policyGenrDt = policyGenrDt;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyRefrenceNo() {
		return this.policyRefrenceNo;
	}

	public void setPolicyRefrenceNo(String policyRefrenceNo) {
		this.policyRefrenceNo = policyRefrenceNo;
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

	public double getPremiumAmount() {
		return this.premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPropertyLocation() {
		return this.propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getProposalGenrBy() {
		return this.proposalGenrBy;
	}

	public void setProposalGenrBy(String proposalGenrBy) {
		this.proposalGenrBy = proposalGenrBy;
	}

	public Date getProposalGenrDt() {
		return this.proposalGenrDt;
	}

	public void setProposalGenrDt(Date proposalGenrDt) {
		this.proposalGenrDt = proposalGenrDt;
	}

	public String getProposalNo() {
		return this.proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getProposalStatus() {
		return this.proposalStatus;
	}

	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	public long getProposalStatusId() {
		return this.proposalStatusId;
	}

	public void setProposalStatusId(long proposalStatusId) {
		this.proposalStatusId = proposalStatusId;
	}

	public String getProposerAddress() {
		return this.proposerAddress;
	}

	public void setProposerAddress(String proposerAddress) {
		this.proposerAddress = proposerAddress;
	}

	public String getProposerName() {
		return this.proposerName;
	}

	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}

	public long getProposerTypeId() {
		return this.proposerTypeId;
	}

	public void setProposerTypeId(long proposerTypeId) {
		this.proposerTypeId = proposerTypeId;
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

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	public double getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getTotalPremiumAmt() {
		return this.totalPremiumAmt;
	}

	public void setTotalPremiumAmt(double totalPremiumAmt) {
		this.totalPremiumAmt = totalPremiumAmt;
	}

	public List<TdoiDbClaimEntryDTO> getTdoiDbClaimEntries() {
		return this.tdoiDbClaimEntries;
	}

	public void setTdoiDbClaimEntries(List<TdoiDbClaimEntryDTO> tdoiDbClaimEntries) {
		this.tdoiDbClaimEntries = tdoiDbClaimEntries;
	}

	

	public List<TdoiDbFireBuildingValDTO> getTdoiDbFireBuildingVals() {
		return this.tdoiDbFireBuildingVals;
	}

	public void setTdoiDbFireBuildingVals(List<TdoiDbFireBuildingValDTO> tdoiDbFireBuildingVals) {
		this.tdoiDbFireBuildingVals = tdoiDbFireBuildingVals;
	}

	public TdoiDbFireBuildingValDTO addTdoiDbFireBuildingVal(TdoiDbFireBuildingValDTO tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().add(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbProposal(this);

		return tdoiDbFireBuildingVal;
	}

	public TdoiDbFireBuildingValDTO removeTdoiDbFireBuildingVal(TdoiDbFireBuildingValDTO tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().remove(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbProposal(null);

		return tdoiDbFireBuildingVal;
	}

	public List<TdoiDbFirePastPolicyDTO> getTdoiDbFirePastPolicies() {
		return this.tdoiDbFirePastPolicies;
	}

	public void setTdoiDbFirePastPolicies(List<TdoiDbFirePastPolicyDTO> tdoiDbFirePastPolicies) {
		this.tdoiDbFirePastPolicies = tdoiDbFirePastPolicies;
	}

	public TdoiDbFirePastPolicyDTO addTdoiDbFirePastPolicy(TdoiDbFirePastPolicyDTO tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().add(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbProposal(this);

		return tdoiDbFirePastPolicy;
	}

	public TdoiDbFirePastPolicyDTO removeTdoiDbFirePastPolicy(TdoiDbFirePastPolicyDTO tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().remove(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbProposal(null);

		return tdoiDbFirePastPolicy;
	}

	public List<TdoiDbFireRiskLocDTO> getTdoiDbFireRiskLocs() {
		return this.tdoiDbFireRiskLocs;
	}

	public void setTdoiDbFireRiskLocs(List<TdoiDbFireRiskLocDTO> tdoiDbFireRiskLocs) {
		this.tdoiDbFireRiskLocs = tdoiDbFireRiskLocs;
	}

	public TdoiDbFireRiskLocDTO addTdoiDbFireRiskLoc(TdoiDbFireRiskLocDTO tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().add(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbProposal(this);

		return tdoiDbFireRiskLoc;
	}

	public TdoiDbFireRiskLocDTO removeTdoiDbFireRiskLoc(TdoiDbFireRiskLocDTO tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().remove(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbProposal(null);

		return tdoiDbFireRiskLoc;
	}

	public List<TdoiDbFireSumInsuredDTO> getTdoiDbFireSumInsureds() {
		return this.tdoiDbFireSumInsureds;
	}

	public void setTdoiDbFireSumInsureds(List<TdoiDbFireSumInsuredDTO> tdoiDbFireSumInsureds) {
		this.tdoiDbFireSumInsureds = tdoiDbFireSumInsureds;
	}

	public TdoiDbFireSumInsuredDTO addTdoiDbFireSumInsured(TdoiDbFireSumInsuredDTO tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().add(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbProposal(this);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbFireSumInsuredDTO removeTdoiDbFireSumInsured(TdoiDbFireSumInsuredDTO tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().remove(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbProposal(null);

		return tdoiDbFireSumInsured;
	}

	public List<TdoiDbPolAviationDTO> getTdoiDbPolAviations() {
		return this.tdoiDbPolAviations;
	}

	public void setTdoiDbPolAviations(List<TdoiDbPolAviationDTO> tdoiDbPolAviations) {
		this.tdoiDbPolAviations = tdoiDbPolAviations;
	}

	public TdoiDbPolAviationDTO addTdoiDbPolAviation(TdoiDbPolAviationDTO tdoiDbPolAviation) {
		getTdoiDbPolAviations().add(tdoiDbPolAviation);
		tdoiDbPolAviation.setTdoiDbProposal(this);

		return tdoiDbPolAviation;
	}

	public TdoiDbPolAviationDTO removeTdoiDbPolAviation(TdoiDbPolAviationDTO tdoiDbPolAviation) {
		getTdoiDbPolAviations().remove(tdoiDbPolAviation);
		tdoiDbPolAviation.setTdoiDbProposal(null);

		return tdoiDbPolAviation;
	}

	public List<TdoiDbPolBurglaryDTO> getTdoiDbPolBurglaries() {
		return this.tdoiDbPolBurglaries;
	}

	public void setTdoiDbPolBurglaries(List<TdoiDbPolBurglaryDTO> tdoiDbPolBurglaries) {
		this.tdoiDbPolBurglaries = tdoiDbPolBurglaries;
	}

	public TdoiDbPolBurglaryDTO addTdoiDbPolBurglary(TdoiDbPolBurglaryDTO tdoiDbPolBurglary) {
		getTdoiDbPolBurglaries().add(tdoiDbPolBurglary);
		tdoiDbPolBurglary.setTdoiDbProposal(this);

		return tdoiDbPolBurglary;
	}

	public TdoiDbPolBurglaryDTO removeTdoiDbPolBurglary(TdoiDbPolBurglaryDTO tdoiDbPolBurglary) {
		getTdoiDbPolBurglaries().remove(tdoiDbPolBurglary);
		tdoiDbPolBurglary.setTdoiDbProposal(null);

		return tdoiDbPolBurglary;
	}

	public List<TdoiDbPolElecEquipDTO> getTdoiDbPolElecEquips() {
		return this.tdoiDbPolElecEquips;
	}

	public void setTdoiDbPolElecEquips(List<TdoiDbPolElecEquipDTO> tdoiDbPolElecEquips) {
		this.tdoiDbPolElecEquips = tdoiDbPolElecEquips;
	}

	public TdoiDbPolElecEquipDTO addTdoiDbPolElecEquip(TdoiDbPolElecEquipDTO tdoiDbPolElecEquip) {
		getTdoiDbPolElecEquips().add(tdoiDbPolElecEquip);
	//	tdoiDbPolElecEquip.setTdoiDbProposal(this);

		return tdoiDbPolElecEquip;
	}

	public TdoiDbPolElecEquipDTO removeTdoiDbPolElecEquip(TdoiDbPolElecEquipDTO tdoiDbPolElecEquip) {
		getTdoiDbPolElecEquips().remove(tdoiDbPolElecEquip);
	//	tdoiDbPolElecEquip.setTdoiDbProposal(null);

		return tdoiDbPolElecEquip;
	}

	public List<TdoiDbPolFirePerilDTO> getTdoiDbPolFirePerils() {
		return this.tdoiDbPolFirePerils;
	}

	public void setTdoiDbPolFirePerils(List<TdoiDbPolFirePerilDTO> tdoiDbPolFirePerils) {
		this.tdoiDbPolFirePerils = tdoiDbPolFirePerils;
	}

	public TdoiDbPolFirePerilDTO addTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		getTdoiDbPolFirePerils().add(tdoiDbPolFirePeril);
		tdoiDbPolFirePeril.setTdoiDbProposal(this);

		return tdoiDbPolFirePeril;
	}

	public TdoiDbPolFirePerilDTO removeTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		getTdoiDbPolFirePerils().remove(tdoiDbPolFirePeril);
		tdoiDbPolFirePeril.setTdoiDbProposal(null);

		return tdoiDbPolFirePeril;
	}

	public List<TdoiDbPolMoneyIntransitDTO> getTdoiDbPolMoneyIntransits() {
		return this.tdoiDbPolMoneyIntransits;
	}

	public void setTdoiDbPolMoneyIntransits(List<TdoiDbPolMoneyIntransitDTO> tdoiDbPolMoneyIntransits) {
		this.tdoiDbPolMoneyIntransits = tdoiDbPolMoneyIntransits;
	}

	public TdoiDbPolMoneyIntransitDTO addTdoiDbPolMoneyIntransit(TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit) {
		getTdoiDbPolMoneyIntransits().add(tdoiDbPolMoneyIntransit);
		tdoiDbPolMoneyIntransit.setTdoiDbProposal(this);

		return tdoiDbPolMoneyIntransit;
	}

	public TdoiDbPolMoneyIntransitDTO removeTdoiDbPolMoneyIntransit(
			TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit) {
		getTdoiDbPolMoneyIntransits().remove(tdoiDbPolMoneyIntransit);
		tdoiDbPolMoneyIntransit.setTdoiDbProposal(null);

		return tdoiDbPolMoneyIntransit;
	}

	public List<TdoiDbProposlWfDTO> getTdoiDbProposlWfs() {
		return this.tdoiDbProposlWfs;
	}

	public void setTdoiDbProposlWfs(List<TdoiDbProposlWfDTO> tdoiDbProposlWfs) {
		this.tdoiDbProposlWfs = tdoiDbProposlWfs;
	}

	public TdoiDbProposlWfDTO addTdoiDbProposlWf(TdoiDbProposlWfDTO tdoiDbProposlWf) {
		getTdoiDbProposlWfs().add(tdoiDbProposlWf);
		tdoiDbProposlWf.setTdoiDbProposal(this);

		return tdoiDbProposlWf;
	}

	public TdoiDbProposlWfDTO removeTdoiDbProposlWf(TdoiDbProposlWfDTO tdoiDbProposlWf) {
		getTdoiDbProposlWfs().remove(tdoiDbProposlWf);
		tdoiDbProposlWf.setTdoiDbProposal(null);

		return tdoiDbProposlWf;
	}

	public List<TdoiDbPropslAviationDTO> getTdoiDbPropslAviations() {
		return this.tdoiDbPropslAviations;
	}

	public void setTdoiDbPropslAviations(List<TdoiDbPropslAviationDTO> tdoiDbPropslAviations) {
		this.tdoiDbPropslAviations = tdoiDbPropslAviations;
	}

	public TdoiDbPropslAviationDTO addTdoiDbPropslAviation(TdoiDbPropslAviationDTO tdoiDbPropslAviation) {
		getTdoiDbPropslAviations().add(tdoiDbPropslAviation);
		tdoiDbPropslAviation.setTdoiDbProposal(this);

		return tdoiDbPropslAviation;
	}

	public TdoiDbPropslAviationDTO removeTdoiDbPropslAviation(TdoiDbPropslAviationDTO tdoiDbPropslAviation) {
		getTdoiDbPropslAviations().remove(tdoiDbPropslAviation);
		tdoiDbPropslAviation.setTdoiDbProposal(null);

		return tdoiDbPropslAviation;
	}

	public List<TdoiDbPropslBurglaryDTO> getTdoiDbPropslBurglaries() {
		return this.tdoiDbPropslBurglaries;
	}

	public void setTdoiDbPropslBurglaries(List<TdoiDbPropslBurglaryDTO> tdoiDbPropslBurglaries) {
		this.tdoiDbPropslBurglaries = tdoiDbPropslBurglaries;
	}

	public TdoiDbPropslBurglaryDTO addTdoiDbPropslBurglary(TdoiDbPropslBurglaryDTO tdoiDbPropslBurglary) {
		getTdoiDbPropslBurglaries().add(tdoiDbPropslBurglary);
		tdoiDbPropslBurglary.setTdoiDbProposal(this);

		return tdoiDbPropslBurglary;
	}

	public TdoiDbPropslBurglaryDTO removeTdoiDbPropslBurglary(TdoiDbPropslBurglaryDTO tdoiDbPropslBurglary) {
		getTdoiDbPropslBurglaries().remove(tdoiDbPropslBurglary);
		tdoiDbPropslBurglary.setTdoiDbProposal(null);

		return tdoiDbPropslBurglary;
	}

	public List<TdoiDbPropslElecEquipDTO> getTdoiDbPropslElecEquips() {
		return this.tdoiDbPropslElecEquips;
	}

	public void setTdoiDbPropslElecEquips(List<TdoiDbPropslElecEquipDTO> tdoiDbPropslElecEquips) {
		this.tdoiDbPropslElecEquips = tdoiDbPropslElecEquips;
	}

	public TdoiDbPropslElecEquipDTO addTdoiDbPropslElecEquip(TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip) {
		getTdoiDbPropslElecEquips().add(tdoiDbPropslElecEquip);
		tdoiDbPropslElecEquip.setTdoiDbProposal(this);

		return tdoiDbPropslElecEquip;
	}

	public TdoiDbPropslElecEquipDTO removeTdoiDbPropslElecEquip(TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip) {
		getTdoiDbPropslElecEquips().remove(tdoiDbPropslElecEquip);
		tdoiDbPropslElecEquip.setTdoiDbProposal(null);

		return tdoiDbPropslElecEquip;
	}

	public List<TdoiDbPropslFirePerilDTO> getTdoiDbPropslFirePerils() {
		return this.tdoiDbPropslFirePerils;
	}

	public void setTdoiDbPropslFirePerils(List<TdoiDbPropslFirePerilDTO> tdoiDbPropslFirePerils) {
		this.tdoiDbPropslFirePerils = tdoiDbPropslFirePerils;
	}

	public TdoiDbPropslFirePerilDTO addTdoiDbPropslFirePeril(TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril) {
		getTdoiDbPropslFirePerils().add(tdoiDbPropslFirePeril);
		tdoiDbPropslFirePeril.setTdoiDbProposal(this);

		return tdoiDbPropslFirePeril;
	}

	public TdoiDbPropslFirePerilDTO removeTdoiDbPropslFirePeril(TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril) {
		getTdoiDbPropslFirePerils().remove(tdoiDbPropslFirePeril);
		tdoiDbPropslFirePeril.setTdoiDbProposal(null);

		return tdoiDbPropslFirePeril;
	}

	public List<TdoiDbPropslPolicyDTO> getTdoiDbPropslPolicies() {
		return this.tdoiDbPropslPolicies;
	}

	public void setTdoiDbPropslPolicies(List<TdoiDbPropslPolicyDTO> tdoiDbPropslPolicies) {
		this.tdoiDbPropslPolicies = tdoiDbPropslPolicies;
	}

	public TdoiDbPropslPolicyDTO addTdoiDbPropslPolicy(TdoiDbPropslPolicyDTO tdoiDbPropslPolicy) {
		getTdoiDbPropslPolicies().add(tdoiDbPropslPolicy);
		tdoiDbPropslPolicy.setTdoiDbProposal(this);

		return tdoiDbPropslPolicy;
	}

	public TdoiDbPropslPolicyDTO removeTdoiDbPropslPolicy(TdoiDbPropslPolicyDTO tdoiDbPropslPolicy) {
		getTdoiDbPropslPolicies().remove(tdoiDbPropslPolicy);
		tdoiDbPropslPolicy.setTdoiDbProposal(null);

		return tdoiDbPropslPolicy;
	}

	public List<TdoiDbPropslPolAddonDTO> getTdoiDbPropslPolAddons() {
		return this.tdoiDbPropslPolAddons;
	}

	public void setTdoiDbPropslPolAddons(List<TdoiDbPropslPolAddonDTO> tdoiDbPropslPolAddons) {
		this.tdoiDbPropslPolAddons = tdoiDbPropslPolAddons;
	}

	public TdoiDbPropslPolAddonDTO addTdoiDbPropslPolAddon(TdoiDbPropslPolAddonDTO tdoiDbPropslPolAddon) {
		getTdoiDbPropslPolAddons().add(tdoiDbPropslPolAddon);
		tdoiDbPropslPolAddon.setTdoiDbProposal(this);

		return tdoiDbPropslPolAddon;
	}

	public TdoiDbPropslPolAddonDTO removeTdoiDbPropslPolAddon(TdoiDbPropslPolAddonDTO tdoiDbPropslPolAddon) {
		getTdoiDbPropslPolAddons().remove(tdoiDbPropslPolAddon);
		tdoiDbPropslPolAddon.setTdoiDbProposal(null);

		return tdoiDbPropslPolAddon;
	}

	public List<TdoiDbPropMoneyIntransitDTO> getTdoiDbPropMoneyIntransits() {
		return this.tdoiDbPropMoneyIntransits;
	}

	public void setTdoiDbPropMoneyIntransits(List<TdoiDbPropMoneyIntransitDTO> tdoiDbPropMoneyIntransits) {
		this.tdoiDbPropMoneyIntransits = tdoiDbPropMoneyIntransits;
	}

	public TdoiDbPropMoneyIntransitDTO addTdoiDbPropMoneyIntransit(
			TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit) {
		getTdoiDbPropMoneyIntransits().add(tdoiDbPropMoneyIntransit);
		tdoiDbPropMoneyIntransit.setTdoiDbProposal(this);

		return tdoiDbPropMoneyIntransit;
	}

	public TdoiDbPropMoneyIntransitDTO removeTdoiDbPropMoneyIntransit(
			TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit) {
		getTdoiDbPropMoneyIntransits().remove(tdoiDbPropMoneyIntransit);
		tdoiDbPropMoneyIntransit.setTdoiDbProposal(null);

		return tdoiDbPropMoneyIntransit;
	}

}
