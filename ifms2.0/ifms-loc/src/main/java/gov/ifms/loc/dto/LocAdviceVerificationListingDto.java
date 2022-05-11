package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdvicePrepListingDto.
 */
@NativeQueryResultEntity
public class LocAdviceVerificationListingDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;
	

	/**
	 * The virtual token no.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long virtualTokenNo;

	/**
	 * The virtual token date.
	 */
	@NativeQueryResultColumn(index = 2)
	private Date virtualTokenDate;

	/** The advice no. */
	@NativeQueryResultColumn(index = 3)
	private String adviceNo;

	/**
	 * The advice date.
	 */
	@NativeQueryResultColumn(index = 4)
	private Date adviceDate;

	/** The div code. */
	@NativeQueryResultColumn(index = 5)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 6)
	private String divName;

	/** The paymentTypeName. */
	@NativeQueryResultColumn(index = 7)
	private String paymentTypeName;

	/**
	 * The gross amt.
	 */
	@NativeQueryResultColumn(index = 8)
	private Double grossAmt;

	/** The deduction amt. */
	@NativeQueryResultColumn(index = 9)
	private Double deductionAmt;

	/**
	 * The net amt.
	 */
	@NativeQueryResultColumn(index = 10)
	private Double netAmt;

	/**
	 * The ddoApprover.
	 */
	@NativeQueryResultColumn(index = 11)
	private String ddoApprover;

	/**
	 * The rec from user.
	 */
	@NativeQueryResultColumn(index = 12)
	private String recFromUser;

	/**
	 * The rec on date.
	 */
	@NativeQueryResultColumn(index = 13)
	private String recOnDate;

	/**
	 * The sent to user.
	 */
	@NativeQueryResultColumn(index = 14)
	private String sentToUser;

	/**
	 * The sent on date.
	 */
	@NativeQueryResultColumn(index = 15)
	private String sentOnDate;

	/**
	 * The lying with.
	 */
	@NativeQueryResultColumn(index = 16)
	private String lyingWith;

	/**
	 * The wf status.
	 */
	@NativeQueryResultColumn(index = 17)
	private String wfStatus;

	/**
	 * The trn status.
	 */
	@NativeQueryResultColumn(index = 18)
	private String trnStatus;

	/**
	 * The authorized date.
	 */
	@NativeQueryResultColumn(index = 19)
	private Date authorizedDate;

	/**
	 * The is editable.
	 */
	@NativeQueryResultColumn(index = 20)
	private Long isEditable;

	/**
	 * The total records.
	 */
	@NativeQueryResultColumn(index = 21)
	private Long totalRecords;

	
	/**
	 * Gets the virtual token no.
	 *
	 * @return the virtual token no
	 */
	public Long getVirtualTokenNo() {
		return virtualTokenNo;
	}

	/**
	 * Sets the virtual token no.
	 *
	 * @param virtualTokenNo the new virtual token no
	 */
	public void setVirtualTokenNo(Long virtualTokenNo) {
		this.virtualTokenNo = virtualTokenNo;
	}

	/**
	 * Gets the virtual token date.
	 *
	 * @return the virtual token date
	 */
	public Date getVirtualTokenDate() {
		return virtualTokenDate;
	}

	/**
	 * Sets the virtual token date.
	 *
	 * @param virtualTokenDate the new virtual token date
	 */
	public void setVirtualTokenDate(Date virtualTokenDate) {
		this.virtualTokenDate = virtualTokenDate;
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
	 * Gets the advice no.
	 *
	 * @return the advice no
	 */
	public String getAdviceNo() {
		return adviceNo;
	}

	/**
	 * Sets the advice no.
	 *
	 * @param adviceNo the new advice no
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	/**
	 * Gets the advice date.
	 *
	 * @return the advice date
	 */
	public Date getAdviceDate() {
		return adviceDate;
	}

	/**
	 * Sets the advice date.
	 *
	 * @param adviceDate the new advice date
	 */
	public void setAdviceDate(Date adviceDate) {
		this.adviceDate = adviceDate;
	}

	/**
	 * Gets the gross amt.
	 *
	 * @return the gross amt
	 */
	public Double getGrossAmt() {
		return grossAmt;
	}

	/**
	 * Sets the gross amt.
	 *
	 * @param grossAmt the new gross amt
	 */
	public void setGrossAmt(Double grossAmt) {
		this.grossAmt = grossAmt;
	}

	/**
	 * Gets the net amt.
	 *
	 * @return the net amt
	 */
	public Double getNetAmt() {
		return netAmt;
	}

	/**
	 * Sets the net amt.
	 *
	 * @param netAmt the new net amt
	 */
	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
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
	 * Gets the rec from user.
	 *
	 * @return the rec from user
	 */
	public String getRecFromUser() {
		return recFromUser;
	}

	/**
	 * Sets the rec from user.
	 *
	 * @param recFromUser the new rec from user
	 */
	public void setRecFromUser(String recFromUser) {
		this.recFromUser = recFromUser;
	}

	/**
	 * Gets the sent to user.
	 *
	 * @return the sent to user
	 */
	public String getSentToUser() {
		return sentToUser;
	}

	/**
	 * Sets the sent to user.
	 *
	 * @param sentToUser the new sent to user
	 */
	public void setSentToUser(String sentToUser) {
		this.sentToUser = sentToUser;
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

	/**
	 * Gets the payment type name.
	 *
	 * @return the payment type name
	 */
	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	/**
	 * Sets the payment type name.
	 *
	 * @param paymentTypeName the new payment type name
	 */
	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}

	/**
	 * Gets the deduction amt.
	 *
	 * @return the deduction amt
	 */
	public Double getDeductionAmt() {
		return deductionAmt;
	}

	/**
	 * Sets the deduction amt.
	 *
	 * @param deductionAmt the new deduction amt
	 */
	public void setDeductionAmt(Double deductionAmt) {
		this.deductionAmt = deductionAmt;
	}

	/**
	 * @return the ddoApprover
	 */
	public String getDdoApprover() {
		return ddoApprover;
	}

	/**
	 * @param ddoApprover the ddoApprover to set
	 */
	public void setDdoApprover(String ddoApprover) {
		this.ddoApprover = ddoApprover;
	}

}
