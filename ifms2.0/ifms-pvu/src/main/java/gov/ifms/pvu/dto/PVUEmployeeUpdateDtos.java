package gov.ifms.pvu.dto;

import java.util.List;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeDtos.
 */
public class PVUEmployeeUpdateDtos extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu employe dto. */
	private PVUEmployeDto pvuEmployeDto;

	/** The pvu employe address dto. */

	private PVUEmployeAddressDto pvuEmployeAddressDto;

	/** The pvu employe nominee dto. */

	private List<PVUEmployeNomineeDto> pvuEmployeNomineeDto;

	/**
	 * Instantiates a new PVU employee dtos.
	 */
	public PVUEmployeeUpdateDtos() {
		super();
	}

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

	
}
