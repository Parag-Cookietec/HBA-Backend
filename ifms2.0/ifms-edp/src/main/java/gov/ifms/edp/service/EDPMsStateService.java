package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsStateDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsStateEntity;

/**
 * The Interface EDPMsStateService.
 */
public interface EDPMsStateService {
    /**
     * Retrieves an EDPMsStateEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the EDPMsStateEntity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    public EDPMsStateEntity getMsState(Long id);

    /**
     * Saves a given EDPMsStateEntity. Use the returned instance for further operations
     * as the save operation might have changed the entity instance completely.
     *
     * @param entity the entity
     * @return the saved EDPMsStateEntity
     */
    public EDPMsStateEntity saveOrUpdateMsState(EDPMsStateEntity entity);

    /**
     * Fetch all the EDPMsState items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<EDPMsStateDto>
     * @throws CustomException the custom exception
     */
    public PagebleDTO<EDPMsStateDto> getMsStates(PageDetails pageDetail) throws CustomException;

    /**
     * Gets the SDT data.
     *
     * @return the SDT data
     */
    public List<EDPSDTDto> getSDTData();
}
