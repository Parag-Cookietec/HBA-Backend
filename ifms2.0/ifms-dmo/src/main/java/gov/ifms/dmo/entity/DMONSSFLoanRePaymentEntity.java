package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_NSSF_LOAN_REPAYMENT", schema = Constant.DMO_SCHEMA)
public class DMONSSFLoanRePaymentEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The NSSF loan Loan RePayment Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NSSF_LOAN_REPAY_ID")
	private Long id;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetEntity;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NSSF_LOAN_HDR_ID", referencedColumnName = "NSSF_LOAN_HDR_ID")
	private DMONSSFLoanEntity nssfLoanId;
	
	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecDate;
	
	/** The Loan Number **/
	@Column(name = "LOAN_NUMBER")
	private String loanNumber;
	
	/** The NSSF loan Reference No **/
	@Column(name = "REFERENCE_NO")
	private String refrenceNo;
	
	/** The NSSF loan  Reference Date **/
	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDate;
	
	/** The Repayments Sr no **/
	@Column(name = "REPAYMENT_SRNO")
	private int rePaymentNo;
	
	
	/** The NSSF loan Finance Year Id  **/
	@Column(name = "FINANCIAL_YR_ID")
	private Long financeYearId;
	
	/** The Install Due Date**/
	@Column(name = "INSTALL_DUE_DT")
	private LocalDate installDueDate;
	
	/** The Opening Balance Amount.**/
	@Column(name = "OPENING_BAL_AMT")
	private Double openingBalanceAmount;
	
	/** The Principal Amount.**/
	@Column(name = "PRINCIPAL_AMOUNT")
	private Double principalAmount;
	
	/** The Interest Amount.**/
	@Column(name = "INTERST_AMOUNT")
	private Double intrestAmount;
	
	/** The closing balance Amount.**/
	@Column(name = "CLOSING_BAL_AMT")
	private Double closingBalAmount;
	
	/** The Is Install Paid.**/
	@Column(name = "IS_INSTALL_PAID")
	private int isInstallPaid;
	
	/** The Is Install Paid Date.**/
	@Column(name = "INSTALL_PAID_DT")
	private LocalDate installPaidDate;
	
	/** The Is Install Paid Amount.**/
	@Column(name = "INSTALL_PAID_AMT")
	private Double installPaidAmount;
	
	/** The Outstanding Amount.**/
	@Column(name = "OUTSTANDING_AMT")
	private Double outstandingAmount;
	
	/** The unpaid Amount.**/
	@Column(name = "UNPAID_AMT")
	private Double unpaidAmount;
	
	/** The debit Amount.**/
	@Column(name = "DEBIT_AMT")
	private Double debitAmount;
	
	/** The credit Amount.**/
	@Column(name = "CREDIT_AMT")
	private Double creditAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DMODPSheetEntryEntity getDpSheetEntity() {
		return dpSheetEntity;
	}

	public void setDpSheetEntity(DMODPSheetEntryEntity dpSheetEntity) {
		this.dpSheetEntity = dpSheetEntity;
	}

	/**
	 * @return the nssfLoanId
	 */
	public DMONSSFLoanEntity getNssfLoanId() {
		return nssfLoanId;
	}

	/**
	 * @param nssfLoanId the nssfLoanId to set
	 */
	public void setNssfLoanId(DMONSSFLoanEntity nssfLoanId) {
		this.nssfLoanId = nssfLoanId;
	}

	public LocalDate getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	public void setDpSheetRecDate(LocalDate dpSheetRecDate) {
		this.dpSheetRecDate = dpSheetRecDate;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public LocalDateTime getRefrenceDate() {
		return refrenceDate;
	}

	public void setRefrenceDate(LocalDateTime refrenceDate) {
		this.refrenceDate = refrenceDate;
	}

	public int getRePaymentNo() {
		return rePaymentNo;
	}

	public void setRePaymentNo(int rePaymentNo) {
		this.rePaymentNo = rePaymentNo;
	}

	public Long getFinanceYearId() {
		return financeYearId;
	}

	public void setFinanceYearId(Long financeYearId) {
		this.financeYearId = financeYearId;
	}

	public LocalDate getInstallDueDate() {
		return installDueDate;
	}

	public void setInstallDueDate(LocalDate installDueDate) {
		this.installDueDate = installDueDate;
	}

	public Double getOpeningBalanceAmount() {
		return openingBalanceAmount;
	}

	public void setOpeningBalanceAmount(Double openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
	}

	public Double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public Double getIntrestAmount() {
		return intrestAmount;
	}

	public void setIntrestAmount(Double intrestAmount) {
		this.intrestAmount = intrestAmount;
	}

	public Double getClosingBalAmount() {
		return closingBalAmount;
	}

	public void setClosingBalAmount(Double closingBalAmount) {
		this.closingBalAmount = closingBalAmount;
	}

	public int getIsInstallPaid() {
		return isInstallPaid;
	}

	public void setIsInstallPaid(int isInstallPaid) {
		this.isInstallPaid = isInstallPaid;
	}

	public LocalDate getInstallPaidDate() {
		return installPaidDate;
	}

	public void setInstallPaidDate(LocalDate installPaidDate) {
		this.installPaidDate = installPaidDate;
	}

	public Double getInstallPaidAmount() {
		return installPaidAmount;
	}

	public void setInstallPaidAmount(Double installPaidAmount) {
		this.installPaidAmount = installPaidAmount;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Double getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(Double unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(closingBalAmount, creditAmount, debitAmount, dpSheetEntity, dpSheetRecDate, nssfLoanId,
				financeYearId, id, installDueDate, installPaidAmount, installPaidDate, intrestAmount, isInstallPaid,
				loanNumber, openingBalanceAmount, outstandingAmount, principalAmount, rePaymentNo, refrenceDate,
				refrenceNo, unpaidAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMONSSFLoanRePaymentEntity other = (DMONSSFLoanRePaymentEntity) obj;
		return Objects.equals(closingBalAmount, other.closingBalAmount)
				&& Objects.equals(creditAmount, other.creditAmount) && Objects.equals(debitAmount, other.debitAmount)
				&& Objects.equals(dpSheetEntity, other.dpSheetEntity)
				&& Objects.equals(dpSheetRecDate, other.dpSheetRecDate) && Objects.equals(nssfLoanId, other.nssfLoanId)
				&& Objects.equals(financeYearId, other.financeYearId) && Objects.equals(id, other.id)
				&& Objects.equals(installDueDate, other.installDueDate)
				&& Objects.equals(installPaidAmount, other.installPaidAmount)
				&& Objects.equals(installPaidDate, other.installPaidDate)
				&& Objects.equals(intrestAmount, other.intrestAmount) && isInstallPaid == other.isInstallPaid
				&& Objects.equals(loanNumber, other.loanNumber)
				&& Objects.equals(openingBalanceAmount, other.openingBalanceAmount)
				&& Objects.equals(outstandingAmount, other.outstandingAmount)
				&& Objects.equals(principalAmount, other.principalAmount) && rePaymentNo == other.rePaymentNo
				&& Objects.equals(refrenceDate, other.refrenceDate) && Objects.equals(refrenceNo, other.refrenceNo)
				&& Objects.equals(unpaidAmount, other.unpaidAmount);
	}
	
}
