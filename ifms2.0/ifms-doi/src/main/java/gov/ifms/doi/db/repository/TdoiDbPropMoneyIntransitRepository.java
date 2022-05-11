package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropMoneyIntransitEntity;

public interface TdoiDbPropMoneyIntransitRepository extends JpaRepository<TdoiDbPropMoneyIntransitEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropMoneyIntransitEntity> {
	@Query("select entity from TdoiDbPropMoneyIntransitEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropMoneyIntransitEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropMoneyIntransitEntity entity SET entity.activeStatus = 0 where entity.propMoneyIntransId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropMoneyIntransitEntity entity where entity.activeStatus = 1 and entity.propMoneyIntransId = :id")
	List<TdoiDbPropMoneyIntransitEntity> findAllActiveById(@Param("id") Long id);
}
