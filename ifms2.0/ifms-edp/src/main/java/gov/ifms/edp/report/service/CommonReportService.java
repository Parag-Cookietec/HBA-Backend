package gov.ifms.edp.report.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.report.dto.CommonReportMasterDto;
import gov.ifms.edp.report.dto.CommonReportPageDetails;
import gov.ifms.edp.report.dto.CommonReportResponseDto;
import gov.ifms.edp.report.dto.CommonReportScreenDisplayResponseDto;
import gov.ifms.edp.report.dto.CommonReportViewPageDetails;

/**
 * The Interface CommonReportService.
 */
public interface CommonReportService {

	/**
	 * Generate report.
	 *
	 * @param pageDetails the page details
	 * @return the object
	 * @throws CustomException the custom exception
	 */
	public Object generateReport(CommonReportPageDetails pageDetails) throws CustomException;
	
	/**
	 * Gets the screen display details.
	 *
	 * @param reportMasterDto the report master dto
	 * @return the screen display details
	 */
	public CommonReportScreenDisplayResponseDto getScreenDisplayDetails(CommonReportMasterDto reportMasterDto); 
	
	/**
	 * View report details.
	 *
	 * @param pageDetails the page details
	 * @return the common report response dto
	 * @throws CustomException the custom exception
	 */
	public CommonReportResponseDto viewReportDetails(CommonReportViewPageDetails pageDetails) throws CustomException;
}
