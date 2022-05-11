package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeDeptAndHodDto;
import gov.ifms.pvu.entity.PVUEmployeDeptAndHodEntity;
/**
 * The Class PVUEmployeDeptAndHodController.
 * 
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 *
 */
public interface PVUEmployeDeptAndHodService {
	/**
	 * Retrieves an PVUEmployeDeptAndHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeDeptAndHodEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public List<PVUEmployeDeptAndHodEntity>   getEmployeDeptAndHod(Long id);

	/**
	 * Saves a given PVUEmployeDeptAndHodEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeDeptAndHodEntity
	 */
	public PVUEmployeDeptAndHodEntity saveOrUpdateEmployeDeptAndHod(PVUEmployeDeptAndHodEntity entity);

	/**
	 * Saves all given PVUEmployeDeptAndHodEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteEmployeDeptAndHod(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the PVUEmployeDeptAndHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeDeptAndHodDto>
	 */
	public PagebleDTO<PVUEmployeDeptAndHodDto> getEmployeDeptAndHods(PageDetails pageDetail) throws CustomException;
}
