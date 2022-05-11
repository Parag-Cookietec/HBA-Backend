package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslAviationWfEntity;

public interface TdoiDbPropslAviationWfRepository extends JpaRepository<TdoiDbPropslAviationWfEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropslAviationWfEntity> {
	@Query("select entity from TdoiDbPropslAviationWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslAviationWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslAviationWfEntity entity SET entity.activeStatus = 0 where entity.dbPropslAviationWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslAviationWfEntity entity where entity.activeStatus = 1 and entity.dbPropslAviationWfId = :id")
	List<TdoiDbPropslAviationWfEntity> findAllActiveById(@Param("id") Long id);
}
