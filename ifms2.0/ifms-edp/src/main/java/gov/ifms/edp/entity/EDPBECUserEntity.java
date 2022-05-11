package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.util.OAuthUtility;

@Entity
@Table(name = "DUMMYEMPSTAGINGMAIN2", schema = Constant.PVU_SCHEMA)
public class EDPBECUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAGINGMAINID")
	private Long id;

	@Column(name = "DISTRICTNAME")
	private String districtName;

	@Column(name = "DISTRICTID")
	private Integer districtId;

	@Column(name = "DDONO")
	private String ddoNo;

	@Column(name = "CARDEXNO")
	private String cardexNo;

	@Column(name = "OFFICENAME")
	private String officeName;

	@Column(name = "OFFICEID")
	private Integer officeId;

	@Column(name = "SALUTATION")
	private String salutation;

	@Column(name = "SALUTATIONID")
	private Integer salutationId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DESIGNATIONID")
	private Integer designationId;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "PAN")
	private String pan;

	@Column(name = "MOBILENO")
	private Long mobileNo;

	@Column(name = "CASE_NO")
	private String caseNo;

	@Column(name = "ACTIVE_STATUS")
	private Long activeStatus;

	@Column(name = "EMPLOYEENO")
	private Long empNo;

	@Column(name = "EMPLOYEEID")
	private Long empId;

	@Column(name = "ISPRIMARY")
	private String isPrimary;

	@Column(name = "ISPRIMARYID")
	private Integer isPrimaryID;

	@Column(name = "IS_CREATE")
	private boolean isCreate;

	@Column(name = "WORKFLOW1")
	private String wf1;

	@Column(name = "WORKFLOW2")
	private String wf2;

	@Column(name = "WORKFLOW3")
	private String wf3;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "UPDATEDBYID", updatable = false)
	private Long updatedById;

	@Column(name = "UPDATEDBYPOSTID", updatable = false)
	private Long updatedByPostId;

	@Column(name = "CREATEDBYID", updatable = false)
	private Long createdById;

	@Column(name = "CREATEDBYPOSTID", updatable = false)
	private Long createdByPostId;

	public EDPBECUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public EDPBECUserEntity(String districtName, String ddoNo, String cardexNo, String officeName, String salutation,
			String firstName, String middleName, String lastName, String designation, String dob, String pan,
			Long mobileNo, String caseNo) {
		super();
		this.districtName = districtName;
		this.ddoNo = ddoNo;
		this.cardexNo = cardexNo;
		this.officeName = officeName;
		this.salutation = salutation;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.dob = dob;
		this.pan = pan;
		this.mobileNo = mobileNo;
		this.caseNo = caseNo;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the districtId
	 */
	public Integer getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
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
	 * @return the officeId
	 */
	public Integer getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
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
	 * @return the salutationId
	 */
	public Integer getSalutationId() {
		return salutationId;
	}

	/**
	 * @param salutationId the salutationId to set
	 */
	public void setSalutationId(Integer salutationId) {
		this.salutationId = salutationId;
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
	 * @return the designationId
	 */
	public Integer getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
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
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
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
	 * @return the isPrimaryID
	 */
	public Integer getIsPrimaryID() {
		return isPrimaryID;
	}

	/**
	 * @param isPrimaryID the isPrimaryID to set
	 */
	public void setIsPrimaryID(Integer isPrimaryID) {
		this.isPrimaryID = isPrimaryID;
	}

	/**
	 * @return the isCreate
	 */
	public boolean isCreate() {
		return isCreate;
	}

	/**
	 * @param isCreate the isCreate to set
	 */
	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
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

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the updatedById
	 */
	public Long getUpdatedById() {
		return updatedById;
	}

	/**
	 * @param updatedById the updatedById to set
	 */
	public void setUpdatedById(Long updatedById) {
		this.updatedById = updatedById;
	}

	/**
	 * @return the updatedByPostId
	 */
	public Long getUpdatedByPostId() {
		return updatedByPostId;
	}

	/**
	 * @param updatedByPostId the updatedByPostId to set
	 */
	public void setUpdatedByPostId(Long updatedByPostId) {
		this.updatedByPostId = updatedByPostId;
	}

	/**
	 * @return the createdById
	 */
	public Long getCreatedById() {
		return createdById;
	}

	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	/**
	 * @return the createdByPostId
	 */
	public Long getCreatedByPostId() {
		return createdByPostId;
	}

	/**
	 * @param createdByPostId the createdByPostId to set
	 */
	public void setCreatedByPostId(Long createdByPostId) {
		this.createdByPostId = createdByPostId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, cardexNo, caseNo, createdById, createdByPostId, ddoNo, designation,
				designationId, districtId, districtName, dob, empId, empNo, firstName, id, isCreate, isPrimary,
				isPrimaryID, lastName, middleName, mobileNo, officeId, officeName, pan, remarks, salutation,
				salutationId, updatedById, updatedByPostId, wf1, wf2, wf3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPBECUserEntity)) {
			return false;
		}
		EDPBECUserEntity other = (EDPBECUserEntity) obj;
		return Objects.equals(activeStatus, other.activeStatus) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(caseNo, other.caseNo) && Objects.equals(createdById, other.createdById)
				&& Objects.equals(createdByPostId, other.createdByPostId) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(designation, other.designation) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(dob, other.dob) && Objects.equals(empId, other.empId)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && isCreate == other.isCreate
				&& Objects.equals(isPrimary, other.isPrimary) && Objects.equals(isPrimaryID, other.isPrimaryID)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(pan, other.pan)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(salutation, other.salutation)
				&& Objects.equals(salutationId, other.salutationId) && Objects.equals(updatedById, other.updatedById)
				&& Objects.equals(updatedByPostId, other.updatedByPostId) && Objects.equals(wf1, other.wf1)
				&& Objects.equals(wf2, other.wf2) && Objects.equals(wf3, other.wf3);
	}

	@Override
	public String toString() {
		return "EDPBECUserEntity [id=" + id + ", districtName=" + districtName + ", districtId=" + districtId
				+ ", ddoNo=" + ddoNo + ", cardexNo=" + cardexNo + ", officeName=" + officeName + ", officeId="
				+ officeId + ", salutation=" + salutation + ", salutationId=" + salutationId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", designationId="
				+ designationId + ", designation=" + designation + ", dob=" + dob + ", pan=" + pan + ", mobileNo="
				+ mobileNo + ", caseNo=" + caseNo + ", activeStatus=" + activeStatus + ", empNo=" + empNo + ", empId="
				+ empId + ", isPrimary=" + isPrimary + ", isPrimaryID=" + isPrimaryID + ", isCreate=" + isCreate
				+ ", wf1=" + wf1 + ", wf2=" + wf2 + ", wf3=" + wf3 + ", remarks=" + remarks + ", updatedById="
				+ updatedById + ", updatedByPostId=" + updatedByPostId + ", createdById=" + createdById
				+ ", createdByPostId=" + createdByPostId + "]";
	}

	/**
	 * Before create.
	 */
	@PrePersist
	private void beforeCreate() {
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		this.activeStatus = 1L;
		// this.createdDate = new Date();
		// this.updatedDate = new Date();
		this.createdById = OAuthUtility.getCurrentUserUserId();
		this.updatedById = OAuthUtility.getCurrentUserUserId();
		this.createdByPostId = dDPMsPostDto.getPostId();
		this.updatedByPostId = OAuthUtility.getCurrentUserLkPOUId();

	}

	/**
	 * On update.
	 */
	@PreUpdate
	private void onUpdate() {
		try {
			// this.updatedDate = new Date();
			this.updatedById = OAuthUtility.getCurrentUserUserId();
			this.updatedByPostId = OAuthUtility.getCurrentUserLkPOUId();
		} catch (Exception e) {
			// this.updatedDate = new Date();
			this.updatedById = 0l;
			this.updatedByPostId = 0l;
		}

	}

}
