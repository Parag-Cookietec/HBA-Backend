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
import gov.ifms.dmo.converter.DMOLoanPurposeConverter;
import gov.ifms.dmo.dto.DMOLoanPurposeDto;
import gov.ifms.dmo.entity.DMOLoanPurposeEntity;
import gov.ifms.dmo.repository.DMOLoanPurposeRepository;
import gov.ifms.dmo.service.DMOLoanPurposeService;

@Service
public class DMOLoanPurposeServiceImpl implements DMOLoanPurposeService {

	@Autowired
	DMOLoanPurposeRepository repository;

	@Autowired
	DMOLoanPurposeConverter converter;

	@Override
	public PagebleDTO<DMOLoanPurposeEntity> loanPurposeListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOLoanPurposeEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOLoanPurposeEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOLoanPurposeEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DMOLoanPurposeDto save(DMOLoanPurposeDto dto) {
		DMOLoanPurposeEntity entity = converter.toEntity(dto);
		return converter.toDTO(repository.save(entity));

	}

}
