package gov.ifms.pvu.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.entity.PVUInwardEntity;

/**
 * The Class PVUInwardService.
 */
public interface PVUInwardService {
	/**
	 * Retrieves an PVUEventInwardService by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEventInwardService with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	PVUInwardEntity getOneById(long id) throws CustomException;

	/**
	 * Saves a given PVUEventInwardService. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEventInwardService
	 */
	PVUInwardEntity save(PVUInwardEntity entity);

	List<PVUInwardEntity> saveAll(List<PVUInwardEntity> entities);

	void setConsignmentNumber(Long trnId, Long eventId, String postConsignmentNo);

	void setAuthDate(Long trnId, Long eventId, LocalDateTime date);

	void setReturnDate(Long trnId, Long eventId, LocalDateTime date);

	void setResetOutwardFlag(Long trnId, Long eventId);

	void setOutwardFlag(Long trnId, Long eventId);

	void setInwardNumberNull(Long trnId, Long eventId, LocalDateTime date);

	void updateStatusId(int activeStatus, Long trnId, Date updatedDate, Long pvuEventId);
}
