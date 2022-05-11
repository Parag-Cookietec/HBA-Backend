package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMODeparmentMinsistryDto;
import gov.ifms.dmo.entity.DMODEPTMinistry;

public interface DMODeparmentMinistryService {

	PagebleDTO<DMODEPTMinistry> deparmentMinistrylisting(PageDetails pageDetail) throws CustomException;

	

	DMODeparmentMinsistryDto save(DMODeparmentMinsistryDto dto);
	
	
}
