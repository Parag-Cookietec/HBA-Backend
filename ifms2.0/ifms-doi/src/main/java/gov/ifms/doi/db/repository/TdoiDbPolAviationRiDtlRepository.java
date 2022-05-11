package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolAviationRiDtlEntity;

public interface TdoiDbPolAviationRiDtlRepository extends JpaRepository<TdoiDbPolAviationRiDtlEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPolAviationRiDtlEntity> {
	@Query("select entity from TdoiDbPolAviationRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolAviationRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolAviationRiDtlEntity entity SET entity.activeStatus = 0 where entity.polAviatRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolAviationRiDtlEntity entity where entity.activeStatus = 1 and entity.polAviatRiDtlId = :id")
	List<TdoiDbPolAviationRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
