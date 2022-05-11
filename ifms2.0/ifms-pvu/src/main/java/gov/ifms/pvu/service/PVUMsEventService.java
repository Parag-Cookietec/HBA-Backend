package gov.ifms.pvu.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.entity.PVUMsEventEntity;

import java.util.List;
import java.util.Optional;

/**
 * The Class PVUMsEventService.
 */
public interface PVUMsEventService {
    /**
     * Retrieves an PVUMsEventEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUMsEventEntity with the given id or {@literal null} if none
     * found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    PVUMsEventEntity getEventById(long id) throws CustomException;

    /**
     * Retrieves all PVU events as List<PVUMsEventEntity> by its id.
     *
     * @return the PVUMsEventEntity with the given id or {@literal null} if none
     * found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    List<PVUMsEventEntity> getAllEvents();

    /**
     * Saves a given PVUMsEventEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param entity the entity
     * @return the saved PVUMsEventEntity
     */
    PVUMsEventEntity saveOrUpdateMasterEvent(PVUMsEventEntity entity);

	/**
	 * Gets the pay fixation events.
	 *
	 * @return the pay fixation events
	 */
	List<PVUMsEventEntity> getPayFixationEvents();

	/**
	 * Gets the pvu events.
	 *
	 * @return the pvu events
	 */
	List<PVUMsEventEntity> getPvuEvents();
	
	/**
	 * Gets the pvu events.
	 *
	 * @return the pvu events
	 */
	Optional<PVUMsEventEntity> getEventByEventCode(String eventCode) throws CustomException;
}
