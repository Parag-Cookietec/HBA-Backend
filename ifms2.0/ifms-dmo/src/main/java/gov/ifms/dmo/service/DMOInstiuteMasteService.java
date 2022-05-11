package gov.ifms.dmo.service;


import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOInstiuteMasterDto;

import gov.ifms.dmo.entity.DMOInstiuteMasterEntity;

public interface DMOInstiuteMasteService {
	
	
	DMOInstiuteMasterDto save(DMOInstiuteMasterDto dto);

	PagebleDTO<DMOInstiuteMasterEntity> instiuteNameListing(PageDetails pageDetail) throws CustomException;
	
	

}
