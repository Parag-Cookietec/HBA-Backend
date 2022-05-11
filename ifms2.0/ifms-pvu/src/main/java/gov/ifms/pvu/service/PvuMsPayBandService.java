package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsPayBandDto;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;

/**
 * The Class PvuMsPayBandService.
 *
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 */
public interface PvuMsPayBandService {
    /**
     * Retrieves an PVUMsPayBandEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUMsPayBandEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    PVUMsPayBandEntity getPayBandById(Long id);

    /**
     * Fetch all the PVUMsPayBandDto items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUMsPayBandDto>
     */
    PagebleDTO<PVUMsPayBandDto> getMsPayBands(PageDetails pageDetail) throws CustomException;

	/**
	 * Saves a given PVUMsPayBandEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayBandEntity
	 */
	public PVUMsPayBandEntity saveOrUpdateMsPayBand(PVUMsPayBandEntity entity);
}
