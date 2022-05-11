package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimQueryEntity;

public interface TdoiDbClaimQueryRepository
		extends JpaRepository<TdoiDbClaimQueryEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimQueryEntity> {
	@Query("select entity from TdoiDbClaimQueryEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimQueryEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbClaimQueryEntity entity SET entity.activeStatus = 0 where entity.dbClaimQueryId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimQueryEntity entity where entity.activeStatus = 1 and entity.dbClaimQueryId = :id")
	List<TdoiDbClaimQueryEntity> findAllActiveById(@Param("id") Long id);
}
