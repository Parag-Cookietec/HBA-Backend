package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "DUMMYEMPSTAGING2", schema = Constant.PVU_SCHEMA)
public class EDPBECBasicEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAGINGID")
	private Long id;
	@Column(name = "﻿SALUTATION")
	private String salutation;
	
	@Column(name = "ACTIVE_STATUS")
	private Long activeStatus;

	@Column(name = "CARDEXNO")
	private String cardexNo;

	@Column(name = "CASE_NO")
	private String caseNo;

	@Column(name = "DDONO")
	private String ddoNo;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "DISTRICTNAME")
	private String districtName;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "EMPLOYEE_DETAILS")
	private String empDetails;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "ISPRIMARY")
	private String isPrimary;

	@Column(name = "IS_CREATE")
	private Integer isCreate;

	@Column(name = "MOBILENO")
	private Long mobileNo;

	@Column(name = "OFFICENAME")
	private String officeName;

	@Column(name = "OFFICE_DETAILS")
	private String officeDetails;

	@Column(name = "PAN")
	private String pan;



	@Column(name = "WORKFLOW1")
	private String wf1;

	@Column(name = "WORKFLOW2")
	private String wf2;

	@Column(name = "WORKFLOW3")
	private String wf3;

	public EDPBECBasicEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the activeStatus
	 */
	public Long getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(Long activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @param caseNo the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
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
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the empDetails
	 */
	public String getEmpDetails() {
		return empDetails;
	}

	/**
	 * @param empDetails the empDetails to set
	 */
	public void setEmpDetails(String empDetails) {
		this.empDetails = empDetails;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the isPrimary
	 */
	public String getIsPrimary() {
		return isPrimary;
	}

	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	/**
	 * @return the isCreate
	 */
	public Integer getIsCreate() {
		return isCreate;
	}

	/**
	 * @param isCreate the isCreate to set
	 */
	public void setIsCreate(Integer isCreate) {
		this.isCreate = isCreate;
	}

	/**
	 * @return the mobileNo
	 */
	public Long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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
	 * @return the officeDetails
	 */
	public String getOfficeDetails() {
		return officeDetails;
	}

	/**
	 * @param officeDetails the officeDetails to set
	 */
	public void setOfficeDetails(String officeDetails) {
		this.officeDetails = officeDetails;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the wf1
	 */
	public String getWf1() {
		return wf1;
	}

	/**
	 * @param wf1 the wf1 to set
	 */
	public void setWf1(String wf1) {
		this.wf1 = wf1;
	}

	/**
	 * @return the wf2
	 */
	public String getWf2() {
		return wf2;
	}

	/**
	 * @param wf2 the wf2 to set
	 */
	public void setWf2(String wf2) {
		this.wf2 = wf2;
	}

	/**
	 * @return the wf3
	 */
	public String getWf3() {
		return wf3;
	}

	/**
	 * @param wf3 the wf3 to set
	 */
	public void setWf3(String wf3) {
		this.wf3 = wf3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, cardexNo, caseNo, ddoNo, designation, districtName, dob, empDetails,
				firstName, id, isCreate, isPrimary, lastName, middleName, mobileNo, officeDetails, officeName, pan,
				salutation, wf1, wf2, wf3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPBECBasicEntity)) {
			return false;
		}
		EDPBECBasicEntity other = (EDPBECBasicEntity) obj;
		return Objects.equals(activeStatus, other.activeStatus) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(caseNo, other.caseNo) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(designation, other.designation) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(dob, other.dob) && Objects.equals(empDetails, other.empDetails)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(isCreate, other.isCreate) && Objects.equals(isPrimary, other.isPrimary)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(officeDetails, other.officeDetails)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(pan, other.pan)
				&& Objects.equals(salutation, other.salutation) && Objects.equals(wf1, other.wf1)
				&& Objects.equals(wf2, other.wf2) && Objects.equals(wf3, other.wf3);
	}

	@Override
	public String toString() {
		return "EDPBECBasicEntity [id=" + id + ", activeStatus=" + activeStatus + ", cardexNo=" + cardexNo + ", caseNo="
				+ caseNo + ", ddoNo=" + ddoNo + ", designation=" + designation + ", districtName=" + districtName
				+ ", dob=" + dob + ", empDetails=" + empDetails + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", isPrimary=" + isPrimary + ", isCreate=" + isCreate
				+ ", mobileNo=" + mobileNo + ", officeName=" + officeName + ", officeDetails=" + officeDetails
				+ ", pan=" + pan + ", salutation=" + salutation + ", wf1=" + wf1 + ", wf2=" + wf2 + ", wf3=" + wf3
				+ "]";
	}

//	public EDPBECBasicEntity(String districtName, String ddoNo, String cardexNo, String officeName, String salutation,
//			String firstName, String middleName, String lastName, String designation, String dob, String pan,
//			Long mobileNo, String caseNo, String wf1, String wf2, String wf3) {
//		this.districtName = districtName;
//		this.ddoNo = ddoNo;
//		this.cardexNo = cardexNo;
//		this.officeName = officeName;
//		this.salutation = salutation;
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.designation = designation;
//		this.dob = dob;
//		this.pan = pan;
//		this.mobileNo = mobileNo;
//		this.caseNo = caseNo;
//		// TODO Auto-generated constructor stub
//	}

	


}
