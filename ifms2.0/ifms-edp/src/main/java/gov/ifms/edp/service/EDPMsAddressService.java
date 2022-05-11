package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsAddressDto;
import gov.ifms.edp.entity.EDPMsAddressEntity;

/**
 * The Interface EDPMsAddressService.
 */
public interface EDPMsAddressService {

	/**
	 * Returns all instances of the EDPMsAddressEntity type.
	 * 
	 * @return all EDPMsAddressEntity
	 */
	List<EDPMsAddressEntity> getMsAddresss();

	/**
	 * Retrieves an EDPMsAddressEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsAddressEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsAddressEntity getMsAddress(Long id);

	/**
	 * Saves a given EDPMsAddressEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsAddressEntity
	 */
	EDPMsAddressEntity saveOrUpdateMsAddress(EDPMsAddressEntity entity);

	/**
	 * Saves all given EDPMsAddressEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsAddressEntity> saveMsAddresss(List<EDPMsAddressEntity> entities);

	/**
	 * Deletes the EDPMsAddressEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsAddress(Long id);

	/**
	 * Fetch all the EDPMsAddress items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAddressDto>
	 */
	PagebleDTO<EDPMsAddressDto> edpMsAddressAsMethodNameSearch(PageDetails pageDetail);

}
