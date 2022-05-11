package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsBillDto;
import gov.ifms.edp.entity.EDPMsBillEntity;

/**
 * The Class EDPMsBillController.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 *
 */
public interface EDPMsBillService {
	/**
	 * Retrieves an EDPMsBillEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsBillEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsBillEntity getMsBill(Long id);

	/**
	 * Saves a given EDPMsBillEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsBillEntity
	 */
	public EDPMsBillEntity saveOrUpdateMsBill(EDPMsBillEntity entity);

	/**
	 * Saves all given EDPMsBillEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsBill(long id, int isDelete);

	/**
	 * Fetch all the EDPMsBill items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsBillDto>
	 */
	public PagebleDTO<EDPMsBillDto> getMsBills(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Find all bills.
	 *
	 * @return the list
	 */
	List<ClueDto> findAllBills();
}
