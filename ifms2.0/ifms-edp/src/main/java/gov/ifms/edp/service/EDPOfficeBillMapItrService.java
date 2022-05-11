package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPOfficeBillMapItrDto;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;

/**
 * The Interface EDPOfficeBillMapItrService.
 */
public interface EDPOfficeBillMapItrService {
	/**
	 * Retrieves an EDPOfficeBillMapItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPOfficeBillMapItrEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPOfficeBillMapItrEntity getOfficeBillMapItr(Long id);

	/**
	 * Saves a given EDPOfficeBillMapItrEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPOfficeBillMapItrEntity
	 */
	public EDPOfficeBillMapItrEntity saveOrUpdateOfficeBillMapItr(EDPOfficeBillMapItrEntity entity);

	/**
	 * Saves all given EDPOfficeBillMapItrEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteOfficeBillMapItr(long id,int isDelete);
	
	/**
	 * Fetch all the EDPOfficeBillMapItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeBillMapItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeBillMapItrDto> getOfficeBillMapItrs(PageDetails pageDetail) throws CustomException;
}
