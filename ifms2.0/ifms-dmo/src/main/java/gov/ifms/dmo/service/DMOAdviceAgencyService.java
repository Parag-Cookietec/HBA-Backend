package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOAdviceAgencyDto;
import gov.ifms.dmo.entity.DMOAdviceAgencyEntity;

public interface DMOAdviceAgencyService {

	PagebleDTO<DMOAdviceAgencyEntity> adviceAgencyListing(PageDetails pageDetail) throws CustomException;

	DMOAdviceAgencyDto findById(Long id);

	DMOAdviceAgencyDto save(DMOAdviceAgencyDto dto);

	

}
