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
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;

/**
 * The Class PVUSelectionGradeEventController.
 * 
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 */

@Repository
@Transactional
public interface PVUSelectionGradeEventRepository extends JpaRepository<PVUSelectionGradeEventEntity, Long>,
		JpaSpecificationExecutor<PVUSelectionGradeEventEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUSelectionGradeEventEntity entity set entity.statusId.lookUpInfoId = :statusId where entity.id = :id")
	void updateStatusIdForPVUReversionEventEntity(@Param("statusId") long statusId, @Param("id") long id);

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUSelectionGradeEventEntity entity set entity.statusId.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Update status id for PVU sgEvent entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUSelectionGradeEventEntity entity set entity.activeStatus = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteSgEvent(@Param("statusId") int statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUSelectionGradeEventEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeDate") Date authorizeDate);

	@Modifying
	@Query("update PVUSelectionGradeEventEntity entity set entity.activeStatus = :activeStatus , entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , " + "entity.statusId.lookUpInfoId = :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Modifying
	@Query("update PVUSelectionGradeEventEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") Date authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	PVUSelectionGradeEventEntity findByTrnNo(@Param("trnNo") String trnNo);

}
