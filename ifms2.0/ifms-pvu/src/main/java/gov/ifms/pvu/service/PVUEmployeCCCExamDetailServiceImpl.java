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
import gov.ifms.pvu.converter.PVUEmployeCCCExamDetailConverter;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;


/**
 * The Class PVUEmployeCCCExamDetailServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 */
@Service
public class PVUEmployeCCCExamDetailServiceImpl implements PVUEmployeCCCExamDetailService  {
	
	/** The logger. */
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeCCCExamDetailAsMethodName repository. */
	@Autowired
	private PVUEmployeCCCExamDetailRepository repository;
	
	/** The PVUEmployeCCCExamDetailAsMethodName helper. */
	@Autowired
	private PVUEmployeCCCExamDetailConverter converter;

	/**
	 * Retrieves an PVUEmployeCCCExamDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeCCCExamDetailEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeCCCExamDetailEntity getEmployeCCCExamDetail(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeCCCExamDetailEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeCCCExamDetailEntity
	 */
	@Override
	public PVUEmployeCCCExamDetailEntity saveOrUpdateEmployeCCCExamDetail(PVUEmployeCCCExamDetailEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeCCCExamDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeCCCExamDetailDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeCCCExamDetailDto> getEmployeCCCExamDetails(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeCCCExamDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUEmployeCCCExamDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUEmployeCCCExamDetailEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}