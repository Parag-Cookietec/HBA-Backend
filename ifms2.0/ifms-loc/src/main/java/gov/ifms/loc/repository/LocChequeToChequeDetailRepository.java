package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeToChequeDetailEntity;

/**
 * The Class LocChequeToChequeDetailController.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:16:18
 */

@Repository
@Transactional
public interface LocChequeToChequeDetailRepository extends JpaRepository<LocChequeToChequeDetailEntity, Long>,
		JpaSpecificationExecutor<LocChequeToChequeDetailEntity> {

}
