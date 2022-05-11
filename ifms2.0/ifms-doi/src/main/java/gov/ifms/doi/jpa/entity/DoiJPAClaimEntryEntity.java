package gov.ifms.doi.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "TDOI_JPA_CLAIM_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJPAClaimEntryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JPA_CLAIM_ID")
	private Long jpaClaimId;

	@Column(name = "PERSON_TYPE_ID")
	private Long personTypeId;

	@Column(name = "DISABLE_TYPE_ID")
	private Long disableTypeId;

	@Column(name = "IS_NODL_JTA_ENTRY")
	private String isNodlJtaEntry;

	@Column(name = "POLICY_NUM")
	private String policyNum;

	@Column(name = "PERSON_NAME")
	private String personName;

	@Column(name = "AADHAR_NUM")
	private Long aadharNum;

	@Column(name = "FATHER_HUSB_NAME")
	private String fatherHusbName;

	@Column(name = "MOTHER_WIFE_NAME")
	private String motherWifeName;

	@Column(name = "MARITAL_TYPE_ID")
	private Long maritalTypeId;

	@Column(name = "COMMUNICATE_ADDR")
	private String communicateAddr;

	@Column(name = "DISTRICT_ID")
	private Long districtId;

	@Column(name = "TALUKA_ID")
	private Long talukaId;

	@Column(name = "VILLAGE_ID")
	private Long villageId;

	@Column(name = "PINCODE")
	private Long pincode;

	@Column(name = "GENDER_ID")
	private Long genderId;

	@Column(name = "DOB_DT")
	private Date dobDt;

	@Column(name = "ACCIDENT_DT")
	private Date accidentDt;

	@Column(name = "DEATH_DISABLE_DT")
	private Date deathDisableDt;

	@Column(name = "AGE_ON_DEATH")
	private int ageOnDeath;

	@Column(name = "ACCIDENT_PLACE")
	private String accidentPlace;

	@Column(name = "LOSS_CAUSE_ID")
	private String lossCauseId;

	@Column(name = "IS_PERSON_DRIVING")
	private int driveVehicle;

	@Column(name = "DRV_LICENSE_NUM")
	private String drvLicenseNum;

	@Column(name = "IS_APPLICANT_SAME")
	private int isApplicantSame;

	@Column(name = "APPLICANT_NAME")
	private String applicantName;

	@Column(name = "APPL_AADHAR_NUM")
	private Long applAadharNum;

	@Column(name = "APPLICANT_ADDR")
	private String applicantAddr;

	@Column(name = "APPL_RELATION_ID")
	private Long applRelationId;

	@Column(name = "APP_DISTRICT_ID")
	private Long appDistrictId;

	@Column(name = "APP_TALUKA_ID")
	private Long appTalukaId;

	@Column(name = "APP_VILLAGE_ID")
	private Long appVillageId;

	@Column(name = "APP_PINCODE")
	private Long appPincode;

	@Column(name = "APP_BANK_ID")
	private Long appBankId;

	@Column(name = "APP_BANK_NAME")
	private String appBankName;

	@Column(name = "APP_BRANCH_ID")
	private Long appBranchId;

	@Column(name = "BANK_IFSC_CODE")
	private String bankIfscCode;

	@Column(name = "APP_MOBILE_NO")
	private Long appMobileNo;

	@Column(name = "IS_NODAL_SAME")
	private int isNodalSame;

	@Column(name = "NODAL_DISTRICT_ID")
	private Long nodalDistrictId;

	@Column(name = "NODAL_TALUKA_ID")
	private Long nodalTalukaId;

	@Column(name = "NODAL_VILLAGE_ID")
	private Long nodalVillageId;

	@Column(name = "NODAL_PINCODE")
	private Long nodalPincode;

	@Column(name = "SCHEME_ID")
	private Long schemeId;

	@Column(name = "SCHEME_NAME")
	private String schemeName;

	@Column(name = "DECEASED_REG_REL_ID")
	private Long deceasedRegRelId;

	@Column(name = "NODAL_OFFICER_NAME")
	private String nodalOfficerName;

	@Column(name = "CLAIM_AMOUNT")
	private Double claimAmount;

	@Column(name = "INWARD_NO")
	private String inwardNumber;

	@Column(name = "INWARD_DT")
	private Date inwrdDate;

	@Column(name = "INWARD_ACCEPT_DT")
	private Date inwardAcceptDt;

	@Column(name = "CLAIM_MONTH_ID")
	private Long claimMonthId;

	@Column(name = "CLAIM_YEAR_ID")
	private Long claimYearId;

	@Column(name = "CLAIM_GENERATE_DT")
	private Date claimGenerateDt;

	@Column(name = "CLAIM_NUMBER")
	private String claimNumber;

	@Column(name = "CLAIM_STATUS_ID")
	private Long claimStatusId;

	@Column(name = "CLAIM_STATUS")
	private String claimStatus;

	@Column(name = "CLAIM_ACCEPT_DT")
	private Date claimAcceptDt;

	@Column(name = "CLAIM_ACCEPT_BY_ID")
	private Long claimAcceptById;

	@Column(name = "CURR_RECCOMD_TYPE")
	private String currReccomdType;

	@Column(name = "CLAIM_ENTRY_STATUS")
	private String claimEntryStatus;

	@Column(name = "IS_SENT_FOR_PAY")
	private int isSentForPay;

	@Column(name = "IS_PAYMENT_DONE")
	private int isPaymentDone;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "CHEQUE_NUM")
	private Long chequeNum;

	@Column(name = "PAYMENT_DT")
	private Date paymentDt;

	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "APP_BANK_ACC_NO")
	private long appBankAccountNo;

	@Column(name = "APP_NAME_IN_BANK", length = 100)
	private String appNameInBank;

	@Column(name = "CLAIM_PAYABLE_AMT")
	private double claimPayableAmt;

	@Column(name = "COMPLAINT_CHRG")
	private double complaintChrg;

	@Column(name = "INTEREST_AMT")
	private double interestAmt;

	@Column(name = "INTEREST_APPL_FROM")
	private Date interestApplFrom;

	@Column(name = "MENTAL_HARASS_CHRG")
	private double mentalHarassChrg;

	@Column(name = "REOPEN_INTEREST")
	private double reopenInterest;

	// bi-directional many-to-one association to TdoiInwardEntry
	@ManyToOne
	@JoinColumn(name = "INWARD_ID")
	private DoiInwardEntry doiInwardEntry;

	// bi-directional many-to-one association to TdoiJpaClaimQuery
	@OneToMany(mappedBy = "doiJpaClaimEntry")
	private List<DoiJpaClaimQueryEntity> doiJpaClaimQueries;

	// bi-directional many-to-one association to TdoiJpaClaimRecommend
	@OneToMany(mappedBy = "doiJpaClaimEntry")
	private List<DoiJpaClaimRecommendEntity> doiJpaClaimRecommends;

	// bi-directional many-to-one association to DoiJpaClaimReturnEntity
	@OneToMany(mappedBy = "doiJpaClaimEntry")
	private List<DoiJpaClaimReturnEntity> doiJpaClaimReturns;

	// bi-directional many-to-one association to DoiJpaClaimEntryWFEntity
	@OneToMany(mappedBy = "doiJpaClaimEntry")
	private List<DoiJpaClaimEntryWFEntity> doiJpaClaimWfs;

	@Column(name = "APP_MOBILE_NUMBER_ALT")
	private Long appMobileNoAlt;

	@Column(name = "APP_EMAIL")
	private String appEmail;

	@Column(name = "DEATH_CERT_NUM")
	private String deathCertificateNumber;

	@Column(name = "DEATH_CERTIFICATE_DATE")
	private Date deathCertificateDate;

	@Column(name = "APPLICANT_PERMANENT_ADDRESS")
	private String applicantAddPer;
	
	@Column(name = "APPLICANT_PERMANENT_DISTRICT")
	private String districtAddPer;
	
	@Column(name = "APPLICANT_PERMANENT_TALUKA")
	private String talukaAddPer;
	
	@Column(name = "APPLICANT_PERMANENT_VILLAGE")
	private String villageAddPer;
	
	@Column(name = "APPLICANT_PERMANENT_PINCODE")
	private String pincodeAddPer;

	@Column(name = "NODAL_EMAIL_ADDRESS")
	private String nodalEmailAddress;
	
	@Column(name = "NODEL_OFFICER")
	private String nodalOfficer;

	@Column(name = "LICENSE_TYPE")
	private int licType;
	
	@Column(name = "LICENSE_NO")
	private String licenseNo;
	
	@Column(name = "LICENSE_VALID_FROM")
	private Date valDateFrom;
	
	@Column(name = "LICENSE_VALID_UPTO")
	private Date valDateTo;

	/**
	 * @return the jpaClaimId
	 */
	public Long getJpaClaimId() {
		return jpaClaimId;
	}

	/**
	 * @param jpaClaimId the jpaClaimId to set
	 */
	public void setJpaClaimId(Long jpaClaimId) {
		this.jpaClaimId = jpaClaimId;
	}

	/**
	 * @return the personTypeId
	 */
	public Long getPersonTypeId() {
		return personTypeId;
	}

	/**
	 * @param personTypeId the personTypeId to set
	 */
	public void setPersonTypeId(Long personTypeId) {
		this.personTypeId = personTypeId;
	}

	/**
	 * @return the disableTypeId
	 */
	public Long getDisableTypeId() {
		return disableTypeId;
	}

	/**
	 * @param disableTypeId the disableTypeId to set
	 */
	public void setDisableTypeId(Long disableTypeId) {
		this.disableTypeId = disableTypeId;
	}

	/**
	 * @return the isNodlJtaEntry
	 */
	public String getIsNodlJtaEntry() {
		return isNodlJtaEntry;
	}

	/**
	 * @param isNodlJtaEntry the isNodlJtaEntry to set
	 */
	public void setIsNodlJtaEntry(String isNodlJtaEntry) {
		this.isNodlJtaEntry = isNodlJtaEntry;
	}

	/**
	 * @return the policyNum
	 */
	public String getPolicyNum() {
		return policyNum;
	}

	/**
	 * @param policyNum the policyNum to set
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the aadharNum
	 */
	public Long getAadharNum() {
		return aadharNum;
	}

	/**
	 * @param aadharNum the aadharNum to set
	 */
	public void setAadharNum(Long aadharNum) {
		this.aadharNum = aadharNum;
	}

	/**
	 * @return the fatherHusbName
	 */
	public String getFatherHusbName() {
		return fatherHusbName;
	}

	/**
	 * @param fatherHusbName the fatherHusbName to set
	 */
	public void setFatherHusbName(String fatherHusbName) {
		this.fatherHusbName = fatherHusbName;
	}

	/**
	 * @return the motherWifeName
	 */
	public String getMotherWifeName() {
		return motherWifeName;
	}

	/**
	 * @param motherWifeName the motherWifeName to set
	 */
	public void setMotherWifeName(String motherWifeName) {
		this.motherWifeName = motherWifeName;
	}

	/**
	 * @return the maritalTypeId
	 */
	public Long getMaritalTypeId() {
		return maritalTypeId;
	}

	/**
	 * @param maritalTypeId the maritalTypeId to set
	 */
	public void setMaritalTypeId(Long maritalTypeId) {
		this.maritalTypeId = maritalTypeId;
	}

	/**
	 * @return the communicateAddr
	 */
	public String getCommunicateAddr() {
		return communicateAddr;
	}

	/**
	 * @param communicateAddr the communicateAddr to set
	 */
	public void setCommunicateAddr(String communicateAddr) {
		this.communicateAddr = communicateAddr;
	}

	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the villageId
	 */
	public Long getVillageId() {
		return villageId;
	}

	/**
	 * @param villageId the villageId to set
	 */
	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	/**
	 * @return the pincode
	 */
	public Long getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the genderId
	 */
	public Long getGenderId() {
		return genderId;
	}

	/**
	 * @param genderId the genderId to set
	 */
	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	/**
	 * @return the dobDt
	 */
	public Date getDobDt() {
		return dobDt;
	}

	/**
	 * @param dobDt the dobDt to set
	 */
	public void setDobDt(Date dobDt) {
		this.dobDt = dobDt;
	}

	/**
	 * @return the accidentDt
	 */
	public Date getAccidentDt() {
		return accidentDt;
	}

	/**
	 * @param accidentDt the accidentDt to set
	 */
	public void setAccidentDt(Date accidentDt) {
		this.accidentDt = accidentDt;
	}

	/**
	 * @return the deathDisableDt
	 */
	public Date getDeathDisableDt() {
		return deathDisableDt;
	}

	/**
	 * @param deathDisableDt the deathDisableDt to set
	 */
	public void setDeathDisableDt(Date deathDisableDt) {
		this.deathDisableDt = deathDisableDt;
	}

	/**
	 * @return the ageOnDeath
	 */
	public int getAgeOnDeath() {
		return ageOnDeath;
	}

	/**
	 * @param ageOnDeath the ageOnDeath to set
	 */
	public void setAgeOnDeath(int ageOnDeath) {
		this.ageOnDeath = ageOnDeath;
	}

	/**
	 * @return the accidentPlace
	 */
	public String getAccidentPlace() {
		return accidentPlace;
	}

	/**
	 * @param accidentPlace the accidentPlace to set
	 */
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	/**
	 * @return the lossCauseId
	 */
	public String getLossCauseId() {
		return lossCauseId;
	}

	/**
	 * @param lossCauseId the lossCauseId to set
	 */
	public void setLossCauseId(String lossCauseId) {
		this.lossCauseId = lossCauseId;
	}

	
	/**
	 * @return the drvLicenseNum
	 */
	public String getDrvLicenseNum() {
		return drvLicenseNum;
	}

	/**
	 * @param drvLicenseNum the drvLicenseNum to set
	 */
	public void setDrvLicenseNum(String drvLicenseNum) {
		this.drvLicenseNum = drvLicenseNum;
	}

	/**
	 * @return the isApplicantSame
	 */
	public int getIsApplicantSame() {
		return isApplicantSame;
	}

	/**
	 * @param isApplicantSame the isApplicantSame to set
	 */
	public void setIsApplicantSame(int isApplicantSame) {
		this.isApplicantSame = isApplicantSame;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the applAadharNum
	 */
	public Long getApplAadharNum() {
		return applAadharNum;
	}

	/**
	 * @param applAadharNum the applAadharNum to set
	 */
	public void setApplAadharNum(Long applAadharNum) {
		this.applAadharNum = applAadharNum;
	}

	/**
	 * @return the applicantAddr
	 */
	public String getApplicantAddr() {
		return applicantAddr;
	}

	/**
	 * @param applicantAddr the applicantAddr to set
	 */
	public void setApplicantAddr(String applicantAddr) {
		this.applicantAddr = applicantAddr;
	}

	/**
	 * @return the applRelationId
	 */
	public Long getApplRelationId() {
		return applRelationId;
	}

	/**
	 * @param applRelationId the applRelationId to set
	 */
	public void setApplRelationId(Long applRelationId) {
		this.applRelationId = applRelationId;
	}

	/**
	 * @return the appDistrictId
	 */
	public Long getAppDistrictId() {
		return appDistrictId;
	}

	/**
	 * @param appDistrictId the appDistrictId to set
	 */
	public void setAppDistrictId(Long appDistrictId) {
		this.appDistrictId = appDistrictId;
	}

	/**
	 * @return the appTalukaId
	 */
	public Long getAppTalukaId() {
		return appTalukaId;
	}

	/**
	 * @param appTalukaId the appTalukaId to set
	 */
	public void setAppTalukaId(Long appTalukaId) {
		this.appTalukaId = appTalukaId;
	}

	/**
	 * @return the appVillageId
	 */
	public Long getAppVillageId() {
		return appVillageId;
	}

	/**
	 * @param appVillageId the appVillageId to set
	 */
	public void setAppVillageId(Long appVillageId) {
		this.appVillageId = appVillageId;
	}

	/**
	 * @return the appPincode
	 */
	public Long getAppPincode() {
		return appPincode;
	}

	/**
	 * @param appPincode the appPincode to set
	 */
	public void setAppPincode(Long appPincode) {
		this.appPincode = appPincode;
	}

	/**
	 * @return the appBankId
	 */
	public Long getAppBankId() {
		return appBankId;
	}

	/**
	 * @param appBankId the appBankId to set
	 */
	public void setAppBankId(Long appBankId) {
		this.appBankId = appBankId;
	}

	/**
	 * @return the appBankName
	 */
	public String getAppBankName() {
		return appBankName;
	}

	/**
	 * @param appBankName the appBankName to set
	 */
	public void setAppBankName(String appBankName) {
		this.appBankName = appBankName;
	}

	/**
	 * @return the appBranchId
	 */
	public Long getAppBranchId() {
		return appBranchId;
	}

	/**
	 * @param appBranchId the appBranchId to set
	 */
	public void setAppBranchId(Long appBranchId) {
		this.appBranchId = appBranchId;
	}

	/**
	 * @return the bankIfscCode
	 */
	public String getBankIfscCode() {
		return bankIfscCode;
	}

	/**
	 * @param bankIfscCode the bankIfscCode to set
	 */
	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	/**
	 * @return the appMobileNo
	 */
	public Long getAppMobileNo() {
		return appMobileNo;
	}

	/**
	 * @param appMobileNo the appMobileNo to set
	 */
	public void setAppMobileNo(Long appMobileNo) {
		this.appMobileNo = appMobileNo;
	}

	/**
	 * @return the isNodalSame
	 */
	public int getIsNodalSame() {
		return isNodalSame;
	}

	/**
	 * @param isNodalSame the isNodalSame to set
	 */
	public void setIsNodalSame(int isNodalSame) {
		this.isNodalSame = isNodalSame;
	}

	/**
	 * @return the nodalDistrictId
	 */
	public Long getNodalDistrictId() {
		return nodalDistrictId;
	}

	/**
	 * @param nodalDistrictId the nodalDistrictId to set
	 */
	public void setNodalDistrictId(Long nodalDistrictId) {
		this.nodalDistrictId = nodalDistrictId;
	}

	/**
	 * @return the nodalTalukaId
	 */
	public Long getNodalTalukaId() {
		return nodalTalukaId;
	}

	/**
	 * @param nodalTalukaId the nodalTalukaId to set
	 */
	public void setNodalTalukaId(Long nodalTalukaId) {
		this.nodalTalukaId = nodalTalukaId;
	}

	/**
	 * @return the nodalVillageId
	 */
	public Long getNodalVillageId() {
		return nodalVillageId;
	}

	/**
	 * @param nodalVillageId the nodalVillageId to set
	 */
	public void setNodalVillageId(Long nodalVillageId) {
		this.nodalVillageId = nodalVillageId;
	}

	/**
	 * @return the nodalPincode
	 */
	public Long getNodalPincode() {
		return nodalPincode;
	}

	/**
	 * @param nodalPincode the nodalPincode to set
	 */
	public void setNodalPincode(Long nodalPincode) {
		this.nodalPincode = nodalPincode;
	}

	/**
	 * @return the schemeId
	 */
	public Long getSchemeId() {
		return schemeId;
	}

	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the deceasedRegRelId
	 */
	public Long getDeceasedRegRelId() {
		return deceasedRegRelId;
	}

	/**
	 * @param deceasedRegRelId the deceasedRegRelId to set
	 */
	public void setDeceasedRegRelId(Long deceasedRegRelId) {
		this.deceasedRegRelId = deceasedRegRelId;
	}

	/**
	 * @return the nodalOfficerName
	 */
	public String getNodalOfficerName() {
		return nodalOfficerName;
	}

	/**
	 * @param nodalOfficerName the nodalOfficerName to set
	 */
	public void setNodalOfficerName(String nodalOfficerName) {
		this.nodalOfficerName = nodalOfficerName;
	}

	/**
	 * @return the claimAmount
	 */
	public Double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * @return the inwardNumber
	 */
	public String getInwardNumber() {
		return inwardNumber;
	}

	/**
	 * @param inwardNumber the inwardNumber to set
	 */
	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	/**
	 * @return the inwrdDate
	 */
	public Date getInwrdDate() {
		return inwrdDate;
	}

	/**
	 * @param inwrdDate the inwrdDate to set
	 */
	public void setInwrdDate(Date inwrdDate) {
		this.inwrdDate = inwrdDate;
	}

	/**
	 * @return the inwardAcceptDt
	 */
	public Date getInwardAcceptDt() {
		return inwardAcceptDt;
	}

	/**
	 * @param inwardAcceptDt the inwardAcceptDt to set
	 */
	public void setInwardAcceptDt(Date inwardAcceptDt) {
		this.inwardAcceptDt = inwardAcceptDt;
	}

	/**
	 * @return the claimMonthId
	 */
	public Long getClaimMonthId() {
		return claimMonthId;
	}

	/**
	 * @param claimMonthId the claimMonthId to set
	 */
	public void setClaimMonthId(Long claimMonthId) {
		this.claimMonthId = claimMonthId;
	}

	/**
	 * @return the claimYearId
	 */
	public Long getClaimYearId() {
		return claimYearId;
	}

	/**
	 * @param claimYearId the claimYearId to set
	 */
	public void setClaimYearId(Long claimYearId) {
		this.claimYearId = claimYearId;
	}

	/**
	 * @return the claimGenerateDt
	 */
	public Date getClaimGenerateDt() {
		return claimGenerateDt;
	}

	/**
	 * @param claimGenerateDt the claimGenerateDt to set
	 */
	public void setClaimGenerateDt(Date claimGenerateDt) {
		this.claimGenerateDt = claimGenerateDt;
	}

	/**
	 * @return the claimNumber
	 */
	public String getClaimNumber() {
		return claimNumber;
	}

	/**
	 * @param claimNumber the claimNumber to set
	 */
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	/**
	 * @return the claimStatusId
	 */
	public Long getClaimStatusId() {
		return claimStatusId;
	}

	/**
	 * @param claimStatusId the claimStatusId to set
	 */
	public void setClaimStatusId(Long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	/**
	 * @return the claimStatus
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * @param claimStatus the claimStatus to set
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	/**
	 * @return the claimAcceptDt
	 */
	public Date getClaimAcceptDt() {
		return claimAcceptDt;
	}

	/**
	 * @param claimAcceptDt the claimAcceptDt to set
	 */
	public void setClaimAcceptDt(Date claimAcceptDt) {
		this.claimAcceptDt = claimAcceptDt;
	}

	/**
	 * @return the claimAcceptById
	 */
	public Long getClaimAcceptById() {
		return claimAcceptById;
	}

	/**
	 * @param claimAcceptById the claimAcceptById to set
	 */
	public void setClaimAcceptById(Long claimAcceptById) {
		this.claimAcceptById = claimAcceptById;
	}

	/**
	 * @return the currReccomdType
	 */
	public String getCurrReccomdType() {
		return currReccomdType;
	}

	/**
	 * @param currReccomdType the currReccomdType to set
	 */
	public void setCurrReccomdType(String currReccomdType) {
		this.currReccomdType = currReccomdType;
	}

	/**
	 * @return the claimEntryStatus
	 */
	public String getClaimEntryStatus() {
		return claimEntryStatus;
	}

	/**
	 * @param claimEntryStatus the claimEntryStatus to set
	 */
	public void setClaimEntryStatus(String claimEntryStatus) {
		this.claimEntryStatus = claimEntryStatus;
	}

	public int getDriveVehicle() {
		return driveVehicle;
	}

	public void setDriveVehicle(int driveVehicle) {
		this.driveVehicle = driveVehicle;
	}

	/**
	 * @return the isSentForPay
	 */
	public int getIsSentForPay() {
		return isSentForPay;
	}

	/**
	 * @param isSentForPay the isSentForPay to set
	 */
	public void setIsSentForPay(int isSentForPay) {
		this.isSentForPay = isSentForPay;
	}

	/**
	 * @return the isPaymentDone
	 */
	public int getIsPaymentDone() {
		return isPaymentDone;
	}

	/**
	 * @param isPaymentDone the isPaymentDone to set
	 */
	public void setIsPaymentDone(int isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the chequeNum
	 */
	public Long getChequeNum() {
		return chequeNum;
	}

	/**
	 * @param chequeNum the chequeNum to set
	 */
	public void setChequeNum(Long chequeNum) {
		this.chequeNum = chequeNum;
	}

	/**
	 * @return the paymentDt
	 */
	public Date getPaymentDt() {
		return paymentDt;
	}

	/**
	 * @param paymentDt the paymentDt to set
	 */
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	/**
	 * @return the paidAmount
	 */
	public Double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
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
	 * @return the appBankAccountNo
	 */
	public long getAppBankAccountNo() {
		return appBankAccountNo;
	}

	/**
	 * @param appBankAccountNo the appBankAccountNo to set
	 */
	public void setAppBankAccountNo(long appBankAccountNo) {
		this.appBankAccountNo = appBankAccountNo;
	}

	/**
	 * @return the appNameInBank
	 */
	public String getAppNameInBank() {
		return appNameInBank;
	}

	/**
	 * @param appNameInBank the appNameInBank to set
	 */
	public void setAppNameInBank(String appNameInBank) {
		this.appNameInBank = appNameInBank;
	}

	/**
	 * @return the claimPayableAmt
	 */
	public double getClaimPayableAmt() {
		return claimPayableAmt;
	}

	/**
	 * @param claimPayableAmt the claimPayableAmt to set
	 */
	public void setClaimPayableAmt(double claimPayableAmt) {
		this.claimPayableAmt = claimPayableAmt;
	}

	/**
	 * @return the complaintChrg
	 */
	public double getComplaintChrg() {
		return complaintChrg;
	}

	/**
	 * @param complaintChrg the complaintChrg to set
	 */
	public void setComplaintChrg(double complaintChrg) {
		this.complaintChrg = complaintChrg;
	}

	/**
	 * @return the interestAmt
	 */
	public double getInterestAmt() {
		return interestAmt;
	}

	/**
	 * @param interestAmt the interestAmt to set
	 */
	public void setInterestAmt(double interestAmt) {
		this.interestAmt = interestAmt;
	}

	/**
	 * @return the interestApplFrom
	 */
	public Date getInterestApplFrom() {
		return interestApplFrom;
	}

	/**
	 * @param interestApplFrom the interestApplFrom to set
	 */
	public void setInterestApplFrom(Date interestApplFrom) {
		this.interestApplFrom = interestApplFrom;
	}

	/**
	 * @return the mentalHarassChrg
	 */
	public double getMentalHarassChrg() {
		return mentalHarassChrg;
	}

	/**
	 * @param mentalHarassChrg the mentalHarassChrg to set
	 */
	public void setMentalHarassChrg(double mentalHarassChrg) {
		this.mentalHarassChrg = mentalHarassChrg;
	}

	/**
	 * @return the reopenInterest
	 */
	public double getReopenInterest() {
		return reopenInterest;
	}

	/**
	 * @param reopenInterest the reopenInterest to set
	 */
	public void setReopenInterest(double reopenInterest) {
		this.reopenInterest = reopenInterest;
	}

	/**
	 * @return the doiInwardEntry
	 */
	public DoiInwardEntry getDoiInwardEntry() {
		return doiInwardEntry;
	}

	/**
	 * @param doiInwardEntry the doiInwardEntry to set
	 */
	public void setDoiInwardEntry(DoiInwardEntry doiInwardEntry) {
		this.doiInwardEntry = doiInwardEntry;
	}

	/**
	 * @return the doiJpaClaimQueries
	 */
	public List<DoiJpaClaimQueryEntity> getDoiJpaClaimQueries() {
		return doiJpaClaimQueries;
	}

	/**
	 * @param doiJpaClaimQueries the doiJpaClaimQueries to set
	 */
	public void setDoiJpaClaimQueries(List<DoiJpaClaimQueryEntity> doiJpaClaimQueries) {
		this.doiJpaClaimQueries = doiJpaClaimQueries;
	}

	/**
	 * @return the doiJpaClaimRecommends
	 */
	public List<DoiJpaClaimRecommendEntity> getDoiJpaClaimRecommends() {
		return doiJpaClaimRecommends;
	}

	/**
	 * @param doiJpaClaimRecommends the doiJpaClaimRecommends to set
	 */
	public void setDoiJpaClaimRecommends(List<DoiJpaClaimRecommendEntity> doiJpaClaimRecommends) {
		this.doiJpaClaimRecommends = doiJpaClaimRecommends;
	}

	/**
	 * @return the doiJpaClaimReturns
	 */
	public List<DoiJpaClaimReturnEntity> getDoiJpaClaimReturns() {
		return doiJpaClaimReturns;
	}

	/**
	 * @param doiJpaClaimReturns the doiJpaClaimReturns to set
	 */
	public void setDoiJpaClaimReturns(List<DoiJpaClaimReturnEntity> doiJpaClaimReturns) {
		this.doiJpaClaimReturns = doiJpaClaimReturns;
	}

	/**
	 * @return the doiJpaClaimWfs
	 */
	public List<DoiJpaClaimEntryWFEntity> getDoiJpaClaimWfs() {
		return doiJpaClaimWfs;
	}

	/**
	 * @param doiJpaClaimWfs the doiJpaClaimWfs to set
	 */
	public void setDoiJpaClaimWfs(List<DoiJpaClaimEntryWFEntity> doiJpaClaimWfs) {
		this.doiJpaClaimWfs = doiJpaClaimWfs;
	}

	/**
	 * @return the appMobileNoAlt
	 */
	public Long getAppMobileNoAlt() {
		return appMobileNoAlt;
	}

	/**
	 * @param appMobileNoAlt the appMobileNoAlt to set
	 */
	public void setAppMobileNoAlt(Long appMobileNoAlt) {
		this.appMobileNoAlt = appMobileNoAlt;
	}

	/**
	 * @return the appEmail
	 */
	public String getAppEmail() {
		return appEmail;
	}

	/**
	 * @param appEmail the appEmail to set
	 */
	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
	}

	/**
	 * @return the deathCertificateNumber
	 */
	public String getDeathCertificateNumber() {
		return deathCertificateNumber;
	}

	/**
	 * @param deathCertificateNumber the deathCertificateNumber to set
	 */
	public void setDeathCertificateNumber(String deathCertificateNumber) {
		this.deathCertificateNumber = deathCertificateNumber;
	}

	/**
	 * @return the deathCertificateDate
	 */
	public Date getDeathCertificateDate() {
		return deathCertificateDate;
	}

	/**
	 * @param deathCertificateDate the deathCertificateDate to set
	 */
	public void setDeathCertificateDate(Date deathCertificateDate) {
		this.deathCertificateDate = deathCertificateDate;
	}

	/**
	 * @return the applicantAddPer
	 */
	public String getApplicantAddPer() {
		return applicantAddPer;
	}

	/**
	 * @param applicantAddPer the applicantAddPer to set
	 */
	public void setApplicantAddPer(String applicantAddPer) {
		this.applicantAddPer = applicantAddPer;
	}

	/**
	 * @return the districtAddPer
	 */
	public String getDistrictAddPer() {
		return districtAddPer;
	}

	/**
	 * @param districtAddPer the districtAddPer to set
	 */
	public void setDistrictAddPer(String districtAddPer) {
		this.districtAddPer = districtAddPer;
	}

	/**
	 * @return the talukaAddPer
	 */
	public String getTalukaAddPer() {
		return talukaAddPer;
	}

	/**
	 * @param talukaAddPer the talukaAddPer to set
	 */
	public void setTalukaAddPer(String talukaAddPer) {
		this.talukaAddPer = talukaAddPer;
	}

	/**
	 * @return the villageAddPer
	 */
	public String getVillageAddPer() {
		return villageAddPer;
	}

	/**
	 * @param villageAddPer the villageAddPer to set
	 */
	public void setVillageAddPer(String villageAddPer) {
		this.villageAddPer = villageAddPer;
	}

	/**
	 * @return the pincodeAddPer
	 */
	public String getPincodeAddPer() {
		return pincodeAddPer;
	}

	/**
	 * @param pincodeAddPer the pincodeAddPer to set
	 */
	public void setPincodeAddPer(String pincodeAddPer) {
		this.pincodeAddPer = pincodeAddPer;
	}

	/**
	 * @return the nodalEmailAddress
	 */
	public String getNodalEmailAddress() {
		return nodalEmailAddress;
	}

	/**
	 * @param nodalEmailAddress the nodalEmailAddress to set
	 */
	public void setNodalEmailAddress(String nodalEmailAddress) {
		this.nodalEmailAddress = nodalEmailAddress;
	}

	/**
	 * @return the nodalOfficer
	 */
	public String getNodalOfficer() {
		return nodalOfficer;
	}

	/**
	 * @param nodalOfficer the nodalOfficer to set
	 */
	public void setNodalOfficer(String nodalOfficer) {
		this.nodalOfficer = nodalOfficer;
	}

	/**
	 * @return the licType
	 */
	public int getLicType() {
		return licType;
	}

	/**
	 * @param licType the licType to set
	 */
	public void setLicType(int licType) {
		this.licType = licType;
	}

	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * @return the valDateFrom
	 */
	public Date getValDateFrom() {
		return valDateFrom;
	}

	/**
	 * @param valDateFrom the valDateFrom to set
	 */
	public void setValDateFrom(Date valDateFrom) {
		this.valDateFrom = valDateFrom;
	}

	/**
	 * @return the valDateTo
	 */
	public Date getValDateTo() {
		return valDateTo;
	}

	/**
	 * @param valDateTo the valDateTo to set
	 */
	public void setValDateTo(Date valDateTo) {
		this.valDateTo = valDateTo;
	}

}
