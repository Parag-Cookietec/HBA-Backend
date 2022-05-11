package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_INVESTMENT", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFInvestmentEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRF_CRF_INVEST_ID")
	private Long id;

	/** The is ACCOUNT_TYPE_ID. */
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;

	/** The is TRANSACTION_DT. */
	@Column(name = "INVESTMENT_DT")
	private LocalDate investmentDt;

	/** The is INVEST_FRM_ID. */
	@Column(name = "INVEST_FRM_ID")
	private Long investFrmId;

	/** The is RBI_ADVICE_NO. */
	@Column(name = "RBI_ADVICE_NO")
	private String rbiAdviceNo;

	/** The is RBI_ADVICE_DT. */
	@Column(name = "RBI_ADVICE_DT")
	private LocalDate rbiAdviceDt;

	/** The is CURR_ACC_BAL. */
	@Column(name = "CURR_ACC_BAL")
	private Double currAccBal;

	/** The is SECURITY_TYPE_ID. */
	@Column(name = "SECURITY_TYPE_ID")
	private Long securityTypeId;

	/** The is REFERENCE_NO. */
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	/** The is REFERENCE_DT. */
	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	/** The is INTEREST_RATE. */
	@Column(name = "INTEREST_RATE")
	private Double interestRate;

	/** The is YR_OF_MATURITY. */
	@Column(name = "YR_OF_MATURITY")
	private Integer yrOfMaturity = 1;

	/** The is INVEST_FACE_VAL. */
	@Column(name = "INVEST_FACE_VAL")
	private Double investFaceVal;

	/** The is NO_OF_UNITS. */
	@Column(name = "NO_OF_UNITS")
	private Long noOfUnits;

	/** The is PURCHASE_PRICE. */
	@Column(name = "PURCHASE_PRICE")
	private Double purchasePrice;

	/** The is BROKEN_DAYS. */
	@Column(name = "BROKEN_DAYS")
	private Integer brokenDays;

	/** The is INTRST_BRKN_DAYS. */
	@Column(name = "INTRST_BRKN_DAYS")
	private Double intrstBrknDays;

	/** The is TOT_DEBITED_AMT. */
	@Column(name = "TOT_DEBITED_AMT")
	private Double totDebitedAmt;

	/** The is PROG_BAL_ACC. */
	@Column(name = "PROG_BAL_ACC")
	private Double progBalAcc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public LocalDate getInvestmentDt() {
		return investmentDt;
	}

	public void setInvestmentDt(LocalDate investmentDt) {
		this.investmentDt = investmentDt;
	}

	public Long getInvestFrmId() {
		return investFrmId;
	}

	public void setInvestFrmId(Long investFrmId) {
		this.investFrmId = investFrmId;
	}

	public String getRbiAdviceNo() {
		return rbiAdviceNo;
	}

	public void setRbiAdviceNo(String rbiAdviceNo) {
		this.rbiAdviceNo = rbiAdviceNo;
	}

	public LocalDate getRbiAdviceDt() {
		return rbiAdviceDt;
	}

	public void setRbiAdviceDt(LocalDate rbiAdviceDt) {
		this.rbiAdviceDt = rbiAdviceDt;
	}

	public Double getCurrAccBal() {
		return currAccBal;
	}

	public void setCurrAccBal(Double currAccBal) {
		this.currAccBal = currAccBal;
	}

	public Long getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(Long securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getYrOfMaturity() {
		return yrOfMaturity;
	}

	public void setYrOfMaturity(Integer yrOfMaturity) {
		this.yrOfMaturity = yrOfMaturity;
	}

	public Double getInvestFaceVal() {
		return investFaceVal;
	}

	public void setInvestFaceVal(Double investFaceVal) {
		this.investFaceVal = investFaceVal;
	}

	public Long getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(Long noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getBrokenDays() {
		return brokenDays;
	}

	public void setBrokenDays(Integer brokenDays) {
		this.brokenDays = brokenDays;
	}

	public Double getIntrstBrknDays() {
		return intrstBrknDays;
	}

	public void setIntrstBrknDays(Double intrstBrknDays) {
		this.intrstBrknDays = intrstBrknDays;
	}

	public Double getTotDebitedAmt() {
		return totDebitedAmt;
	}

	public void setTotDebitedAmt(Double totDebitedAmt) {
		this.totDebitedAmt = totDebitedAmt;
	}

	public Double getProgBalAcc() {
		return progBalAcc;
	}

	public void setProgBalAcc(Double progBalAcc) {
		this.progBalAcc = progBalAcc;
	}

}
