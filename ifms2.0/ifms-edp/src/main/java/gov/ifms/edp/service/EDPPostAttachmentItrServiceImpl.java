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
import gov.ifms.edp.converter.EDPPostAttachmentItrConverter;
import gov.ifms.edp.dto.EDPPostAttachmentItrDto;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPPostAttachmentItrRepository;

/**
 * The Class EDPPostAttachmentItrServiceImpl.
 */
@Service
public class EDPPostAttachmentItrServiceImpl implements EDPPostAttachmentItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPPostAttachmentItrAsMethodName repository. */
	@Autowired
	private EDPPostAttachmentItrRepository repository;

	/** The EDPPostAttachmentItrAsMethodName helper. */
	@Autowired
	private EDPPostAttachmentItrConverter converter;

	/**
	 * Retrieves an EDPPostAttachmentItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPPostAttachmentItrEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPPostAttachmentItrEntity getPostAttachmentItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPPostAttachmentItrEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPPostAttachmentItrEntity
	 */
	@Override
	public EDPPostAttachmentItrEntity saveOrUpdatePostAttachmentItr(EDPPostAttachmentItrEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPPostAttachmentItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deletePostAttachmentItr(long id, int isDelete) {
		repository.deletePostAttachmentItr(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPPostAttachmentItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostAttachmentItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPPostAttachmentItrDto> getPostAttachmentItrs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPPostAttachmentItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPPostAttachmentItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPPostAttachmentItrEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
