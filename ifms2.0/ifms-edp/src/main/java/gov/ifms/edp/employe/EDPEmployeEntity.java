package gov.ifms.edp.employe;

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
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class EDPEmployeEntity.
 */
@Entity
@Table(name = "MS_EMPLOYEE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPEmployeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private Long empId;

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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GENDER", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity gender;

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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MARITAL_STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity maritalStatus;

	/** The category. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CATEGORY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity category;

	/** The religion. */
	@Column(name = "RELIGION")
	private String religion;

	/** The caste. */
	@Column(name = "CASTE")
	private String caste;

	/** The blood group. */
	@Column(name = "BLOOD_GROUP")
	private Long bloodGroup;

	/** The ph status. */

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DIVYANG_JT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity phStatus;

	/** The ph type. */
	@Column(name = "DIVYANG_SUB_CAT")
	private Long phType;

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

	@Column(name = "EMP_PHOTO_NAME")
	private String employeePhotoName;

	public String getEmployeePhotoName() {
		return employeePhotoName;
	}

	public void setEmployeePhotoName(String employeePhotoName) {
		this.employeePhotoName = employeePhotoName;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
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
	public Long getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group.
	 *
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(Long bloodGroup) {
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
	public Long getPhType() {
		return phType;
	}

	/**
	 * Sets the ph type.
	 *
	 * @param phType the phType to set
	 */
	public void setPhType(Long phType) {
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
	 * PVUEmployeeEntity Constructor.
	 */
	public EDPEmployeEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU employe entity.
	 *
	 * @param empId the emp id
	 */
	public EDPEmployeEntity(Long empId) {
		super();
		this.empId = empId;
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
				officeId, panNo, passportExpiryDate, passportNo, phStatus, phType, religion, remarks, salutation,
				statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPEmployeEntity)) {
			return false;
		}
		EDPEmployeEntity other = (EDPEmployeEntity) obj;
		return Objects.equals(aadhaarNo, other.aadhaarNo) && Objects.equals(bloodGroup, other.bloodGroup)
				&& Objects.equals(buckleNo, other.buckleNo) && Objects.equals(caseNo, other.caseNo)
				&& Objects.equals(caste, other.caste) && Objects.equals(category, other.category)
				&& Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(dateOfMedFitnessCert, other.dateOfMedFitnessCert)
				&& Objects.equals(electionCardNo, other.electionCardNo) && Objects.equals(emailID, other.emailID)
				&& Objects.equals(empId, other.empId) && Objects.equals(employeeCode, other.employeeCode)
				&& Objects.equals(employeeMiddleName, other.employeeMiddleName)
				&& Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeePhoto, other.employeePhoto)
				&& Objects.equals(employeeSurname, other.employeeSurname)
				&& Objects.equals(fatherName, other.fatherName) && Objects.equals(gender, other.gender)
				&& Objects.equals(height, other.height) && Objects.equals(identificationMark, other.identificationMark)
				&& Objects.equals(maritalStatus, other.maritalStatus) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(motherName, other.motherName) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(panNo, other.panNo) && Objects.equals(passportExpiryDate, other.passportExpiryDate)
				&& Objects.equals(passportNo, other.passportNo) && Objects.equals(phStatus, other.phStatus)
				&& Objects.equals(phType, other.phType) && Objects.equals(religion, other.religion)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(salutation, other.salutation)
				&& Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeEntity [empId=" + empId + ", officeId=" + officeId + ", caseNo=" + caseNo + ", employeeCode="
				+ employeeCode + ", salutation=" + salutation + ", employeeName=" + employeeName
				+ ", employeeMiddleName=" + employeeMiddleName + ", employeeSurname=" + employeeSurname + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", emailID=" + emailID + ", mobileNo=" + mobileNo
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", maritalStatus=" + maritalStatus
				+ ", category=" + category + ", religion=" + religion + ", caste=" + caste + ", bloodGroup="
				+ bloodGroup + ", phStatus=" + phStatus + ", phType=" + phType + ", dateOfMedFitnessCert="
				+ dateOfMedFitnessCert + ", identificationMark=" + identificationMark + ", height=" + height
				+ ", electionCardNo=" + electionCardNo + ", aadhaarNo=" + aadhaarNo + ", panNo=" + panNo
				+ ", passportNo=" + passportNo + ", passportExpiryDate=" + passportExpiryDate + ", buckleNo=" + buckleNo
				+ ", employeePhoto=" + employeePhoto + ", remarks=" + remarks + ", statusId=" + statusId + "]";
	}

}
