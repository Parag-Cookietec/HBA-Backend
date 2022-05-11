package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

/**
 * The Class LocDistributionSubmitDto.
 */
public class LocDistributionSubmitDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The hdr id.
	 */
	private Long hdrId;

	/**
	 * The inward no.
	 */
	private String inwardNo;

	/**
	 * The inward date.
	 */
	private Date inwardDate;

	/**
	 * The party ref no.
	 */
	private String partyRefNo;

	/**
	 * The party ref date.
	 */
	private Date partyRefDate;

	/**
	 * The raise obj flag.
	 */
	private String raiseObjFlag;

	/**
	 * The obj remarks.
	 */
	private String objRemarks;

	/**
	 * The office id.
	 */
	private Long officeId;

	/**
	 * The cardex no.
	 */
	private String cardexNo;

	/**
	 * The ddo no.
	 */
	private String ddoNo;

	/**
	 * The wfuser req dto.
	 */
	private WfUserReqSDDto wfuserReqDto;

	/** The ref date. */
	private Date refDate;

	/** The ref no. */
	private String refNo;

	/** The status. */
	private String trnStatus;

	/** The new balance Amount. */
	private Double newBalAmt;
	
	/** The assign by wf role id. */
	private Long assignByWfRoleId;

	/** The assign to wf role id. */
	private Long assignToWfRoleId;

	/** The assign by branch id. */
	private Long assignByBranchId;

	/** The wf action id. */
	private Long wfActionId;

	/** The wf action id. */
	private Long assignByOfficeId;

	/** The menuId . */
	private Long menuId;

	/** The assigntoPouId . */
	private Long assignToPouId;

	/** The assigntoPouId . */
	private Long assignToOfficeId;

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the inward no.
	 *
	 * @return the inward no
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets the inward no.
	 *
	 * @param inwardNo the new inward no
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inward date
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the new inward date
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the party ref no.
	 *
	 * @return the party ref no
	 */
	public String getPartyRefNo() {
		return partyRefNo;
	}

	/**
	 * Sets the party ref no.
	 *
	 * @param partyRefNo the new party ref no
	 */
	public void setPartyRefNo(String partyRefNo) {
		this.partyRefNo = partyRefNo;
	}

	/**
	 * Gets the party ref date.
	 *
	 * @return the party ref date
	 */
	public Date getPartyRefDate() {
		return partyRefDate;
	}

	/**
	 * Sets the party ref date.
	 *
	 * @param partyRefDate the new party ref date
	 */
	public void setPartyRefDate(Date partyRefDate) {
		this.partyRefDate = partyRefDate;
	}

	/**
	 * Gets the raise obj flag.
	 *
	 * @return the raise obj flag
	 */
	public String getRaiseObjFlag() {
		return raiseObjFlag;
	}

	/**
	 * Sets the raise obj flag.
	 *
	 * @param raiseObjFlag the new raise obj flag
	 */
	public void setRaiseObjFlag(String raiseObjFlag) {
		this.raiseObjFlag = raiseObjFlag;
	}

	/**
	 * Gets the obj remarks.
	 *
	 * @return the obj remarks
	 */
	public String getObjRemarks() {
		return objRemarks;
	}

	/**
	 * Sets the obj remarks.
	 *
	 * @param objRemarks the new obj remarks
	 */
	public void setObjRemarks(String objRemarks) {
		this.objRemarks = objRemarks;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(String cardexNo) {
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
	 * Gets the wfuser req dto.
	 *
	 * @return the wfuser req dto
	 */
	public WfUserReqSDDto getWfuserReqDto() {
		return wfuserReqDto;
	}

	/**
	 * Sets the wfuser req dto.
	 *
	 * @param wfuserReqDto the new wfuser req dto
	 */
	public void setWfuserReqDto(WfUserReqSDDto wfuserReqDto) {
		this.wfuserReqDto = wfuserReqDto;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the ref no
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the new ref no
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public Double getNewBalAmt() {
		return newBalAmt;
	}

	public void setNewBalAmt(Double newBalAmt) {
		this.newBalAmt = newBalAmt;
	}

	/**
	 * @return the assignByWfRoleId
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * @return the assignToWfRoleId
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * @return the assignByBranchId
	 */
	public Long getAssignByBranchId() {
		return assignByBranchId;
	}

	/**
	 * @param assignByBranchId the assignByBranchId to set
	 */
	public void setAssignByBranchId(Long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	/**
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the assignByOfficeId
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the assignToPouId
	 */
	public Long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * @param assignToPouId the assignToPouId to set
	 */
	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * @return the assignToOfficeId
	 */
	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * @param assignToOfficeId the assignToOfficeId to set
	 */
	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}
	

}
