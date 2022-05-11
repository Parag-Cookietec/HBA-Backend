package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslFirePerilEntity;

public interface TdoiDbPropslFirePerilRepository extends JpaRepository<TdoiDbPropslFirePerilEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropslFirePerilEntity> {
	@Query("select entity from TdoiDbPropslFirePerilEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslFirePerilEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslFirePerilEntity entity SET entity.activeStatus = 0 where entity.firePerilId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslFirePerilEntity entity where entity.activeStatus = 1 and entity.firePerilId = :id")
	List<TdoiDbPropslFirePerilEntity> findAllActiveById(@Param("id") Long id);
}
