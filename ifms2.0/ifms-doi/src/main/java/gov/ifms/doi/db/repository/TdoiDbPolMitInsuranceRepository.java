package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolMitInsuranceEntity;

public interface TdoiDbPolMitInsuranceRepository extends JpaRepository<TdoiDbPolMitInsuranceEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPolMitInsuranceEntity> {
	@Query("select entity from TdoiDbPolMitInsuranceEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolMitInsuranceEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolMitInsuranceEntity entity SET entity.activeStatus = 0 where entity.polMitInsuranceId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolMitInsuranceEntity entity where entity.activeStatus = 1 and entity.polMitInsuranceId = :id")
	List<TdoiDbPolMitInsuranceEntity> findAllActiveById(@Param("id") Long id);
}
