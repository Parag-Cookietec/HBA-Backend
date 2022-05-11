package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaClaimWfEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaClaimWfRepository
		extends JpaRepository<TdoiHbaClaimWfEntity, Long>, JpaSpecificationExecutor<TdoiHbaClaimWfEntity> {
	@Query("select entity from TdoiHbaClaimWfEntity entity where entity.activeStatus = 1")
	List<TdoiHbaClaimWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaClaimWfEntity entity SET entity.activeStatus = 0 where entity.hbaClaimWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaClaimWfEntity entity where entity.activeStatus = 1 and entity.hbaClaimWfId = :id")
	List<TdoiHbaClaimWfEntity> findAllActiveById(@Param("id") Long id);
}
