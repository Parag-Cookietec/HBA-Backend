package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

public class DMODeparmentMinsistryDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	@NotEmpty(message = "Dept name not empty")
	private String deptMinistryName;
	
	private String deptMinistryGuj;  
	
	private LocalDate effectiveFrmDt;
	
	private LocalDate effectiveToDt;

	public String getDeptMinistryGuj() {
		return deptMinistryGuj;
	}

	public void setDeptMinistryGuj(String deptMinistryGuj) {
		this.deptMinistryGuj = deptMinistryGuj;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptMinistryName() {
		return deptMinistryName;
	}

	public void setDeptMinistryName(String deptMinistryName) {
		this.deptMinistryName = deptMinistryName;
	}

}
