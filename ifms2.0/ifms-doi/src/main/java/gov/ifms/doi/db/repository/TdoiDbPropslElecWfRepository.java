package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslElecWfEntity;

public interface TdoiDbPropslElecWfRepository
		extends JpaRepository<TdoiDbPropslElecWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslElecWfEntity> {
	@Query("select entity from TdoiDbPropslElecWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslElecWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslElecWfEntity entity SET entity.activeStatus = 0 where entity.dbPropElecWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslElecWfEntity entity where entity.activeStatus = 1 and entity.dbPropElecWfId = :id")
	List<TdoiDbPropslElecWfEntity> findAllActiveById(@Param("id") Long id);
}
