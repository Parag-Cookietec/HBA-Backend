package gov.ifms.dmo.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_INSTITUT_LOAN_HDR", schema = Constant.DMO_SCHEMA)
public class DMOInstitutionalLoanEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The Institute loan HRD Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTITUT_LOAN_HDR_ID")
	private Long id;

	/** The is DP_SHEET_ID. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "INSTITUT_LOAN_HDR_ID", referencedColumnName = "INSTITUT_LOAN_HDR_ID")
	private DMOInstitutionalLoanMemoEntity repayments;
	
	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	@Column(name = "IS_LOAN_OLDER")
	private int isLoanOlder;
	
	/** The LOAN_ACC_NUMBER **/
	@Column(name = "LOAN_ACC_NUMBER")
	private String loanAccNumber;
	
	/** The INSTITUTE_ID **/
	@Column(name = "INSTITUTE_ID")
	private Long instituteId;

	@Column(name = "AUTH_DESIG_ID")
	private Long authDesignationId;

	/** The INSTITUTE_NAME **/
	@Column(name = "INSTITUTE_NAME")
	private String instituteName;

	/** The DEPARTMENT_ID **/
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	/** The DEPARTMENT_NAME **/
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	/** The LETTER_NO **/
	@Column(name = "LETTER_NO")
	private String letterNo;
	
	/** The LETTER_NO **/
	@Column(name = "LETTER_DT")
	private LocalDate letterDate;
	
	/** The Institute loan Reference No **/
	@Column(name = "REFERENCE_NO")
	private String refrenceNo;
	
	/** The Institute loan  Reference Date **/
	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDate;
	
	/** The Institute loan Advice Number **/
	@Column(name = "ADVICE_NO")
	private String adviceNo;
	
	/** The Institute loan Advice Date **/
	@Column(name = "ADVICE_DT")
	private LocalDate adviceDate;
	
	/** The Institute loan Advice By **/
	@Column(name = "ADVICE_BY")
	private String adviceBy;
	
	/** The Institute loan Transaction Description **/
	@Column(name = "TRANCHE_DESC")
	private String transactionDesc;

	@Column(name = "APPRV_AUTH_NAME")
	private String approvalAuth;

	@Column(name = "LOAN_PURPOSE")
	private String loanPurpose;
	
	/** The Institute loan Sanction OrderDate  **/
	@Column(name = "LOAN_SANCTION_DT")
	private LocalDate sanctionOrderDate;
	
	/** The Institute loan Receipt Date **/
	@Column(name = "LOAN_RECEIPT_DT")
	private LocalDate loanReceiptDate;
	
	/** The Institute loan Finance Year Id  **/
	@Column(name = "LOAN_FIN_YR_ID")
	private Long loanFinanceYearId;
		
	/** The Institute loan  StartDate  **/
	@Column(name = "LOAN_START_DT")
	private LocalDate loanStartDate;

	/** The CHEQUE_NO **/
	@Column(name = "CHEQUE_NO")
	private Long chequeNo;
	
	/** The CHEQUE_DT  **/
	@Column(name = "CHEQUE_DT")
	private LocalDate chequeDate;
	
	/** The Institute loan Loan Amount **/
	@Column(name = "LOAN_AMOUNT")
	private Double loanAmount;
	
	/** The Institute loan Loan ROI **/
	@Column(name = "LOAN_ROI")
	private Double loanROI;

	/** The Institute loan Loan ROI **/
	@Column(name = "TOT_AMT_RELEASD")
	private Double totalAmountRel;

	@Column(name = "PENAL_INTEREST")
	private Double penalInterest;

	@Column(name = "MORATRM_PNCPL_PERC")
	private Double moratariumPeriodPer;
	
	/** The Institute loan Loan Tenure **/
	@Column(name = "LOAN_TENURE")
	private int loanTenure;
	
	/** The Institute loan  Moratarium Period **/
	@Column(name = "MORATORIUM_PERIOD")
	private int moratariumPeriod;
	
	/** The Institute loan  Principal Install Year **/
	@Column(name = "PRNCPL_INSTALL_YR")
	private int prncplInstallYear;
	
	/** The Institute loan Total Principal Install **/
	@Column(name = "PRNCPL_TOT_INSTALL")
	private int totalPrncplInstall;
	
	/** The Institute loan Interest Install Year**/
	@Column(name = "INTERST_INSTALL_YR")
	private int intrestInstallYear;
	
	/** The Institute loan First Install Date **/
	@Column(name = "INTRST_FIRST_INSTALL_DT")
	private LocalDate intrestFirstInstallDate;
	/** The Institute loan First Install Date **/
	@Column(name = "PRNCPL_FIRST_INSTALL_DT")
	private LocalDate firstInstallDate;
	
	/** The Institute loan Maturity Date **/
	@Column(name = "LOAN_MATURITY_DT")
	private LocalDate loanMaturityDate;
	
	/** The Institute loan Deleted Date **/
	@Column(name = "LOAN_DELETE_DT")
	private LocalDate loanDeleteDate;
	
	/** The Institute Loan Deleted By **/
	@Column(name = "LOAN_DELETE_BY")
	private Long loanDeletedBy;
	
	/** The Institute loan Plan Scheme Name **/
	@Column(name = "SCHEME_NAME")
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

	public long getAuthDesignationId() {
		return authDesignationId;
	}

	public void setAuthDesignationId(long authDesignationId) {
		this.authDesignationId = authDesignationId;
	}

	public String getApprovalAuth() {
		return approvalAuth;
	}

	public void setApprovalAuth(String approvalAuth) {
		this.approvalAuth = approvalAuth;
	}

	public DMOInstitutionalLoanMemoEntity getRepayments() {
		return repayments;
	}

	public void setRepayments(DMOInstitutionalLoanMemoEntity repayments) {
		this.repayments = repayments;
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
	
	public DMOInstitutionalLoanEntity() {
		super();
	}

	public DMOInstitutionalLoanEntity(Long nssfLoanId) {
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

	public DMODPSheetEntryEntity getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(DMODPSheetEntryEntity dpSheetId) {
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
