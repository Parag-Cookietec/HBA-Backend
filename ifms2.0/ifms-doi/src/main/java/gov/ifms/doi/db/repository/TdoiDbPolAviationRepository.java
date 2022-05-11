package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolAviationEntity;

public interface TdoiDbPolAviationRepository
		extends JpaRepository<TdoiDbPolAviationEntity, Long>, JpaSpecificationExecutor<TdoiDbPolAviationEntity> {
	@Query("select entity from TdoiDbPolAviationEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolAviationEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolAviationEntity entity SET entity.activeStatus = 0 where entity.polAviationId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolAviationEntity entity where entity.activeStatus = 1 and entity.polAviationId = :id")
	List<TdoiDbPolAviationEntity> findAllActiveById(@Param("id") Long id);
}
