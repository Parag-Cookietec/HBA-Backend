package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsModuleInfoDto;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;

/**
 * The Interface EDPMsModuleInfoService.
 */
public interface EDPMsModuleInfoService {

	/**
	 * Returns all instances of the EDPMsModuleInfoEntity type.
	 * 
	 * @return all EDPMsModuleInfoEntity
	 */
	List<EDPMsModuleInfoEntity> getMsModuleInfos();

	/**
	 * Retrieves an EDPMsModuleInfoEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsModuleInfoEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsModuleInfoEntity getMsModuleInfo(Long id);

	/**
	 * Saves a given EDPMsModuleInfoEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsModuleInfoEntity
	 */
	EDPMsModuleInfoEntity saveOrUpdateMsModuleInfo(EDPMsModuleInfoEntity entity);

	/**
	 * Saves all given EDPMsModuleInfoEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsModuleInfoEntity> saveMsModuleInfos(List<EDPMsModuleInfoEntity> entities);

	/**
	 * Deletes the EDPMsModuleInfoEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsModuleInfo(Long id);

	/**
	 * Fetch all the EDPMsModuleInfo items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleInfoDto>
	 */
	PagebleDTO<EDPMsModuleInfoDto> edpMsModuleInfoAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Gets the ms module info by module id.
	 *
	 * @param moduleId the module id
	 * @return the ms module info by module id
	 */
	List<EDPMsModuleInfoEntity> getMsModuleInfoByModuleId(long moduleId);
}
