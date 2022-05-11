package gov.ifms.dmo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.entity.DMODPSTransactionTypeEntity;

@Repository
@Transactional
public interface DMODPSTransactionTypesRepository extends JpaRepository<DMODPSTransactionTypeEntity, Long>,
		JpaSpecificationExecutor<DMODPSTransactionTypeEntity> {

	/**
	 * Find by active status.
	 *
	 * @param activeStatus
	 *            the active status
	 * @return the list
	 */
	List<DMODPSTransactionTypeEntity> findByActiveStatus(int activeStatus);
}
