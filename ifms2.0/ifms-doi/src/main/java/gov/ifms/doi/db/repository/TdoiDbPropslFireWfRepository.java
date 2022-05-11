package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslFireWfEntity;

public interface TdoiDbPropslFireWfRepository
		extends JpaRepository<TdoiDbPropslFireWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslFireWfEntity> {
	@Query("select entity from TdoiDbPropslFireWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslFireWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslFireWfEntity entity SET entity.activeStatus = 0 where entity.dbPropFireWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslFireWfEntity entity where entity.activeStatus = 1 and entity.dbPropFireWfId = :id")
	List<TdoiDbPropslFireWfEntity> findAllActiveById(@Param("id") Long id);
}
