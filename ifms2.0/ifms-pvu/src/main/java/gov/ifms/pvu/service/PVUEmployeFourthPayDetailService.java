package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeFourthPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;


/**
 * The Class PVUEmployeFourthPayDetailService.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 *
 */
public interface PVUEmployeFourthPayDetailService {
	/**
	 * Retrieves an PVUEmployeFourthPayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFourthPayDetailEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeFourthPayDetailEntity getPVUEmployeFourthPayDetailEntity(Long id);

	/**
	 * Saves a given PVUEmployeFourthPayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFourthPayDetailEntity
	 */
	public PVUEmployeFourthPayDetailEntity saveOrUpdatePVUEmployeFourthPayDetailEntity(
			PVUEmployeFourthPayDetailEntity entity);

	/**
	 * Saves all given PVUEmployeFourthPayDetailEntity entities.
	 *
	 * @param pageDetail the page detail
	 * @return the saved entities
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUEmployeFourthPayDetailEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeFourthPayDetailEntityDto>
	 */
	public PagebleDTO<PVUEmployeFourthPayDetailDto> getPVUEmployeFourthPayDetailEntitys(PageDetails pageDetail)
			throws CustomException;
}
