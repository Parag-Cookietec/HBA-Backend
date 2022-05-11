package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_AVIATION database table.
 * 
 */

public class TdoiDbPropslAviationDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propAviationId;

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

	private TdoiDbProposalDTO tdoiDbProposal;

	private List<TdoiDbPropslAviationWfDTO> tdoiDbPropslAviationWfs;

	private List<TdoiDbPropAviationAircraftDTO> tdoiDbPropAviationAircrafts;

	private List<TdoiDbPropAviationRiDtlDTO> tdoiDbPropAviationRiDtls;

	public long getPropAviationId() {
		return this.propAviationId;
	}

	public void setPropAviationId(long propAviationId) {
		this.propAviationId = propAviationId;
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

	public List<TdoiDbPropslAviationWfDTO> getTdoiDbPropslAviationWfs() {
		return this.tdoiDbPropslAviationWfs;
	}

	public void setTdoiDbPropslAviationWfs(List<TdoiDbPropslAviationWfDTO> tdoiDbPropslAviationWfs) {
		this.tdoiDbPropslAviationWfs = tdoiDbPropslAviationWfs;
	}

	public TdoiDbPropslAviationWfDTO addTdoiDbPropslAviationWf(TdoiDbPropslAviationWfDTO tdoiDbPropslAviationWf) {
		getTdoiDbPropslAviationWfs().add(tdoiDbPropslAviationWf);
		tdoiDbPropslAviationWf.setTdoiDbPropslAviation(this);

		return tdoiDbPropslAviationWf;
	}

	public TdoiDbPropslAviationWfDTO removeTdoiDbPropslAviationWf(TdoiDbPropslAviationWfDTO tdoiDbPropslAviationWf) {
		getTdoiDbPropslAviationWfs().remove(tdoiDbPropslAviationWf);
		tdoiDbPropslAviationWf.setTdoiDbPropslAviation(null);

		return tdoiDbPropslAviationWf;
	}

	public List<TdoiDbPropAviationAircraftDTO> getTdoiDbPropAviationAircrafts() {
		return this.tdoiDbPropAviationAircrafts;
	}

	public void setTdoiDbPropAviationAircrafts(List<TdoiDbPropAviationAircraftDTO> tdoiDbPropAviationAircrafts) {
		this.tdoiDbPropAviationAircrafts = tdoiDbPropAviationAircrafts;
	}

	public TdoiDbPropAviationAircraftDTO addTdoiDbPropAviationAircraft(
			TdoiDbPropAviationAircraftDTO tdoiDbPropAviationAircraft) {
		getTdoiDbPropAviationAircrafts().add(tdoiDbPropAviationAircraft);
		tdoiDbPropAviationAircraft.setTdoiDbPropslAviation(this);

		return tdoiDbPropAviationAircraft;
	}

	public TdoiDbPropAviationAircraftDTO removeTdoiDbPropAviationAircraft(
			TdoiDbPropAviationAircraftDTO tdoiDbPropAviationAircraft) {
		getTdoiDbPropAviationAircrafts().remove(tdoiDbPropAviationAircraft);
		tdoiDbPropAviationAircraft.setTdoiDbPropslAviation(null);

		return tdoiDbPropAviationAircraft;
	}

	public List<TdoiDbPropAviationRiDtlDTO> getTdoiDbPropAviationRiDtls() {
		return this.tdoiDbPropAviationRiDtls;
	}

	public void setTdoiDbPropAviationRiDtls(List<TdoiDbPropAviationRiDtlDTO> tdoiDbPropAviationRiDtls) {
		this.tdoiDbPropAviationRiDtls = tdoiDbPropAviationRiDtls;
	}

	public TdoiDbPropAviationRiDtlDTO addTdoiDbPropAviationRiDtl(TdoiDbPropAviationRiDtlDTO tdoiDbPropAviationRiDtl) {
		getTdoiDbPropAviationRiDtls().add(tdoiDbPropAviationRiDtl);
		tdoiDbPropAviationRiDtl.setTdoiDbPropslAviation(this);

		return tdoiDbPropAviationRiDtl;
	}

	public TdoiDbPropAviationRiDtlDTO removeTdoiDbPropAviationRiDtl(
			TdoiDbPropAviationRiDtlDTO tdoiDbPropAviationRiDtl) {
		getTdoiDbPropAviationRiDtls().remove(tdoiDbPropAviationRiDtl);
		tdoiDbPropAviationRiDtl.setTdoiDbPropslAviation(null);

		return tdoiDbPropAviationRiDtl;
	}

}
