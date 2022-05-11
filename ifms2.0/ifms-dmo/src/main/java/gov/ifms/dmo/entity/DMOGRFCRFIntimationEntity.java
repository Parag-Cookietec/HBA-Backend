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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_INTIMATION", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFIntimationEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The is GRF_CRF_INTIMATION_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRF_CRF_INTIMATION_ID")
	private Long id;

	/** The is ACCOUNT_TYPE_ID. */
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;

	/** The is TRANSACT_TYPE_ID. */
	@Column(name = "TRANSACT_TYPE_ID")
	private Long transactTypeId;

	/** The is REFERENCE_NO. */
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	/** The is REFERENCE_DT. */
	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	/** The is INTIMATION_NO. */
	@Column(name = "INTIMATION_NO")
	private String intimationNo;

	/** The is INTIMATION_DT. */
	@NotNull
	@Column(name = "INTIMATION_DT")
	private LocalDate intimationDt;

	/** The is TILL_DT_PROG_PNCPL. */
	@NotNull
	@Column(name = "TILL_DT_PROG_PNCPL")
	private Double tillDtProgPncpl;

	/** The is INTIMATED_AMT. */
	@Column(name = "INTIMATED_AMT")
	private Double intimatedAmt;

	/** The is AFT_THIS_PROG_PNCPL. */
	@Column(name = "AFT_THIS_PROG_PNCPL")
	private Double aftThisProgPncpl;

	/** The is TRANSACTION_DT. */
	@Column(name = "TRANSACTION_DT")
	private LocalDate transactionDt;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "intimationEntity", cascade = CascadeType.ALL)
	private List<DMOGRFCRFAccountEntity> grfCrfAccounts = new ArrayList<>();

	public List<DMOGRFCRFAccountEntity> getGrfCrfAccounts() {
		return grfCrfAccounts;
	}

	public void addAccountEntity(DMOGRFCRFAccountEntity accountEntity) {
		this.grfCrfAccounts.add(accountEntity);
	}

	public void setGrfCrfAccounts(List<DMOGRFCRFAccountEntity> grfCrfAccounts) {
		this.grfCrfAccounts = grfCrfAccounts;
	}

	/**
	 * 
	 * @return the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
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

}
