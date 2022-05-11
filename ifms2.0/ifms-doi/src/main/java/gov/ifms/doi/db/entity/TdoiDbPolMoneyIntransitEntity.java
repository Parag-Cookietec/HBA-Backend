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
 * The persistent class for the TDOI_DB_POL_MONEY_INTRANSIT database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_MONEY_INTRANSIT", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolMoneyIntransitEntity.findAll", query = "SELECT t FROM TdoiDbPolMoneyIntransitEntity t")
public class TdoiDbPolMoneyIntransitEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POL_MONEY_INTRANS_ID", unique = true, nullable = false)
	private long polMoneyIntransId;

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

	@Column(name = "FIRM_CAPITAL_PAID")
	private double firmCapitalPaid;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Column(name = "INSUR_EXPIRY_TIME", length = 10)
	private String insurExpiryTime;

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

	@Column(name = "PREM_DISC_AMT")
	private double premDiscAmt;

	@Column(name = "PREM_DISC_PC")
	private double premDiscPc;

	@Column(name = "PREM_GST_AMT")
	private double premGstAmt;

	@Column(name = "PREM_GST_PC")
	private double premGstPc;

	@Column(name = "PROPOSER_BUSINESS", length = 100)
	private String proposerBusiness;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private long propslPoliciesId;

	@Column(name = "RATE_OF_INTRST")
	private double rateOfIntrst;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_RI_AMT")
	private double totRiAmt;

	@Column(name = "TOTAL_PREMIUM")
	private double totalPremium;

	// bi-directional many-to-one association to TdoiDbPolMitInsurance
	@OneToMany(mappedBy = "tdoiDbPolMoneyIntransit")
	private List<TdoiDbPolMitInsuranceEntity> tdoiDbPolMitInsurances;

	// bi-directional many-to-one association to TdoiDbPolMitRiDtl
	@OneToMany(mappedBy = "tdoiDbPolMoneyIntransit")
	private List<TdoiDbPolMitRiDtlEntity> tdoiDbPolMitRiDtls;

	// bi-directional many-to-one association to TdoiDbPolMitWf
	@OneToMany(mappedBy = "tdoiDbPolMoneyIntransit")
	private List<TdoiDbPolMitWfEntity> tdoiDbPolMitWfs;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	public TdoiDbPolMoneyIntransitEntity() {
	}

	public long getPolMoneyIntransId() {
		return this.polMoneyIntransId;
	}

	public void setPolMoneyIntransId(long polMoneyIntransId) {
		this.polMoneyIntransId = polMoneyIntransId;
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

	public double getFirmCapitalPaid() {
		return this.firmCapitalPaid;
	}

	public void setFirmCapitalPaid(double firmCapitalPaid) {
		this.firmCapitalPaid = firmCapitalPaid;
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

	public String getInsurExpiryTime() {
		return this.insurExpiryTime;
	}

	public void setInsurExpiryTime(String insurExpiryTime) {
		this.insurExpiryTime = insurExpiryTime;
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

	public String getProposerBusiness() {
		return this.proposerBusiness;
	}

	public void setProposerBusiness(String proposerBusiness) {
		this.proposerBusiness = proposerBusiness;
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

	public List<TdoiDbPolMitInsuranceEntity> getTdoiDbPolMitInsurances() {
		return this.tdoiDbPolMitInsurances;
	}

	public void setTdoiDbPolMitInsurances(List<TdoiDbPolMitInsuranceEntity> tdoiDbPolMitInsurances) {
		this.tdoiDbPolMitInsurances = tdoiDbPolMitInsurances;
	}

	public TdoiDbPolMitInsuranceEntity addTdoiDbPolMitInsurance(TdoiDbPolMitInsuranceEntity tdoiDbPolMitInsurance) {
		getTdoiDbPolMitInsurances().add(tdoiDbPolMitInsurance);
		tdoiDbPolMitInsurance.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitInsurance;
	}

	public TdoiDbPolMitInsuranceEntity removeTdoiDbPolMitInsurance(TdoiDbPolMitInsuranceEntity tdoiDbPolMitInsurance) {
		getTdoiDbPolMitInsurances().remove(tdoiDbPolMitInsurance);
		tdoiDbPolMitInsurance.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitInsurance;
	}

	public List<TdoiDbPolMitRiDtlEntity> getTdoiDbPolMitRiDtls() {
		return this.tdoiDbPolMitRiDtls;
	}

	public void setTdoiDbPolMitRiDtls(List<TdoiDbPolMitRiDtlEntity> tdoiDbPolMitRiDtls) {
		this.tdoiDbPolMitRiDtls = tdoiDbPolMitRiDtls;
	}

	public TdoiDbPolMitRiDtlEntity addTdoiDbPolMitRiDtl(TdoiDbPolMitRiDtlEntity tdoiDbPolMitRiDtl) {
		getTdoiDbPolMitRiDtls().add(tdoiDbPolMitRiDtl);
		tdoiDbPolMitRiDtl.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitRiDtl;
	}

	public TdoiDbPolMitRiDtlEntity removeTdoiDbPolMitRiDtl(TdoiDbPolMitRiDtlEntity tdoiDbPolMitRiDtl) {
		getTdoiDbPolMitRiDtls().remove(tdoiDbPolMitRiDtl);
		tdoiDbPolMitRiDtl.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitRiDtl;
	}

	public List<TdoiDbPolMitWfEntity> getTdoiDbPolMitWfs() {
		return this.tdoiDbPolMitWfs;
	}

	public void setTdoiDbPolMitWfs(List<TdoiDbPolMitWfEntity> tdoiDbPolMitWfs) {
		this.tdoiDbPolMitWfs = tdoiDbPolMitWfs;
	}

	public TdoiDbPolMitWfEntity addTdoiDbPolMitWf(TdoiDbPolMitWfEntity tdoiDbPolMitWf) {
		getTdoiDbPolMitWfs().add(tdoiDbPolMitWf);
		tdoiDbPolMitWf.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitWf;
	}

	public TdoiDbPolMitWfEntity removeTdoiDbPolMitWf(TdoiDbPolMitWfEntity tdoiDbPolMitWf) {
		getTdoiDbPolMitWfs().remove(tdoiDbPolMitWf);
		tdoiDbPolMitWf.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitWf;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

}