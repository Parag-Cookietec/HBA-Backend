package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import gov.ifms.dmo.entity.BaseEntity;

/**
 * The Class DMOMarketLoanRePaymentDto.
 * 
 * @version 2.0
 * @created 2021/07/31 08:19:32
 *
 */
public class DMOMarketLoanRePaymentDto extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Long marketLoanHdrId;

	private Long dpSheetId;

	private LocalDate ldSheetRecvDt;

	private String loanNumber;

	private String referenceNo;

	private LocalDateTime referenceDt;

	private Long repaymentThru;

	private int repaymentSrno;

	private Long majorHeadId;

	private Long financialYrId;

	private LocalDate installDueDt;

	private Double openingBalAmt;

	private Double principalAmount;

	private Double interstAmount;

	private Double closingBalAmt;

	private int isInstallPaid;

	private LocalDate installPaidDt;

	private Double installPaidAmt;

	private Double outstandingAmt;

	private Double unpaidAmt;
	private Double paidAmt;

	private Double debitAmt;

	private Double creditAmt;
	private String adviceNo;

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public Double getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(Double paidAmt) {
		this.paidAmt = paidAmt;
	}

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
	public Long getMarketLoanHdrId() {
		return marketLoanHdrId;
	}

	/**
	 * @param marketLoanHdrId the marketLoanHdrId to set
	 */
	public void setMarketLoanHdrId(Long marketLoanHdrId) {
		this.marketLoanHdrId = marketLoanHdrId;
	}

	/**
	 * @return the dpSheetId
	 */
	public Long getDpSheetId() {
		return dpSheetId;
	}

	/**
	 * @param dpSheetId the dpSheetId to set
	 */
	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	/**
	 * @return the ldSheetRecvDt
	 */
	public LocalDate getLdSheetRecvDt() {
		return ldSheetRecvDt;
	}

	/**
	 * @param ldSheetRecvDt the ldSheetRecvDt to set
	 */
	public void setLdSheetRecvDt(LocalDate ldSheetRecvDt) {
		this.ldSheetRecvDt = ldSheetRecvDt;
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
