package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class EDPOfficeItrDto.
 */
public class EDPOfficeItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office itr id. */
	private Long officeItrId;
	
	/** The office id. */
	private Long officeId;

	/** The transaction no. */
	private String transactionNo;

	/** The office name. */
	private String officeName;

	/** The office name guj. */
	private String officeNameGuj;

	/** The office short name. */
	private String officeShortName;

	/** The office short name guj. */
	private String officeShortNameGuj;
	
	/** The office code. */
	private String officeCode;
	
	/** The office code name. */
	private String officeCodeName;

	/** The office code guj. */
	private String officeCodeGuj;

	/** The office type id. */
	private Long officeTypeId;
	
	/** The gr no. */
	private String grNo;
	
	/** The parent office id. */
	private Long parentOfficeId;
	
	/** The office range id. */
	private Long officeRangeId;
	
	/** The request no. */
	private String requestNo;
	
	/** The district id. */
	private Long districtId;
	
	/** The level id. */
	private Long levelId;

	/** The cardexno. */
	private Long cardexno;

	/** The ddo no. */
	private String ddoNo;

	/** The ddo type. */
	private Integer ddoType;

	/** The non ddo. */
	private Long nonDdo;

	/** The pvu id. */
	private Long pvuId;

	/** The desg ddo id. */
	private Long desgDdoId;

	/** The office name disp. */
	private String officeNameDisp;

	/** The request to. */
	private Long requestTo;

	/** The treasury type. */
	private Long treasuryType;
	
	/** The employee no. */
	private String employeeNo;
	
	/** The employee name. */
	private String employeeName;
	
	/** The addr line 1. */
	private String addrLine1;

	/** The address description. */
	private String addressDescription;

	/** The address description guj. */
	private String addressDescriptionGuj;
	
	/** The addr line 2. */
	private String addrLine2;
	
	/** The taluka id. */
	private Long talukaId;
	
	/** The station. */
	private String station;

	/** The pincode. */
	private Long pincode;
	
	/** The std code. */
	private String stdCode;
	
	/** The phone no. */
	private String phoneNo;

	/** The mobile no. */
	private String mobileNo;

	/** The fax no. */
	private String faxNo;

	/** The email id. */
	private String emailId;

	/** The edp ms department entitie. */
	private Long edpMsDepartmentEntitie;

	/** The hod id. */
	private Integer hodId;

	/** The co id. */
	private Integer coId;
	
	/** The co office name. */
	private Integer coOfficeName;
	
	/** The obj status. */
	private Integer objStatus;

	/** The obj remark. */
	private String objRemark;
	
	/** The is sub treasury. */
	private Short isSubTreasury;

	/** The is treasury. */
	private Short isTreasury;

	/** The is co. */
	private Short isCo;

	/** The is hod. */
	private Short isHod;

	/** The is fd. */
	private Short isFd;
	
	/** The digital sig enable. */
	private Short digitalSigEnable;

	/** The grant rcvng cardex. */
	private Short grantRcvngCardex;

	/** The is verified. */
	private Short isVerified;

	/** The verified date. */
	private Date verifiedDate;
	
	/** The comment. */
	private String comment;
	
	/** The status id. */
	private Short statusId;

	/** The work flow id. */
	private Long workFlowId;

	/** The wf role id. */
	private Long wfRoleId;
	
	/** The is update. */
	private Long isUpdate;
	
	private Long officeStatus;
	

	/** The office end date. */
	private Date officeEndDate;
	
	/** The off st comments. */
	private String offStComments;
	
	private String officeNameAlias;
	
	private String officePVU;

	private Long officeTransferId;

	/**
	 * @return the officeStatus
	 */
	public Long getOfficeStatus() {
		return officeStatus;
	}

	/**
	 * @param officeStatus the officeStatus to set
	 */
	public void setOfficeStatus(Long officeStatus) {
		this.officeStatus = officeStatus;
	}

	/**
	 * Gets the office itr id.
	 *
	 * @return the officeItrId
	 */
	public Long getOfficeItrId() {
		return officeItrId;
	}

	/**
	 * Sets the office itr id.
	 *
	 * @param officeItrId the officeItrId to set
	 */
	public void setOfficeItrId(Long officeItrId) {
		this.officeItrId = officeItrId;
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
	public Long getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * Sets the office type id.
	 *
	 * @param officeTypeId the officeTypeId to set
	 */
	public void setOfficeTypeId(Long officeTypeId) {
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
	 * Gets the office range id.
	 *
	 * @return the officeRangeId
	 */
	public Long getOfficeRangeId() {
		return officeRangeId;
	}

	/**
	 * Sets the office range id.
	 *
	 * @param officeRangeId the officeRangeId to set
	 */
	public void setOfficeRangeId(Long officeRangeId) {
		this.officeRangeId = officeRangeId;
	}

	/**
	 * Gets the request no.
	 *
	 * @return the requestNo
	 */
	public String getRequestNo() {
		return requestNo;
	}

	/**
	 * Sets the request no.
	 *
	 * @param requestNo the requestNo to set
	 */
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
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
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
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
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
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
	public Long getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the pincode to set
	 */
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	/**
	 * Gets the std code.
	 *
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * Sets the std code.
	 *
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
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
	 * Gets the edp ms department entitie.
	 *
	 * @return the edpMsDepartmentEntitie
	 */
	public Long getEdpMsDepartmentEntitie() {
		return edpMsDepartmentEntitie;
	}

	/**
	 * Sets the edp ms department entitie.
	 *
	 * @param edpMsDepartmentEntitie the edpMsDepartmentEntitie to set
	 */
	public void setEdpMsDepartmentEntitie(Long edpMsDepartmentEntitie) {
		this.edpMsDepartmentEntitie = edpMsDepartmentEntitie;
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
	public Short getIsSubTreasury() {
		return isSubTreasury;
	}

	/**
	 * Sets the checks if is sub treasury.
	 *
	 * @param isSubTreasury the isSubTreasury to set
	 */
	public void setIsSubTreasury(Short isSubTreasury) {
		this.isSubTreasury = isSubTreasury;
	}

	/**
	 * Gets the checks if is treasury.
	 *
	 * @return the isTreasury
	 */
	public Short getIsTreasury() {
		return isTreasury;
	}

	/**
	 * Sets the checks if is treasury.
	 *
	 * @param isTreasury the isTreasury to set
	 */
	public void setIsTreasury(Short isTreasury) {
		this.isTreasury = isTreasury;
	}

	/**
	 * Gets the checks if is co.
	 *
	 * @return the isCo
	 */
	public Short getIsCo() {
		return isCo;
	}

	/**
	 * Sets the checks if is co.
	 *
	 * @param isCo the isCo to set
	 */
	public void setIsCo(Short isCo) {
		this.isCo = isCo;
	}

	/**
	 * Gets the checks if is hod.
	 *
	 * @return the isHod
	 */
	public Short getIsHod() {
		return isHod;
	}

	/**
	 * Sets the checks if is hod.
	 *
	 * @param isHod the isHod to set
	 */
	public void setIsHod(Short isHod) {
		this.isHod = isHod;
	}

	/**
	 * Gets the checks if is fd.
	 *
	 * @return the isFd
	 */
	public Short getIsFd() {
		return isFd;
	}

	/**
	 * Sets the checks if is fd.
	 *
	 * @param isFd the isFd to set
	 */
	public void setIsFd(Short isFd) {
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
	public Short getIsVerified() {
		return isVerified;
	}

	/**
	 * Sets the checks if is verified.
	 *
	 * @param isVerified the isVerified to set
	 */
	public void setIsVerified(Short isVerified) {
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
	 * Gets the work flow id.
	 *
	 * @return the workFlowId
	 */
	public Long getWorkFlowId() {
		return workFlowId;
	}

	/**
	 * Sets the work flow id.
	 *
	 * @param workFlowId the workFlowId to set
	 */
	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the checks if is update.
	 *
	 * @return the isUpdate
	 */
	public Long getIsUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the checks if is update.
	 *
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(Long isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * @return the officeEndDate
	 */
	public Date getOfficeEndDate() {
		return officeEndDate;
	}

	/**
	 * @param officeEndDate the officeEndDate to set
	 */
	public void setOfficeEndDate(Date officeEndDate) {
		this.officeEndDate = officeEndDate;
	}

	/**
	 * @return the offStComments
	 */
	public String getOffStComments() {
		return offStComments;
	}

	/**
	 * @param offStComments the offStComments to set
	 */
	public void setOffStComments(String offStComments) {
		this.offStComments = offStComments;
	}

	/**
	 * @return the officeNameAlias
	 */
	public String getOfficeNameAlias() {
		return officeNameAlias;
	}

	/**
	 * @param officeNameAlias the officeNameAlias to set
	 */
	public void setOfficeNameAlias(String officeNameAlias) {
		this.officeNameAlias = officeNameAlias;
	}

	/**
	 * @return the officePVU
	 */
	public String getOfficePVU() {
		return officePVU;
	}

	/**
	 * @param officePVU the officePVU to set
	 */
	public void setOfficePVU(String officePVU) {
		this.officePVU = officePVU;
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(addrLine1, addrLine2, addressDescription, addressDescriptionGuj,
				cardexno, coId, coOfficeName, comment, ddoNo, ddoType, desgDdoId, digitalSigEnable, districtId,
				edpMsDepartmentEntitie, emailId, employeeName, employeeNo, faxNo, grNo, grantRcvngCardex, hodId, isCo,
				isFd, isHod, isSubTreasury, isTreasury, isUpdate, isVerified, levelId, mobileNo, nonDdo, objRemark,
				objStatus, offStComments, officeCode, officeCodeGuj, officeCodeName, officeEndDate, officeId,
				officeItrId, officeName, officeNameAlias, officeNameDisp, officeNameGuj, officePVU, officeRangeId,
				officeShortName, officeShortNameGuj, officeStatus, officeTransferId, officeTypeId, parentOfficeId,
				phoneNo, pincode, pvuId, requestNo, requestTo, station, statusId, stdCode, talukaId, transactionNo,
				treasuryType, verifiedDate, wfRoleId, workFlowId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPOfficeItrDto)) {
			return false;
		}
		EDPOfficeItrDto other = (EDPOfficeItrDto) obj;
		return Objects.equals(addrLine1, other.addrLine1) && Objects.equals(addrLine2, other.addrLine2)
				&& Objects.equals(addressDescription, other.addressDescription)
				&& Objects.equals(addressDescriptionGuj, other.addressDescriptionGuj)
				&& Objects.equals(cardexno, other.cardexno) && Objects.equals(coId, other.coId)
				&& Objects.equals(coOfficeName, other.coOfficeName) && Objects.equals(comment, other.comment)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoType, other.ddoType)
				&& Objects.equals(desgDdoId, other.desgDdoId)
				&& Objects.equals(digitalSigEnable, other.digitalSigEnable)
				&& Objects.equals(districtId, other.districtId)
				&& Objects.equals(edpMsDepartmentEntitie, other.edpMsDepartmentEntitie)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeNo, other.employeeNo) && Objects.equals(faxNo, other.faxNo)
				&& Objects.equals(grNo, other.grNo) && Objects.equals(grantRcvngCardex, other.grantRcvngCardex)
				&& Objects.equals(hodId, other.hodId) && Objects.equals(isCo, other.isCo)
				&& Objects.equals(isFd, other.isFd) && Objects.equals(isHod, other.isHod)
				&& Objects.equals(isSubTreasury, other.isSubTreasury) && Objects.equals(isTreasury, other.isTreasury)
				&& Objects.equals(isUpdate, other.isUpdate) && Objects.equals(isVerified, other.isVerified)
				&& Objects.equals(levelId, other.levelId) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(nonDdo, other.nonDdo) && Objects.equals(objRemark, other.objRemark)
				&& Objects.equals(objStatus, other.objStatus) && Objects.equals(offStComments, other.offStComments)
				&& Objects.equals(officeCode, other.officeCode) && Objects.equals(officeCodeGuj, other.officeCodeGuj)
				&& Objects.equals(officeCodeName, other.officeCodeName)
				&& Objects.equals(officeEndDate, other.officeEndDate) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeItrId, other.officeItrId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(officeNameAlias, other.officeNameAlias)
				&& Objects.equals(officeNameDisp, other.officeNameDisp)
				&& Objects.equals(officeNameGuj, other.officeNameGuj) && Objects.equals(officePVU, other.officePVU)
				&& Objects.equals(officeRangeId, other.officeRangeId)
				&& Objects.equals(officeShortName, other.officeShortName)
				&& Objects.equals(officeShortNameGuj, other.officeShortNameGuj)
				&& Objects.equals(officeStatus, other.officeStatus)
				&& Objects.equals(officeTransferId, other.officeTransferId)
				&& Objects.equals(officeTypeId, other.officeTypeId)
				&& Objects.equals(parentOfficeId, other.parentOfficeId) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(pvuId, other.pvuId)
				&& Objects.equals(requestNo, other.requestNo) && Objects.equals(requestTo, other.requestTo)
				&& Objects.equals(station, other.station) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(stdCode, other.stdCode) && Objects.equals(talukaId, other.talukaId)
				&& Objects.equals(transactionNo, other.transactionNo)
				&& Objects.equals(treasuryType, other.treasuryType) && Objects.equals(verifiedDate, other.verifiedDate)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(workFlowId, other.workFlowId);
	}
	
}
