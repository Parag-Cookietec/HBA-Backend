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
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;

/**
 * The Class PVUPromotionRepository.
 */
@Repository
@Transactional
public interface PVUPromotionRepository
		extends JpaRepository<PVUPromotionEntity, Long>, JpaSpecificationExecutor<PVUPromotionEntity>, GenericDao {

	PVUPromotionEntity findOneById(Long id);

	/**
	 * Update status id for PVUPromotionEntity.
	 *
	 * @param statusId the status id
	 * @param id       the id
	 */
	@Modifying
	@Query("update PVUPromotionEntity entity set entity.activeStatus =:activeStatus, entity.status.lookUpInfoId = :statusId where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id);

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUPromotionEntity entity set entity.status.lookUpInfoId = :statusId, entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * delete status id for PVU employe entity.
	 *
	 * @param id          the id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUPromotionEntity entity set entity.activeStatus =:activeStatus, entity.updatedBy = :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void deleteById(@Param("activeStatus") int activeStatus, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	PVUPromotionEntity findTopByEmployeeEmpIdAndPayCommLookUpInfoIdAndStatusLookUpInfoIdOrderByCreatedDateDesc(long id,
			Long payCommissionId, Long approvedId);

	/**
	 * 
	 * @param id
	 * @return String
	 */
	@Query(value = "select entity.trnNo from PVUPromotionEntity entity where entity.id = :id")
	String getTrnNo(@Param("id") Long id);

	PVUPromotionEntity findByTrnNo(@Param("trnNo") String trnNo);
}
