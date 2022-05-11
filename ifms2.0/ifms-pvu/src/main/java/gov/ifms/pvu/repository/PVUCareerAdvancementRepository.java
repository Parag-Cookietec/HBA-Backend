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
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;

/**
 * The Class PVUCarrearAdvancementController.
 * 
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 */

@Repository
@Transactional
public interface PVUCareerAdvancementRepository extends JpaRepository<PVUCareerAdvancementEntity, Long>,
		JpaSpecificationExecutor<PVUCareerAdvancementEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUCareerAdvancementEntity entity set entity.statusId.lookUpInfoId  = :statusId, entity.updatedBy= :updatedBy "
			+ ", entity.updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying
	@Query(value = "update PVUCareerAdvancementEntity set activeStatus = :activeStatus , updatedBy = :updatedBy , "
			+ "updatedDate = :updatedDate where id = :stEventId")
	public int updateActiveStatus(@Param("stEventId") long stEventId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	PVUCareerAdvancementEntity findOneByTrnNo(String trnum);

	@Modifying
	@Query("update PVUCareerAdvancementEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void updateStatusIdAndAuthDate(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate);

	@Query(value = "select entity.TRN_NO from PVU.T_PVU_CA_EVNT entity  where entity.T_PVU_CA_EVNT_ID = :id", nativeQuery = true)
	String getTrnNo(@Param("id") Long trnId);

	@Query(value = "select entity.EMP_ID from PVU.T_PVU_CA_EVNT entity  where entity.T_PVU_CA_EVNT_ID = :id", nativeQuery = true)
	Long getEmpId(@Param("id") Long trnId);

	@Modifying
	@Query("update PVUCareerAdvancementEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	@Modifying
	@Query("update PVUCareerAdvancementEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , " + "entity.statusId.lookUpInfoId= :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	PVUCareerAdvancementEntity findByTrnNo(@Param("trnNo") String trnNo);

}
