package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcDeadStockRegisterEntity;

public interface TdoiAcDeadStockRegisterRepository extends JpaRepository<TdoiAcDeadStockRegisterEntity, Long>,
		JpaSpecificationExecutor<TdoiAcDeadStockRegisterEntity> {
	@Query("select entity from TdoiAcDeadStockRegisterEntity entity where entity.activeStatus = 1")
	List<TdoiAcDeadStockRegisterEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcDeadStockRegisterEntity entity SET entity.activeStatus = 0 where entity.deadStkRegId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcDeadStockRegisterEntity entity where entity.activeStatus = 1 and entity.deadStkRegId = :id")
	List<TdoiAcDeadStockRegisterEntity> findAllActiveById(@Param("id") Long id);
}
