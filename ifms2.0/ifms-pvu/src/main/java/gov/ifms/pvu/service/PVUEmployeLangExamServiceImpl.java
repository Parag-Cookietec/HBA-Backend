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
import gov.ifms.pvu.converter.PVUEmployeLangExamConverter;
import gov.ifms.pvu.dto.PVUEmployeLangExamDto;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;


/**
 * The Class PVUEmployeLangExamServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 */
@Service
public class PVUEmployeLangExamServiceImpl implements PVUEmployeLangExamService  {
	
	/** The logger. */
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeLangExamAsMethodName repository. */
	@Autowired
	private PVUEmployeLangExamRepository repository;
	
	/** The PVUEmployeLangExamAsMethodName helper. */
	@Autowired
	private PVUEmployeLangExamConverter converter;

	/**
	 * Retrieves an PVUEmployeLangExamEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeLangExamEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeLangExamEntity getEmployeLangExam(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeLangExamEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeLangExamEntity
	 */
	@Override
	public PVUEmployeLangExamEntity saveOrUpdateEmployeLangExam(PVUEmployeLangExamEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeLangExam items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeLangExamDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeLangExamDto> getEmployeLangExams(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeLangExamEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUEmployeLangExamEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUEmployeLangExamEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}