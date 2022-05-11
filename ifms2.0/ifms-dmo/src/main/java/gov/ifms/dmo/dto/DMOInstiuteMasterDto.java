package gov.ifms.dmo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

public class DMOInstiuteMasterDto  {
	
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	@NotEmpty(message = "Institue name not empty")
	private String instituteName;
	
	private LocalDate effectiveFrmDt;
	
	
	private LocalDate effectiveToDt;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getInstituteName() {
		return instituteName;
	}


	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
