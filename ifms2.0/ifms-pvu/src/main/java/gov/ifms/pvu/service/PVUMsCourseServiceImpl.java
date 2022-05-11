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
import gov.ifms.pvu.converter.PVUMsCourseConverter;
import gov.ifms.pvu.dto.PVUMsCourseDto;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.repository.PVUMsCourseRepository;

/**
 * The Class PVUMsCourseController.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 */
@Service
public class PVUMsCourseServiceImpl implements PVUMsCourseService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUMsCourseAsMethodName repository. */
	@Autowired
	private PVUMsCourseRepository repository;

	/** The PVUMsCourseAsMethodName helper. */
	@Autowired
	private PVUMsCourseConverter converter;

	/**
	 * Retrieves an PVUMsCourseEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsCourseEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsCourseEntity getMsCourse(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsCourseEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsCourseEntity
	 */
	@Override
	public PVUMsCourseEntity saveOrUpdateMsCourse(PVUMsCourseEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUMsCourse items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsCourseDto>
	 */
	@Override
	public PagebleDTO<PVUMsCourseDto> getMsCourses(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsCourseEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUMsCourseEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUMsCourseEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
