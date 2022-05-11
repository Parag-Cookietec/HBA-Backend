package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.entity.PVUMsReasonEntity;

import java.util.List;

/**
 * The Class PVUMsReasonController.
 *
 * @version v 1.0
 * @created 2020/04/14 02:50:39
 */
public interface PVUMsReasonService {
    /**
     * Retrieves an PVUMsReasonEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUMsReasonEntity with the given id or {@literal null} if none
     * found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    public PVUMsReasonEntity getMsReason(Long id);

    /**
     * Saves a given PVUMsReasonEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param entity the entity
     * @return the saved PVUMsReasonEntity
     */
    public PVUMsReasonEntity saveOrUpdateMsReason(PVUMsReasonEntity entity);

    /**
     * Fetch all the PVUMsReason items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUMsReasonDto>
     */
    public PagebleDTO<PVUMsReasonDto> getMsReasons(PageDetails pageDetail) throws CustomException;

    public List<PVUMsReasonDto> getRopReasons();

    public List<PVUMsReasonDto> getEventsReasons();
}
