package gov.ifms.pvu.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 */

@Repository
@Transactional
public interface PVUIncrementEventRepository extends JpaRepository<PVUIncrementEventEntity, Long>,
		JpaSpecificationExecutor<PVUIncrementEventEntity>, GenericDao {

	/**
	 * Update status id for PVU increment event entity.
	 *
	 * @param statusId  the status id
	 * @param inEventId the in event id
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUIncrementEventEntity pvuIncrEventEntity set pvuIncrEventEntity.statusId.lookUpInfoId = :statusId, "
			+ " updatedBy= :updatedBy, updatedDate= :updatedDate, updatedByPost = :updatedByPost"
			+ " where pvuIncrEventEntity.inEventId = :inEventId")
	void updateStatusIdForPVUIncrementEventEntity(@Param("statusId") long statusId, @Param("inEventId") long inEventId,
			@Param("updatedDate") Date updatedDate, @Param("updatedBy") long updatedBy,
			@Param("updatedByPost") long updatedByPost);

	/**
	 * Delete increment event id by.
	 *
	 * @param activeStatus the active status
	 * @param id           the id
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUIncrementEventEntity entity set entity.activeStatus = :activeStatus, "
			+ " updatedBy= :updatedBy, updatedDate= :updatedDate, updatedByPost = :updatedByPost "
			+ " where entity.inEventId = :id")
	void deleteIncrementEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedDate") Date updatedDate, @Param("updatedBy") long updatedBy,
			@Param("updatedByPost") long updatedByPost);

	PVUIncrementEventEntity findByTrnNo(@Param("trnNo") String trnNo);
}
