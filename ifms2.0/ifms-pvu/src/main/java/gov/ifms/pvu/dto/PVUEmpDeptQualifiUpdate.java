package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;

public class PVUEmpDeptQualifiUpdate implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu employe dto. */
	private PVUEmployeDto pvuEmployeDto;
	/** The pvu employe address dto. */
	private PVUEmployeAddressDto pvuEmployeAddressDto;

	/** The pvu employe nominee dto. */
	private List<PVUEmployeNomineeDto> pvuEmployeNomineeDto;

	private PVUEmployeDepartmentUpdateDtos departmentDto;
	
	private PVUEmployeeQualificationUpdateDtos qualificationDto;
	
	private long roleId;

	/**
	 * @return the pvuEmployeDto
	 */
	public PVUEmployeDto getPvuEmployeDto() {
		return pvuEmployeDto;
	}

	/**
	 * @param pvuEmployeDto the pvuEmployeDto to set
	 */
	public void setPvuEmployeDto(PVUEmployeDto pvuEmployeDto) {
		this.pvuEmployeDto = pvuEmployeDto;
	}

	/**
	 * @return the pvuEmployeAddressDto
	 */
	public PVUEmployeAddressDto getPvuEmployeAddressDto() {
		return pvuEmployeAddressDto;
	}

	/**
	 * @param pvuEmployeAddressDto the pvuEmployeAddressDto to set
	 */
	public void setPvuEmployeAddressDto(PVUEmployeAddressDto pvuEmployeAddressDto) {
		this.pvuEmployeAddressDto = pvuEmployeAddressDto;
	}

	/**
	 * @return the pvuEmployeNomineeDto
	 */
	public List<PVUEmployeNomineeDto> getPvuEmployeNomineeDto() {
		return pvuEmployeNomineeDto;
	}

	/**
	 * @param pvuEmployeNomineeDto the pvuEmployeNomineeDto to set
	 */
	public void setPvuEmployeNomineeDto(List<PVUEmployeNomineeDto> pvuEmployeNomineeDto) {
		this.pvuEmployeNomineeDto = pvuEmployeNomineeDto;
	}

	/**
	 * @return the departmentDto
	 */
	public PVUEmployeDepartmentUpdateDtos getDepartmentDto() {
		return departmentDto;
	}

	/**
	 * @param departmentDto the departmentDto to set
	 */
	public void setDepartmentDto(PVUEmployeDepartmentUpdateDtos departmentDto) {
		this.departmentDto = departmentDto;
	}

	/**
	 * @return the qualificationDto
	 */
	public PVUEmployeeQualificationUpdateDtos getQualificationDto() {
		return qualificationDto;
	}

	/**
	 * @param qualificationDto the qualificationDto to set
	 */
	public void setQualificationDto(PVUEmployeeQualificationUpdateDtos qualificationDto) {
		this.qualificationDto = qualificationDto;
	}
	/**
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "PVUEmpDeptQualifiUpdate [pvuEmployeDto=" + pvuEmployeDto + ", pvuEmployeAddressDto="
				+ pvuEmployeAddressDto + ", pvuEmployeNomineeDto=" + pvuEmployeNomineeDto + ", departmentDto="
				+ departmentDto + ", qualificationDto=" + qualificationDto + "]";
	}

}
