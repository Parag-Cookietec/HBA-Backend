package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 01:17:36
 *
 */
public class PVUEmployeDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	private long empId;

	/** The office id. */
	@NotBlank
	private long officeId;

	private String officeName;

	/** The case no. */
	private String caseNo;

	/** The employee code. */
	private Long employeeCode;

	/** The salutation. */
	private long salutation;

	private String salutationName;

	/** The employee name. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MAX_50_DIGIT)
	private String employeeName;

	/** The employee middle name. */
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String employeeMiddleName;

	/** The employee surname. */
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String employeeSurname;

	/** The gender. */
	@NotBlank
	private long gender;

	private String genderName;

	/** The nationality. */
	@NotBlank
	private long nationality;

	private String nationalityName;

	/** The date of birth. */
	@NotBlank
	private String dateOfBirth;

	/** The email ID. */
	private String emailID;

	/** The mobile no. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_MOBILE_NO_10_DIGIT)
	private String mobileNo;

	/** The father name. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String fatherName;

	/** The mother name. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String motherName;

	/** The marital status. */
	@NotBlank
	private long maritalStatus;

	private String maritalStatusName;

	/** The category. */
	@NotBlank
	private long category;

	private String categoryName;

	/** The religion. */
	@NotBlank
	private String religion;

	/** The caste. */
	@NotBlank
	private String caste;

	/** The blood group. */
	private long bloodGroup;

	private String bloodGroupName;

	/** The ph status. */
	@NotBlank
	private long phStatus;

	private String phStatusName;

	/** The ph type. */
	private long phType;

	private String phTypeName;

	/** The date of med fitness cert. */
	private String dateOfMedFitnessCert;

	/** The identification mark. */
	@NotBlank
	private String identificationMark;

	/** The height. */
	@NotBlank
	private Integer height;

	/** The election card no. */
	private String electionCardNo;

	/** The aadhaar no. */
	private Long aadhaarNo;

	/** The pan no. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_PAN_NUMBER)
	private String panNo;

	/** The passport no. */
	@Pattern(regexp = Constant.Regex.VALIDATION_PASSPORT_NUMBER)
	private String passportNo;

	/** The passport expiry date. */
	private String passportExpiryDate;

	/** The buckle no. */
	private String buckleNo;

	/** The employee photo. */
	private String employeePhoto;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private long statusId;

	private String statusName;

	/** The photoAttachment . */
	private List<AttachmentMasterDto> photoAttachment;

	/** The other ph category. */
	private String otherPhCategory;

	/** The employee photo name. */
	private String employeePhotoName;

	private String empViewPhoto;
	
	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	private long changeType;

	// ExpressEmp = 1, bullEmp = 2 , Migrate =3
	private int empSrcType;

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the case no.
	 *
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * Sets the case no.
	 *
	 * @param caseNo the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * Gets the employee code.
	 *
	 * @return the employeeCode
	 */
	public Long getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * Sets the employee code.
	 *
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Gets the salutation.
	 *
	 * @return the salutation
	 */
	public long getSalutation() {
		return salutation;
	}

	/**
	 * Sets the salutation.
	 *
	 * @param salutation the salutation to set
	 */
	public void setSalutation(long salutation) {
		this.salutation = salutation;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = (null != employeeName) ? employeeName.toUpperCase() : employeeName;
	}

	/**
	 * Gets the employee middle name.
	 *
	 * @return the employeeMiddleName
	 */
	public String getEmployeeMiddleName() {
		return employeeMiddleName;
	}

	/**
	 * Sets the employee middle name.
	 *
	 * @param employeeMiddleName the employeeMiddleName to set
	 */
	public void setEmployeeMiddleName(String employeeMiddleName) {
		this.employeeMiddleName = (null != employeeMiddleName) ? employeeMiddleName.toUpperCase() : employeeMiddleName;
	}

	/**
	 * Gets the employee surname.
	 *
	 * @return the employeeSurname
	 */
	public String getEmployeeSurname() {
		return employeeSurname;
	}

	/**
	 * Sets the employee surname.
	 *
	 * @param employeeSurname the employeeSurname to set
	 */
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = (null != employeeSurname) ? employeeSurname.toUpperCase() : employeeSurname;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public long getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the gender to set
	 */
	public void setGender(long gender) {
		this.gender = gender;
	}

	/**
	 * Gets the nationality.
	 *
	 * @return the nationality
	 */
	public long getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 *
	 * @param nationality the nationality to set
	 */
	public void setNationality(long nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the email ID.
	 *
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * Sets the email ID.
	 *
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets the father name.
	 *
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * Sets the father name.
	 *
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = (null != fatherName) ? fatherName.toUpperCase() : fatherName;
	}

	/**
	 * Gets the mother name.
	 *
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * Sets the mother name.
	 *
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = null != motherName ? motherName.toUpperCase() : motherName;
	}

	/**
	 * Gets the marital status.
	 *
	 * @return the maritalStatus
	 */
	public long getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(long maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public long getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the category to set
	 */
	public void setCategory(long category) {
		this.category = category;
	}

	/**
	 * Gets the religion.
	 *
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * Sets the religion.
	 *
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * Gets the caste.
	 *
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * Sets the caste.
	 *
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * Gets the blood group.
	 *
	 * @return the bloodGroup
	 */
	public long getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group.
	 *
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(long bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Gets the ph status.
	 *
	 * @return the phStatus
	 */
	public long getPhStatus() {
		return phStatus;
	}

	/**
	 * Sets the ph status.
	 *
	 * @param phStatus the phStatus to set
	 */
	public void setPhStatus(long phStatus) {
		this.phStatus = phStatus;
	}

	/**
	 * Gets the ph type.
	 *
	 * @return the phType
	 */
	public long getPhType() {
		return phType;
	}

	/**
	 * Sets the ph type.
	 *
	 * @param phType the phType to set
	 */
	public void setPhType(long phType) {
		this.phType = phType;
	}

	/**
	 * Gets the date of med fitness cert.
	 *
	 * @return the dateOfMedFitnessCert
	 */
	public String getDateOfMedFitnessCert() {
		return dateOfMedFitnessCert;
	}

	/**
	 * Sets the date of med fitness cert.
	 *
	 * @param dateOfMedFitnessCert the dateOfMedFitnessCert to set
	 */
	public void setDateOfMedFitnessCert(String dateOfMedFitnessCert) {
		this.dateOfMedFitnessCert = dateOfMedFitnessCert;
	}

	/**
	 * Gets the identification mark.
	 *
	 * @return the identificationMark
	 */
	public String getIdentificationMark() {
		return identificationMark;
	}

	/**
	 * Sets the identification mark.
	 *
	 * @param identificationMark the identificationMark to set
	 */
	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * Gets the election card no.
	 *
	 * @return the electionCardNo
	 */
	public String getElectionCardNo() {
		return electionCardNo;
	}

	/**
	 * Sets the election card no.
	 *
	 * @param electionCardNo the electionCardNo to set
	 */
	public void setElectionCardNo(String electionCardNo) {
		this.electionCardNo = electionCardNo;
	}

	/**
	 * Gets the aadhaar no.
	 *
	 * @return the aadhaarNo
	 */
	public Long getAadhaarNo() {
		return aadhaarNo;
	}

	/**
	 * Sets the aadhaar no.
	 *
	 * @param aadhaarNo the aadhaarNo to set
	 */
	public void setAadhaarNo(Long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	/**
	 * Gets the pan no.
	 *
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * Sets the pan no.
	 *
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = (null != panNo) ? panNo.toUpperCase() : panNo;
	}

	/**
	 * Gets the passport no.
	 *
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * Sets the passport no.
	 *
	 * @param passportNo the passportNo to set
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * Gets the passport expiry date.
	 *
	 * @return the passportExpiryDate
	 */
	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	/**
	 * Sets the passport expiry date.
	 *
	 * @param passportExpiryDate the passportExpiryDate to set
	 */
	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	/**
	 * Gets the buckle no.
	 *
	 * @return the buckleNo
	 */
	public String getBuckleNo() {
		return buckleNo;
	}

	/**
	 * Sets the buckle no.
	 *
	 * @param buckleNo the buckleNo to set
	 */
	public void setBuckleNo(String buckleNo) {
		this.buckleNo = buckleNo;
	}

	/**
	 * Gets the employee photo.
	 *
	 * @return the employeePhoto
	 */
	public String getEmployeePhoto() {
		return employeePhoto;
	}

	/**
	 * Sets the employee photo.
	 *
	 * @param employeePhoto the employeePhoto to set
	 */
	public void setEmployeePhoto(String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the photo attachment.
	 *
	 * @return the photo attachment
	 */
	public List<AttachmentMasterDto> getPhotoAttachment() {
		return photoAttachment;
	}

	/**
	 * Sets the photo attachment.
	 *
	 * @param photoAttachment the new photo attachment
	 */
	public void setPhotoAttachment(List<AttachmentMasterDto> photoAttachment) {
		this.photoAttachment = photoAttachment;
	}

	/**
	 * Gets the other ph category.
	 *
	 * @return the other ph category
	 */
	public String getOtherPhCategory() {
		return otherPhCategory;
	}

	/**
	 * Sets the other ph category.
	 *
	 * @param otherPhCategory the new other ph category
	 */
	public void setOtherPhCategory(String otherPhCategory) {
		this.otherPhCategory = otherPhCategory;
	}

	/**
	 * Gets the employee photo name.
	 *
	 * @return the employee photo name
	 */
	public String getEmployeePhotoName() {
		return employeePhotoName;
	}

	/**
	 * Sets the employee photo name.
	 *
	 * @param employeePhotoName the new employee photo name
	 */
	public void setEmployeePhotoName(String employeePhotoName) {
		this.employeePhotoName = employeePhotoName;
	}

	/**
	 * PVUEmployeeDto Constructor.
	 */
	public PVUEmployeDto() {
		super();
	}

	public String getEmpViewPhoto() {
		return empViewPhoto;
	}

	public void setEmpViewPhoto(String empViewPhoto) {
		this.empViewPhoto = empViewPhoto;
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
	 * @return the salutationName
	 */
	public String getSalutationName() {
		return salutationName;
	}

	/**
	 * @param salutationName the salutationName to set
	 */
	public void setSalutationName(String salutationName) {
		this.salutationName = salutationName;
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
	 * @return the phStatusName
	 */
	public String getPhStatusName() {
		return phStatusName;
	}

	/**
	 * @param phStatusName the phStatusName to set
	 */
	public void setPhStatusName(String phStatusName) {
		this.phStatusName = phStatusName;
	}

	/**
	 * @return the phTypeName
	 */
	public String getPhTypeName() {
		return phTypeName;
	}

	/**
	 * @param phTypeName the phTypeName to set
	 */
	public void setPhTypeName(String phTypeName) {
		this.phTypeName = phTypeName;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	/**
	 * @return the changeType
	 */
	public long getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(long changeType) {
		this.changeType = changeType;
	}

	public int getEmpSrcType() {
		return empSrcType;
	}

	public void setEmpSrcType(int empSrcType) {
		this.empSrcType = empSrcType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(aadhaarNo, bloodGroup, buckleNo, caseNo, caste, category, dateOfBirth, dateOfMedFitnessCert,
				electionCardNo, emailID, empId, employeeCode, employeeMiddleName, employeeName, employeePhoto,
				employeeSurname, fatherName, gender, height, identificationMark, maritalStatus, mobileNo, motherName,
				nationality, officeId, otherPhCategory, panNo, passportExpiryDate, passportNo, phStatus, phType,
				photoAttachment, religion, remarks, salutation, statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeDto other = (PVUEmployeDto) obj;
		return aadhaarNo == other.aadhaarNo && bloodGroup == other.bloodGroup
				&& Objects.equals(buckleNo, other.buckleNo) && Objects.equals(caseNo, other.caseNo)
				&& Objects.equals(caste, other.caste) && category == other.category
				&& Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(dateOfMedFitnessCert, other.dateOfMedFitnessCert)
				&& Objects.equals(electionCardNo, other.electionCardNo) && Objects.equals(emailID, other.emailID)
				&& empId == other.empId && employeeCode == other.employeeCode
				&& Objects.equals(employeeMiddleName, other.employeeMiddleName)
				&& Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeePhoto, other.employeePhoto)
				&& Objects.equals(employeeSurname, other.employeeSurname)
				&& Objects.equals(fatherName, other.fatherName) && gender == other.gender
				&& Objects.equals(height, other.height) && Objects.equals(identificationMark, other.identificationMark)
				&& maritalStatus == other.maritalStatus && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(motherName, other.motherName) && nationality == other.nationality
				&& officeId == other.officeId && Objects.equals(otherPhCategory, other.otherPhCategory)
				&& Objects.equals(panNo, other.panNo) && Objects.equals(passportExpiryDate, other.passportExpiryDate)
				&& Objects.equals(passportNo, other.passportNo) && phStatus == other.phStatus && phType == other.phType
				&& Objects.equals(photoAttachment, other.photoAttachment) && Objects.equals(religion, other.religion)
				&& Objects.equals(remarks, other.remarks) && salutation == other.salutation
				&& statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeDto [empId=" + empId + ", officeId=" + officeId + ", caseNo=" + caseNo + ", employeeCode="
				+ employeeCode + ", salutation=" + salutation + ", employeeName=" + employeeName
				+ ", employeeMiddleName=" + employeeMiddleName + ", employeeSurname=" + employeeSurname + ", gender="
				+ gender + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + ", emailID=" + emailID
				+ ", mobileNo=" + mobileNo + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", maritalStatus=" + maritalStatus + ", category=" + category + ", religion=" + religion + ", caste="
				+ caste + ", bloodGroup=" + bloodGroup + ", phStatus=" + phStatus + ", phType=" + phType
				+ ", dateOfMedFitnessCert=" + dateOfMedFitnessCert + ", identificationMark=" + identificationMark
				+ ", height=" + height + ", electionCardNo=" + electionCardNo + ", aadhaarNo=" + aadhaarNo + ", panNo="
				+ panNo + ", passportNo=" + passportNo + ", passportExpiryDate=" + passportExpiryDate + ", buckleNo="
				+ buckleNo + ", employeePhoto=" + employeePhoto + ", remarks=" + remarks + ", statusId=" + statusId
				+ ", photoAttachment=" + photoAttachment + ", otherPhCategory=" + otherPhCategory + "]";
	}

}