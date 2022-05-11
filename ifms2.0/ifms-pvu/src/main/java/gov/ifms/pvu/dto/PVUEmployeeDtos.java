package gov.ifms.pvu.dto;

import java.util.List;

import javax.validation.Valid;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeDtos.
 */
public class PVUEmployeeDtos extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu employe dto. */
	@Valid
	private PVUEmployeDto pvuEmployeDto;

	/** The pvu employe address dto. */

	@Valid
	private PVUEmployeAddressDto pvuEmployeAddressDto;

	/** The pvu employe nominee dto. */
	@Valid
	private List<PVUEmployeNomineeDto> pvuEmployeNomineeDto;

	/**
	 * Instantiates a new PVU employee dtos.
	 */
	public PVUEmployeeDtos() {
		super();
	}

	/**
	 * Gets the pvu employe address dto.
	 *
	 * @return the pvu employe address dto
	 */

	public PVUEmployeAddressDto getPvuEmployeAddressDto() {
		return pvuEmployeAddressDto;
	}

	/**
	 * Sets the pvu employe address dto.
	 *
	 * @param pvuEmployeAddressDto the new pvu employe address dto
	 */

	public void setPvuEmployeAddressDto(PVUEmployeAddressDto pvuEmployeAddressDto) {
		this.pvuEmployeAddressDto = pvuEmployeAddressDto;
	}

	/**
	 * Gets the pvu employe dto.
	 *
	 * @return the pvu employe dto
	 */
	public PVUEmployeDto getPvuEmployeDto() {
		return pvuEmployeDto;
	}

	/**
	 * Sets the pvu employe dto.
	 *
	 * @param pvuEmployeDto the new pvu employe dto
	 */
	public void setPvuEmployeDto(PVUEmployeDto pvuEmployeDto) {
		this.pvuEmployeDto = pvuEmployeDto;
	}

	/**
	 * Gets the pvu employe nominee dto.
	 *
	 * @return the pvu employe nominee dto
	 */

	public List<PVUEmployeNomineeDto> getPvuEmployeNomineeDto() {
		return pvuEmployeNomineeDto;
	}

	/**
	 * Sets the pvu employe nominee dto.
	 *
	 * @param pvuEmployeNomineeDto the new pvu employe nominee dto
	 */

	public void setPvuEmployeNomineeDto(List<PVUEmployeNomineeDto> pvuEmployeNomineeDto) {
		this.pvuEmployeNomineeDto = pvuEmployeNomineeDto;
	}

}
