package gov.ifms.dmo.dto;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DMOInstitutionalLoanDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The Institute loan HRD Id **/
	private Long id;

	/** The is DP_SHEET_ID. */
	private Long dpSheetId;

	/** The DP Sheet Received Date**/
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	private int isLoanOlder;
	
	/** The LOAN_ACC_NUMBER **/
	private String loanAccNumber;
	
	/** The INSTITUTE_ID **/
	private long instituteId;

	private long authDesignationId;

	/** The INSTITUTE_NAME **/
	private String instituteName;

	/** The DEPARTMENT_ID **/
	private long departmentId;
	
	/** The DEPARTMENT_NAME **/
	private String departmentName;
	
	/** The LETTER_NO **/
	private String letterNo;
	
	/** The LETTER_NO **/
	private LocalDate letterDate;
	
	/** The Institute loan Reference No **/
	private String refrenceNo;
	
	/** The Institute loan  Reference Date **/
	private LocalDateTime refrenceDate;
	
	/** The Institute loan Advice Number **/
	private String adviceNo;
	
	/** The Institute loan Advice Date **/
	private LocalDate adviceDate;
	
	/** The Institute loan Advice By **/
	private String adviceBy;
	
	/** The Institute loan Transaction Description **/
	private String transactionDesc;

	private String approvalAuth;

	private String loanPurpose;
	
	/** The Institute loan Sanction OrderDate  **/
	private LocalDate sanctionOrderDate;
	
	/** The Institute loan Receipt Date **/
	private LocalDate loanReceiptDate;
	
	/** The Institute loan Finance Year Id  **/
	private Long loanFinanceYearId;
		
	/** The Institute loan  StartDate  **/
	private LocalDate loanStartDate;

	/** The CHEQUE_NO **/
	private Long chequeNo;
	
	/** The CHEQUE_DT  **/
	private LocalDate chequeDate;
	
	/** The Institute loan Loan Amount **/
	private Double loanAmount;
	
	/** The Institute loan Loan ROI **/
	private Double loanROI;

	/** The Institute loan Loan ROI **/
	private Double totalAmountRel;

	private Double penalInterest;

	private Double moratariumPeriodPer;
	
	/** The Institute loan Loan Tenure **/
	private int loanTenure;
	
	/** The Institute loan  Moratarium Period **/
	private int moratariumPeriod;
	
	/** The Institute loan  Principal Install Year **/
	private int prncplInstallYear;
	
	/** The Institute loan Total Principal Install **/
	private int totalPrncplInstall;
	
	/** The Institute loan Interest Install Year**/
	private int intrestInstallYear;
	
	/** The Institute loan First Install Date **/
	private LocalDate intrestFirstInstallDate;
	/** The Institute loan First Install Date **/
	private LocalDate firstInstallDate;
	
	/** The Institute loan Maturity Date **/
	private LocalDate loanMaturityDate;
	
	/** The Institute loan Deleted Date **/
	private LocalDate loanDeleteDate;
	
	/** The Institute Loan Deleted By **/
	private Long loanDeletedBy;
	
	/** The Institute loan Plan Scheme Name **/
	private String planSchemeName;
	
	public Double getPenalInterest() {
		return penalInterest;
	}

	public void setPenalInterest(Double penalInterest) {
		this.penalInterest = penalInterest;
	}

	public Double getMoratariumPeriodPer() {
		return moratariumPeriodPer;
	}

	public void setMoratariumPeriodPer(Double moratariumPeriodPer) {
		this.moratariumPeriodPer = moratariumPeriodPer;
	}

	public LocalDate getIntrestFirstInstallDate() {
		return intrestFirstInstallDate;
	}

	public void setIntrestFirstInstallDate(LocalDate intrestFirstInstallDate) {
		this.intrestFirstInstallDate = intrestFirstInstallDate;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getApprovalAuth() {
		return approvalAuth;
	}

	public void setApprovalAuth(String approvalAuth) {
		this.approvalAuth = approvalAuth;
	}

	public long getAuthDesignationId() {
		return authDesignationId;
	}

	public void setAuthDesignationId(long authDesignationId) {
		this.authDesignationId = authDesignationId;
	}

	public Double getTotalAmountRel() {
		return totalAmountRel;
	}

	public void setTotalAmountRel(Double totalAmountRel) {
		this.totalAmountRel = totalAmountRel;
	}

	public String getPlanSchemeName() {
		return planSchemeName;
	}

	public void setPlanSchemeName(String planSchemeName) {
		this.planSchemeName = planSchemeName;
	}
	
	public DMOInstitutionalLoanDto() {
		super();
	}

	public DMOInstitutionalLoanDto(Long nssfLoanId) {
		super();
		this.id = nssfLoanId;
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

	public Long getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	public String getLoanAccNumber() {
		return loanAccNumber;
	}

	public void setLoanAccNumber(String loanAccNumber) {
		this.loanAccNumber = loanAccNumber;
	}

	public long getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(long instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLetterNo() {
		return letterNo;
	}

	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}

	public LocalDate getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(LocalDate letterDate) {
		this.letterDate = letterDate;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public LocalDate getSanctionOrderDate() {
		return sanctionOrderDate;
	}

	public void setSanctionOrderDate(LocalDate sanctionOrderDate) {
		this.sanctionOrderDate = sanctionOrderDate;
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

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public LocalDate getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
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

	public LocalDate getLoanDeleteDate() {
		return loanDeleteDate;
	}

	public void setLoanDeleteDate(LocalDate loanDeleteDate) {
		this.loanDeleteDate = loanDeleteDate;
	}

	public Long getLoanDeletedBy() {
		return loanDeletedBy;
	}

	public void setLoanDeletedBy(Long loanDeletedBy) {
		this.loanDeletedBy = loanDeletedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
