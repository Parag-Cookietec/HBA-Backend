/**
 * 
 */
package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;

import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.jpa.converter.DoJpaClaimListingConverter;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingRequestDTO;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingResponseDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchCriteria;
import gov.ifms.doi.jpa.pagination.SpecificationImplimentation;
import gov.ifms.doi.jpa.repository.DoiJPAClaimEntryEntitySpecification;
import gov.ifms.doi.jpa.repository.DoiJpaClaimListingRepository;
import gov.ifms.doi.jpa.service.DoiJpaClaimListingService;

/**
 * @author Rudra
 *
 */
@Service
public class DoiJpaClaimListingServiceImpl implements DoiJpaClaimListingService{

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private DoiJpaClaimListingRepository doiJPAClaimListingRepository;
	@Autowired
	private DoJpaClaimListingConverter converter;
	
	@Override
	public List<DoiJpaClaimListingResponseDTO> getJPAClaimListing(DoiJpaClaimListingRequestDTO dto) {
		List<DoiJPAClaimEntryEntity> responseEntityList = doiJPAClaimListingRepository.findAll(new DoiJPAClaimEntryEntitySpecification(dto));
		return converter.toDtoListFromEntityList(responseEntityList);
	}

	@Override
	public PagebleDTO<DoiJpaClaimListingResponseDTO> getJPAClaimListingPage(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiJPAClaimEntryEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiJPAClaimEntryEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiJPAClaimEntryEntity> page = doiJPAClaimListingRepository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDtoListFromEntityList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
