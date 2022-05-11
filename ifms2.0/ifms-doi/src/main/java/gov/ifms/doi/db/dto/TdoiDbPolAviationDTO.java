package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_AVIATION database table.
 * 
 */

public class TdoiDbPolAviationDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polAviationId;

	private String aircraftGeogLmt;

	private String aircraftStdInstr;

	private String aircraftUsedPurp;

	private double applDeduction;

	private long bankId;

	private String bankName;

	private long branchId;

	private String branchName;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private double crewPaCover;

	private double insrncPremium;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurStartDt;

	private String isRiReqd;

	private double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;

	private long paymentModeId;

	private String pilotWarranty;

	private double pllAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date polictDt;

	private String policyNo;

	private long policyTypeId;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private String prevPolicyNo;

	private long propslPoliciesId;

	private double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String riskCoveredDtls;

	private double sumInsured;

	private double totAddonPrem;

	private double totAgreedVal;

	private double totRiAmt;

	private double totalPremium;

	private double tplCslLiab;

	// bi-directional many-to-one association to TdoiDbProposal

	private TdoiDbProposalDTO tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPolAviationAircraft
	private List<TdoiDbPolAviationAircraftDTO> tdoiDbPolAviationAircrafts;

	// bi-directional many-to-one association to TdoiDbPolAviationRiDtl
	private List<TdoiDbPolAviationRiDtlDTO> tdoiDbPolAviationRiDtls;

	// bi-directional many-to-one association to TdoiDbPolAviationWf
	private List<TdoiDbPolAviationWfDTO> tdoiDbPolAviationWfs;

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

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPolAviationAircraftDTO> getTdoiDbPolAviationAircrafts() {
		return this.tdoiDbPolAviationAircrafts;
	}

	public void setTdoiDbPolAviationAircrafts(List<TdoiDbPolAviationAircraftDTO> tdoiDbPolAviationAircrafts) {
		this.tdoiDbPolAviationAircrafts = tdoiDbPolAviationAircrafts;
	}

	public TdoiDbPolAviationAircraftDTO addTdoiDbPolAviationAircraft(
			TdoiDbPolAviationAircraftDTO tdoiDbPolAviationAircraft) {
		getTdoiDbPolAviationAircrafts().add(tdoiDbPolAviationAircraft);

		return tdoiDbPolAviationAircraft;
	}

	public TdoiDbPolAviationAircraftDTO removeTdoiDbPolAviationAircraft(
			TdoiDbPolAviationAircraftDTO tdoiDbPolAviationAircraft) {
		getTdoiDbPolAviationAircrafts().remove(tdoiDbPolAviationAircraft);

		return tdoiDbPolAviationAircraft;
	}

	public List<TdoiDbPolAviationRiDtlDTO> getTdoiDbPolAviationRiDtls() {
		return this.tdoiDbPolAviationRiDtls;
	}

	public void setTdoiDbPolAviationRiDtls(List<TdoiDbPolAviationRiDtlDTO> tdoiDbPolAviationRiDtls) {
		this.tdoiDbPolAviationRiDtls = tdoiDbPolAviationRiDtls;
	}

	public TdoiDbPolAviationRiDtlDTO addTdoiDbPolAviationRiDtl(TdoiDbPolAviationRiDtlDTO tdoiDbPolAviationRiDtl) {
		getTdoiDbPolAviationRiDtls().add(tdoiDbPolAviationRiDtl);

		return tdoiDbPolAviationRiDtl;
	}

	public TdoiDbPolAviationRiDtlDTO removeTdoiDbPolAviationRiDtl(TdoiDbPolAviationRiDtlDTO tdoiDbPolAviationRiDtl) {
		getTdoiDbPolAviationRiDtls().remove(tdoiDbPolAviationRiDtl);
		return tdoiDbPolAviationRiDtl;
	}

	public List<TdoiDbPolAviationWfDTO> getTdoiDbPolAviationWfs() {
		return this.tdoiDbPolAviationWfs;
	}

	public void setTdoiDbPolAviationWfs(List<TdoiDbPolAviationWfDTO> tdoiDbPolAviationWfs) {
		this.tdoiDbPolAviationWfs = tdoiDbPolAviationWfs;
	}

	public TdoiDbPolAviationWfDTO addTdoiDbPolAviationWf(TdoiDbPolAviationWfDTO tdoiDbPolAviationWf) {
		getTdoiDbPolAviationWfs().add(tdoiDbPolAviationWf);

		return tdoiDbPolAviationWf;
	}

	public TdoiDbPolAviationWfDTO removeTdoiDbPolAviationWf(TdoiDbPolAviationWfDTO tdoiDbPolAviationWf) {
		getTdoiDbPolAviationWfs().remove(tdoiDbPolAviationWf);
		return tdoiDbPolAviationWf;
	}

}
