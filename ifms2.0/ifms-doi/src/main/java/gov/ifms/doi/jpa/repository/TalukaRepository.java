package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.TalukaEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface TalukaRepository extends JpaRepository<TalukaEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from TalukaEntity entity where entity.activeStatus = 1 and entity.districtId= :districtId")
	List<TalukaEntity> getTalukaListByDistrict(@Param("districtId") Long districtId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from TalukaEntity entity where entity.activeStatus = 1")
	List<TalukaEntity> getAllActive();

}
