package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcStampRegisterEntity;

public interface TdoiAcStampRegisterRepository
		extends JpaRepository<TdoiAcStampRegisterEntity, Long>, JpaSpecificationExecutor<TdoiAcStampRegisterEntity> {
	@Query("select entity from TdoiAcStampRegisterEntity entity where entity.activeStatus = 1")
	List<TdoiAcStampRegisterEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcStampRegisterEntity entity SET entity.activeStatus = 0 where entity.stampRegId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcStampRegisterEntity entity where entity.activeStatus = 1 and entity.stampRegId = :id")
	List<TdoiAcStampRegisterEntity> findAllActiveById(@Param("id") Long id);
}
