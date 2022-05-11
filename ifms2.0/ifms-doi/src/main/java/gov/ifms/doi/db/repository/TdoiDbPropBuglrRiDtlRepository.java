package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropBuglrRiDtlEntity;

public interface TdoiDbPropBuglrRiDtlRepository
		extends JpaRepository<TdoiDbPropBuglrRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPropBuglrRiDtlEntity> {
	@Query("select entity from TdoiDbPropBuglrRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropBuglrRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropBuglrRiDtlEntity entity SET entity.activeStatus = 0 where entity.buglrRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropBuglrRiDtlEntity entity where entity.activeStatus = 1 and entity.buglrRiDtlId = :id")
	List<TdoiDbPropBuglrRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
