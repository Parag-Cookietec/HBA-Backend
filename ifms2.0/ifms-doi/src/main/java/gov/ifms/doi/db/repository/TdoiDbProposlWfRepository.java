package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbProposlWfEntity;

public interface TdoiDbProposlWfRepository
		extends JpaRepository<TdoiDbProposlWfEntity, Long>, JpaSpecificationExecutor<TdoiDbProposlWfEntity> {
	@Query("select entity from TdoiDbProposlWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbProposlWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbProposlWfEntity entity SET entity.activeStatus = 0 where entity.dbProposlWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbProposlWfEntity entity where entity.activeStatus = 1 and entity.dbProposlWfId = :id")
	List<TdoiDbProposlWfEntity> findAllActiveById(@Param("id") Long id);
}
