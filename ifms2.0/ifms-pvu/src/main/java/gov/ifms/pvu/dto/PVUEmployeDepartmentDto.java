package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeDepartmentDto.
 *
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 */
public class PVUEmployeDepartmentDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	private long departmentId;

	/** The date of joining GOG. */
	@NotNull
	private Date dateOfJoiningGOG;

	/** The date of retirement. */
	@NotNull
	private Date dateOfRetirement;

	/** The emp status. */
	private long empStatus;
	private String empStatusName;

	/** The emp type. */
	private long empType;
	private String empTypeName;

	/** The designation id. */
	private long designationId;
	private String designationName;

	/** The district id. */
	@NotBlank
	private long districtId;
	private String districtName;

	/** The present office. */
	@NotBlank
	private long presentOffice;
	private String presentOfficeName;

	/** The sub office. */
	private long subOffice;
	private String subOfficeName;

	/** The emp class. */
	@NotBlank
	/** The emp class. */
	private long empClass;
	private String empClassName;

	/** The departmental category. */
	private long departmentalCategory;
	private String departmentalCategoryName;

	/** The station. */
	@NotNull
	private String station;

	/** The taluka. */
	@NotBlank
	private long taluka;
	private String talukaName;

	/** The gpf no. */

	@NotNull
	private String gpfNo;

	/** The pran acc no. */
	private String pranAccNo;

	/** The ppo no. */
	private String ppoNo;

	/** The death termination date. */
	private Date deathTerminationDate;

	/** The ppan no. */
	@NotNull
	private String ppanNo;

	/** The cardex no. */
	@NotNull
	private String cardexNo;

	/** The Pay commission joining time. */
	private long payCommissionJoiningTime;
	private String payCommissionJoiningTimeName;

	/** The emp pay type. */
	private long empPayType;
	private String empPayTypeName;

	/** The office add num. */
	private String officeAddNum;

	/** The ddo code. */
	@NotBlank
	private String ddoCode;

	/** The ddo code. */
	private long parentHeadDeptId;
	private String parentHeadDeptName;

	/** The ddo code. */
	private long hodNameId;
	private String hodName;

	/** The is NPA. */
	private long isNPA = 1;
	private String isNPAName;

	/** The emp pay type. */
	private long deputation;
	private String empDeputationName;

	private long deputDistrictId;

	private String deputDdoCode;

	private String deputCardexNo;

	private long deputOfficeId;
	private String deputOfficeName;

	private Date fixPayDate;

	private String deputDistrictName;
	
	private Long joinEmpPayType;
	private String joinEmpPayTypeName;

	/**
	 * Gets the parent head dept id.
	 *
	 * @return the parent head dept id
	 */
	public long getParentHeadDeptId() {
		return parentHeadDeptId;
	}

	/**
	 * Sets the parent head dept id.
	 *
	 * @param parentHeadDeptId the new parent head dept id
	 */
	public void setParentHeadDeptId(long parentHeadDeptId) {
		this.parentHeadDeptId = parentHeadDeptId;
	}

	/**
	 * Gets the hod name id.
	 *
	 * @return the hod name id
	 */
	public long getHodNameId() {
		return hodNameId;
	}

	/**
	 * Sets the hod name id.
	 *
	 * @param hodNameId the new hod name id
	 */
	public void setHodNameId(long hodNameId) {
		this.hodNameId = hodNameId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/** The status id. */
	private long statusId;

	/** The emp id. */
	private long empId;

	/** The is suspended. */
	private boolean isSuspended;

	/** The deputation end date. */
	private Date deputationEndDate;

	/**
	 * Checks if is suspended.
	 *
	 * @return true, if is suspended
	 */
	public boolean isSuspended() {
		return isSuspended;
	}

	/**
	 * Sets the suspended.
	 *
	 * @param suspended the new suspended
	 */
	public void setSuspended(boolean suspended) {
		isSuspended = suspended;
	}

	/** The deputation start date. */
	private Date deputationStartDate;

	/**
	 * Gets the deputation end date.
	 *
	 * @return the deputation end date
	 */
	public Date getDeputationEndDate() {
		return deputationEndDate;
	}

	/**
	 * Sets the deputation end date.
	 *
	 * @param deputationEndDate the new deputation end date
	 */
	public void setDeputationEndDate(Date deputationEndDate) {
		this.deputationEndDate = deputationEndDate;
	}

	/**
	 * Gets the deputation start date.
	 *
	 * @return the deputation start date
	 */
	public Date getDeputationStartDate() {
		return deputationStartDate;
	}

	/**
	 * Sets the deputation start date.
	 *
	 * @param deputationStartDate the new deputation start date
	 */
	public void setDeputationStartDate(Date deputationStartDate) {
		this.deputationStartDate = deputationStartDate;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the date of joining GOG.
	 *
	 * @return the dateOfJoiningGOG
	 */
	public Date getDateOfJoiningGOG() {
		return dateOfJoiningGOG;
	}

	/**
	 * Sets the date of joining GOG.
	 *
	 * @param dateOfJoiningGOG the dateOfJoiningGOG to set
	 */
	public void setDateOfJoiningGOG(Date dateOfJoiningGOG) {
		this.dateOfJoiningGOG = dateOfJoiningGOG;
	}

	/**
	 * Gets the date of retirement.
	 *
	 * @return the dateOfRetirement
	 */
	public Date getDateOfRetirement() {
		return dateOfRetirement;
	}

	/**
	 * Sets the date of retirement.
	 *
	 * @param dateOfRetirement the dateOfRetirement to set
	 */
	public void setDateOfRetirement(Date dateOfRetirement) {
		this.dateOfRetirement = dateOfRetirement;
	}

	/**
	 * Gets the emp status.
	 *
	 * @return the empStatus
	 */
	public long getEmpStatus() {
		return empStatus;
	}

	/**
	 * Sets the emp status.
	 *
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public long getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(long empType) {
		this.empType = empType;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the present office.
	 *
	 * @return the presentOffice
	 */
	public long getPresentOffice() {
		return presentOffice;
	}

	/**
	 * Sets the present office.
	 *
	 * @param presentOffice the presentOffice to set
	 */
	public void setPresentOffice(long presentOffice) {
		this.presentOffice = presentOffice;
	}

	/**
	 * Gets the sub office.
	 *
	 * @return the subOffice
	 */
	public long getSubOffice() {
		return subOffice;
	}

	/**
	 * Sets the sub office.
	 *
	 * @param subOffice the subOffice to set
	 */
	public void setSubOffice(long subOffice) {
		this.subOffice = subOffice;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the empClass
	 */
	public long getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(long empClass) {
		this.empClass = empClass;
	}

	/**
	 * Gets the departmental category.
	 *
	 * @return the departmentalCategory
	 */
	public long getDepartmentalCategory() {
		return departmentalCategory;
	}

	/**
	 * Sets the departmental category.
	 *
	 * @param departmentalCategory the departmentalCategory to set
	 */
	public void setDepartmentalCategory(long departmentalCategory) {
		this.departmentalCategory = departmentalCategory;
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
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * Gets the taluka.
	 *
	 * @return the taluka
	 */
	public long getTaluka() {
		return taluka;
	}

	/**
	 * Sets the taluka.
	 *
	 * @param taluka the taluka to set
	 */
	public void setTaluka(long taluka) {
		this.taluka = taluka;
	}

	/**
	 * Gets the gpf no.
	 *
	 * @return the gpfNo
	 */
	public String getGpfNo() {
		return gpfNo;
	}

	/**
	 * Sets the gpf no.
	 *
	 * @param gpfNo the gpfNo to set
	 */
	public void setGpfNo(String gpfNo) {
		this.gpfNo = gpfNo;
	}

	/**
	 * Gets the pran acc no.
	 *
	 * @return the pranAccNo
	 */
	public String getPranAccNo() {
		return pranAccNo;
	}

	/**
	 * Sets the pran acc no.
	 *
	 * @param pranAccNo the pranAccNo to set
	 */
	public void setPranAccNo(String pranAccNo) {
		this.pranAccNo = pranAccNo;
	}

	/**
	 * Gets the ppo no.
	 *
	 * @return the ppoNo
	 */
	public String getPpoNo() {
		return ppoNo;
	}

	/**
	 * Sets the ppo no.
	 *
	 * @param ppoNo the ppoNo to set
	 */
	public void setPpoNo(String ppoNo) {
		this.ppoNo = ppoNo;
	}

	/**
	 * Gets the death termination date.
	 *
	 * @return the deathTerminationDate
	 */
	public Date getDeathTerminationDate() {
		return deathTerminationDate;
	}

	/**
	 * Sets the death termination date.
	 *
	 * @param deathTerminationDate the deathTerminationDate to set
	 */
	public void setDeathTerminationDate(Date deathTerminationDate) {
		this.deathTerminationDate = deathTerminationDate;
	}

	/**
	 * Gets the ppan no.
	 *
	 * @return the ppanNo
	 */
	public String getPpanNo() {
		return ppanNo;
	}

	/**
	 * Sets the ppan no.
	 *
	 * @param ppanNo the ppanNo to set
	 */
	public void setPpanNo(String ppanNo) {
		this.ppanNo = ppanNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the pay commission joining time.
	 *
	 * @return the payCommissionJoiningTime
	 */
	public long getPayCommissionJoiningTime() {
		return payCommissionJoiningTime;
	}

	/**
	 * Sets the pay commission joining time.
	 *
	 * @param payCommissionJoiningTime the payCommissionJoiningTime to set
	 */
	public void setPayCommissionJoiningTime(long payCommissionJoiningTime) {
		this.payCommissionJoiningTime = payCommissionJoiningTime;
	}

	/**
	 * Gets the emp pay type.
	 *
	 * @return the empPayType
	 */
	public long getEmpPayType() {
		return empPayType;
	}

	/**
	 * Sets the emp pay type.
	 *
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(long empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * Gets the office add num.
	 *
	 * @return the officeAddNum
	 */
	public String getOfficeAddNum() {
		return officeAddNum;
	}

	/**
	 * Sets the office add num.
	 *
	 * @param officeAddNum the officeAddNum to set
	 */
	public void setOfficeAddNum(String officeAddNum) {
		this.officeAddNum = officeAddNum;
	}

	/**
	 * Gets the ddo code.
	 *
	 * @return the ddoCode
	 */
	public String getDdoCode() {
		return ddoCode;
	}

	/**
	 * Sets the ddo code.
	 *
	 * @param ddoCode the ddoCode to set
	 */
	public void setDdoCode(String ddoCode) {
		this.ddoCode = ddoCode;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Gets the checks if is NPA.
	 *
	 * @return the checks if is NPA
	 */
	public long getIsNPA() {
		return isNPA;
	}

	/**
	 * Sets the checks if is NPA.
	 *
	 * @param isNPA the new checks if is NPA
	 */
	public void setIsNPA(long isNPA) {
		this.isNPA = isNPA;
	}

	/**
	 * @return the empStatusName
	 */
	public String getEmpStatusName() {
		return empStatusName;
	}

	/**
	 * @param empStatusName the empStatusName to set
	 */
	public void setEmpStatusName(String empStatusName) {
		this.empStatusName = empStatusName;
	}

	/**
	 * @return the empTypeName
	 */
	public String getEmpTypeName() {
		return empTypeName;
	}

	/**
	 * @param empTypeName the empTypeName to set
	 */
	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
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
	 * @return the presentOfficeName
	 */
	public String getPresentOfficeName() {
		return presentOfficeName;
	}

	/**
	 * @param presentOfficeName the presentOfficeName to set
	 */
	public void setPresentOfficeName(String presentOfficeName) {
		this.presentOfficeName = presentOfficeName;
	}

	/**
	 * @return the subOfficeName
	 */
	public String getSubOfficeName() {
		return subOfficeName;
	}

	/**
	 * @param subOfficeName the subOfficeName to set
	 */
	public void setSubOfficeName(String subOfficeName) {
		this.subOfficeName = subOfficeName;
	}

	/**
	 * @return the empClassName
	 */
	public String getEmpClassName() {
		return empClassName;
	}

	/**
	 * @param empClassName the empClassName to set
	 */
	public void setEmpClassName(String empClassName) {
		this.empClassName = empClassName;
	}

	/**
	 * @return the departmentalCategoryName
	 */
	public String getDepartmentalCategoryName() {
		return departmentalCategoryName;
	}

	/**
	 * @param departmentalCategoryName the departmentalCategoryName to set
	 */
	public void setDepartmentalCategoryName(String departmentalCategoryName) {
		this.departmentalCategoryName = departmentalCategoryName;
	}

	/**
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * @return the payCommissionJoiningTimeName
	 */
	public String getPayCommissionJoiningTimeName() {
		return payCommissionJoiningTimeName;
	}

	/**
	 * @param payCommissionJoiningTimeName the payCommissionJoiningTimeName to set
	 */
	public void setPayCommissionJoiningTimeName(String payCommissionJoiningTimeName) {
		this.payCommissionJoiningTimeName = payCommissionJoiningTimeName;
	}

	/**
	 * @return the empPayTypeName
	 */
	public String getEmpPayTypeName() {
		return empPayTypeName;
	}

	/**
	 * @param empPayTypeName the empPayTypeName to set
	 */
	public void setEmpPayTypeName(String empPayTypeName) {
		this.empPayTypeName = empPayTypeName;
	}

	/**
	 * @return the parentHeadDeptName
	 */
	public String getParentHeadDeptName() {
		return parentHeadDeptName;
	}

	/**
	 * @param parentHeadDeptName the parentHeadDeptName to set
	 */
	public void setParentHeadDeptName(String parentHeadDeptName) {
		this.parentHeadDeptName = parentHeadDeptName;
	}

	/**
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * @return the isNPAName
	 */
	public String getIsNPAName() {
		return isNPAName;
	}

	/**
	 * @param isNPAName the isNPAName to set
	 */
	public void setIsNPAName(String isNPAName) {
		this.isNPAName = isNPAName;
	}

	public long getDeputation() {
		return deputation;
	}

	public void setDeputation(long deputation) {
		this.deputation = deputation;
	}

	public String getEmpDeputationName() {
		return empDeputationName;
	}

	public void setEmpDeputationName(String empDeputationName) {
		this.empDeputationName = empDeputationName;
	}

	public long getDeputDistrictId() {
		return deputDistrictId;
	}

	public void setDeputDistrictId(long deputDistrictId) {
		this.deputDistrictId = deputDistrictId;
	}

	public String getDeputDdoCode() {
		return deputDdoCode;
	}

	public void setDeputDdoCode(String deputDdoCode) {
		this.deputDdoCode = deputDdoCode;
	}

	public String getDeputCardexNo() {
		return deputCardexNo;
	}

	public void setDeputCardexNo(String deputCardexNo) {
		this.deputCardexNo = deputCardexNo;
	}

	public long getDeputOfficeId() {
		return deputOfficeId;
	}

	public void setDeputOfficeId(long deputOfficeId) {
		this.deputOfficeId = deputOfficeId;
	}

	public String getDeputOfficeName() {
		return deputOfficeName;
	}

	public void setDeputOfficeName(String deputOfficeName) {
		this.deputOfficeName = deputOfficeName;
	}

	/**
	 * @return the fixPayDate
	 */
	public Date getFixPayDate() {
		return fixPayDate;
	}

	public String getDeputDistrictName() {
		return deputDistrictName;
	}

	public void setDeputDistrictName(String deputDistrictName) {
		this.deputDistrictName = deputDistrictName;
	}

	/**
	 * @param fixPayDate the fixPayDate to set
	 */
	public void setFixPayDate(Date fixPayDate) {
		this.fixPayDate = fixPayDate;
	}
	
	

	/**
	 * @return the joinEmpPayType
	 */
	public Long getJoinEmpPayType() {
		return joinEmpPayType;
	}

	/**
	 * @param joinEmpPayType the joinEmpPayType to set
	 */
	public void setJoinEmpPayType(Long joinEmpPayType) {
		this.joinEmpPayType = joinEmpPayType;
	}

	/**
	 * @return the joinEmpPayTypeName
	 */
	public String getJoinEmpPayTypeName() {
		return joinEmpPayTypeName;
	}

	/**
	 * @param joinEmpPayTypeName the joinEmpPayTypeName to set
	 */
	public void setJoinEmpPayTypeName(String joinEmpPayTypeName) {
		this.joinEmpPayTypeName = joinEmpPayTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cardexNo == null) ? 0 : cardexNo.hashCode());
		result = prime * result + ((dateOfJoiningGOG == null) ? 0 : dateOfJoiningGOG.hashCode());
		result = prime * result + ((dateOfRetirement == null) ? 0 : dateOfRetirement.hashCode());
		result = prime * result + ((ddoCode == null) ? 0 : ddoCode.hashCode());
		result = prime * result + ((deathTerminationDate == null) ? 0 : deathTerminationDate.hashCode());
		result = prime * result + (int) (departmentId ^ (departmentId >>> 32));
		result = prime * result + (int) (departmentalCategory ^ (departmentalCategory >>> 32));
		result = prime * result + ((departmentalCategoryName == null) ? 0 : departmentalCategoryName.hashCode());
		result = prime * result + ((deputCardexNo == null) ? 0 : deputCardexNo.hashCode());
		result = prime * result + ((deputDdoCode == null) ? 0 : deputDdoCode.hashCode());
		result = prime * result + (int) (deputDistrictId ^ (deputDistrictId >>> 32));
		result = prime * result + (int) (deputOfficeId ^ (deputOfficeId >>> 32));
		result = prime * result + ((deputOfficeName == null) ? 0 : deputOfficeName.hashCode());
		result = prime * result + (int) (deputation ^ (deputation >>> 32));
		result = prime * result + ((deputationEndDate == null) ? 0 : deputationEndDate.hashCode());
		result = prime * result + ((deputationStartDate == null) ? 0 : deputationStartDate.hashCode());
		result = prime * result + (int) (designationId ^ (designationId >>> 32));
		result = prime * result + ((designationName == null) ? 0 : designationName.hashCode());
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
		result = prime * result + (int) (empClass ^ (empClass >>> 32));
		result = prime * result + ((empClassName == null) ? 0 : empClassName.hashCode());
		result = prime * result + ((empDeputationName == null) ? 0 : empDeputationName.hashCode());
		result = prime * result + (int) (empId ^ (empId >>> 32));
		result = prime * result + (int) (empPayType ^ (empPayType >>> 32));
		result = prime * result + ((empPayTypeName == null) ? 0 : empPayTypeName.hashCode());
		result = prime * result + (int) (empStatus ^ (empStatus >>> 32));
		result = prime * result + ((empStatusName == null) ? 0 : empStatusName.hashCode());
		result = prime * result + (int) (empType ^ (empType >>> 32));
		result = prime * result + ((empTypeName == null) ? 0 : empTypeName.hashCode());
		result = prime * result + ((fixPayDate == null) ? 0 : fixPayDate.hashCode());
		result = prime * result + ((gpfNo == null) ? 0 : gpfNo.hashCode());
		result = prime * result + ((hodName == null) ? 0 : hodName.hashCode());
		result = prime * result + (int) (hodNameId ^ (hodNameId >>> 32));
		result = prime * result + (int) (isNPA ^ (isNPA >>> 32));
		result = prime * result + ((isNPAName == null) ? 0 : isNPAName.hashCode());
		result = prime * result + (isSuspended ? 1231 : 1237);
		result = prime * result + ((officeAddNum == null) ? 0 : officeAddNum.hashCode());
		result = prime * result + (int) (parentHeadDeptId ^ (parentHeadDeptId >>> 32));
		result = prime * result + ((parentHeadDeptName == null) ? 0 : parentHeadDeptName.hashCode());
		result = prime * result + (int) (payCommissionJoiningTime ^ (payCommissionJoiningTime >>> 32));
		result = prime * result
				+ ((payCommissionJoiningTimeName == null) ? 0 : payCommissionJoiningTimeName.hashCode());
		result = prime * result + ((ppanNo == null) ? 0 : ppanNo.hashCode());
		result = prime * result + ((ppoNo == null) ? 0 : ppoNo.hashCode());
		result = prime * result + ((pranAccNo == null) ? 0 : pranAccNo.hashCode());
		result = prime * result + (int) (presentOffice ^ (presentOffice >>> 32));
		result = prime * result + ((presentOfficeName == null) ? 0 : presentOfficeName.hashCode());
		result = prime * result + ((station == null) ? 0 : station.hashCode());
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
		result = prime * result + (int) (subOffice ^ (subOffice >>> 32));
		result = prime * result + ((subOfficeName == null) ? 0 : subOfficeName.hashCode());
		result = prime * result + (int) (taluka ^ (taluka >>> 32));
		result = prime * result + ((talukaName == null) ? 0 : talukaName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeDepartmentDto other = (PVUEmployeDepartmentDto) obj;
		if (cardexNo == null) {
			if (other.cardexNo != null)
				return false;
		} else if (!cardexNo.equals(other.cardexNo))
			return false;
		if (dateOfJoiningGOG == null) {
			if (other.dateOfJoiningGOG != null)
				return false;
		} else if (!dateOfJoiningGOG.equals(other.dateOfJoiningGOG))
			return false;
		if (dateOfRetirement == null) {
			if (other.dateOfRetirement != null)
				return false;
		} else if (!dateOfRetirement.equals(other.dateOfRetirement))
			return false;
		if (ddoCode == null) {
			if (other.ddoCode != null)
				return false;
		} else if (!ddoCode.equals(other.ddoCode))
			return false;
		if (deathTerminationDate == null) {
			if (other.deathTerminationDate != null)
				return false;
		} else if (!deathTerminationDate.equals(other.deathTerminationDate))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (departmentalCategory != other.departmentalCategory)
			return false;
		if (departmentalCategoryName == null) {
			if (other.departmentalCategoryName != null)
				return false;
		} else if (!departmentalCategoryName.equals(other.departmentalCategoryName))
			return false;
		if (deputCardexNo == null) {
			if (other.deputCardexNo != null)
				return false;
		} else if (!deputCardexNo.equals(other.deputCardexNo))
			return false;
		if (deputDdoCode == null) {
			if (other.deputDdoCode != null)
				return false;
		} else if (!deputDdoCode.equals(other.deputDdoCode))
			return false;
		if (deputDistrictId != other.deputDistrictId)
			return false;
		if (deputOfficeId != other.deputOfficeId)
			return false;
		if (deputOfficeName == null) {
			if (other.deputOfficeName != null)
				return false;
		} else if (!deputOfficeName.equals(other.deputOfficeName))
			return false;
		if (deputation != other.deputation)
			return false;
		if (deputationEndDate == null) {
			if (other.deputationEndDate != null)
				return false;
		} else if (!deputationEndDate.equals(other.deputationEndDate))
			return false;
		if (deputationStartDate == null) {
			if (other.deputationStartDate != null)
				return false;
		} else if (!deputationStartDate.equals(other.deputationStartDate))
			return false;
		if (designationId != other.designationId)
			return false;
		if (designationName == null) {
			if (other.designationName != null)
				return false;
		} else if (!designationName.equals(other.designationName))
			return false;
		if (districtId != other.districtId)
			return false;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		if (empClass != other.empClass)
			return false;
		if (empClassName == null) {
			if (other.empClassName != null)
				return false;
		} else if (!empClassName.equals(other.empClassName))
			return false;
		if (empDeputationName == null) {
			if (other.empDeputationName != null)
				return false;
		} else if (!empDeputationName.equals(other.empDeputationName))
			return false;
		if (empId != other.empId)
			return false;
		if (empPayType != other.empPayType)
			return false;
		if (empPayTypeName == null) {
			if (other.empPayTypeName != null)
				return false;
		} else if (!empPayTypeName.equals(other.empPayTypeName))
			return false;
		if (empStatus != other.empStatus)
			return false;
		if (empStatusName == null) {
			if (other.empStatusName != null)
				return false;
		} else if (!empStatusName.equals(other.empStatusName))
			return false;
		if (empType != other.empType)
			return false;
		if (empTypeName == null) {
			if (other.empTypeName != null)
				return false;
		} else if (!empTypeName.equals(other.empTypeName))
			return false;
		if (fixPayDate == null) {
			if (other.fixPayDate != null)
				return false;
		} else if (!fixPayDate.equals(other.fixPayDate))
			return false;
		if (gpfNo == null) {
			if (other.gpfNo != null)
				return false;
		} else if (!gpfNo.equals(other.gpfNo))
			return false;
		if (hodName == null) {
			if (other.hodName != null)
				return false;
		} else if (!hodName.equals(other.hodName))
			return false;
		if (hodNameId != other.hodNameId)
			return false;
		if (isNPA != other.isNPA)
			return false;
		if (isNPAName == null) {
			if (other.isNPAName != null)
				return false;
		} else if (!isNPAName.equals(other.isNPAName))
			return false;
		if (isSuspended != other.isSuspended)
			return false;
		if (officeAddNum == null) {
			if (other.officeAddNum != null)
				return false;
		} else if (!officeAddNum.equals(other.officeAddNum))
			return false;
		if (parentHeadDeptId != other.parentHeadDeptId)
			return false;
		if (parentHeadDeptName == null) {
			if (other.parentHeadDeptName != null)
				return false;
		} else if (!parentHeadDeptName.equals(other.parentHeadDeptName))
			return false;
		if (payCommissionJoiningTime != other.payCommissionJoiningTime)
			return false;
		if (payCommissionJoiningTimeName == null) {
			if (other.payCommissionJoiningTimeName != null)
				return false;
		} else if (!payCommissionJoiningTimeName.equals(other.payCommissionJoiningTimeName))
			return false;
		if (ppanNo == null) {
			if (other.ppanNo != null)
				return false;
		} else if (!ppanNo.equals(other.ppanNo))
			return false;
		if (ppoNo == null) {
			if (other.ppoNo != null)
				return false;
		} else if (!ppoNo.equals(other.ppoNo))
			return false;
		if (pranAccNo == null) {
			if (other.pranAccNo != null)
				return false;
		} else if (!pranAccNo.equals(other.pranAccNo))
			return false;
		if (presentOffice != other.presentOffice)
			return false;
		if (presentOfficeName == null) {
			if (other.presentOfficeName != null)
				return false;
		} else if (!presentOfficeName.equals(other.presentOfficeName))
			return false;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		if (statusId != other.statusId)
			return false;
		if (subOffice != other.subOffice)
			return false;
		if (subOfficeName == null) {
			if (other.subOfficeName != null)
				return false;
		} else if (!subOfficeName.equals(other.subOfficeName))
			return false;
		if (taluka != other.taluka)
			return false;
		if (talukaName == null) {
			if (other.talukaName != null)
				return false;
		} else if (!talukaName.equals(other.talukaName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PVUEmployeDepartmentDto [departmentId=" + departmentId + ", dateOfJoiningGOG=" + dateOfJoiningGOG
				+ ", dateOfRetirement=" + dateOfRetirement + ", empStatus=" + empStatus + ", empStatusName="
				+ empStatusName + ", empType=" + empType + ", empTypeName=" + empTypeName + ", designationId="
				+ designationId + ", designationName=" + designationName + ", districtId=" + districtId
				+ ", districtName=" + districtName + ", presentOffice=" + presentOffice + ", presentOfficeName="
				+ presentOfficeName + ", subOffice=" + subOffice + ", subOfficeName=" + subOfficeName + ", empClass="
				+ empClass + ", empClassName=" + empClassName + ", departmentalCategory=" + departmentalCategory
				+ ", departmentalCategoryName=" + departmentalCategoryName + ", station=" + station + ", taluka="
				+ taluka + ", talukaName=" + talukaName + ", gpfNo=" + gpfNo + ", pranAccNo=" + pranAccNo + ", ppoNo="
				+ ppoNo + ", deathTerminationDate=" + deathTerminationDate + ", ppanNo=" + ppanNo + ", cardexNo="
				+ cardexNo + ", payCommissionJoiningTime=" + payCommissionJoiningTime
				+ ", payCommissionJoiningTimeName=" + payCommissionJoiningTimeName + ", empPayType=" + empPayType
				+ ", empPayTypeName=" + empPayTypeName + ", officeAddNum=" + officeAddNum + ", ddoCode=" + ddoCode
				+ ", parentHeadDeptId=" + parentHeadDeptId + ", parentHeadDeptName=" + parentHeadDeptName
				+ ", hodNameId=" + hodNameId + ", hodName=" + hodName + ", isNPA=" + isNPA + ", isNPAName=" + isNPAName
				+ ", deputation=" + deputation + ", empDeputationName=" + empDeputationName + ", deputDistrictId="
				+ deputDistrictId + ", deputDdoCode=" + deputDdoCode + ", deputCardexNo=" + deputCardexNo
				+ ", deputOfficeId=" + deputOfficeId + ", deputOfficeName=" + deputOfficeName + ", fixPayDate="
				+ fixPayDate + ", statusId=" + statusId + ", empId=" + empId + ", isSuspended=" + isSuspended
				+ ", deputationEndDate=" + deputationEndDate + ", deputationStartDate=" + deputationStartDate + "]"
				+ ", joinEmpPayType=" + joinEmpPayType + ", joinEmpPayTypeName=" + joinEmpPayTypeName ;
	}

}
