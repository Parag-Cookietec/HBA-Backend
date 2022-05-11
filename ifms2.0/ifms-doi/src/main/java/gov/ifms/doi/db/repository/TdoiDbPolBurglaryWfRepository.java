package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolBurglaryWfEntity;

public interface TdoiDbPolBurglaryWfRepository
		extends JpaRepository<TdoiDbPolBurglaryWfEntity, Long>, JpaSpecificationExecutor<TdoiDbPolBurglaryWfEntity> {
	@Query("select entity from TdoiDbPolBurglaryWfEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolBurglaryWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolBurglaryWfEntity entity SET entity.activeStatus = 0 where entity.dbPolBurglWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolBurglaryWfEntity entity where entity.activeStatus = 1 and entity.dbPolBurglWfId = :id")
	List<TdoiDbPolBurglaryWfEntity> findAllActiveById(@Param("id") Long id);
}
