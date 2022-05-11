package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimRiDtlEntity;

public interface TdoiDbClaimRiDtlRepository
		extends JpaRepository<TdoiDbClaimRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimRiDtlEntity> {
	@Query("select entity from TdoiDbClaimRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbClaimRiDtlEntity entity SET entity.activeStatus = 0 where entity.claimRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimRiDtlEntity entity where entity.activeStatus = 1 and entity.claimRiDtlId = :id")
	List<TdoiDbClaimRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
