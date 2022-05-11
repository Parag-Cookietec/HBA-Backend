package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUDepartmentCategoryDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;

/**
 * The Class PVUDepartmentCategoryController.
 * 
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 *
 */
public interface PVUDepartmentCategoryService {
	/**
	 * Retrieves an PVUDepartmentCategoryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUDepartmentCategoryEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUDepartmentCategoryEntity getDepartmentCategory(Long id);

	/**
	 * Saves a given PVUDepartmentCategoryEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUDepartmentCategoryEntity
	 */
	public PVUDepartmentCategoryEntity saveOrUpdateDepartmentCategory(PVUDepartmentCategoryEntity entity);

	/**
	 * Fetch all the PVUDepartmentCategory items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUDepartmentCategoryDto>
	 */
	public PagebleDTO<PVUDepartmentCategoryDto> getDepartmentCategorys(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all department category.
	 *
	 * @return the all department category
	 */
	public List<PVUDepartmentCategoryEntity> getAllDepartmentCategory();
}
