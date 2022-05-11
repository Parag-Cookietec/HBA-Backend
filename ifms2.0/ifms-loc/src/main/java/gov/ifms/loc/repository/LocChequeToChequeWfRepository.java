package gov.ifms.loc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeToChequeWfEntity;

/**
 * The Interface LocChequeToChequeWfRepository.
 */
@Repository
@Transactional
public interface LocChequeToChequeWfRepository extends JpaRepository<LocChequeToChequeWfEntity, Long>,
		JpaSpecificationExecutor<LocChequeToChequeWfEntity>, GenericDao {

	/**
	 * Find by id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the loc cheque to cheque wf entity
	 */
	LocChequeToChequeWfEntity findByIdAndActiveStatus(Long id, int activeStatus);

}
