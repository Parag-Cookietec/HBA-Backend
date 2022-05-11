package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslPolicyEntity;

public interface TdoiDbPropslPolicyRepository
		extends JpaRepository<TdoiDbPropslPolicyEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslPolicyEntity> {
	@Query("select entity from TdoiDbPropslPolicyEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslPolicyEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslPolicyEntity entity SET entity.activeStatus = 0 where entity.propslPoliciesId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslPolicyEntity entity where entity.activeStatus = 1 and entity.propslPoliciesId = :id")
	List<TdoiDbPropslPolicyEntity> findAllActiveById(@Param("id") Long id);
}
