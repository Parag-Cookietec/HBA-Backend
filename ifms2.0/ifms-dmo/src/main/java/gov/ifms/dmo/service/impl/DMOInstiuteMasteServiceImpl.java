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

import gov.ifms.dmo.converter.DMOInstiuteMasterConverter;
import gov.ifms.dmo.dto.DMOInstiuteMasterDto;

import gov.ifms.dmo.entity.DMOInstiuteMasterEntity;
import gov.ifms.dmo.repository.DMOInstiuteMasteRepositry;
import gov.ifms.dmo.service.DMOInstiuteMasteService;
@Service
public class DMOInstiuteMasteServiceImpl implements DMOInstiuteMasteService{
 
	@Autowired
	DMOInstiuteMasteRepositry repositry;
	@Autowired
	DMOInstiuteMasterConverter converter;
	@Override
	public DMOInstiuteMasterDto save(DMOInstiuteMasterDto dto)  {
		DMOInstiuteMasterEntity entity=converter.toEntity(dto);
		return converter.toDTO(repositry.save(entity));
	
	}

	@Override
	public PagebleDTO<DMOInstiuteMasterEntity> instiuteNameListing(PageDetails pageDetail) throws CustomException {
		
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOInstiuteMasterEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMOInstiuteMasterEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMOInstiuteMasterEntity> page = repositry.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		
	}

	

}
