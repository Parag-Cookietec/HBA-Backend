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
public class PVUEmployeDepartmentEditabelDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	private long departmentId;

	/** The date of joining GOG. */
	@NotNull
	private String dateOfJoiningGOG;

	/** The date of retirement. */
	@NotNull
	private String dateOfRetirement;

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
	private String deathTerminationDate;

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
	
	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	private long changeType;

	/** The emp pay type. */
	private long deputation;
	private String empDeputationName;

	private long deputDistrictId;

	private String deputDdoCode;

	private String deputCardexNo;

	private long deputOfficeId;

	private String deputOfficeName;

	private String fixPayDate;

	private String deputDistrictName;

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

	/** The deputation end String. */
	private String deputationEndDate;

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
	private String deputationStartDate;

	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the dateOfJoiningGOG
	 */
	public String getDateOfJoiningGOG() {
		return dateOfJoiningGOG;
	}

	/**
	 * @param dateOfJoiningGOG the dateOfJoiningGOG to set
	 */
	public void setDateOfJoiningGOG(String dateOfJoiningGOG) {
		this.dateOfJoiningGOG = dateOfJoiningGOG;
	}

	/**
	 * @return the dateOfRetirement
	 */
	public String getDateOfRetirement() {
		return dateOfRetirement;
	}

	/**
	 * @param dateOfRetirement the dateOfRetirement to set
	 */
	public void setDateOfRetirement(String dateOfRetirement) {
		this.dateOfRetirement = dateOfRetirement;
	}

	/**
	 * @return the empStatus
	 */
	public long getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(long empStatus) {
		this.empStatus = empStatus;
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
	 * @return the empType
	 */
	public long getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(long empType) {
		this.empType = empType;
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
	 * @return the designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
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
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
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
	 * @return the presentOffice
	 */
	public long getPresentOffice() {
		return presentOffice;
	}

	/**
	 * @param presentOffice the presentOffice to set
	 */
	public void setPresentOffice(long presentOffice) {
		this.presentOffice = presentOffice;
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
	 * @return the subOffice
	 */
	public long getSubOffice() {
		return subOffice;
	}

	/**
	 * @param subOffice the subOffice to set
	 */
	public void setSubOffice(long subOffice) {
		this.subOffice = subOffice;
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
	 * @return the empClass
	 */
	public long getEmpClass() {
		return empClass;
	}

	/**
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(long empClass) {
		this.empClass = empClass;
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
	 * @return the departmentalCategory
	 */
	public long getDepartmentalCategory() {
		return departmentalCategory;
	}

	/**
	 * @param departmentalCategory the departmentalCategory to set
	 */
	public void setDepartmentalCategory(long departmentalCategory) {
		this.departmentalCategory = departmentalCategory;
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
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * @return the taluka
	 */
	public long getTaluka() {
		return taluka;
	}

	/**
	 * @param taluka the taluka to set
	 */
	public void setTaluka(long taluka) {
		this.taluka = taluka;
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
	 * @return the gpfNo
	 */
	public String getGpfNo() {
		return gpfNo;
	}

	/**
	 * @param gpfNo the gpfNo to set
	 */
	public void setGpfNo(String gpfNo) {
		this.gpfNo = gpfNo;
	}

	/**
	 * @return the pranAccNo
	 */
	public String getPranAccNo() {
		return pranAccNo;
	}

	/**
	 * @param pranAccNo the pranAccNo to set
	 */
	public void setPranAccNo(String pranAccNo) {
		this.pranAccNo = pranAccNo;
	}

	/**
	 * @return the ppoNo
	 */
	public String getPpoNo() {
		return ppoNo;
	}

	/**
	 * @param ppoNo the ppoNo to set
	 */
	public void setPpoNo(String ppoNo) {
		this.ppoNo = ppoNo;
	}

	/**
	 * @return the deathTerminationDate
	 */
	public String getDeathTerminationDate() {
		return deathTerminationDate;
	}

	/**
	 * @param deathTerminationDate the deathTerminationDate to set
	 */
	public void setDeathTerminationDate(String deathTerminationDate) {
		this.deathTerminationDate = deathTerminationDate;
	}

	/**
	 * @return the ppanNo
	 */
	public String getPpanNo() {
		return ppanNo;
	}

	/**
	 * @param ppanNo the ppanNo to set
	 */
	public void setPpanNo(String ppanNo) {
		this.ppanNo = ppanNo;
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
	 * @return the payCommissionJoiningTime
	 */
	public long getPayCommissionJoiningTime() {
		return payCommissionJoiningTime;
	}

	/**
	 * @param payCommissionJoiningTime the payCommissionJoiningTime to set
	 */
	public void setPayCommissionJoiningTime(long payCommissionJoiningTime) {
		this.payCommissionJoiningTime = payCommissionJoiningTime;
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
	 * @return the empPayType
	 */
	public long getEmpPayType() {
		return empPayType;
	}

	/**
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(long empPayType) {
		this.empPayType = empPayType;
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
	 * @return the officeAddNum
	 */
	public String getOfficeAddNum() {
		return officeAddNum;
	}

	/**
	 * @param officeAddNum the officeAddNum to set
	 */
	public void setOfficeAddNum(String officeAddNum) {
		this.officeAddNum = officeAddNum;
	}

	/**
	 * @return the ddoCode
	 */
	public String getDdoCode() {
		return ddoCode;
	}

	/**
	 * @param ddoCode the ddoCode to set
	 */
	public void setDdoCode(String ddoCode) {
		this.ddoCode = ddoCode;
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
	 * @return the isNPA
	 */
	public long getIsNPA() {
		return isNPA;
	}

	/**
	 * @param isNPA the isNPA to set
	 */
	public void setIsNPA(long isNPA) {
		this.isNPA = isNPA;
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

	/**
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the deputationEndDate
	 */
	public String getDeputationEndDate() {
		return deputationEndDate;
	}

	/**
	 * @param deputationEndDate the deputationEndDate to set
	 */
	public void setDeputationEndDate(String deputationEndDate) {
		this.deputationEndDate = deputationEndDate;
	}

	/**
	 * @return the deputationStartDate
	 */
	public String getDeputationStartDate() {
		return deputationStartDate;
	}

	/**
	 * @param deputationStartDate the deputationStartDate to set
	 */
	public void setDeputationStartDate(String deputationStartDate) {
		this.deputationStartDate = deputationStartDate;
	}

	public long getDeputation() {
		return deputation;
	}

	public void setDeputation(long deputation) {
		this.deputation = deputation;
	}

	public long getEmpId() {
		return empId;
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

	public String getDeputDistrictName() {
		return deputDistrictName;
	}

	public void setDeputDistrictName(String deputDistrictName) {
		this.deputDistrictName = deputDistrictName;
	}

	public String getFixPayDate() {
		return fixPayDate;
	}

	public void setFixPayDate(String fixPayDate) {
		this.fixPayDate = fixPayDate;
	}
}
