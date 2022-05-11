package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;

import java.util.Date;

/**
 * The Class PVUEmployeReversionEventController.
 * 
 * @version v 1.0
 * @created 2019/12/20 11:11:57
 */

@Repository
@Transactional
public interface PVUEmployeReversionRepository extends JpaRepository<PVUEmployeReversionEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeReversionEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeReversionEntity pvuReverEventEntity set pvuReverEventEntity.statusId.lookUpInfoId = :statusId where pvuReverEventEntity.id = :id")
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
	@Query("update PVUEmployeReversionEntity entity set entity.statusId.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
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
	@Query("update PVUEmployeReversionEntity entity set entity.activeStatus =:activeStatus, entity.updatedBy = :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
	void deleteById(@Param("activeStatus") int activeStatus, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	PVUEmployeReversionEntity findByTrnNo(@Param("trnNo") String trnNo);
}
