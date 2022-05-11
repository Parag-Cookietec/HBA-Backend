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
@Table(name = "MDMO_LOAN_ESTIMATE", schema = Constant.DMO_SCHEMA)
public class DMOLoanEstimateEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The is LOAN_ESTIMATE_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOAN_ESTIMATE_ID")
	private Long id;

	/** The DMO lu look up entity. */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "FINANCIAL_YEAR_ID", referencedColumnName = "FINANCIAL_YEAR_ID")
	private DMOMsFinancialYearEntity dmoMsFinancialYearEntity;


	public DMOMsFinancialYearEntity getDmoMsFinancialYearEntity() {
		return dmoMsFinancialYearEntity;
	}

	public void setDmoMsFinancialYearEntity(DMOMsFinancialYearEntity dmoMsFinancialYearEntity) {
		this.dmoMsFinancialYearEntity = dmoMsFinancialYearEntity;
	}

	/** The is NSSF_LOAN_AMT. */
	@Column(name = "NSSF_LOAN_AMT")
	private Double nssfLoanAmt;

	/** The is MARKET_LOAN_AMT. */
	@Column(name = "MARKET_LOAN_AMT")
	private Double marketLoanAmt;

	/** The is GOI_LOAN_AMT. */
	@Column(name = "GOI_LOAN_AMT")
	private Double goiLoanAmt;

	/** The is INSTITUTE_LOAN_AMT. */
	@Column(name = "INSTITUTE_LOAN_AMT")
	private Double instituteLoanAmt;

	/** The is EFFECTIVE_FRM_DT. */
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;

	/** The is EFFECTIVE_TO_DT. */
	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nssfLoanAmt
	 */
	public Double getNssfLoanAmt() {
		return nssfLoanAmt;
	}

	/**
	 * @param nssfLoanAmt the nssfLoanAmt to set
	 */
	public void setNssfLoanAmt(Double nssfLoanAmt) {
		this.nssfLoanAmt = nssfLoanAmt;
	}

	/**
	 * @return the marketLoanAmt
	 */
	public Double getMarketLoanAmt() {
		return marketLoanAmt;
	}

	/**
	 * @param marketLoanAmt the marketLoanAmt to set
	 */
	public void setMarketLoanAmt(Double marketLoanAmt) {
		this.marketLoanAmt = marketLoanAmt;
	}

	/**
	 * @return the goiLoanAmt
	 */
	public Double getGoiLoanAmt() {
		return goiLoanAmt;
	}

	/**
	 * @param goiLoanAmt the goiLoanAmt to set
	 */
	public void setGoiLoanAmt(Double goiLoanAmt) {
		this.goiLoanAmt = goiLoanAmt;
	}

	/**
	 * @return the instituteLoanAmt
	 */
	public Double getInstituteLoanAmt() {
		return instituteLoanAmt;
	}

	/**
	 * @param instituteLoanAmt the instituteLoanAmt to set
	 */
	public void setInstituteLoanAmt(Double instituteLoanAmt) {
		this.instituteLoanAmt = instituteLoanAmt;
	}

	/**
	 * @return the effectiveFrmDt
	 */
	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	/**
	 * @param effectiveFrmDt the effectiveFrmDt to set
	 */
	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	/**
	 * @return the effectiveToDt
	 */
	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	/**
	 * @param effectiveToDt the effectiveToDt to set
	 */
	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}

}
