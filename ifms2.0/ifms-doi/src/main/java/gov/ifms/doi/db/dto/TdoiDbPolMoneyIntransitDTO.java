package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_MONEY_INTRANSIT database table.
 * 
 */

public class TdoiDbPolMoneyIntransitDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polMoneyIntransId;

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

	private double firmCapitalPaid;

	private double insrncPremium;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurEndDt;

	private String insurExpiryTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurStartDt;

	private String isRiReqd;

	private double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;

	private long paymentModeId;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private String proposerBusiness;

	private long propslPoliciesId;

	private double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private double sumInsured;

	private double totAddonPrem;

	private double totRiAmt;

	private double totalPremium;

	// bi-directional many-to-one association to TdoiDbPolMitInsurance
	private List<TdoiDbPolMitInsuranceDTO> tdoiDbPolMitInsurances;

	// bi-directional many-to-one association to TdoiDbPolMitRiDtl
	private List<TdoiDbPolMitRiDtlDTO> tdoiDbPolMitRiDtls;

	// bi-directional many-to-one association to TdoiDbPolMitWf
	private List<TdoiDbPolMitWfDTO> tdoiDbPolMitWfs;

	// bi-directional many-to-one association to TdoiDbProposal

	private TdoiDbProposalDTO tdoiDbProposal;

	public TdoiDbPolMoneyIntransitDTO() {
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

	public List<TdoiDbPolMitInsuranceDTO> getTdoiDbPolMitInsurances() {
		return this.tdoiDbPolMitInsurances;
	}

	public void setTdoiDbPolMitInsurances(List<TdoiDbPolMitInsuranceDTO> tdoiDbPolMitInsurances) {
		this.tdoiDbPolMitInsurances = tdoiDbPolMitInsurances;
	}

	public TdoiDbPolMitInsuranceDTO addTdoiDbPolMitInsurance(TdoiDbPolMitInsuranceDTO tdoiDbPolMitInsurance) {
		getTdoiDbPolMitInsurances().add(tdoiDbPolMitInsurance);
		tdoiDbPolMitInsurance.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitInsurance;
	}

	public TdoiDbPolMitInsuranceDTO removeTdoiDbPolMitInsurance(TdoiDbPolMitInsuranceDTO tdoiDbPolMitInsurance) {
		getTdoiDbPolMitInsurances().remove(tdoiDbPolMitInsurance);
		tdoiDbPolMitInsurance.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitInsurance;
	}

	public List<TdoiDbPolMitRiDtlDTO> getTdoiDbPolMitRiDtls() {
		return this.tdoiDbPolMitRiDtls;
	}

	public void setTdoiDbPolMitRiDtls(List<TdoiDbPolMitRiDtlDTO> tdoiDbPolMitRiDtls) {
		this.tdoiDbPolMitRiDtls = tdoiDbPolMitRiDtls;
	}

	public TdoiDbPolMitRiDtlDTO addTdoiDbPolMitRiDtl(TdoiDbPolMitRiDtlDTO tdoiDbPolMitRiDtl) {
		getTdoiDbPolMitRiDtls().add(tdoiDbPolMitRiDtl);
		tdoiDbPolMitRiDtl.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitRiDtl;
	}

	public TdoiDbPolMitRiDtlDTO removeTdoiDbPolMitRiDtl(TdoiDbPolMitRiDtlDTO tdoiDbPolMitRiDtl) {
		getTdoiDbPolMitRiDtls().remove(tdoiDbPolMitRiDtl);
		tdoiDbPolMitRiDtl.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitRiDtl;
	}

	public List<TdoiDbPolMitWfDTO> getTdoiDbPolMitWfs() {
		return this.tdoiDbPolMitWfs;
	}

	public void setTdoiDbPolMitWfs(List<TdoiDbPolMitWfDTO> tdoiDbPolMitWfs) {
		this.tdoiDbPolMitWfs = tdoiDbPolMitWfs;
	}

	public TdoiDbPolMitWfDTO addTdoiDbPolMitWf(TdoiDbPolMitWfDTO tdoiDbPolMitWf) {
		getTdoiDbPolMitWfs().add(tdoiDbPolMitWf);
		tdoiDbPolMitWf.setTdoiDbPolMoneyIntransit(this);

		return tdoiDbPolMitWf;
	}

	public TdoiDbPolMitWfDTO removeTdoiDbPolMitWf(TdoiDbPolMitWfDTO tdoiDbPolMitWf) {
		getTdoiDbPolMitWfs().remove(tdoiDbPolMitWf);
		tdoiDbPolMitWf.setTdoiDbPolMoneyIntransit(null);

		return tdoiDbPolMitWf;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

}
