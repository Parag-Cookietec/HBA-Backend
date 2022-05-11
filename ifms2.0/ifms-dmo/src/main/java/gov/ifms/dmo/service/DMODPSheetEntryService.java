package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMODPDateSearchDto;
import gov.ifms.dmo.dto.DMODPSheetEntryDto;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;

public interface DMODPSheetEntryService {

	PagebleDTO<DMODPSheetEntryPostDto> dpSheetListing(PageDetails pageDetail) throws CustomException;

	DMODPSheetEntryPostDto findById(Long id);

	/**
	 * Convert given DMODPSheetHDREntryPostDto to DMODPSheetHDREntity
	 * Saves a given DMODPSheetHDREntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMODPSheetHDREntity
	 */
	DMODPSheetEntryDto saveOrUpdateDPSheet(DMODPSheetHDREntryPostDto dto);
	
	DMODPSheetHDREntryPostDto searchByDate(DMODPDateSearchDto dateSearchDto) throws CustomException;

	PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingGoi(PageDetails pageDetail) throws CustomException;
	PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingNssf(PageDetails pageDetail) throws CustomException;
	PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingMarket(PageDetails pageDetail) throws CustomException;
	PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingInstitute(PageDetails pageDetail) throws CustomException;

}
