package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsSubTreasuryDto;
import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;

/**
 * The Class EDPMsSubTreasuryController.
 * 
 * @version 1.0
 * @created 2020/01/20 10:59:54
 *
 */
public interface EDPMsSubTreasuryService {
	/**
	 * Retrieves an EDPMsSubTreasuryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsSubTreasuryEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsSubTreasuryEntity getMsSubTreasury(Long id);

	/**
	 * Saves a given EDPMsSubTreasuryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsSubTreasuryEntity
	 */
	public EDPMsSubTreasuryEntity saveOrUpdateMsSubTreasury(EDPMsSubTreasuryEntity entity);

	/**
	 * Saves all given EDPMsSubTreasuryEntity entities.
	 *
	 * @param id       the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsSubTreasury(long id, int isDelete);

	/**
	 * Fetch all the EDPMsSubTreasury items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsSubTreasuryDto> getMsSubTreasurys(PageDetails pageDetail) throws CustomException;
}
