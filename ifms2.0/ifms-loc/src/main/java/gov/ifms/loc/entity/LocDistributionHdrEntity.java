package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocDistributionHdrEntity.
 */
@Entity
@Table(name = "TLOC_DISTRIBUTION_HDR", schema = LocDBConstants.LOC_SCHEMA)
public class LocDistributionHdrEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_TRANSACTION_ID")
	private Long id;

	/**
	 * The ref no.
	 */
	@Column(name = "REFERENCE_NO")
	private String refNo;

	/**
	 * The ref date.
	 */
	@Column(name = "REFERENCE_DT")
	private Date refDate;

	/**
	 * The lc no.
	 */
	@Column(name = "LC_NO")
	private String lcNo;

	/**
	 * The entry type.
	 */
	@Column(name = "ENTRY_TYPE")
	private String entryType;

	/**
	 * The grant id.
	 */
	@Column(name = "GRANT_ID")
	private Long grantId;

	/**
	 * The grant order date.
	 */
	@Column(name = "GRANT_ORDER_DATE")
	private Date grantOrderDate;

	/**
	 * The lc issue date.
	 */
	@Column(name = "LC_ISSUE_DATE")
	private Date lcIssueDate;

	/**
	 * The lc valid from.
	 */
	@Column(name = "LC_VALID_FROM")
	private Date lcValidFrom;

	/**
	 * The lc valid to.
	 */
	@Column(name = "LC_VALID_TO")
	private Date lcValidTo;

	/**
	 * The inward no.
	 */
	@Column(name = "INWARD_NO")
	private String inwardNo;

	/**
	 * The grant order no.
	 */
	@Column(name = "GRANT_ORDER_NO")
	private String grantOrderNo;

	/**
	 * The inward date.
	 */
	@Column(name = "INWARD_DT")
	private Date inwardDate;

	/**
	 * The party ref no.
	 */
	@Column(name = "PARTY_REFERENCE_NO")
	private String partyRefNo;

	/**
	 * The raise obj flag.
	 */
	@Column(name = "RAISE_OBJECTION_FLAG")
	private String raiseObjFlag;

	/**
	 * The obj remarks.
	 */
	@Column(name = "OBJECTION_REMARKS")
	private String objRemarks;

	/**
	 * The status id.
	 */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * The status desc.
	 */
	@Column(name = "STATUS_DESCRIPTION")
	private String statusDesc;

	/**
	 * The div id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVISION_ID", referencedColumnName = "DIVISION_ID")
	private LocMsDivisonEntity divId;

	/**
	 * The circle id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIRCLE_ID", referencedColumnName = "CIRCLE_ID")
	private LocMsCircleEntity circleId;

	/**
	 * The balance lc amt.
	 */
	@Column(name = "BALANCE_LC_AMT")
	private Double balanceLcAmt;

	/**
	 * The new balance lc amt.
	 */
	@Column(name = "NEW_BALANCE_LC_AMT")
	private Double newBalanceLcAmt;

	/**
	 * The wf id.
	 */
	@Column(name = "WF_ID")
	private Long wfId;

	/**
	 * The wf role id.
	 */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * The fin year.
	 */
	@Column(name = "FINCIAL_YR")
	private Long finYear;

	/**
	 * The office id.
	 */
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/**
	 * The cardex no.
	 */
	@Column(name = "CARDEX_NO")
	private String cardexNo;

	/**
	 * The ddo no.
	 */
	@Column(name = "DDO_NO")
	private String ddoNo;

	/**
	 * The g status.
	 */
	@Column(name = "GSTATUS")
	private String gStatus;

	/** The party ref date. */
	@Column(name = "PARTY_REFERENCE_DATE")
	private Date partyRefDate;

	/**
	 * Instantiates a new loc distribution hdr entity.
	 *
	 * @param id the id
	 */
	public LocDistributionHdrEntity(Long id) {
		this.id = id;
	}

	/**
	 * LocDistributionHdrEntity Constructor.
	 */
	public LocDistributionHdrEntity() {
		super();
	}

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
	 * @return the status desc
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
	 * Gets the serial version UID.
	 *
	 * @return the serial version UID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public LocMsDivisonEntity getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(LocMsDivisonEntity divId) {
		this.divId = divId;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circle id
	 */
	public LocMsCircleEntity getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the new circle id
	 */
	public void setCircleId(LocMsCircleEntity circleId) {
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
	public String getGStatus() {
		return gStatus;
	}

	/**
	 * Sets the g status.
	 *
	 * @param gStatus the gStatus to set
	 */
	public void setGStatus(String gStatus) {
		this.gStatus = gStatus;
	}

	/**
	 * Gets the grant order no.
	 *
	 * @return the grant order no
	 */
	public String getGrantOrderNo() {
		return grantOrderNo;
	}

	/**
	 * Sets the grant order no.
	 *
	 * @param grantOrderNo the new grant order no
	 */
	public void setGrantOrderNo(String grantOrderNo) {
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
