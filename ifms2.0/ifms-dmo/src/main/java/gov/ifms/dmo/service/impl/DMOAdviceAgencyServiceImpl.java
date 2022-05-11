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
import gov.ifms.dmo.converter.DMOAdviceAgencyConverter;
import gov.ifms.dmo.dto.DMOAdviceAgencyDto;
import gov.ifms.dmo.entity.DMOAdviceAgencyEntity;
import gov.ifms.dmo.repository.DMOAdviceAgencyRepository;
import gov.ifms.dmo.service.DMOAdviceAgencyService;

@Service
public class DMOAdviceAgencyServiceImpl implements DMOAdviceAgencyService {

	@Autowired
	DMOAdviceAgencyRepository repository;

	@Autowired
	DMOAdviceAgencyConverter convert;

	@Override
	public PagebleDTO<DMOAdviceAgencyEntity> adviceAgencyListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOAdviceAgencyEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOAdviceAgencyEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOAdviceAgencyEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public DMOAdviceAgencyDto save(DMOAdviceAgencyDto dto) {
		DMOAdviceAgencyEntity entity = convert.toEntity(dto);
		return convert.toDTO(repository.save(entity));

	}

	@Override
	public DMOAdviceAgencyDto findById(Long id) {
		return convert.toDTO(repository.getOne(id) );
	}

}
