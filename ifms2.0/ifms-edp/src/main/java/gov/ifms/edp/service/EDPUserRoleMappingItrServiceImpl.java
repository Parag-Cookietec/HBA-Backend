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
import gov.ifms.edp.converter.EDPUserRoleMappingItrConverter;
import gov.ifms.edp.dto.EDPUserRoleMappingItrDto;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPUserRoleMappingItrRepository;

/**
 * The Class EDPUserRoleMappingItrServiceImpl.
 */
@Service
public class EDPUserRoleMappingItrServiceImpl implements EDPUserRoleMappingItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPUserRoleMappingItrAsMethodName repository. */
	@Autowired
	private EDPUserRoleMappingItrRepository repository;

	/** The EDPUserRoleMappingItrAsMethodName helper. */
	@Autowired
	private EDPUserRoleMappingItrConverter converter;

	/**
	 * Retrieves an EDPUserRoleMappingItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPUserRoleMappingItrEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPUserRoleMappingItrEntity getUserRoleMappingItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPUserRoleMappingItrEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPUserRoleMappingItrEntity
	 */
	@Override
	public EDPUserRoleMappingItrEntity saveOrUpdateUserRoleMappingItr(EDPUserRoleMappingItrEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPUserRoleMappingItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteUserRoleMappingItr(long id, int isDelete) {
		repository.deleteUserRoleMappingItr(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPUserRoleMappingItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPUserRoleMappingItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPUserRoleMappingItrDto> getUserRoleMappingItrs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPUserRoleMappingItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPUserRoleMappingItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPUserRoleMappingItrEntity> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.getMessage());

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
