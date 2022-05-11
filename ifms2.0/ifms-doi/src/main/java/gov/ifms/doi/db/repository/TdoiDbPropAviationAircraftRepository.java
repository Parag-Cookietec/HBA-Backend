package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropAviationAircraftEntity;

public interface TdoiDbPropAviationAircraftRepository extends JpaRepository<TdoiDbPropAviationAircraftEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropAviationAircraftEntity> {
	@Query("select entity from TdoiDbPropAviationAircraftEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropAviationAircraftEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropAviationAircraftEntity entity SET entity.activeStatus = 0 where entity.aviatAircrftId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropAviationAircraftEntity entity where entity.activeStatus = 1 and entity.aviatAircrftId = :id")
	List<TdoiDbPropAviationAircraftEntity> findAllActiveById(@Param("id") Long id);
}
