package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOSecuirtyMasterDto;
import gov.ifms.dmo.entity.DMOSecuirtyMasterEntity;

public interface DMOSecuirtyMasterService {

	PagebleDTO<DMOSecuirtyMasterEntity> secuirtyMasterListing(PageDetails pageDetail) throws CustomException;

	DMOSecuirtyMasterDto save(DMOSecuirtyMasterDto dto);

}
