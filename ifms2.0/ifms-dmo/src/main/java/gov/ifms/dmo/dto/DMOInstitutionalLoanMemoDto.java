package gov.ifms.dmo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DMOInstitutionalLoanMemoDto {

	/** The GOI loan Reference No **/
	private String refrenceNo;
	
	/** The GOI loan Reference No **/
	private String memoNo;
	
	/** The GOI loan  Reference Date **/
	private LocalDate memoDate;
	
	/** The PAYMENT_TYPE_ID  **/
	private Long paymentTypeId;

	private Long dpSheetEntity;
	
	/** The is DP_SHEET_ID. */
	private Long instituteLoanId;
	
	/** The DP Sheet Received Date**/
	private LocalDate dpSheetRecDate;
	
	private LocalDateTime refrenceDate;

	/** The NET_AMT_PAYABLE.**/
	private Double netAmountPayable;
	
	/** The CHEQUE_NO  **/
	private Long chequeNo;
	
	/** The CHEQUE_PAID_DT.**/
	private LocalDate chequePaidDate;

	/** The CHEQUE_DT.**/
	private LocalDate chequeDate;

	public Long getDpSheetEntity() {
		return dpSheetEntity;
	}

	public void setDpSheetEntity(Long dpSheetEntity) {
		this.dpSheetEntity = dpSheetEntity;
	}

	public Long getInstituteLoanId() {
		return instituteLoanId;
	}

	public void setInstituteLoanId(Long instituteLoanId) {
		this.instituteLoanId = instituteLoanId;
	}

	public LocalDate getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	public void setDpSheetRecDate(LocalDate dpSheetRecDate) {
		this.dpSheetRecDate = dpSheetRecDate;
	}

	public LocalDateTime getRefrenceDate() {
		return refrenceDate;
	}

	public void setRefrenceDate(LocalDateTime refrenceDate) {
		this.refrenceDate = refrenceDate;
	}

	public Double getNetAmountPayable() {
		return netAmountPayable;
	}

	public void setNetAmountPayable(Double netAmountPayable) {
		this.netAmountPayable = netAmountPayable;
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public LocalDate getChequePaidDate() {
		return chequePaidDate;
	}

	public void setChequePaidDate(LocalDate chequePaidDate) {
		this.chequePaidDate = chequePaidDate;
	}

	public LocalDate getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public LocalDate getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(LocalDate memoDate) {
		this.memoDate = memoDate;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
}
