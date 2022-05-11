package gov.ifms.pvu.entity;

import java.util.Date;

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
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;

/**
 * The Class PVUEmployeeDepartmentEntity.
 *
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 *
 */

@Entity
@Table(name = "T_EMP_DPT_DTL", schema = Constant.PVU_SCHEMA)
public class PVUEmployeDepartmentEntity extends BaseEntity {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_DPT_DTL_ID")
	private long departmentId;

	/** The date of joining GOG. */
	@Column(name = "DATE_JOINING")
	private Date dateOfJoiningGOG;

	/** The date of retirement. */
	@Column(name = "RETIREMENT_DATE")
	private Date dateOfRetirement;

	/** The emp status. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empStatus;

	/** The emp type. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empType;

	/** The designation id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The parent admin dept. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NAME_P_ADMIN_DEPT", referencedColumnName = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity parentHeadDept;

	/** The hod name. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NAME_HOD", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity hodName;

	/** The district id. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	/** The present office. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NAME_PRESENT_OFFICE", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity presentOffice;

	/** The sub office. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_OFFICE", referencedColumnName = "S_OFFICE_ID")
	private EDPMsSubOfficeEntity subOffice;

	/** The emp class. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CLASS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empClass;

	/** The departmental category. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DEPT_CAT", referencedColumnName = "DEPT_CATEGORY_ID")
	private PVUDepartmentCategoryEntity departmentalCategory;

	/** The station. */
	@Column(name = "STATION")
	private String station;

	/** The taluka. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUKA", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity taluka;

	/** The gpf no. */
	@Column(name = "GPF")
	private String gpfNo;

	/** The pran acc no. */
	@Column(name = "PRAN_ACCT_NO")
	private String pranAccNo;

	/** The ppo no. */
	@Column(name = "PPO_NO")
	private String ppoNo;

	/** The death termination date. */
	@Column(name = "DATE_DEATH_TERM_NO")
	private Date deathTerminationDate;

	/** The ppan no. */
	@Column(name = "PPAN_NO")
	private String ppanNo;

	/** The emppaytype. */
	@OneToOne(optional = false)
	@JoinColumn(name = "EMP_PAY_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empPayType;

	/** The office add num. */
	@Column(name = "OFF_ADD_CONT_NO")
	private String officeAddNum;

	/** The ddo code. */
	@Column(name = "DDO_CODE")
	private String ddoCode;

	/** The status. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The cardex no. */
	@Column(name = "CARDEX_NO")
	private String cardexNo;

	/** The pay commission joining time. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "APL_PAY_COM_JT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommissionJoiningTime;

	/** The is suspended. */
	@Column(name = "IS_SUSPENDED")
	private boolean isSuspended;

	/** The pay commission joining time. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_NPA", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isNPA;

	@Column(name = "CHANGE_TYPE")
	private long changeType;

	/** The emp status. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_ON_DEPUTATION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity deputation;

	/** The district id. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DEPUT_DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity deputDistrictId;

	@Column(name = "DEPUT_DDO_CODE")
	private String deputDdoCode;

	@Column(name = "DEPUT_CARDEX_NO")
	private String deputCardexNo;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DEPUT_NAME_PRESENT_OFFICE", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity deputOfficeId;
	
	/** The fix pay date. */
	@Column(name = "FIX_PAY_DATE")
	private Date fixPayDate;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "JOIN_EMP_PAY_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity joinEmpPayType;
	
	/** The regular conv date. */
	@Column(name = "REGULAR_CONV_DATE")
	private Date regularConvDate;
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

	/** The deputation end date. */
	@Column(name = "DEPUT_END_DATE")
	private Date deputationEndDate;

	/** The deputation start date. */
	@Column(name = "DEPUT_START_DATE")
	private Date deputationStartDate;

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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	/**
	 * Gets the emp status.
	 *
	 * @return the empStatus
	 */
	public EDPLuLookUpInfoEntity getEmpStatus() {
		return empStatus;
	}

	/**
	 * Sets the emp status.
	 *
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(EDPLuLookUpInfoEntity empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public EDPLuLookUpInfoEntity getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(EDPLuLookUpInfoEntity empType) {
		this.empType = empType;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public EDPMsDistrictEntity getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(EDPMsDistrictEntity districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the empClass
	 */
	public EDPLuLookUpInfoEntity getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(EDPLuLookUpInfoEntity empClass) {
		this.empClass = empClass;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the pay commission joining time.
	 *
	 * @return the payCommissionJoiningTime
	 */
	public EDPLuLookUpInfoEntity getPayCommissionJoiningTime() {
		return payCommissionJoiningTime;
	}

	/**
	 * Sets the pay commission joining time.
	 *
	 * @param payCommissionJoiningTime the payCommissionJoiningTime to set
	 */
	public void setPayCommissionJoiningTime(EDPLuLookUpInfoEntity payCommissionJoiningTime) {
		this.payCommissionJoiningTime = payCommissionJoiningTime;
	}

	/**
	 * Gets the office add num.
	 *
	 * @return the officeaddcnum
	 */
	public String getOfficeAddNum() {
		return officeAddNum;
	}

	/**
	 * Sets the office add num.
	 *
	 * @param officeAddNum the officeaddcnum to set
	 */
	public void setOfficeAddNum(String officeAddNum) {
		this.officeAddNum = officeAddNum;
	}

	/**
	 * Gets the ddo code.
	 *
	 * @return the ddocode
	 */
	public String getDdoCode() {
		return ddoCode;
	}

	/**
	 * Sets the ddo code.
	 *
	 * @param ddoCode the ddocode to set
	 */
	public void setDdoCode(String ddoCode) {
		this.ddoCode = ddoCode;
	}

	/** The pvu employe entity. */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return the pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the pvuEmployeEntity to set
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * PVUEmployeeDepartmentEntity Constructor.
	 */
	public PVUEmployeDepartmentEntity() {
		super();
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
	 * Gets the present office.
	 *
	 * @return the presentOffice
	 */
	public EDPMsOfficeEntity getPresentOffice() {
		return presentOffice;
	}

	/**
	 * Sets the present office.
	 *
	 * @param presentOffice the presentOffice to set
	 */
	public void setPresentOffice(EDPMsOfficeEntity presentOffice) {
		this.presentOffice = presentOffice;
	}

	/**
	 * Gets the sub office.
	 *
	 * @return the subOffice
	 */
	public EDPMsSubOfficeEntity getSubOffice() {
		return subOffice;
	}

	/**
	 * Sets the sub office.
	 *
	 * @param subOffice the subOffice to set
	 */
	public void setSubOffice(EDPMsSubOfficeEntity subOffice) {
		this.subOffice = subOffice;
	}

	/**
	 * Gets the departmental category.
	 *
	 * @return the departmentalCategory
	 */
	public PVUDepartmentCategoryEntity getDepartmentalCategory() {
		return departmentalCategory;
	}

	/**
	 * Sets the departmental category.
	 *
	 * @param departmentalCategory the departmentalCategory to set
	 */
	public void setDepartmentalCategory(PVUDepartmentCategoryEntity departmentalCategory) {
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
	 * @return the cTaluka
	 */
	public EDPMsTalukaEntity getTaluka() {
		return taluka;
	}

	/**
	 * Sets the taluka.
	 *
	 * @param taluka the cTaluka to set
	 */
	public void setTaluka(EDPMsTalukaEntity taluka) {
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
	 * Gets the parent head dept.
	 *
	 * @return the parentHeadDept
	 */
	public EDPMsDepartmentEntity getParentHeadDept() {
		return parentHeadDept;
	}

	/**
	 * Sets the parent head dept.
	 *
	 * @param parentHeadDept the parentHeadDept to set
	 */
	public void setParentHeadDept(EDPMsDepartmentEntity parentHeadDept) {
		this.parentHeadDept = parentHeadDept;
	}

	/**
	 * Gets the emp pay type.
	 *
	 * @return the empPayType
	 */
	public EDPLuLookUpInfoEntity getEmpPayType() {
		return empPayType;
	}

	/**
	 * Sets the emp pay type.
	 *
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(EDPLuLookUpInfoEntity empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * Gets the checks if is NPA.
	 *
	 * @return the checks if is NPA
	 */
	public EDPLuLookUpInfoEntity getIsNPA() {
		return isNPA;
	}

	/**
	 * Sets the checks if is NPA.
	 *
	 * @param isNPA the new checks if is NPA
	 */
	public void setIsNPA(EDPLuLookUpInfoEntity isNPA) {
		this.isNPA = isNPA;
	}

	/**
	 * Gets the hod name.
	 *
	 * @return the hod name
	 */
	public EDPMsOfficeEntity getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the new hod name
	 */
	public void setHodName(EDPMsOfficeEntity hodName) {
		this.hodName = hodName;
	}

	public EDPLuLookUpInfoEntity getDeputation() {
		return deputation;
	}

	public void setDeputation(EDPLuLookUpInfoEntity deputation) {
		this.deputation = deputation;
	}

	public EDPMsDistrictEntity getDeputDistrictId() {
		return deputDistrictId;
	}

	public void setDeputDistrictId(EDPMsDistrictEntity deputDistrictId) {
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

	public EDPMsOfficeEntity getDeputOfficeId() {
		return deputOfficeId;
	}

	public void setDeputOfficeId(EDPMsOfficeEntity deputOfficeId) {
		this.deputOfficeId = deputOfficeId;
	}

	/**
	 * @return the fixPayDate
	 */
	public Date getFixPayDate() {
		return fixPayDate;
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
	public EDPLuLookUpInfoEntity getJoinEmpPayType() {
		return joinEmpPayType;
	}

	/**
	 * @param joinEmpPayType the joinEmpPayType to set
	 */
	public void setJoinEmpPayType(EDPLuLookUpInfoEntity joinEmpPayType) {
		this.joinEmpPayType = joinEmpPayType;
	}
	

	/**
	 * @return the regularConvDate
	 */
	public Date getRegularConvDate() {
		return regularConvDate;
	}

	/**
	 * @param regularConvDate the regularConvDate to set
	 */
	public void setRegularConvDate(Date regularConvDate) {
		this.regularConvDate = regularConvDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardexNo == null) ? 0 : cardexNo.hashCode());
		result = prime * result + (int) (changeType ^ (changeType >>> 32));
		result = prime * result + ((dateOfJoiningGOG == null) ? 0 : dateOfJoiningGOG.hashCode());
		result = prime * result + ((dateOfRetirement == null) ? 0 : dateOfRetirement.hashCode());
		result = prime * result + ((ddoCode == null) ? 0 : ddoCode.hashCode());
		result = prime * result + ((deathTerminationDate == null) ? 0 : deathTerminationDate.hashCode());
		result = prime * result + (int) (departmentId ^ (departmentId >>> 32));
		result = prime * result + ((departmentalCategory == null) ? 0 : departmentalCategory.hashCode());
		result = prime * result + ((deputCardexNo == null) ? 0 : deputCardexNo.hashCode());
		result = prime * result + ((deputDdoCode == null) ? 0 : deputDdoCode.hashCode());
		result = prime * result + ((deputDistrictId == null) ? 0 : deputDistrictId.hashCode());
		result = prime * result + ((deputOfficeId == null) ? 0 : deputOfficeId.hashCode());
		result = prime * result + ((deputation == null) ? 0 : deputation.hashCode());
		result = prime * result + ((deputationEndDate == null) ? 0 : deputationEndDate.hashCode());
		result = prime * result + ((deputationStartDate == null) ? 0 : deputationStartDate.hashCode());
		result = prime * result + ((designationId == null) ? 0 : designationId.hashCode());
		result = prime * result + ((districtId == null) ? 0 : districtId.hashCode());
		result = prime * result + ((empClass == null) ? 0 : empClass.hashCode());
		result = prime * result + ((empPayType == null) ? 0 : empPayType.hashCode());
		result = prime * result + ((empStatus == null) ? 0 : empStatus.hashCode());
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		result = prime * result + ((fixPayDate == null) ? 0 : fixPayDate.hashCode());
		result = prime * result + ((gpfNo == null) ? 0 : gpfNo.hashCode());
		result = prime * result + ((hodName == null) ? 0 : hodName.hashCode());
		result = prime * result + ((isNPA == null) ? 0 : isNPA.hashCode());
		result = prime * result + (isSuspended ? 1231 : 1237);
		result = prime * result + ((officeAddNum == null) ? 0 : officeAddNum.hashCode());
		result = prime * result + ((parentHeadDept == null) ? 0 : parentHeadDept.hashCode());
		result = prime * result + ((payCommissionJoiningTime == null) ? 0 : payCommissionJoiningTime.hashCode());
		result = prime * result + ((ppanNo == null) ? 0 : ppanNo.hashCode());
		result = prime * result + ((ppoNo == null) ? 0 : ppoNo.hashCode());
		result = prime * result + ((pranAccNo == null) ? 0 : pranAccNo.hashCode());
		result = prime * result + ((presentOffice == null) ? 0 : presentOffice.hashCode());
		result = prime * result + ((pvuEmployeEntity == null) ? 0 : pvuEmployeEntity.hashCode());
		result = prime * result + ((station == null) ? 0 : station.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subOffice == null) ? 0 : subOffice.hashCode());
		result = prime * result + ((taluka == null) ? 0 : taluka.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeDepartmentEntity other = (PVUEmployeDepartmentEntity) obj;
		if (cardexNo == null) {
			if (other.cardexNo != null)
				return false;
		} else if (!cardexNo.equals(other.cardexNo))
			return false;
		if (changeType != other.changeType)
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
		if (departmentalCategory == null) {
			if (other.departmentalCategory != null)
				return false;
		} else if (!departmentalCategory.equals(other.departmentalCategory))
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
		if (deputDistrictId == null) {
			if (other.deputDistrictId != null)
				return false;
		} else if (!deputDistrictId.equals(other.deputDistrictId))
			return false;
		if (deputOfficeId == null) {
			if (other.deputOfficeId != null)
				return false;
		} else if (!deputOfficeId.equals(other.deputOfficeId))
			return false;
		if (deputation == null) {
			if (other.deputation != null)
				return false;
		} else if (!deputation.equals(other.deputation))
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
		if (designationId == null) {
			if (other.designationId != null)
				return false;
		} else if (!designationId.equals(other.designationId))
			return false;
		if (districtId == null) {
			if (other.districtId != null)
				return false;
		} else if (!districtId.equals(other.districtId))
			return false;
		if (empClass == null) {
			if (other.empClass != null)
				return false;
		} else if (!empClass.equals(other.empClass))
			return false;
		if (empPayType == null) {
			if (other.empPayType != null)
				return false;
		} else if (!empPayType.equals(other.empPayType))
			return false;
		if (empStatus == null) {
			if (other.empStatus != null)
				return false;
		} else if (!empStatus.equals(other.empStatus))
			return false;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
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
		if (isNPA == null) {
			if (other.isNPA != null)
				return false;
		} else if (!isNPA.equals(other.isNPA))
			return false;
		if (isSuspended != other.isSuspended)
			return false;
		if (officeAddNum == null) {
			if (other.officeAddNum != null)
				return false;
		} else if (!officeAddNum.equals(other.officeAddNum))
			return false;
		if (parentHeadDept == null) {
			if (other.parentHeadDept != null)
				return false;
		} else if (!parentHeadDept.equals(other.parentHeadDept))
			return false;
		if (payCommissionJoiningTime == null) {
			if (other.payCommissionJoiningTime != null)
				return false;
		} else if (!payCommissionJoiningTime.equals(other.payCommissionJoiningTime))
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
		if (presentOffice == null) {
			if (other.presentOffice != null)
				return false;
		} else if (!presentOffice.equals(other.presentOffice))
			return false;
		if (pvuEmployeEntity == null) {
			if (other.pvuEmployeEntity != null)
				return false;
		} else if (!pvuEmployeEntity.equals(other.pvuEmployeEntity))
			return false;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subOffice == null) {
			if (other.subOffice != null)
				return false;
		} else if (!subOffice.equals(other.subOffice))
			return false;
		if (taluka == null) {
			if (other.taluka != null)
				return false;
		} else if (!taluka.equals(other.taluka))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PVUEmployeDepartmentEntity [departmentId=" + departmentId + ", dateOfJoiningGOG=" + dateOfJoiningGOG
				+ ", dateOfRetirement=" + dateOfRetirement + ", empStatus=" + empStatus + ", empType=" + empType
				+ ", designationId=" + designationId + ", parentHeadDept=" + parentHeadDept + ", hodName=" + hodName
				+ ", districtId=" + districtId + ", presentOffice=" + presentOffice + ", subOffice=" + subOffice
				+ ", empClass=" + empClass + ", departmentalCategory=" + departmentalCategory + ", station=" + station
				+ ", taluka=" + taluka + ", gpfNo=" + gpfNo + ", pranAccNo=" + pranAccNo + ", ppoNo=" + ppoNo
				+ ", deathTerminationDate=" + deathTerminationDate + ", ppanNo=" + ppanNo + ", empPayType=" + empPayType
				+ ", officeAddNum=" + officeAddNum + ", ddoCode=" + ddoCode + ", status=" + status + ", cardexNo="
				+ cardexNo + ", payCommissionJoiningTime=" + payCommissionJoiningTime + ", isSuspended=" + isSuspended
				+ ", isNPA=" + isNPA + ", changeType=" + changeType + ", deputation=" + deputation
				+ ", deputDistrictId=" + deputDistrictId + ", deputDdoCode=" + deputDdoCode + ", deputCardexNo="
				+ deputCardexNo + ", deputOfficeId=" + deputOfficeId + ", fixPayDate=" + fixPayDate
				+ ", joinEmpPayType=" + joinEmpPayType + ", regularConvDate=" + regularConvDate + ", deputationEndDate="
				+ deputationEndDate + ", deputationStartDate=" + deputationStartDate + ", pvuEmployeEntity="
				+ pvuEmployeEntity + "]";
	}

	
}
