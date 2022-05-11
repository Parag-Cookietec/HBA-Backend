package gov.ifms.dmo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOWMAConverter;
import gov.ifms.dmo.dto.DMOWMATypesDto;
import gov.ifms.dmo.entity.DMOWMATypesEntity;
import gov.ifms.dmo.repository.DMOWMATypeRepositry;
import gov.ifms.dmo.service.DMOWMATypeService;
@Service
public class DMOWMATypeServiceImpl implements DMOWMATypeService {

	@Autowired
	DMOWMATypeRepositry repositry;
	
	@Autowired
	DMOWMAConverter converter;

	@Override
	public PagebleDTO<DMOWMATypesEntity> wmaTypeListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOWMATypesEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOWMATypesEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOWMATypesEntity> page = repositry.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DMOWMATypesDto saveOrUpdate(DMOWMATypesDto dto) {
		
		DMOWMATypesEntity entity=converter.toEntity(dto);
		return converter.toDTO(repositry.save(entity));
		
	}
	
}
		
