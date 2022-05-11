package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaClaimLossDtlEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaClaimLossDtlRepository
		extends JpaRepository<TdoiHbaClaimLossDtlEntity, Long>, JpaSpecificationExecutor<TdoiHbaClaimLossDtlEntity> {
	@Query("select entity from TdoiHbaClaimLossDtlEntity entity where entity.activeStatus = 1")
	List<TdoiHbaClaimLossDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaClaimLossDtlEntity entity SET entity.activeStatus = 0 where entity.lossDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaClaimLossDtlEntity entity where entity.activeStatus = 1 and entity.lossDtlId = :id")
	List<TdoiHbaClaimLossDtlEntity> findAllActiveById(@Param("id") Long id);
}
