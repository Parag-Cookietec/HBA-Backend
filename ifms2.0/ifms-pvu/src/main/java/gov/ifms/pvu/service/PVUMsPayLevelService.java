package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsPayLevelDto;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
/**
 * The Class PVUMsPayLevelService.
 * 
 * @version v 1.0
 * @created 2019/12/23 17:19:51
 *
 */
public interface PVUMsPayLevelService {
	/**
	 * Retrieves an PVUMsPayLevelEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayLevelEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUMsPayLevelEntity getMsPayLevel(Long id);

	/**
	 * Saves a given PVUMsPayLevelEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayLevelEntity
	 */
	public PVUMsPayLevelEntity saveOrUpdateMsPayLevel(PVUMsPayLevelEntity entity);

	/**
	 * Saves all given PVUMsPayLevelEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteMsPayLevel(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the PVUMsPayLevel items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsPayLevelDto>
	 */
	public PagebleDTO<PVUMsPayLevelDto> getMsPayLevels(PageDetails pageDetail) throws CustomException;
}
