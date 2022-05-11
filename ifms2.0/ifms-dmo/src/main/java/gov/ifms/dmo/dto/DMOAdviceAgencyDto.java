package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DMOAdviceAgencyDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Advice agency Cd should not be null")
	private String adviceAgencyCd;
	
	@NotNull(message="Not null")
	private String adviceAgencyBy;
	
	private LocalDate effectiveFrmDt;
	
	private LocalDate effectiveToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdviceAgencyCd() {
		return adviceAgencyCd;
	}

	public void setAdviceAgencyCd(String adviceAgencyCd) {
		this.adviceAgencyCd = adviceAgencyCd;
	}

	public String getAdviceAgencyBy() {
		return adviceAgencyBy;
	}

	public void setAdviceAgencyBy(String adviceAgencyBy) {
		this.adviceAgencyBy = adviceAgencyBy;
	}

	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}
	
	 

}
