package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcTeRecoveryDtlEntity;

public interface TdoiAcTeRecoveryDtlRepository
		extends JpaRepository<TdoiAcTeRecoveryDtlEntity, Long>, JpaSpecificationExecutor<TdoiAcTeRecoveryDtlEntity> {
	@Query("select entity from TdoiAcTeRecoveryDtlEntity entity where entity.activeStatus = 1")
	List<TdoiAcTeRecoveryDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcTeRecoveryDtlEntity entity SET entity.activeStatus = 0 where entity.teRecoveryDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcTeRecoveryDtlEntity entity where entity.activeStatus = 1 and entity.teRecoveryDtlId = :id")
	List<TdoiAcTeRecoveryDtlEntity> findAllActiveById(@Param("id") Long id);
}
