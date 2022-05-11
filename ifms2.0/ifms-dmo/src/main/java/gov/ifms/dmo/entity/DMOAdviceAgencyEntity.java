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
@Table(name = "MDMO_ADVICE_AGENCY", schema = Constant.DMO_SCHEMA)
public class DMOAdviceAgencyEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	/** The is ADVICE_AGENCY_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADVICE_AGENCY_ID")
	private Long id;

	/** The is ADVICE_AGENCY_CD. */
	@Column(name = "ADVICE_AGENCY_CD")
	private String adviceAgencyCd;
	
	/** The is ADVICE_AGENCY_BY. */
	@Column(name = "ADVICE_AGENCY_BY")
	private String adviceAgencyBy;
	
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
	 * @return the adviceAgencyCd
	 */
	public String getAdviceAgencyCd() {
		return adviceAgencyCd;
	}

	/**
	 * @param adviceAgencyCd the adviceAgencyCd to set
	 */
	public void setAdviceAgencyCd(String adviceAgencyCd) {
		this.adviceAgencyCd = adviceAgencyCd;
	}

	/**
	 * @return the adviceAgencyBy
	 */
	public String getAdviceAgencyBy() {
		return adviceAgencyBy;
	}

	/**
	 * @param adviceAgencyBy the adviceAgencyBy to set
	 */
	public void setAdviceAgencyBy(String adviceAgencyBy) {
		this.adviceAgencyBy = adviceAgencyBy;
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
