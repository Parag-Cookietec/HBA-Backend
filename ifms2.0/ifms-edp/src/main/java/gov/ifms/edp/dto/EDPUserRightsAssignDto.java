package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * The Class EDPUserRightsAssignDto.
 */
public class EDPUserRightsAssignDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	@Min(1)
	private long empId;

	/** The post office user id. */
	private long postOfficeUserId;

	/** The edp user role mapping dto. */
	@Valid
	private EDPUserRoleMappingDto edpUserRoleMappingDto;

	/** The lst edp trn user menu role per dtos. */
	@Valid
	private List<EDPTrnUserMnuRolePrmDto> lstEdpTrnUserMenuRolePerDtos;
	
	/** The lst EDP menu wf dto. */
	private List<EDPMenuWfDto> lstEDPMenuWfDto;
	
	/**
	 * Gets the edp user role mapping dto.
	 *
	 * @return the edpUserRoleMappingDto
	 */
	public EDPUserRoleMappingDto getEdpUserRoleMappingDto() {
		return edpUserRoleMappingDto;
	}

	/**
	 * Sets the edp user role mapping dto.
	 *
	 * @param edpUserRoleMappingDto the edpUserRoleMappingDto to set
	 */
	public void setEdpUserRoleMappingDto(EDPUserRoleMappingDto edpUserRoleMappingDto) {
		this.edpUserRoleMappingDto = edpUserRoleMappingDto;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the post office user id.
	 *
	 * @return the postOfficeUserId
	 */
	public long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the postOfficeUserId to set
	 */
	public void setPostOfficeUserId(long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * Gets the lst edp trn user menu role per dtos.
	 *
	 * @return the lstEdpTrnUserMenuRolePerDtos
	 */
	public List<EDPTrnUserMnuRolePrmDto> getLstEdpTrnUserMenuRolePerDtos() {
		return lstEdpTrnUserMenuRolePerDtos;
	}

	/**
	 * Sets the lst edp trn user menu role per dtos.
	 *
	 * @param lstEdpTrnUserMenuRolePerDtos the lstEdpTrnUserMenuRolePerDtos to set
	 */
	public void setLstEdpTrnUserMenuRolePerDtos(List<EDPTrnUserMnuRolePrmDto> lstEdpTrnUserMenuRolePerDtos) {
		this.lstEdpTrnUserMenuRolePerDtos = lstEdpTrnUserMenuRolePerDtos;
	}

	


	public List<EDPMenuWfDto> getLstEDPMenuWfDto() {
		return lstEDPMenuWfDto;
	}

	public void setLstEDPMenuWfDto(List<EDPMenuWfDto> lstEDPMenuWfDto) {
		this.lstEDPMenuWfDto = lstEDPMenuWfDto;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(edpUserRoleMappingDto, empId, lstEDPMenuWfDto, lstEdpTrnUserMenuRolePerDtos,
				postOfficeUserId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPUserRightsAssignDto other = (EDPUserRightsAssignDto) obj;
		return Objects.equals(edpUserRoleMappingDto, other.edpUserRoleMappingDto) && empId == other.empId
				&& Objects.equals(lstEDPMenuWfDto, other.lstEDPMenuWfDto)
				&& Objects.equals(lstEdpTrnUserMenuRolePerDtos, other.lstEdpTrnUserMenuRolePerDtos)
				&& postOfficeUserId == other.postOfficeUserId;
	}

	@Override
	public String toString() {
		return "EDPUserRightsAssignDto [empId=" + empId + ", postOfficeUserId=" + postOfficeUserId
				+ ", edpUserRoleMappingDto=" + edpUserRoleMappingDto + ", lstEdpTrnUserMenuRolePerDtos="
				+ lstEdpTrnUserMenuRolePerDtos + ", lstEDPMenuWfDto=" + lstEDPMenuWfDto + "]";
	}


	/**
	 * @return the wfIds
	 */



}
