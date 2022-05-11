package gov.ifms.loc.service;

import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocDistributionHdrViewDto;
import gov.ifms.loc.dto.LocDistributionListingDto;
import gov.ifms.loc.dto.LocDistributionSrchParamDto;
import gov.ifms.loc.dto.LocDistributionSubmitDto;


/**
 * The Interface LocDistributionService.
 */
public interface LocDistributionService {

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	LocDistributionSrchParamDto getSearchParam() throws CustomException;

	/**
	 * Submit.
	 *
	 * @param dto the dto
	 * @return the loc distribution submit dto
	 * @throws CustomException the custom exception
	 */
	LocDistributionSubmitDto submit(LocDistributionSubmitDto dto) throws CustomException;

	/**
	 * Gets the listing data.
	 *
	 * @param pageDetails the page details
	 * @return the listing data
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocDistributionListingDto> getListingData(PageDetails pageDetails) throws CustomException;

	/**
	 * Gets the edits the view.
	 *
	 * @param dto the dto
	 * @return the edits the view
	 * @throws CustomException the custom exception
	 */
	LocDistributionHdrViewDto getEditView(IdDto dto) throws CustomException;
	
	/**
	 * Prints the form B.
	 *
	 * @param dto the dto
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	Map<String,Object> printFormB(IdDto dto) throws CustomException;
	
	/**
	 * Prints the form A.
	 *
	 * @param dto the dto
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	Map<String,Object> printFormA(IdDto dto) throws CustomException;
}
