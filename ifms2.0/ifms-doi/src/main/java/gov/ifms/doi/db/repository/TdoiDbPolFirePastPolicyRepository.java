package gov.ifms.doi.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.doi.db.entity.TdoiDbPolFirePastPolicyEntity;
import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;


@Transactional
@Repository
public interface TdoiDbPolFirePastPolicyRepository extends JpaRepository<TdoiDbPolFirePastPolicyEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPolFirePastPolicyEntity> {
	@Query("select entity from TdoiDbPolFirePastPolicyEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolFirePastPolicyEntity> findAllByStatus();
	
	TdoiDbPolFirePastPolicyEntity findBypastPolicyId(long pastPolicyId);
	
	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolFirePastPolicyEntity entity SET entity.activeStatus = 0 where entity.pastPolicyId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolFirePastPolicyEntity entity where entity.activeStatus = 1 and entity.pastPolicyId = :id")
	List<TdoiDbPolFirePastPolicyEntity> findAllActiveById(@Param("id") Long id);
}
