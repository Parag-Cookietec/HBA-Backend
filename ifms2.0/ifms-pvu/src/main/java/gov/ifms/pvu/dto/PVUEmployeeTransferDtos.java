package gov.ifms.pvu.dto;

import java.util.List;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeTransferDtos.
 */
public class PVUEmployeeTransferDtos extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pvu transfer dto. */
	private PVUTransferDto pvuTransferDto;

	/** The pvu transfer employee dto. */
	private List<PVUTransferEmployeeDto> pvuTransferEmployeeDto;

	/**
	 * Gets the pvu transfer dto.
	 *
	 * @return the pvu transfer dto
	 */
	public PVUTransferDto getPvuTransferDto() {
		return pvuTransferDto;
	}

	/**
	 * Sets the pvu transfer dto.
	 *
	 * @param pvuTransferDto the new pvu transfer dto
	 */
	public void setPvuTransferDto(PVUTransferDto pvuTransferDto) {
		this.pvuTransferDto = pvuTransferDto;
	}

	/**
	 * Gets the pvu transfer employee dto.
	 *
	 * @return the pvu transfer employee dto
	 */
	public List<PVUTransferEmployeeDto> getPvuTransferEmployeeDto() {
		return pvuTransferEmployeeDto;
	}

	/**
	 * Sets the pvu transfer employee dto.
	 *
	 * @param pvuTransferEmployeeDto the new pvu transfer employee dto
	 */
	public void setPvuTransferEmployeeDto(List<PVUTransferEmployeeDto> pvuTransferEmployeeDto) {
		this.pvuTransferEmployeeDto = pvuTransferEmployeeDto;
	}
}
