package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMODPSheetEntryViewDto.
 * 
 * @version 2.0
 * @created 2021/07/24 08:19:32
 *
 */
@NativeQueryResultEntity
public class DMODPSheetEntryViewDto implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The DPSheetEntryId. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The DP Sheet Entry Sheet Date **/
	@NativeQueryResultColumn(index = 1)
	private Date dpSheetDate;

	/** The DP Sheet Entry Sheet Date **/
	@NativeQueryResultColumn(index = 2)
	private String financialYear;

	/** The Memo No. **/
	@NativeQueryResultColumn(index = 3)
	private String memoNo;

	/** The Advice No. **/
	@NativeQueryResultColumn(index = 4)
	private String adviceNo;

	/** The Advice Date. **/
	@NativeQueryResultColumn(index = 5)
	private Date adviceDate;

	@NativeQueryResultColumn(index = 6)
	private String adviceBy;

	@NativeQueryResultColumn(index = 7)
	private Long transactType;

	@NativeQueryResultColumn(index = 8)
	private String transactionDesc;

	@NativeQueryResultColumn(index = 9)
	private Double debitAmt;

	@NativeQueryResultColumn(index = 10)
	private Double creditAmt;

	@NativeQueryResultColumn(index = 11)
	private Double monthOfAccount;

	@NativeQueryResultColumn(index = 12)
	private Double dailyNetAmount;

	@NativeQueryResultColumn(index = 13)
	private Double monthlyNetAmount;

	@NativeQueryResultColumn(index = 14)
	private Long recordCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(Date dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
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

	public Date getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(Date adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getAdviceBy() {
		return adviceBy;
	}

	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}

	public Long getTransactType() {
		return transactType;
	}

	public void setTransactType(Long transactType) {
		this.transactType = transactType;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public Double getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}

	public Double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

	public Double getMonthOfAccount() {
		return monthOfAccount;
	}

	public void setMonthOfAccount(Double monthOfAccount) {
		this.monthOfAccount = monthOfAccount;
	}

	public Double getDailyNetAmount() {
		return dailyNetAmount;
	}

	public void setDailyNetAmount(Double dailyNetAmount) {
		this.dailyNetAmount = dailyNetAmount;
	}

	public Double getMonthlyNetAmount() {
		return monthlyNetAmount;
	}

	public void setMonthlyNetAmount(Double monthlyNetAmount) {
		this.monthlyNetAmount = monthlyNetAmount;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
