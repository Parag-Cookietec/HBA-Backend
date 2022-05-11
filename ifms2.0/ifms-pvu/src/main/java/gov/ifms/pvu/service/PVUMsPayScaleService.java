package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsPayScaleDto;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
/**
 * The Class PVUMsPayScaleController.
 * 
 * @version v 1.0
 * @created 2020/01/12 16:58:17
 *
 */
public interface PVUMsPayScaleService {
	/**
	 * Retrieves an PVUMsPayScaleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayScaleEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUMsPayScaleEntity getMsPayScale(Long id);

	/**
	 * Saves a given PVUMsPayScaleEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayScaleEntity
	 */
	public PVUMsPayScaleEntity saveOrUpdateMsPayScale(PVUMsPayScaleEntity entity);

	/**
	 * Saves all given PVUMsPayScaleEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteMsPayScale(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the PVUMsPayScale items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsPayScaleDto>
	 */
	public PagebleDTO<PVUMsPayScaleDto> getMsPayScales(PageDetails pageDetail) throws CustomException;

	public List<PVUMsPayScaleEntity> getScaleValue();


}
