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
import gov.ifms.dmo.converter.DMOGuarantorOrganizationsConverter;
import gov.ifms.dmo.dto.DMOGuarantorOrganizationsDto;

import gov.ifms.dmo.entity.DMOLoanGuarantorEntity;
import gov.ifms.dmo.repository.DMOGuarantorOrganizationsRepositry;
import gov.ifms.dmo.service.DMOGuarantorOrganizationsService;
@Service
public class DMOGuarantorOrganizationsServiceImpl implements DMOGuarantorOrganizationsService {
  
	@Autowired
	DMOGuarantorOrganizationsConverter converter;
	@Autowired
	DMOGuarantorOrganizationsRepositry repositry;

	
	@Override
	public DMOGuarantorOrganizationsDto saveOrUpdate(DMOGuarantorOrganizationsDto dto) {

		DMOLoanGuarantorEntity entity=converter.toEntity(dto);
		return converter.toDTO(repositry.save(entity));
	}


	@Override
	public PagebleDTO<DMOLoanGuarantorEntity> gurantorOrgListing(PageDetails pageDetail) throws CustomException {
	
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOLoanGuarantorEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOLoanGuarantorEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOLoanGuarantorEntity> page = repositry.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		
		
		
	
	}

}
