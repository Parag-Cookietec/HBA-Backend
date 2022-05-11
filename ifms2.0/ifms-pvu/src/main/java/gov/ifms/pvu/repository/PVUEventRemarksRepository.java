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
import gov.ifms.pvu.entity.PVUEventRemarksEntity;

/**
 * The Class PVUDeemedDateRepository.
 */
@Repository
@Transactional
public interface PVUEventRemarksRepository extends JpaRepository<PVUEventRemarksEntity, Long>,
		JpaSpecificationExecutor<PVUEventRemarksEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query(value = " UPDATE PVU.PVU_EVNT_RMKS " + " SET ACTIVE_STATUS = :activeStatus, UPDATED_BY = :updatedBy, "
			+ "	UPDATED_DATE = :updatedDate	WHERE PVU_EVNT_ID = :eventId AND EVNT_TRN_ID =:trnId", nativeQuery = true)
	void deactiveOldReason(@Param("eventId") Long eventId, @Param("trnId") Long id,
						   @Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
						   @Param("updatedDate") Date updatedDate);

	/**
	 * delete status id for PVU events entity.
	 *
	 * @param trnId  the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUEventRemarksEntity entity set entity.activeStatus =:inActiveStatus, entity.updatedBy = :updatedBy ," +
			" entity.updatedDate= :updatedDate where entity.trnNo = :trnId AND entity.eventID = :eventId")
	void deActivateOldReason(@Param("trnId") Long trnId, @Param("eventId") Long eventId, @Param("inActiveStatus") int inActiveStatus,
							 @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);




}
