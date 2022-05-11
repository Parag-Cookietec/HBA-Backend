package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class PVUEmployeDepartmentDtos.
 */
public class PVUEmployeDepartmentUpdateDtos implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5484616904127607165L;

	/** The pvu employe department dto. */ 
	private PVUEmployeDepartmentEditabelDto pvuEmployeDepartmentDto;

	/** The pvu employe history dto. */
	private List<PVUEmployeHistoryEditFormdataDto> pvuEmployeHistoryDto;
	
	/**
	 * @return the pvuEmployeHistoryDto
	 */
	public List<PVUEmployeHistoryEditFormdataDto> getPvuEmployeHistoryDto() {
		return pvuEmployeHistoryDto;
	}

	/**
	 * @param pvuEmployeHistoryDto the pvuEmployeHistoryDto to set
	 */
	public void setPvuEmployeHistoryDto(List<PVUEmployeHistoryEditFormdataDto> pvuEmployeHistoryDto) {
		this.pvuEmployeHistoryDto = pvuEmployeHistoryDto;
	}

	/**
	 * @return the pvuEmployeDepartmentDto
	 */
	public PVUEmployeDepartmentEditabelDto getPvuEmployeDepartmentDto() {
		return pvuEmployeDepartmentDto;
	}

	/**
	 * @param pvuEmployeDepartmentDto the pvuEmployeDepartmentDto to set
	 */
	public void setPvuEmployeDepartmentDto(PVUEmployeDepartmentEditabelDto pvuEmployeDepartmentDto) {
		this.pvuEmployeDepartmentDto = pvuEmployeDepartmentDto;
	}


	@Override
	public String toString() {
		return "PVUEmployeDepartmentUpdateDtos [pvuEmployeDepartmentDto=" + pvuEmployeDepartmentDto
				+ ", pvuEmployeHistoryDto=" + pvuEmployeHistoryDto + "]";
	}

}
