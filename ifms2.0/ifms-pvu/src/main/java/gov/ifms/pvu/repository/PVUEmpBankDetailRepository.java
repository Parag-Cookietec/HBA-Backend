package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
/**
 * The Class PVUEmpBankDetailController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 */

@Repository
@Transactional
public interface PVUEmpBankDetailRepository extends JpaRepository<PVUEmpBankDetailEntity,Long> , 
                  JpaSpecificationExecutor<PVUEmpBankDetailEntity> {

	/**
	 * Find one by pvu employe entity emp id and active status.
	 *
	 * @param empId the emp id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<PVUEmpBankDetailEntity> findOneByPvuEmployeEntityEmpIdAndActiveStatus(Long empId,
			int activeStatus);

	/**
	 * Find one by pvu employe entity emp id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<PVUEmpBankDetailEntity> findOneByPvuEmployeEntityEmpId(Long id);
}
