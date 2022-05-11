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
import gov.ifms.edp.converter.EDPPostItrConverter;
import gov.ifms.edp.dto.EDPPostItrDto;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPPostItrRepository;

/**
 * The Class EDPPostItrServiceImpl.
 */
@Service
public class EDPPostItrServiceImpl implements EDPPostItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPPostItrAsMethodName repository. */
	@Autowired
	private EDPPostItrRepository repository;

	/** The EDPPostItrAsMethodName helper. */
	@Autowired
	private EDPPostItrConverter converter;

	/**
	 * Retrieves an EDPPostItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPPostItrEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPPostItrEntity getPostItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPPostItrEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPPostItrEntity
	 */
	@Override
	public EDPPostItrEntity saveOrUpdatePostItr(EDPPostItrEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPPostItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deletePostItr(long id, int isDelete) {
		repository.deletePostItr(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPPostItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPPostItrDto> getPostItrs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPPostItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPPostItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPPostItrEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
