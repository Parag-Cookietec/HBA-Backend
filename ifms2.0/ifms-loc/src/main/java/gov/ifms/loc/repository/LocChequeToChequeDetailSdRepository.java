package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeToChequeDetailSdEntity;

/**
 * The Class LocChequeToChequeDetailSdController.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:21:51
 */

@Repository
@Transactional
public interface LocChequeToChequeDetailSdRepository extends JpaRepository<LocChequeToChequeDetailSdEntity, Long>,
		JpaSpecificationExecutor<LocChequeToChequeDetailSdEntity> {

	/**
	 * Find by id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the loc cheque to cheque detail sd entity
	 */
	LocChequeToChequeDetailSdEntity findByIdAndActiveStatus(Long id, int activeStatus);
}
