package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUEmployeEntity.
 *
 * @version v 1.0
 * @created 2019/11/22 01:17:36
 *
 */
@Entity
@Table(name = "MS_EMPLOYEE", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUEmployeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private long empId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The case no. */
	@Column(name = "CASE_NO")
	private String caseNo;

	/** The employee code. */
	@Column(name = "EMPLOYEE_NO")
	private Long employeeCode;

	/** The salutation. */
	@OneToOne
	@JoinColumn(name = "SALUTATION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity salutation;

	/** The employee name. */
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	/** The employee middle name. */
	@Column(name = "MIDDLE_GUARDIAN_NAME")
	private String employeeMiddleName;

	/** The employee surname. */
	@Column(name = "SURNAME")
	private String employeeSurname;

	/** The gender. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENDER", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity gender;

	/** The nationality. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NATIONALITY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity nationality;

	/** The date of birth. */
	@Column(name = "DOB")
	private Date dateOfBirth;

	/** The email ID. */
	@Column(name = "EMAIL_ID")
	private String emailID;

	/** The mobile no. */
	@Column(name = "MOBILE_NO")
	private String mobileNo;

	/** The father name. */
	@Column(name = "FATHER_NAME")
	private String fatherName;

	/** The mother name. */
	@Column(name = "MOTHER_NAME")
	private String motherName;

	/** The marital status. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MARITAL_STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity maritalStatus;

	/** The category. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CATEGORY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity category;

	/** The religion. */
	@Column(name = "RELIGION")
	private String religion;

	/** The caste. */
	@Column(name = "CASTE")
	private String caste;

	/** The blood group. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BLOOD_GROUP", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity bloodGroup;

	/** The ph status. */

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DIVYANG_JT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity phStatus;

	/** The ph type. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVYANG_SUB_CAT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity phType;

	/** The date of med fitness cert. */
	@Column(name = "MED_FIT_CERT_DATE")
	private Date dateOfMedFitnessCert;

	/** The identification mark. */
	@Column(name = "ID_MARK")
	private String identificationMark;

	/** The height. */
	@Column(name = "HEIGHT_CM")
	private Integer height;

	/** The election card no. */
	@Column(name = "ELECTION_CARD_NO")
	private String electionCardNo;

	/** The aadhaar no. */
	@Column(name = "AADHAR_NO")
	private Long aadhaarNo;

	/** The pan no. */
	@Column(name = "PAN_NO")
	private String panNo;

	/** The passport no. */
	@Column(name = "PASSPORT_NO")
	private String passportNo;

	/** The passport expiry date. */
	@Column(name = "PASSPORT_EXP_DATE")
	private Date passportExpiryDate;

	/** The buckle no. */
	@Column(name = "BUCKLE_NO")
	private String buckleNo;

	/** The employee photo. */
	@Column(name = "EMPLOYEE_PHOTO")
	private String employeePhoto;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;
	
	@Column(name = "OTHER_PH_CATEGORY")
	private String otherPhCategory;
	
	/** The employee photo. */
	@Column(name = "EMP_PHOTO_NAME")
	private String employeePhotoName;
	
	@Column(name = "CHANGE_TYPE")
	private long changeType;

	/** The employee photo. */
	@Column(name = "OFFICE_NAME")
	private String officeName;

	/** The employee photo. */
	@Column(name = "EMP_SRC_TYPE")
	private int empSrcType;
	
	
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
		this.employeeName = employeeName;
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
		this.employeeMiddleName = employeeMiddleName;
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
		this.employeeSurname = employeeSurname;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
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
		this.fatherName = fatherName;
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
		this.motherName = motherName;
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
	 * Gets the date of med fitness cert.
	 *
	 * @return the dateOfMedFitnessCert
	 */
	public Date getDateOfMedFitnessCert() {
		return dateOfMedFitnessCert;
	}

	/**
	 * Sets the date of med fitness cert.
	 *
	 * @param dateOfMedFitnessCert the dateOfMedFitnessCert to set
	 */
	public void setDateOfMedFitnessCert(Date dateOfMedFitnessCert) {
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
		this.panNo = panNo;
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
	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}

	/**
	 * Sets the passport expiry date.
	 *
	 * @param passportExpiryDate the passportExpiryDate to set
	 */
	public void setPassportExpiryDate(Date passportExpiryDate) {
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
	 * Gets the salutation.
	 *
	 * @return the salutation
	 */
	public EDPLuLookUpInfoEntity getSalutation() {
		return salutation;
	}

	/**
	 * Sets the salutation.
	 *
	 * @param salutation the salutation to set
	 */
	public void setSalutation(EDPLuLookUpInfoEntity salutation) {
		this.salutation = salutation;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public EDPLuLookUpInfoEntity getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the gender to set
	 */
	public void setGender(EDPLuLookUpInfoEntity gender) {
		this.gender = gender;
	}

	/**
	 * Gets the marital status.
	 *
	 * @return the maritalStatus
	 */
	public EDPLuLookUpInfoEntity getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(EDPLuLookUpInfoEntity maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public EDPLuLookUpInfoEntity getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the category to set
	 */
	public void setCategory(EDPLuLookUpInfoEntity category) {
		this.category = category;
	}

	/**
	 * Gets the blood group.
	 *
	 * @return the bloodGroup
	 */
	public EDPLuLookUpInfoEntity getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group.
	 *
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(EDPLuLookUpInfoEntity bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Gets the ph status.
	 *
	 * @return the phStatus
	 */
	public EDPLuLookUpInfoEntity getPhStatus() {
		return phStatus;
	}

	/**
	 * Sets the ph status.
	 *
	 * @param phStatus the phStatus to set
	 */
	public void setPhStatus(EDPLuLookUpInfoEntity phStatus) {
		this.phStatus = phStatus;
	}

	/**
	 * Gets the ph type.
	 *
	 * @return the phType
	 */
	public EDPLuLookUpInfoEntity getPhType() {
		return phType;
	}

	/**
	 * Sets the ph type.
	 *
	 * @param phType the phType to set
	 */
	public void setPhType(EDPLuLookUpInfoEntity phType) {
		this.phType = phType;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the nationality.
	 *
	 * @return the nationality
	 */
	public EDPLuLookUpInfoEntity getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 *
	 * @param nationality the nationality to set
	 */
	public void setNationality(EDPLuLookUpInfoEntity nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the otherPhCategory
	 */
	public String getOtherPhCategory() {
		return otherPhCategory;
	}

	/**
	 * @param otherPhCategory the otherPhCategory to set
	 */
	public void setOtherPhCategory(String otherPhCategory) {
		this.otherPhCategory = otherPhCategory;
	}

	/**
	 * @return the employeePhotoName
	 */
	public String getEmployeePhotoName() {
		return employeePhotoName;
	}

	/**
	 * @param employeePhotoName the employeePhotoName to set
	 */
	public void setEmployeePhotoName(String employeePhotoName) {
		this.employeePhotoName = employeePhotoName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public int getEmpSrcType() {
		return empSrcType;
	}

	public void setEmpSrcType(int empSrcType) {
		this.empSrcType = empSrcType;
	}

	/**
	 * PVUEmployeeEntity Constructor.
	 */
	public PVUEmployeEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU employe entity.
	 *
	 * @param empId the emp id
	 */
	public PVUEmployeEntity(long empId) {
		super();
		this.empId = empId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUEmployeEntity that = (PVUEmployeEntity) o;
		return empId == that.empId && changeType == that.changeType && empSrcType == that.empSrcType && Objects.equals(officeId, that.officeId) && Objects.equals(caseNo, that.caseNo) && Objects.equals(employeeCode, that.employeeCode) && Objects.equals(salutation, that.salutation) && Objects.equals(employeeName, that.employeeName) && Objects.equals(employeeMiddleName, that.employeeMiddleName) && Objects.equals(employeeSurname, that.employeeSurname) && Objects.equals(gender, that.gender) && Objects.equals(nationality, that.nationality) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(emailID, that.emailID) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(fatherName, that.fatherName) && Objects.equals(motherName, that.motherName) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(category, that.category) && Objects.equals(religion, that.religion) && Objects.equals(caste, that.caste) && Objects.equals(bloodGroup, that.bloodGroup) && Objects.equals(phStatus, that.phStatus) && Objects.equals(phType, that.phType) && Objects.equals(dateOfMedFitnessCert, that.dateOfMedFitnessCert) && Objects.equals(identificationMark, that.identificationMark) && Objects.equals(height, that.height) && Objects.equals(electionCardNo, that.electionCardNo) && Objects.equals(aadhaarNo, that.aadhaarNo) && Objects.equals(panNo, that.panNo) && Objects.equals(passportNo, that.passportNo) && Objects.equals(passportExpiryDate, that.passportExpiryDate) && Objects.equals(buckleNo, that.buckleNo) && Objects.equals(employeePhoto, that.employeePhoto) && Objects.equals(remarks, that.remarks) && Objects.equals(statusId, that.statusId) && Objects.equals(otherPhCategory, that.otherPhCategory) && Objects.equals(employeePhotoName, that.employeePhotoName) && Objects.equals(officeName, that.officeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, officeId, caseNo, employeeCode, salutation, employeeName, employeeMiddleName, employeeSurname, gender, nationality, dateOfBirth, emailID, mobileNo, fatherName, motherName, maritalStatus, category, religion, caste, bloodGroup, phStatus, phType, dateOfMedFitnessCert, identificationMark, height, electionCardNo, aadhaarNo, panNo, passportNo, passportExpiryDate, buckleNo, employeePhoto, remarks, statusId, otherPhCategory, employeePhotoName, changeType, officeName, empSrcType);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PVUEmployeEntity{");
		sb.append("empId=").append(empId);
		sb.append(", officeId=").append(officeId);
		sb.append(", caseNo='").append(caseNo).append('\'');
		sb.append(", employeeCode=").append(employeeCode);
		sb.append(", salutation=").append(salutation);
		sb.append(", employeeName='").append(employeeName).append('\'');
		sb.append(", employeeMiddleName='").append(employeeMiddleName).append('\'');
		sb.append(", employeeSurname='").append(employeeSurname).append('\'');
		sb.append(", gender=").append(gender);
		sb.append(", nationality=").append(nationality);
		sb.append(", dateOfBirth=").append(dateOfBirth);
		sb.append(", emailID='").append(emailID).append('\'');
		sb.append(", mobileNo='").append(mobileNo).append('\'');
		sb.append(", fatherName='").append(fatherName).append('\'');
		sb.append(", motherName='").append(motherName).append('\'');
		sb.append(", maritalStatus=").append(maritalStatus);
		sb.append(", category=").append(category);
		sb.append(", religion='").append(religion).append('\'');
		sb.append(", caste='").append(caste).append('\'');
		sb.append(", bloodGroup=").append(bloodGroup);
		sb.append(", phStatus=").append(phStatus);
		sb.append(", phType=").append(phType);
		sb.append(", dateOfMedFitnessCert=").append(dateOfMedFitnessCert);
		sb.append(", identificationMark='").append(identificationMark).append('\'');
		sb.append(", height=").append(height);
		sb.append(", electionCardNo='").append(electionCardNo).append('\'');
		sb.append(", aadhaarNo=").append(aadhaarNo);
		sb.append(", panNo='").append(panNo).append('\'');
		sb.append(", passportNo='").append(passportNo).append('\'');
		sb.append(", passportExpiryDate=").append(passportExpiryDate);
		sb.append(", buckleNo='").append(buckleNo).append('\'');
		sb.append(", employeePhoto='").append(employeePhoto).append('\'');
		sb.append(", remarks='").append(remarks).append('\'');
		sb.append(", statusId=").append(statusId);
		sb.append(", otherPhCategory='").append(otherPhCategory).append('\'');
		sb.append(", employeePhotoName='").append(employeePhotoName).append('\'');
		sb.append(", changeType=").append(changeType);
		sb.append(", officeName='").append(officeName).append('\'');
		sb.append(", empSrcType=").append(empSrcType);
		sb.append('}');
		return sb.toString();
	}
}
