package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcChallanDtlEntity;

public interface TdoiAcChallanDtlRepository
		extends JpaRepository<TdoiAcChallanDtlEntity, Long>, JpaSpecificationExecutor<TdoiAcChallanDtlEntity> {
	@Query("select entity from TdoiAcChallanDtlEntity entity where entity.activeStatus = 1")
	List<TdoiAcChallanDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcChallanDtlEntity entity SET entity.activeStatus = 0 where entity.challanDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcChallanDtlEntity entity where entity.activeStatus = 1 and entity.challanDtlId = :id")
	List<TdoiAcChallanDtlEntity> findAllActiveById(@Param("id") Long id);
}
