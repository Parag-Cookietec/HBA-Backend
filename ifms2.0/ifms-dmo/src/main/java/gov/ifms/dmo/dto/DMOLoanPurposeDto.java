package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DMOLoanPurposeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String loanPurpose;

	private String planSchemeName;

	private LocalDate effectiveFrmDt;

	private LocalDate effectiveToDt;

	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getPlanSchemeName() {
		return planSchemeName;
	}

	public void setPlanSchemeName(String planSchemeName) {
		this.planSchemeName = planSchemeName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
