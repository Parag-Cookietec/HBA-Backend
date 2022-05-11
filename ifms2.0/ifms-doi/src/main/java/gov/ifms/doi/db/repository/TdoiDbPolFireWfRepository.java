package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolFireWfEntity;

public interface TdoiDbPolFireWfRepository
		extends JpaRepository<TdoiDbPolFireWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPolFireWfEntity> {
	@Query("select entity from TdoiDbPolFireWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolFireWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolFireWfEntity entity SET entity.activeStatus = 0 where entity.dbPolFireWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolFireWfEntity entity where entity.activeStatus = 1 and entity.dbPolFireWfId = :id")
	List<TdoiDbPolFireWfEntity> findAllActiveById(@Param("id") Long id);
}
