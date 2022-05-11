package gov.ifms.pvu.dto;

import java.util.List;

import javax.validation.Valid;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeDepartmentDtos.
 */
public class PVUEmployeDepartmentDtos extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5484616904127607165L;

	/** The pvu employe department dto. */
	@Valid
	private PVUEmployeDepartmentDto pvuEmployeDepartmentDto;

	/** The pvu employe history dto. */
	@Valid

	private List<PVUEmployeHistoryDto> pvuEmployeHistoryDto;

	/**
	 * Gets the pvu employe department dto.
	 *
	 * @return the pvu employe department dto
	 */
	public PVUEmployeDepartmentDto getPvuEmployeDepartmentDto() {
		return pvuEmployeDepartmentDto;
	}

	/**
	 * Sets the pvu employe department dto.
	 *
	 * @param pvuEmployeDepartmentDto the new pvu employe department dto
	 */
	public void setPvuEmployeDepartmentDto(PVUEmployeDepartmentDto pvuEmployeDepartmentDto) {
		this.pvuEmployeDepartmentDto = pvuEmployeDepartmentDto;
	}

	/**
	 * Gets the pvu employe history dto.
	 *
	 * @return the pvu employe history dto
	 */
	public List<PVUEmployeHistoryDto> getPvuEmployeHistoryDto() {
		return pvuEmployeHistoryDto;
	}

	/**
	 * Sets the pvu employe history dto.
	 *
	 * @param pvuEmployeHistoryDto the new pvu employe history dto
	 */
	public void setPvuEmployeHistoryDto(List<PVUEmployeHistoryDto> pvuEmployeHistoryDto) {
		this.pvuEmployeHistoryDto = pvuEmployeHistoryDto;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeDepartmentDtos [pvuEmployeDepartmentDto=" + pvuEmployeDepartmentDto
				+ ", pvuEmployeHistoryDto=" + pvuEmployeHistoryDto + "]";
	}

}
