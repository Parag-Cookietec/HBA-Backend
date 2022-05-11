package gov.ifms.edp.service;

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
import gov.ifms.edp.converter.EDPOfficeBillMapItrConverter;
import gov.ifms.edp.dto.EDPOfficeBillMapItrDto;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;

/**
 * The Class EDPOfficeBillMapItrServiceImpl.
 */
@Service
public class EDPOfficeBillMapItrServiceImpl implements EDPOfficeBillMapItrService  {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	/** The EDPOfficeBillMapItrAsMethodName repository. */
	@Autowired
	private EDPOfficeBillMapItrRepository repository;
	
	/** The EDPOfficeBillMapItrAsMethodName helper. */
	@Autowired
	private EDPOfficeBillMapItrConverter converter;

	/**
	 * Retrieves an EDPOfficeBillMapItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPOfficeBillMapItrEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPOfficeBillMapItrEntity getOfficeBillMapItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPOfficeBillMapItrEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPOfficeBillMapItrEntity
	 */
	@Override
	public EDPOfficeBillMapItrEntity saveOrUpdateOfficeBillMapItr(EDPOfficeBillMapItrEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPOfficeBillMapItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteOfficeBillMapItr(long id,int isDelete) {
		//Delete repo
	}
    
	/**
	 * Fetch all the EDPOfficeBillMapItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeBillMapItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeBillMapItrDto> getOfficeBillMapItrs(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPOfficeBillMapItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<EDPOfficeBillMapItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<EDPOfficeBillMapItrEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
