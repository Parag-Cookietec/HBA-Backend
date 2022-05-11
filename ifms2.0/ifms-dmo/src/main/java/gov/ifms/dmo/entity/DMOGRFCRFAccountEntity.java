package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_ACCOUNT", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFAccountEntity extends BaseEntity implements Serializable {
	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The is GRF_CRF_ACC_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRF_CRF_ACC_ID")
	private Long id;

	/** The is ACCOUNT_TYPE_ID. */
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;

	/** The is GRF_CRF_TRN_PK. */
	@Column(name = "GRF_CRF_TRN_PK")
	private Long grfCrfTrnPk;

	/** The is OPENING_BALANCE. */
	@Column(name = "OPENING_BALANCE")
	private Double openingBalance;

	/** The is CLOSING_BALANCE. */
	@Column(name = "CLOSING_BALANCE")
	private Double closingBalance;

	/** The is AMOUNT_ADJUSTED. */
	@Column(name = "AMOUNT_ADJUSTED")
	private Double amountAdjusted;

	/** The is TRANSACTION_DT. */
	@Column(name = "TRANSACTION_DT")
	private LocalDate transactionDt;

	/** The is TRANSACTION_PK_ID. */
	@Column(name = "TRANSACT_PK_TBL_NAME")
	private String transactPkTblName;

	/** The is GRF_CRF_INTIMATION_ID. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GRF_CRF_TRN_PK", referencedColumnName = "GRF_CRF_INTIMATION_ID", insertable = false, updatable = false)
	private DMOGRFCRFIntimationEntity intimationEntity;

	public DMOGRFCRFIntimationEntity getIntimationEntity() {
		return intimationEntity;
	}

	public void setIntimationEntity(DMOGRFCRFIntimationEntity intimationEntity) {
		this.intimationEntity = intimationEntity;
	}
	
	

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

	public LocalDate getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(LocalDate transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactPkTblName() {
		return transactPkTblName;
	}

	public void setTransactPkTblName(String transactPkTblName) {
		this.transactPkTblName = transactPkTblName;
	}
}
