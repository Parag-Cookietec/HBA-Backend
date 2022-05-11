package gov.ifms.pvu.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The Class PVUCommonResponse.
 */
public class PVUCommonResponse {

	/** The emp id. */
	private long empId;
	
	/** The employee no. */
	private Long employeeNo;
	
	/** The employee name. */
	private String employeeName;
	
	/** The class name. */
	private String className;
	
	/** The designation name. */
	private String designationName;
	
	/** The pay level name. */
	private String payLevelName;
	
	/** The cell id. */
	private String cellId;
	
	/** The basic pay. */
	private double basicPay;
	
	/** The date of joining. */
	private Date dateOfJoining;
	
	/** The date of retirement. */
	private Date dateOfRetirement;
	
	/** The office name. */
	private String officeName;
	
	/** The office name. */
	private String subOfficeName;
	
	/** The date of next increment. */
	private Date dateOfNextIncrement;
	
	/** The cardex no. */
	private long cardexNo;
	
	/** The ddo no. */
	private String ddoNo;
	
	/** The salutation. */
	private String salutation;
	
	/** The middel name. */
	private String middelName;
	
	/** The last name. */
	private String lastName;
	
	/** The gender. */
	private String gender;
	
	/** The email id. */
	private String emailId;
	
	/** The mobile no. */
	private String mobileNo;
	
	/** The pan no. */
	private String panNo;
	
	/** The district name. */
	private String districtName;
	
	/** The parent department. */
	private String parentDepartment;
	
	/** The head of department. */
	private String headOfDepartment;
	
	/** The office address. */
	private String officeAddress;
	
	/** The station. */
	private String station;
	
	/** The taluka. */
	private String taluka;

	/** The ccc exam detail. */
	private List<PVUEmployeCCCExamDetailDto> cccExamDetail;
	
	/** The dept exam details. */
	private List<PVUEmployeDeptExamDetailsDto> deptExamDetails;
	
	/** The lang exam. */
	private List<PVUEmployeLangExamDto> langExam;

	private long districtId;

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the new employee name
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designation name
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the new designation name
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the pay level name.
	 *
	 * @return the pay level name
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * Sets the pay level name.
	 *
	 * @param payLevelName the new pay level name
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cell id
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the new cell id
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basic pay
	 */
	public double getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the new basic pay
	 */
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the date of joining.
	 *
	 * @return the date of joining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Sets the date of joining.
	 *
	 * @param dateOfJoining the new date of joining
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the date of retirement.
	 *
	 * @return the date of retirement
	 */
	public Date getDateOfRetirement() {
		return dateOfRetirement;
	}

	/**
	 * Sets the date of retirement.
	 *
	 * @param dateOfRetirement the new date of retirement
	 */
	public void setDateOfRetirement(Date dateOfRetirement) {
		this.dateOfRetirement = dateOfRetirement;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the ccc exam detail.
	 *
	 * @return the ccc exam detail
	 */
	public List<PVUEmployeCCCExamDetailDto> getCccExamDetail() {
		return cccExamDetail;
	}

	/**
	 * Sets the ccc exam detail.
	 *
	 * @param cccExamDetail the new ccc exam detail
	 */
	public void setCccExamDetail(List<PVUEmployeCCCExamDetailDto> cccExamDetail) {
		this.cccExamDetail = cccExamDetail;
	}

	/**
	 * Gets the dept exam details.
	 *
	 * @return the dept exam details
	 */
	public List<PVUEmployeDeptExamDetailsDto> getDeptExamDetails() {
		return deptExamDetails;
	}

	/**
	 * Sets the dept exam details.
	 *
	 * @param deptExamDetails the new dept exam details
	 */
	public void setDeptExamDetails(List<PVUEmployeDeptExamDetailsDto> deptExamDetails) {
		this.deptExamDetails = deptExamDetails;
	}

	/**
	 * Gets the lang exam.
	 *
	 * @return the lang exam
	 */
	public List<PVUEmployeLangExamDto> getLangExam() {
		return langExam;
	}

	/**
	 * Sets the lang exam.
	 *
	 * @param langExam the new lang exam
	 */
	public void setLangExam(List<PVUEmployeLangExamDto> langExam) {
		this.langExam = langExam;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employee no
	 */
	public Long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the new employee no
	 */
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the salutation.
	 *
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * Sets the salutation.
	 *
	 * @param salutation the new salutation
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * Gets the middel name.
	 *
	 * @return the middel name
	 */
	public String getMiddelName() {
		return middelName;
	}

	/**
	 * Sets the middel name.
	 *
	 * @param middelName the new middel name
	 */
	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets the pan no.
	 *
	 * @return the pan no
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * Sets the pan no.
	 *
	 * @param panNo the new pan no
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the parent department.
	 *
	 * @return the parent department
	 */
	public String getParentDepartment() {
		return parentDepartment;
	}

	/**
	 * Sets the parent department.
	 *
	 * @param parentDepartment the new parent department
	 */
	public void setParentDepartment(String parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	/**
	 * Gets the head of department.
	 *
	 * @return the head of department
	 */
	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	/**
	 * Sets the head of department.
	 *
	 * @param headOfDepartment the new head of department
	 */
	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	/**
	 * Gets the office address.
	 *
	 * @return the office address
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * Sets the office address.
	 *
	 * @param officeAddress the new office address
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * Gets the station.
	 *
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * Sets the station.
	 *
	 * @param station the new station
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * Gets the taluka.
	 *
	 * @return the taluka
	 */
	public String getTaluka() {
		return taluka;
	}

	/**
	 * Sets the taluka.
	 *
	 * @param taluka the new taluka
	 */
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getSubOfficeName() {
		return subOfficeName;
	}

	public void setSubOfficeName(String subOfficeName) {
		this.subOfficeName = subOfficeName;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUCommonResponse)) return false;
		PVUCommonResponse that = (PVUCommonResponse) o;
		return getEmpId() == that.getEmpId() &&
				Double.compare(that.getBasicPay(), getBasicPay()) == 0 &&
				getCardexNo() == that.getCardexNo() &&
				getDistrictId() == that.getDistrictId() &&
				Objects.equals(getEmployeeNo(), that.getEmployeeNo()) &&
				Objects.equals(getEmployeeName(), that.getEmployeeName()) &&
				Objects.equals(getClassName(), that.getClassName()) &&
				Objects.equals(getDesignationName(), that.getDesignationName()) &&
				Objects.equals(getPayLevelName(), that.getPayLevelName()) &&
				Objects.equals(getCellId(), that.getCellId()) &&
				Objects.equals(getDateOfJoining(), that.getDateOfJoining()) &&
				Objects.equals(getDateOfRetirement(), that.getDateOfRetirement()) &&
				Objects.equals(getOfficeName(), that.getOfficeName()) &&
				Objects.equals(getSubOfficeName(), that.getSubOfficeName()) &&
				Objects.equals(getDateOfNextIncrement(), that.getDateOfNextIncrement()) &&
				Objects.equals(getDdoNo(), that.getDdoNo()) &&
				Objects.equals(getSalutation(), that.getSalutation()) &&
				Objects.equals(getMiddelName(), that.getMiddelName()) &&
				Objects.equals(getLastName(), that.getLastName()) &&
				Objects.equals(getGender(), that.getGender()) &&
				Objects.equals(getEmailId(), that.getEmailId()) &&
				Objects.equals(getMobileNo(), that.getMobileNo()) &&
				Objects.equals(getPanNo(), that.getPanNo()) &&
				Objects.equals(getDistrictName(), that.getDistrictName()) &&
				Objects.equals(getParentDepartment(), that.getParentDepartment()) &&
				Objects.equals(getHeadOfDepartment(), that.getHeadOfDepartment()) &&
				Objects.equals(getOfficeAddress(), that.getOfficeAddress()) &&
				Objects.equals(getStation(), that.getStation()) &&
				Objects.equals(getTaluka(), that.getTaluka()) &&
				Objects.equals(getCccExamDetail(), that.getCccExamDetail()) &&
				Objects.equals(getDeptExamDetails(), that.getDeptExamDetails()) &&
				Objects.equals(getLangExam(), that.getLangExam());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmpId(), getEmployeeNo(), getEmployeeName(), getClassName(), getDesignationName(), getPayLevelName(), getCellId(), getBasicPay(), getDateOfJoining(), getDateOfRetirement(), getOfficeName(), getSubOfficeName(), getDateOfNextIncrement(), getCardexNo(), getDdoNo(), getSalutation(), getMiddelName(), getLastName(), getGender(), getEmailId(), getMobileNo(), getPanNo(), getDistrictName(), getParentDepartment(), getHeadOfDepartment(), getOfficeAddress(), getStation(), getTaluka(), getCccExamDetail(), getDeptExamDetails(), getLangExam(), getDistrictId());
	}

	@Override
	public String toString() {
		return "PVUCommonResponse{" +
				"empId=" + empId +
				", employeeNo=" + employeeNo +
				", employeeName='" + employeeName + '\'' +
				", className='" + className + '\'' +
				", designationName='" + designationName + '\'' +
				", payLevelName='" + payLevelName + '\'' +
				", cellId='" + cellId + '\'' +
				", basicPay=" + basicPay +
				", dateOfJoining=" + dateOfJoining +
				", dateOfRetirement=" + dateOfRetirement +
				", officeName='" + officeName + '\'' +
				", subOfficeName='" + subOfficeName + '\'' +
				", dateOfNextIncrement=" + dateOfNextIncrement +
				", cardexNo=" + cardexNo +
				", ddoNo='" + ddoNo + '\'' +
				", salutation='" + salutation + '\'' +
				", middelName='" + middelName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", emailId='" + emailId + '\'' +
				", mobileNo='" + mobileNo + '\'' +
				", panNo='" + panNo + '\'' +
				", districtName='" + districtName + '\'' +
				", parentDepartment='" + parentDepartment + '\'' +
				", headOfDepartment='" + headOfDepartment + '\'' +
				", officeAddress='" + officeAddress + '\'' +
				", station='" + station + '\'' +
				", taluka='" + taluka + '\'' +
				", cccExamDetail=" + cccExamDetail +
				", deptExamDetails=" + deptExamDetails +
				", langExam=" + langExam +
				", districtId=" + districtId +
				'}';
	}
}
