package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsActivitiesHeadDto;
import gov.ifms.edp.entity.EDPMsActivitiesHeadEntity;

/**
 * The Interface EDPMsActivitiesHeadService.
 */
public interface EDPMsActivitiesHeadService {
	
     /**
	 * Returns all instances of the EDPMsActivitiesHeadEntity type.
	 * 
	 * @return all EDPMsActivitiesHeadEntity
	 */
	List<EDPMsActivitiesHeadEntity> getMsActivitiesHeads();	

	/**
	 * Retrieves an EDPMsActivitiesHeadEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsActivitiesHeadEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsActivitiesHeadEntity getMsActivitiesHead(Long id);

	/**
	 * Saves a given EDPMsActivitiesHeadEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsActivitiesHeadEntity
	 */
	EDPMsActivitiesHeadEntity saveOrUpdateMsActivitiesHead(EDPMsActivitiesHeadEntity entity);

	/**
	 * Saves all given EDPMsActivitiesHeadEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsActivitiesHeadEntity> saveMsActivitiesHeads(List<EDPMsActivitiesHeadEntity> entities);

	/**
	 * Deletes the EDPMsActivitiesHeadEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsActivitiesHead(Long id);

	
	/**
	 * Fetch all the EDPMsActivitiesHead items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsActivitiesHeadDto>
	 */
	PagebleDTO<EDPMsActivitiesHeadDto> edpMsActivitiesHeadAsMethodNameSearch(PageDetails pageDetail);

}
