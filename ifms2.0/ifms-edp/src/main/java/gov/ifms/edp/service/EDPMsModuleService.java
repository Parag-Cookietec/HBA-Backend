package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsModuleDto;
import gov.ifms.edp.entity.EDPMsModuleEntity;

/**
 * The Interface EDPMsModuleService.
 */
public interface EDPMsModuleService {

	/**
	 * Returns all instances of the EDPMsModuleEntity type.
	 * 
	 * @return all EDPMsModuleEntity
	 */
	List<EDPMsModuleEntity> getMsModules();

	/**
	 * Retrieves an EDPMsModuleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsModuleEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsModuleEntity getMsModule(Long id);

	/**
	 * Saves a given EDPMsModuleEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsModuleEntity
	 */
	EDPMsModuleEntity saveOrUpdateMsModule(EDPMsModuleEntity entity);

	/**
	 * Saves all given EDPMsModuleEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsModuleEntity> saveMsModules(List<EDPMsModuleEntity> entities);

	/**
	 * Deletes the EDPMsModuleEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsModule(Long id);

	/**
	 * Fetch all the EDPMsModule items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleDto>
	 */
	PagebleDTO<EDPMsModuleDto> edpMsModuleAsMethodNameSearch(PageDetails pageDetail);

}
