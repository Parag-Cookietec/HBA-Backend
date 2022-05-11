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
import gov.ifms.edp.converter.EDPMsTalukaConverter;
import gov.ifms.edp.dto.EDPMsTalukaDto;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsTalukaRepository;

/**
 * The Class EDPMsTalukaServiceImpl.
 */
@Service
public class EDPMsTalukaServiceImpl implements EDPMsTalukaService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsTalukaAsMethodName repository. */
	@Autowired
	private EDPMsTalukaRepository repository;

	/** The EDPMsTalukaAsMethodName helper. */
	@Autowired
	private EDPMsTalukaConverter converter;

	/**
	 * Retrieves an EDPMsTalukaEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsTalukaEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsTalukaEntity getMsTaluka(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsTalukaEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsTalukaEntity
	 */
	@Override
	public EDPMsTalukaEntity saveOrUpdateMsTaluka(EDPMsTalukaEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPMsTalukaEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsTaluka(long id, int isDelete) {
		repository.deleteMsTaluka(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPMsTaluka items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTalukaDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsTalukaDto> getMsTalukas(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsTalukaEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsTalukaEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsTalukaEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
