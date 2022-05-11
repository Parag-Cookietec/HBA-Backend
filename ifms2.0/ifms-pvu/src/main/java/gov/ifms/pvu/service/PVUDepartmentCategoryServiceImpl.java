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
import gov.ifms.pvu.converter.PVUDepartmentCategoryConverter;
import gov.ifms.pvu.dto.PVUDepartmentCategoryDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;

/**
 * The Class PVUDepartmentCategoryController.
 * 
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 */
@Service
public class PVUDepartmentCategoryServiceImpl implements PVUDepartmentCategoryService {

	/** The logger. */
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUDepartmentCategoryAsMethodName repository. */
	@Autowired
	private PVUDepartmentCategoryRepository repository;

	/** The PVUDepartmentCategoryAsMethodName helper. */
	@Autowired
	private PVUDepartmentCategoryConverter converter;

	/**
	 * Retrieves an PVUDepartmentCategoryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUDepartmentCategoryEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUDepartmentCategoryEntity getDepartmentCategory(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUDepartmentCategoryEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUDepartmentCategoryEntity
	 */
	@Override
	public PVUDepartmentCategoryEntity saveOrUpdateDepartmentCategory(PVUDepartmentCategoryEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUDepartmentCategory items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUDepartmentCategoryDto>
	 */
	@Override
	public PagebleDTO<PVUDepartmentCategoryDto> getDepartmentCategorys(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUDepartmentCategoryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUDepartmentCategoryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUDepartmentCategoryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			LOGGER.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the all department category.
	 *
	 * @return the all department category
	 */
	@Override
	public List<PVUDepartmentCategoryEntity> getAllDepartmentCategory() {

		return repository.findAll();
	}

}
