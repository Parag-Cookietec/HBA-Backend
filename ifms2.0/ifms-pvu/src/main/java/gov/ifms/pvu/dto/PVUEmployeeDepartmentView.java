package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeeDepartmentDto.
 *
 * @version v 1.0
 * @created 2021/01/30 14:17:25
 */

@NativeQueryResultEntity
public class PVUEmployeeDepartmentView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	@NativeQueryResultColumn(index = 0)
	private String departmentId;

	@NativeQueryResultColumn(index = 1)
	private String dateOfJoiningGOG;

	@NativeQueryResultColumn(index = 2)
	private String dateOfRetirement;

	@NativeQueryResultColumn(index = 3)
	private String employeeStatus;

	@NativeQueryResultColumn(index = 4)
	private String employeeTypeName;

	@NativeQueryResultColumn(index = 5)
	private String designationName;

	@NativeQueryResultColumn(index = 6)
	private String districtName;

	@NativeQueryResultColumn(index = 7)
	private String presentOfficeName;

	@NativeQueryResultColumn(index = 8)
	private String ddoCode;

	/** The office add num. */
	@NativeQueryResultColumn(index = 9)
	private String officeAddressAndContact;

	@NativeQueryResultColumn(index = 10)
	private String className;

	@NativeQueryResultColumn(index = 11)
	private String employeeType;

	@NativeQueryResultColumn(index = 12)
	private String departmentCategoryName;

	/** The station. */
	@NativeQueryResultColumn(index = 13)
	private String station;

	/** The taluka. */
	@NativeQueryResultColumn(index = 14)
	private String talukaName;
	@NativeQueryResultColumn(index = 15)
	private String nameAdminDepartment;

	/** The gpf no. */
	@NativeQueryResultColumn(index = 16)
	private String gpfNumber;

	/** The pran acc no. */
	@NativeQueryResultColumn(index = 17)
	private String pranAccoutNumber;

	/** The ppo no. */
	@NativeQueryResultColumn(index = 18)
	private String ppoNumber;

	/** The ppan no. */
	/** The death termination date. */
	@NativeQueryResultColumn(index = 19)
	private String deathTerminationDate;

	@NativeQueryResultColumn(index = 20)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 21)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 22)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 23)
	private String updateByPostName;

	@NativeQueryResultColumn(index = 24)
	private String officeName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 25)
	private String changeType ;

	@NativeQueryResultColumn(index = 26)
	private String deputationStartDate;

	@NativeQueryResultColumn(index = 27)
	private String deputationEndDate;

	@NativeQueryResultColumn(index = 28)
	private String ppanNo;

	@NativeQueryResultColumn(index = 29)
	private String deputationName;

	@NativeQueryResultColumn(index = 30)
	private String deputationDdoCode;

	@NativeQueryResultColumn(index = 31)
	private String deputationCardexNo;

	@NativeQueryResultColumn(index = 32)
	private String deputationOfficeName;

	@NativeQueryResultColumn(index = 33)
	private String deputationDistrictName;
	
	@NativeQueryResultColumn(index = 34)
	private String fixOrProbationalPayJoiningDate;


	/**
	 * @return the departmentId
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(String departmentId) {
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
		this.dateOfJoiningGOG = PvuUtils.getDateToStringDMYFormatValue(dateOfJoiningGOG);
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
		this.dateOfRetirement = PvuUtils.getDateToStringDMYFormatValue(dateOfRetirement);
	}

	/**
	 * @return the employeeStatus
	 */
	public String getEmployeeStatus() {
		return employeeStatus;
	}

	/**
	 * @param employeeStatus the employeeStatus to set
	 */
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	/**
	 * @return the employeeTypeName
	 */
	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	/**
	 * @param employeeTypeName the employeeTypeName to set
	 */
	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
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
	 * @return the officeAddressAndContact
	 */
	public String getOfficeAddressAndContact() {
		return officeAddressAndContact;
	}

	/**
	 * @param officeAddressAndContact the officeAddressAndContact to set
	 */
	public void setOfficeAddressAndContact(String officeAddressAndContact) {
		this.officeAddressAndContact = officeAddressAndContact;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the employeeType
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @return the departmentCategoryName
	 */
	public String getDepartmentCategoryName() {
		return departmentCategoryName;
	}

	/**
	 * @param departmentCategoryName the departmentCategoryName to set
	 */
	public void setDepartmentCategoryName(String departmentCategoryName) {
		this.departmentCategoryName = departmentCategoryName;
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
	 * @return the nameAdminDepartment
	 */
	public String getNameAdminDepartment() {
		return nameAdminDepartment;
	}

	/**
	 * @param nameAdminDepartment the nameAdminDepartment to set
	 */
	public void setNameAdminDepartment(String nameAdminDepartment) {
		this.nameAdminDepartment = nameAdminDepartment;
	}

	/**
	 * @return the gpfNumber
	 */
	public String getGpfNumber() {
		return PvuUtils.ternaryOperator(gpfNumber);
	}

	/**
	 * @param gpfNumber the gpfNumber to set
	 */
	public void setGpfNumber(String gpfNumber) {
		this.gpfNumber = gpfNumber;
	}

	/**
	 * @return the pranAccoutNumber
	 */
	public String getPranAccoutNumber() {
		return PvuUtils.ternaryOperator(pranAccoutNumber);
	}

	/**
	 * @param pranAccoutNumber the pranAccoutNumber to set
	 */
	public void setPranAccoutNumber(String pranAccoutNumber) {
		this.pranAccoutNumber = pranAccoutNumber;
	}

	/**
	 * @return the ppoNumber
	 */
	public String getPpoNumber() {

		return PvuUtils.ternaryOperator(ppoNumber);
	}

	/**
	 * @param ppoNumber the ppoNumber to set
	 */
	public void setPpoNumber(String ppoNumber) {
		this.ppoNumber = ppoNumber;
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

		this.deathTerminationDate =  PvuUtils.getDateToStringDMYFormatValue(deathTerminationDate);
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


	public String getDeputationStartDate() {
		return deputationStartDate;
	}

	public void setDeputationStartDate(String deputationStartDate) {
		this.deputationStartDate = PvuUtils.getDateToStringDMYFormatValue(deputationStartDate);
	}

	public String getDeputationEndDate() {
		return deputationEndDate;
	}

	public void setDeputationEndDate(String deputationEndDate) {
		this.deputationEndDate = PvuUtils.getDateToStringDMYFormatValue(deputationEndDate);
	}

	public String getPpanNo() {
		return ppanNo;
	}

	public void setPpanNo(String ppanNo) {
		this.ppanNo = PvuUtils.ternaryOperator(ppanNo);
	}

	public String getDeputationName() {
		return deputationName;
	}

	public void setDeputationName(String deputationName) {
		this.deputationName = deputationName;
	}

	public String getDeputationDdoCode() {
		return deputationDdoCode;
	}

	public void setDeputationDdoCode(String deputationDdoCode) {
		this.deputationDdoCode = PvuUtils.ternaryOperator(deputationDdoCode);
	}

	public String getDeputationCardexNo() {
		return deputationCardexNo;
	}

	public void setDeputationCardexNo(String deputationCardexNo) {
		this.deputationCardexNo = PvuUtils.ternaryOperator(deputationCardexNo);
	}

	public String getDeputationOfficeName() {
		return deputationOfficeName;
	}

	public void setDeputationOfficeName(String deputationOfficeName) {
		this.deputationOfficeName = deputationOfficeName;
	}

	public String getDeputationDistrictName() {
		return deputationDistrictName;
	}

	public void setDeputationDistrictName(String deputationDistrictName) {
		this.deputationDistrictName = deputationDistrictName;
	}

	/**
	 * @return the fixOrProbationalPayJoiningDate
	 */
	public String getFixOrProbationalPayJoiningDate() {
		return fixOrProbationalPayJoiningDate;
	}

	/**
	 * @param fixOrProbationalPayJoiningDate the fixOrProbationalPayJoiningDate to set
	 */
	public void setFixOrProbationalPayJoiningDate(String fixOrProbationalPayJoiningDate) {
		this.fixOrProbationalPayJoiningDate = fixOrProbationalPayJoiningDate;
	}
	
	
}
