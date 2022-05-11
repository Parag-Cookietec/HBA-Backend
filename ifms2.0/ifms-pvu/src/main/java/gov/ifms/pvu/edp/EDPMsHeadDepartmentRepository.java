package gov.ifms.pvu.edp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class EDPMsHeadDepartmentController.
 * 
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 */

@Repository
@Transactional
public interface EDPMsHeadDepartmentRepository extends JpaRepository<EDPMsHeadDepartmentEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsHeadDepartmentEntity> {

    List<EDPMsHeadDepartmentEntity> findByDepartmentIdDepartmentId(long id);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
    List<EDPMsHeadDepartmentEntity> findByActiveStatus(int activeStatus);

}
