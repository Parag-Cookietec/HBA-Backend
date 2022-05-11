package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsAccountHeadDto;
import gov.ifms.edp.entity.EDPMsAccountHeadEntity;

/**
 * The Interface EDPMsAccountHeadService.
 */
public interface EDPMsAccountHeadService {
	
     /**
	 * Returns all instances of the EDPMsAccountHeadEntity type.
	 * 
	 * @return all EDPMsAccountHeadEntity
	 */
	List<EDPMsAccountHeadEntity> getMsAccountHeads();	

	/**
	 * Retrieves an EDPMsAccountHeadEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsAccountHeadEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsAccountHeadEntity getMsAccountHead(Long id);

	/**
	 * Saves a given EDPMsAccountHeadEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsAccountHeadEntity
	 */
	EDPMsAccountHeadEntity saveOrUpdateMsAccountHead(EDPMsAccountHeadEntity entity);

	/**
	 * Saves all given EDPMsAccountHeadEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsAccountHeadEntity> saveMsAccountHeads(List<EDPMsAccountHeadEntity> entities);

	/**
	 * Deletes the EDPMsAccountHeadEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsAccountHead(Long id);

	
	/**
	 * Fetch all the EDPMsAccountHead items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAccountHeadDto>
	 */
	PagebleDTO<EDPMsAccountHeadDto> edpMsAccountHeadAsMethodNameSearch(PageDetails pageDetail);

}
