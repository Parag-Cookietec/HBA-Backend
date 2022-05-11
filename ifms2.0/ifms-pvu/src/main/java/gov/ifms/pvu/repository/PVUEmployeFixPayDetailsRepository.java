package gov.ifms.pvu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;

/**
 * The Class PVUEmployeFixPayDetailsController.
 * 
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 */

@Repository
@Transactional
public interface PVUEmployeFixPayDetailsRepository extends JpaRepository<PVUEmployeFixPayDetailsEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeFixPayDetailsEntity> {

	/**
	 * Find one by emp id emp id.
	 *
	 * @param empId the emp id
	 * @return the PVU employe fix pay details entity
	 */
	Optional<PVUEmployeFixPayDetailsEntity> findOneByEmpIdEmpId(long empId);
	List<PVUEmployeFixPayDetailsEntity> findByEmpIdEmpId(long empId);

}
