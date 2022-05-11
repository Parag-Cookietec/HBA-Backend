package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolFirePerilEntity;

public interface TdoiDbPolFirePerilRepository
		extends JpaRepository<TdoiDbPolFirePerilEntity, Long>, JpaSpecificationExecutor<TdoiDbPolFirePerilEntity> {
	@Query("select entity from TdoiDbPolFirePerilEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolFirePerilEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolFirePerilEntity entity SET entity.activeStatus = 0 where entity.polFirePerilId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolFirePerilEntity entity where entity.activeStatus = 1 and entity.polFirePerilId = :id")
	List<TdoiDbPolFirePerilEntity> findAllActiveById(@Param("id") Long id);
}
