package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsLocationDto;
import gov.ifms.edp.entity.EDPMsLocationEntity;

/**
 * The Interface EDPMsLocationService.
 */
public interface EDPMsLocationService {

	/**
	 * Returns all instances of the EDPMsLocationEntity type.
	 * 
	 * @return all EDPMsLocationEntity
	 */
	List<EDPMsLocationEntity> getMsLocations();

	/**
	 * Retrieves an EDPMsLocationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsLocationEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsLocationEntity getMsLocation(Long id);

	/**
	 * Saves a given EDPMsLocationEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsLocationEntity
	 */
	EDPMsLocationEntity saveOrUpdateMsLocation(EDPMsLocationEntity entity);

	/**
	 * Saves all given EDPMsLocationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsLocationEntity> saveMsLocations(List<EDPMsLocationEntity> entities);

	/**
	 * Deletes the EDPMsLocationEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsLocation(Long id);

	/**
	 * Fetch all the EDPMsLocation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsLocationDto>
	 */
	PagebleDTO<EDPMsLocationDto> edpMsLocationAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * This method is used to find all District by lookup info id.
	 *
	 * @return List of List<EDPMsLocationEntity>
	 */

	List<EDPMsLocationEntity> findDistrict();

	/**
	 * This method is used to find all Taluka by lookup info id.
	 *
	 * @return List of List<EDPMsLocationEntity>
	 */

	List<EDPMsLocationEntity> findTaluka();
}
