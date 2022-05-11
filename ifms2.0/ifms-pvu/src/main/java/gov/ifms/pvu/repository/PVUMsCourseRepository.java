package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUMsCourseEntity;

/**
 * The Class PVUMsCourseController.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 */

@Repository
@Transactional
public interface PVUMsCourseRepository
		extends JpaRepository<PVUMsCourseEntity, Long>, JpaSpecificationExecutor<PVUMsCourseEntity> {

	/**
	 * Find by course category look up info id and active status.
	 *
	 * @param lookUpInfoId the look up info id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<PVUMsCourseEntity> findByCourseCategoryLookUpInfoIdAndActiveStatus(long lookUpInfoId, int activeStatus);

}
