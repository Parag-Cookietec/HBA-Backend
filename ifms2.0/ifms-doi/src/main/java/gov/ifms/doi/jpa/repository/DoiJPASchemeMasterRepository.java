package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.doi.jpa.entity.DoiJPASchemeMaster;

/**
 * 
 * @author Sagar Patil
 *
 */
@Repository
public interface DoiJPASchemeMasterRepository extends JpaRepository<DoiJPASchemeMaster, Long >, JpaSpecificationExecutor<DoiJPASchemeMaster> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update DoiJPASchemeMaster entity SET entity.activeStatus = 0, entity.status = 0 where entity.schemeId = :schemeId")
	void softDeleteBySchemeId(@Param("schemeId") Long schemeId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update DoiJPASchemeMaster entity SET entity.status = :schemeStatus where entity.schemeId = :schemeId")
	int updateSchemeStatusBySchemeId(@Param("schemeId") Long schemeId,
			@Param("schemeStatus") String schemeStatus);

	@Query("select entity from DoiJPASchemeMaster entity where entity.activeStatus = 1")
	List<DoiJPASchemeMaster> findAllByStatus();
	
	@Query("select entity from DoiJPASchemeMaster entity where entity.status = 1")
	List<DoiJPASchemeMaster> findAllByStatusAsActive();
	
	@Query("select entity from DoiJPASchemeMaster entity where entity.activeStatus = 1 and status=1")
	List<DoiJPASchemeMaster> findAllActive();
	
}
