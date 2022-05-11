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
import gov.ifms.pvu.converter.PVURegistryConverter;
import gov.ifms.pvu.dto.PVURegistryDto;
import gov.ifms.pvu.entity.PVURegistryEntity;
import gov.ifms.pvu.repository.PVURegistryRepository;


/**
 * The Class PVURegistryController.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 */
@Service
public class PVURegistryServiceImpl implements PVURegistryService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVURegistryAsMethodName repository. */
	@Autowired
	private PVURegistryRepository repository;
	
	/** The PVURegistryAsMethodName helper. */
	@Autowired
	private PVURegistryConverter converter;

	/**
	 * Retrieves an PVURegistryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURegistryEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURegistryEntity getRegistry(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVURegistryEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURegistryEntity
	 */
	@Override
	public PVURegistryEntity saveOrUpdateRegistry(PVURegistryEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVURegistryEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	/* // uncomment method when require  delete api
	@Override
	public void deleteRegistry(long id,int isDelete) {
		repository.deleteRegistry(id, isDelete ,
				OAuthUtility.getCurrentUserUserId(),new java.util.Date());
	}
    */
	/**
	 * Fetch all the PVURegistry items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURegistryDto>
	 */
	@Override
	public PagebleDTO<PVURegistryDto> getRegistrys(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVURegistryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVURegistryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVURegistryEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	

		
		
		

		
	
}
