package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcChallanRegisterEntity;

public interface TdoiAcChallanRegisterRepository extends JpaRepository<TdoiAcChallanRegisterEntity, Long>,
		JpaSpecificationExecutor<TdoiAcChallanRegisterEntity> {
	@Query("select entity from TdoiAcChallanRegisterEntity entity where entity.activeStatus = 1")
	List<TdoiAcChallanRegisterEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcChallanRegisterEntity entity SET entity.activeStatus = 0 where entity.challanRegId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcChallanRegisterEntity entity where entity.activeStatus = 1 and entity.challanRegId = :id")
	List<TdoiAcChallanRegisterEntity> findAllActiveById(@Param("id") Long id);
}
