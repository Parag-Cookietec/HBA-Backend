package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropMitInsuranceEntity;

public interface TdoiDbPropMitInsuranceRepository extends JpaRepository<TdoiDbPropMitInsuranceEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropMitInsuranceEntity> {
	@Query("select entity from TdoiDbPropMitInsuranceEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropMitInsuranceEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropMitInsuranceEntity entity SET entity.activeStatus = 0 where entity.propMitInsuranceId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropMitInsuranceEntity entity where entity.activeStatus = 1 and entity.propMitInsuranceId = :id")
	List<TdoiDbPropMitInsuranceEntity> findAllActiveById(@Param("id") Long id);
}
