package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAdviceDeductionSdEntity;

/**
 * The Class locLocAdvicedeductionSdController.
 * 
 * @version v 1.0
 * @created 2021/02/23 16:58:33
 */

@Repository
@Transactional
public interface LocAdviceDeductionSdRepository
		extends JpaRepository<LocAdviceDeductionSdEntity, Long>, JpaSpecificationExecutor<LocAdviceDeductionSdEntity> {

	/**
	 * Find by lc advice id and active status.
	 *
	 * @param hrdId        the hrd id
	 * @param activeStatus the active status
	 * @return the loc advice deduction sd entity
	 */
	LocAdviceDeductionSdEntity findByLcAdviceIdAndActiveStatus(Long hrdId, int activeStatus);

}
