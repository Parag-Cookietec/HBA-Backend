package gov.ifms.edp.entity;

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
import javax.persistence.Transient;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsOfficeEntity.
 *
 * @author Admin
 */
@Entity
@Table(name = "MS_OFFICE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsOfficeEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/** The transaction no. */
	@Column(name = "TRN_NO")
	private String transactionNo;

	/** The office name. */
	@Column(name = "OFFICE_NAME")
	private String officeName;

	/** The office name guj. */
	@Column(name = "OFF_NAME_GUJ")
	private String officeNameGuj;

	/** The office short name. */
	@Column(name = "OFF_SHORT_NAME")
	private String officeShortName;

	/** The office short name guj. */
	@Column(name = "OFF_SHORT_NAME_GUJ", updatable = false)
	private String officeShortNameGuj;

	/** The office code. */
	@Column(name = "OFFICE_CODE", updatable = false)
	private String officeCode;

	/** The office code name. */
	@Column(name = "OFF_CODE_NAME", updatable = false)
	private String officeCodeName;

	/** The office code guj. */
	@Column(name = "OFF_CODE_GUJ", updatable = false)
	private String officeCodeGuj;

	/** The office type id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity officeTypeId;

	/** The gr no. */
	@Column(name = "GR_NO")
	private String grNo;

	/** The parent office id. */
	@Column(name = "P_OFFICE_ID")
	private Long parentOfficeId;

	/** The country id. */
	@Column(name = "COUNTRY_ID", updatable = false)
	private Long countryId;

	/** The state id. */
	@Column(name = "STATE_ID", updatable = false)
	private Long stateId;

	/** The district id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	/** The taluka id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUKA_ID")
	private EDPMsTalukaEntity talukaId;

	/** The village id. */
	@Column(name = "VILLAGE_ID")
	private Long villageId;

	/** The level id. */
	@Column(name = "LEVEL_ID")
	private Long levelId;

	/** The cardexno. */
	@Column(name = "CARDEX_NO")
	private Long cardexno;

	/** The ddo no. */
	@Column(name = "DDO_NO")
	private String ddoNo;

	/** The ddo type. */
	@Column(name = "DDO_TYPE")
	private Integer ddoType;

	/** The non ddo. */
	@Column(name = "NON_DDO")
	private Long nonDdo;

	/** The pvu id. */
	@Column(name = "PVU_ID")
	private Long pvuId;

	/** The desg ddo id. */
	@Column(name = "DESG_DDO_ID")
	private Long desgDdoId;

	/** The office name disp. */
	@Column(name = "OFFICE_NAME_DISP")
	private String officeNameDisp;

	/** The request to. */
	@Column(name = "REQUEST_TO")
	private Long requestTo;

	/** The treasury type. */
	@Column(name = "TREASURY_TYPE")
	private Long treasuryType;

	/** The employee no. */
	@Column(name = "EMPLOYEE_No")
	private String employeeNo;

	/** The employee name. */
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	/** The addr line 1. */
	@Column(name = "ADDR_LINE_1")
	private String addrLine1;

	/** The addr line 2. */
	@Column(name = "ADDR_LINE_2")
	private String addrLine2;

	/** The station. */
	@Column(name = "STATION")
	private String station;

	/** The pincode. */
	@Column(name = "PIN_CODE")
	private String pincode;

	/** The phone no. */
	@Column(name = "PHONE_NO")
	private String phoneNo;

	/** The mobile no. */
	@Column(name = "MOBILE_NO")
	private String mobileNo;

	/** The fax no. */
	@Column(name = "FAX_NO")
	private String faxNo;

	/** The email id. */
	@Column(name = "EMAIL_ID")
	private String emailId;


	/** The department id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity departmentId;

	/** The hod id. */
	@Column(name = "HOD_ID")
	private Integer hodId;

	/** The co id. */
	@Column(name = "CO_ID")
	private Integer coId;

	/** The co office name. */
	@Column(name = "CO_OFF_NAME")
	private Integer coOfficeName;

	/** The obj status. */
	@Column(name = "OBJ_STATUS")
	private Integer objStatus;

	/** The obj remark. */
	@Column(name = "OBJ_REMARKS")
	private String objRemark;

	/** The is sub treasury. */
	@Column(name = "IS_SUBTREASURY")
	private Short isSubTreasury;

	/** The is treasury. */
	@Column(name = "IS_TREASURY")
	private Short isTreasury ;

	/** The is co. */
	@Column(name = "IS_CO")
	private Long isCo;

	/** The is hod. */
	@Column(name = "IS_HOD")
	private Long isHod;

	/** The is fd. */
	@Column(name = "IS_FD")
	private Long isFd;

	/** The digital sig enable. */
	@Column(name = "DIGI_SIGN_ENABLED")
	private Short digitalSigEnable;

	/** The grant rcvng cardex. */
	@Column(name = "GRANT_RCVNG_CARDEX")
	private Short grantRcvngCardex;

	/** The is verified. */
	@Column(name = "IS_VERIFIED")
	private Long isVerified;

	/** The verified date. */
	@Column(name = "VERIFIED_DATE")
	private Date verifiedDate;

	/** The comment. */
	@Column(name = "COMMENTS")
	private String comment;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Short statusId;

	/** The address description. */
	@Column(name = "ADDRESS_DESC")
	private String addressDescription;

	/** The address description guj. */
	@Column(name = "ADDRESS_DESC_GUJ")
	private String addressDescriptionGuj;

	/** The is update. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_UPDATE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isUpdate;

	/** The office end date. */
	@Column(name = "OFFICE_END_DATE")
	private Date officeEndDate;

	/** The off st comments. */
	@Column(name = "OFF_ST_COMMENTS")
	private String offStComments;

	/** The unique id. */
	@Column(name = "UNIQUE_OFFICE_ID")
	private String uniqueId;

	/** The office division. */
	@Column(name = "OFFICE_DIVISION")
	private String officeDivision;

	/** The office status id. */
	@Column(name = "OFFICE_STATUS")
	private Long officeStatus;

	/** The office name alias. */
	@Column(name = "OFFICE_NAME_ALIAS")
	private String officeNameAlias;

	/** The office PVU. */
	@Column(name = "OFFICE_PVU")
	private String officePVU;

	/** The office sub type. */
	@Column(name = "OFFICE_SUB_TYPE")
	private Long officeSubType;

	/** The ddo sub type. */
	@Column(name = "DDO_SUB_TYPE")
	private Long ddoSubType;

	/** The objection. */
	@Column(name = "OBJECTION")
	private Long objection;

	/** The objection Remarks */
	@Column(name = "OBJECTION_REMARKS")
	private String objectionRemarks;

	/** The initiated By */
	@Column(name = "INITIATED_BY")
	private Long initiatedBy;

	/** The wf In Request */
	@Column(name = "WF_IN_REQUEST")
	private Long wfInRequest;

	@Transient
	private EDPUpdateOfficeTrnEntity officeTrnEntity;

	@Column(name = "OFFICE_TRANSFER_TO")
	private Long officeTransferId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_TYPE_ID")
	private EDPMsSubTypeEntity subType;

	public Long getObjection() {
		return objection;
	}

	public void setObjection(Long objection) {
		this.objection = objection;
	}

	public String getObjectionRemarks() {
		return objectionRemarks;
	}

	public void setObjectionRemarks(String objectionRemarks) {
		this.objectionRemarks = objectionRemarks;
	}

	public Long getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(Long initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public Long getWfInRequest() {
		return wfInRequest;
	}

	public void setWfInRequest(Long wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the transaction no.
	 *
	 * @return the transactionNo
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * Sets the transaction no.
	 *
	 * @param transactionNo the transactionNo to set
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the office name guj.
	 *
	 * @return the officeNameGuj
	 */
	public String getOfficeNameGuj() {
		return officeNameGuj;
	}

	/**
	 * Sets the office name guj.
	 *
	 * @param officeNameGuj the officeNameGuj to set
	 */
	public void setOfficeNameGuj(String officeNameGuj) {
		this.officeNameGuj = officeNameGuj;
	}

	/**
	 * Gets the office short name.
	 *
	 * @return the officeShortName
	 */
	public String getOfficeShortName() {
		return officeShortName;
	}

	/**
	 * Sets the office short name.
	 *
	 * @param officeShortName the officeShortName to set
	 */
	public void setOfficeShortName(String officeShortName) {
		this.officeShortName = officeShortName;
	}

	/**
	 * Gets the office short name guj.
	 *
	 * @return the officeShortNameGuj
	 */
	public String getOfficeShortNameGuj() {
		return officeShortNameGuj;
	}

	/**
	 * Sets the office short name guj.
	 *
	 * @param officeShortNameGuj the officeShortNameGuj to set
	 */
	public void setOfficeShortNameGuj(String officeShortNameGuj) {
		this.officeShortNameGuj = officeShortNameGuj;
	}

	/**
	 * Gets the office code.
	 *
	 * @return the officeCode
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * Sets the office code.
	 *
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * Gets the office code name.
	 *
	 * @return the officeCodeName
	 */
	public String getOfficeCodeName() {
		return officeCodeName;
	}

	/**
	 * Sets the office code name.
	 *
	 * @param officeCodeName the officeCodeName to set
	 */
	public void setOfficeCodeName(String officeCodeName) {
		this.officeCodeName = officeCodeName;
	}

	/**
	 * Gets the office code guj.
	 *
	 * @return the officeCodeGuj
	 */
	public String getOfficeCodeGuj() {
		return officeCodeGuj;
	}

	/**
	 * Sets the office code guj.
	 *
	 * @param officeCodeGuj the officeCodeGuj to set
	 */
	public void setOfficeCodeGuj(String officeCodeGuj) {
		this.officeCodeGuj = officeCodeGuj;
	}

	/**
	 * Gets the office type id.
	 *
	 * @return the officeTypeId
	 */
	public EDPLuLookUpInfoEntity getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * Sets the office type id.
	 *
	 * @param officeTypeId the officeTypeId to set
	 */
	public void setOfficeTypeId(EDPLuLookUpInfoEntity officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	/**
	 * Gets the gr no.
	 *
	 * @return the grNo
	 */
	public String getGrNo() {
		return grNo;
	}

	/**
	 * Sets the gr no.
	 *
	 * @param grNo the grNo to set
	 */
	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}

	/**
	 * Gets the parent office id.
	 *
	 * @return the parentOfficeId
	 */
	public Long getParentOfficeId() {
		return parentOfficeId;
	}

	/**
	 * Sets the parent office id.
	 *
	 * @param parentOfficeId the parentOfficeId to set
	 */
	public void setParentOfficeId(Long parentOfficeId) {
		this.parentOfficeId = parentOfficeId;
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
	 * Gets the level id.
	 *
	 * @return the levelId
	 */
	public Long getLevelId() {
		return levelId;
	}

	/**
	 * Sets the level id.
	 *
	 * @param levelId the levelId to set
	 */
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	/**
	 * Gets the cardexno.
	 *
	 * @return the cardexno
	 */
	public Long getCardexno() {
		return cardexno;
	}

	/**
	 * Sets the cardexno.
	 *
	 * @param cardexno the cardexno to set
	 */
	public void setCardexno(Long cardexno) {
		this.cardexno = cardexno;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the ddo type.
	 *
	 * @return the ddoType
	 */
	public Integer getDdoType() {
		return ddoType;
	}

	/**
	 * Sets the ddo type.
	 *
	 * @param ddoType the ddoType to set
	 */
	public void setDdoType(Integer ddoType) {
		this.ddoType = ddoType;
	}

	/**
	 * Gets the non ddo.
	 *
	 * @return the nonDdo
	 */
	public Long getNonDdo() {
		return nonDdo;
	}

	/**
	 * Sets the non ddo.
	 *
	 * @param nonDdo the nonDdo to set
	 */
	public void setNonDdo(Long nonDdo) {
		this.nonDdo = nonDdo;
	}

	/**
	 * Gets the pvu id.
	 *
	 * @return the pvuId
	 */
	public Long getPvuId() {
		return pvuId;
	}

	/**
	 * Sets the pvu id.
	 *
	 * @param pvuId the pvuId to set
	 */
	public void setPvuId(Long pvuId) {
		this.pvuId = pvuId;
	}

	/**
	 * Gets the desg ddo id.
	 *
	 * @return the desgDdoId
	 */
	public Long getDesgDdoId() {
		return desgDdoId;
	}

	/**
	 * Sets the desg ddo id.
	 *
	 * @param desgDdoId the desgDdoId to set
	 */
	public void setDesgDdoId(Long desgDdoId) {
		this.desgDdoId = desgDdoId;
	}

	/**
	 * Gets the office name disp.
	 *
	 * @return the officeNameDisp
	 */
	public String getOfficeNameDisp() {
		return officeNameDisp;
	}

	/**
	 * Sets the office name disp.
	 *
	 * @param officeNameDisp the officeNameDisp to set
	 */
	public void setOfficeNameDisp(String officeNameDisp) {
		this.officeNameDisp = officeNameDisp;
	}

	/**
	 * Gets the request to.
	 *
	 * @return the requestTo
	 */
	public Long getRequestTo() {
		return requestTo;
	}

	/**
	 * Sets the request to.
	 *
	 * @param requestTo the requestTo to set
	 */
	public void setRequestTo(Long requestTo) {
		this.requestTo = requestTo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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
	 * Gets the addr line 1.
	 *
	 * @return the addrLine1
	 */
	public String getAddrLine1() {
		return addrLine1;
	}

	/**
	 * Sets the addr line 1.
	 *
	 * @param addrLine1 the addrLine1 to set
	 */
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	/**
	 * Gets the address description.
	 *
	 * @return the addressDescription
	 */
	public String getAddressDescription() {
		return addressDescription;
	}

	/**
	 * Sets the address description.
	 *
	 * @param addressDescription the addressDescription to set
	 */
	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	/**
	 * Gets the address description guj.
	 *
	 * @return the addressDescriptionGuj
	 */
	public String getAddressDescriptionGuj() {
		return addressDescriptionGuj;
	}

	/**
	 * Sets the address description guj.
	 *
	 * @param addressDescriptionGuj the addressDescriptionGuj to set
	 */
	public void setAddressDescriptionGuj(String addressDescriptionGuj) {
		this.addressDescriptionGuj = addressDescriptionGuj;
	}

	/**
	 * Gets the addr line 2.
	 *
	 * @return the addrLine2
	 */
	public String getAddrLine2() {
		return addrLine2;
	}

	/**
	 * Sets the addr line 2.
	 *
	 * @param addrLine2 the addrLine2 to set
	 */
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	/**
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public EDPMsTalukaEntity getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(EDPMsTalukaEntity talukaId) {
		this.talukaId = talukaId;
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
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * Gets the phone no.
	 *
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone no.
	 *
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	 * Gets the fax no.
	 *
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * Sets the fax no.
	 *
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public EDPMsDepartmentEntity getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(EDPMsDepartmentEntity departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
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
	 * Gets the hod id.
	 *
	 * @return the hodId
	 */
	public Integer getHodId() {
		return hodId;
	}

	/**
	 * Sets the hod id.
	 *
	 * @param hodId the hodId to set
	 */
	public void setHodId(Integer hodId) {
		this.hodId = hodId;
	}

	/**
	 * Gets the co id.
	 *
	 * @return the coId
	 */
	public Integer getCoId() {
		return coId;
	}

	/**
	 * Sets the co id.
	 *
	 * @param coId the coId to set
	 */
	public void setCoId(Integer coId) {
		this.coId = coId;
	}

	/**
	 * Gets the co office name.
	 *
	 * @return the coOfficeName
	 */
	public Integer getCoOfficeName() {
		return coOfficeName;
	}

	/**
	 * Sets the co office name.
	 *
	 * @param coOfficeName the coOfficeName to set
	 */
	public void setCoOfficeName(Integer coOfficeName) {
		this.coOfficeName = coOfficeName;
	}

	/**
	 * Gets the obj status.
	 *
	 * @return the objStatus
	 */
	public Integer getObjStatus() {
		return objStatus;
	}

	/**
	 * Sets the obj status.
	 *
	 * @param objStatus the objStatus to set
	 */
	public void setObjStatus(Integer objStatus) {
		this.objStatus = objStatus;
	}

	/**
	 * Gets the obj remark.
	 *
	 * @return the objRemark
	 */
	public String getObjRemark() {
		return objRemark;
	}

	/**
	 * Sets the obj remark.
	 *
	 * @param objRemark the objRemark to set
	 */
	public void setObjRemark(String objRemark) {
		this.objRemark = objRemark;
	}

	/**
	 * Gets the checks if is sub treasury.
	 *
	 * @return the isSubTreasury
	 */

	/**
	 * Sets the checks if is co.
	 *
	 * @param isCo the isCo to set
	 */
	public void setIsCo(Long isCo) {
		this.isCo = isCo;
	}

	/**
	 * @return the isSubTreasury
	 */
	public Short getIsSubTreasury() {
		return isSubTreasury;
	}

	/**
	 * @param isSubTreasury the isSubTreasury to set
	 */
	public void setIsSubTreasury(Short isSubTreasury) {
		this.isSubTreasury = isSubTreasury;
	}

	/**
	 * @return the isTreasury
	 */
	public Short getIsTreasury() {
		return isTreasury;
	}

	/**
	 * @param isTreasury the isTreasury to set
	 */
	public void setIsTreasury(Short isTreasury) {
		this.isTreasury = isTreasury;
	}

	/**
	 * @return the isCo
	 */
	public Long getIsCo() {
		return isCo;
	}

	/**
	 * Gets the checks if is hod.
	 *
	 * @return the isHod
	 */
	public Long getIsHod() {
		return isHod;
	}

	/**
	 * Sets the checks if is hod.
	 *
	 * @param isHod the isHod to set
	 */
	public void setIsHod(Long isHod) {
		this.isHod = isHod;
	}

	/**
	 * Gets the checks if is fd.
	 *
	 * @return the isFd
	 */
	public Long getIsFd() {
		return isFd;
	}

	/**
	 * Sets the checks if is fd.
	 *
	 * @param isFd the isFd to set
	 */
	public void setIsFd(Long isFd) {
		this.isFd = isFd;
	}

	/**
	 * Gets the digital sig enable.
	 *
	 * @return the digitalSigEnable
	 */
	public Short getDigitalSigEnable() {
		return digitalSigEnable;
	}

	/**
	 * Sets the digital sig enable.
	 *
	 * @param digitalSigEnable the digitalSigEnable to set
	 */
	public void setDigitalSigEnable(Short digitalSigEnable) {
		this.digitalSigEnable = digitalSigEnable;
	}

	/**
	 * Gets the grant rcvng cardex.
	 *
	 * @return the grantRcvngCardex
	 */
	public Short getGrantRcvngCardex() {
		return grantRcvngCardex;
	}

	/**
	 * Sets the grant rcvng cardex.
	 *
	 * @param grantRcvngCardex the grantRcvngCardex to set
	 */
	public void setGrantRcvngCardex(Short grantRcvngCardex) {
		this.grantRcvngCardex = grantRcvngCardex;
	}

	/**
	 * Gets the checks if is verified.
	 *
	 * @return the isVerified
	 */
	public Long getIsVerified() {
		return isVerified;
	}

	/**
	 * Sets the checks if is verified.
	 *
	 * @param isVerified the isVerified to set
	 */
	public void setIsVerified(Long isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * Gets the verified date.
	 *
	 * @return the verifiedDate
	 */
	public Date getVerifiedDate() {
		return verifiedDate;
	}

	/**
	 * Sets the verified date.
	 *
	 * @param verifiedDate the verifiedDate to set
	 */
	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Short getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Short statusId) {
		this.statusId = statusId;
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
	 * Gets the treasury type.
	 *
	 * @return the treasuryType
	 */
	public Long getTreasuryType() {
		return treasuryType;
	}

	/**
	 * Sets the treasury type.
	 *
	 * @param treasuryType the treasuryType to set
	 */
	public void setTreasuryType(Long treasuryType) {
		this.treasuryType = treasuryType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(addrLine1, addrLine2, addressDescription, addressDescriptionGuj, cardexno, coId,
				coOfficeName, comment, ddoNo, ddoType, departmentId, desgDdoId, digitalSigEnable, districtId, emailId,
				employeeName, employeeNo, faxNo, grNo, grantRcvngCardex, hodId, isCo, isFd, isHod, isSubTreasury,
				isTreasury, isVerified, levelId, mobileNo, nonDdo, objRemark, objStatus, officeCode, officeCodeGuj,
				officeCodeName, officeId, officeName, officeNameDisp, officeNameGuj, officeShortName,
				officeShortNameGuj, officeTypeId, parentOfficeId, phoneNo, pincode, pvuId, requestTo, station, statusId,
				talukaId, transactionNo, treasuryType, verifiedDate, uniqueId);
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
		if (!(obj instanceof EDPMsOfficeEntity)) {
			return false;
		}
		EDPMsOfficeEntity other = (EDPMsOfficeEntity) obj;
		return Objects.equals(addrLine1, other.addrLine1) && Objects.equals(addrLine2, other.addrLine2)
				&& Objects.equals(addressDescription, other.addressDescription)
				&& Objects.equals(addressDescriptionGuj, other.addressDescriptionGuj)
				&& Objects.equals(cardexno, other.cardexno) && Objects.equals(coId, other.coId)
				&& Objects.equals(coOfficeName, other.coOfficeName) && Objects.equals(comment, other.comment)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoType, other.ddoType)
				&& Objects.equals(departmentId, other.departmentId) && Objects.equals(desgDdoId, other.desgDdoId)
				&& Objects.equals(digitalSigEnable, other.digitalSigEnable)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(faxNo, other.faxNo) && Objects.equals(grNo, other.grNo)
				&& Objects.equals(grantRcvngCardex, other.grantRcvngCardex) && Objects.equals(hodId, other.hodId)
				&& Objects.equals(isCo, other.isCo) && Objects.equals(isFd, other.isFd)
				&& Objects.equals(isHod, other.isHod) && Objects.equals(isSubTreasury, other.isSubTreasury)
				&& Objects.equals(isTreasury, other.isTreasury) && Objects.equals(isVerified, other.isVerified)
				&& Objects.equals(levelId, other.levelId) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(nonDdo, other.nonDdo) && Objects.equals(objRemark, other.objRemark)
				&& Objects.equals(objStatus, other.objStatus) && Objects.equals(officeCode, other.officeCode)
				&& Objects.equals(officeCodeGuj, other.officeCodeGuj)
				&& Objects.equals(officeCodeName, other.officeCodeName) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(officeNameDisp, other.officeNameDisp)
				&& Objects.equals(officeNameGuj, other.officeNameGuj)
				&& Objects.equals(officeShortName, other.officeShortName)
				&& Objects.equals(officeShortNameGuj, other.officeShortNameGuj)
				&& Objects.equals(officeTypeId, other.officeTypeId)
				&& Objects.equals(parentOfficeId, other.parentOfficeId) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(pvuId, other.pvuId)
				&& Objects.equals(requestTo, other.requestTo) && Objects.equals(station, other.station)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(talukaId, other.talukaId)
				&& Objects.equals(transactionNo, other.transactionNo) && Objects.equals(uniqueId, other.uniqueId)
				&& Objects.equals(treasuryType, other.treasuryType) && Objects.equals(verifiedDate, other.verifiedDate);
	}

	/**
	 * Instantiates a new EDP ms office entity.
	 */
	public EDPMsOfficeEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms office entity.
	 *
	 * @param officeId the office id
	 */
	public EDPMsOfficeEntity(Long officeId) {
		super();
		this.officeId = officeId;
	}

	/**
	 * Gets the state id.
	 *
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * Sets the state id.
	 *
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * Gets the village id.
	 *
	 * @return the villageId
	 */
	public Long getVillageId() {
		return villageId;
	}

	/**
	 * Sets the village id.
	 *
	 * @param villageId the villageId to set
	 */
	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	/**
	 * Gets the checks if is update.
	 *
	 * @return the isUpdate
	 */
	public EDPLuLookUpInfoEntity getIsUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the checks if is update.
	 *
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(EDPLuLookUpInfoEntity isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * Gets the office end date.
	 *
	 * @return the officeEndDate
	 */
	public Date getOfficeEndDate() {
		return officeEndDate;
	}

	/**
	 * Sets the office end date.
	 *
	 * @param officeEndDate the officeEndDate to set
	 */
	public void setOfficeEndDate(Date officeEndDate) {
		this.officeEndDate = officeEndDate;
	}

	/**
	 * Gets the off st comments.
	 *
	 * @return the offStComments
	 */
	public String getOffStComments() {
		return offStComments;
	}

	/**
	 * Sets the off st comments.
	 *
	 * @param offStComments the offStComments to set
	 */
	public void setOffStComments(String offStComments) {
		this.offStComments = offStComments;
	}

	/**
	 * Gets the unique id.
	 *
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets the unique id.
	 *
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Gets the office division.
	 *
	 * @return the officeDivision
	 */
	public String getOfficeDivision() {
		return officeDivision;
	}

	/**
	 * Sets the office division.
	 *
	 * @param officeDivision the officeDivision to set
	 */
	public void setOfficeDivision(String officeDivision) {
		this.officeDivision = officeDivision;
	}

	/**
	 * Gets the office status.
	 *
	 * @return the officeStatus
	 */
	public Long getOfficeStatus() {
		return officeStatus;
	}

	/**
	 * Sets the office status.
	 *
	 * @param officeStatus the officeStatus to set
	 */
	public void setOfficeStatus(Long officeStatus) {
		this.officeStatus = officeStatus;
	}

	/**
	 * Gets the office name alias.
	 *
	 * @return the officeNameAlias
	 */
	public String getOfficeNameAlias() {
		return officeNameAlias;
	}

	/**
	 * Sets the office name alias.
	 *
	 * @param officeNameAlias the officeNameAlias to set
	 */
	public void setOfficeNameAlias(String officeNameAlias) {
		this.officeNameAlias = officeNameAlias;
	}

	/**
	 * Gets the office PVU.
	 *
	 * @return the officePVU
	 */
	public String getOfficePVU() {
		return officePVU;
	}

	/**
	 * Sets the office PVU.
	 *
	 * @param officePVU the officePVU to set
	 */
	public void setOfficePVU(String officePVU) {
		this.officePVU = officePVU;
	}

	/**
	 * Gets the office sub type.
	 *
	 * @return the office sub type
	 */
	public Long getOfficeSubType() {
		return officeSubType;
	}

	/**
	 * Sets the office sub type.
	 *
	 * @param officeSubType the new office sub type
	 */
	public void setOfficeSubType(Long officeSubType) {
		this.officeSubType = officeSubType;
	}

	/**
	 * Gets the ddo sub type.
	 *
	 * @return the ddo sub type
	 */
	public Long getDdoSubType() {
		return ddoSubType;
	}

	/**
	 * Sets the ddo sub type.
	 *
	 * @param ddoSubType the new ddo sub type
	 */
	public void setDdoSubType(Long ddoSubType) {
		this.ddoSubType = ddoSubType;
	}

	/**
	 * @return the officeTrnEntity
	 */
	public EDPUpdateOfficeTrnEntity getOfficeTrnEntity() {
		return officeTrnEntity;
	}

	/**
	 * @param officeTrnEntity the officeTrnEntity to set
	 */
	public void setOfficeTrnEntity(EDPUpdateOfficeTrnEntity officeTrnEntity) {
		this.officeTrnEntity = officeTrnEntity;
	}

	/**
	 * @return the officeTransferId
	 */
	public Long getOfficeTransferId() {
		return officeTransferId;
	}

	/**
	 * @param officeTransferId the officeTransferId to set
	 */
	public void setOfficeTransferId(Long officeTransferId) {
		this.officeTransferId = officeTransferId;
	}

	public EDPMsSubTypeEntity getSubType() {
		return subType;
	}

	public void setSubType(EDPMsSubTypeEntity subType) {
		this.subType = subType;
	}
}