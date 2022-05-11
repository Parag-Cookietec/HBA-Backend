package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "MDMO_LOAN_PURPOSE", schema = Constant.DMO_SCHEMA)
public class DMOLoanPurposeEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOAN_PURPOSE_ID")
	private Long id;
	
	@Column(name = "LOAN_PURPOSE")
	private String loanPurpose;
	
	@Column(name = "PLAN_SCHEME_NAME")
	private String planSchemeName;
	
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;
	
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
	 * @return the loanPurpose
	 */
	public String getLoanPurpose() {
		return loanPurpose;
	}

	/**
	 * @param loanPurpose the loanPurpose to set
	 */
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	/**
	 * @return the planSchemeName
	 */
	public String getPlanSchemeName() {
		return planSchemeName;
	}

	/**
	 * @param planSchemeName the planSchemeName to set
	 */
	public void setPlanSchemeName(String planSchemeName) {
		this.planSchemeName = planSchemeName;
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
