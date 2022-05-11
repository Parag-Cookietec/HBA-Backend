package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolMoneyIntransitEntity;

public interface TdoiDbPolMoneyIntransitRepository extends JpaRepository<TdoiDbPolMoneyIntransitEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPolMoneyIntransitEntity> {
	@Query("select entity from TdoiDbPolMoneyIntransitEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolMoneyIntransitEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolMoneyIntransitEntity entity SET entity.activeStatus = 0 where entity.polMoneyIntransId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolMoneyIntransitEntity entity where entity.activeStatus = 1 and entity.polMoneyIntransId = :id")
	List<TdoiDbPolMoneyIntransitEntity> findAllActiveById(@Param("id") Long id);
}
