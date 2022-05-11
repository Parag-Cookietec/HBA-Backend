package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropMitWfEntity;

public interface TdoiDbPropMitWfRepository
		extends JpaRepository<TdoiDbPropMitWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPropMitWfEntity> {
	@Query("select entity from TdoiDbPropMitWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropMitWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropMitWfEntity entity SET entity.activeStatus = 0 where entity.dbPropMitWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropMitWfEntity entity where entity.activeStatus = 1 and entity.dbPropMitWfId = :id")
	List<TdoiDbPropMitWfEntity> findAllActiveById(@Param("id") Long id);
}
