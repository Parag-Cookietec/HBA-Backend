package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslPolAddonEntity;

public interface TdoiDbPropslPolAddonRepository
		extends JpaRepository<TdoiDbPropslPolAddonEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslPolAddonEntity> {
	@Query("select entity from TdoiDbPropslPolAddonEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslPolAddonEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslPolAddonEntity entity SET entity.activeStatus = 0 where entity.propslPolAddonId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslPolAddonEntity entity where entity.activeStatus = 1 and entity.propslPolAddonId = :id")
	List<TdoiDbPropslPolAddonEntity> findAllActiveById(@Param("id") Long id);
}
