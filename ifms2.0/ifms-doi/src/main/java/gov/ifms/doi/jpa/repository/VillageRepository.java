package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.VillageEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface VillageRepository extends JpaRepository<VillageEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from VillageEntity entity where entity.activeStatus = 1 and entity.talukaId= :talukaId")
	List<VillageEntity> getVillageListByTalukaId(@Param("talukaId") Long talukaId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from VillageEntity entity where entity.activeStatus = 1")
	List<VillageEntity> getAllActiveVillages();

}
