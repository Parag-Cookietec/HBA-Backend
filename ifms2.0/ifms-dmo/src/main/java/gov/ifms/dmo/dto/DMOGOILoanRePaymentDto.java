package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class DMONSSFLoanRePaymentDto.
 * 
 * @version v 2.0.
 * @created 2021/01/08 10:19:32
 *
 */
public class DMOGOILoanRePaymentDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The NSSF loan Loan RePayment Id **/
	
	private Long id;
	
	/** The is DP_SHEET_ID. */
	
	private Long dpSheetEntity;
	
	/** The is DP_SHEET_ID. */
	
	private Long goiLoanId;
	
	/** The DP Sheet Received Date**/
	
	private LocalDate dpSheetRecDate;
	
	/** The Loan Number **/
	
	private String loanNumber;
	
	/** The NSSF loan Reference No **/
	
	private String refrenceNo;
	
	/** The NSSF loan  Reference Date **/
	
	private LocalDateTime refrenceDate;
	
	/** The Repayments Sr no **/
	
	private int rePaymentNo;
	
	
	/** The NSSF loan Finance Year Id  **/
	
	private Long financeYearId;
	
	/** The Install Due Date**/
	
	private LocalDate installDueDate;
	
	/** The Opening Balance Amount.**/
	
	private Double openingBalanceAmount;
	
	/** The Principal Amount.**/
	
	private Double principalAmount;
	
	/** The Interest Amount.**/
	
	private Double intrestAmount;
	
	/** The closing balance Amount.**/
	
	private Double closingBalAmount;
	
	/** The Is Install Paid.**/
	
	private int isInstallPaid;
	
	/** The Is Install Paid Date.**/
	
	private LocalDate installPaidDate;
	
	/** The Is Install Paid Amount.**/
	
	private Double installPaidAmount;
	
	/** The Outstanding Amount.**/
	
	private Double outstandingAmount;
	
	/** The unpaid Amount.**/
	
	private Double unpaidAmount;
	
	/** The debit Amount.**/
	
	private Double debitAmount;
	
	/** The credit Amount.**/

	private Double creditAmount;

	/** The Interest Rate.**/
	private Double intrestRate;

	/** The Active Status.**/
	private int activeStatus;
	
	/** The LOAN AMT.**/
	private Double loanAmount;
	private String adviceNo;
	private Double paidAmount;
	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public DMOGOILoanRePaymentDto() {
		super();
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public Double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dpSheetEntity
	 */
	public Long getDpSheetEntity() {
		return dpSheetEntity;
	}

	/**
	 * @param dpSheetEntity the dpSheetEntity to set
	 */
	public void setDpSheetEntity(Long dpSheetEntity) {
		this.dpSheetEntity = dpSheetEntity;
	}

	/**
	 * @return the goiLoanId
	 */
	public Long getGoiLoanId() {
		return goiLoanId;
	}

	/**
	 * @param nssfLoanId the nssfLoanId to set
	 */
	public void setGoiLoanId(Long goiLoanId) {
		this.goiLoanId = goiLoanId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the dpSheetRecDate
	 */
	public LocalDate getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	/**
	 * @param dpSheetRecDate the dpSheetRecDate to set
	 */
	public void setDpSheetRecDate(LocalDate dpSheetRecDate) {
		this.dpSheetRecDate = dpSheetRecDate;
	}

	/**
	 * @return the loanNumber
	 */
	public String getLoanNumber() {
		return loanNumber;
	}

	/**
	 * @param loanNumber the loanNumber to set
	 */
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	/**
	 * @return the refrenceNo
	 */
	public String getRefrenceNo() {
		return refrenceNo;
	}

	/**
	 * @param refrenceNo the refrenceNo to set
	 */
	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	/**
	 * @return the refrenceDate
	 */
	public LocalDateTime getRefrenceDate() {
		return refrenceDate;
	}

	/**
	 * @param refrenceDate the refrenceDate to set
	 */
	public void setRefrenceDate(LocalDateTime refrenceDate) {
		this.refrenceDate = refrenceDate;
	}

	/**
	 * @return the rePaymentNo
	 */
	public int getRePaymentNo() {
		return rePaymentNo;
	}

	/**
	 * @param rePaymentNo the rePaymentNo to set
	 */
	public void setRePaymentNo(int rePaymentNo) {
		this.rePaymentNo = rePaymentNo;
	}

	/**
	 * @return the financeYearId
	 */
	public Long getFinanceYearId() {
		return financeYearId;
	}

	/**
	 * @param financeYearId the financeYearId to set
	 */
	public void setFinanceYearId(Long financeYearId) {
		this.financeYearId = financeYearId;
	}

	/**
	 * @return the installDueDate
	 */
	public LocalDate getInstallDueDate() {
		return installDueDate;
	}

	/**
	 * @param installDueDate the installDueDate to set
	 */
	public void setInstallDueDate(LocalDate installDueDate) {
		this.installDueDate = installDueDate;
	}

	/**
	 * @return the openingBalanceAmount
	 */
	public Double getOpeningBalanceAmount() {
		return openingBalanceAmount;
	}

	/**
	 * @param openingBalanceAmount the openingBalanceAmount to set
	 */
	public void setOpeningBalanceAmount(Double openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
	}

	/**
	 * @return the principalAmount
	 */
	public Double getPrincipalAmount() {
		return principalAmount;
	}

	/**
	 * @param principalAmount the principalAmount to set
	 */
	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	/**
	 * @return the intrestAmount
	 */
	public Double getIntrestAmount() {
		return intrestAmount;
	}

	/**
	 * @param intrestAmount the intrestAmount to set
	 */
	public void setIntrestAmount(Double intrestAmount) {
		this.intrestAmount = intrestAmount;
	}

	/**
	 * @return the closingBalAmount
	 */
	public Double getClosingBalAmount() {
		return closingBalAmount;
	}

	/**
	 * @param closingBalAmount the closingBalAmount to set
	 */
	public void setClosingBalAmount(Double closingBalAmount) {
		this.closingBalAmount = closingBalAmount;
	}

	/**
	 * @return the isInstallPaid
	 */
	public int getIsInstallPaid() {
		return isInstallPaid;
	}

	/**
	 * @param isInstallPaid the isInstallPaid to set
	 */
	public void setIsInstallPaid(int isInstallPaid) {
		this.isInstallPaid = isInstallPaid;
	}

	/**
	 * @return the installPaidDate
	 */
	public LocalDate getInstallPaidDate() {
		return installPaidDate;
	}

	/**
	 * @param installPaidDate the installPaidDate to set
	 */
	public void setInstallPaidDate(LocalDate installPaidDate) {
		this.installPaidDate = installPaidDate;
	}

	/**
	 * @return the installPaidAmount
	 */
	public Double getInstallPaidAmount() {
		return installPaidAmount;
	}

	/**
	 * @param installPaidAmount the installPaidAmount to set
	 */
	public void setInstallPaidAmount(Double installPaidAmount) {
		this.installPaidAmount = installPaidAmount;
	}

	/**
	 * @return the outstandingAmount
	 */
	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	/**
	 * @param outstandingAmount the outstandingAmount to set
	 */
	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	/**
	 * @return the unpaidAmount
	 */
	public Double getUnpaidAmount() {
		return unpaidAmount;
	}

	/**
	 * @param unpaidAmount the unpaidAmount to set
	 */
	public void setUnpaidAmount(Double unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	/**
	 * @return the debitAmount
	 */
	public Double getDebitAmount() {
		return debitAmount;
	}

	/**
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the creditAmount
	 */
	public Double getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	
}
