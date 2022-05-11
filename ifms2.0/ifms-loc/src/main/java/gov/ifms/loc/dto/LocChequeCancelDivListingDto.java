package gov.ifms.loc.dto;

import java.io.Serializable;
import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocChequeCancelDivListingDto.
 */
public class LocChequeCancelDivListingDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	/** The hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 1)
	private String refNo;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 2)
	private Date refDate;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 3)
	private String chequeNo;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 4)
	private Date chequeDate;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 5)
	private Double chequeAmt;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 6)
	private String recievedFrom;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 7)
	private String recievedDate;
	
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 8)
	private String sendTo;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 9)
	private String sendOnDate;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 10)
	private String lyingWith;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 11)
	private int isEditable;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 12)
	private int recordCount;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 13)
	private String status;
	
	/** The cheque no. */
	@NativeQueryResultColumn(index = 14)
	private String wfStatus;

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
	 * Gets the cheque no.
	 *
	 * @return the chequeNo
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Sets the cheque no.
	 *
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the chequeDate
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the chequeDate to set
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the chequeAmt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the chequeAmt to set
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * Gets the recieved from.
	 *
	 * @return the recievedFrom
	 */
	public String getRecievedFrom() {
		return recievedFrom;
	}

	/**
	 * Sets the recieved from.
	 *
	 * @param recievedFrom the recievedFrom to set
	 */
	public void setRecievedFrom(String recievedFrom) {
		this.recievedFrom = recievedFrom;
	}

	/**
	 * Gets the recieved date.
	 *
	 * @return the recievedDate
	 */
	public String getRecievedDate() {
		return recievedDate;
	}

	/**
	 * Sets the recieved date.
	 *
	 * @param recievedDate the recievedDate to set
	 */
	public void setRecievedDate(String recievedDate) {
		this.recievedDate = recievedDate;
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
	 * Gets the record count.
	 *
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the isEditable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}
	
	
	
}
