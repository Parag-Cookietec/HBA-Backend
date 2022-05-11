package gov.ifms.doi.hba.entity;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_HBA_PROPOSAL database table. * @author
 * Sagar Jadhav
 */
@Entity
@Table(name = "TDOI_HBA_PROPOSAL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiHbaProposalEntity.findAll", query = "SELECT t FROM TdoiHbaProposalEntity t")
public class TdoiHbaProposalEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HBA_PROPOSAL_ID", unique = true, nullable = false)
	private long hbaProposalId;

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

	@Column(name = "CEILING_TYPE_ID")
	private long ceilingTypeId;

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

	@Column(nullable = false, length = 30)
	private String designation;

	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "DPPF_TAKEN_LOAN", nullable = false)
	private long dppfTakenLoan;

	@Column(name = "EARTHQ_INS_PREM")
	private double earthqInsPrem;

	@Column(name = "EARTHQ_INS_TERM")
	private int earthqInsTerm;

	@Column(name = "EARTHQ_RATE")
	private double earthqRate;

	@Column(name = "EARTHQ_SUM_ASSURD")
	private double earthqSumAssurd;

	@Column(name = "EMPLOYEE_NAME", nullable = false, length = 100)
	private String employeeName;

	@Column(name = "EMPLOYEE_NO", length = 20)
	private String employeeNo;

	@Column(name = "ENDORSEMENT_NO", length = 20)
	private String endorsementNo;

	@Column(name = "HOUSE_ADDRESS", length = 200)
	private String houseAddress;

	@Column(name = "HOUSE_NO", length = 50)
	private String houseNo;

	@Column(name = "HOUSE_TYPE_ID")
	private long houseTypeId;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Column(name = "IS_EARTHQUAKE_AOC", length = 1)
	private String isEarthquakeAoc;

	@Column(name = "IS_TERRORISM_AOC", length = 1)
	private String isTerrorismAoc;

	@Column(name = "LOADING_CHRG_AMT")
	private double loadingChrgAmt;

	@Column(name = "LOAN_ACCOUNT_NO", nullable = false, length = 20)
	private String loanAccountNo;

	@Column(name = "LOAN_AMOUNT", nullable = false)
	private double loanAmount;

	@Column(name = "MOBILE_NUM")
	private long mobileNum;

	@Column(name = "OFFICE_ADDRESS", nullable = false, length = 200)
	private String officeAddress;

	@Column(name = "OFFICE_NAME", nullable = false, length = 50)
	private String officeName;

	@Column(name = "OTHER_AOC_DESC", length = 100)
	private String otherAocDesc;

	@Column(name = "PAYABLE_PREM_AMT")
	private double payablePremAmt;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	private long pincode;

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

	@Column(name = "PREMIUM_ROI")
	private double premiumRoi;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "RISK_COVERED_ID")
	private long riskCoveredId;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "SURVEY_NO", length = 30)
	private String surveyNo;

	@Column(name = "TALUKA_ID")
	private long talukaId;

	@Column(name = "TERM_INS_YRS")
	private short termInsYrs;

	@Column(name = "TERROR_INS_PREM")
	private double terrorInsPrem;

	@Column(name = "TERROR_INS_TERM")
	private int terrorInsTerm;

	@Column(name = "TERROR_RATE")
	private double terrorRate;

	@Column(name = "TERROR_SUM_ASSURD")
	private double terrorSumAssurd;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_PREM_AMT")
	private double totPremAmt;

	@Column(name = "VILLAGE_ID")
	private long villageId;

	@Column(name = "WALL_TYPE_ID")
	private long wallTypeId;

	// bi-directional many-to-one association to TdoiHbaClaimEntry
	@OneToMany(mappedBy = "tdoiHbaProposal")
	@JsonManagedReference
	private List<TdoiHbaClaimEntryEntity> tdoiHbaClaimEntries;

	// bi-directional many-to-one association to TdoiHbaProposlWf
	@OneToMany(mappedBy = "tdoiHbaProposal")
	@JsonManagedReference
	private List<TdoiHbaProposlWfEntity> tdoiHbaProposlWfs;

	public TdoiHbaProposalEntity() {
	}

	public TdoiHbaProposalEntity(long hbaProposalId) {
		this.hbaProposalId = hbaProposalId;
	}

	/**
	 * @return the hbaProposalId
	 */
	public long getHbaProposalId() {
		return hbaProposalId;
	}

	/**
	 * @param hbaProposalId the hbaProposalId to set
	 */
	public void setHbaProposalId(long hbaProposalId) {
		this.hbaProposalId = hbaProposalId;
	}

	/**
	 * @return the aadharNum
	 */
	public long getAadharNum() {
		return aadharNum;
	}

	/**
	 * @param aadharNum the aadharNum to set
	 */
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	/**
	 * @return the bankId
	 */
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchId
	 */
	public long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the btr5ReceiptDt
	 */
	public Date getBtr5ReceiptDt() {
		return btr5ReceiptDt;
	}

	/**
	 * @param btr5ReceiptDt the btr5ReceiptDt to set
	 */
	public void setBtr5ReceiptDt(Date btr5ReceiptDt) {
		this.btr5ReceiptDt = btr5ReceiptDt;
	}

	/**
	 * @return the btr5ReceiptNo
	 */
	public String getBtr5ReceiptNo() {
		return btr5ReceiptNo;
	}

	/**
	 * @param btr5ReceiptNo the btr5ReceiptNo to set
	 */
	public void setBtr5ReceiptNo(String btr5ReceiptNo) {
		this.btr5ReceiptNo = btr5ReceiptNo;
	}

	/**
	 * @return the ceilingTypeId
	 */
	public long getCeilingTypeId() {
		return ceilingTypeId;
	}

	/**
	 * @param ceilingTypeId the ceilingTypeId to set
	 */
	public void setCeilingTypeId(long ceilingTypeId) {
		this.ceilingTypeId = ceilingTypeId;
	}

	/**
	 * @return the challanAmount
	 */
	public double getChallanAmount() {
		return challanAmount;
	}

	/**
	 * @param challanAmount the challanAmount to set
	 */
	public void setChallanAmount(double challanAmount) {
		this.challanAmount = challanAmount;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the chequeDdDt
	 */
	public Date getChequeDdDt() {
		return chequeDdDt;
	}

	/**
	 * @param chequeDdDt the chequeDdDt to set
	 */
	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	/**
	 * @return the chequeDdNo
	 */
	public String getChequeDdNo() {
		return chequeDdNo;
	}

	/**
	 * @param chequeDdNo the chequeDdNo to set
	 */
	public void setChequeDdNo(String chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the dppfTakenLoan
	 */
	public long getDppfTakenLoan() {
		return dppfTakenLoan;
	}

	/**
	 * @param dppfTakenLoan the dppfTakenLoan to set
	 */
	public void setDppfTakenLoan(long dppfTakenLoan) {
		this.dppfTakenLoan = dppfTakenLoan;
	}

	/**
	 * @return the earthqInsPrem
	 */
	public double getEarthqInsPrem() {
		return earthqInsPrem;
	}

	/**
	 * @param earthqInsPrem the earthqInsPrem to set
	 */
	public void setEarthqInsPrem(double earthqInsPrem) {
		this.earthqInsPrem = earthqInsPrem;
	}

	/**
	 * @return the earthqInsTerm
	 */
	public int getEarthqInsTerm() {
		return earthqInsTerm;
	}

	/**
	 * @param earthqInsTerm the earthqInsTerm to set
	 */
	public void setEarthqInsTerm(int earthqInsTerm) {
		this.earthqInsTerm = earthqInsTerm;
	}

	/**
	 * @return the earthqRate
	 */
	public double getEarthqRate() {
		return earthqRate;
	}

	/**
	 * @param earthqRate the earthqRate to set
	 */
	public void setEarthqRate(double earthqRate) {
		this.earthqRate = earthqRate;
	}

	/**
	 * @return the earthqSumAssurd
	 */
	public double getEarthqSumAssurd() {
		return earthqSumAssurd;
	}

	/**
	 * @param earthqSumAssurd the earthqSumAssurd to set
	 */
	public void setEarthqSumAssurd(double earthqSumAssurd) {
		this.earthqSumAssurd = earthqSumAssurd;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the endorsementNo
	 */
	public String getEndorsementNo() {
		return endorsementNo;
	}

	/**
	 * @param endorsementNo the endorsementNo to set
	 */
	public void setEndorsementNo(String endorsementNo) {
		this.endorsementNo = endorsementNo;
	}

	/**
	 * @return the houseAddress
	 */
	public String getHouseAddress() {
		return houseAddress;
	}

	/**
	 * @param houseAddress the houseAddress to set
	 */
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	/**
	 * @return the houseNo
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @param houseNo the houseNo to set
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * @return the houseTypeId
	 */
	public long getHouseTypeId() {
		return houseTypeId;
	}

	/**
	 * @param houseTypeId the houseTypeId to set
	 */
	public void setHouseTypeId(long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	/**
	 * @return the insrncPremium
	 */
	public double getInsrncPremium() {
		return insrncPremium;
	}

	/**
	 * @param insrncPremium the insrncPremium to set
	 */
	public void setInsrncPremium(double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	/**
	 * @return the isEarthquakeAoc
	 */
	public String getIsEarthquakeAoc() {
		return isEarthquakeAoc;
	}

	/**
	 * @param isEarthquakeAoc the isEarthquakeAoc to set
	 */
	public void setIsEarthquakeAoc(String isEarthquakeAoc) {
		this.isEarthquakeAoc = isEarthquakeAoc;
	}

	/**
	 * @return the isTerrorismAoc
	 */
	public String getIsTerrorismAoc() {
		return isTerrorismAoc;
	}

	/**
	 * @param isTerrorismAoc the isTerrorismAoc to set
	 */
	public void setIsTerrorismAoc(String isTerrorismAoc) {
		this.isTerrorismAoc = isTerrorismAoc;
	}

	/**
	 * @return the loadingChrgAmt
	 */
	public double getLoadingChrgAmt() {
		return loadingChrgAmt;
	}

	/**
	 * @param loadingChrgAmt the loadingChrgAmt to set
	 */
	public void setLoadingChrgAmt(double loadingChrgAmt) {
		this.loadingChrgAmt = loadingChrgAmt;
	}

	/**
	 * @return the loanAccountNo
	 */
	public String getLoanAccountNo() {
		return loanAccountNo;
	}

	/**
	 * @param loanAccountNo the loanAccountNo to set
	 */
	public void setLoanAccountNo(String loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	/**
	 * @return the loanAmount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the mobileNum
	 */
	public long getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * @return the officeAddress
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * @param officeAddress the officeAddress to set
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the otherAocDesc
	 */
	public String getOtherAocDesc() {
		return otherAocDesc;
	}

	/**
	 * @param otherAocDesc the otherAocDesc to set
	 */
	public void setOtherAocDesc(String otherAocDesc) {
		this.otherAocDesc = otherAocDesc;
	}

	/**
	 * @return the payablePremAmt
	 */
	public double getPayablePremAmt() {
		return payablePremAmt;
	}

	/**
	 * @param payablePremAmt the payablePremAmt to set
	 */
	public void setPayablePremAmt(double payablePremAmt) {
		this.payablePremAmt = payablePremAmt;
	}

	/**
	 * @return the paymentModeId
	 */
	public long getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	/**
	 * @return the pincode
	 */
	public long getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the policyEndDt
	 */
	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	/**
	 * @param policyEndDt the policyEndDt to set
	 */
	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	/**
	 * @return the policyGenrBy
	 */
	public String getPolicyGenrBy() {
		return policyGenrBy;
	}

	/**
	 * @param policyGenrBy the policyGenrBy to set
	 */
	public void setPolicyGenrBy(String policyGenrBy) {
		this.policyGenrBy = policyGenrBy;
	}

	/**
	 * @return the policyGenrDt
	 */
	public Date getPolicyGenrDt() {
		return policyGenrDt;
	}

	/**
	 * @param policyGenrDt the policyGenrDt to set
	 */
	public void setPolicyGenrDt(Date policyGenrDt) {
		this.policyGenrDt = policyGenrDt;
	}

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the policyRefrenceNo
	 */
	public String getPolicyRefrenceNo() {
		return policyRefrenceNo;
	}

	/**
	 * @param policyRefrenceNo the policyRefrenceNo to set
	 */
	public void setPolicyRefrenceNo(String policyRefrenceNo) {
		this.policyRefrenceNo = policyRefrenceNo;
	}

	/**
	 * @return the policyRenewDt
	 */
	public Date getPolicyRenewDt() {
		return policyRenewDt;
	}

	/**
	 * @param policyRenewDt the policyRenewDt to set
	 */
	public void setPolicyRenewDt(Date policyRenewDt) {
		this.policyRenewDt = policyRenewDt;
	}

	/**
	 * @return the policyStartDt
	 */
	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	/**
	 * @param policyStartDt the policyStartDt to set
	 */
	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	/**
	 * @return the policyTypeId
	 */
	public long getPolicyTypeId() {
		return policyTypeId;
	}

	/**
	 * @param policyTypeId the policyTypeId to set
	 */
	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	/**
	 * @return the premDiscAmt
	 */
	public double getPremDiscAmt() {
		return premDiscAmt;
	}

	/**
	 * @param premDiscAmt the premDiscAmt to set
	 */
	public void setPremDiscAmt(double premDiscAmt) {
		this.premDiscAmt = premDiscAmt;
	}

	/**
	 * @return the premDiscPc
	 */
	public double getPremDiscPc() {
		return premDiscPc;
	}

	/**
	 * @param premDiscPc the premDiscPc to set
	 */
	public void setPremDiscPc(double premDiscPc) {
		this.premDiscPc = premDiscPc;
	}

	/**
	 * @return the premGstAmt
	 */
	public double getPremGstAmt() {
		return premGstAmt;
	}

	/**
	 * @param premGstAmt the premGstAmt to set
	 */
	public void setPremGstAmt(double premGstAmt) {
		this.premGstAmt = premGstAmt;
	}

	/**
	 * @return the premGstPc
	 */
	public double getPremGstPc() {
		return premGstPc;
	}

	/**
	 * @param premGstPc the premGstPc to set
	 */
	public void setPremGstPc(double premGstPc) {
		this.premGstPc = premGstPc;
	}

	/**
	 * @return the premiumRoi
	 */
	public double getPremiumRoi() {
		return premiumRoi;
	}

	/**
	 * @param premiumRoi the premiumRoi to set
	 */
	public void setPremiumRoi(double premiumRoi) {
		this.premiumRoi = premiumRoi;
	}

	/**
	 * @return the referenceDt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the riskCoveredId
	 */
	public long getRiskCoveredId() {
		return riskCoveredId;
	}

	/**
	 * @param riskCoveredId the riskCoveredId to set
	 */
	public void setRiskCoveredId(long riskCoveredId) {
		this.riskCoveredId = riskCoveredId;
	}

	/**
	 * @return the sumInsured
	 */
	public double getSumInsured() {
		return sumInsured;
	}

	/**
	 * @param sumInsured the sumInsured to set
	 */
	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	/**
	 * @return the surveyNo
	 */
	public String getSurveyNo() {
		return surveyNo;
	}

	/**
	 * @param surveyNo the surveyNo to set
	 */
	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	/**
	 * @return the talukaId
	 */
	public long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the termInsYrs
	 */
	public short getTermInsYrs() {
		return termInsYrs;
	}

	/**
	 * @param termInsYrs the termInsYrs to set
	 */
	public void setTermInsYrs(short termInsYrs) {
		this.termInsYrs = termInsYrs;
	}

	/**
	 * @return the terrorInsPrem
	 */
	public double getTerrorInsPrem() {
		return terrorInsPrem;
	}

	/**
	 * @param terrorInsPrem the terrorInsPrem to set
	 */
	public void setTerrorInsPrem(double terrorInsPrem) {
		this.terrorInsPrem = terrorInsPrem;
	}

	/**
	 * @return the terrorInsTerm
	 */
	public int getTerrorInsTerm() {
		return terrorInsTerm;
	}

	/**
	 * @param terrorInsTerm the terrorInsTerm to set
	 */
	public void setTerrorInsTerm(int terrorInsTerm) {
		this.terrorInsTerm = terrorInsTerm;
	}

	/**
	 * @return the terrorRate
	 */
	public double getTerrorRate() {
		return terrorRate;
	}

	/**
	 * @param terrorRate the terrorRate to set
	 */
	public void setTerrorRate(double terrorRate) {
		this.terrorRate = terrorRate;
	}

	/**
	 * @return the terrorSumAssurd
	 */
	public double getTerrorSumAssurd() {
		return terrorSumAssurd;
	}

	/**
	 * @param terrorSumAssurd the terrorSumAssurd to set
	 */
	public void setTerrorSumAssurd(double terrorSumAssurd) {
		this.terrorSumAssurd = terrorSumAssurd;
	}

	/**
	 * @return the totAddonPrem
	 */
	public double getTotAddonPrem() {
		return totAddonPrem;
	}

	/**
	 * @param totAddonPrem the totAddonPrem to set
	 */
	public void setTotAddonPrem(double totAddonPrem) {
		this.totAddonPrem = totAddonPrem;
	}

	/**
	 * @return the totPremAmt
	 */
	public double getTotPremAmt() {
		return totPremAmt;
	}

	/**
	 * @param totPremAmt the totPremAmt to set
	 */
	public void setTotPremAmt(double totPremAmt) {
		this.totPremAmt = totPremAmt;
	}

	/**
	 * @return the villageId
	 */
	public long getVillageId() {
		return villageId;
	}

	/**
	 * @param villageId the villageId to set
	 */
	public void setVillageId(long villageId) {
		this.villageId = villageId;
	}

	/**
	 * @return the wallTypeId
	 */
	public long getWallTypeId() {
		return wallTypeId;
	}

	/**
	 * @param wallTypeId the wallTypeId to set
	 */
	public void setWallTypeId(long wallTypeId) {
		this.wallTypeId = wallTypeId;
	}

	/**
	 * @return the tdoiHbaClaimEntries
	 */
	public List<TdoiHbaClaimEntryEntity> getTdoiHbaClaimEntries() {
		return tdoiHbaClaimEntries;
	}

	/**
	 * @param tdoiHbaClaimEntries the tdoiHbaClaimEntries to set
	 */
	public void setTdoiHbaClaimEntries(List<TdoiHbaClaimEntryEntity> tdoiHbaClaimEntries) {
		this.tdoiHbaClaimEntries = tdoiHbaClaimEntries;
	}

	/**
	 * @return the tdoiHbaProposlWfs
	 */
	public List<TdoiHbaProposlWfEntity> getTdoiHbaProposlWfs() {
		return tdoiHbaProposlWfs;
	}

	/**
	 * @param tdoiHbaProposlWfs the tdoiHbaProposlWfs to set
	 */
	public void setTdoiHbaProposlWfs(List<TdoiHbaProposlWfEntity> tdoiHbaProposlWfs) {
		this.tdoiHbaProposlWfs = tdoiHbaProposlWfs;
	}

}