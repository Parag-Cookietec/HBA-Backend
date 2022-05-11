package gov.ifms.edp.report.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class CommonReportFieldDataDto.
 */
public class CommonReportFieldDataDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The field master dto. */
	private CommonFieldMasterDto fieldMasterDto;
	
	/** The clue dtos. */
	private List<CommonReportClueDto> clueDtos;

	/**
	 * Gets the field master dto.
	 *
	 * @return the field master dto
	 */
	public CommonFieldMasterDto getFieldMasterDto() {
		return fieldMasterDto;
	}

	/**
	 * Sets the field master dto.
	 *
	 * @param fieldMasterDto the new field master dto
	 */
	public void setFieldMasterDto(CommonFieldMasterDto fieldMasterDto) {
		this.fieldMasterDto = fieldMasterDto;
	}

	/**
	 * Gets the clue dtos.
	 *
	 * @return the clue dtos
	 */
	public List<CommonReportClueDto> getClueDtos() {
		return clueDtos;
	}

	/**
	 * Sets the clue dtos.
	 *
	 * @param clueDtos the new clue dtos
	 */
	public void setClueDtos(List<CommonReportClueDto> clueDtos) {
		this.clueDtos = clueDtos;
	}

}
