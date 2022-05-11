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
import gov.ifms.dmo.converter.DMODeparmentMinsistryConverter;
import gov.ifms.dmo.dto.DMODeparmentMinsistryDto;
import gov.ifms.dmo.entity.DMODEPTMinistry;
import gov.ifms.dmo.repository.DMODeparmentMinistryRepository;
import gov.ifms.dmo.service.DMODeparmentMinistryService;
@Service
public class DMODeparmentMinistryServiceImpl implements DMODeparmentMinistryService {
	@Autowired
	DMODeparmentMinistryRepository repository;
	
	@Autowired
	DMODeparmentMinsistryConverter converter;

	@Override
	public PagebleDTO<DMODEPTMinistry> deparmentMinistrylisting(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMODEPTMinistry> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMODEPTMinistry> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMODEPTMinistry> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public DMODeparmentMinsistryDto save(DMODeparmentMinsistryDto dto) {
		DMODEPTMinistry entity=converter.toEntity(dto);
		
		   return converter.toDTO(repository.save(entity));
				   
	
	}

	

	}


