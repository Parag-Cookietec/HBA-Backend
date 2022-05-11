package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFInvestmentPostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long accountTypeId;
	@NotNull(message = "{investment.dt.notNull}")
	private LocalDate investmentDt;
	@NotNull(message = "{investment.from.notNull}")
	private Long investFrmId;
	@NotNull(message = "{rbi.advice.no.notNull}")
	private String rbiAdviceNo;
	@NotNull(message = "{rbi.advice.dt.notNull}")
	private LocalDate rbiAdviceDt;
	private Double currAccBal;
	@NotNull(message = "{security.type.id.notNull}")
	private Long securityTypeId;
	private String referenceNo;
	private LocalDateTime referenceDt;
	@NotNull(message = "{interest.rate.notNull}")
	private Double interestRate;
	@NotNull(message = "{yr.of.maturity.notNull}")
	private Integer yrOfMaturity;
	@NotNull(message = "{invest.face.val.notNull}")
	private Double investFaceVal;
	@NotNull(message = "{no.of.units.notNull}")
	private Long noOfUnits;
	@NotNull(message = "{purchase.price.notNull}")
	private Double purchasePrice;
	@NotNull(message = "{broken.days.notNull}")
	private Integer brokenDays;
	@NotNull(message = "{intrst.brkn.days.notNull}")
	private Double intrstBrknDays;
	@NotNull(message = "{tot.debited.amt.notNull}")
	private Double totDebitedAmt;
	private Double progBalAcc;
	private String accountType;

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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
