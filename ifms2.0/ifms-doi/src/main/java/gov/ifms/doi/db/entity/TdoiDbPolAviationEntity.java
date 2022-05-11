package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_POL_AVIATION database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_AVIATION", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolAviationEntity.findAll", query = "SELECT t FROM TdoiDbPolAviationEntity t")
public class TdoiDbPolAviationEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POL_AVIATION_ID", unique = true, nullable = false)
	private long polAviationId;

	@Column(name = "AIRCRAFT_GEOG_LMT", length = 100)
	private String aircraftGeogLmt;

	@Column(name = "AIRCRAFT_STD_INSTR", length = 100)
	private String aircraftStdInstr;

	@Column(name = "AIRCRAFT_USED_PURP", length = 100)
	private String aircraftUsedPurp;

	@Column(name = "APPL_DEDUCTION")
	private double applDeduction;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

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

	@Column(name = "CREW_PA_COVER")
	private double crewPaCover;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_START_DT")
	private Date insurStartDt;

	@Column(name = "IS_RI_REQD", length = 1)
	private String isRiReqd;

	@Column(name = "PAYABLE_PREM_AMT")
	private double payablePremAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	@Column(name = "PILOT_WARRANTY", length = 100)
	private String pilotWarranty;

	@Column(name = "PLL_AMT")
	private double pllAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICT_DT")
	private Date polictDt;

	@Column(name = "POLICY_NO", length = 30)
	private String policyNo;

	@Column(name = "POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name = "PREM_DISC_AMT")
	private double premDiscAmt;

	@Column(name = "PREM_DISC_PC")
	private double premDiscPc;

	@Column(name = "PREM_GST_AMT")
	private double premGstAmt;

	@Column(name = "PREM_GST_PC")
	private double premGstPc;

	@Column(name = "PREV_POLICY_NO", length = 40)
	private String prevPolicyNo;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private long propslPoliciesId;

	@Column(name = "RATE_OF_INTRST")
	private double rateOfIntrst;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "RISK_COVERED_DTLS", length = 200)
	private String riskCoveredDtls;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_AGREED_VAL")
	private double totAgreedVal;

	@Column(name = "TOT_RI_AMT")
	private double totRiAmt;

	@Column(name = "TOTAL_PREMIUM")
	private double totalPremium;

	@Column(name = "TPL_CSL_LIAB")
	private double tplCslLiab;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPolAviationAircraft
	@OneToMany(mappedBy = "tdoiDbPolAviation")
	private List<TdoiDbPolAviationAircraftEntity> tdoiDbPolAviationAircrafts;

	// bi-directional many-to-one association to TdoiDbPolAviationRiDtl
	@OneToMany(mappedBy = "tdoiDbPolAviation")
	private List<TdoiDbPolAviationRiDtlEntity> tdoiDbPolAviationRiDtls;

	// bi-directional many-to-one association to TdoiDbPolAviationWf
	@OneToMany(mappedBy = "tdoiDbPolAviation")
	private List<TdoiDbPolAviationWfEntity> tdoiDbPolAviationWfs;

	public long getPolAviationId() {
		return this.polAviationId;
	}

	public void setPolAviationId(long polAviationId) {
		this.polAviationId = polAviationId;
	}

	public String getAircraftGeogLmt() {
		return this.aircraftGeogLmt;
	}

	public void setAircraftGeogLmt(String aircraftGeogLmt) {
		this.aircraftGeogLmt = aircraftGeogLmt;
	}

	public String getAircraftStdInstr() {
		return this.aircraftStdInstr;
	}

	public void setAircraftStdInstr(String aircraftStdInstr) {
		this.aircraftStdInstr = aircraftStdInstr;
	}

	public String getAircraftUsedPurp() {
		return this.aircraftUsedPurp;
	}

	public void setAircraftUsedPurp(String aircraftUsedPurp) {
		this.aircraftUsedPurp = aircraftUsedPurp;
	}

	public double getApplDeduction() {
		return this.applDeduction;
	}

	public void setApplDeduction(double applDeduction) {
		this.applDeduction = applDeduction;
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

	public double getCrewPaCover() {
		return this.crewPaCover;
	}

	public void setCrewPaCover(double crewPaCover) {
		this.crewPaCover = crewPaCover;
	}

	public double getInsrncPremium() {
		return this.insrncPremium;
	}

	public void setInsrncPremium(double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	public Date getInsurEndDt() {
		return this.insurEndDt;
	}

	public void setInsurEndDt(Date insurEndDt) {
		this.insurEndDt = insurEndDt;
	}

	public Date getInsurStartDt() {
		return this.insurStartDt;
	}

	public void setInsurStartDt(Date insurStartDt) {
		this.insurStartDt = insurStartDt;
	}

	public String getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(String isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public double getPayablePremAmt() {
		return this.payablePremAmt;
	}

	public void setPayablePremAmt(double payablePremAmt) {
		this.payablePremAmt = payablePremAmt;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public long getPaymentModeId() {
		return this.paymentModeId;
	}

	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public String getPilotWarranty() {
		return this.pilotWarranty;
	}

	public void setPilotWarranty(String pilotWarranty) {
		this.pilotWarranty = pilotWarranty;
	}

	public double getPllAmt() {
		return this.pllAmt;
	}

	public void setPllAmt(double pllAmt) {
		this.pllAmt = pllAmt;
	}

	public Date getPolictDt() {
		return this.polictDt;
	}

	public void setPolictDt(Date polictDt) {
		this.polictDt = polictDt;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public double getPremDiscAmt() {
		return this.premDiscAmt;
	}

	public void setPremDiscAmt(double premDiscAmt) {
		this.premDiscAmt = premDiscAmt;
	}

	public double getPremDiscPc() {
		return this.premDiscPc;
	}

	public void setPremDiscPc(double premDiscPc) {
		this.premDiscPc = premDiscPc;
	}

	public double getPremGstAmt() {
		return this.premGstAmt;
	}

	public void setPremGstAmt(double premGstAmt) {
		this.premGstAmt = premGstAmt;
	}

	public double getPremGstPc() {
		return this.premGstPc;
	}

	public void setPremGstPc(double premGstPc) {
		this.premGstPc = premGstPc;
	}

	public String getPrevPolicyNo() {
		return this.prevPolicyNo;
	}

	public void setPrevPolicyNo(String prevPolicyNo) {
		this.prevPolicyNo = prevPolicyNo;
	}

	public long getPropslPoliciesId() {
		return this.propslPoliciesId;
	}

	public void setPropslPoliciesId(long propslPoliciesId) {
		this.propslPoliciesId = propslPoliciesId;
	}

	public double getRateOfIntrst() {
		return this.rateOfIntrst;
	}

	public void setRateOfIntrst(double rateOfIntrst) {
		this.rateOfIntrst = rateOfIntrst;
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

	public String getRiskCoveredDtls() {
		return this.riskCoveredDtls;
	}

	public void setRiskCoveredDtls(String riskCoveredDtls) {
		this.riskCoveredDtls = riskCoveredDtls;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getTotAddonPrem() {
		return this.totAddonPrem;
	}

	public void setTotAddonPrem(double totAddonPrem) {
		this.totAddonPrem = totAddonPrem;
	}

	public double getTotAgreedVal() {
		return this.totAgreedVal;
	}

	public void setTotAgreedVal(double totAgreedVal) {
		this.totAgreedVal = totAgreedVal;
	}

	public double getTotRiAmt() {
		return this.totRiAmt;
	}

	public void setTotRiAmt(double totRiAmt) {
		this.totRiAmt = totRiAmt;
	}

	public double getTotalPremium() {
		return this.totalPremium;
	}

	public void setTotalPremium(double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public double getTplCslLiab() {
		return this.tplCslLiab;
	}

	public void setTplCslLiab(double tplCslLiab) {
		this.tplCslLiab = tplCslLiab;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPolAviationAircraftEntity> getTdoiDbPolAviationAircrafts() {
		return this.tdoiDbPolAviationAircrafts;
	}

	public void setTdoiDbPolAviationAircrafts(List<TdoiDbPolAviationAircraftEntity> tdoiDbPolAviationAircrafts) {
		this.tdoiDbPolAviationAircrafts = tdoiDbPolAviationAircrafts;
	}

	public List<TdoiDbPolAviationRiDtlEntity> getTdoiDbPolAviationRiDtls() {
		return this.tdoiDbPolAviationRiDtls;
	}

	public void setTdoiDbPolAviationRiDtls(List<TdoiDbPolAviationRiDtlEntity> tdoiDbPolAviationRiDtls) {
		this.tdoiDbPolAviationRiDtls = tdoiDbPolAviationRiDtls;
	}

	public List<TdoiDbPolAviationWfEntity> getTdoiDbPolAviationWfs() {
		return this.tdoiDbPolAviationWfs;
	}

	public void setTdoiDbPolAviationWfs(List<TdoiDbPolAviationWfEntity> tdoiDbPolAviationWfs) {
		this.tdoiDbPolAviationWfs = tdoiDbPolAviationWfs;
	}

}