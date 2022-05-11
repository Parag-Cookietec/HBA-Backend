package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMODPSheetSearchDto;
import gov.ifms.dmo.dto.DMODPSheetSearchHDRPostDto;

public interface DMODPSheetListingService {

	PagebleDTO<DMODPSheetSearchDto> searchDPSheet(DMODPSheetSearchHDRPostDto dto) throws CustomException;

}
