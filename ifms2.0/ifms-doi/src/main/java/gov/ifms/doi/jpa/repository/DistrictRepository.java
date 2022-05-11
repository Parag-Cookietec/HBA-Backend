package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.DistrictEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from DistrictEntity entity where entity.activeStatus = 1")
	List<DistrictEntity> getDistrictList();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from DistrictEntity entity where entity.activeStatus = 1 and entity.stateId= :stateId")
	List<DistrictEntity> getDistrictByStateId(@Param("stateId") Long stateId);

}
