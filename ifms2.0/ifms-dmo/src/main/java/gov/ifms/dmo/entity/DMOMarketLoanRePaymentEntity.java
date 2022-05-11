package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

/**
 * The Class DMOMarketLoanRePaymentEntity.
 * 
 * @version 2.0
 * @created 2021/07/31 08:19:32
 *
 */

@Entity
@Table(name = "TDMO_MARKET_LOAN_REPAYMENT", schema = Constant.DMO_SCHEMA)
public class DMOMarketLoanRePaymentEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The Market loan repayments Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MARKET_LOAN_REPAY_ID")
	private Long id;

	/** The Market loan HRD Id **/
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MARKET_LOAN_HDR_ID", referencedColumnName = "MARKET_LOAN_HDR_ID")
	private DMOMarketLoanEntity marketLoanHdrId;

	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetId;

	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecvDt;

	@Column(name = "LOAN_NUMBER")
	private String loanNumber;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "REPAYMENT_THRU")
	private Long repaymentThru;

	@Column(name = "REPAYMENT_SRNO")
	private int repaymentSrno;

	@Column(name = "MAJOR_HEAD_ID")
	private Long majorHeadId;

	@Column(name = "FINANCIAL_YR_ID")
	private Long financialYrId;

	@Column(name = "INSTALL_DUE_DT")
	private LocalDate installDueDt;

	@Column(name = "OPENING_BAL_AMT")
	private Double openingBalAmt;

	@Column(name = "PRINCIPAL_AMOUNT")
	private Double principalAmount;

	@Column(name = "INTERST_AMOUNT")
	private Double interstAmount;

	@Column(name = "CLOSING_BAL_AMT")
	private Double closingBalAmt;

	@Column(name = "IS_INSTALL_PAID")
	private int isInstallPaid;

	@Column(name = "INSTALL_PAID_DT")
	private LocalDate installPaidDt;

	@Column(name = "INSTALL_PAID_AMT")
	private Double installPaidAmt;

	@Column(name = "OUTSTANDING_AMT")
	private Double outstandingAmt;

	@Column(name = "UNPAID_AMT")
	private Double unpaidAmt;

	@Column(name = "DEBIT_AMT")
	private Double debitAmt;

	@Column(name = "CREDIT_AMT")
	private Double creditAmt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * @return the marketLoanHdrId
	 */
	public DMOMarketLoanEntity getMarketLoanHdrId() {
		return marketLoanHdrId;
	}

	/**
	 * @param marketLoanHdrId the marketLoanHdrId to set
	 */
	public void setMarketLoanHdrId(DMOMarketLoanEntity marketLoanHdrId) {
		this.marketLoanHdrId = marketLoanHdrId;
	}

	/**
	 * @return the dpSheetId
	 */
	public DMODPSheetEntryEntity getDpSheetId() {
		return dpSheetId;
	}

	/**
	 * @param dpSheetId the dpSheetId to set
	 */
	public void setDpSheetId(DMODPSheetEntryEntity dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	/**
	 * @return the dpSheetRecvDt
	 */
	public LocalDate getDpSheetRecvDt() {
		return dpSheetRecvDt;
	}

	/**
	 * @param dpSheetRecvDt the dpSheetRecvDt to set
	 */
	public void setDpSheetRecvDt(LocalDate dpSheetRecvDt) {
		this.dpSheetRecvDt = dpSheetRecvDt;
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
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the referenceDt
	 */
	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the repaymentThru
	 */
	public Long getRepaymentThru() {
		return repaymentThru;
	}

	/**
	 * @param repaymentThru the repaymentThru to set
	 */
	public void setRepaymentThru(Long repaymentThru) {
		this.repaymentThru = repaymentThru;
	}

	/**
	 * @return the repaymentSrno
	 */
	public int getRepaymentSrno() {
		return repaymentSrno;
	}

	/**
	 * @param repaymentSrno the repaymentSrno to set
	 */
	public void setRepaymentSrno(int repaymentSrno) {
		this.repaymentSrno = repaymentSrno;
	}

	/**
	 * @return the majorHeadId
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * @return the financialYrId
	 */
	public Long getFinancialYrId() {
		return financialYrId;
	}

	/**
	 * @param financialYrId the financialYrId to set
	 */
	public void setFinancialYrId(Long financialYrId) {
		this.financialYrId = financialYrId;
	}

	/**
	 * @return the installDueDt
	 */
	public LocalDate getInstallDueDt() {
		return installDueDt;
	}

	/**
	 * @param installDueDt the installDueDt to set
	 */
	public void setInstallDueDt(LocalDate installDueDt) {
		this.installDueDt = installDueDt;
	}

	/**
	 * @return the openingBalAmt
	 */
	public Double getOpeningBalAmt() {
		return openingBalAmt;
	}

	/**
	 * @param openingBalAmt the openingBalAmt to set
	 */
	public void setOpeningBalAmt(Double openingBalAmt) {
		this.openingBalAmt = openingBalAmt;
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
	 * @return the interstAmount
	 */
	public Double getInterstAmount() {
		return interstAmount;
	}

	/**
	 * @param interstAmount the interstAmount to set
	 */
	public void setInterstAmount(Double interstAmount) {
		this.interstAmount = interstAmount;
	}

	/**
	 * @return the closingBalAmt
	 */
	public Double getClosingBalAmt() {
		return closingBalAmt;
	}

	/**
	 * @param closingBalAmt the closingBalAmt to set
	 */
	public void setClosingBalAmt(Double closingBalAmt) {
		this.closingBalAmt = closingBalAmt;
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
	 * @return the installPaidDt
	 */
	public LocalDate getInstallPaidDt() {
		return installPaidDt;
	}

	/**
	 * @param installPaidDt the installPaidDt to set
	 */
	public void setInstallPaidDt(LocalDate installPaidDt) {
		this.installPaidDt = installPaidDt;
	}

	/**
	 * @return the installPaidAmt
	 */
	public Double getInstallPaidAmt() {
		return installPaidAmt;
	}

	/**
	 * @param installPaidAmt the installPaidAmt to set
	 */
	public void setInstallPaidAmt(Double installPaidAmt) {
		this.installPaidAmt = installPaidAmt;
	}

	/**
	 * @return the outstandingAmt
	 */
	public Double getOutstandingAmt() {
		return outstandingAmt;
	}

	/**
	 * @param outstandingAmt the outstandingAmt to set
	 */
	public void setOutstandingAmt(Double outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}

	/**
	 * @return the unpaidAmt
	 */
	public Double getUnpaidAmt() {
		return unpaidAmt;
	}

	/**
	 * @param unpaidAmt the unpaidAmt to set
	 */
	public void setUnpaidAmt(Double unpaidAmt) {
		this.unpaidAmt = unpaidAmt;
	}

	/**
	 * @return the debitAmt
	 */
	public Double getDebitAmt() {
		return debitAmt;
	}

	/**
	 * @param debitAmt the debitAmt to set
	 */
	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}

	/**
	 * @return the creditAmt
	 */
	public Double getCreditAmt() {
		return creditAmt;
	}

	/**
	 * @param creditAmt the creditAmt to set
	 */
	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

}
