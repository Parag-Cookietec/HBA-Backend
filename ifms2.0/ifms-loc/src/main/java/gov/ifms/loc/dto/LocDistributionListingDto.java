package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class LocDistributionListingDto.
 */
@NativeQueryResultEntity
public class LocDistributionListingDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The ref no.
	 */
	@NativeQueryResultColumn(index = 0)
	private String refNo;

	/**
	 * The div id.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long divId;

	/**
	 * The ref Date.
	 */
	@NativeQueryResultColumn(index = 2)
	private Date refDate;

	/**
	 * The div name.
	 */
	@NativeQueryResultColumn(index = 3)
	private String divName;

	/**
	 * The div Code.
	 */
	@NativeQueryResultColumn(index = 4)
	private String divCode;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 5)
	private Long hdrId;

	/**
	 * The authorized Date.
	 */
	@NativeQueryResultColumn(index = 6)
	private Date authorizedDate;

	/**
	 * The lc number.
	 */
	@NativeQueryResultColumn(index = 7)
	private String lcNumber;

	/**
	 * The entry type.
	 */
	@NativeQueryResultColumn(index = 8)
	private String entryType;

	/**
	 * The lc amount.
	 */
	@NativeQueryResultColumn(index = 9)
	private Double lcAmount;

	/**
	 * The lc issue date.
	 */
	@NativeQueryResultColumn(index = 10)
	private Date lcIssueDate;

	/**
	 * The rec from user id.
	 */
	@NativeQueryResultColumn(index = 11)
	private String recFromUserName;

	/**
	 * The rec on date.
	 */
	@NativeQueryResultColumn(index = 12)
	private String recOnDate;

	/**
	 * The sent to user id.
	 */
	@NativeQueryResultColumn(index = 13)
	private String sendToUserName;

	/**
	 * The sent on date.
	 */
	@NativeQueryResultColumn(index = 14)
	private String sentOnDate;

	
	/**
	 * The lying with.
	 */
	@NativeQueryResultColumn(index = 15)
	private String lyingWith;

	/**
	 * The trn status.
	 */
	@NativeQueryResultColumn(index = 16)
	private String trnStatus;

	/**
	 * The wf status.
	 */
	@NativeQueryResultColumn(index = 17)
	private String wfStatus;

	/**
	 * The is editable.
	 */
	@NativeQueryResultColumn(index = 18)
	private Long isEditable;

	/**
	 * The total rec.
	 */
	@NativeQueryResultColumn(index = 19)
	private Long totalRec;

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
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the div name
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the new div name
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the lc number.
	 *
	 * @return the lc number
	 */
	public String getLcNumber() {
		return lcNumber;
	}

	/**
	 * Sets the lc number.
	 *
	 * @param lcNumber the new lc number
	 */
	public void setLcNumber(String lcNumber) {
		this.lcNumber = lcNumber;
	}

	/**
	 * Gets the entry type.
	 *
	 * @return the entry type
	 */
	public String getEntryType() {
		return entryType;
	}

	/**
	 * Sets the entry type.
	 *
	 * @param entryType the new entry type
	 */
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	/**
	 * Gets the lc amount.
	 *
	 * @return the lc amount
	 */
	public Double getLcAmount() {
		return lcAmount;
	}

	/**
	 * Sets the lc amount.
	 *
	 * @param lcAmount the new lc amount
	 */
	public void setLcAmount(Double lcAmount) {
		this.lcAmount = lcAmount;
	}

	/**
	 * Gets the lc issue date.
	 *
	 * @return the lc issue date
	 */
	public Date getLcIssueDate() {
		return lcIssueDate;
	}

	/**
	 * Sets the lc issue date.
	 *
	 * @param lcIssueDate the new lc issue date
	 */
	public void setLcIssueDate(Date lcIssueDate) {
		this.lcIssueDate = lcIssueDate;
	}



	/**
	 * Gets the rec on date.
	 *
	 * @return the rec on date
	 */
	public String getRecOnDate() {
		return recOnDate;
	}

	/**
	 * Sets the rec on date.
	 *
	 * @param recOnDate the new rec on date
	 */
	public void setRecOnDate(String recOnDate) {
		this.recOnDate = recOnDate;
	}



	

	/**
	 * Gets the sent on date.
	 *
	 * @return the sent on date
	 */
	public String getSentOnDate() {
		return sentOnDate;
	}

	/**
	 * Sets the sent on date.
	 *
	 * @param sentOnDate the new sent on date
	 */
	public void setSentOnDate(String sentOnDate) {
		this.sentOnDate = sentOnDate;
	}

	/**
	 * Gets the rec from user name.
	 *
	 * @return the rec from user name
	 */
	public String getRecFromUserName() {
		return recFromUserName;
	}

	/**
	 * Sets the rec from user name.
	 *
	 * @param recFromUserName the new rec from user name
	 */
	public void setRecFromUserName(String recFromUserName) {
		this.recFromUserName = recFromUserName;
	}

	/**
	 * Gets the send to user name.
	 *
	 * @return the send to user name
	 */
	public String getSendToUserName() {
		return sendToUserName;
	}

	/**
	 * Sets the send to user name.
	 *
	 * @param sendToUserName the new send to user name
	 */
	public void setSendToUserName(String sendToUserName) {
		this.sendToUserName = sendToUserName;
	}

	/**
	 * Gets the lying with.
	 *
	 * @return the lying with
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * Sets the lying with.
	 *
	 * @param lyingWith the new lying with
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * Gets the trn status.
	 *
	 * @return the trn status
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets the trn status.
	 *
	 * @param trnStatus the new trn status
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
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
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public Long getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the total rec.
	 *
	 * @return the total rec
	 */
	public Long getTotalRec() {
		return totalRec;
	}

	/**
	 * Sets the total rec.
	 *
	 * @param totalRec the new total rec
	 */
	public void setTotalRec(Long totalRec) {
		this.totalRec = totalRec;
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
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

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
	 * Gets the authorized date.
	 *
	 * @return the authorized date
	 */
	public Date getAuthorizedDate() {
		return authorizedDate;
	}

	/**
	 * Sets the authorized date.
	 *
	 * @param authorizedDate the new authorized date
	 */
	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}

	/**
	 * Instantiates a new loc distribution listing dto.
	 */
	public LocDistributionListingDto() {
		super();
	}
}
