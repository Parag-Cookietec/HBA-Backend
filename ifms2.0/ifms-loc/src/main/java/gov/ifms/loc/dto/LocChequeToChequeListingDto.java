package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocChequeToChequeListingDto.
 */
public class LocChequeToChequeListingDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;

	/** The ref No. */
	@NativeQueryResultColumn(index = 1)
	private String refNo;

	/** The ref date. */
	@NativeQueryResultColumn(index = 2)
	private Date refDate;

	/** The missing cheque no. */
	@NativeQueryResultColumn(index = 3)
	private String missingChequeNo;

	/** The cheque date. */
	@NativeQueryResultColumn(index = 4)
	private Date chequeDate;

	/** The cheque amt. */
	@NativeQueryResultColumn(index = 5)
	private Double chequeAmt;

	/** The rec from. */
	@NativeQueryResultColumn(index = 6)
	private String recFrom;

	/** The rec date. */
	@NativeQueryResultColumn(index = 7)
	private String recDate;

	/** The sent to. */
	@NativeQueryResultColumn(index = 8)
	private String sentTo;

	/** The sent date. */
	@NativeQueryResultColumn(index = 9)
	private String sentDate;

	/** The lying with. */
	@NativeQueryResultColumn(index = 10)
	private String lyingWith;

	/** The status. */
	@NativeQueryResultColumn(index = 11)
	private String status;

	/** The wf status. */
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;

	/** The is editable. */
	@NativeQueryResultColumn(index = 13)
	private Long isEditable;

	/** The total records. */
	@NativeQueryResultColumn(index = 14)
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
	 * Gets the missing cheque no.
	 *
	 * @return the missing cheque no
	 */
	public String getMissingChequeNo() {
		return missingChequeNo;
	}

	/**
	 * Sets the missing cheque no.
	 *
	 * @param missingChequeNo the new missing cheque no
	 */
	public void setMissingChequeNo(String missingChequeNo) {
		this.missingChequeNo = missingChequeNo;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the cheque date
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the new cheque date
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the cheque amt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the new cheque amt
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * Gets the rec from.
	 *
	 * @return the rec from
	 */
	public String getRecFrom() {
		return recFrom;
	}

	/**
	 * Sets the rec from.
	 *
	 * @param recFrom the new rec from
	 */
	public void setRecFrom(String recFrom) {
		this.recFrom = recFrom;
	}

	/**
	 * Gets the rec date.
	 *
	 * @return the rec date
	 */
	public String getRecDate() {
		return recDate;
	}

	/**
	 * Sets the rec date.
	 *
	 * @param recDate the new rec date
	 */
	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}

	/**
	 * Gets the sent to.
	 *
	 * @return the sent to
	 */
	public String getSentTo() {
		return sentTo;
	}

	/**
	 * Sets the sent to.
	 *
	 * @param sentTo the new sent to
	 */
	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
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
}
