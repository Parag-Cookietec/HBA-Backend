package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolFireSumInsuredEntity;

public interface TdoiDbPolFireSumInsuredRepository extends JpaRepository<TdoiDbPolFireSumInsuredEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPolFireSumInsuredEntity> {
	@Query("select entity from TdoiDbPolFireSumInsuredEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolFireSumInsuredEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolFireSumInsuredEntity entity SET entity.activeStatus = 0 where entity.sumInsuredId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolFireSumInsuredEntity entity where entity.activeStatus = 1 and entity.sumInsuredId = :id")
	List<TdoiDbPolFireSumInsuredEntity> findAllActiveById(@Param("id") Long id);
}
