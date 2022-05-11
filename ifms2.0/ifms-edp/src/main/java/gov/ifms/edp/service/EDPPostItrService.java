package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPPostItrDto;
import gov.ifms.edp.entity.EDPPostItrEntity;

/**
 * The Interface EDPPostItrService.
 */
public interface EDPPostItrService {
	/**
	 * Retrieves an EDPPostItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPPostItrEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPPostItrEntity getPostItr(Long id);

	/**
	 * Saves a given EDPPostItrEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPPostItrEntity
	 */
	public EDPPostItrEntity saveOrUpdatePostItr(EDPPostItrEntity entity);

	/**
	 * Saves all given EDPPostItrEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deletePostItr(long id, int isDelete);

	/**
	 * Fetch all the EDPPostItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPPostItrDto> getPostItrs(PageDetails pageDetail) throws CustomException;
}
