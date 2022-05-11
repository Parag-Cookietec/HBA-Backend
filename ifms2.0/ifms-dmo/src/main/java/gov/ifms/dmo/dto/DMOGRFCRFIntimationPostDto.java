package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFIntimationPostDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long accountTypeId;
	private String referenceNo;
	private LocalDateTime referenceDt;
	@NotNull(message = "{intimation.no.notNull}")
	@Size(max = 30, message = "{intimation.no.size}")
	@NotEmpty
	private String intimationNo;
	@NotNull(message = "{intimation.date}")
	private LocalDate intimationDt;
	private Double tillDtProgPncpl;
	@NotNull(message = "{intimated.amt}")
	private Double intimatedAmt;
	@NotNull(message = "{aft.this.prog.pncpl}")
	private Double aftThisProgPncpl;
	@NotNull(message = "{transaction.dt}")
	private LocalDate transactionDt;
	@NotNull(message = "{txn.type.notNull}")
	private Long transactTypeId;
	private Long grfCrfTrnPk;
	private Double openingBalance;
	private Double closingBalance;
	private Double amountAdjusted;
	private Long transactionPkId;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
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

	public String getIntimationNo() {
		return intimationNo;
	}

	public void setIntimationNo(String intimationNo) {
		this.intimationNo = intimationNo;
	}

	public LocalDate getIntimationDt() {
		return intimationDt;
	}

	public void setIntimationDt(LocalDate intimationDt) {
		this.intimationDt = intimationDt;
	}

	public Double getTillDtProgPncpl() {
		return tillDtProgPncpl;
	}

	public void setTillDtProgPncpl(Double tillDtProgPncpl) {
		this.tillDtProgPncpl = tillDtProgPncpl;
	}

	public Double getIntimatedAmt() {
		return intimatedAmt;
	}

	public void setIntimatedAmt(Double intimatedAmt) {
		this.intimatedAmt = intimatedAmt;
	}

	public Double getAftThisProgPncpl() {
		return aftThisProgPncpl;
	}

	public void setAftThisProgPncpl(Double aftThisProgPncpl) {
		this.aftThisProgPncpl = aftThisProgPncpl;
	}

	public LocalDate getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(LocalDate transactionDt) {
		this.transactionDt = transactionDt;
	}

	public Long getGrfCrfTrnPk() {
		return grfCrfTrnPk;
	}

	public void setGrfCrfTrnPk(Long grfCrfTrnPk) {
		this.grfCrfTrnPk = grfCrfTrnPk;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Double getAmountAdjusted() {
		return amountAdjusted;
	}

	public void setAmountAdjusted(Double amountAdjusted) {
		this.amountAdjusted = amountAdjusted;
	}

	public Long getTransactionPkId() {
		return transactionPkId;
	}

	public void setTransactionPkId(Long transactionPkId) {
		this.transactionPkId = transactionPkId;
	}

}
