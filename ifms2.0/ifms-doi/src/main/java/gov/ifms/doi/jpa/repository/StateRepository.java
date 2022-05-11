package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.StateEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface StateRepository extends JpaRepository<StateEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from StateEntity entity where entity.activeStatus = 1")
	List<StateEntity> findAllActive();
	
	List<StateEntity> findByStateName(@Param("stateName") String stateName);
}
