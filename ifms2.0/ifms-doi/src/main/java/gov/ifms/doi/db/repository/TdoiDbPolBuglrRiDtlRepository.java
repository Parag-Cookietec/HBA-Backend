package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolBuglrRiDtlEntity;

public interface TdoiDbPolBuglrRiDtlRepository
		extends JpaRepository<TdoiDbPolBuglrRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPolBuglrRiDtlEntity> {
	@Query("select entity from TdoiDbPolBuglrRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolBuglrRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolBuglrRiDtlEntity entity SET entity.activeStatus = 0 where entity.buglrRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolBuglrRiDtlEntity entity where entity.activeStatus = 1 and entity.buglrRiDtlId = :id")
	List<TdoiDbPolBuglrRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
