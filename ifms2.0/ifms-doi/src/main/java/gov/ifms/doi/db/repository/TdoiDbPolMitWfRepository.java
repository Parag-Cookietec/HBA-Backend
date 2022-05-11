package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolMitWfEntity;

public interface TdoiDbPolMitWfRepository
		extends JpaRepository<TdoiDbPolMitWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPolMitWfEntity> {
	@Query("select entity from TdoiDbPolMitWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolMitWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolMitWfEntity entity SET entity.activeStatus = 0 where entity.dbPolMitWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolMitWfEntity entity where entity.activeStatus = 1 and entity.dbPolMitWfId = :id")
	List<TdoiDbPolMitWfEntity> findAllActiveById(@Param("id") Long id);
}
