package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DMONSSFLoanDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The NSSF loan HRD Id **/
	private Long id;
	
	/** The DP Sheet Received Date**/
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	private int isLoanOlder;
	
	/** The Loan Number **/
	private String loanNumber;
	
	/** The NSSF loan Sanction Order No**/
	private String sanctionOrderNo;
	
	/** The NSSF loan Sanction OrderDate  **/
	private LocalDateTime sanctionOrderDate;
	
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
	
	private LocalDate loanReceiptDate;
	
	private Double loanAmount;
	
	private LocalDate loanStartDate;
	
	private List<DMONSSFLoanRePaymentDto> dtos;
	
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
	 * @return the isLoanOlder
	 */
	public int getIsLoanOlder() {
		return isLoanOlder;
	}

	/**
	 * @param isLoanOlder the isLoanOlder to set
	 */
	public void setIsLoanOlder(int isLoanOlder) {
		this.isLoanOlder = isLoanOlder;
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
	 * @return the sanctionOrderNo
	 */
	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}

	/**
	 * @param sanctionOrderNo the sanctionOrderNo to set
	 */
	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}

	/**
	 * @return the sanctionOrderDate
	 */
	public LocalDateTime getSanctionOrderDate() {
		return sanctionOrderDate;
	}

	/**
	 * @param sanctionOrderDate the sanctionOrderDate to set
	 */
	public void setSanctionOrderDate(LocalDateTime sanctionOrderDate) {
		this.sanctionOrderDate = sanctionOrderDate;
	}

	/**
	 * @return the loanROI
	 */
	public Double getLoanROI() {
		return loanROI;
	}

	/**
	 * @param loanROI the loanROI to set
	 */
	public void setLoanROI(Double loanROI) {
		this.loanROI = loanROI;
	}

	/**
	 * @return the loanTenure
	 */
	public int getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	/**
	 * @return the moratariumPeriod
	 */
	public int getMoratariumPeriod() {
		return moratariumPeriod;
	}

	/**
	 * @param moratariumPeriod the moratariumPeriod to set
	 */
	public void setMoratariumPeriod(int moratariumPeriod) {
		this.moratariumPeriod = moratariumPeriod;
	}

	/**
	 * @return the prncplInstallYear
	 */
	public int getPrncplInstallYear() {
		return prncplInstallYear;
	}

	/**
	 * @param prncplInstallYear the prncplInstallYear to set
	 */
	public void setPrncplInstallYear(int prncplInstallYear) {
		this.prncplInstallYear = prncplInstallYear;
	}

	/**
	 * @return the totalPrncplInstall
	 */
	public int getTotalPrncplInstall() {
		return totalPrncplInstall;
	}

	/**
	 * @param totalPrncplInstall the totalPrncplInstall to set
	 */
	public void setTotalPrncplInstall(int totalPrncplInstall) {
		this.totalPrncplInstall = totalPrncplInstall;
	}

	/**
	 * @return the intrestInstallYear
	 */
	public int getIntrestInstallYear() {
		return intrestInstallYear;
	}

	/**
	 * @param intrestInstallYear the intrestInstallYear to set
	 */
	public void setIntrestInstallYear(int intrestInstallYear) {
		this.intrestInstallYear = intrestInstallYear;
	}

	/**
	 * @return the firstInstallDate
	 */
	public LocalDate getFirstInstallDate() {
		return firstInstallDate;
	}

	/**
	 * @param firstInstallDate the firstInstallDate to set
	 */
	public void setFirstInstallDate(LocalDate firstInstallDate) {
		this.firstInstallDate = firstInstallDate;
	}

	/**
	 * @return the loanMaturityDate
	 */
	public LocalDate getLoanMaturityDate() {
		return loanMaturityDate;
	}

	/**
	 * @param loanMaturityDate the loanMaturityDate to set
	 */
	public void setLoanMaturityDate(LocalDate loanMaturityDate) {
		this.loanMaturityDate = loanMaturityDate;
	}

	/**
	 * @return the dtos
	 */
	public List<DMONSSFLoanRePaymentDto> getDtos() {
		return dtos;
	}

	/**
	 * @param dtos the dtos to set
	 */
	public void setDtos(List<DMONSSFLoanRePaymentDto> dtos) {
		this.dtos = dtos;
	}

	/**
	 * @return the loanReceiptDate
	 */
	public LocalDate getLoanReceiptDate() {
		return loanReceiptDate;
	}

	/**
	 * @param loanReceiptDate the loanReceiptDate to set
	 */
	public void setLoanReceiptDate(LocalDate loanReceiptDate) {
		this.loanReceiptDate = loanReceiptDate;
	}

	/**
	 * @return the loanAmount
	 */
	public Double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the loanStartDate
	 */
	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}

	/**
	 * @param loanStartDate the loanStartDate to set
	 */
	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	
	
}
