package gov.ifms.pvu.repository;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUCsEventEntity;

/**
 * The Class PVUCsEventController.
 * 
 * @version v 1.0
 * @created 2020/01/06 15:19:21
 */

@Repository
@Transactional
public interface PVUCsEventRepository
		extends JpaRepository<PVUCsEventEntity, Long>, JpaSpecificationExecutor<PVUCsEventEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUCsEventEntity pvuCsEntity set pvuCsEntity.statusId.lookUpInfoId = :statusId where pvuCsEntity.id = :id")
	void updateStatusIdForPVUCsEventEntity(@Param("statusId") long statusId, @Param("id") long id);

	/**
	 * Update status id for PVU CsEvent entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUCsEventEntity entity set entity.statusId.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUCsEventEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.updatedBy= :updatedBy ,entity.updatedDate= :updatedDate ,entity.authorizeDate = :authDate where entity.id = :id")
	void updateStatusIdAndAuthDate(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate);

	@Modifying
	@Query("update PVUCsEventEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	/**
	 * delete status id for PVU CsEvent entity.
	 *
	 * @param activeStatus the activeStatus
	 * @param id           the id
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUCsEventEntity entity set entity.activeStatus = :activeStatus, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteCsEvent(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUCsEventEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeDate") LocalDateTime authorizeDate);

	@Modifying
	@Query("update PVUCsEventEntity entity set entity.activeStatus = :activeStatus , entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , " + "entity.statusId.lookUpInfoId = :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	PVUCsEventEntity findByTrnNo(@Param("trnNo") String trnNo);
}
