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
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;

/**
 * The Class PVUEmployeAssuredCareerProgressionController.
 * 
 * @version v 1.0
 * @created 2020/01/11 13:52:57
 */

@Repository
@Transactional
public interface PVUEmployeAssuredCareerProgressionRepository
		extends JpaRepository<PVUEmployeAssuredCareerProgressionEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeAssuredCareerProgressionEntity>, GenericDao {

	public PVUEmployeAssuredCareerProgressionEntity findOneById(Long entityId);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteACPEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.statusId.lookUpInfoId = :statusId,updatedBy= :updatedBy , updatedDate= :updatedDate, authorizeBy = :authorizeBy  where entity.id = :id")
	void updateStatusIdAndAuthorizeBy(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeBy") long authorizeBy);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.statusId.lookUpInfoId = :statusId,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeDate") LocalDateTime authorizeDate);

	@Modifying
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	@Query(value = "select entity.TRN_NO from PVU.T_PVU_AP_EVNT entity  where entity.T_PVU_AP_EVNT_ID = :id", nativeQuery = true)
	String getTrnNo(@Param("id") Long id);

	@Modifying
	@Query("update PVUEmployeAssuredCareerProgressionEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Query(value = "select entity.EMP_ID from PVU.T_PVU_AP_EVNT entity  where entity.T_PVU_AP_EVNT_ID = :id", nativeQuery = true)
	Long getEmpId(@Param("id") Long trnId);

	PVUEmployeAssuredCareerProgressionEntity findByTrnNo(@Param("trnNo") String trnNo);
}
