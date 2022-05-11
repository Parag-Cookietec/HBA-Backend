package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeBookWfEntity;

/**
 * The Interface LocChequeBookWfRepository.
 */
@Repository
@Transactional
public interface LocChequeBookWfRepository extends JpaRepository<LocChequeBookWfEntity, Long>,
		JpaSpecificationExecutor<LocChequeBookWfEntity>, GenericDao {

	/**
	 * Find by trn id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the loc cheque book wf entity
	 */
	LocChequeBookWfEntity findByTrnIdAndActiveStatus(Long id, int activeStatus);

}
