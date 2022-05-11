package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_HBA_PROPOSAL database table. * @author
 * Sagar Jadhav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaProposalDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long hbaProposalId;
	private long aadharNum;

	private long bankId;

	private String bankName;

	private long branchId;

	private String branchName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date btr5ReceiptDt;

	private String btr5ReceiptNo;

	private long ceilingTypeId;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private String designation;

	private long districtId;

	private long dppfTakenLoan;

	private double earthqInsPrem;

	private int earthqInsTerm;

	private double earthqRate;

	private double earthqSumAssurd;

	private String employeeName;

	private String employeeNo;

	private String endorsementNo;

	private String houseAddress;

	private String houseNo;

	private long houseTypeId;

	private double insrncPremium;

	private String isEarthquakeAoc;

	private String isTerrorismAoc;

	private double loadingChrgAmt;

	private String loanAccountNo;

	private double loanAmount;

	private long mobileNum;

	private String officeAddress;

	private String officeName;

	private String otherAocDesc;

	private double payablePremAmt;

	private long paymentModeId;

	private long pincode;

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

	private long policyTypeId;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private double premiumRoi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long riskCoveredId;

	private double sumInsured;

	private String surveyNo;

	private long talukaId;

	private short termInsYrs;

	private double terrorInsPrem;

	private int terrorInsTerm;

	private double terrorRate;

	private double terrorSumAssurd;

	private double totAddonPrem;

	private double totPremAmt;

	private long villageId;

	private long wallTypeId;

	private List<TdoiHbaClaimEntryDTO> tdoiHbaClaimEntries;

	private List<TdoiHbaProposlWfDTO> tdoiHbaProposlWfs;

	public long getHbaProposalId() {
		return hbaProposalId;
	}

	public void setHbaProposalId(long hbaProposalId) {
		this.hbaProposalId = hbaProposalId;
	}

	public long getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getBtr5ReceiptDt() {
		return btr5ReceiptDt;
	}

	public void setBtr5ReceiptDt(Date btr5ReceiptDt) {
		this.btr5ReceiptDt = btr5ReceiptDt;
	}

	public String getBtr5ReceiptNo() {
		return btr5ReceiptNo;
	}

	public void setBtr5ReceiptNo(String btr5ReceiptNo) {
		this.btr5ReceiptNo = btr5ReceiptNo;
	}

	public long getCeilingTypeId() {
		return ceilingTypeId;
	}

	public void setCeilingTypeId(long ceilingTypeId) {
		this.ceilingTypeId = ceilingTypeId;
	}

	public double getChallanAmount() {
		return challanAmount;
	}

	public void setChallanAmount(double challanAmount) {
		this.challanAmount = challanAmount;
	}

	public Date getChallanDt() {
		return challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChequeDdDt() {
		return chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public String getChequeDdNo() {
		return chequeDdNo;
	}

	public void setChequeDdNo(String chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getDppfTakenLoan() {
		return dppfTakenLoan;
	}

	public void setDppfTakenLoan(long dppfTakenLoan) {
		this.dppfTakenLoan = dppfTakenLoan;
	}

	public double getEarthqInsPrem() {
		return earthqInsPrem;
	}

	public void setEarthqInsPrem(double earthqInsPrem) {
		this.earthqInsPrem = earthqInsPrem;
	}

	public int getEarthqInsTerm() {
		return earthqInsTerm;
	}

	public void setEarthqInsTerm(int earthqInsTerm) {
		this.earthqInsTerm = earthqInsTerm;
	}

	public double getEarthqRate() {
		return earthqRate;
	}

	public void setEarthqRate(double earthqRate) {
		this.earthqRate = earthqRate;
	}

	public double getEarthqSumAssurd() {
		return earthqSumAssurd;
	}

	public void setEarthqSumAssurd(double earthqSumAssurd) {
		this.earthqSumAssurd = earthqSumAssurd;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEndorsementNo() {
		return endorsementNo;
	}

	public void setEndorsementNo(String endorsementNo) {
		this.endorsementNo = endorsementNo;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public long getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public double getInsrncPremium() {
		return insrncPremium;
	}

	public void setInsrncPremium(double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	public String getIsEarthquakeAoc() {
		return isEarthquakeAoc;
	}

	public void setIsEarthquakeAoc(String isEarthquakeAoc) {
		this.isEarthquakeAoc = isEarthquakeAoc;
	}

	public String getIsTerrorismAoc() {
		return isTerrorismAoc;
	}

	public void setIsTerrorismAoc(String isTerrorismAoc) {
		this.isTerrorismAoc = isTerrorismAoc;
	}

	public double getLoadingChrgAmt() {
		return loadingChrgAmt;
	}

	public void setLoadingChrgAmt(double loadingChrgAmt) {
		this.loadingChrgAmt = loadingChrgAmt;
	}

	public String getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(String loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOtherAocDesc() {
		return otherAocDesc;
	}

	public void setOtherAocDesc(String otherAocDesc) {
		this.otherAocDesc = otherAocDesc;
	}

	public double getPayablePremAmt() {
		return payablePremAmt;
	}

	public void setPayablePremAmt(double payablePremAmt) {
		this.payablePremAmt = payablePremAmt;
	}

	public long getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyGenrBy() {
		return policyGenrBy;
	}

	public void setPolicyGenrBy(String policyGenrBy) {
		this.policyGenrBy = policyGenrBy;
	}

	public Date getPolicyGenrDt() {
		return policyGenrDt;
	}

	public void setPolicyGenrDt(Date policyGenrDt) {
		this.policyGenrDt = policyGenrDt;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyRefrenceNo() {
		return policyRefrenceNo;
	}

	public void setPolicyRefrenceNo(String policyRefrenceNo) {
		this.policyRefrenceNo = policyRefrenceNo;
	}

	public Date getPolicyRenewDt() {
		return policyRenewDt;
	}

	public void setPolicyRenewDt(Date policyRenewDt) {
		this.policyRenewDt = policyRenewDt;
	}

	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public long getPolicyTypeId() {
		return policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public double getPremDiscAmt() {
		return premDiscAmt;
	}

	public void setPremDiscAmt(double premDiscAmt) {
		this.premDiscAmt = premDiscAmt;
	}

	public double getPremDiscPc() {
		return premDiscPc;
	}

	public void setPremDiscPc(double premDiscPc) {
		this.premDiscPc = premDiscPc;
	}

	public double getPremGstAmt() {
		return premGstAmt;
	}

	public void setPremGstAmt(double premGstAmt) {
		this.premGstAmt = premGstAmt;
	}

	public double getPremGstPc() {
		return premGstPc;
	}

	public void setPremGstPc(double premGstPc) {
		this.premGstPc = premGstPc;
	}

	public double getPremiumRoi() {
		return premiumRoi;
	}

	public void setPremiumRoi(double premiumRoi) {
		this.premiumRoi = premiumRoi;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public long getRiskCoveredId() {
		return riskCoveredId;
	}

	public void setRiskCoveredId(long riskCoveredId) {
		this.riskCoveredId = riskCoveredId;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public long getTalukaId() {
		return talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	public short getTermInsYrs() {
		return termInsYrs;
	}

	public void setTermInsYrs(short termInsYrs) {
		this.termInsYrs = termInsYrs;
	}

	public double getTerrorInsPrem() {
		return terrorInsPrem;
	}

	public void setTerrorInsPrem(double terrorInsPrem) {
		this.terrorInsPrem = terrorInsPrem;
	}

	public int getTerrorInsTerm() {
		return terrorInsTerm;
	}

	public void setTerrorInsTerm(int terrorInsTerm) {
		this.terrorInsTerm = terrorInsTerm;
	}

	public double getTerrorRate() {
		return terrorRate;
	}

	public void setTerrorRate(double terrorRate) {
		this.terrorRate = terrorRate;
	}

	public double getTerrorSumAssurd() {
		return terrorSumAssurd;
	}

	public void setTerrorSumAssurd(double terrorSumAssurd) {
		this.terrorSumAssurd = terrorSumAssurd;
	}

	public double getTotAddonPrem() {
		return totAddonPrem;
	}

	public void setTotAddonPrem(double totAddonPrem) {
		this.totAddonPrem = totAddonPrem;
	}

	public double getTotPremAmt() {
		return totPremAmt;
	}

	public void setTotPremAmt(double totPremAmt) {
		this.totPremAmt = totPremAmt;
	}

	public long getVillageId() {
		return villageId;
	}

	public void setVillageId(long villageId) {
		this.villageId = villageId;
	}

	public long getWallTypeId() {
		return wallTypeId;
	}

	public void setWallTypeId(long wallTypeId) {
		this.wallTypeId = wallTypeId;
	}

	public List<TdoiHbaClaimEntryDTO> getTdoiHbaClaimEntries() {
		return tdoiHbaClaimEntries;
	}

	public void setTdoiHbaClaimEntries(List<TdoiHbaClaimEntryDTO> tdoiHbaClaimEntries) {
		this.tdoiHbaClaimEntries = tdoiHbaClaimEntries;
	}

	public List<TdoiHbaProposlWfDTO> getTdoiHbaProposlWfs() {
		return tdoiHbaProposlWfs;
	}

	public void setTdoiHbaProposlWfs(List<TdoiHbaProposlWfDTO> tdoiHbaProposlWfs) {
		this.tdoiHbaProposlWfs = tdoiHbaProposlWfs;
	}

}
