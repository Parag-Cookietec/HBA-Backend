package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMODPSheetEntryPostDto.
 * 
 * @version 2.0
 * @created 2021/07/21 08:19:32
 *
 */
@NativeQueryResultEntity
public class DMODPSheetEntryPostDto implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The DPSheetEntryId. */
	@NativeQueryResultColumn(index = 0)
	private Long dpSheetDtlId;

	/** The Memo No. **/
	@NativeQueryResultColumn(index = 1)
	private String memoNo;

	/** The Advice No. **/
	@NativeQueryResultColumn(index = 2)
	private String adviceNo;

	/** The Advice Date. **/
	@NativeQueryResultColumn(index = 3)
	private String adviceDate;

	/** The Advice By. **/
	@NativeQueryResultColumn(index = 4)
	private String adviceBy;

	/** The Payment Type Id. **/
	@NativeQueryResultColumn(index = 5)
	private Long paymentTypeId;

	/** The Payment Type Description. **/
	@NativeQueryResultColumn(index = 6)
	private String paymentTypeDesc;

	/** The Transaction TypeId. **/
	@NativeQueryResultColumn(index = 7)
	private Long transactTypeId;

	/** The Transaction Description. **/
	@NativeQueryResultColumn(index = 8)
	private String transactionDesc;

	/** The creditAmt. **/
	@NativeQueryResultColumn(index = 9)
	private Double creditAmt;

	/** ThedebitAmt. **/
	@NativeQueryResultColumn(index = 10)
	private Double debitAmt;

	/** ThedebitAmt. **/
	@NativeQueryResultColumn(index = 11)
	private String activeStatus;

	@NativeQueryResultColumn(index = 12)
	private int count;

	/** The Memo No. **/
	private int addDetailStatus;

	private Long parentDpSheetId;

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAddDetailStatus() {
		return addDetailStatus;
	}

	public void setAddDetailStatus(int addDetailStatus) {
		this.addDetailStatus = addDetailStatus;
	}

	private LocalDate dpSheetReciveDate;


	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}
	
	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long dpSheetDtlId) {
		this.dpSheetDtlId = dpSheetDtlId;
	}

	public String getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getAdviceBy() {
		return adviceBy;
	}

	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public Double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

	public Double getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	/**
	 * @return the dpSheetReciveDate
	 */
	public LocalDate getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	/**
	 * @param dpSheetReciveDate the dpSheetReciveDate to set
	 */
	public void setDpSheetReciveDate(LocalDate dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

	/**
	 * @return the parentDpSheetId
	 */
	public Long getParentDpSheetId() {
		return parentDpSheetId;
	}

	/**
	 * @param parentDpSheetId the parentDpSheetId to set
	 */
	public void setParentDpSheetId(Long parentDpSheetId) {
		this.parentDpSheetId = parentDpSheetId;
	}
		

}
