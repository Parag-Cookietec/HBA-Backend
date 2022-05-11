package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;


/**
 * The Class LocChequeCancelListingDto.
 */
public class LocChequeCancelListingDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 1)
	private String refNo;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 2)
	private String divisionCode;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 3)
	private String divisionName;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 4)
	private Long cardexNo;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 5)
	private String chequeNo;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 6)
	private String chequeDate;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 7)
	private Long chequeAmt;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 8)
	private String recievedFrom;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 9)
	private String recievedDate;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 10)
	private String sendTo;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 11)
	private String sendOnDate;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 12)
	private String lyingWith;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 13)
	private int isEditable;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 14)
	private int recordCount;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 15)
	private String wfStatus;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 16)
	private String status;

	/** The ref Date */
	@NativeQueryResultColumn(index = 17)
	private Date refDate;

	/**
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the divisionCode
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * @param divisionCode the divisionCode to set
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	/**
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the chequeNo
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @return the chequeDate
	 */
	public String getChequeDate() {
		return chequeDate;
	}

	/**
	 * @param chequeDate the chequeDate to set
	 */
	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * @return the chequeAmt
	 */
	public Long getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * @param chequeAmt the chequeAmt to set
	 */
	public void setChequeAmt(Long chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * @return the recievedFrom
	 */
	public String getRecievedFrom() {
		return recievedFrom;
	}

	/**
	 * @param recievedFrom the recievedFrom to set
	 */
	public void setRecievedFrom(String recievedFrom) {
		this.recievedFrom = recievedFrom;
	}

	/**
	 * @return the recievedDate
	 */
	public String getRecievedDate() {
		return recievedDate;
	}

	/**
	 * @param recievedDate the recievedDate to set
	 */
	public void setRecievedDate(String recievedDate) {
		this.recievedDate = recievedDate;
	}

	/**
	 * @return the sendTo
	 */
	public String getSendTo() {
		return sendTo;
	}

	/**
	 * @param sendTo the sendTo to set
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	/**
	 * @return the sendOnDate
	 */
	public String getSendOnDate() {
		return sendOnDate;
	}

	/**
	 * @param sendOnDate the sendOnDate to set
	 */
	public void setSendOnDate(String sendOnDate) {
		this.sendOnDate = sendOnDate;
	}

	/**
	 * @return the lyingWith
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * @param lyingWith the lyingWith to set
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * @return the isEditable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}
}
