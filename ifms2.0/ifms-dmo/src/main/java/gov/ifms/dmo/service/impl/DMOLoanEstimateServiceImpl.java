package gov.ifms.dmo.service.impl;

import java.util.Objects;

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
import gov.ifms.dmo.converter.DMOLoanEstimateConverter;
import gov.ifms.dmo.dto.DMOLoanEstimateDto;
import gov.ifms.dmo.entity.DMOLoanEstimateEntity;
import gov.ifms.dmo.entity.DMOMsFinancialYearEntity;
import gov.ifms.dmo.repository.DMOLoanEstimateRepository;
import gov.ifms.dmo.service.DMOLoanEstimateService;
@Service
public class DMOLoanEstimateServiceImpl implements DMOLoanEstimateService {
 
	@Autowired
	DMOLoanEstimateRepository repositry;
	@Autowired
	DMOLoanEstimateConverter converter;
	@Override
	public PagebleDTO<DMOLoanEstimateEntity> loanEstimateListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOLoanEstimateEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOLoanEstimateEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOLoanEstimateEntity> page = repositry.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	@Override
	public DMOLoanEstimateDto save(DMOLoanEstimateDto dto) {
		
		DMOLoanEstimateEntity entity=converter.toEntity(dto);
		if(Objects.nonNull(dto.getFinancialYearId())) {
		entity.setDmoMsFinancialYearEntity(new DMOMsFinancialYearEntity(dto.getFinancialYearId()));
		}
		return converter.toDTO(repositry.save(entity));
	}
	

}
