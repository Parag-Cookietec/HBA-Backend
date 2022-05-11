package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolicyListEntity;

public interface TdoiDbPolicyListRepository
		extends JpaRepository<TdoiDbPolicyListEntity, Long>, JpaSpecificationExecutor<TdoiDbPolicyListEntity> {
	@Query("select entity from TdoiDbPolicyListEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolicyListEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolicyListEntity entity SET entity.activeStatus = 0 where entity.dbPolicyLstId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolicyListEntity entity where entity.activeStatus = 1 and entity.dbPolicyLstId = :id")
	List<TdoiDbPolicyListEntity> findAllActiveById(@Param("id") Long id);
}
