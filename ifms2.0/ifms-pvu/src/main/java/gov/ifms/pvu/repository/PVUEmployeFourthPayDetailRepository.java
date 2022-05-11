package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;

/**
 * The Class PVUEmployeFourthPayDetailEntityController.
 *
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 */

@Repository
@Transactional
public interface PVUEmployeFourthPayDetailRepository extends JpaRepository<PVUEmployeFourthPayDetailEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeFourthPayDetailEntity> {

	/**
	 * Find PVU employe fourth pay detail entity bypvu employe entity emp id.
	 *
	 * @param empId the emp id
	 * @return the optional
	 */
	Optional<PVUEmployeFourthPayDetailEntity> findPVUEmployeFourthPayDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long empId,int activeStatus);

}
