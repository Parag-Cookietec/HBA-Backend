package gov.ifms.gst.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.dto.GSTBankRateMasterDto;
import gov.ifms.gst.dto.GSTBankRateMasterListingDto;

import java.text.ParseException;

public interface GSTBankRateMasterService {

	/**
	 * Fetch Bank Rate GST Master by given  id
	 * 
	 * @param id
	 * @return dto
	 */
	GSTBankRateMasterDto getBankRateMaster(Long id);


	/**
	 * creates a new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	GSTBankRateMasterDto createBankRateMaster(GSTBankRateMasterDto dto) throws CustomException;

	/**
	 * Update the new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	GSTBankRateMasterDto updateBankRateMaster(GSTBankRateMasterDto dto);

	/**
	 * Gets the Bank Rate GST Master.
	 *
	 * @param pageDetail the page detail
	 * @return the Bank Rate GST Masters
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<GSTBankRateMasterDto> getBankRateMasters(PageDetails pageDetail) throws CustomException;

    PagebleDTO<GSTBankRateMasterListingDto> getBankRateMasterListing(PageDetails pageDetail) throws CustomException, ParseException;
}
