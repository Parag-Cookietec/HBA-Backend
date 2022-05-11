package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import gov.ifms.common.validation.annotation.EmailId;
import gov.ifms.common.validation.annotation.MobileNumber;
import gov.ifms.common.validation.annotation.Numeric;

/**
 * The Class EDPMsOfficeDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:31:41
 *
 */
public class EDPMsOfficeDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office id. */
	private Long officeId;

	/** The transaction no. */
	private String transactionNo;

	/** The office name. */
	@NotBlank
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
	@Min(1)
	private Long officeTypeId;

	/** The gr no. */
	@NotBlank
	private String grNo;

	/** The parent office id. */
	private Long parentOfficeId;

	/** The office range id. */
	private Long officeRangeId;

	/** The request no. */
	private Long requestNo;

	/** The district id. */
	@Min(1)
	private Long districtId;

	/** The district name. */
	private String districtName;

	/** The level id. */
	@Min(1)
	private Long levelId;

	/** The cardexno. */
	private Long cardexno;

	/** The ddo no. */
	// @NotBlank
	private String ddoNo;

	/** The ddo type. */
	private Integer ddoType;

	/** The non ddo. */
	private Long nonDdo;

	/** The pvu id. */
	private Long pvuId;

	/** The desg ddo id. */
	@Min(1)
	private Long desgDdoId;

	/** The office name disp. */
	private String officeNameDisp;

	/** The request to. */
	@Min(1)
	private Long requestTo;

	/** The treasury type. */
	private Long treasuryType;

	/** The employee no. */
	@NotBlank
	private String employeeNo;

	/** The employee name. */
	private String employeeName;

	/** The addr line 1. */
	@NotBlank
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
	private String pincode;

	/** The std code. */
	@Numeric(nullable = true)
	private String stdCode;

	/** The phone no. */
	@Numeric(nullable = true)
	private String phoneNo;

	/** The mobile no. */
	@MobileNumber(nullable = true)
	private String mobileNo;

	/** The fax no. */
	@Numeric(nullable = true)
	private String faxNo;

	/** The email id. */
	@EmailId(nullable = true)
	private String emailId;

	/** The department id. */
	private Long departmentId;

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
	private Long isCo;

	/** The is hod. */
	private Long isHod;

	/** The is fd. */
	private Long isFd;

	/** The digital sig enable. */
	private Short digitalSigEnable;

	/** The grant rcvng cardex. */
	private Short grantRcvngCardex;

	/** The is verified. */
	private Long isVerified;

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

	/** The menu sh name. */
	private String menuShName;

	/** The is new office. */
	private Boolean isNewOffice;

	/** The is update office. */
	private Boolean isUpdateOffice;

	/** The bill submitted to. */
	@Min(1)
	private Long billSubmittedTo;

	/** The bill type. */
	private Long billType;

	/** The bill type selected. */
	private Long billTypeSelected;

	/** The bill status. */
	private Long billStatus;

	/** The selected bills. */
	private Set<Long> selectedBills;

	/** The module id. */
	private List<Long> moduleId;

	/** The office type. */
	private String officeType;

	/** The is update. */
	private Long isUpdate;

	/** The dist name. */
	private String distName;

	/** The dept name. */
	private String deptName;

	/** The office type name. */
	private String officeTypeName;

	/** The level name. */
	private String levelName;

	/** The ddo type name. */
	private String ddoTypeName;

	/** The non ddo type name. */
	private String nonDdoTypeName;

	/** The pvu name. */
	private String pvuName;

	/** The desg ddo name. */
	private String desgDdoName;

	/** The request to name. */
	private String requestToName;

	/** The treasury type name. */
	private String treasuryTypeName;

	/** The taluka name. */
	private String talukaName;

	/** The is co name. */
	private String isCoName;

	/** The hod name. */
	private String hodName;

	/** The co desg name. */
	private String coDesgName;

	/** The office end date. */
	private Date officeEndDate;

	/** The off st comments. */
	private String offStComments;

	/** The unique id. */
	private String uniqueId;

	/** The office division. */
	private String officeDivision;

	/** The office status. */
	private Long officeStatus;

	/** The office name alias. */
	private String officeNameAlias;

	/** The office PVU. */
	private String officePVU;

	/** The prv office status id. */
	private Long prvOfficeStatusId;

	/** The prv office status. */
	private String prvOfficeStatus;

	/** The msg flag. */
	private Boolean msgFlag;

	/** The office sub type. */
	private Long officeSubType;

	/** The ddo sub type. */
	private Long ddoSubType;

	/** The objection. */
	private Long objection;

	/** The objection Remarks */
	private String objectionRemarks;

	/** The initiated By */
	private Long initiatedBy;

	/** The wf In Request */
	private Long wfInRequest;

	/** The wfFinalSubmit */
	private Long wfFinalSubmit;

	/** The TrnId */
	private Long trnId;

	/** The wf status. */
	private String wfStatus;

	/** The officeTransferId. */
	private Long officeTransferId;

	/** The officeTransferDetails. */
	private EDPOfficeTransferDetails officeTransferDetails;

	private Long subTypeId;
	/**
	 * Instantiates a new EDP ms office dto.
	 */
	public EDPMsOfficeDto() {
		super();
	}

	/**
	 * Instantiates a new EDP ms office dto.
	 *
	 * @param officeId   the office id
	 * @param officeName the office name
	 */
	public EDPMsOfficeDto(Long officeId, @NotBlank String officeName) {
		this.officeId = officeId;
		this.officeName = officeName;
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
				billStatus, billSubmittedTo, billType, billTypeSelected, cardexno, coDesgName, coId, coOfficeName,
				comment, ddoNo, ddoSubType, ddoType, ddoTypeName, departmentId, deptName, desgDdoId, desgDdoName,
				digitalSigEnable, distName, districtId, districtName, emailId, employeeName, employeeNo, faxNo, grNo,
				grantRcvngCardex, hodId, hodName, initiatedBy, isCo, isCoName, isFd, isHod, isNewOffice, isSubTreasury,
				isTreasury, isUpdate, isUpdateOffice, isVerified, levelId, levelName, menuShName, mobileNo, moduleId,
				msgFlag, nonDdo, nonDdoTypeName, objRemark, objStatus, objection, objectionRemarks, offStComments,
				officeCode, officeCodeGuj, officeCodeName, officeDivision, officeEndDate, officeId, officeName,
				officeNameAlias, officeNameDisp, officeNameGuj, officePVU, officeRangeId, officeShortName,
				officeShortNameGuj, officeStatus, officeSubType, officeTransferDetails, officeTransferId, officeType,
				officeTypeId, officeTypeName, parentOfficeId, phoneNo, pincode, prvOfficeStatus, prvOfficeStatusId,
				pvuId, pvuName, requestNo, requestTo, requestToName, selectedBills, station, statusId, stdCode,
				talukaId, talukaName, transactionNo, treasuryType, treasuryTypeName, trnId, uniqueId, verifiedDate,
				wfFinalSubmit, wfInRequest, wfRoleId, wfStatus, workFlowId);
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
		if (!(obj instanceof EDPMsOfficeDto)) {
			return false;
		}
		EDPMsOfficeDto other = (EDPMsOfficeDto) obj;
		return Objects.equals(addrLine1, other.addrLine1) && Objects.equals(addrLine2, other.addrLine2)
				&& Objects.equals(addressDescription, other.addressDescription)
				&& Objects.equals(addressDescriptionGuj, other.addressDescriptionGuj)
				&& Objects.equals(billStatus, other.billStatus)
				&& Objects.equals(billSubmittedTo, other.billSubmittedTo) && Objects.equals(billType, other.billType)
				&& Objects.equals(billTypeSelected, other.billTypeSelected) && Objects.equals(cardexno, other.cardexno)
				&& Objects.equals(coDesgName, other.coDesgName) && Objects.equals(coId, other.coId)
				&& Objects.equals(coOfficeName, other.coOfficeName) && Objects.equals(comment, other.comment)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoSubType, other.ddoSubType)
				&& Objects.equals(ddoType, other.ddoType) && Objects.equals(ddoTypeName, other.ddoTypeName)
				&& Objects.equals(departmentId, other.departmentId) && Objects.equals(deptName, other.deptName)
				&& Objects.equals(desgDdoId, other.desgDdoId) && Objects.equals(desgDdoName, other.desgDdoName)
				&& Objects.equals(digitalSigEnable, other.digitalSigEnable) && Objects.equals(distName, other.distName)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeNo, other.employeeNo) && Objects.equals(faxNo, other.faxNo)
				&& Objects.equals(grNo, other.grNo) && Objects.equals(grantRcvngCardex, other.grantRcvngCardex)
				&& Objects.equals(hodId, other.hodId) && Objects.equals(hodName, other.hodName)
				&& Objects.equals(initiatedBy, other.initiatedBy) && Objects.equals(isCo, other.isCo)
				&& Objects.equals(isCoName, other.isCoName) && Objects.equals(isFd, other.isFd)
				&& Objects.equals(isHod, other.isHod) && Objects.equals(isNewOffice, other.isNewOffice)
				&& Objects.equals(isSubTreasury, other.isSubTreasury) && Objects.equals(isTreasury, other.isTreasury)
				&& Objects.equals(isUpdate, other.isUpdate) && Objects.equals(isUpdateOffice, other.isUpdateOffice)
				&& Objects.equals(isVerified, other.isVerified) && Objects.equals(levelId, other.levelId)
				&& Objects.equals(levelName, other.levelName) && Objects.equals(menuShName, other.menuShName)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(moduleId, other.moduleId)
				&& Objects.equals(msgFlag, other.msgFlag) && Objects.equals(nonDdo, other.nonDdo)
				&& Objects.equals(nonDdoTypeName, other.nonDdoTypeName) && Objects.equals(objRemark, other.objRemark)
				&& Objects.equals(objStatus, other.objStatus) && Objects.equals(objection, other.objection)
				&& Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(offStComments, other.offStComments) && Objects.equals(officeCode, other.officeCode)
				&& Objects.equals(officeCodeGuj, other.officeCodeGuj)
				&& Objects.equals(officeCodeName, other.officeCodeName)
				&& Objects.equals(officeDivision, other.officeDivision)
				&& Objects.equals(officeEndDate, other.officeEndDate) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName)
				&& Objects.equals(officeNameAlias, other.officeNameAlias)
				&& Objects.equals(officeNameDisp, other.officeNameDisp)
				&& Objects.equals(officeNameGuj, other.officeNameGuj) && Objects.equals(officePVU, other.officePVU)
				&& Objects.equals(officeRangeId, other.officeRangeId)
				&& Objects.equals(officeShortName, other.officeShortName)
				&& Objects.equals(officeShortNameGuj, other.officeShortNameGuj)
				&& Objects.equals(officeStatus, other.officeStatus)
				&& Objects.equals(officeSubType, other.officeSubType)
				&& Objects.equals(officeTransferDetails, other.officeTransferDetails)
				&& Objects.equals(officeTransferId, other.officeTransferId)
				&& Objects.equals(officeType, other.officeType) && Objects.equals(officeTypeId, other.officeTypeId)
				&& Objects.equals(officeTypeName, other.officeTypeName)
				&& Objects.equals(parentOfficeId, other.parentOfficeId) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(prvOfficeStatus, other.prvOfficeStatus)
				&& Objects.equals(prvOfficeStatusId, other.prvOfficeStatusId) && Objects.equals(pvuId, other.pvuId)
				&& Objects.equals(pvuName, other.pvuName) && Objects.equals(requestNo, other.requestNo)
				&& Objects.equals(requestTo, other.requestTo) && Objects.equals(requestToName, other.requestToName)
				&& Objects.equals(selectedBills, other.selectedBills) && Objects.equals(station, other.station)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(stdCode, other.stdCode)
				&& Objects.equals(talukaId, other.talukaId) && Objects.equals(talukaName, other.talukaName)
				&& Objects.equals(transactionNo, other.transactionNo)
				&& Objects.equals(treasuryType, other.treasuryType)
				&& Objects.equals(treasuryTypeName, other.treasuryTypeName) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(uniqueId, other.uniqueId) && Objects.equals(verifiedDate, other.verifiedDate)
				&& Objects.equals(wfFinalSubmit, other.wfFinalSubmit) && Objects.equals(wfInRequest, other.wfInRequest)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(wfStatus, other.wfStatus)
				&& Objects.equals(workFlowId, other.workFlowId);
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
	 * Gets the hod name.
	 *
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * Gets the co desg name.
	 *
	 * @return the coDesgName
	 */
	public String getCoDesgName() {
		return coDesgName;
	}

	/**
	 * Sets the co desg name.
	 *
	 * @param coDesgName the coDesgName to set
	 */
	public void setCoDesgName(String coDesgName) {
		this.coDesgName = coDesgName;
	}

	/**
	 * Gets the checks if is co name.
	 *
	 * @return the isCoName
	 */
	public String getIsCoName() {
		return isCoName;
	}

	/**
	 * Sets the checks if is co name.
	 *
	 * @param isCoName the isCoName to set
	 */
	public void setIsCoName(String isCoName) {
		this.isCoName = isCoName;
	}

	/**
	 * Gets the menu sh name.
	 *
	 * @return the menuShName
	 */
	public String getMenuShName() {
		return menuShName;
	}

	/**
	 * Sets the menu sh name.
	 *
	 * @param menuShName the menuShName to set
	 */
	public void setMenuShName(String menuShName) {
		this.menuShName = menuShName;
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
	public Long getRequestNo() {
		return requestNo;
	}

	/**
	 * Sets the request no.
	 *
	 * @param requestNo the requestNo to set
	 */
	public void setRequestNo(Long requestNo) {
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
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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
	public Long getIsCo() {
		return isCo;
	}

	/**
	 * Sets the checks if is co.
	 *
	 * @param isCo the isCo to set
	 */
	public void setIsCo(Long isCo) {
		this.isCo = isCo;
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
	 * Gets the checks if is new office.
	 *
	 * @return the isNewOffice
	 */
	public Boolean getIsNewOffice() {
		return isNewOffice;
	}

	/**
	 * Sets the checks if is new office.
	 *
	 * @param isNewOffice the isNewOffice to set
	 */
	public void setIsNewOffice(Boolean isNewOffice) {
		this.isNewOffice = isNewOffice;
	}

	/**
	 * Checks if is update office.
	 *
	 * @return the isUpdateOffice
	 */
	public Boolean isUpdateOffice() {
		return isUpdateOffice;
	}

	/**
	 * Gets the bill submitted to.
	 *
	 * @return the billSubmittedTo
	 */
	public Long getBillSubmittedTo() {
		return billSubmittedTo;
	}

	/**
	 * Sets the bill submitted to.
	 *
	 * @param billSubmittedTo the billSubmittedTo to set
	 */
	public void setBillSubmittedTo(Long billSubmittedTo) {
		this.billSubmittedTo = billSubmittedTo;
	}

	/**
	 * Gets the bill type.
	 *
	 * @return the billType
	 */
	public Long getBillType() {
		return billType;
	}

	/**
	 * Sets the bill type.
	 *
	 * @param billType the billType to set
	 */
	public void setBillType(Long billType) {
		this.billType = billType;
	}

	/**
	 * Gets the bill type selected.
	 *
	 * @return the billTypeSelected
	 */
	public Long getBillTypeSelected() {
		return billTypeSelected;
	}

	/**
	 * Sets the bill type selected.
	 *
	 * @param billTypeSelected the billTypeSelected to set
	 */
	public void setBillTypeSelected(Long billTypeSelected) {
		this.billTypeSelected = billTypeSelected;
	}

	/**
	 * Gets the bill status.
	 *
	 * @return the billStatus
	 */
	public Long getBillStatus() {
		return billStatus;
	}

	/**
	 * Sets the bill status.
	 *
	 * @param billStatus the billStatus to set
	 */
	public void setBillStatus(Long billStatus) {
		this.billStatus = billStatus;
	}

	/**
	 * Gets the selected bills.
	 *
	 * @return the selectedBills
	 */
	public Set<Long> getSelectedBills() {
		return selectedBills;
	}

	/**
	 * Sets the selected bills.
	 *
	 * @param selectedBills the selectedBills to set
	 */
	public void setSelectedBills(Set<Long> selectedBills) {
		this.selectedBills = selectedBills;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the moduleId
	 */
	public List<Long> getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(List<Long> moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the office type.
	 *
	 * @return the officeType
	 */
	public String getOfficeType() {
		return officeType;
	}

	/**
	 * Sets the office type.
	 *
	 * @param officeType the officeType to set
	 */
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
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
	 * Gets the dist name.
	 *
	 * @return the distName
	 */
	public String getDistName() {
		return distName;
	}

	/**
	 * Sets the dist name.
	 *
	 * @param distName the distName to set
	 */
	public void setDistName(String distName) {
		this.distName = distName;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Gets the office type name.
	 *
	 * @return the officeTypeName
	 */
	public String getOfficeTypeName() {
		return officeTypeName;
	}

	/**
	 * Sets the office type name.
	 *
	 * @param officeTypeName the officeTypeName to set
	 */
	public void setOfficeTypeName(String officeTypeName) {
		this.officeTypeName = officeTypeName;
	}

	/**
	 * Gets the level name.
	 *
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Sets the level name.
	 *
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * Gets the ddo type name.
	 *
	 * @return the ddoTypeName
	 */
	public String getDdoTypeName() {
		return ddoTypeName;
	}

	/**
	 * Sets the ddo type name.
	 *
	 * @param ddoTypeName the ddoTypeName to set
	 */
	public void setDdoTypeName(String ddoTypeName) {
		this.ddoTypeName = ddoTypeName;
	}

	/**
	 * Gets the non ddo type name.
	 *
	 * @return the nonDdoTypeName
	 */
	public String getNonDdoTypeName() {
		return nonDdoTypeName;
	}

	/**
	 * Sets the non ddo type name.
	 *
	 * @param nonDdoTypeName the nonDdoTypeName to set
	 */
	public void setNonDdoTypeName(String nonDdoTypeName) {
		this.nonDdoTypeName = nonDdoTypeName;
	}

	/**
	 * Gets the pvu name.
	 *
	 * @return the pvuName
	 */
	public String getPvuName() {
		return pvuName;
	}

	/**
	 * Sets the pvu name.
	 *
	 * @param pvuName the pvuName to set
	 */
	public void setPvuName(String pvuName) {
		this.pvuName = pvuName;
	}

	/**
	 * Gets the desg ddo name.
	 *
	 * @return the desgDdoName
	 */
	public String getDesgDdoName() {
		return desgDdoName;
	}

	/**
	 * Sets the desg ddo name.
	 *
	 * @param desgDdoName the desgDdoName to set
	 */
	public void setDesgDdoName(String desgDdoName) {
		this.desgDdoName = desgDdoName;
	}

	/**
	 * Gets the request to name.
	 *
	 * @return the requestToName
	 */
	public String getRequestToName() {
		return requestToName;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Sets the request to name.
	 *
	 * @param requestToName the requestToName to set
	 */
	public void setRequestToName(String requestToName) {
		this.requestToName = requestToName;
	}

	/**
	 * Gets the treasury type name.
	 *
	 * @return the treasuryTypeName
	 */
	public String getTreasuryTypeName() {
		return treasuryTypeName;
	}

	/**
	 * Sets the treasury type name.
	 *
	 * @param treasuryTypeName the treasuryTypeName to set
	 */
	public void setTreasuryTypeName(String treasuryTypeName) {
		this.treasuryTypeName = treasuryTypeName;
	}

	/**
	 * Gets the taluka name.
	 *
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * Sets the taluka name.
	 *
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
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
	 * Gets the prv office status id.
	 *
	 * @return the prvOfficeStatusId
	 */
	public Long getPrvOfficeStatusId() {
		return prvOfficeStatusId;
	}

	/**
	 * Sets the prv office status id.
	 *
	 * @param prvOfficeStatusId the prvOfficeStatusId to set
	 */
	public void setPrvOfficeStatusId(Long prvOfficeStatusId) {
		this.prvOfficeStatusId = prvOfficeStatusId;
	}

	/**
	 * Gets the prv office status.
	 *
	 * @return the prvOfficeStatus
	 */
	public String getPrvOfficeStatus() {
		return prvOfficeStatus;
	}

	/**
	 * Sets the prv office status.
	 *
	 * @param prvOfficeStatus the prvOfficeStatus to set
	 */
	public void setPrvOfficeStatus(String prvOfficeStatus) {
		this.prvOfficeStatus = prvOfficeStatus;
	}

	/**
	 * Gets the msg flag.
	 *
	 * @return the isMsgFlag
	 */
	public Boolean getMsgFlag() {
		return msgFlag;
	}

	/**
	 * Sets the msg flag.
	 *
	 * @param msgFlag the new msg flag
	 */
	public void setMsgFlag(Boolean msgFlag) {
		this.msgFlag = msgFlag;
	}

	/**
	 * Sets the checks if is update office.
	 *
	 * @param isUpdateOffice the new checks if is update office
	 */
	public void setUpdateOffice(Boolean isUpdateOffice) {
		this.isUpdateOffice = isUpdateOffice;
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

	public Long getWfFinalSubmit() {
		return wfFinalSubmit;
	}

	public void setWfFinalSubmit(Long wfFinalSubmit) {
		this.wfFinalSubmit = wfFinalSubmit;
	}

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
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
	 * @return the officeTransferDetails
	 */
	public EDPOfficeTransferDetails getOfficeTransferDetails() {
		return officeTransferDetails;
	}

	/**
	 * @param officeTransferDetails the officeTransferDetails to set
	 */
	public void setOfficeTransferDetails(EDPOfficeTransferDetails officeTransferDetails) {
		this.officeTransferDetails = officeTransferDetails;
	}

	/**
	 * @return the subTypeId
	 */
	public Long getSubTypeId() {
		return subTypeId;
	}

	/**
	 * @param subTypeId the subTypeId to set
	 */
	public void setSubTypeId(Long subTypeId) {
		this.subTypeId = subTypeId;
	}
}
