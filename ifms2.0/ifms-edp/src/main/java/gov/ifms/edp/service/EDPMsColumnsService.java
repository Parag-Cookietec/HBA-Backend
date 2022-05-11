package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsColumnsDto;
import gov.ifms.edp.entity.EDPMsColumnsEntity;

/**
 * The Interface EDPMsColumnsService.
 */
public interface EDPMsColumnsService {

	/**
	 * Returns all instances of the EDPMsColumnsEntity type.
	 * 
	 * @return all EDPMsColumnsEntity
	 */
	List<EDPMsColumnsEntity> getMsColumnss();

	/**
	 * Retrieves an EDPMsColumnsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsColumnsEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsColumnsEntity getMsColumns(Long id);

	/**
	 * Saves a given EDPMsColumnsEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsColumnsEntity
	 */
	EDPMsColumnsEntity saveOrUpdateMsColumns(EDPMsColumnsEntity entity);

	/**
	 * Saves all given EDPMsColumnsEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsColumnsEntity> saveMsColumnss(List<EDPMsColumnsEntity> entities);

	/**
	 * Deletes the EDPMsColumnsEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsColumns(Long id);

	/**
	 * Fetch all the EDPMsColumns items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsColumnsDto>
	 */
	PagebleDTO<EDPMsColumnsDto> edpMsColumnsAsMethodNameSearch(PageDetails pageDetail);

}
