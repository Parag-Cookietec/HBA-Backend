package gov.ifms.dmo.dto;

import java.time.LocalDate;

/**
 * The Class DMOGOILoanPostDto.
 * 
 * @version 2.0
 * @created 2021/07/13 15:19:32
 *
 */
public class DMODPDataDto {

	private String memoNo;
	private String adviceNo;
	private LocalDate adviceDate;
	private LocalDate dpDate;
	private String adviceBy;
	private String transactionDesc;
	private Double debitAmt;
	private Long id;
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
	public LocalDate getDpDate() {
		return dpDate;
	}
	public void setDpDate(LocalDate dpDate) {
		this.dpDate = dpDate;
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
	public Double getDebitAmt() {
		return debitAmt;
	}
	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}
	
}
