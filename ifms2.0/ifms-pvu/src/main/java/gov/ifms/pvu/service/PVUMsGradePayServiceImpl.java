package gov.ifms.pvu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import gov.ifms.pvu.converter.PVUMsGradePayConverter;
import gov.ifms.pvu.dto.PVUMsGradePayDto;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;


/**
 * The Class PVUGradePayServiceImpl.
 *
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 */
@Service
public class PVUMsGradePayServiceImpl implements PVUMsGradePayService {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUGradePayRepository repository. */
	@Autowired
	private PVUMsGradePayRepository repository;
	
	/** The PVUGradePayConverter converter. */
	@Autowired
	private PVUMsGradePayConverter converter;

	/**
	 * Retrieves an PVUMsGradePayEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsGradePayEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsGradePayEntity getPVUGradePay(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsGradePayEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsGradePayEntity
	 */
	@Override
	public PVUMsGradePayEntity saveOrUpdatePVUGradePay(PVUMsGradePayEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUGradePay items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsGradePayDto>
	 */
	@Override
	public PagebleDTO<PVUMsGradePayDto> getPVUGradePays(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsGradePayEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUMsGradePayEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
			Page<PVUMsGradePayEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	

		
		
		

		
	
}
