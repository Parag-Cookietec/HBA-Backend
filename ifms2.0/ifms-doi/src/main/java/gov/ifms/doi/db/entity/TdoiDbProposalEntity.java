package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_PROPOSAL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPOSAL", schema = DoiJPAConstants.DOI_SCHEMA)
public class TdoiDbProposalEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_PROPOSAL_ID", unique = true )
	private long dbProposalId;

	@Column(name = "AADHAR_NUM")
	private long aadharNum;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

	@Temporal(TemporalType.DATE)
	@Column(name = "BTR5_RECEIPT_DT")
	private Date btr5ReceiptDt;

	@Column(name = "BTR5_RECEIPT_NO", length = 20)
	private String btr5ReceiptNo;

	@Column(name = "CHALLAN_AMOUNT")
	private double challanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "CHALLAN_NO", length = 20)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "CHEQUE_DD_NO", length = 20)
	private String chequeDdNo;

	@Column(name = "CONTACT_NUM", length = 30)
	private String contactNum;

	@Column(name = "DISCOUNT_AMOUNT")
	private double discountAmount;

	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "EMAIL_ADDRESS", length = 30)
	private String emailAddress;

	@Column(name = "ENDORSEMENT_NO", length = 20)
	private String endorsementNo;

	@Column(name = "GRAND_TOTAL_AMT")
	private double grandTotalAmt;

	@Column(name = "INSTITUTE_NAME", length = 40)
	private String instituteName;

	@Column(name = "INSTITUTE_TYPE", length = 40)
	private String instituteType;

	@Column(name = "INSUR_PREMIUM" )
	private double insurPremium;

	@Column(name = "INSURED_NAME", length = 40)
	private String insuredName;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_END_DT")
	private Date policyEndDt;

	@Column(name = "POLICY_GENR_BY", length = 50)
	private String policyGenrBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_GENR_DT")
	private Date policyGenrDt;

	@Column(name = "POLICY_NO", length = 30)
	private String policyNo;

	@Column(name = "POLICY_REFRENCE_NO", length = 30)
	private String policyRefrenceNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_RENEW_DT")
	private Date policyRenewDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_START_DT")
	private Date policyStartDt;

	@Column(name = "POLICY_STATUS", length = 30)
	private String policyStatus;

	@Column(name = "POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name = "PREMIUM_AMOUNT")
	private double premiumAmount;

	@Column(name = "PROPERTY_LOCATION", length = 200)
	private String propertyLocation;

	@Column(name = "PROPOSAL_GENR_BY", length = 50)
	private String proposalGenrBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROPOSAL_GENR_DT")
	private Date proposalGenrDt;

	@Column(name = "PROPOSAL_NO", length = 30)
	private String proposalNo;

	@Column(name = "PROPOSAL_STATUS", length = 30)
	private String proposalStatus;

	@Column(name = "PROPOSAL_STATUS_ID")
	private long proposalStatusId;

	@Column(name = "PROPOSER_ADDRESS" , length = 200)
	private String proposerAddress;

	@Column(name = "PROPOSER_NAME" , length = 10)
	private String proposerName;

	@Column(name = "PROPOSER_TYPE_ID" )
	private long proposerTypeId;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "RISK_TYPE_ID")
	private long riskTypeId;

	@Column(name = "SUM_INSURED" )
	private double sumInsured;

	@Column(name = "TALUKA_ID")
	private long talukaId;

	@Column(name = "TAX_AMOUNT")
	private double taxAmount;

	@Column(name = "TOTAL_PREMIUM_AMT")
	private double totalPremiumAmt;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	@OneToMany(mappedBy = "tdoiDbProposalId")
	private List<TdoiDbClaimEntryEntity> tdoiDbClaimEntries;

	// bi-directional many-to-one association to TdoiDbFireBuildingVal
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbFireBuildingValEntity> tdoiDbFireBuildingVals;

	// bi-directional many-to-one association to TdoiDbFirePastPolicy
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbFirePastPolicyEntity> tdoiDbFirePastPolicies;

	// bi-directional many-to-one association to TdoiDbFireRiskLoc
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbFireRiskLocEntity> tdoiDbFireRiskLocs;

	// bi-directional many-to-one association to TdoiDbFireSumInsured
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbFireSumInsuredEntity> tdoiDbFireSumInsureds;

	// bi-directional many-to-one association to TdoiDbPolAviation
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPolAviationEntity> tdoiDbPolAviations;

	// bi-directional many-to-one association to TdoiDbPolBurglary
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPolBurglaryEntity> tdoiDbPolBurglaries;

	// bi-directional many-to-one association to TdoiDbPolElecEquip
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPolElecEquipEntity> tdoiDbPolElecEquips;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPolFirePerilEntity> tdoiDbPolFirePerils;

	// bi-directional many-to-one association to TdoiDbPolMoneyIntransit
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPolMoneyIntransitEntity> tdoiDbPolMoneyIntransits;

	// bi-directional many-to-one association to TdoiDbProposlWf
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbProposlWfEntity> tdoiDbProposlWfs;

	// bi-directional many-to-one association to TdoiDbPropslAviation
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslAviationEntity> tdoiDbPropslAviations;

	// bi-directional many-to-one association to TdoiDbPropslBurglary
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslBurglaryEntity> tdoiDbPropslBurglaries;

	// bi-directional many-to-one association to TdoiDbPropslElecEquip
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslElecEquipEntity> tdoiDbPropslElecEquips;

	// bi-directional many-to-one association to TdoiDbPropslFirePeril
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslFirePerilEntity> tdoiDbPropslFirePerils;

	// bi-directional many-to-one association to TdoiDbPropslPolicy
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslPolicyEntity> tdoiDbPropslPolicies;

	// bi-directional many-to-one association to TdoiDbPropslPolAddon
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropslPolAddonEntity> tdoiDbPropslPolAddons;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit
	@OneToMany(mappedBy = "tdoiDbProposal")
	private List<TdoiDbPropMoneyIntransitEntity> tdoiDbPropMoneyIntransits;

	public TdoiDbProposalEntity() {
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

	public List<TdoiDbClaimEntryEntity> getTdoiDbClaimEntries() {
		return this.tdoiDbClaimEntries;
	}

	public void setTdoiDbClaimEntries(List<TdoiDbClaimEntryEntity> tdoiDbClaimEntries) {
		this.tdoiDbClaimEntries = tdoiDbClaimEntries;
	}


	public List<TdoiDbFireBuildingValEntity> getTdoiDbFireBuildingVals() {
		return this.tdoiDbFireBuildingVals;
	}

	public void setTdoiDbFireBuildingVals(List<TdoiDbFireBuildingValEntity> tdoiDbFireBuildingVals) {
		this.tdoiDbFireBuildingVals = tdoiDbFireBuildingVals;
	}

	public TdoiDbFireBuildingValEntity addTdoiDbFireBuildingVal(TdoiDbFireBuildingValEntity tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().add(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbProposal(this);

		return tdoiDbFireBuildingVal;
	}

	public TdoiDbFireBuildingValEntity removeTdoiDbFireBuildingVal(TdoiDbFireBuildingValEntity tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().remove(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbProposal(null);

		return tdoiDbFireBuildingVal;
	}

	public List<TdoiDbFirePastPolicyEntity> getTdoiDbFirePastPolicies() {
		return this.tdoiDbFirePastPolicies;
	}

	public void setTdoiDbFirePastPolicies(List<TdoiDbFirePastPolicyEntity> tdoiDbFirePastPolicies) {
		this.tdoiDbFirePastPolicies = tdoiDbFirePastPolicies;
	}

	public TdoiDbFirePastPolicyEntity addTdoiDbFirePastPolicy(TdoiDbFirePastPolicyEntity tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().add(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbProposal(this);

		return tdoiDbFirePastPolicy;
	}

	public TdoiDbFirePastPolicyEntity removeTdoiDbFirePastPolicy(TdoiDbFirePastPolicyEntity tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().remove(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbProposal(null);

		return tdoiDbFirePastPolicy;
	}

	public List<TdoiDbFireRiskLocEntity> getTdoiDbFireRiskLocs() {
		return this.tdoiDbFireRiskLocs;
	}

	public void setTdoiDbFireRiskLocs(List<TdoiDbFireRiskLocEntity> tdoiDbFireRiskLocs) {
		this.tdoiDbFireRiskLocs = tdoiDbFireRiskLocs;
	}

	public TdoiDbFireRiskLocEntity addTdoiDbFireRiskLoc(TdoiDbFireRiskLocEntity tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().add(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbProposal(this);

		return tdoiDbFireRiskLoc;
	}

	public TdoiDbFireRiskLocEntity removeTdoiDbFireRiskLoc(TdoiDbFireRiskLocEntity tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().remove(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbProposal(null);

		return tdoiDbFireRiskLoc;
	}

	public List<TdoiDbFireSumInsuredEntity> getTdoiDbFireSumInsureds() {
		return this.tdoiDbFireSumInsureds;
	}

	public void setTdoiDbFireSumInsureds(List<TdoiDbFireSumInsuredEntity> tdoiDbFireSumInsureds) {
		this.tdoiDbFireSumInsureds = tdoiDbFireSumInsureds;
	}

	public TdoiDbFireSumInsuredEntity addTdoiDbFireSumInsured(TdoiDbFireSumInsuredEntity tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().add(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbProposal(this);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbFireSumInsuredEntity removeTdoiDbFireSumInsured(TdoiDbFireSumInsuredEntity tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().remove(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbProposal(null);

		return tdoiDbFireSumInsured;
	}

	public List<TdoiDbPolAviationEntity> getTdoiDbPolAviations() {
		return this.tdoiDbPolAviations;
	}

	public void setTdoiDbPolAviations(List<TdoiDbPolAviationEntity> tdoiDbPolAviations) {
		this.tdoiDbPolAviations = tdoiDbPolAviations;
	}

	public TdoiDbPolAviationEntity addTdoiDbPolAviation(TdoiDbPolAviationEntity tdoiDbPolAviation) {
		getTdoiDbPolAviations().add(tdoiDbPolAviation);
		tdoiDbPolAviation.setTdoiDbProposal(this);

		return tdoiDbPolAviation;
	}

	public TdoiDbPolAviationEntity removeTdoiDbPolAviation(TdoiDbPolAviationEntity tdoiDbPolAviation) {
		getTdoiDbPolAviations().remove(tdoiDbPolAviation);
		tdoiDbPolAviation.setTdoiDbProposal(null);

		return tdoiDbPolAviation;
	}

	public List<TdoiDbPolBurglaryEntity> getTdoiDbPolBurglaries() {
		return this.tdoiDbPolBurglaries;
	}

	public void setTdoiDbPolBurglaries(List<TdoiDbPolBurglaryEntity> tdoiDbPolBurglaries) {
		this.tdoiDbPolBurglaries = tdoiDbPolBurglaries;
	}

	public TdoiDbPolBurglaryEntity addTdoiDbPolBurglary(TdoiDbPolBurglaryEntity tdoiDbPolBurglary) {
		getTdoiDbPolBurglaries().add(tdoiDbPolBurglary);
		tdoiDbPolBurglary.setTdoiDbProposal(this);

		return tdoiDbPolBurglary;
	}

	public TdoiDbPolBurglaryEntity removeTdoiDbPolBurglary(TdoiDbPolBurglaryEntity tdoiDbPolBurglary) {
		getTdoiDbPolBurglaries().remove(tdoiDbPolBurglary);
		tdoiDbPolBurglary.setTdoiDbProposal(null);

		return tdoiDbPolBurglary;
	}

	public List<TdoiDbPolElecEquipEntity> getTdoiDbPolElecEquips() {
		return this.tdoiDbPolElecEquips;
	}

	public void setTdoiDbPolElecEquips(List<TdoiDbPolElecEquipEntity> tdoiDbPolElecEquips) {
		this.tdoiDbPolElecEquips = tdoiDbPolElecEquips;
	}

	public TdoiDbPolElecEquipEntity addTdoiDbPolElecEquip(TdoiDbPolElecEquipEntity tdoiDbPolElecEquip) {
		getTdoiDbPolElecEquips().add(tdoiDbPolElecEquip);
		tdoiDbPolElecEquip.setTdoiDbProposal(this);

		return tdoiDbPolElecEquip;
	}

	public TdoiDbPolElecEquipEntity removeTdoiDbPolElecEquip(TdoiDbPolElecEquipEntity tdoiDbPolElecEquip) {
		getTdoiDbPolElecEquips().remove(tdoiDbPolElecEquip);
		tdoiDbPolElecEquip.setTdoiDbProposal(null);

		return tdoiDbPolElecEquip;
	}

	public List<TdoiDbPolFirePerilEntity> getTdoiDbPolFirePerils() {
		return this.tdoiDbPolFirePerils;
	}

	public void setTdoiDbPolFirePerils(List<TdoiDbPolFirePerilEntity> tdoiDbPolFirePerils) {
		this.tdoiDbPolFirePerils = tdoiDbPolFirePerils;
	}

	public TdoiDbPolFirePerilEntity addTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		getTdoiDbPolFirePerils().add(tdoiDbPolFirePeril);
		tdoiDbPolFirePeril.setTdoiDbProposal(this);

		return tdoiDbPolFirePeril;
	}

	public TdoiDbPolFirePerilEntity removeTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		getTdoiDbPolFirePerils().remove(tdoiDbPolFirePeril);
		tdoiDbPolFirePeril.setTdoiDbProposal(null);

		return tdoiDbPolFirePeril;
	}

	public List<TdoiDbPolMoneyIntransitEntity> getTdoiDbPolMoneyIntransits() {
		return this.tdoiDbPolMoneyIntransits;
	}

	public void setTdoiDbPolMoneyIntransits(List<TdoiDbPolMoneyIntransitEntity> tdoiDbPolMoneyIntransits) {
		this.tdoiDbPolMoneyIntransits = tdoiDbPolMoneyIntransits;
	}

	public TdoiDbPolMoneyIntransitEntity addTdoiDbPolMoneyIntransit(
			TdoiDbPolMoneyIntransitEntity tdoiDbPolMoneyIntransit) {
		getTdoiDbPolMoneyIntransits().add(tdoiDbPolMoneyIntransit);
		tdoiDbPolMoneyIntransit.setTdoiDbProposal(this);

		return tdoiDbPolMoneyIntransit;
	}

	public TdoiDbPolMoneyIntransitEntity removeTdoiDbPolMoneyIntransit(
			TdoiDbPolMoneyIntransitEntity tdoiDbPolMoneyIntransit) {
		getTdoiDbPolMoneyIntransits().remove(tdoiDbPolMoneyIntransit);
		tdoiDbPolMoneyIntransit.setTdoiDbProposal(null);

		return tdoiDbPolMoneyIntransit;
	}

	public List<TdoiDbProposlWfEntity> getTdoiDbProposlWfs() {
		return this.tdoiDbProposlWfs;
	}

	public void setTdoiDbProposlWfs(List<TdoiDbProposlWfEntity> tdoiDbProposlWfs) {
		this.tdoiDbProposlWfs = tdoiDbProposlWfs;
	}

	public TdoiDbProposlWfEntity addTdoiDbProposlWf(TdoiDbProposlWfEntity tdoiDbProposlWf) {
		getTdoiDbProposlWfs().add(tdoiDbProposlWf);
		tdoiDbProposlWf.setTdoiDbProposal(this);

		return tdoiDbProposlWf;
	}

	public TdoiDbProposlWfEntity removeTdoiDbProposlWf(TdoiDbProposlWfEntity tdoiDbProposlWf) {
		getTdoiDbProposlWfs().remove(tdoiDbProposlWf);
		tdoiDbProposlWf.setTdoiDbProposal(null);

		return tdoiDbProposlWf;
	}

	public List<TdoiDbPropslAviationEntity> getTdoiDbPropslAviations() {
		return this.tdoiDbPropslAviations;
	}

	public void setTdoiDbPropslAviations(List<TdoiDbPropslAviationEntity> tdoiDbPropslAviations) {
		this.tdoiDbPropslAviations = tdoiDbPropslAviations;
	}

	public TdoiDbPropslAviationEntity addTdoiDbPropslAviation(TdoiDbPropslAviationEntity tdoiDbPropslAviation) {
		getTdoiDbPropslAviations().add(tdoiDbPropslAviation);
		tdoiDbPropslAviation.setTdoiDbProposal(this);

		return tdoiDbPropslAviation;
	}

	public TdoiDbPropslAviationEntity removeTdoiDbPropslAviation(TdoiDbPropslAviationEntity tdoiDbPropslAviation) {
		getTdoiDbPropslAviations().remove(tdoiDbPropslAviation);
		tdoiDbPropslAviation.setTdoiDbProposal(null);

		return tdoiDbPropslAviation;
	}

	public List<TdoiDbPropslBurglaryEntity> getTdoiDbPropslBurglaries() {
		return this.tdoiDbPropslBurglaries;
	}

	public void setTdoiDbPropslBurglaries(List<TdoiDbPropslBurglaryEntity> tdoiDbPropslBurglaries) {
		this.tdoiDbPropslBurglaries = tdoiDbPropslBurglaries;
	}

	public TdoiDbPropslBurglaryEntity addTdoiDbPropslBurglary(TdoiDbPropslBurglaryEntity tdoiDbPropslBurglary) {
		getTdoiDbPropslBurglaries().add(tdoiDbPropslBurglary);
		tdoiDbPropslBurglary.setTdoiDbProposal(this);

		return tdoiDbPropslBurglary;
	}

	public TdoiDbPropslBurglaryEntity removeTdoiDbPropslBurglary(TdoiDbPropslBurglaryEntity tdoiDbPropslBurglary) {
		getTdoiDbPropslBurglaries().remove(tdoiDbPropslBurglary);
		tdoiDbPropslBurglary.setTdoiDbProposal(null);

		return tdoiDbPropslBurglary;
	}

	public List<TdoiDbPropslElecEquipEntity> getTdoiDbPropslElecEquips() {
		return this.tdoiDbPropslElecEquips;
	}

	public void setTdoiDbPropslElecEquips(List<TdoiDbPropslElecEquipEntity> tdoiDbPropslElecEquips) {
		this.tdoiDbPropslElecEquips = tdoiDbPropslElecEquips;
	}

	public TdoiDbPropslElecEquipEntity addTdoiDbPropslElecEquip(TdoiDbPropslElecEquipEntity tdoiDbPropslElecEquip) {
		getTdoiDbPropslElecEquips().add(tdoiDbPropslElecEquip);
		tdoiDbPropslElecEquip.setTdoiDbProposal(this);

		return tdoiDbPropslElecEquip;
	}

	public TdoiDbPropslElecEquipEntity removeTdoiDbPropslElecEquip(TdoiDbPropslElecEquipEntity tdoiDbPropslElecEquip) {
		getTdoiDbPropslElecEquips().remove(tdoiDbPropslElecEquip);
		tdoiDbPropslElecEquip.setTdoiDbProposal(null);

		return tdoiDbPropslElecEquip;
	}

	public List<TdoiDbPropslFirePerilEntity> getTdoiDbPropslFirePerils() {
		return this.tdoiDbPropslFirePerils;
	}

	public void setTdoiDbPropslFirePerils(List<TdoiDbPropslFirePerilEntity> tdoiDbPropslFirePerils) {
		this.tdoiDbPropslFirePerils = tdoiDbPropslFirePerils;
	}

	public TdoiDbPropslFirePerilEntity addTdoiDbPropslFirePeril(TdoiDbPropslFirePerilEntity tdoiDbPropslFirePeril) {
		getTdoiDbPropslFirePerils().add(tdoiDbPropslFirePeril);
		tdoiDbPropslFirePeril.setTdoiDbProposal(this);

		return tdoiDbPropslFirePeril;
	}

	public TdoiDbPropslFirePerilEntity removeTdoiDbPropslFirePeril(TdoiDbPropslFirePerilEntity tdoiDbPropslFirePeril) {
		getTdoiDbPropslFirePerils().remove(tdoiDbPropslFirePeril);
		tdoiDbPropslFirePeril.setTdoiDbProposal(null);

		return tdoiDbPropslFirePeril;
	}

	public List<TdoiDbPropslPolicyEntity> getTdoiDbPropslPolicies() {
		return this.tdoiDbPropslPolicies;
	}

	public void setTdoiDbPropslPolicies(List<TdoiDbPropslPolicyEntity> tdoiDbPropslPolicies) {
		this.tdoiDbPropslPolicies = tdoiDbPropslPolicies;
	}

	public TdoiDbPropslPolicyEntity addTdoiDbPropslPolicy(TdoiDbPropslPolicyEntity tdoiDbPropslPolicy) {
		getTdoiDbPropslPolicies().add(tdoiDbPropslPolicy);
		tdoiDbPropslPolicy.setTdoiDbProposal(this);

		return tdoiDbPropslPolicy;
	}

	public TdoiDbPropslPolicyEntity removeTdoiDbPropslPolicy(TdoiDbPropslPolicyEntity tdoiDbPropslPolicy) {
		getTdoiDbPropslPolicies().remove(tdoiDbPropslPolicy);
		tdoiDbPropslPolicy.setTdoiDbProposal(null);

		return tdoiDbPropslPolicy;
	}

	public List<TdoiDbPropslPolAddonEntity> getTdoiDbPropslPolAddons() {
		return this.tdoiDbPropslPolAddons;
	}

	public void setTdoiDbPropslPolAddons(List<TdoiDbPropslPolAddonEntity> tdoiDbPropslPolAddons) {
		this.tdoiDbPropslPolAddons = tdoiDbPropslPolAddons;
	}

	public TdoiDbPropslPolAddonEntity addTdoiDbPropslPolAddon(TdoiDbPropslPolAddonEntity tdoiDbPropslPolAddon) {
		getTdoiDbPropslPolAddons().add(tdoiDbPropslPolAddon);
		tdoiDbPropslPolAddon.setTdoiDbProposal(this);

		return tdoiDbPropslPolAddon;
	}

	public TdoiDbPropslPolAddonEntity removeTdoiDbPropslPolAddon(TdoiDbPropslPolAddonEntity tdoiDbPropslPolAddon) {
		getTdoiDbPropslPolAddons().remove(tdoiDbPropslPolAddon);
		tdoiDbPropslPolAddon.setTdoiDbProposal(null);

		return tdoiDbPropslPolAddon;
	}

	public List<TdoiDbPropMoneyIntransitEntity> getTdoiDbPropMoneyIntransits() {
		return this.tdoiDbPropMoneyIntransits;
	}

	public void setTdoiDbPropMoneyIntransits(List<TdoiDbPropMoneyIntransitEntity> tdoiDbPropMoneyIntransits) {
		this.tdoiDbPropMoneyIntransits = tdoiDbPropMoneyIntransits;
	}

	public TdoiDbPropMoneyIntransitEntity addTdoiDbPropMoneyIntransit(
			TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit) {
		getTdoiDbPropMoneyIntransits().add(tdoiDbPropMoneyIntransit);
		tdoiDbPropMoneyIntransit.setTdoiDbProposal(this);

		return tdoiDbPropMoneyIntransit;
	}

	public TdoiDbPropMoneyIntransitEntity removeTdoiDbPropMoneyIntransit(
			TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit) {
		getTdoiDbPropMoneyIntransits().remove(tdoiDbPropMoneyIntransit);
		tdoiDbPropMoneyIntransit.setTdoiDbProposal(null);

		return tdoiDbPropMoneyIntransit;
	}

}