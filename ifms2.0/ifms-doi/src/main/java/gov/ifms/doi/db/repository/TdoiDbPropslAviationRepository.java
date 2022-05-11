package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslAviationEntity;

public interface TdoiDbPropslAviationRepository
		extends JpaRepository<TdoiDbPropslAviationEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslAviationEntity> {
	@Query("select entity from TdoiDbPropslAviationEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslAviationEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslAviationEntity entity SET entity.activeStatus = 0 where entity.propAviationId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslAviationEntity entity where entity.activeStatus = 1 and entity.propAviationId = :id")
	List<TdoiDbPropslAviationEntity> findAllActiveById(@Param("id") Long id);
}
