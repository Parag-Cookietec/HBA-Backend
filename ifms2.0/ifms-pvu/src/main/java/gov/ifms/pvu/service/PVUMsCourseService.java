package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsCourseDto;
import gov.ifms.pvu.entity.PVUMsCourseEntity;

/**
 * The Class PVUMsCourseController.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 *
 */
public interface PVUMsCourseService {
	/**
	 * Retrieves an PVUMsCourseEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsCourseEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUMsCourseEntity getMsCourse(Long id);

	/**
	 * Saves a given PVUMsCourseEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsCourseEntity
	 */
	public PVUMsCourseEntity saveOrUpdateMsCourse(PVUMsCourseEntity entity);

	/**
	 * Fetch all the PVUMsCourse items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsCourseDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUMsCourseDto> getMsCourses(PageDetails pageDetail) throws CustomException;
}
