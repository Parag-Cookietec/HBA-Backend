package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbFireBuildingValEntity;

public interface TdoiDbFireBuildingValRepository extends JpaRepository<TdoiDbFireBuildingValEntity, Long>,
		JpaSpecificationExecutor<TdoiDbFireBuildingValEntity> {
	@Query("select entity from TdoiDbFireBuildingValEntity entity where entity.activeStatus = 1")
	List<TdoiDbFireBuildingValEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbFireBuildingValEntity entity SET entity.activeStatus = 0 where entity.buildValId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbFireBuildingValEntity entity where entity.activeStatus = 1 and entity.buildValId = :id")
	List<TdoiDbFireBuildingValEntity> findAllActiveById(@Param("id") Long id);
}
