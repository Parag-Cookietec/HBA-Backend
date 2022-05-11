package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolAviationWfEntity;

public interface TdoiDbPolAviationWfRepository
		extends JpaRepository<TdoiDbPolAviationWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPolAviationWfEntity> {
	@Query("select entity from TdoiDbPolAviationWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolAviationWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolAviationWfEntity entity SET entity.activeStatus = 0 where entity.dbPolAviationWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolAviationWfEntity entity where entity.activeStatus = 1 and entity.dbPolAviationWfId = :id")
	List<TdoiDbPolAviationWfEntity> findAllActiveById(@Param("id") Long id);
}
