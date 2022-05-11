package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimPropDtlEntity;

public interface TdoiDbClaimPropDtlRepository
		extends JpaRepository<TdoiDbClaimPropDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimPropDtlEntity> {
	@Query("select entity from TdoiDbClaimPropDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimPropDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbClaimPropDtlEntity entity SET entity.activeStatus = 0 where entity.propDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimPropDtlEntity entity where entity.activeStatus = 1 and entity.propDtlId = :id")
	List<TdoiDbClaimPropDtlEntity> findAllActiveById(@Param("id") Long id);
}
