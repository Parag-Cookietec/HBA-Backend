package gov.ifms.pvu.service;

import java.util.Arrays;
import java.util.List;

import gov.ifms.pvu.dto.enumration.PVUSearchEnum;

/**
 * The Interface PVUBaseService.
 */
public interface PVUBaseService {

    /**
     * Gets the pvu search fields.
     *
     * @return the pvu search fields
     */
    default List<PVUSearchEnum> getPvuSearchFields() {
        return Arrays.asList(PVUSearchEnum.values());
    }

	


}
