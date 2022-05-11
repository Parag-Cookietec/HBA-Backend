package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaClaimRejectEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaClaimRejectRepository
		extends JpaRepository<TdoiHbaClaimRejectEntity, Long>, JpaSpecificationExecutor<TdoiHbaClaimRejectEntity> {
	@Query("select entity from TdoiHbaClaimRejectEntity entity where entity.activeStatus = 1")
	List<TdoiHbaClaimRejectEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaClaimRejectEntity entity SET entity.activeStatus = 0 where entity.claimRejectId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaClaimRejectEntity entity where entity.activeStatus = 1 and entity.claimRejectId = :id")
	List<TdoiHbaClaimRejectEntity> findAllActiveById(@Param("id") Long id);
}
