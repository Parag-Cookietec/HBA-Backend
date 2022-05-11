package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOWMATypesDto;
import gov.ifms.dmo.entity.DMOWMATypesEntity;

public interface DMOWMATypeService {

	PagebleDTO<DMOWMATypesEntity> wmaTypeListing(PageDetails pageDetail) throws CustomException;

	

	DMOWMATypesDto saveOrUpdate(DMOWMATypesDto dto);

}
