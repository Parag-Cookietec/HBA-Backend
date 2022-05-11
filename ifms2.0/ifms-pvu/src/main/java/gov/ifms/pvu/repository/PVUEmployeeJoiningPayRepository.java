package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;

/**
 * The Class PVUEmployeeJoiningPayController.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 */

@Repository
@Transactional
public interface PVUEmployeeJoiningPayRepository extends JpaRepository<PVUEmployeeJoiningPayEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeeJoiningPayEntity> {

	/**
	 * Find one by pvu employe entity emp id.
	 *
	 * @param empId the emp id
	 * @return the optional
	 */
	Optional<PVUEmployeeJoiningPayEntity> findOneByPvuEmployeEntityEmpId(Long empId);

}
