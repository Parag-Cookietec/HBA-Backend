package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class DMOGOILoanPostDto.
 * 
 * @version 2.0
 * @created 2021/07/13 15:19:32
 *
 */
public class DMOGOILoanPostDto  implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The GOI loan HRD Id **/
	private Long id;
	
	private Long goiLoanId;
	/** The DP Sheet Received Date**/
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	private int isLoanOlder;
	
	/** The Loan Number **/
	private String loanNumber;
	
	/** The DPSheet Memo Number **/
	private String memono;
	
	/** The GOI loan Reference No **/
	private String refrenceNo;
	
	/** The GOI loan  Reference Date **/
	private LocalDateTime refrenceDate;
	
	/** The GOI loan Advice Number **/
	private String adviceNo;
	
	/** The GOI loan Advice Date **/
	private LocalDate adviceDate;
	
	/** The GOI loan Advice By **/
	private String adviceBy;
	
	/** The GOI loan Transaction Description **/
	private String transactionDesc;
	
	/** The GOI loan Sanction Order No**/
	private String sanctionOrderNo;
	
	/** The GOI loan Sanction OrderDate  **/
	private LocalDateTime sanctionOrderDate;
	
	/** The GOI loan  Organization Name **/
	private String organizationName;
	
	/** The GOI loan Receipt Date **/
	private LocalDate loanReceiptDate;
	
	/** The GOI loan Finance Year Id  **/
	private Long loanFinanceYearId;
		
	/** The GOI loan  StartDate  **/
	private LocalDate loanStartDate;
	
	/** The GOI loan Credit Amount**/
	private Double creditAmount;
	
	/** The GOI loan Loan Amount **/
	private Double loanAmount;
	
	/** The GOI loan Loan ROI **/
	private Double loanROI;
	
	/** The GOI loan Loan Tenure **/
	private int loanTenure;
	
	/** The GOI loan  Moratarium Period **/
	private int moratariumPeriod;
	
	/** The GOI loan  Principal Install Year **/
	private int prncplInstallYear;
	
	/** The GOI loan Total Principal Install **/
	private int totalPrncplInstall;
	
	/** The GOI loan Interest Install Year**/
	private int intrestInstallYear;
	
	/** The GOI loan First Install Date **/
	private LocalDate firstInstallDate;
	
	/** The GOI loan Maturity Date **/
	private LocalDate loanMaturityDate;
	
	/** The GOI loan Type Of Loan **/
	private Long typeOfLoan;

	/** The GOI loan Back to Back Loan **/
	private Long backToBackLoan;
	
	/** The GOI loan Sanction No. **/
	private String sanctionNo;
	
	/** The GOI loan Sanction Date **/
	private LocalDate sanctionDate;
	
	/** The GOI loan Name of Ministry / Department **/
	private Long nameOfMinistry;
	
	/** The GOI loan Loan Purpose **/
	private Long loanPurpose;
	
	/** The GOI loan Plan Scheme Name **/
	private Long planSchemeName;
	
	/** The GOI loan Rate of Interest **/
	private Double panelInterest;
	
	/** The GOI loan Block Loan Status **/
	private boolean blockLoanStatus;
	
	private Long dpSheetId;
	private Double moratriumPricipalPerc;
	private LocalDate principalFirstInstallDate;
	private LocalDate interestFirstInstallDate;
	private LocalDate demandDateOfReceipt;
	private Long srPageNo;
	
	public Long getSrPageNo() {
		return srPageNo;
	}

	public void setSrPageNo(Long srPageNo) {
		this.srPageNo = srPageNo;
	}

	public Double getPanelInterest() {
		return panelInterest;
	}

	public void setPanelInterest(Double panelInterest) {
		this.panelInterest = panelInterest;
	}

	public Double getMoratriumPricipalPerc() {
		return moratriumPricipalPerc;
	}

	public void setMoratriumPricipalPerc(Double moratriumPricipalPerc) {
		this.moratriumPricipalPerc = moratriumPricipalPerc;
	}

	public LocalDate getPrincipalFirstInstallDate() {
		return principalFirstInstallDate;
	}

	public void setPrincipalFirstInstallDate(LocalDate principalFirstInstallDate) {
		this.principalFirstInstallDate = principalFirstInstallDate;
	}

	public LocalDate getInterestFirstInstallDate() {
		return interestFirstInstallDate;
	}

	public void setInterestFirstInstallDate(LocalDate interestFirstInstallDate) {
		this.interestFirstInstallDate = interestFirstInstallDate;
	}

	public LocalDate getDemandDateOfReceipt() {
		return demandDateOfReceipt;
	}

	public void setDemandDateOfReceipt(LocalDate demandDateOfReceipt) {
		this.demandDateOfReceipt = demandDateOfReceipt;
	}

	public boolean isBlockLoanStatus() {
		return blockLoanStatus;
	}

	public void setBlockLoanStatus(boolean blockLoanStatus) {
		this.blockLoanStatus = blockLoanStatus;
	}

	public Long getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(Long typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public Long getBackToBackLoan() {
		return backToBackLoan;
	}

	public void setBackToBackLoan(Long backToBackLoan) {
		this.backToBackLoan = backToBackLoan;
	}

	public String getSanctionNo() {
		return sanctionNo;
	}

	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
	}

	public LocalDate getSanctionDate() {
		return sanctionDate;
	}

	public void setSanctionDate(LocalDate sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public Long getNameOfMinistry() {
		return nameOfMinistry;
	}

	public void setNameOfMinistry(Long nameOfMinistry) {
		this.nameOfMinistry = nameOfMinistry;
	}

	public Long getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(Long loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public Long getPlanSchemeName() {
		return planSchemeName;
	}

	public void setPlanSchemeName(Long planSchemeName) {
		this.planSchemeName = planSchemeName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	public void setDpSheetRecDate(LocalDate dpSheetRecDate) {
		this.dpSheetRecDate = dpSheetRecDate;
	}

	public int getIsLoanOlder() {
		return isLoanOlder;
	}

	public void setIsLoanOlder(int isLoanOlder) {
		this.isLoanOlder = isLoanOlder;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getMemono() {
		return memono;
	}

	public void setMemono(String memono) {
		this.memono = memono;
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

	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}

	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}

	public LocalDateTime getSanctionOrderDate() {
		return sanctionOrderDate;
	}

	public void setSanctionOrderDate(LocalDateTime sanctionOrderDate) {
		this.sanctionOrderDate = sanctionOrderDate;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDate getLoanReceiptDate() {
		return loanReceiptDate;
	}

	public void setLoanReceiptDate(LocalDate loanReceiptDate) {
		this.loanReceiptDate = loanReceiptDate;
	}

	public Long getLoanFinanceYearId() {
		return loanFinanceYearId;
	}

	public void setLoanFinanceYearId(Long loanFinanceYearId) {
		this.loanFinanceYearId = loanFinanceYearId;
	}

	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanROI() {
		return loanROI;
	}

	public void setLoanROI(Double loanROI) {
		this.loanROI = loanROI;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public int getMoratariumPeriod() {
		return moratariumPeriod;
	}

	public void setMoratariumPeriod(int moratariumPeriod) {
		this.moratariumPeriod = moratariumPeriod;
	}

	public int getPrncplInstallYear() {
		return prncplInstallYear;
	}

	public void setPrncplInstallYear(int prncplInstallYear) {
		this.prncplInstallYear = prncplInstallYear;
	}

	public int getTotalPrncplInstall() {
		return totalPrncplInstall;
	}

	public void setTotalPrncplInstall(int totalPrncplInstall) {
		this.totalPrncplInstall = totalPrncplInstall;
	}

	public int getIntrestInstallYear() {
		return intrestInstallYear;
	}

	public void setIntrestInstallYear(int intrestInstallYear) {
		this.intrestInstallYear = intrestInstallYear;
	}

	public LocalDate getFirstInstallDate() {
		return firstInstallDate;
	}

	public void setFirstInstallDate(LocalDate firstInstallDate) {
		this.firstInstallDate = firstInstallDate;
	}

	public LocalDate getLoanMaturityDate() {
		return loanMaturityDate;
	}

	public void setLoanMaturityDate(LocalDate loanMaturityDate) {
		this.loanMaturityDate = loanMaturityDate;
	}

	public Long getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	/**
	 * @return the goiLoanId
	 */
	public Long getGoiLoanId() {
		return goiLoanId;
	}

	/**
	 * @param goiLoanId the goiLoanId to set
	 */
	public void setGoiLoanId(Long goiLoanId) {
		this.goiLoanId = goiLoanId;
	}

	
	

}
