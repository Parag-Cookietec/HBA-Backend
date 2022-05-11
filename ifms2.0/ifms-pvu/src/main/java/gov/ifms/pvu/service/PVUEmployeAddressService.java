package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeAddressView;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.entity.PVUEmployeAddressEntity;
/**
 * The Class PVUEmployeAddressService.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 */
public interface PVUEmployeAddressService extends PVUBaseService{
	/**
	 * Retrieves an PVUEmployeAddressEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeAddressEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeAddressEntity getEmployeAddress(Long id);

	/**
	 * Saves a given PVUEmployeAddressEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeAddressEntity
	 */
	public PVUEmployeAddressEntity saveOrUpdateEmployeAddress(PVUEmployeAddressEntity entity);

	/**
	 * Fetch all the PVUEmployeAddress items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeAddressDto>
	 */
	public PagebleDTO<PVUEmployeAddressView> getEmployeAddresss(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all employe events.
	 *
	 * @param pageDetail the page detail
	 * @return the all employe events
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEmployeEventView> getAllEmployeEvents(PageDetails pageDetail) throws CustomException;
}
