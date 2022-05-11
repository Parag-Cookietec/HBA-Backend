package gov.ifms.dmo.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GOI_LOAN_HDR", schema = Constant.DMO_SCHEMA)
public class DMOGOILoanEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The GOI loan HRD Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOI_LOAN_HDR_ID")
	private Long id;

	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "GOI_LOAN_HDR_ID")
	private List<DMOGOILoanRePaymentEntity> repayments = new ArrayList<>();
	
	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecDate;
	
	/** The is Loan Older **/
	@Column(name = "IS_LOAN_OLDER")
	private int isLoanOlder;
	
	/** The Loan Number **/
	@Column(name = "LOAN_NUMBER")
	private String loanNumber;
	
	/** The DPSheet Memo Number **/
	@Column(name = "MEMO_NO")
	private String memono;
	
	/** The GOI loan Reference No **/
	@Column(name = "REFERENCE_NO")
	private String refrenceNo;
	
	/** The GOI loan  Reference Date **/
	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDate;
	
	/** The GOI loan Advice Number **/
	@Column(name = "ADVICE_NO")
	private String adviceNo;
	
	/** The GOI loan Advice Date **/
	@Column(name = "ADVICE_DT")
	private LocalDate adviceDate;
	
	/** The GOI loan Advice By **/
	@Column(name = "ADVICE_BY")
	private String adviceBy;
	
	/** The GOI loan Transaction Description **/
	@Column(name = "TRANSACTION_DESC")
	private String transactionDesc;
	
	/** The GOI loan Sanction Order No**/
	@NotNull
	@Column(name = "SANCTION_ORDER_NO")
	private String sanctionOrderNo;
	
	/** The GOI loan Sanction OrderDate  **/
	@NotNull
	@Column(name = "SANCTION_ORDER_DT")
	private LocalDateTime sanctionOrderDate;
	
	/** The GOI loan  Organization Name **/
	@Column(name = "ORGANIZATION_NAME")
	@NotNull
	private String organizationName;
	
	/** The GOI loan Receipt Date **/
	@Column(name = "LOAN_RECEIPT_DT")
	@NotNull
	private LocalDate loanReceiptDate;
	
	/** The GOI loan Finance Year Id  **/
	@Column(name = "LOAN_FIN_YR_ID")
	private Long loanFinanceYearId;
		
	/** The GOI loan  StartDate  **/
	@Column(name = "LOAN_START_DT")
	private LocalDate loanStartDate;
	
	/** The GOI loan Credit Amount**/
	@Column(name = "CREDIT_AMOUNT")
	private Double creditAmount;
	
	/** The GOI loan Loan Amount **/
	@Column(name = "LOAN_AMOUNT")
	@NotNull
	private Double loanAmount;
	
	/** The GOI loan Loan ROI **/
	@Column(name = "LOAN_ROI")
	private Double loanROI;

	@Column(name = "MORATRM_PNCPL_PERC")
	private Double moratriumPricipalPerc;
	
	/** The GOI loan Loan Tenure **/
	@Column(name = "LOAN_TENURE")
	@NotNull
	private int loanTenure;
	
	/** The GOI loan  Moratarium Period **/
	@Column(name = "MORATORIUM_PERIOD")
	@NotNull
	private int moratariumPeriod;
	
	/** The GOI loan  Principal Install Year **/
	@Column(name = "PRNCPL_INSTALL_YR")
	@NotNull
	private int prncplInstallYear;
	
	/** The GOI loan Total Principal Install **/
	@Column(name = "TOT_PRNCPL_INSTALL")
	@NotNull
	private int totalPrncplInstall;

	@Column(name = "SR_PAGE_NO")
	private Long srPageNo;
	
	/** The GOI loan Interest Install Year**/
	@Column(name = "INTERST_INSTALL_YR")
	@NotNull
	private int intrestInstallYear;
	
	/** The GOI loan First Install Date **/
	@Column(name = "PRINCIPAL_FIRST_INSTALL_DT")
	private LocalDate principalFirstInstallDate;

	@Column(name = "INTEREST_FIRST_INSTALL_DT")
	private LocalDate interestFirstInstallDate;

	@Column(name = "DEMAND_DATE_OF_RECEIPT")
	private LocalDate demandDateOfReceipt;
	
	/** The GOI loan Maturity Date **/
	@Column(name = "LOAN_MATURITY_DT")
	private LocalDate loanMaturityDate;
	
	/** The GOI loan Deleted Date **/
	@Column(name = "LOAN_DELETE_DT")
	private LocalDate loanDeleteDate;
	
	/** The GOI Loan Deleted By **/
	@Column(name = "LOAN_DELETE_BY")
	private Long loanDeletedBy;

	/** The GOI loan Type Of Loan **/
	@Column(name = "TYPE_OF_LOAN")
	private Long typeOfLoan;

	/** The GOI loan Back to Back Loan **/
	@Column(name = "BACK_TO_BACK_LOAN")
	private Long backToBackLoan;
	
	/** The GOI loan Sanction No. **/
	@Column(name = "SANCTION_NO")
	private String sanctionNo;
	
	/** The GOI loan Sanction Date **/
	@Column(name = "SANCTION_DATE")
	private LocalDate sanctionDate;
	
	/** The GOI loan Name of Ministry / Department **/
	@Column(name = "NAME_OF_MINISTRY")
	private Long nameOfMinistry;
	
	/** The GOI loan Loan Purpose **/
	@Column(name = "LOAN_PURPOSE")
	private Long loanPurpose;

	/** The GOI loan Rate of Interest **/
	@Column(name = "PANEL_INTEREST")
	private Double panelInterest;
	
	/** The GOI loan Plan Scheme Name **/
	@Column(name = "PLAN_SCHEME_NAME")
	private Long planSchemeName;

	/** The GOI loan Block Loan Status **/
	@Column(name = "BLOCK_LOAN_STATUS")
	private boolean blockLoanStatus;
	
	public Double getMoratriumPricipalPerc() {
		return moratriumPricipalPerc;
	}

	public void setMoratriumPricipalPerc(Double moratriumPricipalPerc) {
		this.moratriumPricipalPerc = moratriumPricipalPerc;
	}

	public Long getSrPageNo() {
		return srPageNo;
	}

	public void setSrPageNo(Long srPageNo) {
		this.srPageNo = srPageNo;
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

	public Double getPanelInterest() {
		return panelInterest;
	}

	public void setPanelInterest(Double panelInterest) {
		this.panelInterest = panelInterest;
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
	
	public DMOGOILoanEntity() {
		super();
	}

	public DMOGOILoanEntity(Long nssfLoanId) {
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

	public DMODPSheetEntryEntity getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(DMODPSheetEntryEntity dpSheetId) {
		this.dpSheetId = dpSheetId;
	}
	
		/**
	 * @return the repayments
	 */
	public List<DMOGOILoanRePaymentEntity> getRepayments() {
		return repayments;
	}

	/**
	 * @param repayments the repayments to set
	 */
	public void setRepayments(List<DMOGOILoanRePaymentEntity> repayments) {
		this.repayments = repayments;
	}

}
