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
import gov.ifms.pvu.converter.PVUEmployeDeptExamDetailsConverter;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;


/**
 * The Class PVUEmployeDeptExamDetailsServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 */
@Service
public class PVUEmployeDeptExamDetailsServiceImpl implements PVUEmployeDeptExamDetailsService  {
	
	/** The logger. */
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeDeptExamDetailsAsMethodName repository. */
	@Autowired
	private PVUEmployeDeptExamDetailsRepository repository;
	
	/** The PVUEmployeDeptExamDetailsAsMethodName helper. */
	@Autowired
	private PVUEmployeDeptExamDetailsConverter converter;

	/**
	 * Retrieves an PVUEmployeDeptExamDetailsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeDeptExamDetailsEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeDeptExamDetailsEntity getEmployeDeptExamDetails(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeDeptExamDetailsEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeDeptExamDetailsEntity
	 */
	@Override
	public PVUEmployeDeptExamDetailsEntity saveOrUpdateEmployeDeptExamDetails(PVUEmployeDeptExamDetailsEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeDeptExamDetails items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeDeptExamDetailsDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeDeptExamDetailsDto> getEmployeDeptExamDetailss(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeDeptExamDetailsEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUEmployeDeptExamDetailsEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUEmployeDeptExamDetailsEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}