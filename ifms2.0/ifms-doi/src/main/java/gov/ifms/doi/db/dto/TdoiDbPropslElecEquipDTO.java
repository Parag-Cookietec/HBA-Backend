package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_ELEC_EQUIP database table.
 * 
 */
public class TdoiDbPropslElecEquipDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbElecEquipId;

	private double aggrIndemLmt;

	private String anyFireInsrPol;

	private String anyPrevPolicy;

	private String anyStaffDiscount;

	private long bankId;

	private String bankName;

	private long branchId;

	private String branchName;

	private long businessTypeId;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private String codeSelected;

	private long codeTypeId;

	private long coinsurnceTypeId;

	private long complAccssIndemId;

	private String equipLocation;

	private String failEquipName;

	private String fireInsurerName;

	private String firePolicyNo;

	private String hasPrevCompDecl;

	private double indemInsurWeek;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insrFrmDt;

	private double insrncPremium;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurStartDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurToDt;

	private short insuranceMnths;

	private String isEquipPartFail;

	private String isEquipUnderMaint;

	private String isOpStaffTrain;

	private String isRiReqd;

	private String maintEquipName;

	private String officeCodeNia;

	private String officeCodeOic;

	private String officeCodeOthr;

	private String officeCodeUii;

	private double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;

	private long paymentModeId;

	private double personalExpenses;

	private String policyStatus;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private String prevDeclDtls;

	private String prevInsrCompany;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date prevInsrExprDt;

	private long prevPolTypeId;

	private String prevPolicyNo;

	private short prevPolicyYear;

	private long propslPoliciesId;

	private long propslTypeId;

	private double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long salaryRollNo;

	private double sharePcNiaAmt;

	private double sharePcOicAmt;

	private double sharePcOthrAmt;

	private double sharePcUiiAmt;

	private double substEquipRent;

	private double sumInsured;

	private double totAddonPrem;

	private double totRiAmt;

	private double totSumInsured;

	private double totalPremium;

	private double transportCost;

	private double uppLmtPerOccur;

	private TdoiDbProposalDTO tdoiDbProposal;

	private List<TdoiDbPropslElecWfDTO> tdoiDbPropslElecWfs;

	private List<TdoiDbPropslEquipDtlDTO> tdoiDbPropslEquipDtls;

	private List<TdoiDbPropElecRiDtlDTO> tdoiDbPropElecRiDtls;

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

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslElecWfDTO> getTdoiDbPropslElecWfs() {
		return this.tdoiDbPropslElecWfs;
	}

	public void setTdoiDbPropslElecWfs(List<TdoiDbPropslElecWfDTO> tdoiDbPropslElecWfs) {
		this.tdoiDbPropslElecWfs = tdoiDbPropslElecWfs;
	}

	public TdoiDbPropslElecWfDTO addTdoiDbPropslElecWf(TdoiDbPropslElecWfDTO tdoiDbPropslElecWf) {
		getTdoiDbPropslElecWfs().add(tdoiDbPropslElecWf);
		tdoiDbPropslElecWf.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropslElecWf;
	}

	public TdoiDbPropslElecWfDTO removeTdoiDbPropslElecWf(TdoiDbPropslElecWfDTO tdoiDbPropslElecWf) {
		getTdoiDbPropslElecWfs().remove(tdoiDbPropslElecWf);
		tdoiDbPropslElecWf.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropslElecWf;
	}

	public List<TdoiDbPropslEquipDtlDTO> getTdoiDbPropslEquipDtls() {
		return this.tdoiDbPropslEquipDtls;
	}

	public void setTdoiDbPropslEquipDtls(List<TdoiDbPropslEquipDtlDTO> tdoiDbPropslEquipDtls) {
		this.tdoiDbPropslEquipDtls = tdoiDbPropslEquipDtls;
	}

	public TdoiDbPropslEquipDtlDTO addTdoiDbPropslEquipDtl(TdoiDbPropslEquipDtlDTO tdoiDbPropslEquipDtl) {
		getTdoiDbPropslEquipDtls().add(tdoiDbPropslEquipDtl);
		tdoiDbPropslEquipDtl.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropslEquipDtl;
	}

	public TdoiDbPropslEquipDtlDTO removeTdoiDbPropslEquipDtl(TdoiDbPropslEquipDtlDTO tdoiDbPropslEquipDtl) {
		getTdoiDbPropslEquipDtls().remove(tdoiDbPropslEquipDtl);
		tdoiDbPropslEquipDtl.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropslEquipDtl;
	}

	public List<TdoiDbPropElecRiDtlDTO> getTdoiDbPropElecRiDtls() {
		return this.tdoiDbPropElecRiDtls;
	}

	public void setTdoiDbPropElecRiDtls(List<TdoiDbPropElecRiDtlDTO> tdoiDbPropElecRiDtls) {
		this.tdoiDbPropElecRiDtls = tdoiDbPropElecRiDtls;
	}

	public TdoiDbPropElecRiDtlDTO addTdoiDbPropElecRiDtl(TdoiDbPropElecRiDtlDTO tdoiDbPropElecRiDtl) {
		getTdoiDbPropElecRiDtls().add(tdoiDbPropElecRiDtl);
		tdoiDbPropElecRiDtl.setTdoiDbPropslElecEquip(this);

		return tdoiDbPropElecRiDtl;
	}

	public TdoiDbPropElecRiDtlDTO removeTdoiDbPropElecRiDtl(TdoiDbPropElecRiDtlDTO tdoiDbPropElecRiDtl) {
		getTdoiDbPropElecRiDtls().remove(tdoiDbPropElecRiDtl);
		tdoiDbPropElecRiDtl.setTdoiDbPropslElecEquip(null);

		return tdoiDbPropElecRiDtl;
	}

}
