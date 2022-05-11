package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;

/**
 * The Class PVUMsPayCellService.
 * 
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 *
 */
public interface PVUMsPayCellService {
	/**
	 * Retrieves an PVUMsPayCellEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayCellEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUMsPayCellEntity getMsPayCell(Long id);

	/**
	 * Saves a given PVUMsPayCellEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayCellEntity
	 */
	public PVUMsPayCellEntity saveOrUpdateMsPayCell(PVUMsPayCellEntity entity);

	/**
	 * Saves all given PVUMsPayCellEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteMsPayCell(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the PVUMsPayCell items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsPayCellDto>
	 */
	public PagebleDTO<PVUMsPayCellDto> getMsPayCells(PageDetails pageDetail) throws CustomException;
}
