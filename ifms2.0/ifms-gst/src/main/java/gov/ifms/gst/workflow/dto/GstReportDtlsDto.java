package gov.ifms.gst.workflow.dto;

import java.util.List;

/**
 * The Class GstReportDtlsDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsDto {	
	

	private List<GstReportDtlsEodcinDto> gstReportDtlsEodcinDto;
	
	public GstReportDtlsDto() {
		
	}

	public GstReportDtlsDto(final List<GstReportDtlsEodcinDto> gstReportDtlsEodcinDto) {
		super();
		this.gstReportDtlsEodcinDto = gstReportDtlsEodcinDto;
	}

	public List<GstReportDtlsEodcinDto> getGstReportDtlsEodcinDto() {
		return gstReportDtlsEodcinDto;
	}

	public void setGstReportDtlsEodcinDto(final List<GstReportDtlsEodcinDto> gstReportDtlsEodcinDto) {
		this.gstReportDtlsEodcinDto = gstReportDtlsEodcinDto;
	}
	
	
}
