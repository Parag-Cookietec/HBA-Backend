package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;

/**
 * The Class PVUEmployeFivePayDetailService.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 *
 */
public interface PVUEmployeFivePayDetailService {
	/**
	 * Retrieves an PVUEmployeFivePayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFivePayDetailEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeFivePayDetailEntity getPVUEmployeFivePayDetailEntity(Long id);

	/**
	 * Saves a given PVUEmployeFivePayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFivePayDetailEntity
	 */
	public PVUEmployeFivePayDetailEntity saveOrUpdatePVUEmployeFivePayDetailEntity(
			PVUEmployeFivePayDetailEntity entity);

	/**
	 * Saves all given PVUEmployeFivePayDetailEntity entities.
	 *
	 * @param pageDetail the page detail
	 * @return the saved entities
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUEmployeFivePayDetailEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeFivePayDetailEntityDto>
	 */
	public PagebleDTO<PVUEmployeFivePayDetailDto> getPVUEmployeFivePayDetailEntitys(PageDetails pageDetail)
			throws CustomException;
}
