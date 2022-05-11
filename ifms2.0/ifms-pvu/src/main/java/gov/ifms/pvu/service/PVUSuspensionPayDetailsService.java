package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUSuspensionPayDetailsDto;
import gov.ifms.pvu.entity.PVUSuspensionPayDetailsEntity;

/**
 * The Class PVUSuspensionPayDetailsController.
 * 
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 *
 */
public interface PVUSuspensionPayDetailsService {
	/**
	 * Retrieves an PVUSuspensionPayDetailsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUSuspensionPayDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws CustomException 
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUSuspensionPayDetailsEntity getSuspensionPayDetails(Long id) throws CustomException;

	/**
	 * Saves a given PVUSuspensionPayDetailsEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUSuspensionPayDetailsEntity
	 * @throws CustomException 
	 */
	public PVUSuspensionPayDetailsEntity saveOrUpdateSuspensionPayDetails(PVUSuspensionPayDetailsEntity entity) throws CustomException;

	/**
	 * Fetch all the PVUSuspensionPayDetails items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSuspensionPayDetailsDto>
	 */
	public PagebleDTO<PVUSuspensionPayDetailsDto> getSuspensionPayDetailss(PageDetails pageDetail)
			throws CustomException;
}
