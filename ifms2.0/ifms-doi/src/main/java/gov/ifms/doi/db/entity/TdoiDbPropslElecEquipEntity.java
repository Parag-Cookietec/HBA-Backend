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
 * The persistent class for the TDOI_DB_PROPSL_ELEC_EQUIP database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_ELEC_EQUIP", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslElecEquipEntity.findAll", query = "SELECT t FROM TdoiDbPropslElecEquipEntity t")
public class TdoiDbPropslElecEquipEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_ELEC_EQUIP_ID", unique = true, nullable = false)
	private long dbElecEquipId;

	@Column(name = "AGGR_INDEM_LMT")
	private double aggrIndemLmt;

	@Column(name = "ANY_FIRE_INSR_POL", length = 1)
	private String anyFireInsrPol;

	@Column(name = "ANY_PREV_POLICY", length = 1)
	private String anyPrevPolicy;

	@Column(name = "ANY_STAFF_DISCOUNT", length = 1)
	private String anyStaffDiscount;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

	@Column(name = "BUSINESS_TYPE_ID", nullable = false)
	private long businessTypeId;

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

	@Column(name = "CODE_SELECTED", length = 20)
	private String codeSelected;

	@Column(name = "CODE_TYPE_ID")
	private long codeTypeId;

	@Column(name = "COINSURNCE_TYPE_ID")
	private long coinsurnceTypeId;

	@Column(name = "COMPL_ACCSS_INDEM_ID")
	private long complAccssIndemId;

	@Column(name = "EQUIP_LOCATION", length = 100)
	private String equipLocation;

	@Column(name = "FAIL_EQUIP_NAME", length = 100)
	private String failEquipName;

	@Column(name = "FIRE_INSURER_NAME", length = 100)
	private String fireInsurerName;

	@Column(name = "FIRE_POLICY_NO", length = 30)
	private String firePolicyNo;

	@Column(name = "HAS_PREV_COMP_DECL", length = 1)
	private String hasPrevCompDecl;

	@Column(name = "INDEM_INSUR_WEEK")
	private double indemInsurWeek;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSR_FRM_DT")
	private Date insrFrmDt;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_START_DT")
	private Date insurStartDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_TO_DT")
	private Date insurToDt;

	@Column(name = "INSURANCE_MNTHS")
	private short insuranceMnths;

	@Column(name = "IS_EQUIP_PART_FAIL", length = 1)
	private String isEquipPartFail;

	@Column(name = "IS_EQUIP_UNDER_MAINT", length = 1)
	private String isEquipUnderMaint;

	@Column(name = "IS_OP_STAFF_TRAIN", length = 1)
	private String isOpStaffTrain;

	@Column(name = "IS_RI_REQD", length = 1)
	private String isRiReqd;

	@Column(name = "MAINT_EQUIP_NAME", length = 100)
	private String maintEquipName;

	@Column(name = "OFFICE_CODE_NIA", length = 20)
	private String officeCodeNia;

	@Column(name = "OFFICE_CODE_OIC", length = 20)
	private String officeCodeOic;

	@Column(name = "OFFICE_CODE_OTHR", length = 20)
	private String officeCodeOthr;

	@Column(name = "OFFICE_CODE_UII", length = 20)
	private String officeCodeUii;

	@Column(name = "PAYABLE_PREM_AMT")
	private double payablePremAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	@Column(name = "PERSONAL_EXPENSES")
	private double personalExpenses;

	@Column(name = "POLICY_STATUS", length = 30)
	private String policyStatus;

	@Column(name = "PREM_DISC_AMT")
	private double premDiscAmt;

	@Column(name = "PREM_DISC_PC")
	private double premDiscPc;

	@Column(name = "PREM_GST_AMT")
	private double premGstAmt;

	@Column(name = "PREM_GST_PC")
	private double premGstPc;

	@Column(name = "PREV_DECL_DTLS", length = 200)
	private String prevDeclDtls;

	@Column(name = "PREV_INSR_COMPANY", length = 100)
	private String prevInsrCompany;

	@Temporal(TemporalType.DATE)
	@Column(name = "PREV_INSR_EXPR_DT")
	private Date prevInsrExprDt;

	@Column(name = "PREV_POL_TYPE_ID")
	private long prevPolTypeId;

	@Column(name = "PREV_POLICY_NO", length = 20)
	private String prevPolicyNo;

	@Column(name = "PREV_POLICY_YEAR")
	private short prevPolicyYear;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private long propslPoliciesId;

	@Column(name = "PROPSL_TYPE_ID", nullable = false)
	private long propslTypeId;

	@Column(name = "RATE_OF_INTRST")
	private double rateOfIntrst;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SALARY_ROLL_NO")
	private long salaryRollNo;

	@Column(name = "SHARE_PC_NIA_AMT")
	private double sharePcNiaAmt;

	@Column(name = "SHARE_PC_OIC_AMT")
	private double sharePcOicAmt;

	@Column(name = "SHARE_PC_OTHR_AMT")
	private double sharePcOthrAmt;

	@Column(name = "SHARE_PC_UII_AMT")
	private double sharePcUiiAmt;

	@Column(name = "SUBST_EQUIP_RENT")
	private double substEquipRent;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_RI_AMT")
	private double totRiAmt;

	@Column(name = "TOT_SUM_INSURED")
	private double totSumInsured;

	@Column(name = "TOTAL_PREMIUM")
	private double totalPremium;

	@Column(name = "TRANSPORT_COST")
	private double transportCost;

	@Column(name = "UPP_LMT_PER_OCCUR")
	private double uppLmtPerOccur;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPropslElecWf
	@OneToMany(mappedBy = "tdoiDbPropslElecEquip")
	private List<TdoiDbPropslElecWfEntity> tdoiDbPropslElecWfs;

	// bi-directional many-to-one association to TdoiDbPropslEquipDtl
	@OneToMany(mappedBy = "tdoiDbPropslElecEquip")
	private List<TdoiDbPropslEquipDtlEntity> tdoiDbPropslEquipDtls;

	// bi-directional many-to-one association to TdoiDbPropElecRiDtl
	@OneToMany(mappedBy = "tdoiDbPropslElecEquip")
	private List<TdoiDbPropElecRiDtlEntity> tdoiDbPropElecRiDtls;

	public TdoiDbPropslElecEquipEntity() {
	}

	public long getDbElecEquipId() {
		return this.dbElecEquipId;
	}

	public void setDbElecEquipId(long dbElecEquipId) {
		this.dbElecEquipId = dbElecEquipId;
	}

	public double getAggrIndemLmt() {
		return this.aggrIndemLmt;
	}

	public void setAggrIndemLmt(double aggrIndemLmt) {
		this.aggrIndemLmt = aggrIndemLmt;
	}

	public String getAnyFireInsrPol() {
		return this.anyFireInsrPol;
	}

	public void setAnyFireInsrPol(String anyFireInsrPol) {
		this.anyFireInsrPol = anyFireInsrPol;
	}

	public String getAnyPrevPolicy() {
		return this.anyPrevPolicy;
	}

	public void setAnyPrevPolicy(String anyPrevPolicy) {
		this.anyPrevPolicy = anyPrevPolicy;
	}

	public String getAnyStaffDiscount() {
		return this.anyStaffDiscount;
	}

	public void setAnyStaffDiscount(String anyStaffDiscount) {
		this.anyStaffDiscount = anyStaffDiscount;
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

	public long getBusinessTypeId() {
		return this.businessTypeId;
	}

	public void setBusinessTypeId(long businessTypeId) {
		this.businessTypeId = businessTypeId;
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

	public String getCodeSelected() {
		return this.codeSelected;
	}

	public void setCodeSelected(String codeSelected) {
		this.codeSelected = codeSelected;
	}

	public long getCodeTypeId() {
		return this.codeTypeId;
	}

	public void setCodeTypeId(long codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public long getCoinsurnceTypeId() {
		return this.coinsurnceTypeId;
	}

	public void setCoinsurnceTypeId(long coinsurnceTypeId) {
		this.coinsurnceTypeId = coinsurnceTypeId;
	}

	public long getComplAccssIndemId() {
		return this.complAccssIndemId;
	}

	public void setComplAccssIndemId(long complAccssIndemId) {
		this.complAccssIndemId = complAccssIndemId;
	}

	public String getEquipLocation() {
		return this.equipLocation;
	}

	public void setEquipLocation(String equipLocation) {
		this.equipLocation = equipLocation;
	}

	public String getFailEquipName() {
		return this.failEquipName;
	}

	public void setFailEquipName(String failEquipName) {
		this.failEquipName = failEquipName;
	}

	public String getFireInsurerName() {
		return this.fireInsurerName;
	}

	public void setFireInsurerName(String fireInsurerName) {
		this.fireInsurerName = fireInsurerName;
	}

	public String getFirePolicyNo() {
		return this.firePolicyNo;
	}

	public void setFirePolicyNo(String firePolicyNo) {
		this.firePolicyNo = firePolicyNo;
	}

	public String getHasPrevCompDecl() {
		return this.hasPrevCompDecl;
	}

	public void setHasPrevCompDecl(String hasPrevCompDecl) {
		this.hasPrevCompDecl = hasPrevCompDecl;
	}

	public double getIndemInsurWeek() {
		return this.indemInsurWeek;
	}

	public void setIndemInsurWeek(double indemInsurWeek) {
		this.indemInsurWeek = indemInsurWeek;
	}

	public Date getInsrFrmDt() {
		return this.insrFrmDt;
	}

	public void setInsrFrmDt(Date insrFrmDt) {
		this.insrFrmDt = insrFrmDt;
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

	public Date getInsurToDt() {
		return this.insurToDt;
	}

	public void setInsurToDt(Date insurToDt) {
		this.insurToDt = insurToDt;
	}

	public short getInsuranceMnths() {
		return this.insuranceMnths;
	}

	public void setInsuranceMnths(short insuranceMnths) {
		this.insuranceMnths = insuranceMnths;
	}

	public String getIsEquipPartFail() {
		return this.isEquipPartFail;
	}

	public void setIsEquipPartFail(String isEquipPartFail) {
		this.isEquipPartFail = isEquipPartFail;
	}

	public String getIsEquipUnderMaint() {
		return this.isEquipUnderMaint;
	}

	public void setIsEquipUnderMaint(String isEquipUnderMaint) {
		this.isEquipUnderMaint = isEquipUnderMaint;
	}

	public String getIsOpStaffTrain() {
		return this.isOpStaffTrain;
	}

	public void setIsOpStaffTrain(String isOpStaffTrain) {
		this.isOpStaffTrain = isOpStaffTrain;
	}

	public String getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(String isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public String getMaintEquipName() {
		return this.maintEquipName;
	}

	public void setMaintEquipName(String maintEquipName) {
		this.maintEquipName = maintEquipName;
	}

	public String getOfficeCodeNia() {
		return this.officeCodeNia;
	}

	public void setOfficeCodeNia(String officeCodeNia) {
		this.officeCodeNia = officeCodeNia;
	}

	public String getOfficeCodeOic() {
		return this.officeCodeOic;
	}

	public void setOfficeCodeOic(String officeCodeOic) {
		this.officeCodeOic = officeCodeOic;
	}

	public String getOfficeCodeOthr() {
		return this.officeCodeOthr;
	}

	public void setOfficeCodeOthr(String officeCodeOthr) {
		this.officeCodeOthr = officeCodeOthr;
	}

	public String getOfficeCodeUii() {
		return this.officeCodeUii;
	}

	public void setOfficeCodeUii(String officeCodeUii) {
		this.officeCodeUii = officeCodeUii;
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

	public double getPersonalExpenses() {
		return this.personalExpenses;
	}

	public void setPersonalExpenses(double personalExpenses) {
		this.personalExpenses = personalExpenses;
	}

	public String getPolicyStatus() {
		return this.policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
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

	public String getPrevDeclDtls() {
		return this.prevDeclDtls;
	}

	public void setPrevDeclDtls(String prevDeclDtls) {
		this.prevDeclDtls = prevDeclDtls;
	}

	public String getPrevInsrCompany() {
		return this.prevInsrCompany;
	}

	public void setPrevInsrCompany(String prevInsrCompany) {
		this.prevInsrCompany = prevInsrCompany;
	}

	public Date getPrevInsrExprDt() {
		return this.prevInsrExprDt;
	}

	public void setPrevInsrExprDt(Date prevInsrExprDt) {
		this.prevInsrExprDt = prevInsrExprDt;
	}

	public long getPrevPolTypeId() {
		return this.prevPolTypeId;
	}

	public void setPrevPolTypeId(long prevPolTypeId) {
		this.prevPolTypeId = prevPolTypeId;
	}

	public String getPrevPolicyNo() {
		return this.prevPolicyNo;
	}

	public void setPrevPolicyNo(String prevPolicyNo) {
		this.prevPolicyNo = prevPolicyNo;
	}

	public short getPrevPolicyYear() {
		return this.prevPolicyYear;
	}

	public void setPrevPolicyYear(short prevPolicyYear) {
		this.prevPolicyYear = prevPolicyYear;
	}

	public long getPropslPoliciesId() {
		return this.propslPoliciesId;
	}

	public void setPropslPoliciesId(long propslPoliciesId) {
		this.propslPoliciesId = propslPoliciesId;
	}

	public long getPropslTypeId() {
		return this.propslTypeId;
	}

	public void setPropslTypeId(long propslTypeId) {
		this.propslTypeId = propslTypeId;
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

	public long getSalaryRollNo() {
		return this.salaryRollNo;
	}

	public void setSalaryRollNo(long salaryRollNo) {
		this.salaryRollNo = salaryRollNo;
	}

	public double getSharePcNiaAmt() {
		return this.sharePcNiaAmt;
	}

	public void setSharePcNiaAmt(double sharePcNiaAmt) {
		this.sharePcNiaAmt = sharePcNiaAmt;
	}

	public double getSharePcOicAmt() {
		return this.sharePcOicAmt;
	}

	public void setSharePcOicAmt(double sharePcOicAmt) {
		this.sharePcOicAmt = sharePcOicAmt;
	}

	public double getSharePcOthrAmt() {
		return this.sharePcOthrAmt;
	}

	public void setSharePcOthrAmt(double sharePcOthrAmt) {
		this.sharePcOthrAmt = sharePcOthrAmt;
	}

	public double getSharePcUiiAmt() {
		return this.sharePcUiiAmt;
	}

	public void setSharePcUiiAmt(double sharePcUiiAmt) {
		this.sharePcUiiAmt = sharePcUiiAmt;
	}

	public double getSubstEquipRent() {
		return this.substEquipRent;
	}

	public void setSubstEquipRent(double substEquipRent) {
		this.substEquipRent = substEquipRent;
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

	public double getTotSumInsured() {
		return this.totSumInsured;
	}

	public void setTotSumInsured(double totSumInsured) {
		this.totSumInsured = totSumInsured;
	}

	public double getTotalPremium() {
		return this.totalPremium;
	}

	public void setTotalPremium(double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public double getTransportCost() {
		return this.transportCost;
	}

	public void setTransportCost(double transportCost) {
		this.transportCost = transportCost;
	}

	public double getUppLmtPerOccur() {
		return this.uppLmtPerOccur;
	}

	public void setUppLmtPerOccur(double uppLmtPerOccur) {
		this.uppLmtPerOccur = uppLmtPerOccur;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslElecWfEntity> getTdoiDbPropslElecWfs() {
		return this.tdoiDbPropslElecWfs;
	}

	public void setTdoiDbPropslElecWfs(List<TdoiDbPropslElecWfEntity> tdoiDbPropslElecWfs) {
		this.tdoiDbPropslElecWfs = tdoiDbPropslElecWfs;
	}

	public TdoiDbPropslElecWfEntity addTdoiDbPropslElecWf(TdoiDbPropslElecWfEntity tdoiDbPropslElecWf) {
		getTdoiDbPropslElecWfs().add(tdoiDbPropslElecWf);
		tdoiDbPropslElecWf.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropslElecWf;
	}

	public TdoiDbPropslElecWfEntity removeTdoiDbPropslElecWf(TdoiDbPropslElecWfEntity tdoiDbPropslElecWf) {
		getTdoiDbPropslElecWfs().remove(tdoiDbPropslElecWf);
		tdoiDbPropslElecWf.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropslElecWf;
	}

	public List<TdoiDbPropslEquipDtlEntity> getTdoiDbPropslEquipDtls() {
		return this.tdoiDbPropslEquipDtls;
	}

	public void setTdoiDbPropslEquipDtls(List<TdoiDbPropslEquipDtlEntity> tdoiDbPropslEquipDtls) {
		this.tdoiDbPropslEquipDtls = tdoiDbPropslEquipDtls;
	}

	public TdoiDbPropslEquipDtlEntity addTdoiDbPropslEquipDtl(TdoiDbPropslEquipDtlEntity tdoiDbPropslEquipDtl) {
		getTdoiDbPropslEquipDtls().add(tdoiDbPropslEquipDtl);
		tdoiDbPropslEquipDtl.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropslEquipDtl;
	}

	public TdoiDbPropslEquipDtlEntity removeTdoiDbPropslEquipDtl(TdoiDbPropslEquipDtlEntity tdoiDbPropslEquipDtl) {
		getTdoiDbPropslEquipDtls().remove(tdoiDbPropslEquipDtl);
		tdoiDbPropslEquipDtl.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropslEquipDtl;
	}

	public List<TdoiDbPropElecRiDtlEntity> getTdoiDbPropElecRiDtls() {
		return this.tdoiDbPropElecRiDtls;
	}

	public void setTdoiDbPropElecRiDtls(List<TdoiDbPropElecRiDtlEntity> tdoiDbPropElecRiDtls) {
		this.tdoiDbPropElecRiDtls = tdoiDbPropElecRiDtls;
	}

	public TdoiDbPropElecRiDtlEntity addTdoiDbPropElecRiDtl(TdoiDbPropElecRiDtlEntity tdoiDbPropElecRiDtl) {
		getTdoiDbPropElecRiDtls().add(tdoiDbPropElecRiDtl);
		tdoiDbPropElecRiDtl.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropElecRiDtl;
	}

	public TdoiDbPropElecRiDtlEntity removeTdoiDbPropElecRiDtl(TdoiDbPropElecRiDtlEntity tdoiDbPropElecRiDtl) {
		getTdoiDbPropElecRiDtls().remove(tdoiDbPropElecRiDtl);
		tdoiDbPropElecRiDtl.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropElecRiDtl;
	}

}