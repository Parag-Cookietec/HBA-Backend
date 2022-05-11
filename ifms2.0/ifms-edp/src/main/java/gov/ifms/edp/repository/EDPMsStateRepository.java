package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsStateEntity;

/**
 * The Interface EDPMsStateRepository.
 */
@Repository
@Transactional
public interface EDPMsStateRepository
        extends JpaRepository<EDPMsStateEntity, Long>, JpaSpecificationExecutor<EDPMsStateEntity> {

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsStateEntity> findByActiveStatus(int activeStatus);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param jpaSort the jpa sort
	 * @return the list
	 */
	List<EDPMsStateEntity> findByActiveStatus(int activeStatus, Sort jpaSort);

}
