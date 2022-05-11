package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPUpdateOfficeTrnDto;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;

/**
 * The Class UpdateOfficeTrnController.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 *
 */
public interface EDPUpdateOfficeTrnService {

	/**
	 * Returns all instances of the UpdateOfficeTrnEntity type.
	 * 
	 * @return all UpdateOfficeTrnEntity
	 */
	List<EDPUpdateOfficeTrnEntity> getUpdateOfficeTrns();

	/**
	 * Retrieves an UpdateOfficeTrnEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the UpdateOfficeTrnEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPUpdateOfficeTrnEntity getUpdateOfficeTrn(Long id);

	/**
	 * Saves a given UpdateOfficeTrnEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved UpdateOfficeTrnEntity
	 */
	EDPUpdateOfficeTrnEntity saveOrUpdateUpdateOfficeTrn(EDPUpdateOfficeTrnEntity entity);

	/**
	 * Saves all given UpdateOfficeTrnEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPUpdateOfficeTrnEntity> saveUpdateOfficeTrns(List<EDPUpdateOfficeTrnEntity> entities);

	/**
	 * Deletes the UpdateOfficeTrnEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteUpdateOfficeTrn(Long id);

	/**
	 * Fetch all the UpdateOfficeTrn items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<UpdateOfficeTrnDto>
	 */
	PagebleDTO<EDPUpdateOfficeTrnDto> updateOfficeTrnAsMethodNameSearch(PageDetails pageDetail);

}
