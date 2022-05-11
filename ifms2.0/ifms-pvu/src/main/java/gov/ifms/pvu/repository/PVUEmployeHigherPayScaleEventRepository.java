package gov.ifms.pvu.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;

/**
 * The Class PVUEmployeHigherPayScaleEventController.
 *
 * @version v 1.0
 * @created 2020/01/07 16:13:21
 */

@Repository
@Transactional
public interface PVUEmployeHigherPayScaleEventRepository
		extends JpaRepository<PVUEmployeHigherPayScaleEventEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeHigherPayScaleEventEntity>, GenericDao {

	/**
	 * Find one by id.
	 *
	 * @param id the id
	 * @return the PVU employe higher pay scale event entity
	 */
	PVUEmployeHigherPayScaleEventEntity findOneById(Long id);

	/**
	 * Find all by employee emp id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<PVUEmployeHigherPayScaleEventEntity> findAllByEmployeeEmpId(Long id);

	/**
	 * Find one by trn no.
	 *
	 * @param trnum the trnum
	 * @return the PVU employe higher pay scale event entity
	 */
	PVUEmployeHigherPayScaleEventEntity findOneByTrnNo(String trnum);

	/**
	 * Update status id.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeHigherPayScaleEventEntity entity set entity.status.lookUpInfoId = :statusId,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Update print status and approve date.
	 *
	 * @param activeStatus the active status
	 * @param id           the id
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @param isPrintAble  the is print able
	 * @param approveDate  the approve date
	 */
	@Modifying
	@Query("update PVUEmployeHigherPayScaleEventEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Modifying
	@Query("update PVUEmployeHigherPayScaleEventEntity entity set entity.status.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	@Query(value = "select entity.EMP_ID from PVU.T_PVU_HP_EVNT entity  where entity.T_PVU_HP_EVNT_ID = :id", nativeQuery = true)
	Long getEmpId(@Param("id") Long trnId);

	@Query(value = "select entity.TRN_NO from PVU.T_PVU_HP_EVNT entity  where entity.T_PVU_HP_EVNT_ID = :id", nativeQuery = true)
	String getTrnNo(@Param("id") Long trnId);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeHigherPayScaleEventEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteHigherPayEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	PVUEmployeHigherPayScaleEventEntity findByTrnNo(@Param("trnNo") String trnNo);
}
