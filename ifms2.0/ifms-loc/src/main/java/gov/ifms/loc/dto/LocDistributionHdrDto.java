package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocDistributionHdrDto.
 *
 * @version v 1.0
 * @created 2021/02/11 14:33:34
 */
public class LocDistributionHdrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NotNull
	private Long id;

	/**
	 * The ref no.
	 */
	@NotNull
	private String refNo;

	/**
	 * The ref date.
	 */
	@NotNull
	private Date refDate;

	/**
	 * The lc no.
	 */
	@NotNull
	private String lcNo;

	/**
	 * The entry type.
	 */
	@NotNull
	private String entryType;

	/**
	 * The grant id.
	 */
	@NotNull
	private Long grantId;

	/**
	 * The grant order date.
	 */
	@NotNull
	private Date grantOrderDate;

	/**
	 * The grant order no.
	 */
	private Date grantOrderNo;
	/**
	 * The lc issue date.
	 */
	@NotNull
	private Date lcIssueDate;

	/**
	 * The lc valid from.
	 */
	@NotNull
	private Date lcValidFrom;

	/**
	 * The lc valid to.
	 */
	@NotNull
	private Date lcValidTo;

	/**
	 * The inward no.
	 */
	@NotNull
	private String inwardNo;

	/**
	 * The inward date.
	 */
	@NotNull
	private Date inwardDate;

	/**
	 * The party ref no.
	 */
	@NotNull
	private String partyRefNo;

	/**
	 * The party ref date.
	 */
	private Date partyRefDate;

	/**
	 * The raise obj flag.
	 */
	@NotNull
	private String raiseObjFlag;

	/**
	 * The obj remarks.
	 */
	@NotNull
	private String objRemarks;

	/**
	 * The status id.
	 */
	@NotNull
	private Long statusId;

	/**
	 * The status desc.
	 */
	@NotNull
	private String statusDesc;

	/**
	 * The div id.
	 */
	@NotNull
	private Long divId;

	/**
	 * The circle id.
	 */
	@NotNull
	private Long circleId;

	/**
	 * The balance lc amt.
	 */
	@NotNull
	private Double balanceLcAmt;

	/**
	 * The new balance lc amt.
	 */
	@NotNull
	private Double newBalanceLcAmt;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The fin year.
	 */
	private Long finYear;

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
	 * The g status.
	 */
	private String gStatus;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the lc no.
	 *
	 * @return the lcNo
	 */
	public String getLcNo() {
		return lcNo;
	}

	/**
	 * Sets the lc no.
	 *
	 * @param lcNo the lcNo to set
	 */
	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	/**
	 * Gets the entry type.
	 *
	 * @return the entryType
	 */
	public String getEntryType() {
		return entryType;
	}

	/**
	 * Sets the entry type.
	 *
	 * @param entryType the entryType to set
	 */
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	/**
	 * Gets the grant id.
	 *
	 * @return the grantId
	 */
	public Long getGrantId() {
		return grantId;
	}

	/**
	 * Sets the grant id.
	 *
	 * @param grantId the grantId to set
	 */
	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}

	/**
	 * Gets the grant order date.
	 *
	 * @return the grantOrderDate
	 */
	public Date getGrantOrderDate() {
		return grantOrderDate;
	}

	/**
	 * Sets the grant order date.
	 *
	 * @param grantOrderDate the grantOrderDate to set
	 */
	public void setGrantOrderDate(Date grantOrderDate) {
		this.grantOrderDate = grantOrderDate;
	}

	/**
	 * Gets the lc issue date.
	 *
	 * @return the lcIssueDate
	 */
	public Date getLcIssueDate() {
		return lcIssueDate;
	}

	/**
	 * Sets the lc issue date.
	 *
	 * @param lcIssueDate the lcIssueDate to set
	 */
	public void setLcIssueDate(Date lcIssueDate) {
		this.lcIssueDate = lcIssueDate;
	}

	/**
	 * Gets the lc valid from.
	 *
	 * @return the lcValidFrom
	 */
	public Date getLcValidFrom() {
		return lcValidFrom;
	}

	/**
	 * Sets the lc valid from.
	 *
	 * @param lcValidFrom the lcValidFrom to set
	 */
	public void setLcValidFrom(Date lcValidFrom) {
		this.lcValidFrom = lcValidFrom;
	}

	/**
	 * Gets the lc valid to.
	 *
	 * @return the lcValidTo
	 */
	public Date getLcValidTo() {
		return lcValidTo;
	}

	/**
	 * Sets the lc valid to.
	 *
	 * @param lcValidTo the lcValidTo to set
	 */
	public void setLcValidTo(Date lcValidTo) {
		this.lcValidTo = lcValidTo;
	}

	/**
	 * Gets the inward no.
	 *
	 * @return the inwardNo
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets the inward no.
	 *
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inwardDate
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the inwardDate to set
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the party ref no.
	 *
	 * @return the partyRefNo
	 */
	public String getPartyRefNo() {
		return partyRefNo;
	}

	/**
	 * Sets the party ref no.
	 *
	 * @param partyRefNo the partyRefNo to set
	 */
	public void setPartyRefNo(String partyRefNo) {
		this.partyRefNo = partyRefNo;
	}

	/**
	 * Gets the raise obj flag.
	 *
	 * @return the raiseObjFlag
	 */
	public String getRaiseObjFlag() {
		return raiseObjFlag;
	}

	/**
	 * Sets the raise obj flag.
	 *
	 * @param raiseObjFlag the raiseObjFlag to set
	 */
	public void setRaiseObjFlag(String raiseObjFlag) {
		this.raiseObjFlag = raiseObjFlag;
	}

	/**
	 * Gets the obj remarks.
	 *
	 * @return the objRemarks
	 */
	public String getObjRemarks() {
		return objRemarks;
	}

	/**
	 * Sets the obj remarks.
	 *
	 * @param objRemarks the objRemarks to set
	 */
	public void setObjRemarks(String objRemarks) {
		this.objRemarks = objRemarks;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status desc.
	 *
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Sets the status desc.
	 *
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the divId
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the balance lc amt.
	 *
	 * @return the balanceLcAmt
	 */
	public Double getBalanceLcAmt() {
		return balanceLcAmt;
	}

	/**
	 * Sets the balance lc amt.
	 *
	 * @param balanceLcAmt the balanceLcAmt to set
	 */
	public void setBalanceLcAmt(Double balanceLcAmt) {
		this.balanceLcAmt = balanceLcAmt;
	}

	/**
	 * Gets the new balance lc amt.
	 *
	 * @return the newBalanceLcAmt
	 */
	public Double getNewBalanceLcAmt() {
		return newBalanceLcAmt;
	}

	/**
	 * Sets the new balance lc amt.
	 *
	 * @param newBalanceLcAmt the newBalanceLcAmt to set
	 */
	public void setNewBalanceLcAmt(Double newBalanceLcAmt) {
		this.newBalanceLcAmt = newBalanceLcAmt;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
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
	 * Gets the fin year.
	 *
	 * @return the finYear
	 */
	public Long getFinYear() {
		return finYear;
	}

	/**
	 * Sets the fin year.
	 *
	 * @param finYear the finYear to set
	 */
	public void setFinYear(Long finYear) {
		this.finYear = finYear;
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
	 * Gets the g status.
	 *
	 * @return the gStatus
	 */
	public String getgStatus() {
		return gStatus;
	}

	/**
	 * Sets the g status.
	 *
	 * @param gStatus the gStatus to set
	 */
	public void setgStatus(String gStatus) {
		this.gStatus = gStatus;
	}

	/**
	 * Gets the grant order no.
	 *
	 * @return the grant order no
	 */
	public Date getGrantOrderNo() {
		return grantOrderNo;
	}

	/**
	 * Sets the grant order no.
	 *
	 * @param grantOrderNo the new grant order no
	 */
	public void setGrantOrderNo(Date grantOrderNo) {
		this.grantOrderNo = grantOrderNo;
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

}
