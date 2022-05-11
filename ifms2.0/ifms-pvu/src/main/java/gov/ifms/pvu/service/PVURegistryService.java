package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVURegistryDto;
import gov.ifms.pvu.entity.PVURegistryEntity;
/**
 * The Class PVURegistryController.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 *
 */
public interface PVURegistryService {
	/**
	 * Retrieves an PVURegistryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURegistryEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVURegistryEntity getRegistry(Long id);

	/**
	 * Saves a given PVURegistryEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURegistryEntity
	 */
	public PVURegistryEntity saveOrUpdateRegistry(PVURegistryEntity entity);

	/**
	 * Saves all given PVURegistryEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteRegistry(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the PVURegistry items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURegistryDto>
	 */
	public PagebleDTO<PVURegistryDto> getRegistrys(PageDetails pageDetail) throws CustomException;
}
