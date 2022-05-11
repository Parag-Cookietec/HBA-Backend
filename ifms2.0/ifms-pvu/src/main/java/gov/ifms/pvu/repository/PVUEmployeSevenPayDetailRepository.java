package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;

/**
 * The Class PVUEmploye7PayDetailController.
 *
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 */

@Repository
@Transactional
public interface PVUEmployeSevenPayDetailRepository extends JpaRepository<PVUEmployeSevenPayDetailEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeSevenPayDetailEntity> {

	/**
	 * Find one by pvu employe entity emp id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<PVUEmployeSevenPayDetailEntity> findOneByPvuEmployeEntityEmpIdAndActiveStatus(Long id,int activeStatus);

	 PVUEmployeSevenPayDetailEntity findFirstByPvuEmployeEntityEmpId(Long id);
	 
	 Optional<PVUEmployeSevenPayDetailEntity> findByPvuEmployeEntity(PVUEmployeEntity employeeEntity);
}
