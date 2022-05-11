package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslBurglaryWfEntity;

public interface TdoiDbPropslBurglaryWfRepository extends JpaRepository<TdoiDbPropslBurglaryWfEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropslBurglaryWfEntity> {
	@Query("select entity from TdoiDbPropslBurglaryWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslBurglaryWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslBurglaryWfEntity entity SET entity.activeStatus = 0 where entity.dbPropslBurglWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslBurglaryWfEntity entity where entity.activeStatus = 1 and entity.dbPropslBurglWfId = :id")
	List<TdoiDbPropslBurglaryWfEntity> findAllActiveById(@Param("id") Long id);
}
