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
import gov.ifms.pvu.entity.PVUSeniorScaleEntity;

/**
 * The Class PVUSeniorScaleRepository.
 */
@Repository
@Transactional
public interface PVUSeniorScaleRepository
		extends JpaRepository<PVUSeniorScaleEntity, Long>, JpaSpecificationExecutor<PVUSeniorScaleEntity>, GenericDao {

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUSeniorScaleEntity entity set entity.status.lookUpInfoId = :statusId, entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUSeniorScaleEntity entity set entity.status.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void updateStatusIdAndAuthDate(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate);

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUSeniorScaleEntity entity set entity.status.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	/**
	 * delete status id for PVU employe entity.
	 *
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUSeniorScaleEntity entity set entity.activeStatus =:activeStatus, entity.updatedBy = :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void deleteById(@Param("activeStatus") int activeStatus, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying
	@Query("update PVUSeniorScaleEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , " + "entity.status.lookUpInfoId= :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Query(value = "select entity.TRN_NO from PVU.T_PVU_SS_EVNT entity  where entity.T_PVU_SS_EVNT_ID = :id", nativeQuery = true)
	String getTrnNo(@Param("id") Long trnId);

	@Query(value = "select entity.EMP_ID from PVU.T_PVU_SS_EVNT entity  where entity.T_PVU_SS_EVNT_ID = :id", nativeQuery = true)
	Long getEmpId(@Param("id") Long trnId);

	PVUSeniorScaleEntity findByTrnNo(@Param("trnNo") String trnNo);
}
