package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolElecWfEntity;

public interface TdoiDbPolElecWfRepository
		extends JpaRepository<TdoiDbPolElecWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPolElecWfEntity> {
	@Query("select entity from TdoiDbPolElecWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolElecWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolElecWfEntity entity SET entity.activeStatus = 0 where entity.dbPolElecWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolElecWfEntity entity where entity.activeStatus = 1 and entity.dbPolElecWfId = :id")
	List<TdoiDbPolElecWfEntity> findAllActiveById(@Param("id") Long id);
}
