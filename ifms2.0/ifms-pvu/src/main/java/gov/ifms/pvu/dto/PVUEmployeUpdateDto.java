package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 01:17:36
 *
 */
@NativeQueryResultEntity
public class PVUEmployeUpdateDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String itrId;
	@NativeQueryResultColumn(index = 1)
	/** The emp id. */
	private String empId;

	@NativeQueryResultColumn(index = 2)
	private String officeName;

	@NativeQueryResultColumn(index = 3)
	/** The case no. */
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 4)
	/** The employee name. */
	private String employeeName;

	@NativeQueryResultColumn(index = 5)
	private String genderName;

	@NativeQueryResultColumn(index = 6)
	private String nationalityName;

	@NativeQueryResultColumn(index = 7)
	private String dateOfBirth;

	/** The date of birth. */
	@NativeQueryResultColumn(index = 8)
	private String emailId;

	@NativeQueryResultColumn(index = 9)
	private String mobileNo;

	/** The mobile no. */

	@NativeQueryResultColumn(index = 10)
	private String fatherName;

	/** The mother name. */
	@NativeQueryResultColumn(index = 11)
	private String motherName;

	@NativeQueryResultColumn(index = 12)
	private String maritalStatusName;

	@NativeQueryResultColumn(index = 13)
	private String categoryName;

	/** The religion. */
	@NativeQueryResultColumn(index = 14)
	private String religion;

	/** The caste. */
	@NativeQueryResultColumn(index = 15)
	private String caste;

	@NativeQueryResultColumn(index = 16)
	private String bloodGroupName;

	@NativeQueryResultColumn(index = 17)
	private String physicalStatusName;

	@NativeQueryResultColumn(index = 18)
	private String physicalTypeName;

	/** The date of med fitness cert. */
	@NativeQueryResultColumn(index = 19)
	private String dateOfMedicalFitnessCert;

	/** The identification mark. */
	@NativeQueryResultColumn(index = 20)
	private String identificationMark;

	/** The height. */
	@NativeQueryResultColumn(index = 21)
	private Integer height;

	/** The election card no. */
	@NativeQueryResultColumn(index = 22)
	private String electionCardNumber;

	/** The aadhaar no. */
	@NativeQueryResultColumn(index = 23)
	private String aadhaarNumber;

	/** The pan no. */
	@NativeQueryResultColumn(index = 24)
	private String panNumber;

	/** The passport no. */
	@NativeQueryResultColumn(index = 25)
	private String passportNumber;

	/** The passport expiry date. */
	@NativeQueryResultColumn(index = 26)
	private String passportExpiryDate;

	/** The buckle no. */
	@NativeQueryResultColumn(index = 27)
	private String buckleNumber;

	/** The employee photo. */
	@NativeQueryResultColumn(index = 28)
	private String updateByUserName;

	/** The remarks. */
	@NativeQueryResultColumn(index = 29)
	private String updateByPostName;

	/** The remarks. */
	@NativeQueryResultColumn(index = 30)
	private String updateByUpdateDate;


	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 31)
	private String changeType ;

	@NativeQueryResultColumn(index = 32)
	private String physicalPercentage;

	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	
	/**
	 * @return the itrId
	 */
	public String getItrId() {
		return itrId;
	}

	/**
	 * @param itrId the itrId to set
	 */
	public void setItrId(String itrId) {
		this.itrId = itrId;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
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
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
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
	 * @return the genderName
	 */
	public String getGenderName() {
		return genderName;
	}

	/**
	 * @param genderName the genderName to set
	 */
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	/**
	 * @return the nationalityName
	 */
	public String getNationalityName() {
		return nationalityName;
	}

	/**
	 * @param nationalityName the nationalityName to set
	 */
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = PvuUtils.getDateToStringDMYFormatValue(dateOfBirth);
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = PvuUtils.ternaryOperator(emailId);
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the maritalStatusName
	 */
	public String getMaritalStatusName() {
		return maritalStatusName;
	}

	/**
	 * @param maritalStatusName the maritalStatusName to set
	 */
	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * @return the bloodGroupName
	 */
	public String getBloodGroupName() {
		return bloodGroupName;
	}

	/**
	 * @param bloodGroupName the bloodGroupName to set
	 */
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

	/**
	 * @return the physicalStatusName
	 */
	public String getPhysicalStatusName() {
		return physicalStatusName;
	}

	/**
	 * @param physicalStatusName the physicalStatusName to set
	 */
	public void setPhysicalStatusName(String physicalStatusName) {
		this.physicalStatusName = physicalStatusName;
	}

	/**
	 * @return the physicalTypeName
	 */
	public String getPhysicalTypeName() {
		return physicalTypeName;
	}

	/**
	 * @param physicalTypeName the physicalTypeName to set
	 */
	public void setPhysicalTypeName(String physicalTypeName) {
		this.physicalTypeName = physicalTypeName;
	}

	/**
	 * @return the dateOfMedicalFitnessCert
	 */
	public String getDateOfMedicalFitnessCert() {
		return dateOfMedicalFitnessCert;
	}

	/**
	 * @param dateOfMedicalFitnessCert the dateOfMedicalFitnessCert to set
	 */
	public void setDateOfMedicalFitnessCert(String dateOfMedicalFitnessCert) {
		this.dateOfMedicalFitnessCert = PvuUtils.getDateToStringDMYFormatValue(dateOfMedicalFitnessCert);
	}

	/**
	 * @return the identificationMark
	 */
	public String getIdentificationMark() {
		return identificationMark;
	}

	/**
	 * @param identificationMark the identificationMark to set
	 */
	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @return the electionCardNumber
	 */
	public String getElectionCardNumber() {
		return electionCardNumber;
	}

	/**
	 * @param electionCardNumber the electionCardNumber to set
	 */
	public void setElectionCardNumber(String electionCardNumber) {
		this.electionCardNumber = PvuUtils.ternaryOperator(electionCardNumber);
	}

	/**
	 * @return the aadhaarNumber
	 */
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	/**
	 * @param aadhaarNumber the aadhaarNumber to set
	 */
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = PvuUtils.ternaryOperator(aadhaarNumber);
	}

	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}

	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = PvuUtils.ternaryOperator(panNumber);
	}

	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = PvuUtils.ternaryOperator(passportNumber);
	}

	/**
	 * @return the passportExpiryDate
	 */
	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	/**
	 * @param passportExpiryDate the passportExpiryDate to set
	 */
	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = PvuUtils.getDateToStringDMYFormatValue(passportExpiryDate);
	}

	/**
	 * @return the buckleNumber
	 */
	public String getBuckleNumber() {
		return PvuUtils.ternaryOperator(buckleNumber);
	}

	/**
	 * @param buckleNumber the buckleNumber to set
	 */
	public void setBuckleNumber(String buckleNumber) {
		this.buckleNumber = PvuUtils.ternaryOperator(buckleNumber);
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return updateByUserName;
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	public String getPhysicalPercentage() {
		return physicalPercentage;
	}

	public void setPhysicalPercentage(String physicalPercentage) {
		this.physicalPercentage = physicalPercentage;
	}
}