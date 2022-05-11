package gov.ifms.dmo.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "TDMO_NSSF_LOAN_HDR", schema = Constant.DMO_SCHEMA)
public class DMONSSFLoanEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The NSSF loan HRD Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NSSF_LOAN_HDR_ID")
	private Long id;

	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "NSSF_LOAN_HDR_ID")
	private List<DMONSSFLoanRePaymentEntity> repayments = new ArrayList<>();
	
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
	
	/** The NSSF loan Reference No **/
	@Column(name = "REFERENCE_NO")
	private String refrenceNo;
	
	/** The NSSF loan  Reference Date **/
	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDate;
	
	/** The NSSF loan Advice Number **/
	@Column(name = "ADVICE_NO")
	private String adviceNo;
	
	/** The NSSF loan Advice Date **/
	@Column(name = "ADVICE_DT")
	private LocalDate adviceDate;
	
	/** The NSSF loan Advice By **/
	@Column(name = "ADVICE_BY")
	private String adviceBy;
	
	/** The NSSF loan Transaction Description **/
	@Column(name = "TRANSACTION_DESC")
	private String transactionDesc;
	
	/** The NSSF loan Sanction Order No**/
	@NotNull
	@Column(name = "SANCTION_ORDER_NO")
	private String sanctionOrderNo;
	
	/** The NSSF loan Sanction OrderDate  **/
	@NotNull
	@Column(name = "SANCTION_ORDER_DT")
	private LocalDateTime sanctionOrderDate;
	
	/** The NSSF loan  Organization Name **/
	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;
	
	/** The NSSF loan Receipt Date **/
	@Column(name = "LOAN_RECEIPT_DT")
	@NotNull
	private LocalDate loanReceiptDate;
	
	/** The NSSF loan Finance Year Id  **/
	@Column(name = "LOAN_FIN_YR_ID")
	private Long loanFinanceYearId;
		
	/** The NSSF loan  StartDate  **/
	@Column(name = "LOAN_START_DT")
	private LocalDate loanStartDate;
	
	/** The NSSF loan Credit Amount**/
	@Column(name = "CREDIT_AMOUNT")
	private Double creditAmount;
	
	/** The NSSF loan Loan Amount **/
	@Column(name = "LOAN_AMOUNT")
	@NotNull
	private Double loanAmount;
	
	/** The NSSF loan Loan ROI **/
	@Column(name = "LOAN_ROI")
	private Double loanROI;
	
	/** The NSSF loan Loan Tenure **/
	@Column(name = "LOAN_TENURE")
	@NotNull
	private int loanTenure;
	
	/** The NSSF loan  Moratarium Period **/
	@Column(name = "MORATORIUM_PERIOD")
	@NotNull
	private int moratariumPeriod;
	
	/** The NSSF loan  Principal Install Year **/
	@Column(name = "PRNCPL_INSTALL_YR")
	@NotNull
	private int prncplInstallYear;
	
	/** The NSSF loan Total Principal Install **/
	@Column(name = "TOT_PRNCPL_INSTALL")
	@NotNull
	private int totalPrncplInstall;
	
	/** The NSSF loan Interest Install Year**/
	@Column(name = "INTERST_INSTALL_YR")
	@NotNull
	private int intrestInstallYear;
	
	/** The NSSF loan First Install Date **/
	@Column(name = "FIRST_INSTALL_DT")
	@NotNull
	private LocalDate firstInstallDate;
	
	/** The NSSF loan Maturity Date **/
	@Column(name = "LOAN_MATURITY_DT")
	private LocalDate loanMaturityDate;
	
	/** The NSSF loan Deleted Date **/
	@Column(name = "LOAN_DELETE_DT")
	private LocalDate loanDeleteDate;
	
	/** The NSSF Loan Deleted By **/
	@Column(name = "LOAN_DELETE_BY")
	private Long loanDeletedBy;

	public DMONSSFLoanEntity() {
		super();
	}

	public DMONSSFLoanEntity(Long nssfLoanId) {
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

	public DMODPSheetEntryEntity getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(DMODPSheetEntryEntity dpSheetId) {
		this.dpSheetId = dpSheetId;
	}
	
		/**
	 * @return the repayments
	 */
	public List<DMONSSFLoanRePaymentEntity> getRepayments() {
		return repayments;
	}

	/**
	 * @param repayments the repayments to set
	 */
	public void setRepayments(List<DMONSSFLoanRePaymentEntity> repayments) {
		this.repayments = repayments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adviceBy, adviceDate, adviceNo, creditAmount, dpSheetId, dpSheetRecDate, firstInstallDate,
				id, intrestInstallYear, isLoanOlder, loanAmount, loanDeleteDate, loanDeletedBy, loanFinanceYearId,
				loanMaturityDate, loanNumber, loanROI, loanReceiptDate, loanStartDate, loanTenure, memono,
				moratariumPeriod, organizationName, prncplInstallYear, refrenceDate, refrenceNo, sanctionOrderDate,
				sanctionOrderNo, totalPrncplInstall, transactionDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMONSSFLoanEntity other = (DMONSSFLoanEntity) obj;
		return Objects.equals(adviceBy, other.adviceBy) && Objects.equals(adviceDate, other.adviceDate)
				&& Objects.equals(adviceNo, other.adviceNo) && Objects.equals(creditAmount, other.creditAmount)
				&& Objects.equals(dpSheetId, other.dpSheetId) && Objects.equals(dpSheetRecDate, other.dpSheetRecDate)
				&& Objects.equals(firstInstallDate, other.firstInstallDate) && Objects.equals(id, other.id)
				&& intrestInstallYear == other.intrestInstallYear && isLoanOlder == other.isLoanOlder
				&& Objects.equals(loanAmount, other.loanAmount) && Objects.equals(loanDeleteDate, other.loanDeleteDate)
				&& Objects.equals(loanDeletedBy, other.loanDeletedBy)
				&& Objects.equals(loanFinanceYearId, other.loanFinanceYearId)
				&& Objects.equals(loanMaturityDate, other.loanMaturityDate)
				&& Objects.equals(loanNumber, other.loanNumber) && Objects.equals(loanROI, other.loanROI)
				&& Objects.equals(loanReceiptDate, other.loanReceiptDate)
				&& Objects.equals(loanStartDate, other.loanStartDate) && loanTenure == other.loanTenure
				&& Objects.equals(memono, other.memono) && moratariumPeriod == other.moratariumPeriod
				&& Objects.equals(organizationName, other.organizationName)
				&& prncplInstallYear == other.prncplInstallYear && Objects.equals(refrenceDate, other.refrenceDate)
				&& Objects.equals(refrenceNo, other.refrenceNo)
				&& Objects.equals(sanctionOrderDate, other.sanctionOrderDate)
				&& Objects.equals(sanctionOrderNo, other.sanctionOrderNo)
				&& totalPrncplInstall == other.totalPrncplInstall
				&& Objects.equals(transactionDesc, other.transactionDesc);
	}
	
	
}
