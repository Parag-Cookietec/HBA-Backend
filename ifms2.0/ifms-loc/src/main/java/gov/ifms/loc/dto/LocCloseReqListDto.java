package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocCloseReqListDto.
 */
@NativeQueryResultEntity
public class LocCloseReqListDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The ref no.
	 */
	@NativeQueryResultColumn(index = 0)
	private String refNo;

	/**
	 * The ref date.
	 */
	@NativeQueryResultColumn(index = 1)
	private Date refDate;

	/**
	 * The office name.
	 */
	@NativeQueryResultColumn(index = 2)
	private String officeName;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 3)
	private Long hdrId;

	/** The div id. */
	@NativeQueryResultColumn(index = 4)
	private Long divId;

	/** The div code. */
	@NativeQueryResultColumn(index = 5)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 6)
	private String divName;

	/** The circle id. */
	@NativeQueryResultColumn(index = 7)
	private Long circleId;

	/** The circle code. */
	@NativeQueryResultColumn(index = 8)
	private String circleCode;

	/** The circle name. */
	@NativeQueryResultColumn(index = 9)
	private String circleName;

	/**
	 * The cardex no.
	 */
	@NativeQueryResultColumn(index = 10)
	private Long cardexNo;

	/**
	 * The ddo no.
	 */
	@NativeQueryResultColumn(index = 11)
	private Long ddoNo;

	/**
	 * The received from.
	 */
	@NativeQueryResultColumn(index = 12)
	private String receivedFrom;

	/**
	 * The received date.
	 */
	@NativeQueryResultColumn(index = 13)
	private String receivedDate;

	/**
	 * The send to.
	 */
	@NativeQueryResultColumn(index = 14)
	private String sendTo;

	/**
	 * The send on date.
	 */
	@NativeQueryResultColumn(index = 15)
	private String sendOnDate;

	/**
	 * The lying with.
	 */
	@NativeQueryResultColumn(index = 16)
	private String lyingWith;

	/**
	 * The is editable.
	 */
	@NativeQueryResultColumn(index = 17)
	private Long isEditable;

	/**
	 * The record count.
	 */
	@NativeQueryResultColumn(index = 18)
	private Long recordCount;

	/**
	 * The wf status.
	 */
	@NativeQueryResultColumn(index = 19)
	private String wfStatus;

	/**
	 * The status.
	 */
	@NativeQueryResultColumn(index = 20)
	private String status;

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
	 * Gets the div code.
	 *
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the divName
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the divName to set
	 */
	public void setDivName(String divName) {
		this.divName = divName;
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
	 * Gets the circle code.
	 *
	 * @return the circleCode
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circleName
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the circleName to set
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
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
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the received from.
	 *
	 * @return the receivedFrom
	 */
	public String getReceivedFrom() {
		return receivedFrom;
	}

	/**
	 * Sets the received from.
	 *
	 * @param receivedFrom the receivedFrom to set
	 */
	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	/**
	 * Gets the received date.
	 *
	 * @return the receivedDate
	 */
	public String getReceivedDate() {
		return receivedDate;
	}

	/**
	 * Sets the received date.
	 *
	 * @param receivedDate the receivedDate to set
	 */
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	/**
	 * Gets the send to.
	 *
	 * @return the sendTo
	 */
	public String getSendTo() {
		return sendTo;
	}

	/**
	 * Sets the send to.
	 *
	 * @param sendTo the sendTo to set
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	/**
	 * Gets the send on date.
	 *
	 * @return the sendOnDate
	 */
	public String getSendOnDate() {
		return sendOnDate;
	}

	/**
	 * Sets the send on date.
	 *
	 * @param sendOnDate the sendOnDate to set
	 */
	public void setSendOnDate(String sendOnDate) {
		this.sendOnDate = sendOnDate;
	}

	/**
	 * Gets the lying with.
	 *
	 * @return the lyingWith
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * Sets the lying with.
	 *
	 * @param lyingWith the lyingWith to set
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the isEditable
	 */
	public Long getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
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
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the record count.
	 *
	 * @return the recordCount
	 */
	public Long getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

}
