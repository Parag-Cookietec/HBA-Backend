package gov.ifms.pvu.service;

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
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUEmployeDeptAndHodConverter;
import gov.ifms.pvu.dto.PVUEmployeDeptAndHodDto;
import gov.ifms.pvu.entity.PVUEmployeDeptAndHodEntity;
import gov.ifms.pvu.repository.PVUEmployeDeptAndHodRepository;


/**
 * The Class PVUEmployeDeptAndHodController.
 * 
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 */
@Service
public class PVUEmployeDeptAndHodServiceImpl implements PVUEmployeDeptAndHodService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeDeptAndHodAsMethodName repository. */
	@Autowired
	private PVUEmployeDeptAndHodRepository repository;
	
	/** The PVUEmployeDeptAndHodAsMethodName helper. */
	@Autowired
	private PVUEmployeDeptAndHodConverter converter;

	/**
	 * Retrieves an PVUEmployeDeptAndHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeDeptAndHodEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public List<PVUEmployeDeptAndHodEntity> getEmployeDeptAndHod(Long id) {
		return repository.findAllByDepartmentId(id);
	}

	/**
	 * Saves a given PVUEmployeDeptAndHodEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeDeptAndHodEntity
	 */
	@Override
	public PVUEmployeDeptAndHodEntity saveOrUpdateEmployeDeptAndHod(PVUEmployeDeptAndHodEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUEmployeDeptAndHodEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	/* // uncomment method when require  delete api
	@Override
	public void deleteEmployeDeptAndHod(long id,int isDelete) {
		repository.deleteEmployeDeptAndHod(id, isDelete ,
				OAuthUtility.getCurrentUserUserId(),new java.util.Date());
	}
    */
	/**
	 * Fetch all the PVUEmployeDeptAndHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeDeptAndHodDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeDeptAndHodDto> getEmployeDeptAndHods(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeDeptAndHodEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUEmployeDeptAndHodEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUEmployeDeptAndHodEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	

		
		
		

		
	
}
