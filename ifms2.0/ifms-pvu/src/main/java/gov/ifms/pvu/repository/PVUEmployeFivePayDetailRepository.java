package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;

/**
 * The Class PVUEmployeFivePayDetailEntityController.
 *
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 */

@Repository
@Transactional
public interface PVUEmployeFivePayDetailRepository extends JpaRepository<PVUEmployeFivePayDetailEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeFivePayDetailEntity> {

	/**
	 * Find one by pvu employe entity emp id.
	 *
	 * @param empId the emp id
	 * @return the optional
	 */
	Optional<PVUEmployeFivePayDetailEntity> findOneByPvuEmployeEntityEmpIdAndActiveStatus(long empId,int activeStatus);

	/**
	 * Find one by pay scale pay scale id and pvu employe entity emp id.
	 *
	 * @param payScale the pay scale
	 * @param empid    the empid
	 * @return the PVU employe five pay detail entity
	 */
	PVUEmployeFivePayDetailEntity findOneByPayScalePayScaleIdAndPvuEmployeEntityEmpId(Long payScale, long empid);
	
	PVUEmployeFivePayDetailEntity findFirstByPvuEmployeEntityEmpId(Long id);
}
