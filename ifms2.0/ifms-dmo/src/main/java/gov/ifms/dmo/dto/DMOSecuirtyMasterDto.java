package gov.ifms.dmo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

public class DMOSecuirtyMasterDto {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Name not should be empty")
	private String securityName;
	
	private LocalDate effectiveFrmDt;
	
	private LocalDate effectiveToDt;

	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
