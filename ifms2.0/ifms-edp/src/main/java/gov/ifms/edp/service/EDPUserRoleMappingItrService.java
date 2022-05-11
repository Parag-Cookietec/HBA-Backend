package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPUserRoleMappingItrDto;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;

/**
 * The Interface EDPUserRoleMappingItrService.
 */
public interface EDPUserRoleMappingItrService {
	/**
	 * Retrieves an EDPUserRoleMappingItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPUserRoleMappingItrEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPUserRoleMappingItrEntity getUserRoleMappingItr(Long id);

	/**
	 * Saves a given EDPUserRoleMappingItrEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPUserRoleMappingItrEntity
	 */
	public EDPUserRoleMappingItrEntity saveOrUpdateUserRoleMappingItr(EDPUserRoleMappingItrEntity entity);

	/**
	 * Saves all given EDPUserRoleMappingItrEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteUserRoleMappingItr(long id,int isDelete);
	
	/**
	 * Fetch all the EDPUserRoleMappingItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPUserRoleMappingItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPUserRoleMappingItrDto> getUserRoleMappingItrs(PageDetails pageDetail) throws CustomException;
}
