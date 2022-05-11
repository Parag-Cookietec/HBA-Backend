package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropMitRiDtlEntity;

public interface TdoiDbPropMitRiDtlRepository
		extends JpaRepository<TdoiDbPropMitRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPropMitRiDtlEntity> {
	@Query("select entity from TdoiDbPropMitRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropMitRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropMitRiDtlEntity entity SET entity.activeStatus = 0 where entity.propMitRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropMitRiDtlEntity entity where entity.activeStatus = 1 and entity.propMitRiDtlId = :id")
	List<TdoiDbPropMitRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
