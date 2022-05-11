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
import gov.ifms.dmo.converter.DMOSecuirtyMasterConverter;
import gov.ifms.dmo.dto.DMOSecuirtyMasterDto;
import gov.ifms.dmo.entity.DMOSecuirtyMasterEntity;
import gov.ifms.dmo.repository.DMOSecuirtyMasterRepository;
import gov.ifms.dmo.service.DMOSecuirtyMasterService;
@Service
public class DMOSecuirtyMasterServiceImpl implements DMOSecuirtyMasterService {
@Autowired
DMOSecuirtyMasterRepository repository;
@Autowired
DMOSecuirtyMasterConverter converter;
	@Override
	public PagebleDTO<DMOSecuirtyMasterEntity> secuirtyMasterListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOSecuirtyMasterEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOSecuirtyMasterEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOSecuirtyMasterEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	
	}
	@Override
	public DMOSecuirtyMasterDto save(DMOSecuirtyMasterDto dto) {
		DMOSecuirtyMasterEntity entity=converter.toEntity(dto);
		return converter.toDTO(repository.save(entity));
	}

}
