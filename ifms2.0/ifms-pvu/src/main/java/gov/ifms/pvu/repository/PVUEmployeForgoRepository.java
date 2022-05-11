package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;

/**
 * The Class PVUForgoEventController.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:00:23
 */

@Repository
@Transactional
public interface PVUEmployeForgoRepository extends JpaRepository<PVUEmployeForgoEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeForgoEntity>, GenericDao {

	Optional<PVUEmployeForgoEntity> findByIdAndActiveStatus(Long id, int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeForgoEntity pvuEmployeForgoEntity set pvuEmployeForgoEntity.statusId.lookUpInfoId = :statusId,updatedBy=:updatedBy , updatedDate=:updatedDate where pvuEmployeForgoEntity.id = :id")
	void updateStatusIdForPVUEmployeForgoEntity(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	PVUEmployeForgoEntity findByTrnNo(@Param("trnNo") String trnNo);

}
