package gov.ifms.dmo.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class DMONSSFLoanHDRRespDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The NSSF loan HRD Id **/
	@NativeQueryResultColumn(index = 0)
	private Long id;

	private Long nssfLoanId;

	/** The DP Sheet Received Date **/
	@NativeQueryResultColumn(index = 2)
	private String dpSheetRecDate;

	/** The is Loan Older **/
	@NativeQueryResultColumn(index = 3)
	private int isLoanOlder;

	/** The Loan Number **/
	@NativeQueryResultColumn(index = 4)
	private String loanNumber;

	/** The DPSheet Memo Number **/
	@NativeQueryResultColumn(index = 5)
	private String memono;

	/** The NSSF loan Reference No **/
	@NativeQueryResultColumn(index = 6)
	private String refrenceNo;

	/** The NSSF loan Reference Date **/
	@NativeQueryResultColumn(index = 7)
	private String refrenceDate;

	/** The NSSF loan Advice Number **/
	@NativeQueryResultColumn(index = 8)
	private String adviceNo;

	/** The NSSF loan Advice Date **/
	@NativeQueryResultColumn(index = 9)
	private String adviceDate;

	/** The NSSF loan Advice By **/
	@NativeQueryResultColumn(index = 10)
	private String adviceBy;

	/** The NSSF loan Transaction Description **/
	@NativeQueryResultColumn(index = 11)
	private String transactionDesc;

	/** The NSSF loan Sanction Order No **/
	@NativeQueryResultColumn(index = 12)
	private String sanctionOrderNo;

	/** The NSSF loan Sanction OrderDate **/
	@NativeQueryResultColumn(index = 13)
	private String sanctionOrderDate;

	/** The NSSF loan Organization Name **/
	@NativeQueryResultColumn(index = 14)
	private String organizationName;

	/** The NSSF loan Receipt Date **/
	@NativeQueryResultColumn(index = 15)
	private String loanReceiptDate;

	/** The NSSF loan Finance Year Id **/
	@NativeQueryResultColumn(index = 16)
	private Long loanFinanceYearId;

	/** The NSSF loan StartDate **/
	@NativeQueryResultColumn(index = 17)
	private String loanStartDate;

	/** The NSSF loan Credit Amount **/
	@NativeQueryResultColumn(index = 18)
	private Double creditAmount;

	/** The NSSF loan Loan Amount **/
	@NativeQueryResultColumn(index = 19)
	private Double loanAmount;

	/** The NSSF loan Loan ROI **/
	@NativeQueryResultColumn(index = 20)
	private Double loanROI;

	/** The NSSF loan Loan Tenure **/
	@NativeQueryResultColumn(index = 21)
	private int loanTenure;

	/** The NSSF loan Moratarium Period **/
	@NativeQueryResultColumn(index = 22)
	private int moratariumPeriod;

	/** The NSSF loan Principal Install Year **/
	@NativeQueryResultColumn(index = 23)
	private int prncplInstallYear;

	/** The NSSF loan Total Principal Install **/
	@NativeQueryResultColumn(index = 24)
	private int totalPrncplInstall;

	/** The NSSF loan Interest Install Year **/
	@NativeQueryResultColumn(index = 25)
	private int intrestInstallYear;

	/** The NSSF loan First Install Date **/
	@NativeQueryResultColumn(index = 26)
	private String firstInstallDate;

	/** The NSSF loan Maturity Date **/
	@NativeQueryResultColumn(index = 27)
	private String loanMaturityDate;
	
	@NativeQueryResultColumn(index = 28)
	private String loanDelDt;
	
	@NativeQueryResultColumn(index = 29)
	private String loanDelBy;
	
	@NativeQueryResultColumn(index = 30)
	private String activeStatus;
	
	@NativeQueryResultColumn(index = 31)
	private long count;

	@NativeQueryResultColumn(index = 1)
	private Long dpSheetId;

	/** The NSSF loan Rate of Interest **/
	private double rateOfInterest;

	public String getLoanDelDt() {
		return loanDelDt;
	}

	public void setLoanDelDt(String loanDelDt) {
		this.loanDelDt = loanDelDt;
	}

	public String getLoanDelBy() {
		return loanDelBy;
	}

	public void setLoanDelBy(String loanDelBy) {
		this.loanDelBy = loanDelBy;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

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

	public String getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	public void setDpSheetRecDate(String dpSheetRecDate) {
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

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
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

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Long getLoanFinanceYearId() {
		return loanFinanceYearId;
	}

	public void setLoanFinanceYearId(Long loanFinanceYearId) {
		this.loanFinanceYearId = loanFinanceYearId;
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

	public String getRefrenceDate() {
		return refrenceDate;
	}

	public void setRefrenceDate(String refrenceDate) {
		this.refrenceDate = refrenceDate;
	}

	public String getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getSanctionOrderDate() {
		return sanctionOrderDate;
	}

	public void setSanctionOrderDate(String sanctionOrderDate) {
		this.sanctionOrderDate = sanctionOrderDate;
	}

	public String getLoanReceiptDate() {
		return loanReceiptDate;
	}

	public void setLoanReceiptDate(String loanReceiptDate) {
		this.loanReceiptDate = loanReceiptDate;
	}

	public String getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(String loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public String getFirstInstallDate() {
		return firstInstallDate;
	}

	public void setFirstInstallDate(String firstInstallDate) {
		this.firstInstallDate = firstInstallDate;
	}

	public String getLoanMaturityDate() {
		return loanMaturityDate;
	}

	public void setLoanMaturityDate(String loanMaturityDate) {
		this.loanMaturityDate = loanMaturityDate;
	}


}
