package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class DMODPSheetEntryDto.
 * 
 * @version 2.0
 * @created 2021/07/21 08:19:32
 *
 */
public class DMODPSheetEntryDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The DPSheetEntryId. */
	private Long id;
	
	private Long parentDpSheetId;
	/** The Memo No.**/
	private String memoNo;
	
	/** The Advice No.**/
	private String adviceNo;

	/** The DP Sheet Entry Sheet Date **/
	private LocalDate dpSheetDate; 

	/** The Advice Date.**/
	private LocalDate adviceDate;
	
	private String paymentTypeDesc;

	private Long transactTypeId;

	private Long paymentTypeId;
	
	private String adviceBy;
	
	private String transactionDesc;

	private Double creditAmt;
	
	private Double debitAmt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public LocalDate getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(LocalDate adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getAdviceBy() {
		return adviceBy;
	}

	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
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

	public LocalDate getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(LocalDate dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
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

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
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
