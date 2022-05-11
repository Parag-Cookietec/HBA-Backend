package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaClaimEntryEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaClaimEntryRepository
		extends JpaRepository<TdoiHbaClaimEntryEntity, Long>, JpaSpecificationExecutor<TdoiHbaClaimEntryEntity> {
	@Query("select entity from TdoiHbaClaimEntryEntity entity where entity.activeStatus = 1")
	List<TdoiHbaClaimEntryEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaClaimEntryEntity entity SET entity.activeStatus = 0 where entity.hbaClaimId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaClaimEntryEntity entity where entity.activeStatus = 1 and entity.hbaClaimId = :id")
	List<TdoiHbaClaimEntryEntity> findAllActiveById(@Param("id") Long id);
}
