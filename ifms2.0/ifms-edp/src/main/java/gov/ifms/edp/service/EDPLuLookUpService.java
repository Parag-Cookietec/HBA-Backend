package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPLuLookUpDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;

/**
 * The Interface EDPLuLookUpService.
 */
public interface EDPLuLookUpService {

	/**
	 * Returns all instances of the EDPLuLookUpEntity type.
	 * 
	 * @return all EDPLuLookUpEntity
	 */
	List<EDPLuLookUpEntity> getLuLookUps();

	/**
	 * Retrieves an EDPLuLookUpEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLuLookUpEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPLuLookUpEntity getLuLookUp(Long id);

	/**
	 * Saves a given EDPLuLookUpEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLuLookUpEntity
	 */
	EDPLuLookUpEntity saveOrUpdateLuLookUp(EDPLuLookUpEntity entity);

	/**
	 * Saves all given EDPLuLookUpEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPLuLookUpEntity> saveLuLookUps(List<EDPLuLookUpEntity> entities);

	/**
	 * Deletes the EDPLuLookUpEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteLuLookUp(Long id);

	/**
	 * Fetch all the EDPLuLookUp items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpDto>
	 */
	PagebleDTO<EDPLuLookUpDto> edpLuLookUpAsMethodNameSearch(PageDetails pageDetail);

}
