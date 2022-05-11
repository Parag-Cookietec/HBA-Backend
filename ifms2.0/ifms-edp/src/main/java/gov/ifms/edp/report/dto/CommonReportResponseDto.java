package gov.ifms.edp.report.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The Class CommonReportResponseDto.
 */
public class CommonReportResponseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The header dtos. */
	private List<CommonReportHeaderDto> headerDtos;
	
	/** The data. */
	private transient List<Map<String, Object>> data;

	/**
	 * Gets the header dtos.
	 *
	 * @return the header dtos
	 */
	public List<CommonReportHeaderDto> getHeaderDtos() {
		return headerDtos;
	}

	/**
	 * Sets the header dtos.
	 *
	 * @param headerDtos the new header dtos
	 */
	public void setHeaderDtos(List<CommonReportHeaderDto> headerDtos) {
		this.headerDtos = headerDtos;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<Map<String, Object>> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	
}
