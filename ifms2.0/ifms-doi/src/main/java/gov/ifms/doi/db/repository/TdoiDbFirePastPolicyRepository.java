package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbFirePastPolicyEntity;

public interface TdoiDbFirePastPolicyRepository
		extends JpaRepository<TdoiDbFirePastPolicyEntity, Long>, JpaSpecificationExecutor<TdoiDbFirePastPolicyEntity> {
	@Query("select entity from TdoiDbFirePastPolicyEntity entity where entity.activeStatus = 1")
	List<TdoiDbFirePastPolicyEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbFirePastPolicyEntity entity SET entity.activeStatus = 0 where entity.pastPolicyId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbFirePastPolicyEntity entity where entity.activeStatus = 1 and entity.pastPolicyId = :id")
	List<TdoiDbFirePastPolicyEntity> findAllActiveById(@Param("id") Long id);
}
