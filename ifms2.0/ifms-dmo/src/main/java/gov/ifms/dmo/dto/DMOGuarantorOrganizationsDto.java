package gov.ifms.dmo.dto;

import java.time.LocalDate;

public class DMOGuarantorOrganizationsDto {

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long departmentId;
	
	private String departmentName;
	
	private String organizationName;
	
	private LocalDate startFrmDt;
	
	private LocalDate endToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDate getStartFrmDt() {
		return startFrmDt;
	}

	public void setStartFrmDt(LocalDate startFrmDt) {
		this.startFrmDt = startFrmDt;
	}

	public LocalDate getEndToDt() {
		return endToDt;
	}

	public void setEndToDt(LocalDate endToDt) {
		this.endToDt = endToDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
