package gov.ifms.pvu.repository;

import gov.ifms.pvu.entity.PVUEmployeIncrementEventSummaryEntity;
import gov.ifms.pvu.entity.PVUIncrementEventSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * The Class PVUIncrementEventSummaryController.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 */

@Repository
@Transactional
public interface PVUEmployeIncrementEventSummaryRepository extends JpaRepository<PVUEmployeIncrementEventSummaryEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeIncrementEventSummaryEntity> {

	/**
	 * Find first by in event id in event id and active status.
	 *
	 * @param inEventId    the in event id
	 * @param activestatus the activestatus
	 * @return the PVU increment event summary entity
	 */
	public PVUEmployeIncrementEventSummaryEntity findFirstByInEventIdInEventIdAndActiveStatus(Long inEventId,
                                                                                       int activestatus);

	/**
	 * Delete increment summary id by event id.
	 *
	 * @param activeStatus the active status
	 * @param id           the id
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeIncrementEventSummaryEntity entity set entity.activeStatus = :activeStatus, updatedDate= :updatedDate,"
			+ " updatedBy = :updatedBy, updatedByPost = :updatedByPost  " + " where entity.inEventId.inEventId = :id")
	public void deleteIncrementSummaryIdByEventId(@Param("activeStatus") Integer activeStatus, @Param("id") Long id,
                                                  @Param("updatedDate") Date updatedDate, @Param("updatedBy") long updatedBy,
                                                  @Param("updatedByPost") long updatedByPost);

}
