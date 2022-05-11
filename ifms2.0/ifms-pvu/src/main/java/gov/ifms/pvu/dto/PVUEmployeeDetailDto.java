package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;

/**
 * The Class PVUEmployeeDetailDto.
 */
public class PVUEmployeeDetailDto extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu employe dto. */
	private PVUEmployeDto pvuEmployeDto;

	/** The edp ms office dto. */
	private EDPMsOfficeDto edpMsOfficeDto;

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
	 * Gets the edp ms office dto.
	 *
	 * @return the edp ms office dto
	 */
	public EDPMsOfficeDto getEdpMsOfficeDto() {
		return edpMsOfficeDto;
	}

	/**
	 * Sets the edp ms office dto.
	 *
	 * @param edpMsOfficeDto the new edp ms office dto
	 */
	public void setEdpMsOfficeDto(EDPMsOfficeDto edpMsOfficeDto) {
		this.edpMsOfficeDto = edpMsOfficeDto;
	}
}
