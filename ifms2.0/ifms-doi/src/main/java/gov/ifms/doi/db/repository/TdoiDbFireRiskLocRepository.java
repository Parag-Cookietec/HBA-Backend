package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbFireRiskLocEntity;

public interface TdoiDbFireRiskLocRepository
		extends JpaRepository<TdoiDbFireRiskLocEntity, Long>, JpaSpecificationExecutor<TdoiDbFireRiskLocEntity> {
	@Query("select entity from TdoiDbFireRiskLocEntity entity where entity.activeStatus = 1")
	List<TdoiDbFireRiskLocEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbFireRiskLocEntity entity SET entity.activeStatus = 0 where entity.fireRiskLocId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbFireRiskLocEntity entity where entity.activeStatus = 1 and entity.fireRiskLocId = :id")
	List<TdoiDbFireRiskLocEntity> findAllActiveById(@Param("id") Long id);
}
