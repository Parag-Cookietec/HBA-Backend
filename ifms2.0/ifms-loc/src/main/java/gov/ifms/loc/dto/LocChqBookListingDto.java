package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqBookListingDto.
 */
@NativeQueryResultEntity
public class LocChqBookListingDto implements Serializable {

	/** The status. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;

	/** The div code. */
	@NativeQueryResultColumn(index = 1)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 2)
	private String divName;

	/** The ref no. */
	@NativeQueryResultColumn(index = 3)
	private String refNo;

	/** The ref date. */
	@NativeQueryResultColumn(index = 4)
	private Date refDate;

	/** The req type. */
	@NativeQueryResultColumn(index = 5)
	private String reqTypeName;
	/** The req type. */
	@NativeQueryResultColumn(index = 6)
	private Long reqTypeId;

	/** The received from. */
	@NativeQueryResultColumn(index = 7)
	private String receivedFromName;

	/** The received date. */
	@NativeQueryResultColumn(index = 8)
	private String receivedDate;

	/** The sent to. */
	@NativeQueryResultColumn(index = 9)
	private String sentToName;

	/** The sent date. */
	@NativeQueryResultColumn(index = 10)
	private String sentDate;

	/** The lying with. */
	@NativeQueryResultColumn(index = 11)
	private String lyingWith;

	/** The status. */
	@NativeQueryResultColumn(index = 12)
	private String status;
	/** The wf status. */
	@NativeQueryResultColumn(index = 13)
	private String wfStatus;

	/** The is editable. */
	@NativeQueryResultColumn(index = 14)
	private Long isEditable;

	/** The total records. */
	@NativeQueryResultColumn(index = 15)
	private Long totalRecords;

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
	 * Gets the req type name.
	 *
	 * @return the req type name
	 */
	public String getReqTypeName() {
		return reqTypeName;
	}

	/**
	 * Sets the req type name.
	 *
	 * @param reqTypeName the new req type name
	 */
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	/**
	 * Gets the req type id.
	 *
	 * @return the req type id
	 */
	public Long getReqTypeId() {
		return reqTypeId;
	}

	/**
	 * Sets the req type id.
	 *
	 * @param reqTypeId the new req type id
	 */
	public void setReqTypeId(Long reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	/**
	 * Gets the received from name.
	 *
	 * @return the received from name
	 */
	public String getReceivedFromName() {
		return receivedFromName;
	}

	/**
	 * Sets the received from name.
	 *
	 * @param receivedFromName the new received from name
	 */
	public void setReceivedFromName(String receivedFromName) {
		this.receivedFromName = receivedFromName;
	}

	/**
	 * Gets the received date.
	 *
	 * @return the received date
	 */
	public String getReceivedDate() {
		return receivedDate;
	}

	/**
	 * Sets the received date.
	 *
	 * @param receivedDate the new received date
	 */
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	/**
	 * Gets the sent to name.
	 *
	 * @return the sent to name
	 */
	public String getSentToName() {
		return sentToName;
	}

	/**
	 * Sets the sent to name.
	 *
	 * @param sentToName the new sent to name
	 */
	public void setSentToName(String sentToName) {
		this.sentToName = sentToName;
	}

	/**
	 * Gets the sent date.
	 *
	 * @return the sent date
	 */
	public String getSentDate() {
		return sentDate;
	}

	/**
	 * Sets the sent date.
	 *
	 * @param sentDate the new sent date
	 */
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * Gets the total records.
	 *
	 * @return the total records
	 */
	public Long getTotalRecords() {
		return totalRecords;
	}

	/**
	 * Sets the total records.
	 *
	 * @param totalRecords the new total records
	 */
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
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
}
