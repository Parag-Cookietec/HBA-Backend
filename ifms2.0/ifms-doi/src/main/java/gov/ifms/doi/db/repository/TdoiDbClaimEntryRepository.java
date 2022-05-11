package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimEntryEntity;

public interface TdoiDbClaimEntryRepository
		extends JpaRepository<TdoiDbClaimEntryEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimEntryEntity> {
	@Query("select entity from TdoiDbClaimEntryEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimEntryEntity> findAllByStatus();


	@Query("update TdoiDbClaimEntryEntity entity SET entity.activeStatus=0 where entity.dbClaimId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimEntryEntity entity where entity.activeStatus = 1 and entity.dbClaimId = :id")
	List<TdoiDbClaimEntryEntity> findAllActiveById(@Param("id") Long id);
}
