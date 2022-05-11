package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class DMONSSFLoanPostDto.
 * 
 * @version 2.0
 * @created 2021/07/13 15:19:32
 *
 */
public class DMONSSFLoanPostDto  implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The NSSF loan HRD Id **/
	private Long id;
	
	private Long nssfLoanId;
	
	/** The DP Sheet Received Date**/
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	private int isLoanOlder;
	
	/** The Loan Number **/
	private String loanNumber;
	
	/** The DPSheet Memo Number **/
	private String memono;
	
	/** The NSSF loan Reference No **/
	private String refrenceNo;
	
	/** The NSSF loan  Reference Date **/
	private LocalDateTime refrenceDate;
	
	/** The NSSF loan Advice Number **/
	private String adviceNo;
	
	/** The NSSF loan Advice Date **/
	private LocalDate adviceDate;
	
	/** The NSSF loan Advice By **/
	private String adviceBy;
	
	/** The NSSF loan Transaction Description **/
	private String transactionDesc;
	
	/** The NSSF loan Sanction Order No**/
	private String sanctionOrderNo;
	
	/** The NSSF loan Sanction OrderDate  **/
	private LocalDateTime sanctionOrderDate;
	
	/** The NSSF loan  Organization Name **/
	private String organizationName;
	
	/** The NSSF loan Receipt Date **/
	private LocalDate loanReceiptDate;
	
	/** The NSSF loan Finance Year Id  **/
	private Long loanFinanceYearId;
		
	/** The NSSF loan  StartDate  **/
	private LocalDate loanStartDate;
	
	/** The NSSF loan Credit Amount**/
	private Double creditAmount;
	
	/** The NSSF loan Loan Amount **/
	private Double loanAmount;
	
	/** The NSSF loan Loan ROI **/
	private Double loanROI;
	
	/** The NSSF loan Loan Tenure **/
	private int loanTenure;
	
	/** The NSSF loan  Moratarium Period **/
	private int moratariumPeriod;
	
	/** The NSSF loan  Principal Install Year **/
	private int prncplInstallYear;
	
	/** The NSSF loan Total Principal Install **/
	private int totalPrncplInstall;
	
	/** The NSSF loan Interest Install Year**/
	private int intrestInstallYear;
	
	/** The NSSF loan First Install Date **/
	private LocalDate firstInstallDate;
	
	/** The NSSF loan Maturity Date **/
	private LocalDate loanMaturityDate;

	private Long dpSheetId;
	
	/** The NSSF loan Rate of Interest **/
	private double rateOfInterest;

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
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
	 * @return the nssfLoanId
	 */
	public Long getNssfLoanId() {
		return nssfLoanId;
	}

	/**
	 * @param nssfLoanId the nssfLoanId to set
	 */
	public void setNssfLoanId(Long nssfLoanId) {
		this.nssfLoanId = nssfLoanId;
	}

	
	

}
