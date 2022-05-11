package gov.ifms.pvu.service;

import gov.ifms.pvu.dto.PVUEmployeIncrementEventSummaryDto;
import gov.ifms.pvu.entity.PVUEmployeIncrementEventSummaryEntity;


import java.util.Date;

/**
 * The Class PVUIncrementEventSummaryController.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 *
 */
public interface PVUEmployeIncrementEventSummaryService {
	/**
	 * Retrieves an PVUIncrementEventSummaryEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEventSummaryEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeIncrementEventSummaryEntity getIncrementEventSummary(Long id);

	/**
	 * Saves a given PVUIncrementEventSummaryEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEventSummaryEntity
	 */
	public PVUEmployeIncrementEventSummaryEntity saveOrUpdateIncrementEventSummary(PVUEmployeIncrementEventSummaryEntity entity);

	/**
	 * Gets the inc count summary by in event id.
	 *
	 * @param id the id
	 * @return the inc count summary by in event id
	 */
	public PVUEmployeIncrementEventSummaryEntity getIncCountSummaryByInEventId(Long id);

	/**
	 * Save or update increment event summary.
	 *
	 * @param pvuIncrementEventSummaryDto the pvu increment event summary dto
	 * @return the PVU increment event summary dto
	 */
	public PVUEmployeIncrementEventSummaryDto saveOrUpdateIncrementEventSummary(
			PVUEmployeIncrementEventSummaryDto pvuIncrementEventSummaryDto);

	/**
	 * Gets the inc count summary by in event id dto.
	 *
	 * @param inEventId the in event id
	 * @return the inc count summary by in event id dto
	 */
	public PVUEmployeIncrementEventSummaryDto getIncCountSummaryByInEventIdDto(Long inEventId);

	/**
	 * Delete increment summary id by event id.
	 *
	 * @param inActiveStatus the in active status
	 * @param inEventId      the in event id
	 * @param updateBy       the update by
	 * @param updatedDate    the updated date
	 */
	public void deleteIncrementSummaryIdByEventId(int inActiveStatus, Long inEventId, Date updatedDate);

}
