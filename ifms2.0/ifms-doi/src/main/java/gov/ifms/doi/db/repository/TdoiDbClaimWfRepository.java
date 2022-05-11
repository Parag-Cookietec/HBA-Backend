package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimWfEntity;

public interface TdoiDbClaimWfRepository
		extends JpaRepository<TdoiDbClaimWfEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimWfEntity> {
	@Query("select entity from TdoiDbClaimWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbClaimWfEntity entity SET entity.activeStatus = 0 where entity.dbClaimWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimWfEntity entity where entity.activeStatus = 1 and entity.dbClaimWfId = :id")
	List<TdoiDbClaimWfEntity> findAllActiveById(@Param("id") Long id);
}
