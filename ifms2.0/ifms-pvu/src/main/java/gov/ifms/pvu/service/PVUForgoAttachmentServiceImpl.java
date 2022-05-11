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
import gov.ifms.pvu.converter.PVUForgoAttachmentConverter;
import gov.ifms.pvu.dto.PVUForgoAttachmentDto;
import gov.ifms.pvu.entity.PVUForgoAttachmentEntity;
import gov.ifms.pvu.repository.PVUForgoAttachmentRepository;


/**
 * The Class PVUForgoAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 */
@Service
public class PVUForgoAttachmentServiceImpl implements PVUForgoAttachmentService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUForgoAttachmentAsMethodName repository. */
	@Autowired
	private PVUForgoAttachmentRepository repository;
	
	/** The PVUForgoAttachmentAsMethodName helper. */
	@Autowired
	private PVUForgoAttachmentConverter converter;

	/**
	 * Retrieves an PVUForgoAttachmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUForgoAttachmentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUForgoAttachmentEntity getForgoAttachment(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUForgoAttachmentEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUForgoAttachmentEntity
	 */
	@Override
	public PVUForgoAttachmentEntity saveOrUpdateForgoAttachment(PVUForgoAttachmentEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUForgoAttachmentEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	/* // uncomment method when require  delete api
	@Override
	public void deleteForgoAttachment(long id,int isDelete) {
		repository.deleteForgoAttachment(id, isDelete ,
				OAuthUtility.getCurrentUserUserId(),new java.util.Date());
	}
    */
	/**
	 * Fetch all the PVUForgoAttachment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUForgoAttachmentDto>
	 */
	@Override
	public PagebleDTO<PVUForgoAttachmentDto> getForgoAttachments(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUForgoAttachmentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUForgoAttachmentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUForgoAttachmentEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	

		
		
		

		
	
}
