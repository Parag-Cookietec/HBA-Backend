package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPReportPageDetails;

public interface EDPReportsService {

	/**
	 * Edp generate report.
	 *
	 * @param pageDetail the page detail
	 * @return the object
	 * @throws CustomException the custom exception
	 */
	Object edpGenerateReport(EDPReportPageDetails pageDetail) throws CustomException;

	/**
	 * Edp generate report.
	 *
	 * @param id the id
	 * @return the list
	 * @throws CustomException 
	 */
	ClueDto edpGenerateReportFilterData(Long id) throws CustomException;
	
	/**
	 * Gets the post details post report.
	 *
	 * @return the post details post report
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getPostDetailsPostReport(Long officeId) throws CustomException;
	
}
