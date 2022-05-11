package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaOthrCompClaimEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaOthrCompClaimRepository
		extends JpaRepository<TdoiHbaOthrCompClaimEntity, Long>, JpaSpecificationExecutor<TdoiHbaOthrCompClaimEntity> {
	@Query("select entity from TdoiHbaOthrCompClaimEntity entity where entity.activeStatus = 1")
	List<TdoiHbaOthrCompClaimEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaOthrCompClaimEntity entity SET entity.activeStatus = 0 where entity.othrCompClaimId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaOthrCompClaimEntity entity where entity.activeStatus = 1 and entity.othrCompClaimId = :id")
	List<TdoiHbaOthrCompClaimEntity> findAllActiveById(@Param("id") Long id);
}
