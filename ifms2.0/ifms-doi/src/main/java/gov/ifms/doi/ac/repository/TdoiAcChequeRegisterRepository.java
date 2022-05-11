package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcChequeRegisterEntity;

public interface TdoiAcChequeRegisterRepository
		extends JpaRepository<TdoiAcChequeRegisterEntity, Long>, JpaSpecificationExecutor<TdoiAcChequeRegisterEntity> {
	@Query("select entity from TdoiAcChequeRegisterEntity entity where entity.activeStatus = 1")
	List<TdoiAcChequeRegisterEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcChequeRegisterEntity entity SET entity.activeStatus = 0 where entity.chequeRegId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcChequeRegisterEntity entity where entity.activeStatus = 1 and entity.chequeRegId = :id")
	List<TdoiAcChequeRegisterEntity> findAllActiveById(@Param("id") Long id);
}
