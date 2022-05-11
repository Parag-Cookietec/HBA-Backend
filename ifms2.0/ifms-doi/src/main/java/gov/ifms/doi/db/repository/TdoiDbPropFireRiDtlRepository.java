package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropFireRiDtlEntity;

public interface TdoiDbPropFireRiDtlRepository
		extends JpaRepository<TdoiDbPropFireRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPropFireRiDtlEntity> {
	@Query("select entity from TdoiDbPropFireRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropFireRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropFireRiDtlEntity entity SET entity.activeStatus = 0 where entity.fireRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropFireRiDtlEntity entity where entity.activeStatus = 1 and entity.fireRiDtlId = :id")
	List<TdoiDbPropFireRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
