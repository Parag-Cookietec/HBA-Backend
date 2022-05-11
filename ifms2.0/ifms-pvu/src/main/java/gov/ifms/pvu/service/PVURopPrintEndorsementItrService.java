package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVURopPrintEndorsementItrDto;
import gov.ifms.pvu.entity.PVURopPrintEndorsementItrEntity;

/**
 * The Class PVURopPrintEndorsementItrController.
 * 
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 *
 */
public interface PVURopPrintEndorsementItrService {
	/**
	 * Retrieves an PVURopPrintEndorsementItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopPrintEndorsementItrEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVURopPrintEndorsementItrEntity getPVURopPrintEndorsementItr(Long id);

	/**
	 * Saves a given PVURopPrintEndorsementItrEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopPrintEndorsementItrEntity
	 */
	public PVURopPrintEndorsementItrEntity saveOrUpdatePVURopPrintEndorsementItr(
			PVURopPrintEndorsementItrEntity entity);

	/**
	 * Fetch all the PVURopPrintEndorsementItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopPrintEndorsementItrDto>
	 */
	public PagebleDTO<PVURopPrintEndorsementItrDto> getPVURopPrintEndorsementItrs(PageDetails pageDetail)
			throws CustomException;
}
