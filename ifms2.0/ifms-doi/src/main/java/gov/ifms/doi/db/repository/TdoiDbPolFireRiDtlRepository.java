package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolFireRiDtlEntity;

public interface TdoiDbPolFireRiDtlRepository
		extends JpaRepository<TdoiDbPolFireRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPolFireRiDtlEntity> {
	@Query("select entity from TdoiDbPolFireRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolFireRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolFireRiDtlEntity entity SET entity.activeStatus = 0 where entity.polFireRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolFireRiDtlEntity entity where entity.activeStatus = 1 and entity.polFireRiDtlId = :id")
	List<TdoiDbPolFireRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
