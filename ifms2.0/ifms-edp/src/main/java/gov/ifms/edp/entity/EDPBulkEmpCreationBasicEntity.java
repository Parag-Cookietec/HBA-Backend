package gov.ifms.edp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "DUMMYEMPSTAGING2", schema = Constant.PVU_SCHEMA)
public class EDPBulkEmpCreationBasicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAGINGID")
	private Long stgId;

	@Column(name = "SALUTATION")
	private String saluation;

	@Column(name = "CASE_NO")
	private String caseNo;

	@Column(name = "CARDEXNO")
	private String cardexNo;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middelName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "PAN")
	private String pan;

	@Column(name = "MOBILENO")
	private Long mobileNo;

	@Column(name = "WORKFLOW1")
	private String workflow1;

	@Column(name = "WORKFLOW2")
	private String workflow2;

	@Column(name = "WORKFLOW3")
	private String workflow3;

	@Column(name = "DISTRICTNAME")
	private String districtName;

	@Column(name = "DDONO")
	private String ddoNo;


	@Column(name = "OFFICENAME")
	private String officeName;

	@Column(name = "ISPRIMARY")
	private String isPK;

	@Column(name = "EMPLOYEE_DETAILS")
	private String empDetails;
	@Column(name = "OFFICE_DETAILS")
	private String officeDetails;
	
	@Column(name = "ACTIVE_STATUS")
	private Long activeStatus;

	@Column(name = "IS_CREATE")
	private int isCreate;

	
	public EDPBulkEmpCreationBasicEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the stgId
	 */
	public Long getStgId() {
		return stgId;
	}

	/**
	 * @param stgId the stgId to set
	 */
	public void setStgId(Long stgId) {
		this.stgId = stgId;
	}

	/**
	 * @return the saluation
	 */
	public String getSaluation() {
		return saluation;
	}

	/**
	 * @param saluation the saluation to set
	 */
	public void setSaluation(String saluation) {
		this.saluation = saluation;
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
	 * @return the middelName
	 */
	public String getMiddelName() {
		return middelName;
	}

	/**
	 * @param middelName the middelName to set
	 */
	public void setMiddelName(String middelName) {
		this.middelName = middelName;
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
	 * @return the workflow1
	 */
	public String getWorkflow1() {
		return workflow1;
	}

	/**
	 * @param workflow1 the workflow1 to set
	 */
	public void setWorkflow1(String workflow1) {
		this.workflow1 = workflow1;
	}

	/**
	 * @return the workflow2
	 */
	public String getWorkflow2() {
		return workflow2;
	}

	/**
	 * @param workflow2 the workflow2 to set
	 */
	public void setWorkflow2(String workflow2) {
		this.workflow2 = workflow2;
	}

	/**
	 * @return the workflow3
	 */
	public String getWorkflow3() {
		return workflow3;
	}

	/**
	 * @param workflow3 the workflow3 to set
	 */
	public void setWorkflow3(String workflow3) {
		this.workflow3 = workflow3;
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
	 * @return the isPK
	 */
	public String getIsPK() {
		return isPK;
	}

	/**
	 * @param isPK the isPK to set
	 */
	public void setIsPK(String isPK) {
		this.isPK = isPK;
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
	 * @return the isCreate
	 */
	public int getIsCreate() {
		return isCreate;
	}

	/**
	 * @param isCreate the isCreate to set
	 */
	public void setIsCreate(int isCreate) {
		this.isCreate = isCreate;
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

}
